/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivan
 */
public class Vozac implements Serializable,OpstiDomenskiObjekat{
 private int vozacID;
 private String imePrezime;
 private String drzava;
 private Date datumRodjenja;
 private int poeni;
 private int pobede;
 private int podijumi;
 private int najbrziKrugovi;
 private int polPozicije;
 private Tim tim;

    public Vozac() {
    }

    public Vozac(int vozacID, String imePrezime, String drzava, Date datumRodjenja, int poeni, int pobede, int podijumi, int najbrziKrugovi, int polPozicije, Tim tim) {
        this.vozacID = vozacID;
        this.imePrezime = imePrezime;
        this.drzava = drzava;
        this.datumRodjenja = datumRodjenja;
        this.poeni = poeni;
        this.pobede = pobede;
        this.podijumi = podijumi;
        this.najbrziKrugovi = najbrziKrugovi;
        this.polPozicije = polPozicije;
        this.tim = tim;
    }

    public Tim getTim() {
        return tim;
    }

    public void setTim(Tim tim) {
        this.tim = tim;
    }

    public int getVozacID() {
        return vozacID;
    }

    public void setVozacID(int vozacID) {
        this.vozacID = vozacID;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public int getPoeni() {
        return poeni;
    }

    public void setPoeni(int poeni) {
        this.poeni = poeni;
    }

    public int getPobede() {
        return pobede;
    }

    public void setPobede(int pobede) {
        this.pobede = pobede;
    }

    public int getPodijumi() {
        return podijumi;
    }

    public void setPodijumi(int podijumi) {
        this.podijumi = podijumi;
    }

    public int getNajbrziKrugovi() {
        return najbrziKrugovi;
    }

    public void setNajbrziKrugovi(int najbrziKrugovi) {
        this.najbrziKrugovi = najbrziKrugovi;
    }

    public int getPolPozicije() {
        return polPozicije;
    }

    public void setPolPozicije(int polPozicije) {
        this.polPozicije = polPozicije;
    }
      String sql = "Update Vozac set Poeni=?,Pobede=?,Podijumi=?,PolPozicije=?  where VozacID=?";

    @Override
    public String toString() {
//return imePrezime+" ["+tim.getNaziv()+"]";
return imePrezime;
    }

    @Override
    public String vratiVrednostiAtributa() {
        Date date=new java.sql.Date(getDatumRodjenja().getTime());
        return "('"+getImePrezime()+"','"+getDrzava()+"','"+date+"',"+0+","+0+","+0+","+0+","+0+","+getTim().getTimID()+")";
    }

    @Override
    public String postaviVrednostiAtributa() {
return "Poeni="+getPoeni()+",Pobede="+getPobede()+",Podijumi="+getPodijumi()+",PolPozicije="+getPolPozicije()+"";
    }

    @Override
    public String vratiImeKlase() {
return "Vozac";
    }

    @Override
    public String vratiAtributeKlase() {
        return "(ImePrezime,DrzavaVozac,DatumRodjenja,Poeni,Pobede,Podijumi,NajbrziKrugovi,PolPozicije,TimID)";
    }

    @Override
    public String vratiUslovPretrage() {
return "order by v.Poeni desc";
    }

    @Override
    public String vratiUslovIzmene() {
        return " where VozacID="+getVozacID()+"";
    }

    @Override
    public String vratiUslovBrisanja() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiTabeluPretrage() {
        return "Vozac v join Tim t on v.TimID=t.TimID";
    }

    @Override
    public String vratiAtributePretrage() {
        return "*";
    }

    @Override
    public ArrayList<Vozac> napuni(ResultSet rs) {
              ArrayList<Vozac> rezultat = new ArrayList<>();
        try {
         while (rs.next()) {
             
             int vozID = rs.getInt(1);
             String imePrezime = rs.getString(2);
             String drzava=rs.getString(3);
             Date datumRodjenja=rs.getDate(4);
             int poeni = rs.getInt(5);
             int pobede = rs.getInt(6);
             int podijumi = rs.getInt(7);
             int najbrziKrugovi = rs.getInt(8);
             int polPozicije = rs.getInt(9);
             
             int timID = rs.getInt(11);
             String naziv = rs.getString(12);
             String drzavaT=rs.getString(13);
             String sefTima=rs.getString(14);
             String sasija=rs.getString(15);
             String motor=rs.getString(16);
             int prvoUcesce = rs.getInt(17);
             
             Tim t = new Tim(timID, naziv, drzavaT, sefTima, sasija, motor, prvoUcesce);
             Vozac v = new Vozac(vozID, imePrezime, drzava, datumRodjenja, poeni, pobede, podijumi, najbrziKrugovi, polPozicije, t);
             rezultat.add(v);
         }
         
     } catch (SQLException ex) {
         Logger.getLogger(Vozac.class.getName()).log(Level.SEVERE, null, ex);
     }
    return rezultat;

   
    }
  
}
