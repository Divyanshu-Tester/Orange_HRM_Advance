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

public WebDriver driver;
	public String browserName;
	private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

	public WebDriver getDriver(String browser) throws IOException {

		// browserName= PropertyReaderHelper.getConfigPropertyData("browser");

		// Check if browser parameter is passed from TestNG, else fallback to properties
		// file
		browserName = (browser != null) ? browser : ConfigReader.getConfigPropertyData("browser");
		//WebDriver driver = null;
		if (threadLocal.get() == null) {
		if (browserName.equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();
			Map<String, Object> map = new HashMap<>();
			map.put("credentials_enable_service", false); // Disabling password manager service
			map.put("profile.password_manager_enabled", false);
			// Disable autofill for addresses
			map.put("autofill.profile_enabled", false);

			// To disbale the images on website just to speed up the process
			// map.put("profile.managed_default_content_settings.images", 2);
			options.setExperimentalOption("prefs", map);

			// options.addArguments("--Incognito");
			WebDriverManager.chromedriver();
			threadLocal.set(new ChromeDriver(options));
			
		//driver.manage().window().maximize();
			
		}
		//	Map<String, Object> networkConditions = new HashMap<>();
        //    networkConditions.put("offline", false);  // Not offline
         //   networkConditions.put("latency", 100);  // 100 ms latency
      //      networkConditions.put("downloadThroughput", 50000);  // 50 KB/s download
      //      networkConditions.put("uploadThroughput", 30000);    // 30 KB/s upload

            // Apply the network conditions
        //    ChromeDriver chromeDriver = (ChromeDriver) driver;
         //   chromeDriver.executeCdpCommand("Network.emulateNetworkConditions", networkConditions);			}

		else if (browserName.equals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			// options.addArguments("-private");
			WebDriverManager.firefoxdriver();
		threadLocal.set(new FirefoxDriver());
			// FirefoxProfile profile = new FirefoxProfile();

		}

		else if (browserName.equals("edge")) {
			// Configure Edge options to enable InPrivate browsing
			EdgeOptions options = new EdgeOptions();
			// options.addArguments("inprivate");
			WebDriverManager.edgedriver();
		//	driver = new EdgeDriver();
			// driver.get("https://www.amazon.com/ref=nav_logo");
		}
		}
		return threadLocal.get();

	}
	

    public WebDriver getDriver() {
        return threadLocal.get();
    }
	
	
	public void tearDown() {
	    WebDriver driver = threadLocal.get();
	    if (driver != null) {
	        driver.quit();
	        threadLocal.remove(); // Clear the thread-local instance
	    }
	
	
}}
