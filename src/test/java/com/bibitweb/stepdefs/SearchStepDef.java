package com.bibitweb.stepdefs;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import com.bibitweb.pages.ExplorePages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchStepDef {

    private WebDriver driver;
    private ExplorePages homePage;

    @Given("User opens the Bibit homepage")
    public void user_opens_the_bibit_homepage() {
        WebDriverManager.firefoxdriver().setup();

        FirefoxProfile profile = new FirefoxProfile(
            new File("/Users/myuser/Library/Application Support/Firefox/Profiles/t7nxi3o7.default-release")
        );

        FirefoxOptions options = new FirefoxOptions();

        // --- Chrome (opsional) ---
        /*
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("user-data-dir=/Users/myuser/Library/Application Support/Google/Chrome");
        chromeOptions.addArguments("profile-directory=Default");

        driver = new ChromeDriver(chromeOptions);
        */


        // --- Safari (opsional, hanya jika Safari Driver aktif) ---
        /*
        driver = new SafariDriver(); // Tidak perlu setup WebDriverManager untuk Safari
        */

        options.setProfile(profile);

        driver = new FirefoxDriver(options);
        driver.get("https://bibit.id/id");

        homePage = new ExplorePages(driver);
    }

    @Then("Login and click login button {string}")
    public void login_button_should_be_visible(String phoneNumber) {
        assertTrue(homePage.isLoginButtonVisible());
        homePage.clickLoginButton();
        assertTrue(homePage.isFieldLoginVisible());
        homePage.fillPhoneNumber(phoneNumber);
        homePage.clickLoginButtonTwo();
    }

    @And("User enters OTP {string} dan pin {string}")
    public void user_enters_otp(String otp, String pin) {
        //homePage.fillOTP(otp); // Buat metode ini di Page Object
        // homePage.clickLoginMethodEmail();
        // homePage.clickLoginMethodMissedCall();
        homePage.clickLoginMethodSMS();
        homePage.clickPilihButton();
        assertTrue(homePage.isOTPNumberPage());

        for (char digit : otp.toCharArray()) {
            homePage.clickOTPNumber(digit);
        }

        assertTrue(homePage.isPinPage());

        for (char digit : pin.toCharArray()) {
            homePage.clickOTPNumber(digit);
        }

        homePage.clickLanjutButton();
    }

    @Then("User should be redirected to homepage account and search investor {string}")
    public void user_should_be_redirected_to_homepage(String manajemen){
        assertTrue(homePage.isSearchButton());
        homePage.clickSearchButton();
        assertTrue(homePage.isSearchInputVisible());
        homePage.clickSearchFieldTrigger();
        homePage.fillInSearchField(manajemen);
    }
}
