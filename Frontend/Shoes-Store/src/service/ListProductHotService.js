import axios from 'axios'

const REST_API = 'http://localhost:8080/api/products/hot';

export const listProductHot = () => {
   return axios.get(REST_API);
}