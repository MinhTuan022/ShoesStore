import React, { useEffect, useState } from 'react'
import HeaderComponent from '../components/HeaderComponent'
import FooterComponent from '../components/FooterComponent'
import BreadCrumbComponent from '../components/BreadCrumbComponent'
import { Link, NavLink } from 'react-router-dom'
import { Button } from 'bootstrap'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faTrash, faTrashCan } from '@fortawesome/free-solid-svg-icons'

const ShoppingCart = () => {
   const [cartItems, setCartItems] = useState([]);
   const storedCartItems = JSON.parse(localStorage.getItem('cart')) || [];
   const totalAmount = storedCartItems.reduce((total, product) => total + (product.price * product.quantity), 0);

   useEffect(() => {
      // const storedCartItems = JSON.parse(localStorage.getItem('cart')) || [];
      setCartItems(storedCartItems);
      
      // console.log(totalAmount);
   }, []);


   

   const handleDeleteCart = (productId) => {
      // Tạo một bản sao mới của giỏ hàng mà không bao gồm sản phẩm cần xóa
      const updatedCart = cartItems.filter(item => item.productId !== productId);
  
      // Cập nhật state và lưu vào localStorage
      setCartItems(updatedCart);
      localStorage.setItem("cart", JSON.stringify(updatedCart));
    };
   return (
      <>
         <HeaderComponent />
         <BreadCrumbComponent />
         <section class="shoping-cart spad">
            <div class="container">
               <form id="cart-form" action="" method="">
                  <div class="row">
                     <div class="col-lg-12">
                        <div class="shoping__cart__table">
                           <table>
                              <thead>
                                 <tr>
                                    <th class="shoping__product">Products</th>
                                    <th>Sale</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th></th>
                                 </tr>
                              </thead>
                              <tbody>
                                 {cartItems.map((item) =>(
                                 
                                 <tr key={item.productId}>
                                    <td class="shoping__cart__item">
                                       <img width="20%" src={`data:image/jpeg;base64,${item.productImage}`} alt="" />
                                       <h5>{item.productName}</h5> &nbsp;
                                       <h5>Size: {item.size}</h5>
                                    </td>
                                    <td class="shoping__cart__price">
                                    5%
                                    {/* {item.price.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' }) * } */}
                                    </td>
                                    <td class="shoping__cart__price">
                                    {item.price.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' })}
                                    </td>
                                    <td class="shoping__cart__quantity">
                                       <div class="quantity">
                                          <div class="pro-qty">
                                             <input type="number" min={1} value={item.quantity}/>
                                          </div>
                                       </div>
                                    </td>
                                    <td class="shoping__cart__total">
                                    {(item.price * item.quantity).toLocaleString('vi-VN', { style: 'currency', currency: 'VND' })}
                                    </td>
                                    <td class="shoping__cart__item__close">
                                       <span onClick={() => handleDeleteCart(item.productId)}><FontAwesomeIcon icon={faTrashCan}/></span>
                                    </td>
                                 </tr>
                                 ))}
                              </tbody>
                           </table>
                        </div>
                     </div>
                  </div>

                  <div class="shoping__cart__btns">
                     <Link to={"/"}><button class="primary-btn cart-btn">CONTINUE SHOPPING</button></Link>
                     <input type="submit" name="update_click" value="Upadate Cart" class="primary-btn cart-btn cart-btn-right" />
                  </div>


                  <div class="container  form-check">
                     <div class="row">
                        <div class="col-lg-6"></div>

                        <div class="col-lg-6 shoping__checkout">
                           <h5>Cart Total</h5>
                           <ul>
                              <li>Subtotal <span>{totalAmount.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' })}</span></li>
                              <li>Sale <span>0%</span></li>
                              <li>Total <span>{totalAmount.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' })}</span></li>
                           </ul>
                           <Link to={"/checkout"} ><button class="primary-btn">PROCEED TO CHECKOUT</button></Link>

                        </div>
                     </div>
                  </div>
               </form>
            </div>
         </section>
         <FooterComponent />
      </>
   )
}

export default ShoppingCart