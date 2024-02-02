import React from 'react'
import HeaderComponent from '../components/HeaderComponent'
import FooterComponent from '../components/FooterComponent'
import BreadCrumbComponent from '../components/BreadCrumbComponent'
import ProductDetailComponent from '../components/ProductDetailComponents/ProductDetailComponent'

const ProductDetail = () => {
   return (
      <>
         <HeaderComponent />
         <BreadCrumbComponent/>
         <ProductDetailComponent/>
         <FooterComponent />
      </>
   )
}

export default ProductDetail