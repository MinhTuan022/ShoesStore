import React from 'react'

const SigninComponent = () => {
   return (
      <section class="vh-100 gradient-custom login-form">
         <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
               <div class="col-12 col-md-8 col-lg-6 col-xl-5 ">
                  <div class="card bg-light text-black box-login" >
                     <div class="card-body p-5 text-center ">

                        <div class="mb-md-2 mt-md-2 pb-2 ">

                           <h2 class="fw-bold mb-2 text-uppercase text-login">Login</h2>
                           <p class="text-black-50 mb-4">Please enter your login and password!</p>
                           <form>
                              <div class="form-outline form-white mb-4">
                                 <input type="text" id="typeEmailX" class="form-control form-control-mg" placeholder='Username' />
                              </div>

                              <div class="form-outline form-white mb-4">
                                 <input type="password" id="typePasswordX" class="form-control form-control-mg" placeholder='Password' />
                              </div>

                              <p class="small mb-2 pb-lg-2"><a class="text-black-50" href="#!">Forgot password?</a></p>

                              <button class="btn btn-outline-dark btn-mg px-5" type="submit">Login</button>
                           </form>
                           {/* <div class="d-flex justify-content-center text-center mt-4 pt-1">
                 <a href="#!" class="text-white"><i class="fab fa-facebook-f fa-lg"></i></a>
                 <a href="#!" class="text-white"><i class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
                 <a href="#!" class="text-white"><i class="fab fa-google fa-lg"></i></a>
               </div> */}

                        </div>

                        <div>
                           <p class="mb-0">Don't have an account? <a href="#!" class="text-black-50 fw-bold">Sign Up</a>
                           </p>
                        </div>

                     </div>
                  </div>
               </div>
            </div>
         </div>
      </section>
   )
}

export default SigninComponent