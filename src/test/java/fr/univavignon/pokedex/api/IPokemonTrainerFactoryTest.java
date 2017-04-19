package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokemonTrainerFactoryTest {
	@Mock
	private IPokemonFactory IpokemonFactoryMock;
	@Mock
    private IPokedexFactory IpokedexFactoryMock;
	@Mock
	private IPokemonMetadataProvider IpokemonMetadataProviderMock;
	@Mock
    private IPokedex myPokedex ;
	@Mock
	private IPokemonTrainerFactory IpokemonTrainerFactoryMock;
	
	private Pokemon myPokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4,0.56);
	private Team team;
	private PokemonTrainer trainer;
	
	@Test
	public void testcreateTrainer(){
		PokemonTrainer p = IpokemonTrainerFactoryMock.createTrainer("Roger", team, IpokedexFactoryMock);
		assertEquals(team,p.getTeam());
		assertEquals(trainer.getName(), p.getName());
		assertEquals(trainer.getPokedex(), p.getPokedex());
	}
	@Before
	public void setUp() throws PokedexException {
		MockitoAnnotations.initMocks(this);
		Mockito.when(IpokemonFactoryMock.createPokemon(0, 613, 64, 4000, 4)).thenReturn(myPokemon);
		Mockito.when(IpokedexFactoryMock.createPokedex(IpokemonMetadataProviderMock, IpokemonFactoryMock)).thenReturn(myPokedex);
		trainer = new PokemonTrainer("Roger", team, IpokedexFactoryMock.createPokedex(IpokemonMetadataProviderMock, IpokemonFactoryMock));
		Mockito.when(IpokemonTrainerFactoryMock.createTrainer("Roger",team,IpokedexFactoryMock)).thenReturn(trainer);
	}
}
