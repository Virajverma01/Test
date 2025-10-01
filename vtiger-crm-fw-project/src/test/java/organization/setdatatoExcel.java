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

public class setdatatoExcel {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
	
		fileUtility fu = new fileUtility();
		
		fu.setDatatoExcel("setData",3, 0, "Google");
	}
	

}
