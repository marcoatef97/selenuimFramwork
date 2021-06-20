package Test;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcel {

	public String[][] readSheet(String dataFile) throws InvalidFormatException, IOException
	{
		File myFile = new File(dataFile);
		XSSFWorkbook wb = new XSSFWorkbook(myFile);
		XSSFSheet mySheet = wb.getSheet("Sheet1");
		
		int rows = mySheet.getPhysicalNumberOfRows();
		int columns = mySheet.getRow(0).getLastCellNum();
		
		String[][] myArray = new String[rows-1][columns];
		
		for (int i=1 ; i<rows ; i++)
		{
			for (int a=0 ; a<columns ; a++)
			{
				XSSFRow row = mySheet.getRow(i);
				myArray[i-1][a] =row.getCell(a).getStringCellValue();
			}
		}
		
		return myArray;
	}
}
