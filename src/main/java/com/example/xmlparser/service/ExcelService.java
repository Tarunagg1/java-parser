package com.example.xmlparser.service;

import com.example.xmlparser.model.Entry;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private XmlParserService xmlParserService;

    public void createExcelFile(List<Entry> entries) throws Exception {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Parsed Data");

        // Create headers
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Title");
        headerRow.createCell(1).setCellValue("Has Number");
        headerRow.createCell(2).setCellValue("YouTube Link");

        // Create data rows
        int rowNum = 1;
        for (Entry entry : entries) {
            Row dataRow = sheet.createRow(rowNum++);
            dataRow.createCell(0).setCellValue(entry.getTitle());
            dataRow.createCell(1).setCellValue(xmlParserService.hasNumber(entry.getTitle()));
            dataRow.createCell(2).setCellValue(xmlParserService.extractYoutubeLink(entry.getContent()));
        }

        // Create parsed directory if it doesn't exist
        java.io.File dir = new java.io.File("parsed");
        if (!dir.exists()) {
            dir.mkdir();
        }

        // Save file with timestamp
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String fileName = "parsed/output_" + timestamp + ".xlsx";
        
        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            workbook.write(fileOut);
        }
        workbook.close();
    }
}