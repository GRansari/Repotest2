package readrepo;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//import junit.framework.Assert;

public class Repo {

	
	WebDriver driver;
	 
	@Before
	public void start() {
		
		driver= new ChromeDriver();	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/droppable");
		//driver.get("https://jqueryui.com/droppable/");
		//driver.get("http://demo.guru99.com/test/simple_context_menu.html");
	}
	@Test
	
	public void dragAndDrop() {
		WebElement ele2 = driver.findElement(By.id("droppable"));
		WebElement ele1 =driver.findElement(By.id("draggable"));
		
		Actions act = new Actions(driver);
		act.clickAndHold(ele1).moveToElement(ele2).release().build().perform();
		WebElement ele3 = driver.findElement(By.xpath("//div[@id='droppable']/p[text()='Dropped!']"));
		Assert.assertEquals("Dropped!",ele3.getText());
	}
	@Ignore
	@Test
	public void drag() {
		WebElement ele4 = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(ele4);
		WebElement ele1=driver.findElement(By.id("draggable"));
		WebElement ele2 = driver.findElement(By.id("droppable"));
	
		//driver.switchTo().frame(ele3);
		
		Actions act = new Actions(driver);
		act.dragAndDrop(ele1, ele2).build().perform();
		WebElement confermation = driver.findElement(By.xpath("//div[@id='droppable']/p[text()='Dropped!']"));
		Assert.assertEquals("Dropped!",confermation.getText());
	}
	@Ignore
	@Test
	public void rightclick() throws InterruptedException {
		
		Actions act = new Actions(driver);
		WebElement Dclick = driver.findElement(By.xpath("//span[text()='right click me']"));
		act.contextClick(Dclick).build().perform();
		Thread.sleep(2000);
		
		WebElement doubleClick = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		act.doubleClick().build().perform();
		Thread.sleep(2000);
	}
	
	@After
	public void end() {
		driver.quit();
		
	}
	
	
}

	
	
	
	
	

