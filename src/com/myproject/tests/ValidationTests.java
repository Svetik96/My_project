package com.myproject.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.myproject.orm.Validation;

public class ValidationTests {

	@Test
	public void usernameRepeatsTest(){
		assertEquals(true, Validation.checkUsernameRepeats("Svitlana"));
		assertEquals(true, Validation.checkUsernameRepeats("one"));
		assertEquals(false, Validation.checkUsernameRepeats("sveta96"));
	}
	
	@Test
	public void usernameAndPasswordTest(){
		assertEquals(true, Validation.checkUsernameAndPassword("Svitlana"));
		assertEquals(true, Validation.checkUsernameAndPassword("sveta"));
		assertEquals(true, Validation.checkUsernameAndPassword("svetik96"));
		assertEquals(true, Validation.checkUsernameAndPassword("svetik_96"));
		assertEquals(false, Validation.checkUsernameAndPassword("967473193"));
		assertEquals(false, Validation.checkUsernameAndPassword("1996sveta"));
		assertEquals(false, Validation.checkUsernameAndPassword("Svitlana.Ovcharuk"));
		assertEquals(false, Validation.checkUsernameAndPassword("sveta#hfh"));
		assertEquals(false, Validation.checkUsernameAndPassword("sveta_"));
	}
	
	@Test
	public void emailTest(){
		assertEquals(true, Validation.checkEmail("ovcharuksveta@ukr.net"));
		assertEquals(true, Validation.checkEmail("sveta_96@mail.ru"));
		assertEquals(true, Validation.checkEmail("svitlana.ovcharuk@gmail.com"));
		assertEquals(true, Validation.checkEmail("sveta-96@mail.ru"));
		assertEquals(false, Validation.checkEmail("1996s@mail.ru"));
		assertEquals(false, Validation.checkEmail("svetka@gmail."));
		assertEquals(false, Validation.checkEmail("svetka@gmail.."));
		assertEquals(false, Validation.checkEmail("sveta#mail.com"));
		assertEquals(false, Validation.checkEmail("svetka$%96@mail.ru"));
		assertEquals(false, Validation.checkEmail("_sv@mail.ru"));
	}
}