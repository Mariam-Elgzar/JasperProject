//package com.example.Jasper.service;
//
//import net.sf.jasperreports.engine.*;
//
//import java.util.Map;
//
//public class ReportExporter {
//    public void exportInvoiceToPdf(Map<String, Object> parameters, JRDataSource dataSource, String outputPath) throws JRException {
//        // 1. Load the compiled report (.jasper)
//        JasperReport jasperReport = JasperCompileManager.compileReport(
//                getClass().getResourceAsStream("/reports/InvoiceItem.jrxml")
//        );
//
//        // 2. Fill the report with data and parameters
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
//
//        // 3. Export to PDF
//        JasperExportManager.exportReportToPdfFile(jasperPrint, outputPath);
//    }
//}
