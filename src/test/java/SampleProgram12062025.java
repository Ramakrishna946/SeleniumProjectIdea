

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleProgram12062025 {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "localhost:9222");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        System.out.println("Connected to existing Chrome. Current tab url: " + driver.getCurrentUrl());

        // Open new tab using Selenium 4
        WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
        newTab.get("https://www.linkedin.com/in/ramakrishna-chintha-bbaa52136/");
        System.out.println("Connected to existing Chrome. Current tab title: " + driver.getCurrentUrl());
        System.out.println("New tab opened. Title: " + newTab.getTitle());

        driver.close();
    }
}
