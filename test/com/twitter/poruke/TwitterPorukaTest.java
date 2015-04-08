package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterPorukaTest {
	
	private TwitterPoruka twitterPoruka;
	
	@Before
	public void setUp() throws Exception {
		twitterPoruka=new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		twitterPoruka=null;
	}

	@Test
	public void testSetKorisnik() {
		twitterPoruka.setKorisnik("ana_ilic");
		assertEquals("ana_ilic",twitterPoruka.getKorisnik());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		twitterPoruka.setKorisnik(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		twitterPoruka.setKorisnik("");
	}
	
	@Test
	public void testSetPoruka() {
		twitterPoruka.setPoruka("Poruka");
		assertEquals("Poruka",twitterPoruka.getPoruka());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		twitterPoruka.setPoruka(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaVecaOd140() {
		twitterPoruka.setPoruka("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	@Test
	public void testToString() {
		twitterPoruka.setKorisnik("ana_ilic");
		twitterPoruka.setPoruka("Poruka");
		assertEquals("KORISNIK:"+twitterPoruka.getKorisnik()+" PORUKA:"+twitterPoruka.getPoruka(),twitterPoruka.toString());
	}
}