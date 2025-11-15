

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v132.page.model.Screenshot;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class apsrtctesting {
    public static void main(String[]args) throws InterruptedException, IOException	{
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.apsrtconline.in/oprs-web/guest/home.do?h=1");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement from=driver.findElement(By.xpath("//input[@id='fromPlaceName']"));
        from.sendKeys("ong");
        Thread.sleep(2000);
        List<WebElement> suggestions1= driver.findElements(By.cssSelector("li[role='presentation']"));
        String fromloc="ONGOLE";
        boolean toFound = false;
        for(WebElement loc: suggestions1) {
            if(loc.getText().contains(fromloc)) {
                String text=loc.getText();
                loc.click();
                System.out.println(" FROM:-"+text);
                toFound=true;
                break;

            }
        }
        if(!toFound) {
            System.out.println( " The from location entered is not availiable");
        }

        driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(2000);

        WebElement to=driver.findElement(By.xpath("//input[@name='destination']"));
        to.sendKeys("hyd");
        Thread.sleep(2000);
        List<WebElement> suggestions2= driver.findElements(By.xpath("//li[@role='presentation']"));
        String toloc="HYDERABAD";

        for(WebElement loc1: suggestions2) {
            if(loc1.getText().contains(toloc)) {
                String text=loc1.getText();
                loc1.click();
                System.out.println(" TO:-"+text);
                toFound=true;
                break;
            }
        }
        if(!toFound) {
            System.out.println("The To location entered is not availiable");
        }


        String targetMonth="November 2025";
        String targetday="10";

        driver.findElement(By.xpath("//input[@id='txtJourneyDate']")).click();

        while(true) {
            String displayedMonth=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
            if(displayedMonth.equalsIgnoreCase(targetMonth)) {
                break;
            }else {
                driver.findElement(By.xpath("//a[@data-handler='next']")).click();
            }
        }
        driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='" + targetday + "']")).click();

        System.out.println("Date of Journey on  Selected this: " + targetday + " " + targetMonth);

        driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div/span[@class='popClose']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@class='selectBox selectBoxs']")).click();
        driver.findElement(By.xpath("//label[@class='selectOption']")).click();
        driver.findElement(By.xpath("//div[@class='selectBox selectBoxs'][contains(normalize-space(),'Boarding Points')]")).click();
        driver.findElement(By.xpath("//label[@class='selectOption'][contains(normalize-space(),'ONGOLE')]")).click();
        driver.findElement(By.xpath("//div[@class='selectBox selectBoxs'][contains(normalize-space(),'Dropping Points')]")).click();
        driver.findElement(By.xpath("//label[@class='selectOption'][contains(normalize-space(),'HYDERABAD MGBS')]")).click();
        String serviceno="5019";
        String droploc="BHEL-LINGAMPALLY - 06:15";
        String name="Ram";
        String age="28";
        String mobno="8868649198";
        String email="example@gmail.com";
        driver.findElement(By.xpath("//div[@class='col1' ][contains(normalize-space(),'"+serviceno+"')]/following-sibling::div//input[@name='SrvcSelectBtnForward']")).click();
        WebElement droppnt=driver.findElement(By.id("ForwardDroppingId"));
        Select select= new Select(droppnt);
        select.selectByIndex(6);
        driver.findElement(By.xpath("//input[@name='OnwardLayoutBtn']")).click();
        driver.findElement(By.xpath("//li[@class='availSeatClassS']")).click();
        driver.findElement(By.xpath("//input[@id='mobileNo']")).sendKeys(mobno);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
        WebElement gender=driver.findElement(By.id("genderCodeIdForward0"));
        Select sel=new Select(gender);
        sel.selectByIndex(1);
        driver.findElement(By.id("passengerNameForward0")).sendKeys(name);
        driver.findElement(By.id("passengerAgeForward0")).sendKeys(age);
        WebElement consesion=driver.findElement(By.id("concessionIdsForward0"));
        Select sel1= new Select(consesion);
        sel1.selectByIndex(1);
        driver.findElement(By.id("BookNowBtn")).click();
        Thread.sleep(2000);
        File src=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String timestamp= new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());
        FileUtils.copyFile(src, new File("C:\\Users\\chkri\\git\\repository2\\Practice\\SeleniumPractice\\Screenshots\\Screenshot_" + timestamp + ".png"));
        ru.yandex.qatools.ashot.Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(2000))  // scrolls and stitches
                .takeScreenshot(driver);

        ImageIO.write(screenshot.getImage(), "PNG", new File("FullPage"+ timestamp +".png"));


        driver.close();
    }

}

