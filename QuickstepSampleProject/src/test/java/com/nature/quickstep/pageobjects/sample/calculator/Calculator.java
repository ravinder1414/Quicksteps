package com.nature.quickstep.pageobjects.sample.calculator;

import org.openqa.selenium.By;

import com.nature.quickstep.pageobjects.PageObject;

/**
 * A page object which encapsulates interation with the math.com basic
 * calculator.
 * 
 * @author mark.micallef
 */

public class Calculator extends PageObject {

    /**
     * Stores the name of the 'clear' key on the calculator.
     */
    public final static String KEY_CLEAR = "clear";

    /**
     * Stores the name of the 'equals' key on the calculator.
     */
    public final static String KEY_EQUALS = "DoIt";

    /**
     * Navigates to the math.com basic calculator.
     */
    @Override
    public void navigateTo() {
        browser().get("http://www.math.com/students/calculators/source/basic.htm");
    }

    @Override
    public boolean isPresent() {
        return browser().getClass().equals("http://www.math.com/students/calculators/source/basic.htm");
    }

    /**
     * Presses a key on the calculator.
     * 
     * @param keyValue
     *            - A symbol such as 0..9,+,-,etc
     */
    public void hitKey(String keyValue) {

        if (keyValue.equals("0")) {
            keyValue = "zero";
        } else if (keyValue.equals("1")) {
            keyValue = "one";
        } else if (keyValue.equals("2")) {
            keyValue = "two";
        } else if (keyValue.equals("3")) {
            keyValue = "three";
        } else if (keyValue.equals("4")) {
            keyValue = "four";
        } else if (keyValue.equals("5")) {
            keyValue = "five";
        } else if (keyValue.equals("6")) {
            keyValue = "six";
        } else if (keyValue.equals("7")) {
            keyValue = "seven";
        } else if (keyValue.equals("8")) {
            keyValue = "eight";
        } else if (keyValue.equals("9")) {
            keyValue = "nine";
        } else if (keyValue.equals("+")) {
            keyValue = "plus";
        } else if (keyValue.equals("-")) {
            keyValue = "minus";
        } else if (keyValue.equals("*")) {
            keyValue = "times";
        } else if (keyValue.equals("/")) {
            keyValue = "div";
        }

        browser().findElement(By.name(keyValue)).click();

    }

    /**
     * A convenience method for hitting the 'clear' button on the calculator.
     */
    public void hitClear() {
        hitKey(KEY_CLEAR);
    }

    /**
     * A convenience method for hitting the 'equals' button on the calculator.
     */
    public void hitEquals() {
        hitKey(KEY_EQUALS);
    }

    /**
     * Reads and returns the value of the display on the calculator screen.
     * 
     * @return The value displayed on the calculator screen.
     */
    public String getResult() {
        return browser().findElement(By.name("Input")).getAttribute("value");
    }

}
