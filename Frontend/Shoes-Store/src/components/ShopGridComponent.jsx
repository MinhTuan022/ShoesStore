import { faListUl } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import React, { useEffect, useState } from 'react'
// import { listProductByCategory } from '../service/ListProductByCategoryService'
import { listBrand } from '../service/ListBrandService'
import axios from 'axios'
import { useParams, NavLink, Link } from 'react-router-dom'
import ReactPaginate from 'react-paginate'
const ShopGridComponent = () => {
   const [products, setProducts] = useState([]);
   const [brands, setBrands] = useState([]);
   const { cateId, braId } = useParams();
   const [selectedBrand, setSelectedBrand] = useState('');
   const [currentPage, setCurrentPage] = useState(1);
   const [totalPages, setTotalPages] = useState(1);
   const size = 8
   const page =1
   const handleCheckboxChange = async (selected) => {
      setSelectedBrand(selected);
      fetchData(cateId, selected, 1); // Trigger re-fetch with the selected brand
   };

   useEffect(() => {
      listBrand()
         .then((response) => {
            setBrands(response.data);
         })
         .catch((error) => {
            console.error(error);
         });

      setSelectedBrand('');
      
      if (braId) {
         fetchData('', braId, 1)
      }
      else {
         fetchData(cateId, '', 1);
      }

   }, [cateId, braId]);


   const fetchData = async (cateId, braId, page) => {
      try {
         let response;

         if (cateId != '' && braId === '') {
            response = await axios.get(`http://localhost:8080/api/products/${cateId}/category?page=${page}&size=${size}`);
         }
         else if (cateId != '' && braId != '') {
            response = await axios.get(`http://localhost:8080/api/products/${cateId}/category/${braId}/brand?page=${page}&size=${size}`);
         }
         else if (cateId === '') {
            response = await axios.get(`http://localhost:8080/api/products/${braId}/brand?page=${page}&size=${size}`);
         }


         setProducts(response.data.content);
         // setCurrentPage(page);
         setTotalPages(response.data.totalPages)
      } catch (error) {
         console.error(error);
      }
   };
   const handlePageClick = (event) => {

      if (selectedBrand !== '') {
         fetchData(cateId, selectedBrand, event.selected+1)
      }
      else if (braId) {
         fetchData('', braId, event.selected + 1)
      }
      else {
         fetchData(cateId, '', event.selected + 1);
      }
   };


   return (
      <>

         <section className="product spad">
            <div className="container">
               <div className="row">
                  <div className="col-lg-3 col-md-5">
                     {cateId &&
                        <div className="sidebar">
                           <div className="sidebar__item">
                              <h4>Thương Hiệu</h4>
                              <ul>
                                 {brands.map((brand) => (
                                    <li key={brand.braId}><input
                                       type="checkbox"
                                       name="brand"
                                       checked={selectedBrand == brand.braId}
                                       onChange={() => handleCheckboxChange(brand.braId)} />
                                       <a key={brand.braId}> {brand.braName}</a>
                                    </li>
                                 ))}

                              </ul>
                           </div>
                           {/* <!-- ----------- Chon Brand khi đã có Cate --------- --> */}

                        </div>
                     }
                  </div>
                  <div className="col-lg-9 col-md-7">

                     <div className="filter__item">
                        <div className="row">
                           <div className="col-lg-4 col-md-5">
                              <div className="filter__sort">
                                 <span>Sắp Xếp</span>
                                 <select>

                                    <option value="">Default</option>
                                    <option value="">Price Thấp - Cao</option>
                                    <option value="">Price Cao - Thấp</option>
                                 </select>
                              </div>
                           </div>
                           <div className="col-lg-4 col-md-4">
                              <div className="filter__found">
                              </div>
                           </div>
                           <div className="col-lg-4 col-md-3">
                              <div className="filter__option">
                                 <span className="icon_ul"><FontAwesomeIcon icon={faListUl} size="2xs" /></span>
                              </div>
                           </div>
                        </div>
                     </div>
                     {/* <!-- --------------- Chọn Kiểu Sắp xếp sản phẩm ------------ -->
<!-- ------------------San Pham--------------- --> */}
                     <div>
                        <div className="row featured__filter">
                           {(products.length > 0) ? products.map((product) => (
                              <div className="col-lg-3 col-md-4 col-sm-6" key={product.proId}>
                                 <div className="featured__item">
                                    <div className="featured__item__pic">
                                       <NavLink to={`/ProductDetail/${product.proId}`}>
                                          <div className="container-zoom">
                                             {product.images && product.images.length > 0 && (
                                                <img src={`data:image/jpeg;base64,${product.images[0].imgData}`} alt="" className="zoom-img" />
                                             )}
                                          </div>
                                          {product.proBasisPrice > 0 ?
                                             <span className="badge bg-danger dis">{((product.proBasisPrice - product.proPrice) / product.proBasisPrice * 100).toFixed()}%</span>
                                             : <></>}
                                          {product.proHot ? <span className="badge bg-warning hot">Hot</span> : <></>}
                                       </NavLink>
                                    </div>


                                    <div className="featured__item__text">
                                       <h6><a href="#">{product.proName}</a></h6>
                                       <h5>{product.proPrice.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' })}
                                          &nbsp;
                                          {product.proBasisPrice > 0 ?
                                             <span className="text1"><s>{product.proBasisPrice.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' })}</s></span>
                                             : <></>}
                                       </h5>
                                    </div>
                                 </div>
                              </div>
                           )) : <p>Không có Sản Phẩm nào</p>}
                        </div>
                     </div>
                     {/* <!-- ------------------San Pham--------------- -->
<!-- ------------------Phan trang--------------- --> */}
                     {products.length > 0 && (
                        <ReactPaginate
                           previousLabel={'<'}
                           nextLabel={'>'}
                           //   breakLabel={<a href="">...</a>}
                           breakClassName={'break-me'}
                           pageCount={totalPages}
                           marginPagesDisplayed={2}
                           pageRangeDisplayed={2}
                           onPageChange={handlePageClick}
                           containerClassName={'pagination'}
                           subContainerClassName={'pages pagination'}
                           
                           activeClassName={'active'}
                        />
                     )}
                     {/* <!-- ------------------Phan trang--------------- --> */}
                  </div>
               </div>
            </div>
         </section >
      </>
   )
}

export default ShopGridComponent