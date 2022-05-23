import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class JunitTest {

    //Déclaration de la variable de classe de type webDriver
    private WebDriver driver;

    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        //Definition du chemin du chrome driver dans les pptés du syst
        String path = "D:\\logi\\webdrivers\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        //Association de l'instance de classe ChromeDriver au webDriver
        this.driver = new ChromeDriver();

        // Instanciation du Selenium WebDriverWait avec le WebDriver pour une durée de 5 secondes
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        // Définition de l'attente implicite du WebDriver à 10 secondes
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown() {
        //fermeture du navigateur
        this.driver.quit();
    }

    /*@Test
    public void loginTest() {
        //navigation vers l'url du site à tester
        this.driver.get("https://ztrain-web.vercel.app/auth/login");
        //Assertion sur le titre de la page de connexion
        assertEquals(this.driver.getTitle(), "");

        //Recherche d'élément avec l'objet By
        By usernameInputLocator= By.xpath("//*[@id='email_login']");
        WebElement userNameInput = this.driver.findElement(usernameInputLocator);

        By passwordInputLocator = By.xpath("//*[@id='password_login']");
        WebElement passwordInput = this.driver.findElement(passwordInputLocator);

        By submitButtonLocator = By.xpath("//*[@id='btn_login']");
        WebElement submitButton = this.driver.findElement(submitButtonLocator);

        // Définition de la valeur des input
        userNameInput.sendKeys("sehajpreet2.nicholi@orperfect.com");
        passwordInput.sendKeys("hqqps2J$");

        // Attente explicite de l'etat cliquable de l'élément submitButton
        this.wait.until(ExpectedConditions.elementToBeClickable(submitButton));

        // Clic sur un élément
        submitButton.click();
        this.wait.until(ExpectedConditions.urlContains("home"));

        By ztrainLogoLocator = By.xpath("//*[@id=\"style_content_logo__pkvMP\"]/h1");
        WebElement ztrainLogo = this.driver.findElement(ztrainLogoLocator);

        // Assertion sur le titre de la page d'accueil
        assertTrue(ztrainLogo.getText().equals("Z-Train"));

    }*/


}
