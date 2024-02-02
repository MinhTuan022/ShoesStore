import axios from 'axios'

const REST_API = 'http://localhost:8080/api/brands';

export const listBrand = () => {
   return axios.get(REST_API);
}