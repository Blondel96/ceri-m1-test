package fr.univavignon.pokedex.core;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.PokemonMetadata;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {
	private final String METADATA_URL = "https://raw.githubusercontent.com/PokemonGo-Enhanced/node-pokemongo-data/master/data.json";
	private List<PokemonMetadata> cacheDatas = new ArrayList<PokemonMetadata>();
	private static PokemonMetadataProvider INSTANCE = null;
	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		PokemonMetadata value = null;
		for (PokemonMetadata pm : this.cacheDatas) {
			if (pm.getIndex() == index) {
				value = pm;
				break;
			}
		}
		if (value == null) {
			throw new PokedexException("Impossible de trouver les données demandées !");
		}
		else{
			return value;
		}
		
	}
	public static PokemonMetadataProvider getInstance() throws IOException{
		if(INSTANCE == null){
			return new PokemonMetadataProvider();
		}
		else{
			return INSTANCE;
		}
	}
	private PokemonMetadataProvider() throws IOException {
		super();
			 	
				URL url = new URL(METADATA_URL);
				JSONArray jsonArray = new JSONArray(IOUtils.toString(url));
				jsonArray.forEach(item -> {
				    JSONObject obj = (JSONObject) item;
				    cacheDatas.add(new PokemonMetadata(obj.getInt("PkMn"),
				    		obj.getString("Identifier"),
				    		obj.getInt("BaseAttack"),
				    		obj.getInt("BaseDefense"),
				    		obj.getInt("BaseStamina")));
				});
				
		}

	}


