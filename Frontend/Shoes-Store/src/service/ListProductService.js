import axios from 'axios'

const REST_API = 'http://localhost:8080/api/products';

export const listProduct = () => {
   return axios.get(REST_API);
}