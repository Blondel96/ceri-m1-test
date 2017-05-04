package fr.univavignon.pokedex.core;

import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokedexFactoryTest;
import fr.univavignon.pokedex.api.PokedexException;

public class PokedexFactoryTest extends IPokedexFactoryTest {
	@Override
	public void setUp() throws PokedexException {
		IPokedexFactory factory = new PokedexFactory();
		this.setIpokedexFactoryMock(factory);
	}
}
