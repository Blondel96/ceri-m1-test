package fr.univavignon.pokedex.core;
import java.io.IOException;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
 
import com.thoughtworks.xstream.io.xml.DomDriver;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.IPokemonTrainerFactory;
import fr.univavignon.pokedex.api.PokemonTrainer;
import fr.univavignon.pokedex.api.Team;
import util.FileManager;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {

	private IPokemonFactory pokemonFactory;
	private IPokemonMetadataProvider metadataProvider;
	private final String POKETRAINER_FILE = "datas.xml";
	private ArrayList<PokemonTrainer> pokeTrainerDatas = null;
	private XStream xStream = new XStream(new DomDriver());
	public PokemonTrainerFactory(IPokemonFactory pokemonFactory, IPokemonMetadataProvider metadataProvider ) {
		super();
		try{
		this.pokemonFactory = pokemonFactory;
		this.metadataProvider = metadataProvider;
		//Chargement des données des trainers depuis le fichier xml
		 
		xStream.alias("PokemonTrainer",new ArrayList<PokemonTrainer>().getClass());
		this.pokeTrainerDatas = (ArrayList<PokemonTrainer>) xStream.fromXML(FileManager.readFile(POKETRAINER_FILE));
		}
		catch(Exception ex){
			this.pokeTrainerDatas = null;
		}
		
	}

	@Override
	public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
		try{
		IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
		PokemonTrainer pokemonTrainer = new PokemonTrainer(name, team, pokedex);
		boolean b = false;
		//on verifie si la liste contient des valeurs
		if(this.pokeTrainerDatas != null && this.pokeTrainerDatas.size() > 0){
			//on verifie si les données du trainer existe ou pas
			for(PokemonTrainer p:this.pokeTrainerDatas){
				if(p.getName().equals(name)){
					//on recupère le poketrainer
					pokemonTrainer = p;
					b = true;
					break;
				}
			}
			
		}
		else{
			this.pokeTrainerDatas = new ArrayList<>();
		}
		if(!b)
		{
			//on ajoute le trainer a la liste contenu dans le fichier
			this.pokeTrainerDatas.add(pokemonTrainer);
			System.out.println(this.pokeTrainerDatas.get(0));
			String content = xStream.toXML(this.pokeTrainerDatas);
			FileManager.writeFile(POKETRAINER_FILE, content);
		}
		
		return pokemonTrainer;
		}
		catch(IOException ex){
			return null;
		}
		
	}

}
