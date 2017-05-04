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
	
	@Test
	public void testcreateTrainer(){
		//Team instinct
		PokemonTrainer p1 = IpokemonTrainerFactoryMock.createTrainer("Samuel", Team.INSTINCT, IpokedexFactoryMock);
		assertEquals(Team.INSTINCT,p1.getTeam());
		assertEquals("Samuel", p1.getName());
		assertNotNull(p1.getPokedex());
		//Team Mystic
		PokemonTrainer p2 = IpokemonTrainerFactoryMock.createTrainer("David", Team.MYSTIC, IpokedexFactoryMock);
		assertEquals(Team.MYSTIC,p2.getTeam());
		assertEquals("David", p2.getName());
		assertNotNull(p2.getPokedex());
		//Team Valor
		PokemonTrainer p3 = IpokemonTrainerFactoryMock.createTrainer("Roger", Team.VALOR, IpokedexFactoryMock);
		assertEquals(Team.VALOR,p3.getTeam());
		assertEquals("Roger", p3.getName());
		assertNotNull(p3.getPokedex());
		//verifier le chargement si le trainer existe déja
		PokemonTrainer p4 = IpokemonTrainerFactoryMock.createTrainer("Samuel", Team.INSTINCT, IpokedexFactoryMock);
		assertEquals(Team.INSTINCT,p4.getTeam());
		assertEquals("Samuel", p4.getName());
		assertNotNull(p4.getPokedex());
	}
	@Before
	public void setUp() throws PokedexException {
		MockitoAnnotations.initMocks(this);
		 
		Mockito.when(IpokedexFactoryMock.createPokedex(IpokemonMetadataProviderMock, IpokemonFactoryMock)).thenReturn(myPokedex);
		PokemonTrainer trainer1 = new PokemonTrainer("Samuel", Team.INSTINCT, IpokedexFactoryMock.createPokedex(IpokemonMetadataProviderMock, IpokemonFactoryMock));
		Mockito.when(IpokemonTrainerFactoryMock.createTrainer("Samuel",Team.INSTINCT,IpokedexFactoryMock)).thenReturn(trainer1);
		
		PokemonTrainer trainer2 = new PokemonTrainer("David", Team.MYSTIC, IpokedexFactoryMock.createPokedex(IpokemonMetadataProviderMock, IpokemonFactoryMock));
		Mockito.when(IpokemonTrainerFactoryMock.createTrainer("David",Team.MYSTIC,IpokedexFactoryMock)).thenReturn(trainer2);
		
		PokemonTrainer trainer3 = new PokemonTrainer("Roger", Team.VALOR, IpokedexFactoryMock.createPokedex(IpokemonMetadataProviderMock, IpokemonFactoryMock));
		Mockito.when(IpokemonTrainerFactoryMock.createTrainer("Roger",Team.VALOR,IpokedexFactoryMock)).thenReturn(trainer3);
	}
 
	public void setIpokedexFactoryMock(IPokedexFactory ipokedexFactoryMock) {
		IpokedexFactoryMock = ipokedexFactoryMock;
	}
	 
	public void setIpokemonTrainerFactoryMock(IPokemonTrainerFactory ipokemonTrainerFactoryMock) {
		IpokemonTrainerFactoryMock = ipokemonTrainerFactoryMock;
	}
	 
	
}
