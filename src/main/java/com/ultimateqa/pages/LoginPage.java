package com.ultimateqa.pages;

import com.aventstack.extentreports.Status;
import com.ultimateqa.customlisteners.CustomListeners;
import com.ultimateqa.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(linkText = "Sign In")
    WebElement signInLink;
    @CacheLookup
    @FindBy(xpath = "//h2[@class='page__heading']")
    WebElement welcomeText;
    @CacheLookup
    @FindBy(id = "user[email]")
    WebElement userEmail;
    @CacheLookup
    @FindBy(id = "user[password]")
    WebElement userPassword;
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement signInButton;
    @CacheLookup
    @FindBy(xpath = "//li[contains(text(),'Invalid email or password.')]")
    WebElement errorMessage;

    public void clickOnSignInLink() {
        Reporter.log("Verify sign in link " + signInLink.getText());
        clickOnElement(signInLink);

    }

    public String getWelcomeTextFromSignInPage() {
        Reporter.log("Verify welcome back text " + welcomeText.getText());
        return getTextFromElement(welcomeText);
    }

    public void enterUserEmail(String userNameText) {
        Reporter.log("Enter user email " + userEmail.getText() + " and enter " + userNameText);
        sendTextToElement(userEmail, userNameText);
    }

    public void enterUserPassword(String userPasswordText) {
        Reporter.log("Enter user password " + userPassword.getText() + " and enter " + userPasswordText);
        sendTextToElement(userPassword, userPasswordText);
    }

    public void clickOnSignInButton() {
        Reporter.log("Click on sign in button " + signInButton.getText());
        clickOnElement(signInButton);
    }

    public String getErrorMessageForInvaidUserNameAndPassword() {
        Reporter.log("Verify error message " + errorMessage.getText());
        return getTextFromElement(errorMessage);
    }

}
