export type LoginRequest = {
    email: string;
    password: string;
  };

export type LoginResponse = {
    accessToken: string;
    refreshToken: string;
    createdAt: number;
    expireInMs: number;
};