package student;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CreateDrivers 

{
	static WebDriver chrome()
	{
	WebDriver chrome = new ChromeDriver();
	return chrome;
	}
	
	static WebDriver IE()
	{
	WebDriver IE = new InternetExplorerDriver();
	return IE;
	}
	
	static WebDriver fireFox()
	{
	WebDriver fireFox = new FirefoxDriver();
	return fireFox;
	}
}
