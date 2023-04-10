package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task07 extends TestBase {
    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Test Cases' button
5. Verify user is navigated to test cases page successfully
     */

    @Test
    public void tastCaseTest() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Test Cases' button
        driver.findElement(By.xpath("//a[text()=' Test Cases']")).click();

        //5. Verify user is navigated to test cases page successfully
        Assert.assertTrue(
                driver.findElement(By.xpath("//*[text()='Test Cases']")).
                        isDisplayed()
        );

    }
}
