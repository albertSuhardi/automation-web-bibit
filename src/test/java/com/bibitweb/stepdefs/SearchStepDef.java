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

    @Given("User opens the Bibit homepage with logged-in profile with pin {string}")
    public void user_opens_the_bibit_homepage_and_login(String pin) throws InterruptedException {
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

        options.setProfile(profile);

        driver = new FirefoxDriver(options);
        driver.get("https://bibit.id/id");

        homePage = new ExplorePages(driver);

        assertTrue(homePage.isLoginButtonVisible());
        homePage.clickLoginButton();

        Thread.sleep(3000);

        for (char digit : pin.toCharArray()) {
            homePage.clickOTPNumber(digit);
        }

        homePage.clickLanjutButton();
        Thread.sleep(5000);
        assertTrue(homePage.isExploreButtonVisible());
    }

    @And("User clicks Explore")
    public void user_should_be_redirected_to_homepage() {
        homePage.clickExploreButton();
        assertTrue(homePage.isExploreTitleVisible());
        homePage.clickExploreSearchFieldVisible();
        assertTrue(homePage.isSearchTopRowVisible());
    }

    @Then("User sees search field and types {string}")
    public void user_search_field_and_type(String manajemen) throws InterruptedException{
        homePage.searchProdukInvestasi(manajemen);
        Thread.sleep(2000);
        assertTrue(homePage.isSearchTextVisible("Saham"));
    }

}
