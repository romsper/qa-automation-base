const { assert } = require("chai");
require("mocha-allure-reporter");
// const { temp_base } = require("../base/temp_base")
const temp_base = require("../base/temp_base")

describe('Shit', () => {

    beforeEach("Before", () => {
        console.log("Before step")
    });

    it('Allure', function() {
    
        let num = temp_base.firstStep();
        assert.equal(num, 1)
    })
})


console.log("LOG", temp_base.firstStep)