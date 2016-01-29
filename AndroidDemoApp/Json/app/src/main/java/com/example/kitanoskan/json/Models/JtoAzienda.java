package com.example.kitanoskan.json.Models;

/**
 * Created by kitanoskan on 4.12.2015.
 */
public class JtoAzienda {

    protected JtoAnagrafica jtoAnagrafica = null;
    protected String username = null;
    protected String password = null;
    protected String companyCode = null;
    protected String marketSegmentCode = null;
    protected String marketSegmentDescr = null;


    public JtoAzienda() {
        // TODO Auto-generated constructor stub
    }


    public JtoAzienda(JtoAnagrafica jtoAnagrafica, String username,
                      String password, String companyCode,
                      String marketSegmentCode, String marketSegmentDescr) {
        super();
        this.jtoAnagrafica = jtoAnagrafica;
        this.username = username;
        this.password = password;
        this.companyCode = companyCode;
        this.marketSegmentCode = marketSegmentCode;
        this.marketSegmentDescr = marketSegmentDescr;
    }


    public JtoAnagrafica getJtoAnagrafica() {
        return jtoAnagrafica;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public void setJtoAnagrafica(JtoAnagrafica jtoAnagrafica) {
        this.jtoAnagrafica = jtoAnagrafica;
    }


    public String getCompanyCode() {
        return companyCode;
    }


    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }


    public String getMarketSegmentCode() {
        return marketSegmentCode;
    }


    public void setMarketSegmentCode(String marketSegmentCode) {
        this.marketSegmentCode = marketSegmentCode;
    }


    public String getMarketSegmentDescr() {
        return marketSegmentDescr;
    }


    public void setMarketSegmentDescr(String marketSegmentDescr) {
        this.marketSegmentDescr = marketSegmentDescr;
    }

}
