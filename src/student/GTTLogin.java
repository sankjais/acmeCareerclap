package student;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GTTLogin

{
	static int flag = 0;

	void validLogin(TestData student) throws InterruptedException

	{
		WebDriver driver = CreateDrivers.chrome();
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		long starttime = System.currentTimeMillis(), endtime;

		try {

			// some time its not work- implicit wait so use explicit wait.

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.navigate().to(student.welcomeURL);
			driver.manage().window().maximize();
			String getURL = driver.getCurrentUrl();
			if (getURL.equals(student.checkURL))
				if (driver.getTitle().equals("CareerClap")) {
					System.out.println("welcome page is loaded successfull");
					System.out.println("Welcome Page URL is- " + getURL);
					System.out.println("Title of webpage- " + driver.getTitle());
				} else {
					System.out.println("unable to see welcome page- Reloading page please wait.......");
					driver.navigate().refresh();
					if (getURL.equals(student.checkURL))
						if (driver.getTitle().equals("CareerClap")) {
							System.out.println("welcome page is loaded successfull");
							System.out.println("Welcome Page URL is- " + getURL);
							System.out.println("Title of webpaage- " + driver.getTitle());
						} else {
							driver.quit();
							System.out.println("SMOKE FAIL- Unable to load welcome page.");
							flag = 1;
						}
				}

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a")));
			driver.findElement(By.xpath("//a")).click();

			if (driver.getCurrentUrl().equals(student.LoginURL)) {
				if (driver.getTitle().contains("CareerClap")) {
					System.out.println("Login page loaded sucessfully...!");
					driver.findElement(By.name("userid")).sendKeys(student.email);
					driver.findElement(By.name("password")).sendKeys(student.fpassword);
					driver.findElement(By.cssSelector("input[type=button]")).click();
					wait.until(ExpectedConditions.urlContains(student.updatePasswordURL));
					Thread.sleep(2000);
					if (driver.getCurrentUrl().equals(student.updatePasswordURL)) {
						System.out.println("Smoke PASS");
						System.out.println("user successfuly Login");

					} else {
						WebElement element2 = driver.findElement(By.xpath("//div[1]//div[3]//div[3]/div"));
						// relative-path //div[1]//div[1]/div[3]/form/div[3]/div
						System.out.println(element2.getText());
						System.out
								.println("SMOKE FAIL- due to user unable to login with Invalid username and password.");
						flag = 1;
					}
				}
			} else {
				System.out.println("login page is not available , check your network or try after some time.");
				flag = 1;
			}

			Thread.sleep(1000);

		} // try block closed

		catch (InterruptedException e) {
			// System.err.println(e);
			System.out.println("Exception occured to to thread synchronization failed");
		} catch (NoSuchElementException e) {
			System.out.println("you had used some drivers elements, which is wrong in syntax or not in browser.");
			// TODO: handle exception
		} catch (UnreachableBrowserException e) {
			System.out.println("oops- fail to load website- check your network connection or firewall setting");
			// TODO: handle exception
		} catch (InvalidArgumentException e) {
			System.out.println("Expected [object Undefined] undefined to be a string");
			flag = 1;
		}

		finally {

			driver.quit();
			endtime = System.currentTimeMillis();
			if (flag == 0) {
				System.out.println("User Login for first time & total time for execution process was = "
						+ (endtime - starttime) / 6000 + " SECONDS");
			} else {
				System.out.println(
						"User tried to Login for first time but fail's and total time for execution process was = "
								+ (endtime - starttime) / 6000 + " SECONDS");
			}
		}

	} // closing for validLogin
}