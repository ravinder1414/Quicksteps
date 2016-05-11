package com.nature.quickstep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.nature.quickstep.pageobjects.PageObject;
import com.nature.quickstep.util.SeleniumWaitBuilder.WaitInit;

/**
 * 
 * @author martin.vanek
 * 
 */
public class Examples {

    /**
     * Showcase how PageObject ensure() refuse() methods should be used
     */
    public void showEnsureRefuse() {

        ExamplePage examplePage = new ExamplePage();
        SuccessPage succesPage = new SuccessPage();
        ErrorPage errorPage = new ErrorPage();

        examplePage.navigateTo(); //redirects can occur making any findElement to fail...

        examplePage.ensure().html().seconds(5); //Wait 5 seconds if "html" will become root element (easiest way to skip all redirects)
        examplePage.ensure().page(examplePage).seconds(5);
        examplePage.ensure().element(By.id("FormId")).seconds(5);
        examplePage.ensure().title().equals("Example Page").seconds(5);
        examplePage.ensure().url().matches(".*-1\\.\\d+$").seconds(5);

        //Call navigateTo() and Wait until ExamplePage.isPresent() returns true or fail after 5 seconds
        examplePage.navigateTo(5);

        //redirects can occur making any findElement to fail...
        examplePage.submitForm();

        //submit form and wait for title to end width "Success" or fail after 5 seconds
        examplePage.submitForm().ensure().title().endsWith("Success").seconds(5);

        //submit form and wait for 5 seconds for success page, but if error page appears meanwhile, fail immediately
        examplePage.submitForm().ensure().page(succesPage).refuse().page(errorPage).seconds(5);

        //submit form and wait for 5 seconds for success page, but if error element appears meanwhile, fail immediately
        examplePage.submitForm().ensure().page(succesPage).refuse().element(examplePage.getErrorLocator()).seconds(5);

    }

    static class ExamplePage extends PageObject {

        public WaitInit submitForm() {
            WebElement button = browser().findElement(By.id("FormId")).findElement(By.id("SubmitButtonId"));
            return click(button);
        }

        public By getErrorLocator() {
            return By.id("form-errors");
        }

        @Override
        public void navigateTo() {
            browser().get("http://www.example.com/example");

        }

        @Override
        public boolean isPresent() {
            return browser().getTitle().equals("Example Page");
        }

    }

    static class SuccessPage extends PageObject {

        @Override
        public void navigateTo() {
            throw new IllegalStateException("Never navigate directly to success page");

        }

        @Override
        public boolean isPresent() {
            return browser().getTitle().equals("Success Page");
        }
    }

    static class ErrorPage extends PageObject {

        @Override
        public void navigateTo() {
            throw new IllegalStateException("Never navigate directly to error page");

        }

        @Override
        public boolean isPresent() {
            return browser().getTitle().equals("Error Page");
        }

    }

}
