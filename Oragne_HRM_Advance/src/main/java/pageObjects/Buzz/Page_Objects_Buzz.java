package pageObjects.Buzz;

import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base_Objects.Base_Objects;

public class Page_Objects_Buzz extends Base_Objects

{

	public Page_Objects_Buzz(WebDriver driver) 
	
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	private static By Mind = By.xpath("//textarea[@placeholder=\"What's on your mind?\"]");
	private static By Click_Post = By.xpath("//button[@type='submit']");
	private static By Share_Photos = By.xpath("//button[normalize-space()='Share Photos']");
	private static By Share_Videos = By.xpath("//button[normalize-space()='Share Video']");
	private static By Most_Recent_Posts = By.xpath("//button[normalize-space()='Most Recent Posts']");
	private static By Most_Liked_Posts = By.xpath("//button[normalize-space()='Most Liked Posts']");
	private static By Most_Commented_Post = By.xpath("//button[normalize-space()='Most Commented Posts']")	;
	private static By Dynamic_Like = By.id("heart");
	private static By Dynamic_Comment = By.xpath("//i[contains(@class, 'bi-chat-text-fill')]");
	private static By Dynamic_Share = By.xpath("//i[contains(@class, 'bi-share-fill')]");
	private static By Kebab_Button = By.xpath("//button[contains(@class, 'oxd-icon-button')]");
	
	
	public static void whOnMind()
	
	{
		WebElement Content = wait.until(ExpectedConditions.elementToBeClickable(Mind));
		Content.sendKeys("This is The Test Kwyword , If you want to run Random Contents call the other method");
	}
	
	
	public static void clkPOST()
	{
		WebElement POST = wait.until(ExpectedConditions.elementToBeClickable(Click_Post));
		POST.click();
		
	
	}
	
	public static void upldPhoto(String FilePath)
	{
		String AbFilePath = Paths.get(System.getProperty(FilePath)).toString();
		
		WebElement clkShare_Photo = wait.until(ExpectedConditions.elementToBeClickable(Share_Photos));
		clkShare_Photo.click();
		
		
		WebElement File_Upload_Input = wait.until(ExpectedConditions.presenceOfElementLocated(Click_Post));
		File_Upload_Input.sendKeys((AbFilePath));
		
		
	}
	
	
	public static void vdoUpload (String RelativeFilePath)
	
	{
		String[] validFormats = {".mp4", ".avi", ".mov", ".mkv"};
		
		String absolutePath = Paths.get(System.getProperty("user.dir"),
				
				RelativeFilePath).toString();
		
		
		boolean isValidFormate = false;
		for(String format : validFormats)
		{
			if(absolutePath.endsWith(format));
			{
				isValidFormate = true;	
                break;
			}
		}
		
		if(isValidFormate)
		{
			throw new IllegalArgumentException("Invalid file format. Please upload a video file.");
		}
		
		WebElement shareVideo = wait.until(ExpectedConditions.elementToBeClickable(Share_Videos));
		shareVideo.click();
		
		WebElement fileUploadInput = wait.until(ExpectedConditions.presenceOfElementLocated(Share_Videos));
		fileUploadInput.sendKeys(absolutePath);
		
		
	}
	
	
	public static void clkMstRctPts()
	{
		WebElement clickMstRctPhotoes = wait.until(ExpectedConditions.elementToBeClickable(Most_Recent_Posts));
		clickMstRctPhotoes.click();
	}
	
	public static void clkMstLiked()
	{
		WebElement clickMstLiked  = wait.until(ExpectedConditions.elementToBeClickable(Most_Liked_Posts));
		clickMstLiked .click();
	}
	
	public static void clkMstComntPost()
	{
		WebElement clickMstCommantedPost = wait.until(ExpectedConditions.elementToBeClickable(Most_Commented_Post));
		clickMstCommantedPost .click();
	}
	
	
	public static void RndclkLike()
	{
		List<WebElement> allLike_Button = (List<WebElement>) wait.until(ExpectedConditions.elementToBeClickable(Dynamic_Like));
		
		if(allLike_Button.isEmpty())
		{
			throw new RuntimeException("No Like Button Founded In The Feed");
		}
		
			
		int RdmIndex = new Random().nextInt(allLike_Button.size());
		WebElement randomLike = allLike_Button.get(RdmIndex);
		
		wait.until(ExpectedConditions.elementToBeClickable(randomLike)).click();
	}
	
	
	public static void RndCommt()
	{

		List<WebElement> allCMT_Button = (List<WebElement>) wait.until(ExpectedConditions.elementToBeClickable(Dynamic_Like));
		
		if(allCMT_Button.isEmpty())
		{
			throw new RuntimeException("No Like Button Founded In The Feed");
		}
		
		int RndId = new Random().nextInt(allCMT_Button.size());
		
		WebElement randomCMT = allCMT_Button.get(RndId);
		
		wait.until(ExpectedConditions.elementToBeClickable(Dynamic_Comment)).sendKeys("This is Random Testing COmment Section");
		
		
	}
	
	
	
}

























