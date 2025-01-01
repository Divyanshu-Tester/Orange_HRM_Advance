package base_Class;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Configuration extends Base_Class

{
	WebDriver driver;

	public void getTitleLogin()
	{
		String Actual_Title , ExpectedTitle ;
		
		Actual_Title = driver.getTitle();
		
		System.out.println("The Actual Page Title is "+Actual_Title);
      
		ExpectedTitle = "Login Page";
       
		
		Assert.assertEquals(Actual_Title, ExpectedTitle,"Actual and expected Title Doesnot Match");

        System.out.println("This line will not be printed if the assertion fails");

		
	}
	
	//METHOD TO CHECK BROKEN LINK 
	
	public void brknLink()

	{
		@SuppressWarnings("unchecked")
		List <WebElement>  allBrkn=  (List<WebElement>) driver.findElement(By.tagName("a"));
		System.out.println("All the Links found are"+allBrkn.size());
		
		for(WebElement link: allBrkn)
		{
			String href = link.getAttribute("href");
			
			if(href!=null && !href.isEmpty())
			{
				try
				{
					HttpURLConnection connection = (HttpURLConnection) new URL(href).openConnection();
					connection.setRequestMethod("HEAD");
					connection.connect();
					
					int connectionCode = connection.getResponseCode();
					
					if(connectionCode>=400)
					{
						System.out.println(href+"Is a Broken link with the Status Code"+connectionCode);
					}
					else
					{
						System.out.println(href+"IS Not a Broken link .VALID LINK"+connectionCode);
						
					}
				}
				catch(Exception e)
				
				{
					System.out.println(href + " is a broken link. Exception: " + e.getMessage());
                }
				
				}
			else 
			{
                System.out.println("The link is empty or null.");
			}
			
			
		}
		
		
	
	}
}
