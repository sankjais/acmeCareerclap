package student;

public class TestData

{

	String userID, password, fpassword, firstname, middlename, lastname, contact, email = userID, DOB, gender, SID,
			SID_type, address, job_status, preferred_sector, company_name, designation, working_from_date,
			working_to_date, CTC, institute, degree, college_from_date, college_to_date, college_city, college_state,
			welcomeURL = "http://acme.careerclap.com/", LoginURL = "http://acme.careerclap.com/#/login",
			updatePasswordURL = "http://acme.careerclap.com/#/ftupdatePassword",
			profileURL = "http://acme.careerclap.com/#/userInfo",
			landingURL = "http://acme.careerclap.com/#/studentLanding",
			barclayStartURL = "http://acme.careerclap.com/#/beginYourJourney",
			practiceAssessmentInstructions = "http://acme.careerclap.com/#/barclayspracticeInstructions",
			barclaysAssessmentInstructions ="http://acme.careerclap.com/#/beginYourJourneyInstructions",
			barclaysQuiz = "http://acme.careerclap.com/#/commonquiz", checkURL = "http://acme.careerclap.com/#/",
			barclaysCompletion="http://acme.careerclap.com/#/beginYourJourneyCompletion";

	public static void main(String[] args)

	{
		long starttime = System.currentTimeMillis(), endtime;
		TestData testdata = new TestData();
		// GTTLogin login= new GTTLogin();
		// UpdatePassword passwordUpdate = new UpdatePassword();
		// StudentProfile profileUpdate = new StudentProfile();

		StudentLanding landingTest = new StudentLanding();

		try {

			ExcelUtils dd;
			// dd = new ExcelUtils("student.temp","Sheet2");

			dd = new ExcelUtils("D:\\sanket data\\Careerclap data\\temp\\user.xlsx", "Sheet2");
			System.out.println("The Row count is " + (dd.excel_get_rows() - 1));
			System.out.println("The column count is " + dd.excel_get_columns());
			int rows = dd.excel_get_rows(), cols = dd.excel_get_columns();
			String[][] tdata = new String[rows][cols];

			for (int r = 1; r < rows; r++)
				for (int c = 0; c < cols; c++) {
					tdata[r][c] = dd.getCellDataasstring(r, c);
				}

			for (int r = 1; r < rows; r++) {
				testdata.userID = tdata[r][0];
				testdata.password = tdata[r][1];
				testdata.fpassword = tdata[r][2];
				testdata.firstname = tdata[r][3];
				testdata.middlename = tdata[r][4];
				testdata.lastname = tdata[r][5];
				testdata.contact = tdata[r][6];
				testdata.email = tdata[r][0];
				testdata.gender = tdata[r][7];
				testdata.SID = tdata[r][10];
				testdata.SID_type = tdata[r][9];
				testdata.address = tdata[r][11];
				testdata.job_status = tdata[r][12];
				testdata.company_name = tdata[r][13];
				testdata.designation = tdata[r][14];
				testdata.working_from_date = tdata[r][16];
				testdata.working_to_date = tdata[r][17];
				testdata.CTC = tdata[r][15];
				testdata.institute = tdata[r][18];
				testdata.degree = tdata[r][19];
				testdata.college_from_date = tdata[r][20];
				testdata.college_to_date = tdata[r][21];
				testdata.DOB = tdata[r][8];
				testdata.preferred_sector = tdata[r][22];
				testdata.college_city = tdata[r][23];
				testdata.college_state = tdata[r][24];
				System.out.println("login through new user- please wait \n *********************  " + testdata.userID
						+ "  *********************\n");

				// login.validLogin(testdata);
				// passwordUpdate.updatePassword(testdata);
				// profileUpdate.updateProfile(testdata);
				landingTest.barclaysTest(testdata);

			}

		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			endtime = System.currentTimeMillis();
			System.out.println("Total Time for Executing all threads = " + (endtime - starttime) / 6000 + " SECONDS");
		}

	}
}
