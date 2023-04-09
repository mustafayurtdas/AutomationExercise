package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;

public class Task01 extends TestBase {
    /*
  1. Launch browser
  2. Navigate to url 'http://automationexercise.com'
  3. Verify that home page is visible successfully
  4. Click on 'Signup / Login' button
  5. Verify 'New User Signup!' is visible
  6. Enter name and email address
  7. Click 'Signup' button
  8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
  9. Fill details: Title, Name, Email, Password, Date of birth
  10. Select checkbox 'Sign up for our newsletter!'
  11. Select checkbox 'Receive special offers from our partners!'
  12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
  13. Click 'Create Account button'
  14. Verify that 'ACCOUNT CREATED!' is visible
  15. Click 'Continue' button
  16. Close the advertise and Verify that 'Logged in as username' is visible
  17. Click 'Delete Account' button
  18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
           */
    @Test
    public void signUp(){
        //   2. Navigate to url 'http://automationexercise.com'

        driver.navigate().to("http://automationexercise.com");

        //   3. Verify that home page is visible successfully

        WebElement homePage = driver.findElement(By.xpath("//html"));

        Assert.assertTrue(homePage.isDisplayed());

        //   4. Click on 'Signup / Login' button
        WebElement login = driver.findElement(By.xpath("//a[@href='/login']"));
        login.click();

        //   5. Verify 'New User Signup!' is visible

        WebElement loginHeader = driver.findElement(By.xpath("//*[@class='signup-form']/h2"));
        // String expectedHeader = "New User Signup!";
        // Assert.assertEquals(expectedHeader,loginHeader.getText());
        Assert.assertTrue(loginHeader.isDisplayed());

        //   6. Enter name and email address
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Mustafa");
        driver.findElement(By.xpath("(//*[@name='email'])[2]")).sendKeys("abc@example.com");

        //   7. Click 'Signup' button
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();

        //   8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.
                findElement(By.cssSelector("div[class='login-form'] h2 b")).
                isDisplayed());

        //   9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.cssSelector("label[for='id_gender1']")).click(); // Title
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("12345");

        WebElement days = driver.findElement(By.xpath("//select[@id='days']"));
        Select date = new Select(days);
        date.selectByValue("11");

        WebElement months = driver.findElement(By.xpath("//select[@id='months']"));
        Select month = new Select(months);
        month.selectByVisibleText("April");

        WebElement years = driver.findElement(By.xpath("//select[@id='years']"));
        Select year = new Select(years);
        year.selectByValue("1986");

        //   10. Select checkbox 'Sign up for our newsletter!'

        action.click().sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();

        WebElement newsletterCheckbox = driver.findElement(By.name("newsletter"));
        newsletterCheckbox.click();


        //   11. Select checkbox 'Receive special offers from our partners!'
        WebElement partnerOffersCheckbox = driver.findElement(By.name("optin"));
        partnerOffersCheckbox.click();

        //   12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.cssSelector("input[id='first_name']")).sendKeys("Mustafa");
        driver.findElement(By.cssSelector("input[id='last_name']")).sendKeys("Yurtdaş");
        driver.findElement(By.cssSelector("input[id='company']")).sendKeys("Company");
        driver.findElement(By.cssSelector("input[id='address1']")).sendKeys("Ankara");
        driver.findElement(By.cssSelector("input[id='address2']")).sendKeys("Istanbul");

        Select country = new Select(driver.findElement(By.cssSelector("select[id='country']")));
        country.selectByIndex(1);

        action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.cssSelector("input[id='state']")).sendKeys("Florida");
        driver.findElement(By.cssSelector("input[id='city']")).sendKeys("Miami");
        driver.findElement(By.cssSelector("input[id='zipcode']")).sendKeys("06100");
        driver.findElement(By.cssSelector("input[id='mobile_number']")).sendKeys("534444324");

        //   13. Click 'Create Account button'

        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        //   14. Verify that 'ACCOUNT CREATED!' is visible
        boolean accountCreated = driver.findElement(By.xpath("//b[text()='Account Created!']")).isDisplayed();
        Assert.assertTrue(accountCreated);

        //   15. Click 'Continue' button
        driver.findElement(By.linkText("Continue")).click();

        //   16. Verify that 'Logged in as username' is visible
        boolean loggedInAs = driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed();
        Assert.assertTrue(loggedInAs);

    }

    @Test
    public void deleteAccount() {
        driver.navigate().to("http://automationexercise.com");

        WebElement login = driver.findElement(By.xpath("//a[@href='/login']"));
        login.click();

        driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("abc@example.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345");
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        //   17. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).

                click();

        //   18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        boolean accountDeleted = driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed();
        Assert.assertTrue(accountDeleted);
    }
}
