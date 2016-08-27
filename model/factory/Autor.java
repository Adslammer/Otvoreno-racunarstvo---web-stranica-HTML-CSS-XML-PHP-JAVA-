package model.factory;

import java.io.IOException;
import java.io.Writer;
import java.util.StringTokenizer;


public class Autor {

	public static model.Autor fromText(String input)  {
		
		model.Autor autor = new model.Autor();
		
		StringTokenizer tok = new StringTokenizer(input, ",");
		
		//ime autora
		String ime = tok.nextToken().trim();
		autor.setIme(ime);
		
		//prezime autora
		String prezime = tok.nextToken().trim();
		autor.setPrezime(prezime);
		
		
		return autor;
	}
	
	public static void toXML(model.Autor autor, Writer output) throws IOException {
		
		output.write("    <autor>\r\n");
		output.write("      <ime>" + autor.getIme() + "</ime>\r\n");
		output.write("      <prezime>" + autor.getPrezime() + "</prezime>\r\n");
		output.write("    </autor>\r\n");
		
	}
	
}
