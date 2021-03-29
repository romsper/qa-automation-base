module.exports = {
  verbose: true,
  preset: 'jest-playwright-preset',
  transform: {
    '^.+\\.ts$': 'ts-jest',
  },
  testRunner : 'jasmine2',
  reporters: [
    'default',
    'jest-allure',
  ],
  setupFilesAfterEnv: [
    'jest-allure/dist/setup',
    '<rootDir>/testSetup.js'
  ],
}