package com.Przemek.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Testy {

    @Test
    public void Test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.warcraftlogs.com/");

        List<WebElement> cookieButtons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[@mode='secondary']")));
        cookieButtons.get(0).click();
        WebElement search = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='searchfield-mini']")));
        search.sendKeys("Pudzianos");
        List<WebElement> chooseFirst = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[@class='ui-menu-item']")));
        chooseFirst.get(0).click();
        WebElement raids = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id = \"filter-zone-text\"]")));
        raids.click();
        List<WebElement> zoneList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[contains(@id,\"zone\")]")));
        int zoneListSize = zoneList.size() - 2;
        //int randomNumber = ThreadLocalRandom.current().nextInt(0, zoneListSize);
        int randomNumber = 2;
        zoneList.get(randomNumber).click();
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class = \"zone-table-and-loading-container\"]")));
        List<WebElement> bossesNameForSize = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[contains(@class,\"Boss zone-boss-cell\")]")));
        int bossesSize = bossesNameForSize.size();
        //String bossNameByOrder = bossesName.get(0).getText();
        //String parsePercent = bossesParse.get(0).getText();
        System.out.println("Boss name " + "|" + " Parse");
        //System.out.println(bossNameByOrder + " " + parsePercent);

        for (int x = 0; x < bossesSize; x++) {
            List<WebElement> bossesParse = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//td[contains(@class,\"rank-percent hist\")]")));
            List<WebElement> bossesName = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(@class,\"Boss zone-boss-cell\")]")));
            String bossNameByOrder = bossesName.get(x).getText();
            String parsePercent = bossesParse.get(x).getText();
            System.out.println(bossNameByOrder + " " + parsePercent + " x = " + x + " bossesSize = " + bossesSize);
        }
        //driver.quit();

    }

}
