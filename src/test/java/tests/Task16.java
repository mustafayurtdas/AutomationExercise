package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task16 extends TestBase {
    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Signup / Login' button
5. Fill email, password and click 'Login' button
6. Verify 'Logged in as username' at top
7. Add products to cart
8. Click 'Cart' button
9. Verify that cart page is displayed
10. Click Proceed To Checkout
11. Verify Address Details and Review Your Order
12. Enter description in comment text area and click 'Place Order'
13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
14. Click 'Pay and Confirm Order' button
15. Verify success message 'Your order has been placed successfully!'
16. Click 'Delete Account' button
17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
     */

    @Test
    public void name() throws InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//html"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Signup / Login' button
        WebElement login = driver.findElement(By.xpath("//a[@href='/login']"));
        login.click();

        //5. Fill email, password and click 'Login' button
        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("abc@example.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345");
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        //6. Verify that 'Logged in as username' is visible
        boolean loggedInAs = driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed();
        Assert.assertTrue(loggedInAs);

        //7. Add products to cart
        action.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

        //8. Click 'Cart' button
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();

        //9. Verify that cart page is displayed
        Assert.assertTrue(
                driver.
                        findElement(By.xpath("//*[text()='Shopping Cart']")).
                        isDisplayed()
        );

        //10. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")).click();

        //11. Verify Address Details and Review Your Order
        Assert.assertTrue(
                driver.findElement(By.xpath("//h2[text()='Address Details']")).isDisplayed()
                        &&
                        driver.findElement(By.xpath("//h2[text()='Review Your Order']")).isDisplayed()
        );

        //12. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//*[@name='message']")).sendKeys("any comment");
        driver.findElement(By.linkText("Place Order")).click();

        //13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //14. Click 'Pay and Confirm Order' button
        driver.navigate().back();
        driver.navigate().forward();

        driver.findElement(By.xpath("//input[@data-qa='name-on-card']")).sendKeys("Mustafa");
        action.
                sendKeys(Keys.TAB,"1234567890123456").
                sendKeys(Keys.TAB,"311").
                sendKeys(Keys.TAB,"12").
                sendKeys(Keys.TAB,"2030").
                sendKeys(Keys.TAB,Keys.ENTER).
                build().
                perform();


        //15. Verify success message 'Your order has been placed successfully!'
        Assert.assertTrue(
                driver.findElement(By.xpath("//b[text()='Order Placed!']")).
                        isDisplayed());

        //16. Click 'Delete Account' button
        //17. Verify 'ACCOUNT DELETED!' and click 'Continue' button

    }
}
