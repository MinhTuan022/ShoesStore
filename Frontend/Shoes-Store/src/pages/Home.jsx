import React from 'react'
import MenuCategoryComponent from '../components/HeroBannerComponent'
import ProductsComponent from '../components/ProductsComponent'
import FooterComponent from '../components/FooterComponent'
import HeaderComponent from '../components/HeaderComponent'
import ProductDetail from '../components/ProductDetailComponents/ProductDetailComponent'

function Home() {
   return (
      <>
         <HeaderComponent />
         <MenuCategoryComponent></MenuCategoryComponent>
         <ProductsComponent></ProductsComponent>
         <FooterComponent/>
      </>
   )
}

export default Home