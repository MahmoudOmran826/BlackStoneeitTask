package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    //    Variables
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //Locators
    private By inputEmailSelector = By.id("mat-input-0");
    private By inputPasswordSelector = By.id("mat-input-1");
    private By btnLoginSelector = By.className("block");
    private By loginTitleSelector = By.xpath("//h3[text()='Sign In']");


    //Methods
    public LoginPage enterEmail(String email) {
        wait.until(ExpectedConditions.presenceOfElementLocated(inputEmailSelector));
        driver.findElement(inputEmailSelector).clear();
        driver.findElement(inputEmailSelector).sendKeys(email);
        return new LoginPage(driver);
    }
    public LoginPage enterPassword(String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(inputPasswordSelector));
        driver.findElement(inputPasswordSelector).clear();
        driver.findElement(inputPasswordSelector).sendKeys(password);
        return new LoginPage(driver);
    }
    public AdminPage clickLoginBtn(){
        WebElement element;
        int i=0;
        do {
            element=wait.until(ExpectedConditions.elementToBeClickable(btnLoginSelector));
            driver.findElement(btnLoginSelector).click();
            i++;
        }while (element==null&&i<=3);
        return new AdminPage(driver);
    }
    public String getLoginPageTitle(){
        return driver.getTitle();
    }
}