package org.Soumya;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PaginationHandle {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("web-driver.chrome.driver", "C:\\Chromedriver\\chromedriver_win32 (1)\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--remote-allow-origins=*"});
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        driver.get("http://192.168.0.106:3001/");

        WebElement mobile = driver.findElement(By.xpath("//input[@id='u-id']"));
        mobile.sendKeys("7980752165");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("123456789");
        driver.findElement(By.cssSelector("button[type='submit']")).click();//login
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[normalize-space()='User Manage']")).click();//user manage
        driver.findElement(By.xpath("//a[normalize-space()='User Detail']")).click();
        Thread.sleep(3000);
        //clicking on pagination
//        driver.findElement(By.xpath("//button[@aria-label='Next Page']")).click();
//        Thread.sleep(2000);
//        System.out.println(driver.findElement(By.xpath("//span[normalize-space()='11-20 of 1000']")).getText());

        WebElement firstPageBtn = driver.findElement(By.id("pagination-first-page"));
        WebElement previousPageBtn = driver.findElement(By.id("pagination-previous-page"));
        WebElement nextPageBtn = driver.findElement(By.id("pagination-next-page"));
        WebElement lastPageBtn = driver.findElement(By.id("pagination-last-page"));
        // Thread.sleep(500);
        // Assuming there are 10 pages in total, you can iterate through all pages like this:
//        int totalPages = 10;
//
//        for (int pageNumber = 1; pageNumber <= totalPages; pageNumber++) {
//            // Load data and perform actions on the current page
//            // loadPageData(driver, pageNumber);
//
//            // If not the last page, go to the next page
//
//            if (pageNumber < totalPages) {
//                nextPageBtn.click();
//                Thread.sleep(500);
//            }
//        }
//
//        String pageCount = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > section:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > nav:nth-child(1) > span:nth-child(3)")).getText();
//        System.out.println(pageCount);
        // Assuming there are 10 pages in total, you can iterate through all pages like this:
        int totalPages = 3;


        List<WebElement> nameArray = null;
        for (int pageNumber = 1; pageNumber <= totalPages; pageNumber++) {
            // Find all elements of the specified column using the 'data-column-id' attribute
            List<WebElement> nameColumnElements = driver.findElements(By.xpath("//div[@data-column-id='3']"));
            List<WebElement> mobileColumnElements = driver.findElements(By.xpath("//div[@data-column-id='4']"));

            System.out.println("Data from '" + nameColumnElements.get(0).getText() + "' column on Page " + pageNumber + ":");

            int index = 0;
            for (WebElement nameElement : nameColumnElements) {
                if (!nameElement.getText().equals(nameColumnElements.get(0).getText()) && !mobileColumnElements.get(index).getText().equals(mobileColumnElements.get(0).getText())) {
                    System.out.println(nameElement.getText() + " : " + mobileColumnElements.get(index).getText());
                }
                    index++;
            }


            if (pageNumber < totalPages) {
                nextPageBtn.click();
                Thread.sleep(500);
            }


        }


        driver.close();

    }
}













