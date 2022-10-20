package UtilitySwagLab;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UserIdData {
	
	public static String Para(int row,int cell,String Name) throws EncryptedDocumentException, IOException 
	{
		FileInputStream Src =new FileInputStream("C:\\Users\\pjagd\\eclipse-workspace\\SWAGLAB\\src\\main\\resources\\SwagLabUserPass.xls");
		String data = WorkbookFactory.create(Src).getSheet(Name).getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
}