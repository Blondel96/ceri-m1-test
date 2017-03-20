package fr.univavignon.pokedex.api;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


public final  class IPokemonMetadataProviderTest {
	
	@Mock private IPokemonMetadataProvider IpokemonMetadataProviderMock;
	
	
	private PokemonMetadata pokeData = new PokemonMetadata(0, "meta1", 10, 15, 30);
	@Test 
	public void testgetPokemonMetadata() throws PokedexException{
		assertEquals(pokeData, IpokemonMetadataProviderMock.getPokemonMetadata(0));
	}
	
	@Test(expected=PokedexException.class)
	public void testgetPokemonMetadataPokedexException() throws PokedexException{
		IpokemonMetadataProviderMock.getPokemonMetadata(-1);
	}
	
	@Before
	public void setUp() throws PokedexException {
		Mockito.when(IpokemonMetadataProviderMock.getPokemonMetadata(0)).thenReturn(pokeData);
		Mockito.when(IpokemonMetadataProviderMock.getPokemonMetadata(-1)).thenThrow(new PokedexException("Impossible de trouver le pokemon !"));
	}
	
}
