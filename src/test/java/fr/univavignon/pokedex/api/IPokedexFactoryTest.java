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
    private IPokedex myPokedex = null ;
    
	@Test
	public void testcreatePokedex(){
		IPokedex pokedex = IpokedexFactoryMock.createPokedex(IpokemonMetadataProviderMock, IpokemonFactoryMock);
		assertNotNull(pokedex);
		
	}
	
	@Before
	public void setUp() throws PokedexException {
		MockitoAnnotations.initMocks(this);
		Mockito.when(IpokedexFactoryMock.createPokedex(IpokemonMetadataProviderMock, IpokemonFactoryMock)).thenReturn(myPokedex);
	}

	public void setIpokedexFactoryMock(IPokedexFactory ipokedexFactoryMock) {
		IpokedexFactoryMock = ipokedexFactoryMock;
	}

	 

	
	
}
