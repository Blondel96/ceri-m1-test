package fr.univavignon.pokedex.core;

import java.io.IOException;

import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.IPokemonTrainerFactory;
import fr.univavignon.pokedex.api.IPokemonTrainerFactoryTest;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Team;

public class PokemonTrainerFactoryTest extends IPokemonTrainerFactoryTest {
	@Override
	public void setUp() throws PokedexException {
		IPokemonFactory pokemonFactory = new PokemonFactory();
		IPokemonMetadataProvider metadataProvider = null;
		try {
			metadataProvider = PokemonMetadataProvider.getInstance();
		} catch (IOException e) {
		 
		}
		IPokemonTrainerFactory pokemonTrainerFactory = new PokemonTrainerFactory(pokemonFactory, metadataProvider);
		IPokedexFactory pokedexFactory = new PokedexFactory();
		this.setIpokemonTrainerFactoryMock(pokemonTrainerFactory);
		this.setIpokedexFactoryMock(pokedexFactory);
		this.setTeam(Team.INSTINCT);
		 
	}
}
