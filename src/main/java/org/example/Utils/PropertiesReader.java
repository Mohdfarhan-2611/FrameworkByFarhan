package org.example.Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class PropertiesReader {

    private PropertiesReader() {
    }

    private static Properties properties = new Properties();
    private static final String PROPERTYREADERPATH = System.getProperty("user.dir") + "/src/test/resources/data.properties";
    private static final String DATAPATH = System.getProperty("user.dir") + "/src/main/resources/Avibra Test_Data2.xlsx";
    private static final Map<String, String> propertyreadermap = new HashMap<>();

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream(PROPERTYREADERPATH);
            properties.load(fileInputStream);
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                propertyreadermap.put(String.valueOf(entry.getKey()).toLowerCase(), String.valueOf(entry.getValue()).trim());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Read data from data properties
    public static String readKey(String key) throws Exception {
        if (Objects.isNull(key) || Objects.isNull(propertyreadermap.get(key.toLowerCase()))) {
            throw new Exception("Property name " + key + " is not found in PropertyReader");
        }
        return propertyreadermap.get(key.toLowerCase());
    }

    // Method to read Excel data with null/empty handling
    public static Object[][] readTestDataFromExcel() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(DATAPATH);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheetAt(0); // Assuming first sheet contains data

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        List<Object[]> filteredData = new ArrayList<>();

        for (int i = 1; i < rowCount; i++) {  // Start from row 1 (skip header)
            Row row = sheet.getRow(i);
            if (row == null) continue; // Skip null rows

            Object[] rowData = new Object[colCount];
            boolean isRowValid = false;

            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                if (cell == null || cell.getCellType() == CellType.BLANK) {
                    rowData[j] = "";  // Assign empty string for blank cells
                } else {
                    rowData[j] = cell.toString().trim();
                }

                // Mark row as valid if it contains non-empty username & password
                if (!rowData[j].toString().isEmpty()) {
                    isRowValid = true;
                }
            }

            if (isRowValid) {
                filteredData.add(rowData);
            } else {
                System.out.println("Skipping invalid row due to empty username/password: " + Arrays.toString(rowData));
            }
        }

        workbook.close();
        fileInputStream.close();

        return filteredData.toArray(new Object[0][0]);
    }
}
