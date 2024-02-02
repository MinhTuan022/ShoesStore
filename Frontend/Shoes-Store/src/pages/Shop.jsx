import React from 'react'

import ProductsComponent from '../components/ProductsComponent'
import FooterComponent from '../components/FooterComponent'
import HeaderComponent from '../components/HeaderComponent'
import BreadCrumbComponent from '../components/BreadCrumbComponent'
import ShopGridComponent from '../components/ShopGridComponent'


function Shop() {
   return (
      <>
         <HeaderComponent />
         <BreadCrumbComponent/>
         {/* <ProductsComponent/> */}
         <ShopGridComponent/>
         <FooterComponent/>
      </>
   )
}

export default Shop