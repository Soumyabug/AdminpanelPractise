package org.Soumya;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CreditCoin {
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
        // handle credit button
        driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
        System.out.println(driver.findElement(By.className("modal-header")).getText());//grabing the header of the popup

        driver.findElement(By.xpath("//input[@value='GAME']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='WIN']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='GAME']")).click();// selecting radio button
        //entering coin
        String coin = "20";
        driver.findElement(By.xpath("//input[@type='number']")).sendKeys(coin);
        //selecting reason
        WebElement reasonDropdown = driver.findElement(By.xpath("//div[@role='dialog']//div//div//div//div//select"));
        reasonDropdown.click();
        Thread.sleep(2000);
        Select reason = new Select(reasonDropdown);
        reason.selectByValue("PhonePay");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@type='button'])[51]")).click();
        Thread.sleep(2000);

        //verify if the coins are credited
        driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
        Set<String> windowes = driver.getWindowHandles();//get all the windows present
        Iterator<String> it = windowes.iterator();// iterate through all the windows
        String parentId = it.next(); //user details
        //   String childId = it.next();  //user transaction history
        String childtwoId = it.next();//user game history
        //user transaction history
        driver.switchTo().window(childtwoId);
        System.out.println(driver.findElement(By.className("page-title")).getText());
        Thread.sleep(3000);

        WebElement amount = driver.findElement(By.xpath("(//div[@role='cell'])[5]"));
        String finalAmount = amount.getText().substring(2, amount.getText().length());
        System.out.println(finalAmount);
        //verify amount
        if (coin.equals(finalAmount)) {
            System.out.println("Amount Verified");
        } else {
            System.out.println("Test Failed");
        }
        Thread.sleep(3000);
//        WebElement walletType = driver.findElement(By.id("cell-6-13106601"));
//        System.out.println(walletType.getText());
//        WebElement reasonType = driver.findElement(By.id("cell-10-13106601"));
//        System.out.println(reasonType.getText());
//        WebElement status = driver.findElement(By.id("cell-11-13106601"));
//        System.out.println(status.getText());
//        WebElement details = driver.findElement(By.id("cell-9-13106601"));
//        System.out.println(details.getText());




    }
}
