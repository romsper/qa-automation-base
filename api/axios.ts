import axios from 'axios';

const instance = axios.create({
    baseURL: "https://randomuser.me/api",
  });

  export default instance