package json;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Converts data in excel sheet to JSON file and objects 
 * @author Mohammad Yazdani
 */

public class ExelToJSON
{
  public static void main(String[] args)
  {
	String jsonFilePath = "E:\\data\\temperatures.json";
	String excelFilePath = "E:\\data\\temperatures.xlsx";

	// Gson is used to create a json object that is spaced nicely
	Gson gson = new GsonBuilder().setPrettyPrinting().create();

	// Instantiate the writer since we're writing to a JSON file.
	FileWriter writer = null;
	String jsonString = null;
	DailyTemp dailyTemp = null;

	FileInputStream excelFile = null;

	try
	{
	  excelFile = new FileInputStream(new File(excelFilePath));

	  // create FileWriter object for writing to JSON file
	  writer = new FileWriter(jsonFilePath);
	  // Object is converted to a JSON String

	  // Create Workbook instance holding reference to .xlsx file
	  XSSFWorkbook workbook = new XSSFWorkbook(excelFile);

	  // Get first/desired sheet from the workbook
	  XSSFSheet sheet = workbook.getSheetAt(0);

	  // Iterate through each rows one by one
	  Iterator<Row> rowIterator = sheet.iterator();
	  while (rowIterator.hasNext())
	  {
		Row row = rowIterator.next();
		// For each row, iterate through all the columns
		Iterator<Cell> cellIterator = row.cellIterator();

		while (cellIterator.hasNext())
		{
		  Cell cell = cellIterator.next();
		  if (cell.getCellType() != Cell.CELL_TYPE_STRING)
		  {
			dailyTemp = new DailyTemp();

			dailyTemp.setMinute((int) cell.getNumericCellValue());
			cell = cellIterator.next();
			dailyTemp.setTemp((float) cell.getNumericCellValue());
			// System.out.println(dailyTemp);
			jsonString = gson.toJson(dailyTemp) + ",\n";
			writer.write(jsonString);

		  }
		}
	  }
	  excelFile.close();
	  writer.close();
	} catch (Exception e)
	{
	  e.printStackTrace();
	}
  }

}
