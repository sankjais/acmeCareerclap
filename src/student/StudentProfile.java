package student;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentProfile

{
	static boolean flag = true;

	void updateProfile(TestData student) {
		
		InterruptedException exit = new InterruptedException();
		long starttime = System.currentTimeMillis(), endtime;
		WebDriver driver = CreateDrivers.chrome();
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		// some time its not work- implicit wait so use explicit wait.
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
							flag = false;
						}
				}

			// WebElement element1 = driver.findElement(By.name("userID"));
			// element1.sendKeys(userID);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a")));
			driver.findElement(By.xpath("//a")).click();
			if (driver.getCurrentUrl().equals(student.LoginURL)) {
				if (driver.getTitle().contains("CareerClap")) {
					System.out.println("Login page loaded sucessfully...!");
					driver.findElement(By.name("userid")).sendKeys(student.userID);
					driver.findElement(By.name("password")).sendKeys(student.password);
					driver.findElement(By.cssSelector("input[type=button]")).click();
					Thread.sleep(5000);
					wait.until(ExpectedConditions.urlContains(student.profileURL));
					// instead of above method we should use thread if we are
					// passing invalid credential to caught exception
					if (driver.getCurrentUrl().equals(student.profileURL))
						if (driver.getTitle().contains("CareerClap")) {

							System.out.println("User login successfuly");
							// student profile method call here
							driver.findElement(By.cssSelector("input[name=firstName")).clear();
							System.out.println("Firstname- " + student.firstname);
							driver.findElement(By.cssSelector("input[name=firstName")).sendKeys(student.firstname);
							driver.findElement(By.cssSelector("input[name='middleName']")).clear();
							System.out.println("MiddleName- " + student.middlename);
							driver.findElement(By.cssSelector("input[name='middleName']")).sendKeys(student.middlename);
							driver.findElement(By.cssSelector("input[name='lastName']")).clear();
							System.out.println("LastName- " + student.lastname);
							driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys(student.lastname);
							Thread.sleep(500);
							driver.findElement(By.cssSelector("input[name='email']")).clear();
							Thread.sleep(500);
							System.out.println("Email- " + student.email);
							driver.findElement(By.cssSelector("input[name='email']")).sendKeys(student.email);
							Thread.sleep(1000);
							driver.findElement(By.cssSelector("input[name='contact']")).clear();
							
							if(driver.findElement(By.xpath("//div[4]//span[3]")).getText().equalsIgnoreCase("Email address is already used by another user"))
							{
								System.out.println("Email id already registered please change Email ID");
								throw exit;
							}
							
							
							
							System.out.println("Contact- " + student.contact);
							driver.findElement(By.cssSelector("input[name='contact']")).sendKeys(student.contact);

							// calendar- here error may occur because we were
							// sending date directly, not able to select now
							Thread.sleep(2000);

							if (student.DOB.equalsIgnoreCase(driver
									.findElement(By.cssSelector("input[placeholder='Date of Birth']")).getText())) {
								System.out.println("profile contain same DOB.");
							} else {
								SetData.setDOB(driver, student);

							}
							// System.out.println(driver.findElement(By.xpath("//div[1]//div[2]/ul//div[6]//input")).getText());
							System.out.println("DOB - " + student.DOB);
							// System.out.println("execution done");
							Thread.sleep(1000);

							// for picking gender
							System.out.println("Gender- " + student.gender);
							if (student.gender.contains("Female")) {
								driver.findElement(By.xpath("//label[2]/input")).click();
							} else {
								driver.findElement(By.xpath("//label[1]/input")).click();
							}
							
							Thread.sleep(500);
							
							if(driver.findElement(By.xpath("//div[5]//span[3]")).getText().equalsIgnoreCase("Contact number is already used by another user"))
							{
								System.out.println("Contact number is already used by another user please change contact number");
								throw exit;
							}
							
							
							

							// adding id type
							System.out.println("Student ID Type- " + student.SID_type);
							System.out.println("Student ID - " + student.SID);
							int tempSid_type = SetData.setSID(student.SID_type);
							String tempSID = "//*[@id='studentId_selection']/option[" + tempSid_type + "]";
							driver.findElement(By.xpath(tempSID)).click();
							driver.findElement(By.id("studIdNo")).clear();
							driver.findElement(By.id("studIdNo")).sendKeys(student.SID);
							Thread.sleep(1000);
							driver.findElement(By.xpath("//ul[2]/li[2]/div[3]/div/input")).clear();
							System.out.println("Address - " + student.address);
							driver.findElement(By.xpath("//ul[2]/li[2]/div[3]/div/input")).sendKeys(student.address);

							// adding job id details
							System.out.println("Job Status - " + student.job_status);
							int tempJobid_type = SetData.setJobID(student.job_status);
							String tempJobID = "//*[@name='jobStatus']/option[" + tempJobid_type + "]";
							driver.findElement(By.xpath(tempJobID)).click();
							SetData.setJobDetails(driver, tempJobid_type, student);
							Thread.sleep(1000);

							// adding college as other
							System.out.println("Institute - " + student.institute);
							driver.findElement(By.xpath("//div[2]/form//div[3]//div[2]/input")).clear();
							driver.findElement(By.xpath("//div[2]/form//div[3]//div[2]/input")).sendKeys("Other");
							wait.until(ExpectedConditions
									.visibilityOfElementLocated(By.xpath("//div[3]//div[2]//strong")));
							// driver.findElement(By.xpath("//div[1]//div[3]//ul//div[2]/ul/li/a")).click();
							driver.findElement(By.xpath("//div[3]//div[2]//strong")).click();
							driver.findElement(By.xpath("//div[3]/div[1]/div/input")).clear();
							driver.findElement(By.xpath("//div[3]/div[1]/div/input")).sendKeys(student.institute);

							// adding college city & state as maharashtra now
							driver.findElement(By.xpath("//div[3]/div[2]/div[1]//input")).clear();
							System.out.println("Institute City  - " + student.college_city);
							driver.findElement(By.xpath("//div[3]/div[2]/div[1]//input"))
									.sendKeys(student.college_city);

							// selecting state
							int state_id = SetData.setState(student.college_state);
							String tempState = "//div[3]//div[3]//option[" + state_id + "]";
							driver.findElement(By.xpath("//ul//div[3]//select")).click();
							driver.findElement(By.xpath(tempState)).click();
							System.out.println("Institute State - " + student.college_state);

							// selecting degree
							int qualification_id = SetData.setDegree(student.degree);
							String tempDegree = "//form//ul//div[4]/select/option[" + qualification_id + "]";
							System.out.println("Degree - " + student.degree);
							driver.findElement(By.xpath("//div[1]//div[4]/select")).click();
							driver.findElement(By.xpath(tempDegree)).click();

							// col dates

							SetData.setCollegeFromDate(driver, student);

							System.out.println("Institue attended From - " + student.college_from_date
									+ " Institute completed Till " + student.college_to_date);
							SetData.setCollegeToDate(driver, student);

							if (driver.findElement(By.cssSelector("input[type='checkbox']")).isSelected()) {

							} else {
								driver.findElement(By.cssSelector("input[type='checkbox']")).click();

							}
							Thread.sleep(300);
							
							WebElement submitButton = driver.findElement(By.cssSelector("input[type='button']"));
							((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",submitButton);
							Thread.sleep(1000);

							driver.findElement(By.cssSelector("input[type='button']")).click();
							Thread.sleep(6000);

							if (driver.getCurrentUrl().equals(student.landingURL)) {
								System.out.println("profile updated successfull");
								System.out.println("Smoke PASS");
								driver.findElement(By.xpath(".//*[@id='dropdowndiv']/button")).click();
								Thread.sleep(500);
								driver.findElement(By.xpath(".//*[@id='menu1']/li[5]/a")).click();
								Thread.sleep(2000);
								// here exit
							}

							else {
								System.out.println("User unable to update profile.");
								System.out.println("Smoke failed");
								flag = false;
								System.out.println(driver.getCurrentUrl());
							}

						} else {
							WebElement element2 = driver.findElement(By.xpath("//div[1]//div[3]//div[3]/div"));
							// relative-path
							// //div[1]//div[1]/div[3]/form/div[3]/div
							System.out.println(element2.getText());
							System.out.println(
									"SMOKE FAIL- due to user unable to login with Invalid username and password.");
							flag = false;
						}
				}
			}
		}

		catch (InterruptedException e) {
			// System.err.println(e);
			System.out.println("Exiting Careerclap");
			flag= false;
		} catch (NoSuchElementException e) {
			System.out
					.println("you have used some driver elements, which is wrong in syntax or unreachable in browser.");
			flag= false;
			// TODO: handle exception
		} catch (UnreachableBrowserException e) {
			System.out.println("oops- fail to load website- check your network connection or firewall setting");
			// TODO: handle exception
			flag= false;

		} finally {
			driver.quit();
			endtime = System.currentTimeMillis();
			if (flag == true) {
				System.out.println("total time for updating profile = " + (endtime - starttime) / 6000 + " SECONDS");
			} else {
				System.out.println(
						"total time for updating profile but fail's is = " + (endtime - starttime) / 6000 + " SECONDS");

			}
		}

	}
}
