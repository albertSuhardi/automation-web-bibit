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

    public boolean isFieldLoginVisible(){
        String expectedText = "Masukkan Nomor Hp Kamu";
        String actualText = driver.findElement(By.cssSelector("div.login-register-heading.text-left")).getText();
        return actualText.contains(expectedText);
    }

    public void fillPhoneNumber(String phoneNumber){
        WebElement phoneInput = driver.findElement(By.cssSelector("input.PhoneInputInput"));
        phoneInput.clear(); // Clear existing value
        phoneInput.sendKeys(phoneNumber);
    }

    public void clickLoginButtonTwo(){
        driver.findElement(By.cssSelector("[data-testid='login-btn-login']")).click();
    }

    public void clickLoginMethodEmail(){
        driver.findElement(By.cssSelector("[data-testid='login-method-email']")).click();
    }

    public void clickLoginMethodMissedCall(){
        driver.findElement(By.cssSelector("[data-testid='login-method-missed-call']")).click();
    }

    public void clickLoginMethodSMS(){
        driver.findElement(By.cssSelector("[data-testid='login-method-sms']")).click();
    }

    public void clickPilihButton(){
        driver.findElement(By.xpath("//div[text()='Pilih']")).click();
    }

    public boolean isOTPNumberPage() {
        return driver.findElement(By.xpath("//div[text()='Verifikasi']")).isDisplayed();
    }


    ////////////////////////////////////////////////////////////////////////////////////////////
    // OTP NUMBER
    ////////////////////////////////////////////////////////////////////////////////////////////
    /// 
    
    public void clickOTPNumber(char digit){
        driver.findElement(By.cssSelector("[data-testid='num-" + digit + "']")).click();
    }

    public boolean isPinPage(){
        return driver.findElement(By.xpath("//div[text()='Masukkan PIN Kamu']")).isDisplayed();
    }

    public void clickLanjutButton(){
        driver.findElement(By.cssSelector("button[data-content='Lanjut']")).click();
    }

    public boolean isSearchButton(){
        return driver.findElement(By.cssSelector("[data-testid='tabbar-explore']")).isDisplayed();
    }
    
    public void clickSearchButton(){
        driver.findElement(By.cssSelector("[data-testid='tabbar-explore']")).click();
    }

    public void clickSearchFieldTrigger() {
        driver.findElement(By.xpath("//p[text()='Cari produk investasi']")).click();
    }
    
    public boolean isSearchInputVisible() {
        return driver.findElement(By.cssSelector("input[placeholder*='Cari']")).isDisplayed();
    }

    public void fillInSearchField(String text) {
        WebElement input = driver.findElement(By.cssSelector("input[placeholder*='Cari']"));
        input.clear();
        input.sendKeys(text);
    }

    public boolean isGotoTextVisible(String text) {
        return driver.findElement(By.xpath("//div[text()[contains(., '"+text+"')]]")).isDisplayed();
    }
}
