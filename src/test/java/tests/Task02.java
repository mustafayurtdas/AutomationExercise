package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task02 extends TestBase {
    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Delete Account' button
10. Verify that 'ACCOUNT DELETED!' is visible
     */

    @Test
    public void login() {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Signup / Login' button
        WebElement login = driver.findElement(By.xpath("//a[@href='/login']"));
        login.click();

        //5. Verify 'Login to your account' is visible
        WebElement loginText = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginText.isDisplayed());

        //6. Enter correct email address and password
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("abc@example.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345");

        //7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        //8. Verify that 'Logged in as username' is visible
        boolean loggedInAs = driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed();
        Assert.assertTrue(loggedInAs);

        //9. Click 'Delete Account' button
//        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();

        //10. Verify that 'ACCOUNT DELETED!' is visible
//        boolean accountDeleted = driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed();
//        Assert.assertTrue(accountDeleted);
    }
}
