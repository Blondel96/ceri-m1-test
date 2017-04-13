package fr.univavignon.pokedex.api;


import static org.junit.Assert.*;

 
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class IPokedexFactoryTest {
	@Mock
	private IPokemonFactory IpokemonFactoryMock;
    @Mock
    private IPokemonMetadataProvider IpokemonMetadataProviderMock;
    @Mock
    private IPokedexFactory IpokedexFactoryMock;
    @Mock
    private IPokedex myPokedex ;
    private PokemonMetadata pokeData = new PokemonMetadata(0, "meta1", 10, 15, 30);
    private Pokemon myPokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4,0.56);
    
	@Test
	public void testcreatePokedex(){
	
		assertNotNull(IpokedexFactoryMock.createPokedex(IpokemonMetadataProviderMock, IpokemonFactoryMock));
	}
	
	@Before
	public void setUp() throws PokedexException {
		MockitoAnnotations.initMocks(this);
		Mockito.when(IpokemonMetadataProviderMock.getPokemonMetadata(0)).thenReturn(pokeData);
		Mockito.when(IpokemonMetadataProviderMock.getPokemonMetadata(-1)).thenThrow(new PokedexException("Impossible de trouver le pokemon !"));
		Mockito.when(IpokemonFactoryMock.createPokemon(0, 613, 64, 4000, 4)).thenReturn(myPokemon);
		Mockito.when(IpokedexFactoryMock.createPokedex(IpokemonMetadataProviderMock, IpokemonFactoryMock)).thenReturn(myPokedex);
	}
}
