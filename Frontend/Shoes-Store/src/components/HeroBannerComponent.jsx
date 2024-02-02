import { faPhone } from '@fortawesome/free-solid-svg-icons'
import award from '../imgs/banner/award.png'
import hotline from '../imgs/banner/hotline.png'
import deliver from '../imgs/banner/deliver.png'
import gift from '../imgs/banner/gift-box.png'
import React from 'react'
import { Link } from 'react-router-dom'

const MenuCategoryComponent = () => {
   return (
      <><section className="hero">
         <div className="container">
            <div className="row">
               <div className="col-lg-3">
               </div>
               <div className="col-lg-9">
                  <div className="hero__item set-bg">
                     <div className="hero__text">
                        <span>Buy Online</span>
                        <h2>The Best <br />Sale</h2>
                        <p>Free Pickup and Delivery Available</p>
                        <Link to={"/Sale"} className="primary-btn">SHOP NOW</Link>
                     </div>
                  </div>
               </div>
            </div>
         </div>

         <div className="container des">
               <div className="row">
                  <div className="col-lg-3">
                     <div>
                        <img src={deliver} alt="" />
                     </div>
                     <div className="content-text">
                        <h6 >Vận chuyển miễn phí</h6>
                        <p>Cho đơn hàng  500.000đ</p>
                     </div>
                  </div>
                  <div className="col-lg-3">
                     <div>
                        <img src={gift} alt="" width="50" />
                     </div>
                     <div className="content-text">
                        <h6 >Mua 2 được giảm giá</h6>
                        <p>Lên đến 10% cho đơn hàng kế</p>
                     </div>
                  </div>
                  <div className="col-lg-3">
                     <div className="">
                        <img src={award} alt="" width="50" />
                     </div>
                     <div className="content-text">
                        <h6 >Chứng nhận chất lượng</h6>
                        <p>Sản phẩm chất lượng kiểm định</p>
                     </div>
                  </div>
                  <div className="col-lg-3">
                     <div className="">
                        <img src={hotline} alt="" width="50" />
                     </div>
                     <div className="content-text">
                        <h6 >Hotline: 19001234</h6>
                        <p>Hỗ trợ trực tiếp nhanh chóng</p>
                     </div>
                  </div>
               </div>
            </div>
      </section>
      </>

   )
}

export default MenuCategoryComponent