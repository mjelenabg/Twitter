package com.twitter.poruke;

/**
 * Ova klasa predstavlja Twitter poruku.
 * @author mjelenabg
 * @version 0.1
 */
public class TwitterPoruka {
	
	/**
	 * Korisnik koji je napisao twitter poruku.
	 */
	private String korisnik;
	
	/**
	 * Poruka koju je korisnik napisao. 
	 */
	private String poruka;
	
	/**
	 * Metoda koja vraca vrednost atributa korisnik.
	 * @return korisnik kao String.
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Metoda postavlja vrednost atributa korisnik na unetu vrednost.
	 * @param korisnik Nova vrednost za atribut korisnik.
	 * @throws java.lang.RuntimeException ako je uneti korisnik null ili prazan String.
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || korisnik.equals(""))
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	
	/**
	 * Metoda koja vraca vrednost atributa poruka.
	 * @return poruka kao String.
	 */
	public String getPoruka() {
		return poruka;
	}
	
	/**
	 * Metoda postavlja vrednost atributa poruka na unetu vrednost.
	 * @param poruka Nova vrednost za atribut poruka.
	 * @throws java.lang.RuntimeException ako je uneta poruka null ili duza od 140 znakova.
	 */
	public void setPoruka(String poruka) {
		if (poruka==null || poruka.length()>140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
			this.poruka = poruka;
	}
	
	/**
	 * Metoda koja vraca vrednost atributa korisnik i vrednost atributa poruka.
	 * @return korisnik i poruka kao String.
	 */
	public String toString(){
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((korisnik == null) ? 0 : korisnik.hashCode());
		result = prime * result + ((poruka == null) ? 0 : poruka.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TwitterPoruka other = (TwitterPoruka) obj;
		if (korisnik == null) {
			if (other.korisnik != null)
				return false;
		} else if (!korisnik.equals(other.korisnik))
			return false;
		if (poruka == null) {
			if (other.poruka != null)
				return false;
		} else if (!poruka.equals(other.poruka))
			return false;
		return true;
	}
	


}
