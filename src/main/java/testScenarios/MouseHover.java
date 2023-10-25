package testScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHover {
	WebDriver driver;
	@Test
	public void dragAndDrop()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		//action.dragAndDrop(drag, drop).build().perform();
		action.clickAndHold(drag).moveToElement(drop).release().build().perform();
		driver.quit();
		
		
	}
}
