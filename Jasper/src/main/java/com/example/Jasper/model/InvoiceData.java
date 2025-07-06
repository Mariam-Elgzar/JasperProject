package com.example.Jasper.model;

import lombok.*;

import java.security.Timestamp;

@Data
public class InvoiceData {
    private String invoiceno;
    private String invoicetoname;
    private Long total;
    private java.sql.Timestamp createddate;
    private Long header_id;
    private String accountnumber;
    private String customername;
    private String billaddress;
    private String billunit;
    private String billpostal;
    private String billprov;
    private String billcity;
    private String contactname;
    private String contactphone;
    private String contactemail;
    private Timestamp invoice_createddate;
    private Timestamp min_fromdate;
    private Timestamp max_fromdate;
    private Long taxsum;
    private Long installationsum;
    private Long valuesum;
    private Long paid;
    private Long collectionstatusid;
    private Timestamp serializeddate;
    private Long branchid;
    private String area;
    private String headertype;
    private Long bill_grandtotal;
    private Long bill_pervpayment;
    private Long bill_currentpayment;
    private Timestamp bill_prevrundate;
    private Timestamp bill_currentrundate;
    private Timestamp invoicestartdate;
    private Long depositbalance;

    private Long line_id;
    private String orderserviceid;
    private java.sql.Date invoicefrom;
    private java.sql.Date invoiceto;
    private String componentsname;
    private String service;
    private Long linetypeid;
    private Integer quantity;
    private Long debitvalue;
    private Long creditvalue;
    private Long type_charge;
    private Long changerate;
    private String comments;
    private Long beforpro;
    private Long discountvalue;
    private Integer billingfrequency;
    private java.sql.Timestamp line_createddate;
    private String parent_orderserviceid;
    private Long currencyid;
    private String currency_name;
    private java.sql.Timestamp rundate;
    private String run_caption;
    private java.sql.Timestamp run_cover_to_date;
    private String agentname;
    private String laststatus;
    private java.sql.Timestamp laststatusdate;

    public InvoiceData(String invoiceno, String invoicetoname, Long total, java.sql.Timestamp createddate) {
        this.invoiceno = invoiceno;
        this.invoicetoname = invoicetoname;
        this.customername = invoicetoname;
        this.total = total;
        this.createddate = createddate;
    }

    public InvoiceData() {
    }

    public String getInvoiceno() {
        return invoiceno;
    }

    public void setInvoiceno(String invoiceno) {
        this.invoiceno = invoiceno;
    }

    public String getInvoicetoname() {
        return invoicetoname;
    }

    public void setInvoicetoname(String invoicetoname) {
        this.invoicetoname = invoicetoname;
        this.customername = invoicetoname;
    }

    public String getCustomername() {
        return customername != null ? customername : invoicetoname;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public java.sql.Timestamp getCreateddate() {
        return createddate;
    }

    public void setCreateddate(java.sql.Timestamp createddate) {
        this.createddate = createddate;
    }

    public Long getHeader_id() {
        return header_id;
    }

    public void setHeader_id(Long header_id) {
        this.header_id = header_id;
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getBilladdress() {
        return billaddress;
    }

    public void setBilladdress(String billaddress) {
        this.billaddress = billaddress;
    }

    public String getBillunit() {
        return billunit;
    }

    public void setBillunit(String billunit) {
        this.billunit = billunit;
    }

    public String getBillpostal() {
        return billpostal;
    }

    public void setBillpostal(String billpostal) {
        this.billpostal = billpostal;
    }

    public String getBillprov() {
        return billprov;
    }

    public void setBillprov(String billprov) {
        this.billprov = billprov;
    }

    public String getBillcity() {
        return billcity;
    }

    public void setBillcity(String billcity) {
        this.billcity = billcity;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getContactphone() {
        return contactphone;
    }

    public void setContactphone(String contactphone) {
        this.contactphone = contactphone;
    }

    public String getContactemail() {
        return contactemail;
    }

    public void setContactemail(String contactemail) {
        this.contactemail = contactemail;
    }

    public Timestamp getInvoice_createddate() {
        return invoice_createddate;
    }

    public void setInvoice_createddate(Timestamp invoice_createddate) {
        this.invoice_createddate = invoice_createddate;
    }

    public Timestamp getMin_fromdate() {
        return min_fromdate;
    }

    public void setMin_fromdate(Timestamp min_fromdate) {
        this.min_fromdate = min_fromdate;
    }

    public Timestamp getMax_fromdate() {
        return max_fromdate;
    }

    public void setMax_fromdate(Timestamp max_fromdate) {
        this.max_fromdate = max_fromdate;
    }

    public Long getTaxsum() {
        return taxsum;
    }

    public void setTaxsum(Long taxsum) {
        this.taxsum = taxsum;
    }

    public Long getInstallationsum() {
        return installationsum;
    }

    public void setInstallationsum(Long installationsum) {
        this.installationsum = installationsum;
    }

    public Long getValuesum() {
        return valuesum;
    }

    public void setValuesum(Long valuesum) {
        this.valuesum = valuesum;
    }

    public Long getPaid() {
        return paid;
    }

    public void setPaid(Long paid) {
        this.paid = paid;
    }

    public Long getCollectionstatusid() {
        return collectionstatusid;
    }

    public void setCollectionstatusid(Long collectionstatusid) {
        this.collectionstatusid = collectionstatusid;
    }

    public Timestamp getSerializeddate() {
        return serializeddate;
    }

    public void setSerializeddate(Timestamp serializeddate) {
        this.serializeddate = serializeddate;
    }

    public Long getBranchid() {
        return branchid;
    }

    public void setBranchid(Long branchid) {
        this.branchid = branchid;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getHeadertype() {
        return headertype;
    }

    public void setHeadertype(String headertype) {
        this.headertype = headertype;
    }

    public Long getBill_grandtotal() {
        return bill_grandtotal;
    }

    public void setBill_grandtotal(Long bill_grandtotal) {
        this.bill_grandtotal = bill_grandtotal;
    }

    public Long getBill_pervpayment() {
        return bill_pervpayment;
    }

    public void setBill_pervpayment(Long bill_pervpayment) {
        this.bill_pervpayment = bill_pervpayment;
    }

    public Long getBill_currentpayment() {
        return bill_currentpayment;
    }

    public void setBill_currentpayment(Long bill_currentpayment) {
        this.bill_currentpayment = bill_currentpayment;
    }

    public Timestamp getBill_prevrundate() {
        return bill_prevrundate;
    }

    public void setBill_prevrundate(Timestamp bill_prevrundate) {
        this.bill_prevrundate = bill_prevrundate;
    }

    public Timestamp getBill_currentrundate() {
        return bill_currentrundate;
    }

    public void setBill_currentrundate(Timestamp bill_currentrundate) {
        this.bill_currentrundate = bill_currentrundate;
    }

    public Timestamp getInvoicestartdate() {
        return invoicestartdate;
    }

    public void setInvoicestartdate(Timestamp invoicestartdate) {
        this.invoicestartdate = invoicestartdate;
    }

    public Long getDepositbalance() {
        return depositbalance;
    }

    public void setDepositbalance(Long depositbalance) {
        this.depositbalance = depositbalance;
    }

    public Long getLine_id() { return line_id; }
    public void setLine_id(Long line_id) { this.line_id = line_id; }

    public String getOrderserviceid() { return orderserviceid; }
    public void setOrderserviceid(String orderserviceid) { this.orderserviceid = orderserviceid; }

    public java.sql.Date getInvoicefrom() { return invoicefrom; }
    public void setInvoicefrom(java.sql.Date invoicefrom) { this.invoicefrom = invoicefrom; }

    public java.sql.Date getInvoiceto() { return invoiceto; }
    public void setInvoiceto(java.sql.Date invoiceto) { this.invoiceto = invoiceto; }

    public String getComponentsname() { return componentsname; }
    public void setComponentsname(String componentsname) { this.componentsname = componentsname; }

    public String getService() { return service; }
    public void setService(String service) { this.service = service; }

    public Long getLinetypeid() { return linetypeid; }
    public void setLinetypeid(Long linetypeid) { this.linetypeid = linetypeid; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Long getDebitvalue() { return debitvalue; }
    public void setDebitvalue(Long debitvalue) { this.debitvalue = debitvalue; }

    public Long getCreditvalue() { return creditvalue; }
    public void setCreditvalue(Long creditvalue) { this.creditvalue = creditvalue; }

    public Long getType_charge() { return type_charge; }
    public void setType_charge(Long type_charge) { this.type_charge = type_charge; }

    public Long getChangerate() { return changerate; }
    public void setChangerate(Long changerate) { this.changerate = changerate; }

    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }

    public Long getBeforpro() { return beforpro; }
    public void setBeforpro(Long beforpro) { this.beforpro = beforpro; }

    public Long getDiscountvalue() { return discountvalue; }
    public void setDiscountvalue(Long discountvalue) { this.discountvalue = discountvalue; }

    public Integer getBillingfrequency() { return billingfrequency; }
    public void setBillingfrequency(Integer billingfrequency) { this.billingfrequency = billingfrequency; }

    public java.sql.Timestamp getLine_createddate() { return line_createddate; }
    public void setLine_createddate(java.sql.Timestamp line_createddate) { this.line_createddate = line_createddate; }

    public String getParent_orderserviceid() { return parent_orderserviceid; }
    public void setParent_orderserviceid(String parent_orderserviceid) { this.parent_orderserviceid = parent_orderserviceid; }

    public Long getCurrencyid() { return currencyid; }
    public void setCurrencyid(Long currencyid) { this.currencyid = currencyid; }

    public String getCurrency_name() { return currency_name; }
    public void setCurrency_name(String currency_name) { this.currency_name = currency_name; }

    public java.sql.Timestamp getRundate() { return rundate; }
    public void setRundate(java.sql.Timestamp rundate) { this.rundate = rundate; }

    public String getRun_caption() { return run_caption; }
    public void setRun_caption(String run_caption) { this.run_caption = run_caption; }

    public java.sql.Timestamp getRun_cover_to_date() { return run_cover_to_date; }
    public void setRun_cover_to_date(java.sql.Timestamp run_cover_to_date) { this.run_cover_to_date = run_cover_to_date; }

    public String getAgentname() { return agentname; }
    public void setAgentname(String agentname) { this.agentname = agentname; }

    public String getLaststatus() { return laststatus; }
    public void setLaststatus(String laststatus) { this.laststatus = laststatus; }

    public java.sql.Timestamp getLaststatusdate() { return laststatusdate; }
    public void setLaststatusdate(java.sql.Timestamp laststatusdate) { this.laststatusdate = laststatusdate; }
}




