import axios from 'axios'

const REST_API = 'http://localhost:8080/api/auth/signin';
const token = localStorage.getItem("token")

export const loginUser = (email, password) => {
   return axios.post(REST_API, { email, password });
}

export const getUser = (email) => {
   return axios.get(`http://localhost:8080/api/users/user?email=${email}`,{
      headers: {
         Authorization: `Bearer ${token}`
      }
   });
}



