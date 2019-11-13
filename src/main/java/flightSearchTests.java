import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class flightSearchTests {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://www.justdial.com/");

            //Wait for element - //a[@title="Book Train Tickets Online"]
            WebDriverWait wait = new WebDriverWait(driver, 3);


            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title=\"Book Train Tickets Online\"]")));
            driver.findElement(By.xpath("//a[@title=\"Book Train Tickets Online\"]")).click();

            //Enter Source
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder=\"Select Station\"]")));

            //driver.findElement(By.xpath("//*[@placeholder=\"Select Station\"]")).sendKeys("PUNE"+Keys.ARROW_DOWN+Keys.ENTER);
            driver.findElement(By.xpath("//*[@placeholder=\"Select Station\"]")).sendKeys("PUNE");
            driver.findElement(By.xpath("//*[@placeholder=\"Select Station\"]")).sendKeys(" JUNCTION");
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.xpath("//*[@placeholder=\"Select Station\"]")).sendKeys(Keys.ARROW_DOWN);
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.xpath("//*[@placeholder=\"Select Station\"]")).sendKeys(Keys.ENTER);

            //Enter Destination
            driver.findElement(By.xpath("//*[@id=\"to_stn\"]")).sendKeys("BDTS");
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.xpath("//*[@id=\"to_stn\"]")).sendKeys(Keys.ARROW_DOWN);
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.xpath("//*[@id=\"to_stn\"]")).sendKeys(Keys.ENTER);

            //Enter Dates Programatically (Skip date picker) - //*[@id="departDate"] - document.getElementById('departDate').value = 'blah'
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("document.getElementById('departDate').value = 'Tue,31-Dec-2019'");

            driver.findElement(By.xpath("//button[text()='Search']")).click();

        }
        catch (Exception e){
            System.err.println("Exception"+e.getLocalizedMessage());
            e.printStackTrace();
        }
        finally {
            driver.close();
            driver.quit();

        }
    }
}
