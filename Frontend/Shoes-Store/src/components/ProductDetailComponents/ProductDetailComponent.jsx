import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import { getProduct } from '../../service/ProductDetailService'
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome"
import { faFacebook, faLinkedinIn, faPinterestP, faTwitter } from '@fortawesome/free-brands-svg-icons'
import axios from 'axios';

const ProductDetail = () => {
   const [product, setProduct] = useState([]);
   const [sizes, setSize] = useState([]);
   const { proId } = useParams();
   const [cartItems, setCartItems] = useState([]);
   const [selectedSize, setSelectedSize] = useState('');
   const [quantity, setQuantity] = useState(1);

   const handleSizeChange = (event) => {
      const newSize = event.target.value;
      setSelectedSize(newSize);
   };

   const handleQuantityChange = (event) => {
      const newQuantity = parseInt(event.target.value, 10);
      setQuantity(newQuantity);
   };

   useEffect(() => {
      const storedCartItems = JSON.parse(localStorage.getItem('cart')) || [];
      setCartItems(storedCartItems);
   }, []);

   const addToCart = (item) => {
      const updatedCart = [...cartItems, item];
      setCartItems(updatedCart);
      localStorage.setItem('cart', JSON.stringify(updatedCart));
   };

   const clearCart = () => {
      setCartItems([]);
      localStorage.removeItem('cart');
   };

   useEffect(() => {

      axios.get(`http://localhost:8080/api/products/${proId}`).then((response) => {
         setProduct(response.data);
         setSize(response.data.sizes);
         // console.log(response.data.sizes)
      }).catch(error => {
         console.error(error);
      })
   }, [proId])

   const handleAddToCart = () => {
      addToCart({
         productId: product.proId,
         productName: product.proName,
         productImage: product.images[0].imgData,
         quantity: quantity, 
         size: selectedSize,
         price: product.proPrice,
      });
   };


   return (
      <section className="product-details spad">
         <div className="container">
            <div className="row">
               <div className="col-lg-6 col-md-6">
                  <div className="product__details__pic">
                     <div className="product__details__pic__item">
                        {product.images && product.images.length > 0 && (
                           <img className="product__details__pic__item--large" src={`data:image/jpeg;base64,${product.images[0].imgData}`} alt="" />
                        )}
                     </div>

                     {/*Thêm ảnh sản phẩm*/}
                     {/* <div className="product__details__pic__slider owl-carousel">
                     {product && product.images && product.images.length > 1 ? (
                        <img data-imgbigurl="" src={`data:image/jpeg;base64,${product.images[1].imgData}`} alt="" />
                     ):<></>}
                     </div> */}
                  </div>
               </div>
               <div className="col-lg-6 col-md-6">
                  <div className="product__details__text">
                     <h3>{product.proName}</h3>
                     <div className="product__details__rating">

                        <span className="fa fa-star checked"></span>

                        <span>5  reviews</span>

                     </div>
                     <div className="product__details__price">{product.proPrice} đ</div>
                     <p>{product.proDescription}</p>
                     <form id="add-to-cart-form">
                        <div className="product__details__quantity">
                           <div className="quantity">
                              <b>Số Lượng:</b>
                              <div className="pro-qty">
                                 <input min={0} type="number" onChange={handleQuantityChange} value={quantity}/>
                              </div>
                              <b>Size:</b>
                              <select name="" id="size" className="size" onChange={handleSizeChange}>
                                 {sizes.map((s) => (
                                    <option key={s.sid} > {s.size} </option>
                                 ))}


                              </select>
                           </div>
                        </div>

                        <button type="submit" className="primary-btn" onClick={handleAddToCart}>ADD TO CARD</button>

                        {/* <a href='#'><button className="primary-btn">ADD TO CARD</button></a> */}



                     </form>
                     <ul>
                        <li><b>Availability</b>

                           <span>Out Of Stock</span>


                        </li>
                        <li><b>Shipping</b> <span>03 days shipping. <samp>Free pickup today</samp></span></li>

                        <li><b>Share on</b>
                           <div className="share">
                              <a href="#"><FontAwesomeIcon icon={faFacebook} /></a>
                              <a href="#"><FontAwesomeIcon icon={faTwitter} /></a>
                              <a href="#"><FontAwesomeIcon icon={faLinkedinIn} /></a>
                              <a href="#"><FontAwesomeIcon icon={faPinterestP} /></a>
                           </div>
                        </li>
                     </ul>
                  </div>
               </div>



               <div className="col-lg-12">
                  <div className="product__details__tab">
                     <ul className="nav nav-tabs" role="tablist">
                        <li className="nav-item">
                           <a className="nav-link active" data-toggle="tab" href="#tabs-1" role="tab" aria-selected="true">Description</a>
                        </li>
                        <li className="nav-item">
                           <a className="nav-link" data-toggle="tab" href="#tabs-2" role="tab" aria-selected="false">Total Reviews</a>
                        </li>
                        <li className="nav-item">
                           <a className="nav-link" data-toggle="tab" href="#tabs-3" role="tab" aria-selected="false">Reviews <span>$count</span></a>
                        </li>
                     </ul>
                     <div className="tab-content">
                        <div className="tab-pane active" id="tabs-1" role="tabpanel">
                           <div className="product__details__tab__desc">
                              <h6>Product Description</h6>
                              <p>{product.proDescription}</p>
                           </div>
                        </div>
                        <div className="tab-pane" id="tabs-2" role="tabpanel">
                           <div className="product__details__tab__desc">
                              <h6>Total Product Reviews </h6>
                              <div className="rating-summary">
                                 <div className="average-rating">
                                    <span className="rating">$averageRating</span>
                                    <span className="outof5">out of 5</span>
                                    <div className="total-count">
                                       $totalRatings Ratings
                                    </div>
                                 </div>
                                 <ul className="bar-chart">
                                    <li>
                                       <span className="star">5 star:</span>
                                       <div className="bar-container">
                                          <div className="bar"></div>
                                       </div>
                                       <span className="count">$star5Count;</span>
                                    </li>
                                    <li>
                                       <span className="star">4 star:</span>
                                       <div className="bar-container">
                                          <div className="bar" ></div>
                                       </div>
                                       <span className="count">$star4Count</span>
                                    </li>
                                    <li>
                                       <span className="star">3 star:</span>
                                       <div className="bar-container">
                                          <div className="bar" ></div>
                                       </div>
                                       <span className="count">$star3Count</span>
                                    </li>
                                    <li>
                                       <span className="star">2 star:</span>
                                       <div className="bar-container">
                                          <div className="bar" ></div>
                                       </div>
                                       <span className="count">echo $star2Count;</span>
                                    </li>
                                    <li>
                                       <span className="star">1 star:</span>
                                       <div className="bar-container">
                                          <div className="bar" ></div>
                                       </div>
                                       <span className="count">echo $star1Count;</span>
                                    </li>
                                 </ul>
                              </div>

                           </div>
                        </div>
                        <div className="tab-pane" id="tabs-3" role="tabpanel">
                           <div className="product__details__tab__desc">
                              <h6>Product Reviews</h6>
                              <div className="comments-container">

                                 <ul className="comments-list">
                                    <li className="comment">
                                       <div className="comment-content">
                                          <h1 className="comment-author">CusName</h1>

                                          <span className="fa fa-star checked"></span>

                                          <p className="comment-text">ComDate</p>
                                          <p className="comment-text" >ComContent</p>
                                       </div>
                                    </li>
                                 </ul>

                              </div>
                              <form >
                                 <div className="rating-container">
                                    <h5>Tap to Rate:</h5>
                                    <div className="rating">
                                       <input type="radio" id="star5" name="rating" value="5" />
                                       <label></label>
                                       <input type="radio" id="star4" name="rating" value="4" />
                                       <label ></label>
                                       <input type="radio" id="star3" name="rating" value="3" />
                                       <label ></label>
                                       <input type="radio" id="star2" name="rating" value="2" />
                                       <label ></label>
                                       <input type="radio" id="star1" name="rating" value="1" />
                                       <label ></label>
                                    </div>
                                 </div>
                                 <div className="comment-box">
                                    <input type="hidden" name="proid" value="" />
                                    <textarea id="comment-input" placeholder="Enter your comment!" name="comment"></textarea>
                                    <button id="submit-button">Send</button>
                                 </div>
                              </form>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </section>
   )
}

export default ProductDetail