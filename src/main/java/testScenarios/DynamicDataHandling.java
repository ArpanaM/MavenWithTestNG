package testScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicDataHandling {

	WebDriver driver;
	@Test
	public void DynData()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jqueryscript.net/demo/Simple-Math-Captcha-Plugin-for-jQuery-ebcaptcha/demo/");
		String str=driver.findElement(By.id("ebcaptchatext")).getText();
		System.out.println(str);
		String str1=str.substring(8, 9);
		String str2=str.substring(12,13);
		Integer res= Integer.valueOf(str1) + Integer.valueOf(str2);
		driver.findElement(By.id("ebcaptchainput")).sendKeys(String.valueOf(res));
		boolean chkSub=driver.findElement(By.xpath("//*[@id=\"form\"]/input[2]")).isEnabled();
		System.out.println(chkSub);
		if(chkSub==true)
		{
			System.out.println("Calculation is correct");
		}
		else
		{
			System.out.println("Calculation is incorrect");
		}
		driver.quit();
	}
}
