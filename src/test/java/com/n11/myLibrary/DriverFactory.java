package com.n11.myLibrary;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class DriverFactory {
    private DriverFactory() {

    }

    private static InheritableThreadLocal<WebDriver> driverContainer = new InheritableThreadLocal<>();

    public static WebDriver get() {

        if (driverContainer.get() == null) {


            String browser =  System.getProperty("browser") != null ? browser = System.getProperty("browser") : PropertiesReader.get("browser");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverContainer.set(new ChromeDriver());
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driverContainer.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverContainer.set(new FirefoxDriver());
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driverContainer.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    WebDriverManager.iedriver().setup();
                    driverContainer.set(new InternetExplorerDriver());
                    break;

                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");
                    WebDriverManager.edgedriver().setup();
                    driverContainer.set(new EdgeDriver());
                    break;

                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driverContainer.set(new SafariDriver());
                    break;

                case "remote_chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();

                    chromeOptions.setCapability("platform", Platform.ANY);
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");

                    try {
                        driverContainer.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),chromeOptions));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "remote_firefox":
                    FirefoxOptions firefoxOptions=new FirefoxOptions();
                    firefoxOptions.setCapability("platform", Platform.ANY);

                    firefoxOptions.addArguments("--headless");
                    firefoxOptions.addArguments("--no-sandbox");
                    firefoxOptions.addArguments("--disable-dev-shm-usage");
                    try{
                        driverContainer.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions));
                    }catch (MalformedURLException e){
                        e.printStackTrace();
                    }
                    break;

            }
        }
        return driverContainer.get();
    }

    public static void closeDriver() {
        driverContainer.get().quit();
        driverContainer.remove();
    }
}