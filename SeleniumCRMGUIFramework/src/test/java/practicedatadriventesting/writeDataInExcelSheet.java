package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class writeDataInExcelSheet {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis =new FileInputStream("./TestData/Book1.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh= wb.getSheet("Sheet3");
			Row rw= sh.getRow(1);
			Cell cell=rw.createCell(4);
			cell.setCellValue("amar");
			
			FileOutputStream fos=new FileOutputStream("./TestData/Book1.xlsx");
			wb.write(fos);
			wb.close();
	}

}
