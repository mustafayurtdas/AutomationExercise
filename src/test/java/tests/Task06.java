package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Task06 extends TestBase {
    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
     */

    @Test
    public void contactUs() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Contact Us' button
        WebElement contactUS = driver.findElement(By.xpath("//*[text()=' Contact us']"));
        contactUS.click();

        //5. Verify 'GET IN TOUCH' is visible
        Assert.assertTrue(
                driver.findElement(By.xpath("//*[text()='Get In Touch']")).
                        isDisplayed());

        //6. Enter name, email, subject and message
        //7. Upload file
        //8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@data-qa='name']")).click();
        action.
                sendKeys("Mustafa",Keys.TAB).
                sendKeys("abc@example.com",Keys.TAB).
                sendKeys("deneme",Keys.TAB).
                sendKeys("deneme bir ki",Keys.TAB).
                sendKeys("C:\\Users\\Mustafa\\Desktop>test",Keys.TAB,Keys.ENTER).
                perform();

        //9. Click OK button
        driver.switchTo().alert().accept();

        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement success = driver.findElement(By.xpath("//*[@class='status alert alert-success']"));
        String expectedResult = "Success! Your details have been submitted successfully.";
        Assert.assertEquals(expectedResult,success.getText());

        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
        Assert.assertTrue(
                driver.
                        findElement(By.xpath("//*[@id='slider']")).
                        isDisplayed());

    }
}
