package Console;

import static org.junit.Assert.*;
import org.junit.Test;

public class BadTests {
	
	@Test
	public void emailTest1(){
		assertEquals("ovcharuksveta@ukr.net", Validation.validEmail("ovcharuksveta@ukr.net"));
	}
	
	@Test
	public void emailTest3(){
		assertEquals("sveta_96@mail.ru", Validation.validEmail("sveta_96@mail.ru"));
	}
	
	@Test
	public void emailTest4(){
		assertEquals("svitlana.ovcharuk@gmail.com", Validation.validEmail("svitlana.ovcharuk@gmail.com"));
	}
	
	@Test(timeout = 1000)
	public void emailTest5(){
		assertEquals("Invalid email, please, write again: ", Validation.validEmail("1996s@mail.ru"));
	}
	
	@Test(timeout = 1000)
	public void emailTest2(){
		assertEquals("svetka@gmail.", Validation.validEmail("svetka@gmail."));
	}
	
	
	@Test(timeout = 1000)
	public void emailTest6(){
		assertEquals("svetka@gmail..", Validation.validEmail("svetka@gmail.."));
	}
	
	@Test
	public void emailTest7(){
		assertEquals("sveta-96@mail.ru", Validation.validEmail("sveta-96@mail.ru"));
	}
	
	@Test
	public void usernameTest1(){
		assertEquals("Svitlana", Validation.validUsername("Svitlana"));
	}
	
	@Test
	public void usernameTest4(){
		assertEquals("svitlana96", Validation.validUsername("svitlana96"));
	}
	
	@Test
	public void usernameTest5(){
		assertEquals("Svitlana_Ovcharuk", Validation.validUsername("Svitlana_Ovcharuk"));
	}
	
	@Test(timeout = 1000)
	public void usernameTest2(){
		assertEquals("", Validation.validUsername("Vova"));
	}
	
	@Test(timeout = 1000)
	public void usernameTest3(){
		assertEquals("", Validation.validUsername("ndsnfb."));
	}
	
	@Test(timeout = 1000)
	public void usernameTest6(){
		assertEquals("", Validation.validUsername("_ndsnfb"));
	}
	
	
	@Test
	public void passwordTest1(){
		assertEquals("Svitlana", Validation.validPassword("Svitlana"));
	}
	
	@Test
	public void passwordTest4(){
		assertEquals("svitlana96", Validation.validPassword("svitlana96"));
	}
	
	@Test
	public void passwordTest5(){
		assertEquals("Svitlana_Ovcharuk", Validation.validPassword("Svitlana_Ovcharuk"));
	}
	
	@Test
	public void passwordTest2(){
		assertEquals("Vova", Validation.validPassword("Vova"));
	}
	
	@Test(timeout = 1000)
	public void passwordTest3(){
		assertEquals("", Validation.validPassword("ndsnfb."));
	}
	
	@Test(timeout = 1000)
	public void passwordTest6(){
		assertEquals("", Validation.validPassword("_ndsnfb"));
	}
}
