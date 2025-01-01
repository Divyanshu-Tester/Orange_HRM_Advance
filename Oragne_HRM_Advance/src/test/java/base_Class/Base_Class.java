package base_Class;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base_Class 

{
    protected WebDriver driver;

    @BeforeMethod
    public void Launch_Chrome() 
    
    {
        driver = new ChromeDriver(); // Initialize WebDriver
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //ChromeOptions options = new ChromeOptions();
       // options.setCapability("goog:loggingPrefs", Map.of("browser", "ALL"));
       // driver = new ChromeDriver(options);
    }
    
    
//    @AfterMethod
//    public void Quit()
//    {
//    	driver.quit();
//  
//   }


}

