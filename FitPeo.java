// import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// import org.testng.Assert;

import org.testng.annotations.Test;

@Test

public class FitPeo {

        WebDriver driver;
        // System.out.println("invalid username and password");

        // System.out.println("invalid Empty");

        @Test
        public void testGoogleTitle() throws InterruptedException {
                System.out.println("Login SucessFully...!");
                Thread.sleep(3000);
                ChromeOptions options = new ChromeOptions();
                System.setProperty("webdriver.chrome.driver",
                                "/home/madhanagopal/Desktop/Automation/Selenium/fitpeo/src/test/java/chromedriver-linux64/chromedriver");
                options.addArguments("--disable-web-security");

                WebDriver driver = new ChromeDriver(options);

                driver.get("https://www.fitpeo.com/");
                driver.manage().window().maximize();

                Thread.sleep(3000);

                // Find the link or button to navigate to the Revenue Calculator page
                // Example using a link text
                WebElement revenueCalculatorLink = driver.findElement(By.linkText("Revenue Calculator"));

                // Click the link to navigate to the Revenue Calculator page
                revenueCalculatorLink.click();

                // Click the link to navigate to the Revenue Calculator page

                // Add any additional steps for verification or interaction on the Revenue
                // Calculator page
                System.out.println("Navigated to the Revenue Calculator page successfully.");
                Thread.sleep(3000);
                Actions actions = new Actions(driver);

                actions.sendKeys(Keys.PAGE_DOWN).perform();
                ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,50)");

                // // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                WebElement slider = driver.findElement(By.cssSelector("input[type='range']"));

                // Get the slider attributes
                int maxValue = Integer.parseInt(slider.getAttribute("max")); // 2000
                int minValue = Integer.parseInt(slider.getAttribute("min")); // 0
                int targetValue = 9399;

                // Calculate the width of the slider and the necessary offset
                int sliderWidth = slider.getSize().getWidth();
                int offset = (int) ((double) (targetValue - minValue) / (maxValue - minValue) * sliderWidth);

                // Simulate the dragging action using Actions class
                actions.clickAndHold(slider).moveByOffset(offset, 0).release().perform();
                // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                JavascriptExecutor js = (JavascriptExecutor) driver;

                // WebElement slider = driver.findElement(By.cssSelector(".css-16i48op"));
                Thread.sleep(4000);

                WebElement sliders = driver.findElement(By.id(":r0:")); // Update selector as needed

                // Set the value of the slider using JavaScript
                js.executeScript("arguments[0].value = 560;", sliders); // Adjust 1500 as needed

                // Optionally, trigger a change event
                js.executeScript("arguments[0].dispatchEvent(new Event('change'));", sliders);

                // button/span

                WebElement AllocationQty = driver
                                .findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/label/span[1]/input"));
                AllocationQty.click();

                WebElement AllocationQtys = driver
                                .findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/label/span[1]/input"));
                AllocationQtys.click();

                WebElement AllocationQtyss = driver
                                .findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[3]/label/span[1]/input"));
                AllocationQtyss.click();

        }

}
