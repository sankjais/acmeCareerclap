package student;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tempSid_type = SetData.setSID("Aadhaar ID");
		System.out.println(tempSid_type);
		String tempSID ="//*[@id='studentId_selection']/option[" + tempSid_type + "]";
		System.out.println(tempSID);
	}

}
