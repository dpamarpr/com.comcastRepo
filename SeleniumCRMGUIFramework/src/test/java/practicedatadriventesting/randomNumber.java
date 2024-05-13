package practicedatadriventesting;

import java.io.FileInputStream;
import java.util.*;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class randomNumber {

	public static void main(String[] args) throws Throwable {
	                
		Random rd=new Random();
		int ran=rd.nextInt(1000);
		
		FileInputStream fis= new FileInputStream("C:\\Users\\ACER\\OneDrive\\Documents\\testdata\\Book1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet3");
		String row=sh.getRow(1).getCell(0).getStringCellValue()+ran;
		
		System.out.println(row);
		
	}

}
