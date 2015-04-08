package com.twitter;
import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;
/**
 * Ova klasa predstavlja Twitter.
 * @author mjelenabg
 * @version 0.1
 */
	
public class Twitter {
	
	/**
	 * Lista Twitter poruka.
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	
	/**
	 * Metoda koja vraca sve poruke iz liste Twitter poruka.
	 * @return poruke kao LinkedList
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	
	/**
	 * Metoda koja pravi novu Twitter poruku i puni je podacima, a zatim je unosi na kraj liste Twitter poruka.
	 * @param korisnik Nova vrednost za atribut korisnik.
	 * @param poruka Nova vrednost za atribut poruka.
	 */
	public void unesi(String korisnik, String poruka) {
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	
	/**
	 * Metoda koja pretrazuje poruke i trazi one koje sadrze trazeni tag.
	 * Ako nadje neku takvu i nije prekoracen maxBroj poruka ona se upisuje u niz.
	 * Ako je prekoracen maxBr pretraga se prekida.
	 * @param maxBroj Maksimalan broj poruka koje ce metoda vratiti.
	 * @param tag Tag koji ce se pretrazivati medju porukama.
	 * @return rezultat pretrage, kao niz Twitter poruka.
	 * @throws java.lang.RuntimeException ako je uneti tag null ili prazan String.
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
	 if (tag==null || tag.isEmpty()) throw new RuntimeException("Morate uneti tag");
	 	//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
	 if (maxBroj<=0)
		maxBroj = 100;
	 	//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		//Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		//se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
				if (brojac < maxBroj){
					rezultat[brojac+1]=poruke.get(i);
					brojac++;
				}
				else break;
		return rezultat;
	}
}

