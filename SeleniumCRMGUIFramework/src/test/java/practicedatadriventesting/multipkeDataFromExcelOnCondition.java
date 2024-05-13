package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class multipkeDataFromExcelOnCondition {

	public static void main(String[] args) throws Throwable, IOException {
		String expectedcompany="samsung";
		String data1="";
		String data2="";
		String data3="";
		FileInputStream fis= new FileInputStream("‪C:\\Users\\ACER\\OneDrive\\Desktop\\code2\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet("org");
		int rw =sh.getLastRowNum();
		for(int i=1;i<=rw; i++)
		{
		    String data="";
			 data=sh.getRow(i).getCell(0).toString();
			if(data.equals(expectedcompany)) {
			
			 data1=sh.getRow(i).getCell(1).toString();
			 data2=sh.getRow(i).getCell(1).toString();
			 data3=sh.getRow(i).getCell(2).toString();
				
			}
		
		System.out.print(data1);
		System.out.print(data2);
		System.out.print(data3);
		}
	}

}
