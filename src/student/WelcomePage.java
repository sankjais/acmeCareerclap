package student;

public class WelcomePage
//test
{
	static int dcode;

	public static int setDegree(String degree) {
		int degreeCode = 0;

		switch (degree) {

		case "SSC":
			degreeCode = 1;
			break;
		case "HSC":
			degreeCode = 2;
			break;
		case "B.A":
			degreeCode = 3;
			break;
		case "B.Com":
			degreeCode = 4;
			break;
		case "B.S.C":
			degreeCode = 5;
			break;
		case "B.E/B.Tech":
			degreeCode = 6;
			break;
		case "M.Com":
			degreeCode = 7;
			break;
		case "B.B.M.":
			degreeCode = 8;
			break;
		case "B.M.S":
			degreeCode = 9;
			break;
		case "M.A.":
			degreeCode = 10;
			break;
		case "M.B.A":
			degreeCode = 11;
			break;
		case "M.E/M.Tech":
			degreeCode = 12;
			break;
		case "M.Sc":
			degreeCode = 13;
			break;
		case "Diploma":
			degreeCode = 14;
			break;
		case "B.Ed.":
			degreeCode = 15;
			break;
		case "M.C.A":
			degreeCode = 16;
			break;
		case "B.C.A":
			degreeCode = 17;
			break;
		case "B.C.S.":
			degreeCode = 18;
			break;
		case "B.B.A":
			degreeCode = 19;
			break;
		case "PhD":
			degreeCode = 21;
			break;
		case "M.Phil":
			degreeCode = 22;
			break;
		case "Other":
			degreeCode = 22;
			break;
		case "Law":
			degreeCode = 23;
			break;
		case "Architecture":
			degreeCode = 24;
			break;
		case "Hotel Management":
			degreeCode = 25;
			break;
		case "Nursing":
			degreeCode = 26;
			break;
		case "Vocational":
			degreeCode = 27;
			break;

		}

		return degreeCode;

	}

}
