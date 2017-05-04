package fr.univavignon.pokedex.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.PokemonMetadata;

public class Pokedex implements IPokedex,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IPokemonFactory pokemonFactory;
	private IPokemonMetadataProvider pokemonMetadataProvider;
	private List<Pokemon> pokemonList;
	
	public Pokedex(IPokemonFactory pokemonFactory,IPokemonMetadataProvider pokemonMetadataProvider) {
		super();
		this.pokemonFactory = pokemonFactory;
		this.pokemonMetadataProvider = pokemonMetadataProvider;
		pokemonList = new ArrayList<Pokemon>();
	}

	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		 
		return pokemonMetadataProvider.getPokemonMetadata(index);
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		 
		return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
	}

	@Override
	public int size() {
		return pokemonList.size();
	}

	@Override
	public int addPokemon(Pokemon pokemon) {
		pokemonList.add(pokemon);
		return (pokemonList.indexOf(pokemon));
	}

	@Override
	public Pokemon getPokemon(int id) throws PokedexException {
		Pokemon pokemon = null;
		try{
		 pokemon = pokemonList.get(id);
		}
		catch(IndexOutOfBoundsException ex){
			throw new PokedexException("Impossible de trouver le pokemon d'id "+id);
		}
		
		if(pokemon == null){
			throw new PokedexException("Impossible de trouver le pokemon d'id "+id);
		}
		
		return pokemon;
	}

	@Override
	public List<Pokemon> getPokemons() {
		return   Collections.unmodifiableList(pokemonList);
	}

	@Override
	public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
		List<Pokemon> sortedList = pokemonList;
		sortedList.sort(order);	
		return Collections.unmodifiableList(sortedList) ;
	}

	 

}
