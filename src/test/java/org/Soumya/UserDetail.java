package org.Soumya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UserDetail {
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
        // System.out.println(driver.findElement(By.xpath("//p[@class='page-title']")).getText());//verify present in user detail
        List<WebElement> userID = driver.findElements(By.cssSelector("[data-column-id$='2']"));
        List<String> userList = new ArrayList<>();
        // int count = userID.size();
        //System.out.println(count);

        for (WebElement user : userID) {
            userList.add(user.getText());

        }
        //System.out.println(currentList);
        String playerId = userList.get(4);
        System.out.println(playerId);//grabing player id form array
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='input-field-data-search']")).sendKeys(playerId);
        driver.findElement(By.xpath("//button[@class='btn btn-search icon-only']")).click();//searching the playerId
        Thread.sleep(5000);
        String confirm = driver.findElement(By.xpath("//div[@id='cell-2-520000']")).getText();
        Assert.assertEquals(confirm, playerId); //verify if the searched id is same
        Thread.sleep(3000);
        //userID SEARCH

        driver.findElement(By.xpath("//a[@class='d-flex justify-content-between align-items-center']")).click();//view user detail
        Thread.sleep(2000);
        driver.navigate().back();//come back

        List<WebElement> mobileNo = driver.findElements(By.cssSelector("[data-column-id$='4']"));//grabing mobile numbers
        List<String> mobiList = new ArrayList<>();
        for (WebElement mobileNumber : mobileNo) {
            mobiList.add(mobileNumber.getText());
        }
        String finalmobileNo = mobiList.get(6);
        System.out.println(finalmobileNo);
        driver.findElement(By.xpath("//input[@id='input-field-data-search']")).sendKeys(finalmobileNo);
        driver.findElement(By.xpath("//button[@class='btn btn-search icon-only']")).click();//search mobile numbers
        Thread.sleep(2000);
        //Mobile number search

        driver.findElement(By.cssSelector("button[class='btn btn-ui export-btn btn-primary ms-10 text-only']")).click();//reseting page

        WebElement filter = driver.findElement(By.xpath("//div[@class='filter dropdown']"));//clicking dropdown
        filter.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Active']")).click();//active user list
        Thread.sleep(2000);

        System.out.println(driver.findElement(By.xpath("//div[@class='filter dropdown']")).getText());//verifying active user list

        WebElement paginationSet = driver.findElement(By.xpath("//select[@aria-label='Rows per page:']"));//pagination
        Thread.sleep(2000);
        Select paginationDropdown = new Select(paginationSet);
        paginationDropdown.selectByIndex(2);//selecting another value form dropdown
        Thread.sleep(2000);



    }
}