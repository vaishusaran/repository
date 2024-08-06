package LinenChest_Project.DemoQA1;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class SigninInExcel {
	
	public static String readXl(int j, int i) throws IOException, BiffException{
	
	Workbook wb;
	String username="";
	// String password="";
	File inputWorkbook = new File("C:\\Users\\assar\\Documents\\Selenium\\test.xls");
	try {
		wb = Workbook.getWorkbook(inputWorkbook);
		Sheet sheet = wb.getSheet(0);
			username =sheet.getCell(j, i).getContents();
			//password =sheet.getCell(1, i).getContents();
		
		}catch (IOException e) {
			
		}
	return username;
	
	}

	public static void main (String args []) throws InterruptedException, BiffException, IOException
	{
		SigninInExcel rds=new SigninInExcel();
		String outputt=rds.readXl(0, 1);
		System.out.println(outputt);
		
	}
}
	

	
//Reading ROw and coloumn from Excel
	/*public static void main(String args[]) throws IOException{
		
	File file = new File("C:\\Users\\assar\\Documents\\Selenium\\LinenchestLogin.xlsx");
	FileInputStream inputstream = new FileInputStream(file);
	XSSFWorkbook wb = new XSSFWorkbook(inputstream);

	//Getting sheet
	XSSFSheet sheet = wb.getSheetAt(0);
	
	/*Row row=sheet.getRow(0);
	Cell cell=row.getCell(0);
	System.out.println(sheet.getRow(0).getCell(0));
	
	Row row1 =sheet.getRow(1);
	Cell cell1 = row.getCell(0);
	System.out.println(sheet.getRow(1).getCell(0));
	
	Row row2=sheet.getRow(0);
	Cell cell2=row.getCell(1);
	System.out.println(sheet.getRow(0).getCell(1));
	
	Row row3=sheet.getRow(1);
	Cell cell3=row.getCell(1);
	System.out.println(sheet.getRow(1).getCell(1));*/
	// Read the Entire excel sheet.
/*	int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
	for(int i=0; i<=rowCount; i++) {
		int cellCount= sheet.getRow(i).getLastCellNum();
		System.out.println("row value is " +i);
		
		
		for(int j=0; j<cellCount; j++)
		{
			System.out.println(sheet.getRow(i).getCell(j).getStringCellValue()+",");
			
		}
		System.out.println();
	}}*/
	

