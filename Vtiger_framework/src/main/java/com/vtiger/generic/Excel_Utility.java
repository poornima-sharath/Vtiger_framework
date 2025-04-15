package com.vtiger.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	/* Method to read the data from excel (External Resource)*/
	
	public String getDataFromExcel(String SheetName, int r , int c) throws Throwable {
		
		FileInputStream f = new FileInputStream("./data/Testdata.xlsx");
				Workbook book = WorkbookFactory.create(f);
				Cell cell = book.getSheet(SheetName).getRow(r).getCell(c);
				DataFormatter d =  new DataFormatter();
				String data = d.formatCellValue(cell);
				
		return data;
	}
	
	public void ExcelDataProvider() throws Throwable {
		
		FileInputStream f = new FileInputStream("./data/Testdata.xlsx");
		Workbook book = WorkbookFactory.create(f);
		Sheet sheet = book.getSheet("DataProvider");
		int lastRow = sheet.getLastRowNum();
		int lastCell = sheet.getRow(0).getLastCellNum();
		
		for(int i=0; i<=lastRow; i++) {
			for(int j=0; j<=lastCell; j++) {
				sheet.getRow(i).getCell(j);
			}
		}
	}
}
