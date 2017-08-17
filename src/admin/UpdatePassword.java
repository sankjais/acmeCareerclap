package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdatePassword {

	static boolean flag = true;

	static void  updatePassword(TestData admin) throws InterruptedException {
		long starttime = System.currentTimeMillis(), endtime;
		WebDriver driver = CreateDrivers.chrome();
		driver.navigate().to(admin.LoginURL);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5000);

		try {
			if (driver.getCurrentUrl().equalsIgnoreCase(admin.LoginURL)) {
				if (driver.getTitle().contains("CareerClap")) {
					System.out.println("Admin Login page loaded successfully");
				}
			} else {

				driver.navigate().refresh();
				Thread.sleep(3000);
				if (driver.getCurrentUrl().equalsIgnoreCase(admin.LoginURL)) {
					if (driver.getTitle().contains("CareerClap")) {
						System.out.println("Admin Login page loaded successfully");
					}
				} else {
					flag = false;
					driver.quit();
					System.out.println("Try after some time, server is not responding");
				}

			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div/input")));
			driver.findElement(By.xpath("//div[1]/div/input")).clear();
			driver.findElement(By.xpath("//div[1]/div/input")).sendKeys(admin.userID);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div/input")));
			driver.findElement(By.xpath("//div[2]/div/input")).clear();
			driver.findElement(By.xpath("//div[2]/div/input")).sendKeys(admin.fpassword);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/input")));
			driver.findElement(By.xpath("//form/input")).click();

			Thread.sleep(3000);
			if (driver.getCurrentUrl().equalsIgnoreCase(admin.updatePasswordURL)) {
				if (driver.getTitle().contains("CareerClap")) {
					System.out.println("Admin login successfully");

				}
			} else {
				if (driver.findElement(By.xpath("//form/div[3]")).getText().contains("Invalid")) {
					System.out.println(driver.findElement(By.xpath("//form/div[3]")).getText());
					flag = false;
					driver.quit();
				}
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div/input")));
			driver.findElement(By.xpath("//div[1]/div/input")).clear();
			driver.findElement(By.xpath("//div[1]/div/input")).sendKeys(admin.fpassword);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div/input")));
			driver.findElement(By.xpath("//div[2]/div/input")).clear();
			driver.findElement(By.xpath("//div[2]/div/input")).sendKeys(admin.password);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[3]/div/input")));
			driver.findElement(By.xpath("//div[3]/div/input")).clear();
			driver.findElement(By.xpath("//div[3]/div/input")).sendKeys(admin.password);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=button]")));
			driver.findElement(By.cssSelector("input[type=button]")).click();

			if (driver.getCurrentUrl().equalsIgnoreCase(admin.dashboardURL)) {
				if (driver.getTitle().contains("CareerClap")) {
					System.out.println("Admin updated password successfully");

				}
			} else {

				System.out.println("Admin fail to update password, check password");
				flag = false;
				driver.quit();
			}

		}

		catch (NoSuchElementException e) {
			System.out.println("you had used some drivers elements, which is wrong in syntax or not in browser.  -  NoSuchElementException");
			flag = false;
			// TODO: handle exception
		} catch (UnreachableBrowserException e) {
			System.out.println("oops- fail to load website- check your network connection or firewall setting  -  UnreachableBrowserException");
			flag = false;

			// TODO: handle exception
		} catch (InvalidArgumentException e) {
			System.out.println("Expected [object Undefined] undefined to be a string   - InvalidArgumentException");
			flag = false;

		}
		catch (WebDriverException e) {
			// TODO: handle exception
			System.out.println("unknown error: Element- WebDriverException");
			flag=false;
		}
		
		finally {
			driver.quit();
			endtime = System.currentTimeMillis();
			if(flag==true)
			{
				System.out
				.println("total time took for updating password is = " + (endtime - starttime) / 6000 + " SECONDS");
			}
			else
			{
				System.out.println("total time used while trying to update password but fail's is " + (endtime - starttime) / 6000 + " SECONDS");
			}
		}

	}

}
