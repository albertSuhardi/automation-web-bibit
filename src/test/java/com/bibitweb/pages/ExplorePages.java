package com.bibitweb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExplorePages {
    WebDriver driver;

    public ExplorePages(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoginButtonVisible() {
        return driver.findElement(By.cssSelector("a.navbarItem_navbar-item__9m6wG.navbarItem_button__MuFw9[href='https://app.bibit.id/login']")).isDisplayed();
    }

    public void clickLoginButton() {
        driver.findElement(By.cssSelector("a.navbarItem_navbar-item__9m6wG.navbarItem_button__MuFw9[href='https://app.bibit.id/login']")).click();
    }
    
    public void clickOTPNumber(char digit){
        driver.findElement(By.cssSelector("[data-testid='num-" + digit + "']")).click();
    }

    public void clickLanjutButton(){
        driver.findElement(By.cssSelector("button[data-content='Lanjut']")).click();
    }

    public boolean isExploreButtonVisible(){
        return driver.findElement(By.xpath("//div[text()='Explore']")).isDisplayed();
    }

    public void clickExploreButton(){
        driver.findElement(By.xpath("//div[text()='Explore']")).click();
    }

    public boolean isExploreTitleVisible() {
        return driver.findElement(By.xpath("//div[text()='Explore']")).isDisplayed();
    }

    public boolean isSearchTopRowVisible() {
        return driver.findElement(By.className("ExploreSaham_bit-search-top-row__vKyam")).isDisplayed();
    }

    public void clickExploreSearchFieldVisible() {
        driver.findElement(By.cssSelector("div.ExploreSaham_bit-explore-button__XEn5W")).click();
    }

    public void searchProdukInvestasi(String text) {
        WebElement searchInput = driver.findElement(By.cssSelector("input.custom-input-search"));
        searchInput.click();
        searchInput.sendKeys(text);
    }

    public boolean isSearchTextVisible(String text) {
        return driver.findElement(By.xpath("//div[text()[contains(., '"+text+"')]]")).isDisplayed();
    }
}
