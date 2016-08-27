package model.factory;

import java.io.IOException;
import java.io.Writer;
import java.util.StringTokenizer;


public class Izdavac {

	public static model.Izdavac fromText(String input)  {
		
		model.Izdavac izdavac = new model.Izdavac();
		
		StringTokenizer tok = new StringTokenizer(input, ",");
		
		//naziv izdavaèa
		String naziv = tok.nextToken().trim();
		izdavac.setNaziv(naziv);
		
		return izdavac;
	}
	
	public static void toXML(model.Izdavac izdavac, Writer output) throws IOException {
		
		output.write("    <izdavac>\r\n");
		output.write("      <naziv>" + izdavac.getNaziv() + "</naziv>\r\n");
		output.write("    </izdavac>\r\n");
	}
	
}

