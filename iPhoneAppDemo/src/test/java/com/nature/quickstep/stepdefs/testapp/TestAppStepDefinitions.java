package com.nature.quickstep.stepdefs.testapp;


import com.nature.quickstep.pageobjects.iphoneapp.TestApp;
import com.nature.quickstep.util.WebDriverUtils;

import cucumber.api.java.en.*;
import static org.junit.Assert.*;


public class TestAppStepDefinitions {
	
	TestApp app = new TestApp();
	
	@Given("^I am an iPhone user using an app$")
	public void I_am_an_iPhone_user_using_an_app() throws Throwable {
	    WebDriverUtils.getBrowser();
	}

	@When("^I try to add \"([^\"]*)\" and \"([^\"]*)\"$")
	public void I_try_to_add_and(String num1, String num2) throws Throwable {
	   app.computeSum(num1, num2);
	}

	@Then("^I should get \"([^\"]*)\" as the answer$")
	public void I_should_get_as_the_answer(String answer) throws Throwable {
	   assertEquals(answer, app.getAnswer());
	}
	
	
	
	
}
