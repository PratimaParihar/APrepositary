package genericPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Flib {
	
	public String readPropertyData(String propPath,String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(propPath);
		Properties prop = new Properties();
		prop.load(fis);
		String data = prop.getProperty(key);
		return data;	
	}
	
	public String readExcelData(String excelPath, String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	{
		 FileInputStream fis= new FileInputStream(excelPath);
		 Workbook wb = WorkbookFactory.create(fis);
		 Sheet sheet = wb.getSheet(sheetName);
		 Row row=sheet.getRow(rowNo);
		 Cell cell=row.getCell(cellNo);
		 String data=cell.getStringCellValue().toString();
		
		 return data;
		
	}
	
	public int getLastRowCount(String excelPath, String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int rc = sheet.getLastRowNum();
		return rc;
	}
	
	public long readExcelData1(String excelPath, String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	{
		 FileInputStream fis= new FileInputStream(excelPath);
		 Workbook wb = WorkbookFactory.create(fis);
		 Sheet sheet = wb.getSheet(sheetName);
		 Row row=sheet.getRow(rowNo);
		 Cell cell=row.getCell(cellNo);
		// String data=cell.getStringCellValue().toString();
		 long data = (long) cell.getNumericCellValue();
		 return data;		
	}
	
	public int randomNumber()
	{
		Random rm = new Random();
		int random = rm.nextInt(1000);
		int rm1 = random + 1000;
		return rm1;
	}

}

