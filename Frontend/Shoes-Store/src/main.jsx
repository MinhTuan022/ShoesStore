import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './pages/App.jsx'
import Home from './pages/Home.jsx'
import ProductsComponent from './components/ProductsComponent.jsx'
import ProductDetail from './pages/ProductDetail.jsx'
import ShopGrid from './pages/Shop.jsx'
import './index.css'
import './style.css'
import 'bootstrap/dist/css/bootstrap.min.css'

import {
   createBrowserRouter,
  RouterProvider,
   // BrowserRouter
} from "react-router-dom"
import NotFoundPage from './pages/NotFoundPage.jsx'
import Contact from './pages/Contact.jsx'
import Sale from './pages/Sale.jsx'
import Login from './pages/Login.jsx'
import SigninComponent from './components/SigninComponent.jsx'
import ShoppingCart from './pages/ShoppingCart.jsx'
import CheckOut from './pages/CheckOut.jsx'


const router = createBrowserRouter([
   {
      path: "/",
      element: <Home />,
   },
   {
      path: "*",
      element: <NotFoundPage />,
   },
   {
      path: "/products/:cateId/category",
      element: <ShopGrid />,
   },
   {
      path: "/products/:braId/brand",
      element: <ShopGrid />,
      
   },
   // {
   //    path: "/products/:cateId?/:braId?",
   //    element: <ShopGrid />,
      
   {
      path: "/ProductDetail/:proId",
      element: <ProductDetail />,
   },
   {
      path: "/Sale",
      element: <Sale />,
   },
   {
      path: "/Contact",
      element: <Contact />,
   },
   {
      path: "/shopping-cart",
      element: <ShoppingCart />,
   },
   {
      path: "/checkout",
      element: <CheckOut />,
   },

   {
      path: "/login",
      element: <Login />,
   },
]);

ReactDOM.createRoot(document.getElementById('root')).render(
   <React.StrictMode>
      <RouterProvider router={router} />
      {/* <BrowserRouter>
         <App/>
      </BrowserRouter> */}
   </React.StrictMode>,
)
