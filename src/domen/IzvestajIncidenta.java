/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivan
 */
public class IzvestajIncidenta implements Serializable,OpstiDomenskiObjekat{
    private int vozacID;
    private int trkaID;

  
 private int incidentID;
 private String incident;
 private String kazna;
 private int krug;
 private String napomena;

    public IzvestajIncidenta() {
    }

    public IzvestajIncidenta(int vozacID,int trkaID,int incidentID, String incident, String kazna, int krug, String napomena) {
        this.vozacID=vozacID;
        this.trkaID=trkaID;
        this.incidentID = incidentID;
        this.incident = incident;
        this.kazna = kazna;
        this.krug = krug;
        this.napomena = napomena;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public int getIncidentID() {
        return incidentID;
    }

    public void setIncidentID(int incidentID) {
        this.incidentID = incidentID;
    }

    public String getIncident() {
        return incident;
    }

    public void setIncident(String incident) {
        this.incident = incident;
    }

    public String getKazna() {
        return kazna;
    }

    public void setKazna(String kazna) {
        this.kazna = kazna;
    }

    public int getKrug() {
        return krug;
    }

    public void setKrug(int krug) {
        this.krug = krug;
    }
      public int getVozacID() {
        return vozacID;
    }

    public void setVozacID(int vozacID) {
        this.vozacID = vozacID;
    }

    public int getTrkaID() {
        return trkaID;
    }

    public void setTrkaID(int trkaID) {
        this.trkaID = trkaID;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return "("+getTrkaID()+","+getVozacID()+",(select count(*) from izvestajincidenta ii where ii.TrkaID="+getTrkaID()+" and ii.VozacID="+getVozacID()+" ),'"+getIncident()+"','"+getKazna()+"',"+getKrug()+",'n/a')";
    }

    @Override
    public String postaviVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiImeKlase() {
        return "izvestajincidenta";
    }

    @Override
    public String vratiAtributeKlase() {
return "";
    }

    @Override
    public String vratiUslovPretrage() {
        return "";
    }

    @Override
    public String vratiUslovIzmene() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovBrisanja() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiTabeluPretrage() {
return "IzvestajIncidenta";
    }

    @Override
    public String vratiAtributePretrage() {
return "*";
    }

    @Override
    public ArrayList<IzvestajIncidenta> napuni(ResultSet rs) {
 ArrayList<IzvestajIncidenta> rezultat = new ArrayList<>();
        try {

            while (rs.next()) {
                try {
                    int trkaID = rs.getInt(1);
                    int vozacID = rs.getInt(2);
                    int incidentID=rs.getInt(3);
                    String incident=rs.getString(4);
                    String kazna=rs.getString(5);
                    String napomena=rs.getString(6);
                    int krug = rs.getInt(6);
IzvestajIncidenta ii =new IzvestajIncidenta(vozacID, trkaID, incidentID, incident, kazna, krug, napomena);
                    rezultat.add(ii);
                } catch (SQLException ex) {
                    Logger.getLogger(Tim.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tim.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return rezultat;
    }
 
}
