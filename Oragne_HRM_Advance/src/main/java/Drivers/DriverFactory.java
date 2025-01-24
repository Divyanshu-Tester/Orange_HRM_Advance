package Drivers;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


import Utilities.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableGaugeData;

public class DriverFactory {

//protected static WebDriver driver;
	private static String browserName;
	private static volatile DriverFactory instance;
	private static ThreadLocal<WebDriver> tlDriver= new ThreadLocal();
	
	private DriverFactory() {};

	private  void initDriver(String browser) {
		// Check if browser parameter is passed from TestNG, else fallback to properties
	
	//	browserName = (browser != null) ? browser : ConfigReader.getConfigPropertyData("browser");
		if (browser.equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();
			Map<String, Object> map = new HashMap<>();
			map.put("credentials_enable_service", false); // Disabling password manager service
			map.put("profile.password_manager_enabled", false);
			map.put("autofill.profile_enabled", false); // Disable autofill for addresses

			// To disbale the images on website just to speed up the process
			// map.put("profile.managed_default_content_settings.images", 2);
			options.setExperimentalOption("prefs", map);

			// options.addArguments("--Incognito");
			WebDriverManager.chromedriver();
			tlDriver.set(new ChromeDriver(options));

			// driver.manage().window().maximize();

		}
		// Map<String, Object> networkConditions = new HashMap<>();
		// networkConditions.put("offline", false); // Not offline
		// networkConditions.put("latency", 100); // 100 ms latency
		// networkConditions.put("downloadThroughput", 50000); // 50 KB/s download
		// networkConditions.put("uploadThroughput", 30000); // 30 KB/s upload

		// Apply the network conditions
		// ChromeDriver chromeDriver = (ChromeDriver) driver;
		// chromeDriver.executeCdpCommand("Network.emulateNetworkConditions",
		// networkConditions); }

		else if (browser.equals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			// options.addArguments("-private");
			WebDriverManager.firefoxdriver();
			 tlDriver.set(new FirefoxDriver());

		}

		else if (browser.equals("edge")) {
			// Configure Edge options to enable InPrivate browsing
			EdgeOptions options = new EdgeOptions();
			// options.addArguments("inprivate");
			WebDriverManager.edgedriver();
			// driver = new EdgeDriver();
			// driver.get("https://www.amazon.com/ref=nav_logo");
		}
	}
	
	
	public static DriverFactory getDriverInstance(String browser) {
		if(instance==null) {
			synchronized(DriverFactory.class){
				if(instance==null) {
				instance= new DriverFactory();
			}}
		}
		
		if(tlDriver.get()==null) {
			instance.initDriver(browser);
		}
		
		return instance;
	}
	
	
	public WebDriver getDriver() {
		return	tlDriver.get();
	}
	
	public static void quit() {
		if(tlDriver.get()!=null) {
			tlDriver.get().quit();
			tlDriver.remove();
		}
	}

	
}
