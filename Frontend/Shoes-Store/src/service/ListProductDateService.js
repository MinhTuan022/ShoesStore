import axios from 'axios'

const REST_API = 'http://localhost:8080/api/products/date';

export const listProductDate = () => {
   return axios.get(REST_API);
}