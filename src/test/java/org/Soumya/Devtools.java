//package org.Soumya;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.v112.network.Network;
//import org.openqa.selenium.devtools.v112.network.model.RequestId;
//
//import java.util.Optional;
//import java.util.concurrent.TimeUnit;
//
//public class Devtools {
//    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("web-driver.chrome.driver", "C:\\Chromedriver\\chromedriver_win32 (1)\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments(new String[]{"--remote-allow-origins=*"});
//        WebDriver driver = new ChromeDriver();
//        DevTools Devtools = ((ChromeDriver) driver).getDevTools();
//        Devtools.createSession();
//        Devtools.send(Network.clearBrowserCache());
//        Devtools.send(Network.setCacheDisabled(true));
//
//        final RequestId[] requestIds = new RequestId[1];
//        Devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.of(100000000)));
//        return Devtools.addListener(Network.responseReceived(), responseReceived -> {
//
//
//            requestIds[0] = responseReceived.getRequestId();
//            String url = responseReceived.getResponse().getUrl();
//
//            int status = responseReceived.getResponse().getStatus();
//            String type = responseReceived.getType().toJson();
//            String headers = responseReceived.getResponse().getHeaders().toString();
//
//            String responseBody = Devtools.send(Network.getResponseBody(requestIds[0])).getBody();
//            driver.get("https://www.flipkart.com");
//        };   )
//
//    }
//
//
//}
