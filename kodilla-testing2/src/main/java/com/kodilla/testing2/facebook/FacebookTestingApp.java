package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {

    public static final String XPATH_WAIT_FOR_WINDOW_WITH_COOKIES = "//div[contains(@class, \"_4t2a\")]\n";
    public static final String XPATH_ACCEPT_ALL_COOKIES_BUTTON = "//div[contains(@class, \"_9xo5\")]/button[2]\n";
    public static final String XPATH_REGISTER_BUTTON = "//div[contains(@class, \"_6ltg\")]/a\n";
    public static final String XPATH_SELECT_DAY = "//div[contains(@class, \"_5k_5\")]/span/span/select[1]\n";
    public static final String XPATH_SELECT_MONTH = "//div[contains(@class, \"_5k_5\")]/span/span/select[2]\n";
    public static final String XPATH_SELECT_YEAR = "//div[contains(@class, \"_5k_5\")]/span/span/select[3]\n";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.com/");

        if (driver.manage().getCookies().size() == 0) {
            while (!driver.findElement(By.xpath(XPATH_WAIT_FOR_WINDOW_WITH_COOKIES)).isDisplayed());
            WebElement cookiesButton = driver.findElement(By.xpath(XPATH_ACCEPT_ALL_COOKIES_BUTTON));
            cookiesButton.click();
        }

        WebElement registerButton = driver.findElement(By.xpath(XPATH_REGISTER_BUTTON));
        registerButton.click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {

        }

        WebElement selectDay = driver.findElement(By.xpath(XPATH_SELECT_DAY));
        Select selDay = new Select(selectDay);
        selDay.selectByVisibleText("15");

        WebElement selectMonth = driver.findElement(By.xpath(XPATH_SELECT_MONTH));
        Select selMonth = new Select(selectMonth);
        selMonth.selectByVisibleText("mar");

        WebElement selectYear = driver.findElement(By.xpath(XPATH_SELECT_YEAR));
        Select selYear = new Select(selectYear);
        selYear.selectByVisibleText("2015");
    }
}
