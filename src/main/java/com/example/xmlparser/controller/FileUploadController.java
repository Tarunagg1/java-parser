package com.example.xmlparser.controller;

import com.example.xmlparser.model.Entry;
import com.example.xmlparser.service.ExcelService;
import com.example.xmlparser.service.XmlParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
public class FileUploadController {

    @Autowired
    private XmlParserService xmlParserService;

    @Autowired
    private ExcelService excelService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            List<Entry> entries = xmlParserService.parseXml(file.getInputStream());
            excelService.createExcelFile(entries);
            return ResponseEntity.ok("File processed successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error processing file: " + e.getMessage());
        }
    }
} 