package com.example.Jasper.service;

import com.example.Jasper.model.InvoiceData;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.awt.*;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InvoiceReportService {

    private final DataSource dataSource;

    @Autowired
    public InvoiceReportService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Generate PDF report using database connection for all invoices
     */
    public byte[] generateInvoiceReportPdf() throws Exception {
        try (InputStream reportStream = new ClassPathResource("reports/InvoiceItem.jrxml").getInputStream();
             Connection connection = dataSource.getConnection()) {

            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("LogoPath", getLogoPath());
            parameters.put("MainColor", new Color(14, 25, 153));
            parameters.put("Parameter1", "Additional Parameter");
            parameters.put(JRParameter.REPORT_CONNECTION, connection);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);

            return JasperExportManager.exportReportToPdf(jasperPrint);

        } catch (Exception e) {
            throw new Exception("Error generating PDF report: " + e.getMessage(), e);
        }
    }

    /**
     * Generate PDF report filtering by specific invoice numbers
     * Make sure your JRXML query uses: WHERE invoiceno IN ($P!{InvoiceNumbers})
     */
    public byte[] generateInvoiceReportPdfByInvoices(List<String> invoiceNumbers) throws Exception {
        try (InputStream reportStream = new ClassPathResource("reports/InvoiceItem.jrxml").getInputStream();
             Connection connection = dataSource.getConnection()) {

            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("LogoPath", getLogoPath());
            parameters.put("MainColor", new Color(14, 25, 153));
            parameters.put("Parameter1", "Additional Parameter");
            parameters.put(JRParameter.REPORT_CONNECTION, connection);

            // Prepare invoices list as 'value1','value2',...
            String invoiceList = "'" + String.join("','", invoiceNumbers) + "'";
            parameters.put("InvoiceNumbers", invoiceList);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);

            return JasperExportManager.exportReportToPdf(jasperPrint);

        } catch (Exception e) {
            throw new Exception("Error generating filtered PDF report: " + e.getMessage(), e);
        }
    }

    /**
     * Generate PDF report from Java Bean data (not database)
     */
    public byte[] generateInvoiceReportPdfFromBeans(List<InvoiceData> invoiceDataList) throws Exception {
        try (InputStream reportStream = new ClassPathResource("reports/InvoiceItem.jrxml").getInputStream();Connection connection = dataSource.getConnection())
        {

            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("LogoPath", getLogoPath());
            parameters.put("MainColor", new Color(14, 25, 153));
            parameters.put("Parameter1", "Additional Parameter");
            parameters.put(JRParameter.REPORT_CONNECTION, connection);

            // Do NOT set JRParameter.REPORT_CONNECTION here

            JRDataSource beanDataSource = new JRBeanCollectionDataSource(invoiceDataList);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanDataSource);

            return JasperExportManager.exportReportToPdf(jasperPrint);

        } catch (Exception e) {
            throw new Exception("Error generating PDF report from beans: " + e.getMessage(), e);
        }
    }

    /**
     * Returns the absolute path to the logo image
     */
    private String getLogoPath() {
        try {
            ClassPathResource resource = new ClassPathResource("static/logo1.jpeg");
            return resource.getFile().getAbsolutePath();
        } catch (Exception e) {
            return "";
        }
    }
}
