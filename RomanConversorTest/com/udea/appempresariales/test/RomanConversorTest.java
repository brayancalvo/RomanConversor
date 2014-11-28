package com.udea.appempresariales.test;

import static org.junit.Assert.*;
import om.udae.appempresariales.RomanConversor;

import org.junit.Test;

public class RomanConversorTest {
	
	RomanConversor romanconversor = new RomanConversor();

	@Test
	public void menorA3() {
		String romanNumber = romanconversor.turnit("3");
		assertEquals("III",romanNumber);
	}
	
	@Test
	public void mayorA3yMenor10() {
		String romanNumber = romanconversor.turnit("10");
		assertEquals("X",romanNumber);
	}
	
	@Test
	public void mayorA10yMenor100() {
		String romanNumber = romanconversor.turnit("51");
		assertEquals("LI",romanNumber);
	}
	
	@Test
	public void validaLetras() {
		String romanNumber = romanconversor.turnit("1X");
		assertEquals("error",romanNumber);
	}

}
