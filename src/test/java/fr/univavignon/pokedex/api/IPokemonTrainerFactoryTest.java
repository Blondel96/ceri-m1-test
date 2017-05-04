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
	private Team team = Team.INSTINCT;
	private PokemonTrainer trainer;
	
	@Test
	public void testcreateTrainer(){
		PokemonTrainer p = IpokemonTrainerFactoryMock.createTrainer("Samuel", team, IpokedexFactoryMock);
		assertEquals(team,p.getTeam());
		assertEquals("Samuel", p.getName());
		assertNotNull(p.getPokedex());
	}
	@Before
	public void setUp() throws PokedexException {
		MockitoAnnotations.initMocks(this);
		Mockito.when(IpokemonFactoryMock.createPokemon(0, 613, 64, 4000, 4)).thenReturn(myPokemon);
		Mockito.when(IpokedexFactoryMock.createPokedex(IpokemonMetadataProviderMock, IpokemonFactoryMock)).thenReturn(myPokedex);
		trainer = new PokemonTrainer("Samuel", team, IpokedexFactoryMock.createPokedex(IpokemonMetadataProviderMock, IpokemonFactoryMock));
		Mockito.when(IpokemonTrainerFactoryMock.createTrainer("Samuel",team,IpokedexFactoryMock)).thenReturn(trainer);
	}
 
	public void setIpokedexFactoryMock(IPokedexFactory ipokedexFactoryMock) {
		IpokedexFactoryMock = ipokedexFactoryMock;
	}
	 
	public void setIpokemonTrainerFactoryMock(IPokemonTrainerFactory ipokemonTrainerFactoryMock) {
		IpokemonTrainerFactoryMock = ipokemonTrainerFactoryMock;
	}
	 
	 
	public void setTeam(Team team) {
		this.team = team;
	}
	
}
