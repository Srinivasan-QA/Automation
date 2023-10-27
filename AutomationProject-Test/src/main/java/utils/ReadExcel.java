package utils;


import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static void main(String[] args) throws IOException {
		
		// Finding the file location
		String filelocation = "./test-data/Login.xlsx";
		//
		XSSFWorkbook wbook = new XSSFWorkbook(filelocation);
		XSSFSheet sheet = wbook.getSheetAt(0);
		for (int i = 1; i <= args.length; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j <= args.length; j++) {
				XSSFCell cell = row.getCell(j);
				String value = cell.getStringCellValue();
				System.out.println(value);
			}
		}
		wbook.close();
	}

}
