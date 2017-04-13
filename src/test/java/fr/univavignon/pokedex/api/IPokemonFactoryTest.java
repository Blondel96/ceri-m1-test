package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokemonFactoryTest {
	@Mock
	private IPokemonFactory IpokemonFactoryMock;
	private Pokemon myPokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4,0.56);
	@Test
	public void testcreatePokemon(){
		Pokemon newPoke = IpokemonFactoryMock.createPokemon(0, 613, 64, 4000, 4);
		
		assertEquals(myPokemon.getAttack(),newPoke.getAttack());
		assertEquals(myPokemon.getDefense(),newPoke.getDefense());
		assertEquals(myPokemon.getStamina(),newPoke.getStamina());
		assertEquals(myPokemon.getCp(),newPoke.getCp());
		assertEquals(myPokemon.getHp(),newPoke.getHp());
		assertEquals(myPokemon.getName(),newPoke.getName());
		assertEquals(myPokemon.getCandy(),newPoke.getCandy());
		assertEquals(myPokemon.getDust(),newPoke.getDust());
		assertEquals(myPokemon.getIndex(),newPoke.getIndex());
		assertEquals(myPokemon.getIv(), newPoke.getIv(),2);
	}
	
	@Before
	public void setUp()  {
		MockitoAnnotations.initMocks(this);
		Mockito.when(IpokemonFactoryMock.createPokemon(0, 613, 64, 4000, 4)).thenReturn(myPokemon);
		
	}
}
