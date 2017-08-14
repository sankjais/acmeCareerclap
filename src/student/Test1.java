package student;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = CreateDrivers.chrome();
		driver.get("https://www.google.com/");
		/*driver.findElement(By.xpath("//div[1]/div[4]//div[2]/ol/li[2]/a")).sendKeys(Keys.CONTROL.ENTER);
		String firstWin=driver.getWindowHandle();
		if(driver.getWindowHandles().equals(firstWin))
		{
			driver.quit();
			System.out.println("closing");
		}*/
		
		
		driver.findElement(By.id("gsr")).sendKeys(Keys.CONTROL,"t");
		driver.get("https://www.google.co.in");
		//String wh1=driver.getWindowHandle();
	   // String cwh=null;
	   /* while(wh1!=cwh)
	    {   
	    new Actions(driver).sendKeys(Keys.CONTROL).sendKeys(Keys.NUMPAD1).perform();
	    driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL, Keys.TAB);
	    cwh=driver.getWindowHandle();
	    driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL+"w");
	    }*/
	    Thread.sleep(10000);
	    driver.quit();
	    
	    
	    
	    
	//    String Parent_Window = driver.getWindowHandle();    
        // Switching from parent window to child window   
       for (String Child_Window : driver.getWindowHandles())  
       {  
        driver.switchTo().window(Child_Window);
        Thread.sleep(2000);      
        driver.close();
       }
       String currentURL=driver.getCurrentUrl();
       System.out.println(currentURL);
       if(currentURL.equalsIgnoreCase("https://adc-sec-prodsoa11.sec.gov:7011/TCRWeb/faces/login?_afrLoop=3056749701212429&_afrWindowMode=0&_adf.ctrl-state=dtjrla5r7_4"))
       {
        driver.close();
       }
	}

}
