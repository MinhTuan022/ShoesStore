import axios from 'axios'

const REST_API = 'http://localhost:8080/api/categories';

export const listCategory = () => {
   return axios.get(REST_API);
}