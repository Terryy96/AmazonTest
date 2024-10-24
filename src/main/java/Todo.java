import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import java.util.List;


public class Todo {
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;


    @BeforeEach
    public void BeforeTest() {
       String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/Drivers/chromedriver2.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }



    //The task:
    //Go to "https://amazon.in"
    //Search for:
    //Search: "Wrist Watches"
    //Display: "Analogue"
    //Brands Material: "Leather"
    //Brand: "Titan"
    //Discount: "25% Off or more"
    //Get the Fifth Element from the search
    @Test
    public void Test1() throws InterruptedException {
        driver.navigate().to("https://amazon.in");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Wrist Watches");
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(3000);

        //select Display Type
        Actions actions = new Actions(driver);
        WebElement watchDisplayType = driver.findElement(By.id("p_n_feature_seven_browse-bin-title"));
        actions.scrollToElement(watchDisplayType);
        WebElement analogue =driver.findElement(By.xpath("//*[@id=\"p_n_feature_seven_browse-bin/1480900031\"]/span/a/div/label/i"));
        analogue.click();

        //select Band Material
        Thread.sleep(3000);
        WebElement watchBandMaterial = driver.findElement(By.id("p_n_feature_fourteen_browse-bin/11142591031"));
        actions.scrollToElement(watchBandMaterial);
        WebElement leather = driver.findElement(By.xpath("//*[@id=\"p_n_material_browse/1480907031\"]/span/a/div/label/i"));
        leather.click();

        //select Brand
        Thread.sleep(3000);
        WebElement brandTitan = driver.findElement(By.xpath("//*[@id=\"p_123/230208\"]/span/a/div/label/i"));
        brandTitan.click();

        //select 25 % discount
        Thread.sleep(3000);
        WebElement discount = driver.findElement(By.xpath("//div[@id='p_n_pct-off-with-tax/2665398031']"));
        actions.scrollToElement(discount);
        Thread.sleep(1000);
        WebElement selectedDiscount = driver.findElement(By.xpath("//span[contains(text(),'25% Off or more')]"));
        selectedDiscount.click();

        //select fifth element
        Thread.sleep(2000);
        WebElement fifthElement = driver.findElement(By.
                xpath("/descendant::div[@class=\"s-product-image-container aok-relative s-text-center s-image-overlay-grey puis-image-overlay-grey s-padding-left-small s-padding-right-small puis-spacing-small s-height-equalized puis puis-v2znmscl0pr10o2h2wghk61cb1h\"][5]"));
        fifthElement.click();
    }

    @AfterEach
    public void afterClass () {
            driver.quit();
        }
    }

