package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddDost {
	static boolean flag = true;

	static void addDost(WebDriver driver, String fname, String lname, String email, String number, String category,
			String status, String profileDescription) throws InterruptedException {

		long starttime = System.currentTimeMillis();
		long endtime = 0;
		WebDriverWait wait= new WebDriverWait(driver, 5000);
		try {

			Thread.sleep(1000);
			driver.findElement(By.xpath("//fieldset/div/ul/li[1]/a")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/form//div[1]/div[1]/input")));
			driver.findElement(By.xpath("//div/form//div[1]/div[1]/input")).sendKeys(fname);
			Thread.sleep(500);
			driver.findElement(By.xpath("//div/form//div[1]/div[2]/input")).sendKeys(lname);
			Thread.sleep(500);
			driver.findElement(By.xpath("//div/form//div[1]/div[3]/input")).sendKeys(email);
			Thread.sleep(500);
			driver.findElement(By.xpath("//div/form//div[3]/div[1]/input")).sendKeys(number);
			Thread.sleep(500);
			driver.findElement(By.xpath("//div/form//div[3]/div[2]/select")).click();
			// selecting category

			int dostcategory = 0;
			switch (category) {
			case "Career Dost":
				dostcategory = 2;
				break;
			case "Learning Dost":
				dostcategory = 3;
				break;
			case "College Fest Dost ":
				dostcategory = 4;
				break;
			case "Muscle Building and Nutrition Dost ":
				dostcategory = 5;
				break;
			case "Image Dost ":
				dostcategory = 6;
				break;
			case "Fashion & Lifestyle Management Dost ":
				dostcategory = 7;
				break;
			case "Public Speaking Dost ":
				dostcategory = 8;
				break;
			case "Weight Loss and Fitness Dost ":
				dostcategory = 9;
				break;

			default:
				System.out.println("Invalid Dost Category selected");
				break;
			}

			String tempcategory = "//div[2]/select/option[" + dostcategory + "]";
			Thread.sleep(500);
			driver.findElement(By.xpath(tempcategory)).click();

			driver.findElement(By.xpath("//div/form//div[3]/div[3]/select")).click();
			int doststatus = 0;
			switch (status) {
			case "Active":
				doststatus = 2;
				break;

			case "In-Active":
				doststatus = 3;
				break;

			case "Delete":
				doststatus = 4;
				break;

			default:
				System.err.println("Invalid dost stauts");
				break;

			}

			String tempstatus = "//div[3]/select/option[" + doststatus + "]";
			Thread.sleep(500);
			driver.findElement(By.xpath(tempstatus)).click();

			driver.findElement(By.xpath("//textarea")).sendKeys(profileDescription);
			Thread.sleep(1000);

		}

		catch (NoSuchElementException e) {
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
				System.out.println(
						"total time took for adding new Dost is = " + (endtime - starttime) / 6000 + " SECONDS");
			} else {
				System.out.println("total time took for adding new Dost but fail's is " + (endtime - starttime) / 6000
						+ " SECONDS");
			}
		}
	}
}
