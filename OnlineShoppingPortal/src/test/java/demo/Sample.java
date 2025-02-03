package demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import genericPackage.Flib;
import genericPackage.IAutoConstant;

public class Sample implements IAutoConstant{
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String dateTime = LocalDateTime.now().toString();
		String newdateTime = dateTime.replaceAll(":", "-");
		System.out.println(newdateTime);
//		
//	Flib flib = new Flib();	
//	for(int i=1;i<=4;i++)
//	{
//		String email=flib.readExcelData(EXCEL_PATH, "InvalidLoginCreds", i, 0);
//		System.out.println(email);
//		
//		String pwd=flib.readExcelData(EXCEL_PATH, "InvalidLoginCreds", i, 1);
//		System.out.println(pwd);
//	}
	}
}
