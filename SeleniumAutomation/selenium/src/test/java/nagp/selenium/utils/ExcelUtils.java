package nagp.selenium.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import nagp.selenium.pageactions.HomePageAction;

public class ExcelUtils {

	private static final Logger LOGGER = LogManager.getLogger(ExcelUtils.class);

	/**
	 * This method is to read a column data from excle sheet
	 * 
	 * @param path
	 * @param column
	 * @return data of a column in excel
	 * @throws IOException
	 */
	public static List<String> getDataOfExcelColumn(String path, int column, int sheetNo) throws IOException {
		ArrayList<String> data = null;
		FileInputStream fis = null;
		try {
			data = new ArrayList<String>();
			fis = new FileInputStream(new File(path));
			XSSFWorkbook workBook = new XSSFWorkbook(fis);
			Sheet sheet = workBook.getSheetAt(sheetNo);
			for (Row row : sheet) {
				if (Optional.ofNullable(row.getCell(column).getStringCellValue()).isPresent()) {
					data.add(row.getCell(column).getStringCellValue());
				}
			}
		} catch (Exception e) {
			LOGGER.error("Some error encountered while fetching data from excel", e);
		} finally {
			fis.close();
		}
		return data;
	}
}
