package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDataintoExcel {
	
	public static void main(String[] args) throws Throwable {
		
		FileInputStream f = new FileInputStream(".\\data\\testdata.xlsx");
		Workbook book = WorkbookFactory.create(f);
		book.getSheet("WriteData").createRow(0).createCell(0).setCellValue("Tarushi");
		book.getSheet("Sheet1").createRow(1).createCell(1).setCellValue(27);
		FileOutputStream f2 = new FileOutputStream(".\\data\\testdata.xlsx");
		book.write(f2);
		book.close();
	}

}
