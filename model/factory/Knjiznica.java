package model.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

import model.Knjiga;

public class Knjiznica {

	
	public static model.Knjiznica fromText(BufferedReader input) {

		//stvori objekt - listu kartica
		model.Knjiznica listaKnjiga = new model.Knjiznica();
		
		//string koji sadrži proèitani redak datoteke
		String line = null;
		
		//trenutni redak datoteke
		int currentLine = 0;
		
		try {
		
			//do zadnjeg retka u datoteci ...
			while( (line = input.readLine()) != null ) {
				
				//povecavanje brojaca trenutne linije
				currentLine++;
				
				//odbaci prazne znakove na poèetku i kraju retka
				line = line.trim();
				
				//preskoci prazne retke
				if( line.length() == 0 ) 
					continue;
				
				//preskoèi retke ako poèinju sa znakom # (komentari)
				if( line.startsWith("#") )
					continue;
				
				model.Knjiga knjiga = null;
				
				//predaj stvoreni string tvornici objekata Kartica
				knjiga = model.factory.Knjiga.fromText(line);
				
				//dodaj novostvoreni objekt u listu objekata (ako nije null)
				if( knjiga != null )
					listaKnjiga.add(knjiga);
			}
		} catch(Exception e) {
			System.out.println("Greska u retku " + currentLine);
			return null;
		}
		//vrati novostvorenu listu kartica
		return listaKnjiga;
	}
	
	public static void toXML(model.Knjiznica knjige, Writer output) throws IOException {
		
		if( knjige == null ) return;
		output.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n");
		output.write("<!DOCTYPE knjiznica SYSTEM \"gramatika.dtd\">\r\n");
		output.write("<?xml-stylesheet type=\"text/xsl\" href=\"pretvorba.xsl\"?>\r\n");
		output.write("<knjiznica>\r\n");
		Iterator<Knjiga> it = knjige.knjige();
		while(it.hasNext())
			model.factory.Knjiga.toXML(it.next(), output); 
		output.write("</knjiznica>\r\n");
		output.flush();
	}
}
