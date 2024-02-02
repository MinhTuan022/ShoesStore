import React, { useEffect, useState } from 'react'
import HeaderComponent from '../components/HeaderComponent'
import BreadCrumbComponent from '../components/BreadCrumbComponent'
import FooterComponent from '../components/FooterComponent'
import { ToastContainer, toast } from 'react-toastify'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

const CheckOut = () => {
   const [cartItems, setCartItems] = useState([]);
   const storedCartItems = JSON.parse(localStorage.getItem('cart')) || [];
   const totalAmount = storedCartItems.reduce((total, product) => total + (product.price * product.quantity), 0);
   const navigate = useNavigate();
   useEffect(() => {
      setCartItems(storedCartItems);
      // console.log(totalAmount);
   }, []);

   const [order, setOrder] = useState({
      email: "",
      ordAddress: "",
      ordReceiver: "",
      ordPhone: "",
      payId: 1,
      orderDetailList: [],
   });

   useEffect(() => {
      // Lấy dữ liệu từ localStorage khi component được tạo
      const cartItems = JSON.parse(localStorage.getItem('cart')) || [];

      if (cartItems.length > 0) {
         const orderDetailList = cartItems.map(item => ({
            size: item.size,
            quantity: item.quantity,
            proId: item.productId,
         }));

         const savedEmail = localStorage.getItem('email') || "";
         setOrder({
            ...order,
            //  payId: payid,
            email: savedEmail,
            orderDetailList: orderDetailList,
         });
      }
   }, []); // Chỉ chạy một lần khi component được tạo

   const handleInputChange = (fieldName, value) => {
      setOrder({
         ...order,
         [fieldName]: value,
      });
   };
   // const clearCart = () => {
   //    setCartItems([]);
   //    localStorage.removeItem("cart");
   // };
   const handleCheckOut = async () => {
      try {
         const response = await axios.post('http://localhost:8080/api/order/create', order);
         setCartItems([]);
         localStorage.removeItem("cart");

         // toast.success('Dữ liệu đã được gửi thành công!', { position: "top-center" });
         
         console.log(response.data);
         navigate("/")

      } catch (error) {
         console.error('Lỗi khi gửi dữ liệu:', error);
      }
   };


   return (
      <><HeaderComponent />
         <ToastContainer /><BreadCrumbComponent /><section class="checkout spad">
            <div class="container">
               <div class="checkout__form">
                  <h4>Billing Details</h4>
                  <form action="#">
                     <div class="row">
                        <div class="col-lg-6 col-md-6">
                           <div class="row">
                              <div class="col-lg-12">
                                 <div class="checkout__input">
                                    <p>Receiver:<span>*</span></p>
                                    <input type="text" value={order.ordReceiver}
                                       onChange={(event) => handleInputChange('ordReceiver', event.target.value)} />
                                 </div>
                              </div>
                           </div>

                           <div class="checkout__input">
                              <p>Address<span>*</span></p>
                              <input type="text" placeholder="Street Address" class="checkout__input__add" value={order.ordAddress}
                                 onChange={(event) => handleInputChange('ordAddress', event.target.value)} />
                           </div>

                           <div class="row">
                              <div class="col-lg-6">
                                 <div class="checkout__input">
                                    <p>Phone<span>*</span></p>
                                    <input type="text" value={order.ordPhone}
                                       onChange={(event) => handleInputChange('ordPhone', event.target.value)} />
                                 </div>
                              </div>
                              <div class="col-lg-6">
                                 <div class="checkout__input">
                                    <p>Email<span>*</span></p>
                                    {localStorage.getItem("email") ?
                                       <input type="text" defaultValue={localStorage.getItem("email")} readOnly />
                                       : <input type="text" />
                                    }
                                 </div>
                              </div>
                           </div>
                        </div>
                        <div class="col-lg-6 col-md-6">
                           <div class="checkout__order">
                              <h4>Your Order</h4>
                              <div class="checkout__order__products">Products <span>Total</span></div>
                              <ul>
                                 {cartItems.map((item) => (
                                    <li key={item.productId}>{item.productName} <span>{(item.price * item.quantity).toLocaleString('vi-VN', { style: 'currency', currency: 'VND' })}</span></li>
                                 ))}
                              </ul>
                              {/* <div class="checkout__order__subtotal">Subtotal <span>$750.99</span></div> */}
                              <div class="checkout__order__total">Total <span>{totalAmount.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' })}</span></div>

                              <div >
                                 <label>
                                    Payment upon delivery
                                    <input type="radio" value={1}
                                       checked={order.payId === 1}
                                       onChange={(event) => handleInputChange('payId', 1)} />
                                    <span class="checkmark"></span>
                                 </label>
                              </div>
                              <div>
                                 <label>
                                    Credit Card
                                    <input type="radio" value={2}
                                       checked={order.payId === 2}
                                       onChange={(event) => handleInputChange('payId', 2)} />
                                    <span class="checkmark"></span>
                                 </label>
                              </div>
                              <button type="button" class="site-btn" onClick={handleCheckOut}>PLACE ORDER</button>

                           </div>
                        </div>
                     </div>
                  </form>
               </div>
            </div>

         </section>
         <FooterComponent /></>
   )
}

export default CheckOut