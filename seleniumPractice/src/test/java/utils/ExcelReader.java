package utils;

import builder.SignUpBuilder;
import entity.SignUp;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/**
 * Created by tester1 on 2/9/2017.
 */
public class ExcelReader {
    Workbook workbook;
    Sheet signUpDetailsSheet;

    public ExcelReader(String testData) {
        String excelFile= testData + ".xlsx";
        InputStream file= this.getClass().getClassLoader().getResourceAsStream(excelFile);

        try {
            workbook = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }


        signUpDetailsSheet = workbook.getSheet("signUpDetailsSheet");

    }




    private Cell getCellData(Sheet sheetName, Row dataRow, String header) {
        return dataRow.getCell(getCellNumber(sheetName,header), Row.CREATE_NULL_AS_BLANK);
    }



    private int getCellNumber(Sheet sheetName, String header) {
        int cellsize= sheetName.getRow(0).getPhysicalNumberOfCells();

        for (int cellNum = 0;cellNum < cellsize; cellNum++) {
            if (sheetName.getRow(0).getCell(cellNum).toString().equalsIgnoreCase(header))
                return cellNum;
        }
        throw new RuntimeException("No cell found for header: " + header);
    }



    private Row readDataRow(Sheet sheetName, String dataId) {
        Iterator<Row> rowIterator = sheetName.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            if (row.getCell(0).getStringCellValue().equalsIgnoreCase(dataId))
                return row;
        }
        throw new RuntimeException("No data found with this identifier: " + dataId);
    }



    public SignUp getSignUpDetails(String dataId) {
        Row dataRow = readDataRow(signUpDetailsSheet, dataId);

        String firstName= getCellData(signUpDetailsSheet, dataRow, "name").getStringCellValue();
        String lastName= getCellData(signUpDetailsSheet, dataRow,"lastName").getStringCellValue();
        String emailID= getCellData(signUpDetailsSheet,dataRow,"emailId").getStringCellValue();
        String password= getCellData(signUpDetailsSheet,dataRow,"password").getStringCellValue();

        System.out.println("firstname ==="+firstName);
        return new SignUpBuilder()
                .firstName(firstName)
                .lastName(lastName)
                .emailID(emailID)
                .password(password)
                .build();
    }
}
