package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IPokedexTest {
	@Mock
	private IPokedex IpokedexMock;

	private Pokemon myPokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
	private Pokemon anotherPokemon = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1);
	
	private Comparator<Pokemon> nameComparator;
	@Test
	public void testsize() {
		assertNotNull(IpokedexMock.size());
	}

	@Test
	public void testaddPokemon() {
		assertEquals(myPokemon.getIndex(), IpokedexMock.addPokemon(myPokemon));
	}

	@Test
	public void testgetPokemon() throws PokedexException {
		Pokemon newPoke = IpokedexMock.getPokemon(myPokemon.getIndex());
		assertEquals(myPokemon, newPoke);
	}

	@Test(expected = PokedexException.class)
	public void testgetPokemonPokedexException() throws PokedexException {
		IpokedexMock.getPokemon(-1);
	}

	@Test
	public void testgetPokemons() {
		  assertFalse(IpokedexMock.getPokemons().isEmpty());
		  assertTrue(IpokedexMock.getPokemons().getClass().isInstance(Collections.unmodifiableList(new ArrayList<>())));
		   
	}

	@Test
	public void testgetPokemonsOrderBy(){
		assertFalse(IpokedexMock.getPokemons(nameComparator).isEmpty());
		assertTrue(IpokedexMock.getPokemons(nameComparator).getClass().isInstance(Collections.unmodifiableList(new ArrayList<>())));
		assertEquals(anotherPokemon.getIndex(),IpokedexMock.getPokemons(nameComparator).get(0).getIndex());
	}
	@Before
	public void setUp() throws PokedexException {
		MockitoAnnotations.initMocks(this);
	    List<Pokemon> listPokemon;
	    List<Pokemon> unmodifiable;
	    List<Pokemon> sortedList ;
		listPokemon= new ArrayList<Pokemon>();
		listPokemon.add(myPokemon);
		listPokemon.add(anotherPokemon);
		unmodifiable = Collections.unmodifiableList(listPokemon);
		
		nameComparator = new Comparator<Pokemon>() {
			
			@Override
			public int compare(Pokemon o1, Pokemon o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};
		listPokemon.sort(nameComparator);
		sortedList = Collections.unmodifiableList(listPokemon);
	    
		Mockito.when(IpokedexMock.size()).thenReturn(0);
		Mockito.when(IpokedexMock.addPokemon(myPokemon)).thenReturn(myPokemon.getIndex());
		Mockito.when(IpokedexMock.getPokemon(myPokemon.getIndex())).thenReturn(myPokemon);
		Mockito.when(IpokedexMock.getPokemons()).thenReturn(unmodifiable);
		Mockito.when(IpokedexMock.getPokemons(nameComparator)).thenReturn(sortedList);
		Mockito.when(IpokedexMock.getPokemon(-1)).thenThrow(new PokedexException("Fatal Error invalid Id !"));

	}
}
