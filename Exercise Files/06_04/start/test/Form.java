import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

public class Form {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:/Users/Acer/Downloads/chromedriver_win/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/form");

        FormPage formPage = new FormPage();
        formPage.submitForm(driver);

        ComfirmationPage comfirmationPage = new ComfirmationPage();
        comfirmationPage.waitForAlertBanner(driver);

        assertEquals("The form was successfully submitted!",
                comfirmationPage.getAlertBannerText(driver));

        driver.quit();
    }

}
