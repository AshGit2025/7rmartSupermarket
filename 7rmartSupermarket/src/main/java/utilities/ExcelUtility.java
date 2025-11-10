package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constant;


public class ExcelUtility {

	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet s;

	public static String getStringData(int a, int b, String sheet) throws IOException
	{
		f= new FileInputStream(Constant.FILEPATH); // to fetch file location
		w= new XSSFWorkbook(f); // to get workbook from file
		s= w.getSheet(sheet); // to get corresponding sheet from workbook
		XSSFRow r= s.getRow(a); // to get row value
		XSSFCell c = r.getCell(b); // to get column
		
		return c.getStringCellValue();  //to return data in the cell
	}
		
		
	public static String getIntegerData(int a, int b, String sheet) throws IOException
	{
		f= new FileInputStream(Constant.FILEPATH); // to fetch file location
		w= new XSSFWorkbook(f); // to get workbook from file
		s= w.getSheet(sheet); // to get corresponding sheet from workbook
		XSSFRow r= s.getRow(a); // to get row value
		XSSFCell c = r.getCell(b); // to get column
		
		int x = (int) c.getNumericCellValue(); // to convert or typeCast default double data to integer
		return String.valueOf(x);
		
	}
	
	
}
