package com.nature.quickstep.pageobjects.iphoneapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.nature.quickstep.pageobjects.PageObject;

/**
 * A page object wrapper around <i>TestApp</i>, an iphone app which takes values
 * in 2 fields and computes their sum when a button is clicked.
 * 
 * @author mark.micallef
 */

public class TestApp extends PageObject {

	@Override
	public void navigateTo() {
		// Not applicable to this app
	}

	@Override
	public boolean isPresent() {
		// Not applicable to this app
		return true;
	}

	public void computeSum(String num1, String num2) {

		fldTextField1().clear();
		fldTextField2().clear();

		fldTextField1().sendKeys(num1);
		fldTextField2().sendKeys(num2);

		btnComputeSum().click();
	}

	public String getAnswer() {
		return lblAnswer().getText();
	}

	public WebElement fldTextField1() {
		return browser.findElement(By.name("TextField1"));
	}

	public WebElement fldTextField2() {
		return browser.findElement(By.name("TextField2"));
	}

	public WebElement btnComputeSum() {
		return browser.findElement(By.name("ComputeSumButton"));
	}

	public WebElement lblAnswer() {
		return browser.findElement(By.xpath("//text[1]"));
	}
}
