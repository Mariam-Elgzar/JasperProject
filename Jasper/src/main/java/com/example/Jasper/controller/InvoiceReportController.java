package com.example.Jasper.controller;
import com.example.Jasper.model.InvoiceData;
import com.example.Jasper.service.InvoiceReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "*")
public class InvoiceReportController {

    @Autowired
    private InvoiceReportService invoiceReportService;

    /**
     * Generate invoice report PDF - all invoices
     * GET /api/reports/invoice/pdf
     */
    @GetMapping("/invoice/pdf")
    public ResponseEntity<byte[]> generateInvoiceReportPdf() {
        try {
            byte[] pdfBytes = invoiceReportService.generateInvoiceReportPdf();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "invoice-report.pdf");
            headers.setContentLength(pdfBytes.length);

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(("Error generating PDF: " + e.getMessage()).getBytes());
        }
    }

    /**
     * Generate invoice report PDF for specific invoice numbers
     * POST /api/reports/invoice/pdf/by-numbers
     */
    @PostMapping("/invoice/pdf/by-numbers")
    public ResponseEntity<byte[]> generateInvoiceReportPdfByNumbers(@RequestBody List<String> invoiceNumbers) {
        try {
            if (invoiceNumbers == null || invoiceNumbers.isEmpty()) {
                return ResponseEntity.badRequest()
                        .body("Invoice numbers are required".getBytes());
            }

            byte[] pdfBytes = invoiceReportService.generateInvoiceReportPdfByInvoices(invoiceNumbers);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "invoice-report-filtered.pdf");
            headers.setContentLength(pdfBytes.length);

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(("Error generating PDF: " + e.getMessage()).getBytes());
        }
    }

    /**
     * Generate invoice report PDF from provided data
     * POST /api/reports/invoice/pdf/from-data
     */
    @PostMapping("/invoice/pdf/from-data")
    public ResponseEntity<byte[]> generateInvoiceReportPdfFromData(@RequestBody List<InvoiceData> invoiceData) {
        try {
            if (invoiceData == null || invoiceData.isEmpty()) {
                return ResponseEntity.badRequest()
                        .body("Invoice data is required".getBytes());
            }

            byte[] pdfBytes = invoiceReportService.generateInvoiceReportPdfFromBeans(invoiceData);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "invoice-report-custom.pdf");
            headers.setContentLength(pdfBytes.length);

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(("Error generating PDF: " + e.getMessage()).getBytes());
        }
    }

    /**
     * Preview invoice report in browser (inline PDF)
     * GET /api/reports/invoice/preview
     */
    @GetMapping("/invoice/preview")
    public ResponseEntity<byte[]> previewInvoiceReport() {
        try {
            byte[] pdfBytes = invoiceReportService.generateInvoiceReportPdf();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("inline", "invoice-report-preview.pdf");

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(("Error generating PDF preview: " + e.getMessage()).getBytes());
        }
    }

    /**
     * Generate sample report with test data
     * GET /api/reports/invoice/sample
     */
    @GetMapping("/invoice/sample")
    public ResponseEntity<byte[]> generateSampleInvoiceReport() {
        try {
            // Create sample data
            List<InvoiceData> sampleData = createSampleInvoiceData();

            byte[] pdfBytes = invoiceReportService.generateInvoiceReportPdf();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "invoice-report-sample.pdf");
            headers.setContentLength(pdfBytes.length);

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(("Error generating sample PDF: " + e.getMessage()).getBytes());
        }
    }

    /**
     * Get report status/health check
     * GET /api/reports/status
     */
    @GetMapping("/status")
    public ResponseEntity<String> getReportStatus() {
        try {
            // You can add additional health checks here
            return ResponseEntity.ok("Report service is running");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Report service error: " + e.getMessage());
        }
    }

    /**
     * Create sample invoice data for testing
     */
    private List<InvoiceData> createSampleInvoiceData() {
        List<InvoiceData> sampleData = new ArrayList<>();

        sampleData.add(new InvoiceData("2860", "John Doe Company", 1500L,
                Timestamp.valueOf(LocalDateTime.now().minusDays(1))));
        sampleData.add(new InvoiceData("3020", "Jane Smith Ltd", 2750L,
                Timestamp.valueOf(LocalDateTime.now().minusDays(2))));
        sampleData.add(new InvoiceData("2920", "ABC Corporation", 980L,
                Timestamp.valueOf(LocalDateTime.now().minusDays(3))));
        sampleData.add(new InvoiceData("2843", "XYZ Enterprises", 3200L,
                Timestamp.valueOf(LocalDateTime.now().minusDays(4))));
        sampleData.add(new InvoiceData("2781", "Tech Solutions Inc", 1890L,
                Timestamp.valueOf(LocalDateTime.now().minusDays(5))));

        return sampleData;
    }
}