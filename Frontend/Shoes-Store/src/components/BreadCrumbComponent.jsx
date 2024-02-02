import React from 'react'
import banner from '../imgs/tp229-blogbanner-05-452.jpg'
import { useParams } from 'react-router-dom';

const BreadCrumbComponent = () => {
   const { cateId, braId } = useParams();
   return (
      <section class="breadcrumb-section set-bgBC">
         <div class="container">
            <div class="row">
               <div class="col-lg-12 text-center">
                  <div class="breadcrumb__text">
                     <h2>Shoes Shop</h2>
                     <div class="breadcrumb__option">
                        <a href="/">Home</a>
                        <span>Shop</span> &nbsp;
                        {braId == 1 && <span>/ Nike</span>}
                        {braId == 2 && <span>/ Adidas</span>}
                        {braId == 3 && <span>/ Lacoste</span>}
                        {braId == 4 && <span>/ Puma</span>}
                        {braId == 5 && <span>/ Balence</span>}
                        {braId == 6 && <span>/ Asics</span>}                                           
                        {cateId == 1 && <span>/ Giày Nam</span>}
                        {cateId == 2 && <span>/ Giày Nữ</span>}
                        {cateId == 3 && <span>/ Dép</span>}
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </section>
   )
}

export default BreadCrumbComponent