import React, { useEffect, useState } from 'react'
import { listProductSale } from '../service/ListProductSaleService'
import { BrowserRouter as Link, NavLink } from "react-router-dom"
import { listProductHot } from '../service/ListProductHotService'
import { listProductDate } from '../service/ListProductDateService'

const ProductsComponent = () => {
   const [productsSale, setProductsSale] = useState([])
   const [productsHot, setProductsHot] = useState([])
   const [productsDate, setProductsDate] = useState([])
   useEffect(() => {
      listProductSale().then((response) => {
         setProductsSale(response.data);
      }).catch(error => {
         console.error(error);
      })

      listProductHot().then((response) => {
         setProductsHot(response.data);
      }).catch(error => {
         console.error(error);
      })

      listProductDate().then((response) => {
         setProductsDate(response.data);
      }).catch(error => {
         console.error(error);
      })
   }, [])

   return (
      <>
         <section className="featured spad">
            <div className="container text-center">
               <div className="row">
                  <div className="col-lg-12">
                     <div className="section-title">
                        <h4>Sản Phẩm Sale</h4>
                     </div>
                  </div>
               </div>
               <div className="row featured__filter">
                  {productsSale.map((productSale) => (
                     <div className="col-lg-3 col-md-4 col-sm-4 product-box" key={productSale.proId}>
                        <div className="featured__item">
                           <div className="featured__item__pic">
                              <NavLink to={`/ProductDetail/${productSale.proId}`}>
                              
                                 <div className="container-zoom">
                                    {productSale.images && productSale.images.length > 0 && (
                                       <img src={`data:image/jpeg;base64,${productSale.images[0].imgData}`} alt="" className="zoom-img" />
                                    )}
                                 </div>
                                 {productSale.proBasisPrice > 0 ?
                                 <span className="badge bg-danger dis">{((productSale.proBasisPrice - productSale.proPrice) / productSale.proBasisPrice * 100).toFixed()}%</span>
                                 :<></>}
                                 {productSale.proHot ? <span className="badge bg-warning hot">Hot</span> : <></>}
                              </NavLink>
                           </div>
                           <div className="featured__item__text">
                              <h6><a href="#">{productSale.proName}</a></h6>
                              <h5>{productSale.proPrice.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' })}
                                 &nbsp;
                                 
                                 <span className="text1"><s>{productSale.proBasisPrice.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' })}</s></span>
                              </h5>
                           </div>
                        </div>
                     </div>
                  ))}
                  <div className="col-lg col-md col-sm">
                     <a href="shop-grid.php?Category=Sale"><button className="btn btn-primary more " type="submit">Xem Thêm Sản Phẩm</button></a>
                  </div>
               </div>
            </div>


         </section>
         <section className="featured spad">
            <div className="container text-center">
               <div className="row">
                  <div className="col-lg-12">
                     <div className="section-title">
                        <h4>Sản Phẩm Mới Nhất</h4>
                     </div>
                  </div>
               </div>
               <div className="row featured__filter">
                  {productsDate.map((productDate) => (
                     <div className="col-lg-3 col-md-4 col-sm-4 product-box" key={productDate.proId}>
                        <div className="featured__item">
                           <div className="featured__item__pic">
                              <a href='shop-details.php?ProID='>
                                 <div className="container-zoom">
                                    {productDate.images && productDate.images.length > 0 && (
                                       <img src={`data:image/jpeg;base64,${productDate.images[0].imgData}`} alt="" className="zoom-img" />
                                    )}
                                 </div>
                                 {productDate.proBasisPrice > 0 ?
                                 <span className="badge bg-danger dis">{((productDate.proBasisPrice - productDate.proPrice) / productDate.proBasisPrice * 100).toFixed()}%</span>
                                 :<></>}                                 
                                 {productDate.proHot ? <span className="badge bg-warning hot">Hot</span> : <span></span>}
                              </a>
                           </div>
                           <div className="featured__item__text">
                              <h6><a href="#">{productDate.proName}</a></h6>
                              <h5>{productDate.proPrice}₫
                                 &nbsp;
                                 <span className="text1"><s>{productDate.proBasisPrice}₫</s></span>
                              </h5>
                           </div>
                        </div>
                     </div>
                  ))}
                  {/* <div className="col-lg col-md col-sm">
                     <a href="shop-grid.php?Category=Sale"><button className="btn btn-primary more " type="submit">Xem Thêm Sản Phẩm</button></a>
                  </div> */}
               </div>
            </div>


         </section>

         <section className="featured spad">
            <div className="container text-center">
               <div className="row">
                  <div className="col-lg-12">
                     <div className="section-title">
                        <h4>Sản Phẩm Hot</h4>
                     </div>
                  </div>
               </div>
               <div className="row featured__filter">
                  {productsHot.map((productHot) => (
                     (productHot.proHot ?
                     <div className="col-lg-3 col-md-4 col-sm-4 product-box" key={productHot.proId}>
                        <div className="featured__item">
                           <div className="featured__item__pic">
                              <a href=''>
                                 <div className="container-zoom">
                                    {productHot.images && productHot.images.length > 0 && (
                                       <img src={`data:image/jpeg;base64,${productHot.images[0].imgData}`} alt="" className="zoom-img" />
                                    )}
                                 </div>
                                 {productHot.proBasisPrice > 0 ?
                                 <span className="badge bg-danger dis">{((productHot.proBasisPrice - productHot.proPrice) / productHot.proBasisPrice * 100).toFixed()}%</span>
                                 :<></>}                                 
                                 {productHot.proHot ? <span className="badge bg-warning hot">Hot</span> : <span></span>}
                              </a>
                           </div>
                           <div className="featured__item__text">
                              <h6><a href="#">{productHot.proName}</a></h6>
                              <h5>{productHot.proPrice}₫
                                 &nbsp;
                                 <span className="text1"><s>{productHot.proBasisPrice}₫</s></span>
                              </h5>
                           </div>
                        </div>
                     </div>
                      : <></>)
                  ))}
                  {/* <div className="col-lg col-md col-sm">
                     <a href="shop-grid.php?Category=Sale"><button className="btn btn-primary more " type="submit">Xem Thêm Sản Phẩm</button></a>
                  </div> */}
               </div>
            </div>


         </section>
      </>
   )
}

export default ProductsComponent