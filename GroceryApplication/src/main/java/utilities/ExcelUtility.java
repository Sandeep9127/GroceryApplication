package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public  String readGroceryData(String path,int a,int b) throws IOException
	{
	FileInputStream file = new FileInputStream(path);
	XSSFWorkbook workbook=new XSSFWorkbook(file);
	XSSFSheet sheets=workbook.getSheet("Sheet1");
	XSSFRow row=sheets.getRow(a);
	XSSFCell cell=row.getCell(b);
	String userName=cell.getStringCellValue();
	return userName;
	}
	/*public String readPassWord(String path,int a,int b) throws IOException
	{
	FileInputStream file = new FileInputStream(path);
	XSSFWorkbook workbook=new XSSFWorkbook(file);
	XSSFSheet sheets=workbook.getSheet("Sheet1");
	XSSFRow row=sheets.getRow(a);
	XSSFCell cell=row.getCell(b);
	String passWord=cell.getStringCellValue();
	return passWord;
	}*/


}
