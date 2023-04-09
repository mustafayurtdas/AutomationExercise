package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task05 extends TestBase {
    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and already registered email address
7. Click 'Signup' button
8. Verify error 'Email Address already exist!' is visible
     */

    @Test
    public void alreadyExist() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Signup / Login' button
        WebElement login = driver.findElement(By.xpath("//a[@href='/login']"));
        login.click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignUp = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(newUserSignUp.isDisplayed());

        //6. Enter name and already registered email address
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Mustafa");
        driver.findElement(By.xpath("(//*[@name='email'])[2]")).sendKeys("abc@example.com");


        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();

        //8. Verify error 'Email Address already exist!' is visible
        WebElement already = driver.findElement(By.xpath("//p[text()='Email Address already exist!']"));
        Assert.assertTrue(already.isDisplayed());

    }
}
