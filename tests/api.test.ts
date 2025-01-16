import { test, expect } from '@playwright/test'
import { API } from "../api/controllers";
import { LoginRequest } from "../api/auth/models";
import { ErrorResponse } from '../api/ErrorResponse';
import { AxiosError } from 'axios';

test.describe('Api test', () => {

  test.beforeEach(async () => {

  })

  test('Verify users list', async () => {
    let result = await (await API.auth.getUsers().then((response) => response)).data

    console.log(result)

    expect(result.results[0].gender).toBe("female")
  })

  test('Verify login', async () => {
    let request: LoginRequest = {
      email: "test",
      password: "test"
    }
    let result = await (await API.auth.postLogin(request).then((response) => response)).data

    expect(result.accessToken).toBeDefined()
    expect(result.refreshToken).toBeDefined()
  })

  test('Verify login with invalid credentials', async () => {
    let request: LoginRequest = {
      email: "error",
      password: "error"
    }

    try {
      await (await API.auth.postLogin(request).then((response) => response)).data
    } catch (error) {
      const _error = error as AxiosError<ErrorResponse>;

      expect(_error.response?.status).toBe(404)
      expect(_error.response?.data.code).toBe("10001")
      expect(_error.response?.data.reason).toBe("Invalid credentials provided")
    }
  })
})