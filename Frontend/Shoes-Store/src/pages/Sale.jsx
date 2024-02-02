import React, { useState, useEffect } from 'react'
import { listProduct } from '../service/ListProductService'
import { NavLink } from 'react-router-dom'
import HeaderComponent from '../components/HeaderComponent'
import FooterComponent from '../components/FooterComponent'
import BreadCrumbComponent from '../components/BreadCrumbComponent'

const Sale = () => {
   const [products, setProducts] = useState([])

   useEffect(() => {
      listProduct().then((response) => {
         setProducts(response.data);
      }).catch(error => {
         console.error(error);
      })

   }, [])
   return (

      <>
      <HeaderComponent />
      <BreadCrumbComponent/>
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
               {products.map((product) => (
                  <div className="col-lg-3 col-md-4 col-sm-4 product-box" key={product.proId}>
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

                              <span className="text1"><s>{product.proBasisPrice.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' })}</s></span>
                           </h5>
                        </div>
                     </div>
                  </div>
               ))}
            </div>
         </div>


      </section>
      <FooterComponent/>
      </>
   )
}

export default Sale