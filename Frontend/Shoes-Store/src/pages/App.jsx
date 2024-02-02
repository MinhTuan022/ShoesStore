import { useState } from 'react'
// import reactLogo from './assets/react.svg'
// import viteLogo from '/vite.svg'
// import './App.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faFacebook, faYoutube } from '@fortawesome/free-brands-svg-icons'
import HeaderComponent from '../components/HeaderComponent'
import MenuCategoryComponent from '../components/HeroBannerComponent'
import ProductsComponent from '../components/ProductsComponent'
import Login from '../components/Login'
import { BrowserRouter as Routes, Route, Router } from 'react-router-dom'
import Home from '../pages/Home'
import FooterComponent from '../components/FooterComponent'
import ProductDetail from '../components/ProductDetailComponents/ProductDetailComponent'

function App() {

   return (
      <>

         <HeaderComponent />
         <Routes>
            {/* <Route path="/" element={<Home />} /> */}
            {/* <Route path="/Product" element={<ProductsComponent />} /> */}
         </Routes>

         <FooterComponent></FooterComponent>
      </>

   )
}

export default App;
