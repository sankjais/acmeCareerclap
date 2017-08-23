package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {

	boolean flag = true;

	void testDashboard(TestData admin) throws InterruptedException {
		long starttime = System.currentTimeMillis(), endtime;
		WebDriver driver = CreateDrivers.chrome();
		driver.get(admin.LoginURL);
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
					System.out.println("Smoke Fail");
				}

			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div/input")));
			driver.findElement(By.xpath("//div[1]/div/input")).clear();
			driver.findElement(By.xpath("//div[1]/div/input")).sendKeys(admin.userID);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div/input")));
			driver.findElement(By.xpath("//div[2]/div/input")).clear();
			driver.findElement(By.xpath("//div[2]/div/input")).sendKeys(admin.password);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/input")));
			driver.findElement(By.xpath("//form/input")).click();

			Thread.sleep(3000);
			if (driver.getCurrentUrl().equalsIgnoreCase(admin.dashboardURL)) {
				if (driver.getTitle().contains("CareerClap")) {
					System.out.println("Admin login successfully");
					Thread.sleep(5000);

					//AddInstitute.add(driver, admin.instituteName, admin.instituteCity, admin.instituteState);
					AddDost.addDost(driver,admin.dostfname, admin.dostlname, admin.dostemail, admin.dostContact,
							admin.dostCategory, admin.dostStatus, admin.aboutDost);
				}

			}

		} catch (NoSuchElementException e) {
			System.out.println(
					"you had used some drivers elements, which is wrong in syntax or not in browser.  -  NoSuchElementException");
			flag = false;
			// TODO: handle exception
		} catch (UnreachableBrowserException e) {
			System.out.println(
					"oops- fail to load website- check your network connection or firewall setting  -  UnreachableBrowserException");
			flag = false;

			// TODO: handle exception
		} catch (InvalidArgumentException e) {
			System.out.println("Expected [object Undefined] undefined to be a string   - InvalidArgumentException");
			flag = false;

		} catch (WebDriverException e) {
			// TODO: handle exception
			System.out.println("unknown error: Element- WebDriverException");
			flag = false;
		}

		finally {
			driver.quit();
			endtime = System.currentTimeMillis();
			if (flag == true) {
				System.out.println("total time took for testing admin dash board is = " + (endtime - starttime) / 6000
						+ " SECONDS");
			} else {
				System.out.println("total time used while testing admin dashboard but fail's is "
						+ (endtime - starttime) / 6000 + " SECONDS");
			}
		}
	}
}
