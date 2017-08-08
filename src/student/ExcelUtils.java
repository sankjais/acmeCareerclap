package student;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils
{
	
	private XSSFSheet ExcelWSheet;
	private XSSFWorkbook ExcelWBook;
	   
	   //Constructor to connect to the Excel with sheetname and Path
	   public  ExcelUtils(String Path, String SheetName) throws Exception {
	   
	      try {
	         // Open the Excel file
	         FileInputStream ExcelFile = new FileInputStream(Path);
	         
	         // Access the required test data sheet
	         ExcelWBook = new XSSFWorkbook(ExcelFile);
	         ExcelWSheet = ExcelWBook.getSheet(SheetName);
	      }
	      catch (Exception e){
	         throw (e);
	         }
	      }
	      
	   //This method is to set the rowcount of the excel.
	   public int excel_get_rows() throws Exception {
	   
	      try{
	         return ExcelWSheet.getPhysicalNumberOfRows();
	      }
	      catch (Exception e){
	         throw (e);
	      }
	   }
	   public short excel_get_columns() throws Exception {
		   
		      try{
		         return ExcelWSheet.getRow(0).getLastCellNum();//getPhysicalNumberOfRows();
		      }
		      catch (Exception e){
		         throw (e);
		      }
	   }
	   
	   //This method to get the data and get the value as strings.
	   public String getCellDataasstring(int RowNum, int ColNum) throws Exception {
	   
	      try {
	         String CellData = ExcelWSheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
	         //System.out.println(CellData);
	         return CellData;
	      }
	      catch (Exception e) {
	    	  //System.err.println(e);
	       return "Errors in Getting Cell Data";
	      }
	   }
	   
	   //This method to get the data and get the value as number.
	   public double getCellDataasnumber(int RowNum, int ColNum) throws Exception {
	   
	      try {
	         double CellData = ExcelWSheet.getRow(RowNum).getCell(ColNum).getNumericCellValue();
	         System.out.println("The value of CellData " + CellData);
	         return CellData;
	      }
	      catch (Exception e){
	         return 000.00;
	      }
	   }	
	   
	   
		   }
	


