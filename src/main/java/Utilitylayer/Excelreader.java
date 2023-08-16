package Utilitylayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelreader {

	XSSFWorkbook workbook;

	public Excelreader(String filePath) throws IOException {
		File f = new File(filePath);
		FileInputStream fis = new FileInputStream(f);
		workbook = new XSSFWorkbook(fis);

	}

	public int getallrow(int sheetindex) {
		return workbook.getSheetAt(sheetindex).getLastRowNum() + 1;
	}

	public int getallcell(int sheetindex) {
		return workbook.getSheetAt(sheetindex).getRow(0).getLastCellNum();
	}

	public Object getspecificdata(int sheetindex, int rows, int cells) {
		XSSFCell cell = workbook.getSheetAt(sheetindex).getRow(rows).getCell(cells);
		if (cell == null) {
			return "";
		}

		if (cell != null) {

			if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
				return cell.getRawValue();
			} else if (cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
				return cell.getBooleanCellValue();
			} else if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellType() == XSSFCell.CELL_TYPE_FORMULA) {
				return cell.getCellFormula();
			}

		}

		return null;
	}

	public Object getallsheetdata(int sheetindex) {

		int rows = getallrow(sheetindex);
		int cells = getallcell(sheetindex);

		Object[][] data = new Object[rows][cells];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cells; j++) {
				data[i][j] = getspecificdata(sheetindex, i, j);
			}
		}
		return data;

	}

}
