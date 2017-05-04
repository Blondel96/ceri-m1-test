package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IPokedexTest {
	@Mock
	private IPokedex IpokedexMock;

	private Pokemon myPokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
	private Pokemon anotherPokemon = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1);
	
	private PokemonComparators nameComparator = PokemonComparators.NAME;
	private PokemonComparators indexComparator = PokemonComparators.INDEX;
	private PokemonComparators cpComparator = PokemonComparators.CP;
	 

	public void setIpokedexMock(IPokedex ipokedexMock) {
		IpokedexMock = ipokedexMock;
	}

	  

	public void setMyPokemon(Pokemon myPokemon) {
		this.myPokemon = myPokemon;
	}
	public void setAnotherPokemon(Pokemon anotherPokemon) {
		this.anotherPokemon = anotherPokemon;
	}

	 
	 

	@Test 
	public void testaddPokemon() {
		assertEquals(0, IpokedexMock.addPokemon(myPokemon));
	}
	
	@Test
	public void testsize() {
		assertNotNull(IpokedexMock.size());
	}

	

	@Test
	public void testgetPokemon() throws PokedexException {
		Pokemon newPoke = IpokedexMock.getPokemon(0);
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
		//nameComparator
		assertTrue(IpokedexMock.getPokemons(nameComparator).getClass().isInstance(Collections.unmodifiableList(new ArrayList<>())));
		//indexComparator
		assertTrue(IpokedexMock.getPokemons(indexComparator).getClass().isInstance(Collections.unmodifiableList(new ArrayList<>())));
		//cpComparator
		assertTrue(IpokedexMock.getPokemons(cpComparator).getClass().isInstance(Collections.unmodifiableList(new ArrayList<>())));
	}
	@Before
	public void setUp() throws PokedexException {
		MockitoAnnotations.initMocks(this);
	    List<Pokemon> listPokemon;
	    List<Pokemon> unmodifiable;
	    List<Pokemon> sortedListName ;
	    List<Pokemon> sortedListCp;
	    List<Pokemon> sortedListIndex;
		listPokemon= new ArrayList<Pokemon>();
		listPokemon.add(myPokemon);
		listPokemon.add(anotherPokemon);
		unmodifiable = Collections.unmodifiableList(listPokemon);
		listPokemon.sort(nameComparator);
		sortedListName = Collections.unmodifiableList(listPokemon);
	    listPokemon.sort(cpComparator);
	    sortedListCp = Collections.unmodifiableList(listPokemon);
	    listPokemon.sort(indexComparator);
	    sortedListIndex = Collections.unmodifiableList(listPokemon);
		Mockito.when(IpokedexMock.size()).thenReturn(0);
		Mockito.when(IpokedexMock.addPokemon(myPokemon)).thenReturn(myPokemon.getIndex());
		Mockito.when(IpokedexMock.getPokemon(myPokemon.getIndex())).thenReturn(myPokemon);
		Mockito.when(IpokedexMock.getPokemons()).thenReturn(unmodifiable);
		Mockito.when(IpokedexMock.getPokemons(nameComparator)).thenReturn(sortedListName);
		Mockito.when(IpokedexMock.getPokemons(cpComparator)).thenReturn(sortedListCp);
		Mockito.when(IpokedexMock.getPokemons(indexComparator)).thenReturn(sortedListIndex);
		Mockito.when(IpokedexMock.getPokemon(-1)).thenThrow(new PokedexException("Fatal Error invalid Id !"));

	}
}
