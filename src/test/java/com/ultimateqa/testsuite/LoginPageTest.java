package com.ultimateqa.testsuite;

import com.ultimateqa.pages.LoginPage;
import com.ultimateqa.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity" , "regression"})
    public void userShouldNavigateToLoginPageSuccessfully(){

        loginPage.clickOnSignInLink();

        String expectedSignInMessage = "Welcome Back!";
        Assert.assertEquals(loginPage.getWelcomeTextFromSignInPage(), expectedSignInMessage, "Not on sign in page");
    }

    @Test(groups = {"smoke" , "regression"})
    public void verifyTheErrorMessage(){

        loginPage.clickOnSignInLink();
        loginPage.enterUserEmail("priem123@email.com");
        loginPage.enterUserPassword("prime123");
        loginPage.clickOnSignInButton();

        String expectedSignInErrorMessage = "Invalid email or password.";
        Assert.assertEquals(loginPage.getErrorMessageForInvaidUserNameAndPassword(), expectedSignInErrorMessage,
                "No error message displayed");

    }
}
