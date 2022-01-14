package dataProvider;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import reusableMethods.baseClass;

public class ExcelData {
	static int rowCount;
	static int colCount;
	static XSSFSheet workSheet;
	static XSSFWorkbook sheet;

	@DataProvider(name = "getData")
	public Object[][] getData() throws IOException {

		String projectPath = System.getProperty("user.dir");

		sheet = new XSSFWorkbook(projectPath + "\\src\\test\\java\\resources\\Practice.xlsx");
		int count = sheet.getNumberOfSheets();

		String dataSheet = baseClass.getPropertyFile().getProperty("nameOfSheet");

		for (int i = 0; i < count; i++) {
			XSSFSheet indx = sheet.getSheetAt(i);
			if (sheet.getSheetName(i).equalsIgnoreCase(dataSheet)) {

				rowCount = indx.getLastRowNum() + 1;
				workSheet = sheet.getSheet(dataSheet);
				XSSFRow r = workSheet.getRow(i);
				colCount = r.getLastCellNum();
			}
		}

		Object[][] ob = new Object[rowCount - 1][colCount];
		for (int rowNum = 1; rowNum < rowCount; rowNum++) {
			for (int colNum = 0; colNum < colCount; colNum++) {
				XSSFRow rw = workSheet.getRow(rowNum);
				ob[rowNum - 1][colNum] = rw.getCell(colNum).getStringCellValue();
			}

		}
		return ob;
	}

}
