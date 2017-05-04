package fr.univavignon.pokedex.core;

import fr.univavignon.pokedex.api.IPokemonFactoryTest;
import fr.univavignon.pokedex.api.Pokemon;

public class PokemonFactoryTest extends IPokemonFactoryTest {
	@Override
	public void setUp() {
		PokemonFactory pf = new PokemonFactory();
		setIpokemonFactoryMock(pf);
		
		setMyPokemon(new Pokemon(1, "Bulbasaur", 5, 12, 6, 613, 64, 4000, 4,0.511));
	}
}
