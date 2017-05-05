# UCE Génie Logiciel Avancé : Techniques de tests

Nom Prénom : Diffo Erso Blondel
Groupe : Classique

Badge CircleCI: 

	[![CircleCI](https://circleci.com/gh/Blondel96/ceri-m1-test.svg?style=svg)](https://circleci.com/gh/Blondel96/ceri-m1-test)
Badge Qualité de Code :
	 [![Codacy Badge](https://api.codacy.com/project/badge/Grade/ccf9b213f4f64d97a16dc90c52aa00fd)](https://www.codacy.com/app/Blondel96/ceri-m1-test?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Blondel96/ceri-m1-test&amp;utm_campaign=Badge_Grade)
	 
Badge Couverture de tests : 
[![Codacy Badge](https://api.codacy.com/project/badge/Coverage/ccf9b213f4f64d97a16dc90c52aa00fd)](https://www.codacy.com/app/Blondel96/ceri-m1-test?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Blondel96/ceri-m1-test&amp;utm_campaign=Badge_Coverage)


---Description des implémentations

1. PokemonMetadataProvider: Cette Classe a été implémentée en utilisant l'API GSON pour recupérer les informations sur les races de pokémons
							 elle utilise le pattern singleton pour éviter de recharger les données à chaque appel de ses fonctions.
							 
2. PokemonFactory: Elle utilise le chrome driver pour calculer l'iv du pokemon et initialise le pokemon avec les valeurs d'attaque, défense et stamina.

3. Pokedex: Elle utilise le pattern decorator et possède les attributs de deux classes précédentes.

4.PokemonTrainerFactory: Elle utilise la librairie XStream afin de sérialiser la liste des trainers dans un fichier XML. Ce dernier permettra de recharger le trainer 
						dans le cas ou il existerait déjà.
						