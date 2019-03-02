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
public class Tim implements Serializable,OpstiDomenskiObjekat{
    private int timID;
    private String naziv;
    private String drzava;
    private String sefTima;
    private String sasija;
    private String motor;
    private int prvoUcesce;

    public Tim() {
    }

    public Tim(int timID, String naziv, String drzava, String sefTima, String sasija, String motor, int prvoUcesce) {
        this.timID = timID;
        this.naziv = naziv;
        this.drzava = drzava;
        this.sefTima = sefTima;
        this.sasija = sasija;
        this.motor = motor;
        this.prvoUcesce = prvoUcesce;
    }

    public int getPrvoUcesce() {
        return prvoUcesce;
    }

    public void setPrvoUcesce(int prvoUcesce) {
        this.prvoUcesce = prvoUcesce;
    }

    public int getTimID() {
        return timID;
    }

    public void setTimID(int timID) {
        this.timID = timID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getSefTima() {
        return sefTima;
    }

    public void setSefTima(String sefTima) {
        this.sefTima = sefTima;
    }

    public String getSasija() {
        return sasija;
    }

    public void setSasija(String sasija) {
        this.sasija = sasija;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    @Override
    public String toString() {
return naziv;
    }
    

    @Override
    public String vratiVrednostiAtributa() {
        return "('"+getNaziv()+"','"+getDrzava()+"','"+getSefTima()+"','"+getSasija()+"','"+getMotor()+"',"+getPrvoUcesce()+")";

    }

    @Override
    public String postaviVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiImeKlase() {
return "Tim";
    }

    @Override
    public String vratiAtributeKlase() {
        return "(Naziv,DrzavaTim,SefTima,Sasija,Motor,PrvoUcesce)";
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
return "Tim ";
    }

    @Override
    public String vratiAtributePretrage() {
        return "*";
    }

    @Override
    public ArrayList<Tim> napuni(ResultSet rs) {
      ArrayList<Tim> rezultat = new ArrayList<>();
        try {

            while (rs.next()) {
                try {
                    int timID = rs.getInt(1);
                    String naziv = rs.getString(2);
                    String drzava=rs.getString(3);
                    String sefTima=rs.getString(4);
                    String sasija=rs.getString(5);
                    String motor=rs.getString(6);
                    int prvoUcesce = rs.getInt(7);

                    Tim t = new Tim(timID, naziv, drzava, sefTima, sasija, motor, prvoUcesce);
                    rezultat.add(t);
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
