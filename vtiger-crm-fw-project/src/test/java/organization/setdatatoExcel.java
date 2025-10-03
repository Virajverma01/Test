package organization;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;


public class setdatatoExcel {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
	
		fileUtility fu = new fileUtility();
		
			fu.setDatatoExcel("setData",3, 0, "Google");
	}
	
}
