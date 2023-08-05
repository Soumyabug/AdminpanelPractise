package org.Soumya;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LinkCount {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("web-driver.chrome.driver", "C:\\Chromedriver\\chromedriver_win32 (1)\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--remote-allow-origins=*"});
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        driver.get("http://192.168.0.106:3001/");

        WebElement mobile = driver.findElement(By.xpath("//input[@id='u-id']"));
        mobile.sendKeys(new CharSequence[]{"7980752165"});
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys(new CharSequence[]{"123456789"});
        driver.findElement(By.cssSelector("button[type='submit']")).click();//login

        driver.findElement(By.xpath("//span[normalize-space()='User Manage']")).click();//user manage
        driver.findElement(By.xpath("//a[normalize-space()='User Detail']")).click();//user detail

        int count = driver.findElements(By.tagName("a")).size();
        System.out.println(count);
        WebElement pageLink = driver.findElement(By.id("cell-9-520001"));
        System.out.println(pageLink.findElements(By.tagName("a")).size());


        String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

        pageLink.findElements(By.tagName("a")).get(0).sendKeys(clickonlinkTab);
        pageLink.findElements(By.tagName("a")).get(1).sendKeys(clickonlinkTab);
        Thread.sleep(2000);

        Set<String> windowes = driver.getWindowHandles();//get all the windows present
        Iterator<String> it = windowes.iterator();// iterate through all the windows
        String parentId = it.next(); //user details
        String childId = it.next();  //user transaction history
        String childtwoId = it.next();//user game history

        //going to user game-history
        driver.switchTo().window(childtwoId);
        System.out.println(driver.findElement(By.className("page-title")).getText());
        Thread.sleep(3000);
        //going to user transaction history
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.className("page-title")).getText());
        Thread.sleep(3000);
        //coming back to userDetailPage
        driver.switchTo().window(parentId);
        System.out.println(driver.findElement(By.className("page-title")).getText());


    }
}


