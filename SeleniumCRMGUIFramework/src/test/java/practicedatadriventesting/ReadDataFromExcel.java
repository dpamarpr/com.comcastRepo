package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//get the excel path location & java object of the physical file
		FileInputStream fis =new FileInputStream("./TestData/Book1.xlsx");
		
		// open the workbook in read mode
		Workbook wb = WorkbookFactory.create(fis);
		
		//get the control of the sheet
		Sheet sh = wb.getSheet("sheet2");
		
		//get the control of the row
		 Row row=sh.getRow(2);
		 
		//get the control of the cell
		 Cell cell=row.getCell(1);
		 String data= cell.getStringCellValue();
		 
		 System.out.println(data);
		 
		 // close the workbook
		 wb.close();
		 
		 
		
		
		
		

	}

}
  