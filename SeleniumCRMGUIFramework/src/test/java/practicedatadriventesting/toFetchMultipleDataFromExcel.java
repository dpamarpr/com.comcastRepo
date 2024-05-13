package practicedatadriventesting;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class toFetchMultipleDataFromExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis =new FileInputStream("./TestData/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet2");
		int row=sh.getLastRowNum();
		for(int i=1; i<=row; i++)
		{
			Row rw=sh.getRow(i);
			String data1=rw.getCell(0).toString();
			String data2=rw.getCell(1).toString();
			System.out.println(data1+"\t"+data2);
		}
		wb.close();
		
	}

}
