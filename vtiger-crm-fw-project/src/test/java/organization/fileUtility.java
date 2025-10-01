package organization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class fileUtility {
	
	public String getDataFromExcel(String sheetName, int Row, int Cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/testscriptdata.xlsx");

		Workbook wb = WorkbookFactory.create(fis);

		Sheet sr = wb.getSheet(sheetName);

		Row row = sr.getRow(Row);

		Cell cl = row.getCell(Cell);

		String org = cl.getStringCellValue();
		
		wb.close();
		
		return org;
	}
	
	
	public void setDatatoExcel(String sheetName, int Row , int Cell , String Value) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/testscriptdata.xlsx");

		Workbook wb = WorkbookFactory.create(fis);

		Sheet sr = wb.getSheet(sheetName);

		Row row = sr.createRow(Row);

		Cell cl = row.createCell(Cell);
		
		cl.setCellValue(Value);
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/testscriptdata.xlsx");
		wb.write(fos);
		
		wb.close();
		
		System.out.println("Data Set Succesfully on Excel");

	}
	

}
