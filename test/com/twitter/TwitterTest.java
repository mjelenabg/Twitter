package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	
	private Twitter twitter;
	private TwitterPoruka tp;
	LinkedList<TwitterPoruka> lista;
	
	@Before
	public void setUp() throws Exception {
		twitter=new Twitter();
		tp=new TwitterPoruka();
		lista=new LinkedList<TwitterPoruka>();
	}

	@After
	public void tearDown() throws Exception {
		twitter=null;
		tp=null;
		lista=null;
	}

	@Test
	public void testVratiSvePorukeNull() {
		assertEquals(lista, twitter.vratiSvePoruke());
	}
	
	@Test
	public void testVratiSvePoruke1() {
		tp.setKorisnik("ana_ilic");
		tp.setPoruka("Porukaaaaa");
		lista.addLast(tp);
		twitter.unesi("ana_ilic", "Porukaaaaa" );
		assertEquals(lista, twitter.vratiSvePoruke());
	}
	
	@Test
	public void testVratiSvePoruke2() {
		TwitterPoruka tp1=new TwitterPoruka();
		tp1.setKorisnik("petar_petrovic");
		tp1.setPoruka("Porukaporuka");
		lista.addLast(tp1);
		twitter.unesi(tp1.getKorisnik(),tp1.getPoruka());
		tp.setKorisnik("ana_ilic");
		tp.setPoruka("Porukaaaaa");
		lista.addLast(tp);
		twitter.unesi(tp.getKorisnik(),tp.getPoruka());
		assertEquals(lista, twitter.vratiSvePoruke());
	}
	
	@Test
	public void testUnesiZaKorisnika() {
		twitter.unesi("ana_ilic","Poruka");
		assertEquals("ana_ilic",twitter.vratiSvePoruke().getLast().getKorisnik());
	}
	@Test
	public void testUnesiZaPoruku() {
		twitter.unesi("ana_ilic","Poruka");
		assertEquals("Poruka",twitter.vratiSvePoruke().getLast().getPoruka());	
	}
	
	@Test
	public void testUnesi() {
		tp.setKorisnik("ana_ilic");
		tp.setPoruka("Porukaaaaa");
		twitter.unesi(tp.getKorisnik(), tp.getPoruka());
		lista.addLast(tp);
		assertEquals(lista, twitter.vratiSvePoruke());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagNull() {
		twitter.vratiPoruke(50, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagPrazanString() {
		twitter.vratiPoruke(50, "");
	}
	
	@Test
	public void testVratiPorukeMaxBrManjiOdNula() {
		TwitterPoruka [] niz=twitter.vratiPoruke(-1, "tag");
		assertEquals(100, niz.length);
	}
	
	@Test
	public void testVratiPoruke() {
		TwitterPoruka tp1= new TwitterPoruka();
		TwitterPoruka tp2= new TwitterPoruka();
		TwitterPoruka tp3= new TwitterPoruka();
		TwitterPoruka tp4= new TwitterPoruka();
		TwitterPoruka [] niz= new TwitterPoruka[3];
		tp1.setKorisnik("ana_ilic");
		tp1.setPoruka("Poruka 1");
		tp2.setKorisnik("ana");
		tp2.setPoruka("Poruka 2");
		tp3.setKorisnik("ilic");
		tp3.setPoruka("Poruka 3");
		tp4.setKorisnik("ai");
		tp4.setPoruka("Poruka 4");
		twitter.unesi(tp1.getKorisnik(), tp1.getPoruka());
		twitter.unesi(tp2.getKorisnik(), tp2.getPoruka());
		twitter.unesi(tp3.getKorisnik(), tp3.getPoruka());
		twitter.unesi(tp4.getKorisnik(), tp4.getPoruka());
		niz[0]=tp1;
		assertArrayEquals(niz, twitter.vratiPoruke(3, "1"));
	}
}
