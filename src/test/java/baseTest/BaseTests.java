package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pom.AdminPage;
import pom.LoginPage;

public class BaseTests {
    WebDriver driver;
    protected String email = "store@admin.com";
    protected String password = "P@ssw0rd";
    protected String expectedWelcomeMessage = "Welcome To Dashboard";
    protected String expectedLoginPageTitle = "Admin | Login";
    protected LoginPage loginPage;
    protected AdminPage adminPage;
    @BeforeTest
    public void setup(){
//        Driver initialization
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        loginPage= new LoginPage(driver);
        adminPage = new AdminPage(driver);
        driver.manage().window().maximize();
//        Login to Website URL
        driver.get("https://oyn-adminportal-qc-demo.salmonsky-1edff179.westeurope.azurecontainerapps.io/identity/login");

    }
    @AfterTest
    public void tearDown(){
//  Close the browser.
        driver.quit();
    }
}
