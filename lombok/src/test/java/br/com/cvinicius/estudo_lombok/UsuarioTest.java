package br.com.cvinicius.estudo_lombok;

import org.junit.*;

public class UsuarioTest {

	@Test
	public void criarUsuarioComSetterGetterTest(){
		
		Usuario usuario = new Usuario();
		
		usuario.setCpf("0123456789");
		usuario.setRg("9874563210");
		usuario.setNome("Usuario 1");
		
		Usuario usuario2 = new Usuario();
		
		usuario2.setCpf("9874563210");
		usuario2.setRg("0123456789");
		usuario2.setNome("Usuario 2");
		
		Assert.assertNotEquals(usuario, usuario2);
	}
	
	@Test
	public void criarUsuarioComConstrutorTest(){
		
		Usuario usuario  = new Usuario("0123456789", "9874563210", "Usuario 1");
		Usuario usuario2 = new Usuario("9874563210", "0123456789", "Usuario 2");
		
		Assert.assertNotEquals(usuario, usuario2);
	}
}