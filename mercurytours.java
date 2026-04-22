import org.openqa.selenium.*;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;

public class mercurytours {
@Test
    public void formautomation()
    {
        WebDriver driver = new EdgeDriver();

        driver.get("https://demo.guru99.com/test/newtours/register.php");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String PageTitle = driver.getTitle();

        System.out.println("The title of the page is "+PageTitle);

        TakesScreenshot takefirst = (TakesScreenshot) driver;

        File source_one = takefirst.getScreenshotAs(OutputType.FILE);

        File destination_one = new File("C:\\Users\\amit29\\OneDrive - Discovery\\Documents\\AmitChanna\\SeleniumTestReports\\screenshotone.jpg");
        try {

            FileUtils.copyFile(source_one, destination_one);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Capture the mailing information

        WebElement country = driver.findElement(By.name("country"));

        Select select = new Select(country);

        select.selectByVisibleText("ARUBA");

        driver.findElement(By.name("city")).sendKeys("Dewfresh");

        driver.findElement(By.name("state")).sendKeys("Albania");

        driver.findElement(By.name("postalCode")).sendKeys("2196");

        driver.findElement(By.name("address1")).sendKeys("Unit 2026, Moor Park, Katherine West");

        // Capture the Contact Information

        driver.findElement(By.name("firstName")).sendKeys("Amit");

        driver.findElement(By.name("lastName")).sendKeys("Channa");

        driver.findElement(By.name("phone")).sendKeys("0643733837");

        driver.findElement(By.id("userName")).sendKeys("amitchanna@gmail.com");

        //Submit the information

        driver.findElement(By.name("submit")).click();

        String registrationcomplete = "Thank you for registering.";

        if(driver.getPageSource().contains(registrationcomplete))
        {
            System.out.println("The test case is passed");
        }
        else
        {
            System.err.println("The test case is failed");
        }



    }
}
