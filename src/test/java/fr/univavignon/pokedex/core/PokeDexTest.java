package fr.univavignon.pokedex.core;

import java.io.IOException;

 

import fr.univavignon.pokedex.api.IPokedexTest;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;

public class PokeDexTest extends IPokedexTest{
	private PokemonFactory pokemonFactory = new PokemonFactory();
	private Pokemon pokemon = pokemonFactory.createPokemon(1, 613, 64, 4000, 4);
	private Pokemon anotherPokemon = pokemonFactory.createPokemon(63, 500, 30, 2500, 4);
	@Override
	public void setUp() throws PokedexException {
		PokemonMetadataProvider metadataProvider = null;
		try {
			metadataProvider = PokemonMetadataProvider.getInstance();
		} catch (IOException e) {
			
		}
		Pokedex pokeDex = new Pokedex(pokemonFactory,metadataProvider);
		pokeDex.addPokemon(pokemon);
		pokeDex.addPokemon(anotherPokemon);
		this.setIpokedexMock(pokeDex);
		this.setMyPokemon(pokemon);
		this.setAnotherPokemon(anotherPokemon);
		

	}
}
