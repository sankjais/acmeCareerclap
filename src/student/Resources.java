package student;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Resources {

	static int flag = 0;

	public static void resourcesTest(TestData student)

	{

		long starttime = System.currentTimeMillis(), endtime;
		WebDriver driver = CreateDrivers.chrome();
		WebDriverWait wait = new WebDriverWait(driver, 3000);

		try {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.navigate().to(student.welcomeURL);
			driver.manage().window().maximize();
			String getURL = driver.getCurrentUrl();
			if (getURL.equals(student.checkURL))
				if (driver.getTitle().equals("CareerClap")) {
					System.out.println("welcome page is loaded successfull");
					System.out.println("Welcome Page URL is- " + getURL);
					// System.out.println("Title of webpage- " +
					// driver.getTitle());
				} else {
					System.out.println("unable to see welcome page- Reloading page please wait.......");
					driver.navigate().refresh();
					if (getURL.equals(student.checkURL))
						if (driver.getTitle().equals("CareerClap")) {
							System.out.println("welcome page is loaded successfull");
							System.out.println("Welcome Page URL is- " + getURL);
							// System.out.println("Title of webpaage- " +
							// driver.getTitle());
						} else {
							driver.quit();
							System.out.println("SMOKE FAIL- Unable to load welcome page.");
							flag = 1;
						}
				}

			// WebElement element1 = driver.findElement(By.name("userID"));
			// element1.sendKeys(userID);
			driver.findElement(By.xpath("//a")).click();
			if (driver.getCurrentUrl().equals(student.LoginURL)) {
				if (driver.getTitle().contains("CareerClap")) {
					System.out.println("Login page loaded sucessfully...!");
					driver.findElement(By.name("userid")).sendKeys(student.userID);
					driver.findElement(By.name("password")).sendKeys(student.password);
					Thread.sleep(1000);
					driver.findElement(By.cssSelector("input[type=button]")).click();
					// Thread.sleep(2000);
					wait.until(ExpectedConditions.urlContains(student.profileURL));
					// instead of above method we should use thread if we are
					// passing invalid credential to caught exception
					if (driver.getCurrentUrl().equals(student.profileURL))
						if (driver.getTitle().contains("CareerClap")) {
							System.out.println("User login successfuly");
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[1]//div[1]/a/img")));
							driver.findElement(By.xpath("//div[1]//div[1]/a/img")).click();
							wait.until(ExpectedConditions.urlToBe(student.landingURL));
							// Thread.sleep(5000);

							if (driver.getCurrentUrl().equals(student.landingURL)) {
								if (driver.getTitle().contains("CareerClap")) {
									System.out.println("landing page is loaded successful");
									// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[4]/span")));
									Thread.sleep(5000);

									driver.findElement(By.xpath("//div[10]/span")).click();
									Thread.sleep(2000);
									wait.until(ExpectedConditions.urlToBe(student.resources));
									if (driver.getCurrentUrl().equals(student.resources)) {
										if (driver.getTitle().contains("CareerClap")) {
											System.out.println("Resources page is loaded successful");
											Thread.sleep(2000);
											driver.findElement(By.xpath(".//*[@id='dropdowndiv']/button")).click();
											Thread.sleep(1000);
											driver.findElement(By.xpath(".//*[@id='menu1']/li[5]/a")).click();
											Thread.sleep(2000);

										}

									}

									else {

										WebElement element2 = driver.findElement(By.xpath("//form/div[3]/div"));
										// relative-path
										// //div[1]//div[1]/div[3]/form/div[3]/div
										System.out.println(element2.getText());
										System.out.println(
												"SMOKE FAIL- due to user unable to login with valid username and password.");
										flag = 1;
									}

									Thread.sleep(1000);
									// driver.quit();
								}
							}
						}
				}
			}

		} catch (

		InterruptedException e) {
			// System.err.println(e);
			System.out.println("exception occured to to thread synchronization failed");
		} catch (NoSuchElementException e) {
			System.out
					.println("you have used some driver elements, which is wrong in syntax or unreachable in browser.");
		} catch (UnreachableBrowserException e) {
			System.out.println("oops- fail to load website- check your network connection or firewall setting");
		} finally {
			driver.quit();
			endtime = System.currentTimeMillis();
			if (flag == 0) {
				System.out.println(
						"total time for cheking resources = " + (endtime - starttime) / 6000 + " SECONDS");
			} else {
				System.out.println("total time for checking resources but fail's is = " + (endtime - starttime) / 6000
						+ " SECONDS");

			}
		}

	}

	/////

}
