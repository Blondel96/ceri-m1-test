package fr.univavignon.pokedex.api;


import static org.junit.Assert.*;

import org.junit.Before;
 
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public  class IPokemonMetadataProviderTest {
	
	@Mock 
	private IPokemonMetadataProvider IpokemonMetadataProviderMock;
	private PokemonMetadata pokeData;
	public IPokemonMetadataProvider getIpokemonMetadataProviderMock() {
		return IpokemonMetadataProviderMock;
	}

	public void setIpokemonMetadataProviderMock(IPokemonMetadataProvider ipokemonMetadataProviderMock) {
		IpokemonMetadataProviderMock = ipokemonMetadataProviderMock;
	}

	public PokemonMetadata getPokeData() {
		return pokeData;
	}

	public void setPokeData(PokemonMetadata pokeData) {
		this.pokeData = pokeData;
	}


	@Test 
	public void testgetPokemonMetadata() throws PokedexException{
		 
		PokemonMetadata data = IpokemonMetadataProviderMock.getPokemonMetadata(pokeData.getIndex()) ;
		assertEquals(pokeData.getIndex(),data.getIndex());
		assertEquals(pokeData.getName(),data.getName());
		assertEquals(pokeData.getStamina(),data.getStamina());
		assertEquals(pokeData.getAttack(),data.getAttack());
		assertEquals(pokeData.getDefense(),data.getDefense());
	}
	
	@Test(expected=PokedexException.class)
	public void testgetPokemonMetadataPokedexException() throws PokedexException{
		IpokemonMetadataProviderMock.getPokemonMetadata(-1);
	}
	
	@Before
	public void setUp() throws PokedexException {
		MockitoAnnotations.initMocks(this);
		pokeData = new PokemonMetadata(0, "meta1", 10, 15, 30);
		Mockito.when(IpokemonMetadataProviderMock.getPokemonMetadata(0)).thenReturn(pokeData);
		Mockito.when(IpokemonMetadataProviderMock.getPokemonMetadata(-1)).thenThrow(new PokedexException("Impossible de trouver le pokemon !"));
	}
	
}
