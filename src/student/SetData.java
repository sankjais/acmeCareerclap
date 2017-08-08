package student;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetData {
	
	
	


	public static int setDegree(String degree) {
		int degreeCode = 0;
		switch (degree) {
		case "SSC":
			degreeCode = 2;
			break;
		case "HSC":
			degreeCode = 3;
			break;
		case "B.A":
			degreeCode = 4;
			break;
		case "B.Com":
			degreeCode = 5;
			break;
		case "B.S.C":
			degreeCode = 6;
			break;
		case "B.E/B.Tech":
			degreeCode = 7;
			break;
		case "M.Com":
			degreeCode = 8;
			break;
		case "B.B.M.":
			degreeCode = 9;
			break;
		case "B.M.S":
			degreeCode = 11;
			break;
		case "M.A.":
			degreeCode = 12;
			break;
		case "M.B.A":
			degreeCode = 13;
			break;
		case "M.E/M.Tech":
			degreeCode = 14;
			break;
		case "M.Sc":
			degreeCode = 15;
			break;
		case "Diploma":
			degreeCode = 16;
			break;
		case "B.Ed.":
			degreeCode = 17;
			break;
		case "M.C.A":
			degreeCode = 18;
			break;
		case "B.C.A":
			degreeCode = 19;
			break;
		case "B.C.S.":
			degreeCode = 20;
			break;
		case "B.B.A":
			degreeCode = 21;
			break;
		case "PhD":
			degreeCode = 22;
			break;
		case "M.Phil":
			degreeCode = 23;
			break;
		case "Other":
			degreeCode = 24;
			break;
		case "Law":
			degreeCode = 25;
			break;
		case "Architecture":
			degreeCode = 26;
			break;
		case "Hotel Management":
			degreeCode = 27;
			break;
		case "Nursing":
			degreeCode = 28;
			break;
		case "Vocational":
			degreeCode = 29;
			break;

		}

		return degreeCode;
	}// exit setDegree

	public static int setSID(String SID_type) {
		int id_type = 0;
		switch (SID_type) {
		case "Voter ID":
			id_type = 2;
			break;
		case "Aadhaar ID":
			id_type = 3;
			break;
		case "Driving License":
			id_type = 4;
			break;
		case "PAN card":
			id_type = 5;
			break;
		case "Ration Card":
			id_type = 6;
			break;

		}

		return id_type;
	}// exit setSID

	public static int setJobID(String JobID_type) {
		int id_type = 0;
		switch (JobID_type) {
		case "Working":
			id_type = 2;
			break;
		case "Offer In Hand":
			id_type = 3;
			break;
		case "Searching":
			id_type = 4;
			break;

		}

		return id_type;
	}// exit setJobID

	static void setJobDetails(WebDriver driver, int id, TestData student) throws InterruptedException {
		switch (id) {
		case 2: {
			driver.findElement(By.xpath("//div[2]/form//ul[3]/li[2]//select")).click();
			driver.findElement(By.xpath("//div[2]/form//ul[3]/li[2]//select")).click();
			driver.findElement(By.xpath("//ul[3]//li[2]/div[1]/select/option[2]")).click();
			driver.findElement(By.xpath("//div[2]/div[1]/div/input")).clear();
			System.out.println("Company name - " + student.company_name);
			driver.findElement(By.xpath("//div[2]/div[1]/div/input")).sendKeys(student.company_name);
			driver.findElement(By.xpath("//div[2]/div[2]/div/input")).clear();
			System.out.println("Designation - " + student.designation);
			driver.findElement(By.xpath("//div[2]/div[2]/div/input")).sendKeys(student.designation);
			driver.findElement(By.xpath("//div[2]/div[3]/div/input")).clear();
			System.out.println("CTC - " + student.CTC);
			driver.findElement(By.xpath("//div[2]/div[3]/div/input")).sendKeys(student.CTC);
			setWorkingFromDate(driver, student);
			System.out.println("From - " + student.working_from_date + " To - " + student.working_to_date);
			setWorkingToDate(driver, student);
			break;
		}

		case 3: {
			driver.findElement(By.xpath("//div[2]/form//ul[3]/li[2]//select")).click();
			driver.findElement(By.xpath("//div[2]/form//ul[3]/li[2]//select")).click();
			driver.findElement(By.xpath("//ul[3]//li[2]/div[1]/select/option[3]")).click();
			driver.findElement(By.xpath("//div[2]/div[1]/div/input")).clear();
			System.out.println("Company Name - " + student.company_name);
			driver.findElement(By.xpath("//div[2]/div[1]/div/input")).sendKeys(student.company_name);
			driver.findElement(By.xpath("//div[2]/div[2]/div/input")).clear();
			System.out.println("Designation - " + student.designation);
			driver.findElement(By.xpath("//div[2]/div[2]/div/input")).sendKeys(student.designation);
			driver.findElement(By.xpath("//div[2]/div[3]/div/input")).clear();
			System.out.println("CTC - " + student.CTC);
			driver.findElement(By.xpath("//div[2]/div[3]/div/input")).sendKeys(student.CTC);
			setWorkingFromDate(driver, student);
			System.out.println("From - " + student.working_from_date + " To - " + student.working_to_date);
			setWorkingToDate(driver, student);
			break;

		}

		case 4: {
			driver.findElement(By.xpath("//div[2]/form//ul[3]/li[2]//select")).click();
			driver.findElement(By.xpath("//div[2]/form//ul[3]/li[2]//select")).click();
			driver.findElement(By.xpath("//ul[3]//li[2]/div[1]/select/option[4]")).click();
			driver.findElement(By.xpath("//div[1]/div//ul[3]/li[2]/div[2]//input")).clear();
			System.out.println("Preferred Sector - " + student.preferred_sector);
			driver.findElement(By.xpath("//div[1]/div//ul[3]/li[2]/div[2]//input")).sendKeys(student.preferred_sector);
			break;
		}

		}
	}// exit setJobDetails

	static void setWorkingFromDate(WebDriver tempDriver, TestData student) throws InterruptedException

	{

		int YYYY;
		String temp, MM;
		temp = student.working_from_date;
		MM = temp.substring(0, 2);
		YYYY = Integer.parseInt(temp.substring(6, 10));
		tempDriver.findElement(By.name("working_startDate0")).click();
		Thread.sleep(500);
		tempDriver.findElement(By.xpath("//div[2]/div[4]/div[1]//input")).click();
		Thread.sleep(500);
		tempDriver.findElement(By.xpath("//div[2]/table/thead/tr[1]/th[2]")).click();
		Thread.sleep(300);
		int foo = 1;
		start: while (foo == 1) {
			List<WebElement> allDates = tempDriver.findElements(By.xpath("//div[4]/div[3]//td/span"));
			for (WebElement ele : allDates)

			{

				int year = Integer.parseInt(ele.getText());

				if (year > YYYY) {
					tempDriver.findElement(By.xpath("//div[3]//thead//th[1]")).click();
					Thread.sleep(500);
					continue start;
				}
				if (year == YYYY) {
					ele.click();
					Thread.sleep(500);

					switch (MM) {

					case "01":
						tempDriver.findElement(By.xpath("//div[2]//td/span[1]")).click();
						break;

					case "02":
						tempDriver.findElement(By.xpath("//div[2]//td/span[2]")).click();
						break;

					case "03":
						tempDriver.findElement(By.xpath("//div[2]//td/span[3]")).click();
						break;

					case "04":
						tempDriver.findElement(By.xpath("//div[2]//td/span[4]")).click();
						break;

					case "05":
						tempDriver.findElement(By.xpath("//div[2]//td/span[5]")).click();
						break;

					case "06":
						tempDriver.findElement(By.xpath("//div[2]//td/span[6]")).click();
						break;

					case "07":
						tempDriver.findElement(By.xpath("//div[2]//td/span[7]")).click();
						break;

					case "08":
						tempDriver.findElement(By.xpath("//div[2]//td/span[8]")).click();
						break;

					case "09":
						tempDriver.findElement(By.xpath("//div[2]//td/span[9]")).click();
						break;

					case "10":
						tempDriver.findElement(By.xpath("//div[2]//td/span[10]")).click();
						break;

					case "11":
						tempDriver.findElement(By.xpath("//div[2]//td/span[11]")).click();
						break;

					case "12":
						tempDriver.findElement(By.xpath("//div[2]//td/span[12]")).click();
						break;

					default:
						System.out.println(
								"invalid from date of working details imported from excel sheet, please check");
						break;

					}

					Thread.sleep(300);
					foo = 0;
					continue start;

				}

			}
		}

	}

	static void setWorkingToDate(WebDriver tempDriver, TestData student) throws InterruptedException

	{

		int  YYYY;
		String temp, MM;
		temp = student.working_to_date;
		MM = temp.substring(0, 2);
		YYYY = Integer.parseInt(temp.substring(6, 10));
		tempDriver.findElement(By.name("working_endDate0")).click();
		Thread.sleep(500);
		tempDriver.findElement(By.xpath("//div[2]/div[4]/div[2]//input")).click();
		Thread.sleep(500);
		tempDriver.findElement(By.xpath("//div[2]/table/thead/tr[1]/th[2]")).click();
		Thread.sleep(300);
		int foo = 1;
		start: while (foo == 1) {
			List<WebElement> allDates = tempDriver.findElements(By.xpath("//div[4]/div[3]//td/span"));
			for (WebElement ele : allDates)

			{

				int year = Integer.parseInt(ele.getText());

				if (year > YYYY) {
					tempDriver.findElement(By.xpath("//div[3]//thead//th[1]")).click();
					Thread.sleep(500);
					continue start;
				}
				if (year == YYYY) {
					ele.click();
					Thread.sleep(500);

					switch (MM) {

					case "01":
						tempDriver.findElement(By.xpath("//div[2]//td/span[1]")).click();
						break;

					case "02":
						tempDriver.findElement(By.xpath("//div[2]//td/span[2]")).click();
						break;

					case "03":
						tempDriver.findElement(By.xpath("//div[2]//td/span[3]")).click();
						break;

					case "04":
						tempDriver.findElement(By.xpath("//div[2]//td/span[4]")).click();
						break;

					case "05":
						tempDriver.findElement(By.xpath("//div[2]//td/span[5]")).click();
						break;

					case "06":
						tempDriver.findElement(By.xpath("//div[2]//td/span[6]")).click();
						break;

					case "07":
						tempDriver.findElement(By.xpath("//div[2]//td/span[7]")).click();
						break;

					case "08":
						tempDriver.findElement(By.xpath("//div[2]//td/span[8]")).click();
						break;

					case "09":
						tempDriver.findElement(By.xpath("//div[2]//td/span[9]")).click();
						break;

					case "10":
						tempDriver.findElement(By.xpath("//div[2]//td/span[10]")).click();
						break;

					case "11":
						tempDriver.findElement(By.xpath("//div[2]//td/span[11]")).click();
						break;

					case "12":
						tempDriver.findElement(By.xpath("//div[2]//td/span[12]")).click();
						break;

					default:
						System.out
								.println("invalid To date of working details imported from excel sheet, please check");
						break;

					}

					Thread.sleep(300);
					foo = 0;
					continue start;

				}

			}
		}

	}

	static void setCollegeFromDate(WebDriver tempDriver, TestData student) throws InterruptedException

	{

		int YYYY;
		String temp, MM;
		temp = student.college_from_date;
		MM = temp.substring(0, 2);
		YYYY = Integer.parseInt(temp.substring(6, 10));
		tempDriver.findElement(By.name("fromDate0")).click();
		Thread.sleep(500);
		//tempDriver.findElement(By.xpath("//div[2]//ul/div[1]/div/div[4]/div[1]//input")).click();
		Thread.sleep(500);
		tempDriver.findElement(By.xpath("//div[2]/table/thead/tr[1]/th[2]")).click();
		Thread.sleep(300);
		int foo = 1;
		start: while (foo == 1) {
			List<WebElement> allDates = tempDriver.findElements(By.xpath("//div[4]/div[3]//td/span"));
			for (WebElement ele : allDates)

			{

				int year = Integer.parseInt(ele.getText());

				if (year > YYYY) {
					tempDriver.findElement(By.xpath("//div[3]//thead//th[1]")).click();
					Thread.sleep(500);
					continue start;
				}
				if (year == YYYY) {
					ele.click();
					Thread.sleep(500);

					switch (MM) {

					case "01":
						tempDriver.findElement(By.xpath("//div[2]//td/span[1]")).click();
						break;

					case "02":
						tempDriver.findElement(By.xpath("//div[2]//td/span[2]")).click();
						break;

					case "03":
						tempDriver.findElement(By.xpath("//div[2]//td/span[3]")).click();
						break;

					case "04":
						tempDriver.findElement(By.xpath("//div[2]//td/span[4]")).click();
						break;

					case "05":
						tempDriver.findElement(By.xpath("//div[2]//td/span[5]")).click();
						break;

					case "06":
						tempDriver.findElement(By.xpath("//div[2]//td/span[6]")).click();
						break;

					case "07":
						tempDriver.findElement(By.xpath("//div[2]//td/span[7]")).click();
						break;

					case "08":
						tempDriver.findElement(By.xpath("//div[2]//td/span[8]")).click();
						break;

					case "09":
						tempDriver.findElement(By.xpath("//div[2]//td/span[9]")).click();
						break;

					case "10":
						tempDriver.findElement(By.xpath("//div[2]//td/span[10]")).click();
						break;

					case "11":
						tempDriver.findElement(By.xpath("//div[2]//td/span[11]")).click();
						break;

					case "12":
						tempDriver.findElement(By.xpath("//div[2]//td/span[12]")).click();
						break;

					default:
						System.out.println(
								"invalid from date of working details imported from excel sheet, please check");
						break;

					}

					Thread.sleep(300);
					foo = 0;
					continue start;

				}

			}
		}

	}


	static void setCollegeToDate(WebDriver tempDriver, TestData student) throws InterruptedException

	{

		int  YYYY;
		String temp, MM;
		temp = student.college_to_date;
		MM = temp.substring(0, 2);
		YYYY = Integer.parseInt(temp.substring(6, 10));
		tempDriver.findElement(By.name("toDate0")).click();
		Thread.sleep(500);
		//tempDriver.findElement(By.xpath("//div[4]//div[4]/div[2]//input")).click();
		Thread.sleep(500);
		tempDriver.findElement(By.xpath("//div[4]/div[2]//thead//th[2]")).click();
		Thread.sleep(300);
		int foo = 1;
		start: while (foo == 1) {
			List<WebElement> allDates = tempDriver.findElements(By.xpath("//div[4]/div[3]//td/span"));
			for (WebElement ele : allDates)

			{

				int year = Integer.parseInt(ele.getText());

				if (year > YYYY) {
					tempDriver.findElement(By.xpath("//div[3]//thead//th[1]")).click();
					Thread.sleep(500);
					continue start;
				}
				if (year == YYYY) {
					ele.click();
					Thread.sleep(500);

					switch (MM) {

					case "01":
						tempDriver.findElement(By.xpath("//div[2]//td/span[1]")).click();
						break;

					case "02":
						tempDriver.findElement(By.xpath("//div[2]//td/span[2]")).click();
						break;

					case "03":
						tempDriver.findElement(By.xpath("//div[2]//td/span[3]")).click();
						break;

					case "04":
						tempDriver.findElement(By.xpath("//div[2]//td/span[4]")).click();
						break;

					case "05":
						tempDriver.findElement(By.xpath("//div[2]//td/span[5]")).click();
						break;

					case "06":
						tempDriver.findElement(By.xpath("//div[2]//td/span[6]")).click();
						break;

					case "07":
						tempDriver.findElement(By.xpath("//div[2]//td/span[7]")).click();
						break;

					case "08":
						tempDriver.findElement(By.xpath("//div[2]//td/span[8]")).click();
						break;

					case "09":
						tempDriver.findElement(By.xpath("//div[2]//td/span[9]")).click();
						break;

					case "10":
						tempDriver.findElement(By.xpath("//div[2]//td/span[10]")).click();
						break;

					case "11":
						tempDriver.findElement(By.xpath("//div[2]//td/span[11]")).click();
						break;

					case "12":
						tempDriver.findElement(By.xpath("//div[2]//td/span[12]")).click();
						break;

					default:
						System.out.println(
								"invalid from date of working details imported from excel sheet, please check");
						break;

					}

					Thread.sleep(300);
					foo = 0;
					continue start;

				}

			}
		}

	}

	static void setDOB(WebDriver tempDriver, TestData student) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(tempDriver, 3000);
		int DD, YYYY;
		String temp, MM;
		temp = student.DOB;
		MM = temp.substring(0, 2);
		DD = Integer.parseInt(temp.substring(3, 5));
		YYYY = Integer.parseInt(temp.substring(6, 10));
		/*
		 * System.out.println(MM); System.out.println(DD);
		 * System.out.println(YYYY);
		 */
		tempDriver.findElement(By.name("dob")).click();
		Thread.sleep(500);
		tempDriver.findElement(By.xpath("//div[4]/div[1]//tr[1]/th[2]")).click();
		Thread.sleep(500);
		tempDriver.findElement(By.xpath("//div[4]/div[2]//tr/th[2]")).click();
		Thread.sleep(300);
		int foo = 1;
		start: while (foo == 1) {
			List<WebElement> allDates = tempDriver.findElements(By.xpath("//div[4]/div[3]//td/span"));
			for (WebElement ele : allDates)

			{
				// System.out.println(ele.getText());
				int year = Integer.parseInt(ele.getText());
				if (year > YYYY) {
					tempDriver.findElement(By.xpath("//div[4]/div[3]//thead//th[1]")).click();
					Thread.sleep(500);
					continue start;
				}
				if (year == YYYY) {
					ele.click();
					Thread.sleep(500);

					switch (MM) {

					case "01":
						tempDriver.findElement(By.xpath("//div[4]/div[2]//td/span[1]")).click();
						break;

					case "02":
						tempDriver.findElement(By.xpath("//div[4]/div[2]//td/span[2]")).click();
						break;

					case "03":
						tempDriver.findElement(By.xpath("//div[4]/div[2]//td/span[3]")).click();
						break;

					case "04":
						tempDriver.findElement(By.xpath("//div[4]/div[2]//td/span[4]")).click();
						break;

					case "05":
						tempDriver.findElement(By.xpath("//div[4]/div[2]//td/span[5]")).click();
						break;

					case "06":
						tempDriver.findElement(By.xpath("//div[4]/div[2]//td/span[6]")).click();
						break;

					case "07":
						tempDriver.findElement(By.xpath("//div[4]/div[2]//td/span[7]")).click();
						break;

					case "08":
						tempDriver.findElement(By.xpath("//div[4]/div[2]//td/span[8]")).click();
						break;

					case "09":
						tempDriver.findElement(By.xpath("//div[4]/div[2]//td/span[9]")).click();
						break;

					case "10":
						tempDriver.findElement(By.xpath("//div[4]/div[2]//td/span[10]")).click();
						break;

					case "11":
						tempDriver.findElement(By.xpath("//div[4]/div[2]//td/span[11]")).click();
						break;

					case "12":
						tempDriver.findElement(By.xpath("//div[4]/div[2]//td/span[12]")).click();
						break;

					default:
						System.out.println("invalid DOB imported from excel sheet, please check");
						break;

					}
					Thread.sleep(1000);
					List<WebElement> allDates1 = tempDriver.findElements(By.xpath("//div[4]/div[1]//td"));
					for (WebElement ele2 : allDates1)

					{
						// System.out.println(ele.getText());
						int dd = Integer.parseInt(ele2.getText());
						if (dd == DD) {
							wait.until(ExpectedConditions.visibilityOf(ele2));
							ele2.click();
							Thread.sleep(2000);
							// System.out.println("exec 1");
							foo = 0;
							continue start;
						}

					}

				}

			}
		}

	}

	public static int setState(String state) {
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

		}

		return stateCode;
	}

}
