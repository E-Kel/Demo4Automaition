package pages.signIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SLoginVerify {

    public static String checkLogin(String email, String pass, String fname, String lname) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200x600");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

        WebElement searchEmailLoginField = waitForElementLocatedBy(driver, By.xpath("//input[@id='email']"));
        WebElement searchPasswordLoginField = waitForElementLocatedBy(driver, By.xpath("//input[@id='passwd']"));
        WebElement searchLoginButton = waitForElementLocatedBy(driver, By.xpath("//p[@class='submit']//span[1]"));

        searchEmailLoginField.sendKeys(email);
        searchPasswordLoginField.sendKeys(pass);
        searchLoginButton.click();

        WebElement findUsername = waitForElementLocatedBy(driver, By.xpath("//span[contains(text(),'vcbxvbxcvbx xvbxcvbxcb')]"));

        String usernameText = findUsername.getText();
        driver.quit();
        return usernameText;


    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(by));

    }


}


