package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDatafromExel {
	
	public static void main(String[] args) throws Throwable {
		
		FileInputStream f = new FileInputStream(".\\data\\testdata.xlsx");
		Workbook book = WorkbookFactory.create(f);
		String Data = book.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
		System.out.println(Data);
		Cell numData = book.getSheet("Sheet1").getRow(0).getCell(1);
		/* Object of data formatter is created to read the data of all types */
		DataFormatter excelData = new DataFormatter();
		String data = excelData.formatCellValue(numData);
		System.out.println(data);
		 Cell SpecialChar = book.getSheet("Sheet1").getRow(0).getCell(2);
		 String specData = excelData.formatCellValue(SpecialChar);
		System.out.println(specData);
		
	}
}
