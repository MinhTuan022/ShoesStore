import React, { useEffect, useState } from "react"
import logo from "../imgs/logo-shoes.png"
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome"
import { faFacebook, faLinkedinIn, faPinterestP, faTwitter } from '@fortawesome/free-brands-svg-icons'
import { faCartShopping, faEnvelope, faUser, faPhone, faBars, faArrowCircleDown, faCaretDown, faChevronDown, faRightFromBracket } from "@fortawesome/free-solid-svg-icons"
import { BrowserRouter as Link, NavLink, Outlet } from "react-router-dom"
import { listBrand } from '../service/ListBrandService'
import { listCategory } from "../service/ListCategoryService"
import { getUser } from '../service/LoginService'



const HeaderComponent = () => {
   const [brands, setBrands] = useState([])
   const [categories, setCategories] = useState([])
   const [user, setUser] = useState([])
   const email = localStorage.getItem("email")
   const storedCartItems = JSON.parse(localStorage.getItem('cart')) || [];
   useEffect(() => {
      listBrand().then((response) => {
         setBrands(response.data);
      }).catch(error => {
         console.error(error);
      })

      listCategory().then((re) => {
         setCategories(re.data);
      }).catch(error => {
         console.error(error);
      })

      if (email) {
         fetchData();
      }

   }, [])


   const fetchData = async () => {
      const token = localStorage.getItem('token');
      let res;
      res = await getUser(email)
         .then(response => {
            // console.log(response.data);
            setUser(response.data)
            // Xử lý dữ liệu ở đây
         })
         .catch(error => {
            console.error('Authentication error:', error);
            // Xử lý lỗi ở đây
         });
   };

   const handleLogout = () => {
      localStorage.removeItem("token");
      localStorage.removeItem("email");

   }




   const [isOpen, setIsOpen] = useState(false);

   const toggleDropdown = () => {
      setIsOpen(!isOpen);
   };

   return (
      <><header className="header">
         <div className="header__top">
            <div className="container">
               <div className="row">
                  <div className="col-lg-6 col-md-6 col-sm-6">
                     <div className="header__top__left">
                        <ul>
                           <li><FontAwesomeIcon icon={faEnvelope} /> shoesstore@scorpio.com</li>
                           <li>Free Shipping for all Order of $99</li>
                        </ul>
                     </div>
                  </div>
                  <div className="col-lg-6 col-md-6 col-sm-6">
                     <div className="header__top__right">
                        <div className="header__top__right__social">
                           <a href="#"><FontAwesomeIcon icon={faFacebook} /></a>
                           <a href="#"><FontAwesomeIcon icon={faTwitter} /></a>
                           <a href="#"><FontAwesomeIcon icon={faLinkedinIn} /></a>
                           <a href="#"><FontAwesomeIcon icon={faPinterestP} /></a>
                        </div>
                        {!localStorage.getItem("token") ?
                           <div className="header__top__right__auth">
                              <NavLink to={"/login"}><FontAwesomeIcon icon={faUser} /> Login</NavLink>

                              /
                              <a href="#" data-toggle="modal" data-target="#register"> Register</a>
                           </div>
                           : <div className="header__top__right__auth">
                              <a>{user.uname}</a> &nbsp;
                              <a href="" onClick={() => handleLogout()}> <FontAwesomeIcon icon={faRightFromBracket} /> Logout</a>
                           </div>}
                     </div>
                  </div>
               </div>
            </div>
         </div>
         <div className="container">
            <div className="row">
               <div className="col-lg-3">
                  <div className="header__logo">
                     <a href="/"><img src={logo} alt="" /></a>
                  </div>
               </div>
               <div className="col-lg-7">
                  <nav className="header__menu">
                     <ul>
                        {categories.map((category) => (
                           <li key={category.cateId}><NavLink to={`/products/${category.cateId}/category`}>{category.cateName}</NavLink></li>
                        ))}
                        <li><NavLink to={"/Sale"}>Sale</NavLink></li>
                        <li><NavLink to={"/Contact"}>Contact</NavLink></li>

                     </ul>
                  </nav>
               </div>
               <div className="col-lg-2">
                  <div className="header__cart">
                     <ul>
                        <li><NavLink to={"/shopping-cart"}><FontAwesomeIcon icon={faCartShopping} color="black" />
                           
                              {storedCartItems === null?
                              <span>0</span>
                                  :<span>{storedCartItems.length}</span>
                              }
                           
                        </NavLink></li>
                     </ul>

                     {/* <div className="header__cart__price">item: <span></span></div> */}

                  </div>
               </div>
            </div>
            <div className="humberger__open">
               {/* <FontAwesomeIcon icon={faBars}></FontAwesomeIcon> */}
            </div>
         </div>
         <section class="hero">
            <div className="container">
               <div className="row">
                  <div className="col-lg-3">
                     <div className="hero__categories">
                        <div className="hero__categories__all" onClick={toggleDropdown}>
                           <FontAwesomeIcon icon={faBars} color="white" />
                           &nbsp; &nbsp;
                           <span>Thương Hiệu</span>
                           &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                           <FontAwesomeIcon icon={faChevronDown} color="white" size="2xs"></FontAwesomeIcon>
                        </div>
                        {isOpen && (
                           <ul>
                              {brands.map((brand) => (
                                 <li key={brand.braId}><NavLink to={`/products/${brand.braId}/brand`}>{brand.braName}</NavLink></li>
                              ))}
                           </ul>
                        )}
                     </div>
                  </div>
                  <div className="col-lg-9">
                     <div className="hero__search">
                        <div className="hero__search__form">
                           <form>
                              <input type="text" placeholder="What do you need?" name="search-product" />

                              <button type="submit" className="site-btn">SEARCH</button>
                           </form>
                        </div>
                        <div className="hero__search__phone">
                           <div className="hero__search__phone__icon">
                              <FontAwesomeIcon icon={faPhone} />
                           </div>
                           <div className="hero__search__phone__text">
                              <h5>+84 859 655 99 </h5>
                              <span>support 24/7 time</span>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div></section>
      </header>
      </>
   )
}
export default HeaderComponent