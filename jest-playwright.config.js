// https://github.com/playwright-community/jest-playwright/#configuration
module.exports = {
  // browsers: ["chromium", "firefox", "webkit"], // -> if you want to run your tests in three browsers at the same time
  browsers: ["webkit"],
  // devices: ['iPad (gen 7) landscape'], // -> if you need to run your tests on device 
  exitOnPageError: false,
  launchOptions: {
    headless: false
  }
}