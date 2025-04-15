package DDT;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchingDatafromPDF {
	
	public static void main(String[] args) throws Throwable {
		
		File file = new File("data/FLY_Bus_ticket.pdf");
		
		PDDocument doc = PDDocument.load(file);
		int pages = doc.getNumberOfPages();
		System.out.println(pages);
		
		PDFTextStripper pdfData = new PDFTextStripper();
		//String readPdf = pdfData.getText(doc);
		/* Fetches all the pages from pdf */
		//System.out.println(readPdf);
		
		pdfData.setStartPage(2);
		pdfData.setEndPage(2);
		/* Reads only the prescribed page */
		String readPdf1 = pdfData.getText(doc);
		System.out.println(readPdf1);
		}
}
