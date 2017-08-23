package admin;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddInstitute {

	static boolean flag = true;
	 


	static void add(WebDriver driver, String Institute, String city, String state) throws InterruptedException {
		
		long starttime = System.currentTimeMillis();
		long endtime = 0;
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			driver.findElement(By.id("collegeName")).sendKeys(Institute);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[1]/div/div[2]/div/div/input")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//div[1]/div/div[2]/div/div/input")).sendKeys(city);
			Thread.sleep(1000);

			int stateCode = 0;
			switch (state) {
			case "Andhra Pradesh":
				stateCode = 2;
				break;
			case "Arunachal Pradesh":
				stateCode = 3;
				break;
			case "Andaman and Nicobar":
				stateCode = 4;
				break;
			case "Assam":
				stateCode = 5;
				break;
			case "Bihar":
				stateCode = 6;
				break;
			case "Chhattisgarh":
				stateCode = 7;
				break;
			case "Chandigarh":
				stateCode = 8;
				break;
			case "Dadra and Nagar Haveli":
				stateCode = 9;
				break;
			case "Daman and Diu":
				stateCode = 10;
				break;
			case "Delhi":
				stateCode = 11;
				break;
			case "Goa":
				stateCode = 12;
				break;
			case "Gujarat":
				stateCode = 13;
				break;
			case "Haryana":
				stateCode = 14;
				break;
			case "Himachal Pradesh":
				stateCode = 15;
				break;
			case "Jammu and Kashmir":
				stateCode = 16;
				break;
			case "Jharkhand":
				stateCode = 17;
				break;
			case "Karnataka":
				stateCode = 18;
				break;
			case "Kerala":
				stateCode = 19;
				break;
			case "Lakshadweep":
				stateCode = 20;
				break;
			case "Madhya Pradesh":
				stateCode = 21;
				break;
			case "Maharashtra":
				stateCode = 22;
				break;
			case "Manipur":
				stateCode = 23;
				break;
			case "Meghalaya":
				stateCode = 24;
				break;
			case "Mizoram":
				stateCode = 25;
				break;
			case "Nagaland":
				stateCode = 26;
				break;
			case "Orissa":
				stateCode = 27;
				break;
			case "Punjab":
				stateCode = 28;
				break;
			case "Pondicherry":
				stateCode = 29;
				break;
			case "Rajasthan":
				stateCode = 30;
				break;
			case "Sikkim":
				stateCode = 31;
				break;
			case "Tamil Nadu":
				stateCode = 32;
				break;
			case "Telangana":
				stateCode = 33;
				break;
			case "Tripura":
				stateCode = 34;
				break;
			case "Uttar Pradesh":
				stateCode = 35;
				break;
			case "Uttarakhand":
				stateCode = 36;
				break;
			case "West Bengal":
				stateCode = 37;
				break;
			default:
				System.out.println("Invalid State selected");
				break;

			}

			String tempState = "//div[3]/div/div/select/option[" + stateCode + "]";
			driver.findElement(By.xpath("//div[3]/div/div/select")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(tempState)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//form/div[2]//button[1]")).click();
			

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[3]//span/span/span")));
			if (driver.findElement(By.xpath("//div[3]//span/span/span")).getText()
					.equalsIgnoreCase(Institute+"  Institute Saved Successfully.....!")) {
				System.out.println("Institute Saved Successfully");
			}
			else{
				System.out.println("failed to add institute");
				flag=false;
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Failed to add new institue");
			flag = false;
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
				System.out.println("total time took for adding new Institue is = " + (endtime - starttime) / 6000
						+ " SECONDS");
			} else {
				System.out.println("total time took for adding new Institue is but fail's is "
						+ (endtime - starttime) / 6000 + " SECONDS");
			}
		}

	}

}
