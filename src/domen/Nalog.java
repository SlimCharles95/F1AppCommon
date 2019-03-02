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
public class Nalog implements Serializable,OpstiDomenskiObjekat{
    
    private String korisnickoIme;
    private String sifra;

    public Nalog() {
    }

    public Nalog( String korisnickoIme, String sifra) {
        
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

  
    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }
   
    @Override
    public String vratiVrednostiAtributa() {
        return "('"+getKorisnickoIme()+"','"+getSifra()+"')";
    }

    @Override
    public String postaviVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiImeKlase() {
        return "Nalog";
    }

    @Override
    public String vratiAtributeKlase() {
        return "";
    }

    @Override
    public String vratiUslovPretrage() {
return "where KorisnickoIme='"+getKorisnickoIme()+"' and Sifra='"+getSifra()+"'";
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
return "Nalog n";
    }

    @Override
    public String vratiAtributePretrage() {
return "*";
    }

    @Override
    public ArrayList<Nalog> napuni(ResultSet rs) {
 Nalog ulogovani;
 ArrayList<Nalog> rezultat=new ArrayList<>();
        try {                
            while (rs.next()) {
                
                String korsinickoIme= rs.getString("KorisnickoIme");
                String sifra=rs.getString("Sifra");
                ulogovani=new Nalog( korsinickoIme, sifra);
                rezultat.add(ulogovani);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Nalog.class.getName()).log(Level.SEVERE, null, ex);
        }
 return rezultat;
    }

    
    
   
  
    
}
