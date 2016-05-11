package com.nature.quickstep.stepdefs.sample;

import static org.junit.Assert.assertEquals;

import com.nature.quickstep.pageobjects.sample.calculator.Calculator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SampleStepDefinitions {

    Calculator calc = new Calculator();

    @Given("^I am a user of Math.com using the simple calculator$")
    public void I_am_a_user_of_Math_com_using_the_simple_calculator() throws Throwable {
        calc.navigateTo();
    }

    @When("^I calculate \"([^\"]*)\"$")
    public void I_calculate(String expression) throws Throwable {

        calc.hitClear();

        for (char c : expression.toCharArray()) {

            if (!Character.isWhitespace(c)) {
                calc.hitKey("" + c);
            }

        }

        calc.hitEquals();
    }

    @Then("^I should see the answer ([^\"]*)$")
    public void I_should_see_the_answer(String answer) throws Throwable {
        assertEquals(answer, calc.getResult());
    }

}
