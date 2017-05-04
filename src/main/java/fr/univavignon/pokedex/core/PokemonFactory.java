package fr.univavignon.pokedex.core;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.PokedexException;
import fr.univavignon.pokedex.api.Pokemon;
import io.github.bonigarcia.wdm.ChromeDriverManager;
 

public class PokemonFactory implements IPokemonFactory {
	private final String URL_VALUE = "https://pokeassistant.com/main/ivcalculator?locale=en";
	 
	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		String name = "";
		try {
			name = PokemonMetadataProvider.getInstance().getPokemonMetadata(index).getName();
		} catch (PokedexException e) {
			
		} catch (IOException e) {
		
		}
		ChromeDriverManager.getInstance().setup();
		WebDriver phantom = new ChromeDriver();
		
		phantom.get(URL_VALUE);
		
		phantom.findElement(By.xpath("//*[@id=\"search_pokemon_name\"]")).sendKeys(name);
		phantom.findElement(By.xpath("/html/body/div/div[3]/div[1]/span/div/div/div")).click();
		phantom.findElement(By.xpath("//*[@id=\"search_cp\"]")).sendKeys(Integer.toString(cp));
		phantom.findElement(By.xpath("//*[@id=\"search_hp\"]")).sendKeys(Integer.toString(hp));
		phantom.findElement(By.xpath("//*[@id=\"search_dust\"]")).sendKeys(Integer.toString(dust));
		phantom.findElement(By.xpath("//*[@id=\"calculatebtn\"]")).click();
		
		int attack = Integer.parseInt(phantom.findElement(By.xpath("//*[@id=\"possiblecombis\"]/tbody/tr[1]/td[2]")).getText());
		int defense = Integer.parseInt(phantom.findElement(By.xpath("//*[@id=\"possiblecombis\"]/tbody/tr[1]/td[3]")).getText());
		int stamina = Integer.parseInt(phantom.findElement(By.xpath("//*[@id=\"possiblecombis\"]/tbody/tr[1]/td[4]")).getText());
		String ivString = phantom.findElement(By.xpath("//*[@id=\"possiblecombis\"]/tbody/tr[1]/td[5]")).getText();
		ivString= ivString.split("%")[0];
		Double iv = Double.parseDouble(ivString)/100;
		phantom.quit();
		return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
	}
	
	
	
	public PokemonFactory() {
	
	}
}
