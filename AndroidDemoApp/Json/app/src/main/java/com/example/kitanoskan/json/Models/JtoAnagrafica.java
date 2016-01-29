package com.example.kitanoskan.json.Models;

/**
 * Created by kitanoskan on 4.12.2015.
 */
public class JtoAnagrafica {

    protected JtoAddressDetails jtoAddressDetails = null;
    protected JtoContactDetails jtoContactDetails = null;
    protected String corporateLegalForm = null;
    protected String companyName = null;
    protected String taxIdentificationNumber = null;
    protected String vatIdentificationNumber = null;
    protected String numberEemployee = null;

    public JtoAnagrafica() {
        // TODO Auto-generated constructor stub
    }

    public JtoAnagrafica(JtoAddressDetails jtoAddressDetails,
                         JtoContactDetails jtoContactDetails, String corporateLegalForm,
                         String companyName, String taxIdentificationNumber,
                         String vatIdentificationNumber, String numberEemployee) {
        super();
        this.jtoAddressDetails = jtoAddressDetails;
        this.jtoContactDetails = jtoContactDetails;
        this.corporateLegalForm = corporateLegalForm;
        this.companyName = companyName;
        this.taxIdentificationNumber = taxIdentificationNumber;
        this.vatIdentificationNumber = vatIdentificationNumber;
        this.numberEemployee = numberEemployee;
    }

    public JtoAddressDetails getJtoAddressDetails() {
        return jtoAddressDetails;
    }

    public void setJtoAddressDetails(JtoAddressDetails jtoAddressDetails) {
        this.jtoAddressDetails = jtoAddressDetails;
    }

    public JtoContactDetails getJtoContactDetails() {
        return jtoContactDetails;
    }

    public void setJtoContactDetails(JtoContactDetails jtoContactDetails) {
        this.jtoContactDetails = jtoContactDetails;
    }

    public String getCorporateLegalForm() {
        return corporateLegalForm;
    }

    public void setCorporateLegalForm(String corporateLegalForm) {
        this.corporateLegalForm = corporateLegalForm;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }

    public void setTaxIdentificationNumber(String taxIdentificationNumber) {
        this.taxIdentificationNumber = taxIdentificationNumber;
    }

    public String getVatIdentificationNumber() {
        return vatIdentificationNumber;
    }

    public void setVatIdentificationNumber(String vatIdentificationNumber) {
        this.vatIdentificationNumber = vatIdentificationNumber;
    }

    public String getNumberEemployee() {
        return numberEemployee;
    }

    public void setNumberEemployee(String numberEemployee) {
        this.numberEemployee = numberEemployee;
    }

}
