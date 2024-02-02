import React, { useState } from 'react'
import HeaderComponent from '../components/HeaderComponent'
import FooterComponent from '../components/FooterComponent'
import { loginUser } from '../service/LoginService'
import { NavLink, useNavigate } from 'react-router-dom'
const Login = () => {
   const navigate = useNavigate();
   const [email, setEmail] = useState("");
   const [password, setPassword] = useState("");
   const [isShowPassword, setIsShowPassword] = useState(false);

   const handleLogin = async () => {
      if(!email || ! password){
         console.log("rong")
      }

      let response  = await loginUser(email, password);
      console.log(response);
      if(response && response.data.token){
         localStorage.setItem("token", response.data.token)
         localStorage.setItem("email", email)
         navigate("/")
         window.location.reload();
      }else{
         alert("Thất bại");
      }


   }


   return (

      <>
         {/* <div>Đăng Nhập</div> */}
         <section>
            <div class="container py-5 h-100">
               <div class="row d-flex justify-content-center align-items-center h-100">
                  <div class="col col-xl-10">
                     <div class="card">
                        <div class="row g-0">
                           <div class="col-md-6 col-lg-5 d-none d-md-block">
                              <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img2.webp"
                                 alt="login form" class="img-fluid" />
                           </div>
                           <div class="col-md-6 col-lg-7 d-flex align-items-center">
                              <div class="card-body p-4 p-lg-5 text-black">

                                 <form>

                                    <div class="d-flex align-items-center mb-3 pb-1">
                                       <i class="fas fa-cubes fa-2x me-3"></i>
                                       <span class="h1 fw-bold mb-0">Logo</span>
                                    </div>

                                    <h5 class="fw-normal mb-3 pb-3">Sign into your account</h5>

                                    <div class="form-outline mb-4">
                                       <input class="form-control form-control-lg"
                                          type="email"  
                                          placeholder='Email Address'
                                          value={email}
                                          onChange={(event) => setEmail(event.target.value)}
                                       />
                                    
                                    </div>

                                    <div class="form-outline mb-4">
                                       <input class="form-control form-control-lg"
                                          type={isShowPassword === true ? "text" : "password"}
                                          placeholder='Password'
                                          value={password}
                                          onChange={(event) => setPassword(event.target.value)}
                                       />
                                    </div>

                                    <div class="pt-1 mb-4">
                                       <button class="btn btn-dark btn-lg btn-block" 
                                          type="button"
                                          onClick={() => handleLogin()}
                                       >Login</button>
                                    </div>

                                    <a class="small text-muted" href="#!">Forgot password?</a>
                                    <p class="mb-5 pb-lg-2">Don't have an account? 
                                       <NavLink to={"/signup"}>Register here</NavLink>
                                    </p>
                                    
                                 </form>

                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </section>
         <FooterComponent />
      </>
   )
}

export default Login