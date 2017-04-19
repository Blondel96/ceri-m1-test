package fr.univavignon.pokedex.core;

import java.io.IOException;

import org.junit.Before;
import fr.univavignon.pokedex.api.IPokemonMetadataProviderTest;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;

public class PokemonMetadataProviderTest extends IPokemonMetadataProviderTest{
	
	@Before
	public void setUp() throws PokedexException {
		
		try {
			this.setIpokemonMetadataProviderMock(PokemonMetadataProvider.getInstance());
			this.setPokeData(new PokemonMetadata(1, "Bulbasaur", 126, 126, 90));
		} catch (IOException e) {
			
		}
	}

	
}
