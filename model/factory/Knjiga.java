package model.factory;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Knjiga {

	public static model.Knjiga fromText(String input) {
		
		model.Knjiga knjiga = new model.Knjiga();
		
		//tokenizacija stringa
		StringTokenizer st = new StringTokenizer(input, "|");
		
		//isbn
		knjiga.setIsbn(st.nextToken().trim());
		
		//naslov
		knjiga.setNaslov(st.nextToken().trim());
		
		//podnaslov
		knjiga.setPodnaslov(st.nextToken().trim());
		
		//autori
		String listaAutora = st.nextToken().trim();	
		StringTokenizer str1 = new StringTokenizer(listaAutora, ";");
			
		while(str1.hasMoreElements() == true) {
			
			String autor = (String) str1.nextElement();
			model.Autor aut = model.factory.Autor.fromText(autor);
			if(aut != null)
				knjiga.addAutor(aut);
		}
	
		//broj stranica
		knjiga.setBroj_stranica(Integer.parseInt(st.nextToken().trim()));
		
		//izdavaci
		String listaIzdavaca = st.nextToken().trim();	
		StringTokenizer str2 = new StringTokenizer(listaIzdavaca, ";");
			
		while(str2.hasMoreElements() == true) {
			
			String izdavac = (String) str2.nextElement();
			model.Izdavac izd = model.factory.Izdavac.fromText(izdavac);
			if(izd != null)
				knjiga.addIzdavac(izd);
		}
		
		//dat izd
		knjiga.setDatum_izdanja(st.nextToken().trim());
		
		//nacin distr.
		knjiga.setNacin_distribucije(st.nextToken().trim());
		
		//kategorija
		knjiga.setKategorija(st.nextToken().trim());
		
		//br. poglavlja
		knjiga.setBroj_poglavlja(Integer.parseInt(st.nextToken().trim()));
				
		//cijena
		knjiga.setCijena(st.nextToken().trim());
		
		//jezik
		knjiga.setJezik(st.nextToken().trim());
		
		//izdanje
		knjiga.setIzdanje(Integer.parseInt(st.nextToken().trim()));
		
		//uvez
		knjiga.setUvez(st.nextToken().trim());
		
		//ocjena
		knjiga.setOcjena(Integer.parseInt(st.nextToken().trim()));
	
		return knjiga;
	}
	
	public static void toXML(model.Knjiga knjiga, Writer output) throws IOException {
		
		output.write("  <knjiga isbn=\"" + knjiga.getIsbn() + "\" jezik=\"" + knjiga.getJezik() + "\" izdanje=\"" + knjiga.getIzdanje() + "\" uvez=\"" + knjiga.getUvez() + "\" ocjena=\"" + knjiga.getOcjena() + "\">\r\n");
		output.write("    <naslov>" + knjiga.getNaslov() + "</naslov>\r\n");
		if(!(knjiga.getPodnaslov().equals(""))){
			output.write("    <podnaslov>" + knjiga.getPodnaslov() + "</podnaslov>\r\n");
		}
		Iterator<model.Autor> it = knjiga.autori();
		while(it.hasNext())
			model.factory.Autor.toXML(it.next(), output); 
		output.write("    <broj_stranica>" + knjiga.getBroj_stranica() + "</broj_stranica>\r\n");
		Iterator<model.Izdavac> iter = knjiga.izdavaci();
		while(iter.hasNext())
			model.factory.Izdavac.toXML(iter.next(), output); 
		output.write("    <datum_izdanja>" + knjiga.getDatum_izdanja() + "</datum_izdanja>\r\n");
		output.write("    <naèin_distribucije>" + knjiga.getNacin_distribucije() + "</naèin_distribucije>\r\n");
		output.write("    <kategorija>" + knjiga.getKategorija() + "</kategorija>\r\n");
		output.write("    <broj_poglavlja>" + knjiga.getBroj_poglavlja() + "</broj_poglavlja>\r\n");
		output.write("    <cijena>" + knjiga.getCijena() + "</cijena>\r\n");
		output.write("  </knjiga>\r\n");
	}
}
