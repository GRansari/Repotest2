package readrepo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class myntra {

	
	
	WebDriver driver;
	 
	@Before
	public void start() {
		
		driver= new ChromeDriver();	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");
	}
	
	@Test
	public void testSurch() {
			Assert.assertEquals("Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra", driver.getTitle());
		
		WebElement surchBox = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
		if(surchBox.isDisplayed()) {
			surchBox.sendKeys("Shirts");
		}
		else{
			System.out.println("surchbox is not available");
		}
		
		List<WebElement> surchboxList = driver.findElements(By.xpath("//div[@class=' desktop-autoSuggest desktop-showContent']//li"));
	    System.out.println(	surchboxList.size());
		
	    for(int i=0;i<=surchboxList.size();i++) {
	    	
	    	System.out.println(surchboxList.get(i).getText());
	    	
	    	if(surchboxList.get(i).getText().equalsIgnoreCase("Shirts Men Casual")) {
	    		System.out.println("yes, it is available");
	    		surchboxList.get(i).click();
	    	}
	  		    
	    }
	  
		 WebElement shirttext =  driver.findElement(By.xpath("//span[@class='breadcrumbs-crumb']"));
	      System.out.println(shirttext.getText());
	    Assert.assertEquals("asual Shirts for Men",shirttext.getText());
	    
	    
	}
	
	@After
	public void after() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.quit();
	}
}


