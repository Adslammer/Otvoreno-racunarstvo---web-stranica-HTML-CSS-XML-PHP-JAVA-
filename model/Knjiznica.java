package model;

import java.util.Iterator;
import java.util.Vector;

public class Knjiznica {

	private Vector<Knjiga> knjige = new Vector<Knjiga>();
	
	public void add(Knjiga knjiga) {
		knjige.add(knjiga);
	}
	
	public void remove(Knjiga knjiga) {
		knjige.remove(knjiga);
		
	}
	public Iterator<Knjiga> knjige() {
		
		return knjige.iterator();
	}
}
