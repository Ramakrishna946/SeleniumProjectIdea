

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class CalendarAutomation {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();// Set up WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Open site with date picker (example: MakeMyTrip)
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");//https://www.makemytrip.com/

        //driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();

        // Close any pop-up (if exists)
        try {
            WebElement popup = driver.findElement(By.cssSelector("span.ic_circularclose_grey"));
            popup.click();
        } catch (Exception e) {
            System.out.println("No popup found.");
        }

        // Click on "Departure" date field to open calendar
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement departureInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='ctl00$mainContent$view_date1']")));
        departureInput.click();
//        WebElement departDate = driver.findElement(By.xpath("//input[@id='departure']"));
//        departDate.click();

        // Target date
        String targetMonth = "October 2025";
        String targetDay = "27";

        // Loop until correct month is visible
        while (true) {
            String displayedMonth = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();

            if (displayedMonth.equalsIgnoreCase(targetMonth)) {
                break;
            } else {
                // Click Next button
                driver.findElement(By.xpath("//a[@data-handler='next']")).click();
            }
        }

        // Select the day
        driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='" + targetDay + "']")).click();

        System.out.println("Date Selected: " + targetDay + " " + targetMonth);
        driver.switchTo().newWindow(WindowType.TAB);

        // Close browser
        driver.quit();
    }
}

