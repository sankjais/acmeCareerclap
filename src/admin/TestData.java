package admin;

public class TestData {

	String userID = "", password = "", fpassword = "",
			LoginURL = "http://acme.careerclap.com/#/adminLogin",
			updatePasswordURL = "http://acme.careerclap.com/#/changePassword",
			dashboardURL = "http://acme.careerclap.com/#/admindashboard";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long starttime = System.currentTimeMillis(), endtime = 0;
		try {

			TestData admin = new TestData();
			UpdatePassword.updatePassword(admin);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		finally {
			endtime= System.currentTimeMillis();
			System.out.println(
					"Total time taken for execution of all threads is - " + (endtime - starttime) / 6000 + " SECONDS");
		}

	}

}
