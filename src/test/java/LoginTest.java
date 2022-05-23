import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.ztrain.web.pageObjects.HomePage;
import com.ztrain.web.pageObjects.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class LoginTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    public void setup() {
        String path = "D:\\logi\\webdrivers\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //this.loginPage = new LoginPage(this.driver, this.wait);
        //this.homePage = new HomePage(this.driver, this.wait);
    }

    @AfterMethod
    public void teardown() {
        this.driver.quit();
    }

    /*@Test
    public void loginUsingValidCredentials() {
        this.loginPage.goToLoginPage();
        this.loginPage.login("sehajpreet2.nicholi@orperfect.com", "hqqps2J$");

        this.wait.until(ExpectedConditions.urlContains("home"));
        assertTrue(this.homePage.isZtrainLogoDisplayed());
    }*/

    /*@Test
    public void loginUsingInvalidPassword() {
        LoginPage loginPage = new LoginPage(this.driver, this.wait);
        loginPage.goToLoginPage();
        loginPage.login("sehajpreet2.nicholi@orperfect.com", "123456789");
        this.wait.until(ExpectedConditions.urlContains("home"));
        assertFalse(this.driver.getCurrentUrl().contains("home"));
    }*/
}
