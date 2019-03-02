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
public class Trka implements Serializable,OpstiDomenskiObjekat{
    private int trkaID;
    private String nazivTrke;
    private String drzava;
    private String nazivStaze;
    private Date datumOdrzavanja;
    private int brojKrugova;
    private double duzinaKruga;
    private int kapacitet;

    public Trka() {
    }

    public Trka(int trkaID, String nazivTrke, String drzava, String nazivStaze, Date datumOdrzavanja, int brojKrugova, double duzinaKruga, int kapacitet) {
        this.trkaID = trkaID;
        this.nazivTrke = nazivTrke;
        this.drzava = drzava;
        this.nazivStaze = nazivStaze;
        this.datumOdrzavanja = datumOdrzavanja;
        this.brojKrugova = brojKrugova;
        this.duzinaKruga = duzinaKruga;
        this.kapacitet = kapacitet;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public int getTrkaID() {
        return trkaID;
    }

    public void setTrkaID(int trkaID) {
        this.trkaID = trkaID;
    }

    public String getNazivTrke() {
        return nazivTrke;
    }

    public void setNazivTrke(String nazivTrke) {
        this.nazivTrke = nazivTrke;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getNazivStaze() {
        return nazivStaze;
    }

    public void setNazivStaze(String nazivStaze) {
        this.nazivStaze = nazivStaze;
    }

    public Date getDatumOdrzavanja() {
        return datumOdrzavanja;
    }

    public void setDatumOdrzavanja(Date datumOdrzavanja) {
        this.datumOdrzavanja = datumOdrzavanja;
    }

    public int getBrojKrugova() {
        return brojKrugova;
    }

    public void setBrojKrugova(int brojKrugova) {
        this.brojKrugova = brojKrugova;
    }

    public double getDuzinaKruga() {
        return duzinaKruga;
    }

    public void setDuzinaKruga(double duzinaKruga) {
        this.duzinaKruga = duzinaKruga;
    }
            
    @Override
    
    public String vratiVrednostiAtributa() {
        Date datum= new java.sql.Date(getDatumOdrzavanja().getTime());
        return "('"+getNazivTrke()+"','"+getDrzava()+"','"+getNazivStaze()+"','"+datum+"',"+getBrojKrugova()+","+getDuzinaKruga()+","+getKapacitet()+")";

    }

    @Override
    public String postaviVrednostiAtributa() {
        return "";
    }

    @Override
    public String vratiImeKlase() {
return "Trka";
    }

    @Override
    public String vratiAtributeKlase() {
return "(NazivTrke, Drzava, NazivStaze,DatumOdrzavanja, BrojKrugova,DuzinaKruga,Kapacitet)";
    }

    @Override
    public String vratiUslovPretrage() {
        return "";
    }

    @Override
    public String vratiUslovIzmene() {
return "";
    }

    @Override
    public String vratiUslovBrisanja() {
        return " where TrkaID="+getTrkaID()+"";
    }

    @Override
    public String vratiTabeluPretrage() {
return "Trka ";
    }

    @Override
    public String vratiAtributePretrage() {
return "*";
    }

    @Override
    public ArrayList<Trka> napuni(ResultSet rs) {
 ArrayList<Trka> rezultat = new ArrayList<>();
        try {
            
            while (rs.next()) {
                int trkaID = rs.getInt(1);
                String naziv = rs.getString(2);
                String drzava=rs.getString(3);
                String nazivStaze=rs.getString(4);
                Date datumOdrzavanja=rs.getDate(5);
                int brojKrugova = rs.getInt(6);
                double duzinaKruga=rs.getDouble(7);
                int kapacitet = rs.getInt(8);
                Trka t=new Trka(trkaID, naziv, drzava, nazivStaze, datumOdrzavanja, brojKrugova, duzinaKruga, kapacitet);
                rezultat.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Trka.class.getName()).log(Level.SEVERE, null, ex);
        }
            return rezultat;

    }
     
}
