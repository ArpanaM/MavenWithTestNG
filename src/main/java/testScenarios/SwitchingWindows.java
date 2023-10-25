package testScenarios;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwitchingWindows {

	WebDriver driver;
	@Test
	public void switchWind()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open"); 
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		//fetch window ids opened by the driver object
		Set<String> allWin = driver.getWindowHandles();
		System.out.println("Total number of Windows="+allWin.size());
		String win1=null;
		String win2=null;
		//to read data from set object we should use iterator class
		Iterator<String> itr=allWin.iterator();
		if(itr.hasNext())
		{
			win1=itr.next();
			win2=itr.next();
		}
		System.out.println("Window1 id="+win1);
		System.out.println("Window2 id="+win2);
		System.out.println("Window1 title="+driver.getTitle());
		driver.switchTo().window(win2);
		System.out.println("Window2 title="+driver.getTitle());
		boolean chkLogStatus=driver.findElement(By.linkText("Log in")).isEnabled();
		System.out.println(chkLogStatus);
		Assert.assertEquals(chkLogStatus,true);
		driver.quit();
	}
}
