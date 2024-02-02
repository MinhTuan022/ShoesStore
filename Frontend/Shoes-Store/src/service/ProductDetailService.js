import axios from 'axios'
import { Outlet, useParams } from 'react-router-dom'



export const getProduct = () => {
   const REST_API = `http://localhost:8080/api/products/${proId}`;
   const {proId}= useParams();
   return axios.get(REST_API);
}