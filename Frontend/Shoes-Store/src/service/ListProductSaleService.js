import axios from 'axios'

const REST_API = 'http://localhost:8080/api/products/sale';

export const listProductSale = () => {
   return axios.get(REST_API);
}