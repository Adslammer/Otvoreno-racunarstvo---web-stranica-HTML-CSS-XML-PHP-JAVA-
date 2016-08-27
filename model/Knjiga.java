package model;

import java.util.Iterator;
import java.util.Vector;

public class Knjiga {
	
	private String isbn;
	private String naslov;
	private String podnaslov;
	private Vector<Autor> autori = new Vector<Autor>();
	private int broj_stranica;
	private Vector<Izdavac> izdavaci = new Vector<Izdavac>();
	private String datum_izdanja;
	private String nacin_distribucije;
	private String kategorija;
	private int broj_poglavlja;
	private String cijena;
	
	private String jezik;
	private int izdanje;
	private String uvez;
	private int ocjena;
	
	public boolean setNaslov(String naslov) {
		this.naslov = naslov;
		return true;
	}
	
	public String getNaslov() {
		return naslov;
	}
	
	public boolean setPodnaslov(String podnaslov) {

			this.podnaslov = podnaslov;
			return true;
		
	}
	
	public String getPodnaslov() {
		return podnaslov;
	}
	
	public void addAutor(Autor autor) {
		autori.add(autor);
	}
	
	public void removeAutor(Autor autor) {
		autori.remove(autor);
	}
	
	public Iterator<Autor> autori() {
		return autori.iterator();
	}
	
	public boolean setBroj_stranica(int broj_stranica) {
		this.broj_stranica = broj_stranica;
		return true;
	}
	
	public int getBroj_stranica() {
		return broj_stranica;
	}
	
	public void addIzdavac(Izdavac izdavac) {
		izdavaci.add(izdavac);
	}
	
	public void removeIzdavac(Izdavac izdavac) {
		izdavaci.remove(izdavac);
	}
	
	public Iterator<Izdavac> izdavaci() {
		return izdavaci.iterator();
	}
	
	public boolean setDatum_izdanja(String datum_izdanja) {
		this.datum_izdanja = datum_izdanja;
		return true;
	}
	
	public String getDatum_izdanja() {
		return datum_izdanja;
	}
	
	public boolean setNacin_distribucije(String nacin_distribucije) {
		this.nacin_distribucije = nacin_distribucije;
		return true;
	}
	
	public String getNacin_distribucije() {
		return nacin_distribucije;
	}
	
	public boolean setKategorija(String kategorija) {
		this.kategorija = kategorija;
		return true;
	}
	
	public String getKategorija() {
		return kategorija;
	}
	
	public boolean setBroj_poglavlja(int broj_poglavlja) {
		this.broj_poglavlja = broj_poglavlja;
		return true;
	}
	
	public int getBroj_poglavlja() {
		return broj_poglavlja;
	}
	
	public boolean setCijena(String cijena) {
		this.cijena = cijena;
		return true;
	}
	
	public String getCijena() {
		return cijena;
	}
	
	public boolean setIsbn(String isbn) {
		
		if( isbn.length() != 13)
			return false;
		
		this.isbn = isbn;
		return true;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public boolean setJezik(String jezik) {
		
		if (jezik.equals("Hrvatski") || jezik.equals("Engleski") || jezik.equals("Njemaèki") || jezik.equals("Slovenski")){
			this.jezik = jezik;
			return true;
		}
		return false;
	}
	
	public String getJezik() {
		return jezik;
	}
	
	public boolean setIzdanje(int izdanje) {
		if (izdanje==1 || izdanje==2 || izdanje==3 || izdanje==4 || izdanje==5 ||
		    izdanje==6 || izdanje==7 || izdanje==8 || izdanje==9 || izdanje==10){
			this.izdanje = izdanje;
			return true;
		}
		return false;
	}
	
	public int getIzdanje() {
		return izdanje;
	}
	
	public boolean setUvez(String uvez) {
		
		if (uvez.equals("Meki") || uvez.equals("Tvrdi")){
			this.uvez = uvez;
			return true;
		}
		return false;
	}
	
	public String getUvez() {
		return uvez;
	}
	
	public boolean setOcjena(int ocjena) {
		
		if (ocjena==1 || ocjena==2 || ocjena==3 || ocjena==4 || ocjena==5){
			this.ocjena = ocjena;
			return true;
		}
		return false;
	}
	
	public int getOcjena() {
		return ocjena;
	}

}

