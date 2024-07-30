package apache.xls;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import lombok.extern.java.Log;
import org.apache.commons.math3.util.Pair;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log
public class ReadXls {

    public static void main(String[] args) {

        String xlsFilePath = "MavenModule/src/main/java/apache/xls/dataForReadingInJava.xlsx";

        try (InputStream inputStream = new FileInputStream(xlsFilePath);
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Map<String, Table<Integer, Integer, Double>> sheetTableMap = new HashMap<>();
            for (Sheet sheet : workbook) {
                var nofRowsAndCols=nofRowsAndCols(sheet);
                String sheetName = sheet.getSheetName();
                var table = getTable(sheet);
                sheetTableMap.put(sheetName, table);
                log.info("Sheet="+sheetName+", nofRowsAndCols = " + nofRowsAndCols);
            }
            sheetTableMap.entrySet().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Pair<Integer,Integer> nofRowsAndCols(Sheet sheet) {
        int numberOfRows = sheet.getLastRowNum() + 1;
        // Get the number of columns
        int numberOfColumns = 0;
        for (Row row : sheet) {
            if (row.getLastCellNum() > numberOfColumns) {
                numberOfColumns = row.getLastCellNum();
            }
        }
        return Pair.create(numberOfRows,numberOfColumns);
    }

    private static Table<Integer, Integer, Double> getTable(Sheet sheet) {
        Table<Integer, Integer, Double> table = HashBasedTable.create();
        for (Row row : sheet) {
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case STRING -> log.info("String data excluded, sheet=" + sheet.getSheetName() + ", cell=" + cell);
                    case NUMERIC -> table.put(cell.getRowIndex(), cell.getColumnIndex(), cell.getNumericCellValue());
                    default -> log.warning("Unknown cell type, sheet=" + sheet.getSheetName());
                }
            }
        }
        return table;
    }
}
