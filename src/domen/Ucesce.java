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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivan
 */
public class Ucesce implements Serializable,OpstiDomenskiObjekat{
   private Trka trka;
   private Vozac vozac;
   private String plasman;
   private String ukupnoVreme;
   private String zaostatakZaPrvim;
   private int pocetnaPozicija;
   private int brojPitStopa;
   private String najbrziKrug;
   private Nalog nalog;
   private ArrayList<IzvestajIncidenta> incidenti;

    public Ucesce() {
        ArrayList<IzvestajIncidenta> incidenti=new ArrayList<>();
    }

    public Ucesce(Trka trka, Vozac vozac, String plasman, String ukupnoVreme, String zaostatakZaPrvim, int pocetnaPozicija, int brojPitStopa, String najbrziKrug, Nalog nalog, ArrayList<IzvestajIncidenta> incidenti) {
        this.trka = trka;
        this.vozac = vozac;
        this.plasman = plasman;
        this.ukupnoVreme = ukupnoVreme;
        this.zaostatakZaPrvim = zaostatakZaPrvim;
        this.pocetnaPozicija = pocetnaPozicija;
        this.brojPitStopa = brojPitStopa;
        this.najbrziKrug = najbrziKrug;
        this.nalog = nalog;
        this.incidenti = incidenti;
    }

    public ArrayList<IzvestajIncidenta> getIncidenti() {
        return incidenti;
    }

    public void setIncidenti(ArrayList<IzvestajIncidenta> incidenti) {
        this.incidenti = incidenti;
    }

    public Trka getTrka() {
        return trka;
    }

    public void setTrka(Trka trka) {
        this.trka = trka;
    }

    public Vozac getVozac() {
        return vozac;
    }

    public void setVozac(Vozac vozac) {
        this.vozac = vozac;
    }

    public String getPlasman() {
        return plasman;
    }

    public void setPlasman(String plasman) {
        this.plasman = plasman;
    }

    public String getUkupnoVreme() {
        return ukupnoVreme;
    }

    public void setUkupnoVreme(String ukupnoVreme) {
        this.ukupnoVreme = ukupnoVreme;
    }

    public String getZaostatakZaPrvim() {
        return zaostatakZaPrvim;
    }

    public void setZaostatakZaPrvim(String zaostatakZaPrvim) {
        this.zaostatakZaPrvim = zaostatakZaPrvim;
    }

    public int getPocetnaPozicija() {
        return pocetnaPozicija;
    }

    public void setPocetnaPozicija(int pocetnaPozicija) {
        this.pocetnaPozicija = pocetnaPozicija;
    }

    public int getBrojPitStopa() {
        return brojPitStopa;
    }

    public void setBrojPitStopa(int brojPitStopa) {
        this.brojPitStopa = brojPitStopa;
    }

    public String getNajbrziKrug() {
        return najbrziKrug;
    }

    public void setNajbrziKrug(String najbrziKrug) {
        this.najbrziKrug = najbrziKrug;
    }

    public Nalog getNalog() {
        return nalog;
    }

    public void setNalog(Nalog nalog) {
        this.nalog = nalog;
    }

    @Override
    public String vratiVrednostiAtributa() {
return "((select max(TrkaID) from Trka), "+getVozac().getVozacID()+", 'n/a', 'n/a', 'n/a', 0, 0, 'n/a','"+getNalog().getKorisnickoIme()+"')";
    }

    @Override
    public String postaviVrednostiAtributa() {
return " Plasman='"+getPlasman()+"',UkupnoVreme='"+getUkupnoVreme()+"',ZaostatakZaPrvim='"+getZaostatakZaPrvim()+"',PocetnaPozicija="+getPocetnaPozicija()+",BrojPitStopa="+getBrojPitStopa()+",NalogID='"+getNalog().getKorisnickoIme()+"' ";

    }

    @Override
    public String vratiImeKlase() {
        return "Ucesce";
    }

    @Override
    public String vratiAtributeKlase() {
        return "";
    }

    @Override
    public String vratiUslovPretrage() {
return " order by u.Plasman asc";

    }

    @Override
    public String vratiUslovIzmene() {
        return "where TrkaID="+getTrka().getTrkaID()+" and VozacID="+getVozac().getVozacID()+"";
//return "where u.TrkaID="+getTrka().getTrkaID()+" order by u.Plasman asc";

    }

    @Override
    public String vratiUslovBrisanja() {
return "where TrkaID="+getTrka().getTrkaID()+"";
    }

    @Override
    public String vratiTabeluPretrage() {
//return "Ucesce u join Nalog n on u.NalogID=n.KorisnickoIme join Trka t on u.TrkaID=t.TrkaID join (select * from Vozac v  join Tim t on v.TimID=t.TimID) as y on u.VozacID=y.VozacID "
  return "Ucesce u join Nalog n on u.NalogID=n.KorisnickoIme join Trka t on u.TrkaID=t.TrkaID join Vozac v on u.VozacID=v.VozacID join Tim b on v.TimID=b.TimID";      
        
    }

    @Override
    public String vratiAtributePretrage() {
        return "*";
    }

    @Override
    public ArrayList<Ucesce> napuni(ResultSet rs) {
                  ArrayList<Ucesce> rezultat = new ArrayList<>();
        try {
           while (rs.next()) {

               int trkaID = rs.getInt("TrkaID");
               int vozacID=rs.getInt("VozacID");
               String plasman = rs.getString("Plasman");
               String ukupanoVreme=rs.getString("UkupnoVreme");
               String zaostatakZaPrvim=rs.getString("ZaostatakZaPrvim");
               int pocetnaPozicija = rs.getInt("PocetnaPozicija");
               int brojPitStopa = rs.getInt("BrojPitStopa");
               String najbrziKrug=rs.getString("NajbrziKrug");
               
               String korisnickoIme=rs.getString("KorisnickoIme");
               String sifra=rs.getString("Sifra");
               Nalog n=new Nalog( korisnickoIme, sifra);

                String naziv = rs.getString("NazivTrke");
                String drzava=rs.getString("Drzava");
                String nazivStaze=rs.getString("NazivStaze");
                Date datumOdrzavanja=rs.getDate("DatumOdrzavanja");
                int brojKrugova = rs.getInt("BrojKrugova");
                double duzinaKruga=rs.getDouble("DuzinaKruga");
                int kapacitet = rs.getInt("Kapacitet");
                Trka t=new Trka(trkaID, naziv, drzava, nazivStaze, datumOdrzavanja, brojKrugova, duzinaKruga, kapacitet);

               String imePrezime = rs.getString("ImePrezime");
               String drzavaVoz=rs.getString("DrzavaVozac");
               Date datumRodjenja=rs.getDate("DatumRodjenja");
               int poeni = rs.getInt("Poeni");
               int pobede = rs.getInt("Pobede");
               int podijumi = rs.getInt("Podijumi");
               int najbrziKrugovi = rs.getInt("NajbrziKrugovi");
               int polPozicije = rs.getInt("PolPozicije");

               int timID = rs.getInt("TimID");
               String nazivTim = rs.getString("Naziv");
               String drzavaT=rs.getString("DrzavaTim");
               String sefTima=rs.getString("SefTima");
               String sasija=rs.getString("Sasija");
               String motor=rs.getString("Motor");
               int prvoUcesce = rs.getInt("PrvoUcesce");

               Tim tim = new Tim(timID, nazivTim, drzavaT, sefTima, sasija, motor, prvoUcesce);
               Vozac v = new Vozac(vozacID, imePrezime, drzava, datumRodjenja, poeni, pobede, podijumi, najbrziKrugovi, polPozicije, tim);
               
               
               Ucesce u=new Ucesce(t, v, plasman, ukupanoVreme, zaostatakZaPrvim, pocetnaPozicija, brojPitStopa, najbrziKrug, n, null);
               rezultat.add(u);
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(Ucesce.class.getName()).log(Level.SEVERE, null, ex);
       }
       return rezultat;
    }
    
   
}
