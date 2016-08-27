import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Konverter {
	
	public static void main(String[] args) {
	
		
		//provjera broja parametara s kojima je program pokrenut
		if( args.length != 2 ) {
			System.out.println("Netocan broj parametara!");
			System.exit(1);
		}
		
		//deklaracija objekata koji èitaju podatke
		FileReader inputFile = null;
		BufferedReader reader = null;
		
		//pokušaj otvaranja datoteke za èitanje
		try {
			inputFile =  new FileReader(args[0]);
		} catch(FileNotFoundException e) {
			
			System.out.println("Ulazna datoteka nije pronadjena! " + e);
			System.exit(1);
		}
		
		//BufferedReader 'nad' datotekom
		reader = new BufferedReader(inputFile);
		
		//stvaranje podatkovne strukture èitanjem tekstualne datoteke
		model.Knjiznica knjiznica = null; //X
		try {
			knjiznica = model.factory.Knjiznica.fromText(reader);//X
		} catch(Exception e) {
			System.out.println(e);
			System.exit(1);
		}
		
		//deklaracija objekata koji pišu podatke
		FileWriter outputFile = null;
		BufferedWriter writer = null;
		
		//pokušaj otvaranja datotke za pisanje
		try {
			outputFile = new FileWriter(args[1]);	
		} catch(IOException e) {
			
			System.out.println("Izlazna datoteka ne moze biti stvorena!\n" + e);
			System.exit(1);
		}
		
		//BufferedWriter 'nad' izlaznom datotekom
		writer = new BufferedWriter(outputFile);
		
		//serijalizacija podatkovne strukture u datoteku
		try {
			model.factory.Knjiznica.toXML(knjiznica, writer); //X
		} catch(IOException e) {
			System.out.println("Greska u stvaranju xml dokumenta\n" + e);
			System.exit(1);
		}
		
		//sve prošlo OK ...
		System.out.println("Konverzija dovršena!");

		//zatvaranje tokova
		try {
			outputFile.close();
		} catch(Exception e) {}
		
		try {
			inputFile.close();
		} catch(Exception e) {}
		
	}

}
