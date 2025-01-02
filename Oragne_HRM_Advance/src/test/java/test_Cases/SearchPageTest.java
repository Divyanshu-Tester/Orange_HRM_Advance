package test_Cases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base_Class.Base_Class;

public class SearchPageTest extends  Base_Class{

	@Test(priority = 0,dataProvider="searchData")
	public void searchFunctionalityTest(String searchText) {
	List<String> results=	searchObj.validateSearch(searchText);
	System.out.println(results.size());
	if(results.isEmpty()) {
		System.out.println("Result text does not contain the search character:" +searchText);
	}
	for(String result:results) {
		Reporter.log(result,true);
		Assert.assertTrue(result.toLowerCase().contains(searchText));
	}
	}
	
	
	
	
	
	
	
	
	@DataProvider(name="searchData")
	public Object[] getData() {
		Object obj[]= {"m","admin","ghj","time"};
		return obj;
	}

}
