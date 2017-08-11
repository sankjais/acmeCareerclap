package student;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = CreateDrivers.chrome();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//div[1]/div[4]//div[2]/ol/li[2]/a")).sendKeys(Keys.CONTROL.ENTER);
		String firstWin=driver.getWindowHandle();
		if(driver.getWindowHandles().equals(firstWin))
		{
			driver.quit();
			System.out.println("closing");
		}
		

	}

}
