import client from '../axios.ts';
import { LoginRequest, LoginResponse } from './models.ts';

// This is temp endpoint to test the API
async function getUsers() {
  return await client.get('/');
}

async function postLogin(request: LoginRequest) {
  return await client.post<LoginResponse>('/login', request);
}

export default {
  getUsers,
  postLogin,
};

