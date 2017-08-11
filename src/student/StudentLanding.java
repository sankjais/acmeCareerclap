package student;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentLanding

{
	static int flag = 0;

	void barclaysTest(TestData student) {
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
					//Thread.sleep(2000);
					 wait.until(ExpectedConditions.urlContains(student.profileURL));
					// instead of above method we should use thread if we are
					// passing invalid credential to caught exception
					if (driver.getCurrentUrl().equals(student.profileURL))
						if (driver.getTitle().contains("CareerClap")) {
							System.out.println("User login successfuly");
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[1]//div[1]/a/img")));
							driver.findElement(By.xpath("//div[1]//div[1]/a/img")).click();
							wait.until(ExpectedConditions.urlToBe(student.landingURL));
							//Thread.sleep(5000);
							
							if (driver.getCurrentUrl().equals(student.landingURL)) {
								if (driver.getTitle().contains("CareerClap")) {
									System.out.println("landing page is loaded successful");
									//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[4]/span")));
									Thread.sleep(5000);
									
									driver.findElement(By.xpath("//div[4]/span")).click();
									System.out.println("its here @1");
									Thread.sleep(5000);
									wait.until(ExpectedConditions.urlToBe(student.barclayStartURL));
									if (driver.getCurrentUrl().equals(student.barclayStartURL)) {
										if (driver.getTitle().contains("CareerClap")) {
											System.out.println("Barclay start page ie PDF page is loaded successfuly.");
											Thread.sleep(5000);
											//wait.until(ExpectedConditions.urlContains(student.barclayStartURL));
											 for (String handle : driver.getWindowHandles()) {

												    driver.switchTo().window(handle);}
											
											for (int i = 1; i < 35; i++) {

												System.out.println("reading pdf " + i);
												String tempXpath = "//tr[" + i + "]//a";
												
												System.out.println(currentWindow);
												driver.findElement(By.xpath(tempXpath)).click();
												//driver.findElement(By.xpath(tempXpath)).sendKeys(Keys.CONTROL.ENTER);
												String nextWindow= driver.getWindowHandle();
												Thread.sleep(5000);
												//System.out.println(currentWindow);
											       if (!currentWindow.equals(nextWindow)) {
												            driver.quit();
												        	driver.switchTo().window(currentWindow);
												        
												    }

												    
												
											}
											Thread.sleep(1000);
											driver.findElement(By.xpath("//a[2]")).click();
											wait.until(ExpectedConditions
													.urlContains(student.barclayspracticeInstructions));
											if (driver.getCurrentUrl().equals(student.barclayspracticeInstructions)) {
												if (driver.getTitle().contains("CareerClap")) {
													System.out.println("Barclays Instruction page is loaded successfuly");
													driver.findElement(By.xpath("//button")).click();
													wait.until(ExpectedConditions.urlContains(student.barclaysQuiz));
													if (driver.getCurrentUrl().equals(student.barclaysQuiz)) {
														for (int i = 1; i <= 20; i++) {
															wait.until(ExpectedConditions
																	.elementToBeClickable(By.xpath("//*[@id='1']")));
															driver.findElement(By.xpath(".//*[@id='1']")).click();
															wait.until(ExpectedConditions
																	.elementToBeClickable(By.xpath("//form//a[2]/i")));
															driver.findElement(By.xpath("//form//a[2]/i")).click();
														}
														wait.until(ExpectedConditions.elementToBeClickable(
																By.xpath(".//*[@id='exitExam']//a")));
														driver.findElement(By.xpath(".//*[@id='exitExam']//a")).click();

													}
												}
											}

										}
									}
								}
							}
							Thread.sleep(10000);

						} else {

							WebElement element2 = driver
									.findElement(By.xpath("html/body/div[1]/div/div/div[1]/div[3]/form/div[3]/div"));
							// relative-path
							// //div[1]//div[1]/div[3]/form/div[3]/div
							System.out.println(element2.getText());
							System.out.println(
									"SMOKE FAIL- due to user unable to login with valid username and password.");
						}

					Thread.sleep(1000);
					// driver.quit();
				}
			}
		} catch (InterruptedException e) {
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
			System.out.println("total time for execution process till barclaysStartPage = "
					+ (endtime - starttime) / 6000 + " SECONDS");
		}
	}

}
