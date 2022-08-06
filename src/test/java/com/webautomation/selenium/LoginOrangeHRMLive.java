package com.webautomation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginOrangeHRMLive {
    /*
    1. Open a browser
    2. Open URL (https://opensource-demo.orangehrmlive.com/)
    3. Enter User Name
    4. Enter password
    5. Click on login button
    6. Check the page title
    */
    public static void main(String[] args) {
        LoginOrangeHRMLive loginOrangeHRMLive = new LoginOrangeHRMLive();
        loginOrangeHRMLive.setUp();

        WebDriver driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        WebElement userName = driver.findElement(By.cssSelector("input#txtUsername"));
        WebElement password = driver.findElement(By.cssSelector("input#txtPassword"));
        WebElement loginButton = driver.findElement(By.cssSelector("input#btnLogin"));
        userName.sendKeys("Admin");
        password.sendKeys("admin123");
        loginButton.click();
        String actualHomePageTitle = driver.getTitle();
        System.out.println("Application login successfully");
        System.out.println("Home Page Title is: " + actualHomePageTitle);
        try {
            if (actualHomePageTitle.equals("OrangeHRM")) {
                System.out.println("Home Page Title found, Test Case passed");
            }
        } catch (Exception e) {
            System.out.println("Home Page Title: " + actualHomePageTitle + "Not found");
        }
        driver.quit();
    }

    public void setUp() {
        String homeDirectory = System.getProperty("user.dir");
//      System.out.println("home Directory is: " + " " + homeDirectory);
        String driverLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\Driver\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", driverLocation);
    }

}
