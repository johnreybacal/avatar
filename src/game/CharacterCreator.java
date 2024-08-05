package game;

import battle.Playable;
import battle.Player;
import bender.*;
import bending.Bending;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

import element.ElementType;

/**`
 * Character creation and character generation
 * @author jbacal
 *
 */
public class CharacterCreator {
	
	private int teamCount;
	
	private String[] names_collection = {
		//MALE names
		//from the bible
		"Aaron", "Abel", "Abraham",	"Adam",	"Andrew", "Asher", "Barak", 
		"Barnabas", "Bartholomew", "Benjamin", "Dan", "Elijah", "Elon", 
		"Ephraim", "Ezekiel", "Gabriel", "Gad", "Gideon", "Hillel", "Hiram", 
		"Immanuel", "Isaac", "Ishmael", "Israel", "Jabin", "Jacob", "James",
		"Jared", "Jesse", "Jesus", "Jethro", "Joel", "John", "Jokim", "Joseph",
		"Joshua", "Josiah", "Judah", "Levi", "Lucas", "Luke", "Mark", "Matthew",
		"Meshach", "Micah", "Moses", "Noah", "Paul", "Peter", "Philip", 
		"Reuben", "Rufus", "Samson", "Saul", "Seth", "Silas", "Simon", 
		"Solomon", "Stephen", "Thaddeus", "Thomas", "Timothy", "Zacharias",
		
		//random
		"Milo", "Lucien", "Asa", "Rolf", "Jacob", "John", "Fredric", "Erick", 
		"Edgar", "Harris", "Alan", "Margarito", "Lino", "Norbert", "Dee",
		"Newton", "Elvin", "Ariel", "Jules", "Reinaldo", "Curt", "Elden", 
		"Elton", "Sherman", "Gavin", "Seth", "Landon", "Toby", "Blaine",
		"Eusebio", "Ahmad", "Hugh", "Gregory", "Kirk", "Brice", "Cornelius", 
		"Thomas", "Chong", "Ike", "Brendan", "Deshawn", "Moshe", "Hank", 
		"Johnny", "Darnell", "Zane", "Keven", "Jon", "Stefan", "Herbert", 
		
		//FEMALE names
		"Abigail", "Ada", "Ahlai", "Angel", "Anna", "Apphia", "Atarah", 
		"Athaliah", "Bathsheba", "Bilhah", "Candace", "Chloe", "Claudia",
		"Damaris", "Deborah", "Delilah", "Diana", "Dinah", "Elizabeth", 
		"Esther", "Eunice", "Eve", "Hagar", "Hannah", "Huldah", "Jedidah", 
		"Jezebel", "Joanna", "Judith", "Julia", "Leah", "Lois", "Lydia", 
		"Martha", "Mary", "Michaiah", "Milcah", "Miriam", "Naarah", "Naomi",
		"Oprah", "Phebe", "Priscilla", "Rachel", "Rebecca", "Ruth", "Salome",
		"Sapphira", "Sarai", "Sherah", "Susanna", "Tabitha", "Tamar", "Tirza",
		"Vashti", "Zilpah",
		
		//random
		"Felicia", "Sharlene", "Michelle", "Esther", "Gladys", "Felecia",
		"Misty", "Francisca", "Imogene", "Arlene", "Essie", "Helena", "Gale",
		"Caroline", "Myra", "Leanna", "Miranda", "Peggy", "Florine", "Rosa",
		"Britney", "Maggie", "Lynette", "Pearlie", "Sonia", "Ila", "Janette", 
		"Dominique", "Freda", "Jenna", "Dolly", "Tamra", "Bertha", "Kathie",
		"Christian", "Aileen", "Estelle", "Brenda", "Sabrina", "Wendi", 
		"Elinor", "Marguerite", "Ruth", "Goldie", "Traci", "Nita", "Jackie", 
		"Naomi", "Alyssa", "Nancy", 
		
		//Dragon ball
		"Goku", "Bulma", "Kami", "Yamcha", "Krillin", "Tien", "Piccolo", 
		"Gohan", "Vegeta", "Kid Trunks", "Goten", "Future Trunks", "Pan", 
		"Android 18", "Android 16", "Android 17", "Android 19", "Android 20", 
		"Beerus", "Chaozu", "Chi-Chi", "Launch", "Mr. Satan", "Oolong", "Puar",
		"Videl", "Whis", "Yajirobe", "Demon King Piccolo", "Freeza", "Cell", 
		"Majin Buu", "Goku Black", "Zamasu", "Baba", "Bra", "Bardock", "Champa",
		"Dende", "Dr. Gero", "Captain Ginyu", "Grandpa Gohan", "Jaco",
		"King Kai", "Supreme Kai", "Elder Kai", "Mr. Popo", "Nappa", "Uub", 
		"Pilaf", "Raditz", "Shenron", "Vados", "Zarbon", "Broly", "Cooler", 
		"King Cold", "Garlic Jr", "King Vegeta", "Nail", "Guru", "Hit", 
		"Super Saiyan Goku", "Super Saiyan 2 Goku", "Super Saiyan 3 Goku", 
		"Super Saiyan Vegeta", "Super Saiyan 2 Vegeta", "Majin Vegeta",
		"Super Saiyan Gohan", "Super Saiyan 2 Gohan", "Super Saiyan Goten",
		"Super Saiyan Trunks", "Vegito", "Gogeta", "Super Saiyan Blue Goku", 
		"Super Saiyan Blue Vegeta", "Mystic Gohan", "Caulifla", "Baby", 
		"Shenlong", "Ryan Shenlong", "Uh Shenlong", "Ryuu Shenlong", 
		"Chi Shenlong", "Su Shenlong", "San Shenlong", "Li Shenlong",
		
		//Artist
		"Donatello", "Botticelli", "Michelangelo", "Raphael", "Titian", "Durer",
		"Caravaggio", "Rubens", "Bernini", "Rembrandt", "Pissarro", "Manet",
		"Degas", "Cezanne", "Monet", "Renoir", "Cassatt", "Gauguin", "Munch", 
		"Klimt", "Matisse", "Picasso", "Kandinsky", "Chagall", "Seurat",
		"Magritte", "Escher", "Rothko", "Dali", "Kahlo", "Pollock", "Warhol", 
		"Vettriano", "Da Vinci", "El Greco", "Winslow Homer", "Paul Klee", 
		"Edward Hopper", "Diego Rivera", "Vincent", "Joan Miro", "Ansel Adams",
		
		//Star wars
		"Padme Amidala", "Jar Jar Binks", "Borvo the Hutt", "Darth Caedus",
		"Boba Fett", "Jabba the Hutt", "Obi-Wan Kenobi", "Darth Maul",
		"Leia Organa", "Sheev Palpatine", "Kylo Ren", "Darth Sidious", 
		"Anakin Skywalker", "Luke Skywalker", "Ben Solo", "Han Solo", 
		"Darth Vader", "Watto", "Mace Windu", "Yoda", "Count Dooku", "Sebulba",
		"Qui-Gon Jinn", "Chewbacca", "Jango Fett", "Lando Calrissian", 
		"Bail Organa", "Wedge Antilles", "Poe Dameron", "Ki-Adi-Mundi", 
		"Nute Gunray", "Panaka", "Rune Haako", "Rey", "Finn",
		"Supreme Leader Snoke", "General Hux", "Admiral Ackbar", "Ahsoka Tano", 
		"Asajj Ventress", "Bendu", "Captain Phasma", "Chirrut Imwe",
		"Ezra Bridger", "Galen Erso", "Grand Moff Tarkin", 
		"Grand Admiral Thrawn", "Greedo", "Jyn Erso", "Lyra Erso",
		"Maz Kanata", "Mon Mothma", "Sabine Wren", "Saw Gerrera", 
		"Savage Opress", "Shmi Skywalker", "Kanan Jarrus", "Hera Syndulla",
		"Rose Tico", "Vice Admiral Holdo"
		
		//Pokemons HAHAHAHA
		/*
		"Bulbasaur", "Chikorita", "Treecko", "Turtwig", "Victini", "Chespin", 
		"Rowlet", "Grookey", "Ivysaur", "Bayleef", "Grovyle", "Grotle", "Snivy",
		"Quilladin", "Dartrix", "Thwackey",	"Venusaur", "Meganium", "Sceptile",
		"Torterra", "Servine", "Chesnaught", "Decidueye", "Rillaboom",
		"Charmander", "Cyndaquil", "Torchic", "Chimchar", "Serperior", 
		"Fennekin", "Litten", "Scorbunny", "Charmeleon", "Quilava", "Combusken",
		"Monferno", "Tepig", "Braixen", "Torracat", "Raboot", "Charizard",
		"Typhlosion", "Blaziken", "Infernape", "Pignite", "Delphox",
		"Incineroar", "Cinderace", "Squirtle", "Totodile", "Mudkip", "Piplup", 
		"Emboar", "Froakie", "Popplio", "Sobble", "Wartortle", "Croconaw", 
		"Marshtomp", "Prinplup", "Oshawott", "Frogadier", "Brionne", "Drizzile",
		"Blastoise", "Feraligatr", "Swampert", "Empoleon", "Dewott", "Greninja",
		"Primarina", "Inteleon", "Caterpie", "Sentret", "Poochyena", "Starly",
		"Samurott", "Bunnelby", "Pikipek", "Skwovet", "Metapod", "Furret", 
		"Mightyena", "Staravia", "Patrat", "Diggersby", "Trumbeak", "Greedent",
		"Butterfree", "Hoothoot", "Zigzagoon", "Staraptor", "Watchog",
		"Fletchling", "Toucannon", "Rookidee", "Weedle", "Noctowl", "Linoone", 
		"Bidoof", "Lillipup", "Fletchinder", "Yungoos", "Corvisquire", "Kakuna",
		"Ledyba", "Wurmple", "Bibarel", "Herdier", "Talonflame", "Gumshoos", 
		"Corviknight", "Beedrill", "Ledian", "Silcoon", "Kricketot", 
		"Stoutland", "Scatterbug", "Grubbin", "Blipbug", "Pidgey", "Spinarak",
		"Beautifly", "Kricketune", "Purrloin", "Spewpa", "Charjabug", "Dottler",
		"Pidgeotto", "Ariados", "Cascoon", "Shinx", "Liepard", "Vivillon",
		"Vikavolt", "Orbeetle",	"Pidgeot", "Crobat", "Dustox", "Luxio", 
		"Pansage", "Litleo", "Crabrawler", "Nickit", "Rattata", "Chinchou", 
		"Lotad", "Luxray", "Simisage", "Pyroar", "Crabominable", "Thievul",
		"Raticate", "Lanturn", "Lombre", "Budew", "Pansear", "Flabébé", 
		"Oricorio", "Gossifleur", "Spearow", "Pichu", "Ludicolo", "Roserade",
		"Simisear", "Floette", "Cutiefly", "Eldegoss", "Fearow", "Cleffa",
		"Seedot", "Cranidos", "Panpour", "Florges", "Ribombee", "Wooloo",
		"Ekans", "Igglybuff", "Nuzleaf", "Rampardos", "Simipour", "Skiddo", 
		"Rockruff", "Dubwool", "Arbok", "Togepi", "Shiftry", "Shieldon", 
		"Munna", "Gogoat", "Lycanroc", "Chewtle", "Pikachu", "Togetic", 
		"Taillow", "Bastiodon", "Musharna", "Pancham", "Wishiwashi", "Drednaw",
		"Raichu", "Natu", "Swellow", "Burmy", "Pidove", "Pangoro", "Mareanie", 
		"Yamper", "Sandshrew", "Xatu", "Wingull", "Wormadam", "Tranquill", 
		"Furfrou", "Toxapex", "Boltund", "Sandslash", "Mareep", "Pelipper", 
		"Mothim", "Unfezant", "Espurr", "Mudbray", "Rolycoly", "Nidoran", 
		"Flaaffy", "Ralts", "Combee", "Blitzle", "Meowstic", "Mudsdale", 
		"Carkol", "Nidorina", "Ampharos", "Kirlia", "Vespiquen", "Zebstrika", 
		"Honedge", "Dewpider", "Coalossal", "Nidoqueen", "Bellossom", 
		"Gardevoir", "Pachirisu", "Roggenrola", "Doublade", "Araquanid", 
		"Applin", "Nidoran", "Marill", "Surskit", "Buizel", "Boldore", 
		"Aegislash", "Fomantis", "Flapple",	"Nidorino", "Azumarill", 
		"Masquerain", "Floatzel", "Gigalith", "Spritzee", "Lurantis", 
		"Appletun", "Nidoking", "Sudowoodo", "Shroomish", "Cherubi", "Woobat", 
		"Aromatisse", "Morelull", "Silicobra", "Clefairy", "Politoed", 
		"Breloom", "Cherrim", "Swoobat", "Swirlix", "Shiinotic", "Sandaconda",
		"Clefable", "Hoppip", "Slakoth", "Shellos", "Drilbur", "Slurpuff", 
		"Salandit", "Cramorant", "Vulpix", "Skiploom", "Vigoroth", "Gastrodon", 
		"Excadrill", "Inkay", "Salazzle", "Arrokuda", "Ninetales", "Jumpluff", 
		"Slaking", "Ambipom", "Audino", "Malamar", "Stufful", "Barraskewda",
		"Jigglypuff", "Aipom", "Nincada", "Drifloon", "Timburr", "Binacle", 
		"Bewear", "Toxel", "Wigglytuff", "Sunkern", "Ninjask", "Drifblim", 
		"Gurdurr", "Barbaracle", "Bounsweet", "Toxtricity",	"Zubat", "Sunflora",
		"Shedinja", "Buneary", "Conkeldurr", "Skrelp", "Steenee", "Sizzlipede",
		"Golbat", "Yanma", "Whismur", "Lopunny", "Tympole", "Dragalge", 
		"Tsareena", "Centiskorch", "Oddish", "Wooper", "Loudred", "Mismagius", 
		"Palpitoad", "Clauncher", "Comfey", "Clobbopus", "Gloom", "Quagsire", 
		"Exploud", "Honchkrow", "Seismitoad", "Clawitzer", "Oranguru", 
		"Grapploct", "Vileplume", "Espeon", "Makuhita", "Glameow", "Throh", 
		"Helioptile", "Passimian", "Sinistea", "Paras", "Umbreon", "Hariyama", 
		"Purugly", "Sawk", "Heliolisk", "Wimpod", "Polteageist", "Parasect", 
		"Murkrow", "Azurill", "Chingling", "Sewaddle", "Tyrunt", "Golisopod", 
		"Hatenna", "Venonat", "Slowking", "Nosepass", "Stunky", "Swadloon", 
		"Tyrantrum", "Sandygast", "Hattrem", "Venomoth", "Misdreavus", "Skitty",
		"Skuntank", "Leavanny", "Amaura", "Palossand", "Hatterene",	"Diglett", 
		"Unown", "Delcatty", "Bronzor", "Venipede", "Aurorus", "Pyukumuku", 
		"Impidimp",	"Dugtrio", "Wobbuffet", "Sableye", "Bronzong", "Whirlipede",
		"Sylveon", "Type", "Null",	"Morgrem", "Meowth", "Girafarig", "Mawile", 
		"Bonsly", "Scolipede", "Hawlucha", "Silvally", "Grimmsnarl", "Persian",
		"Pineco", "Aron", "Mim .", "Cottonee", "Dedenne", "Minior", "Obstagoon",
		"Psyduck", "Forretress", "Lairon", "Happiny", "Whimsicott", "Carbink", 
		"Komala", "Perrserker", "Golduck", "Dunsparce", "Aggron", "Chatot", 
		"Petilil", "Goomy", "Turtonator", "Cursola", "Mankey", "Gligar", 
		"Meditite", "Spiritomb", "Lilligant", "Sliggoo", "Togedemaru", 
		"Sirfetch'd", "Primeape", "Steelix", "Medicham", "Gible", "Basculin", 
		"Goodra", "Mimikyu", "Mr. Rime", "Growlithe", "Snubbull", "Electrike", 
		"Gabite", "Sandile", "Klefki", "Bruxish", "Runerigus", "Arcanine", 
		"Granbull", "Manectric", "Garchomp", "Krokorok", "Phantump", "Drampa", 
		"Milcery", "Poliwag", "Qwilfish", "Plusle", "Munchlax", "Krookodile", 
		"Trevenant", "Dhelmise", "Alcremie", "Poliwhirl", "Scizor", "Minun", 
		"Riolu", "Darumaka", "Pumpkaboo", "Jangmo o", "Falinks", "Poliwrath", 
		"Shuckle", "Volbeat", "Lucario", "Darmanitan", "Gourgeist", "Hakamo o",
		"Pincurchin", "Abra", "Heracross", "Illumise", "Hippopotas", "Maractus",
		"Bergmite", "Kommo o", "Snom", "Kadabra", "Sneasel", "Roselia", 
		"Hippowdon", "Dwebble", "Avalugg", "Tapu", "Frosmoth", "Alakazam", 
		"Teddiursa", "Gulpin", "Skorupi", "Crustle", "Noibat", "Tapu", 
		"Stonjourner", "Machop", "Ursaring", "Swalot", "Drapion", "Scraggy", 
		"Noivern", "Tapu", "Eiscue", "Machoke", "Slugma", "Carvanha", 
		"Croagunk", "Scrafty", "Xerneas", "Tapu", "Indeedee", "Machamp", 
		"Magcargo", "Sharpedo", "Toxicroak", "Sigilyph", "Yveltal", "Cosmog", 
		"Morpeko", "Bellsprout", "Swinub", "Wailmer", "Carnivine", "Yamask", 
		"Zygarde", "Cosmoem", "Cufant",	"Weepinbell", "Piloswine", "Wailord", 
		"Finneon", "Cofagrigus", "Diancie", "Solgaleo", "Copperajah", 
		"Victreebel", "Corsola", "Numel", "Lumineon", "Tirtouga", "Hoopa",
		"Lunala", "Dracozolt", "Tentacool", "Remoraid", "Camerupt", "Mantyke", 
		"Carracosta", "Volcanion", "Nihilego", "Arctozolt", "Tentacruel", 
		"Octillery", "Torkoal", "Snover", "Archen", "Buzzwole", "Dracovish",
		"Delibird", "Spoink", "Abomasnow", "Archeops", "Pheromosa", "Arctovish",
		"Mantine", "Grumpig", "Weavile", "Trubbish", "Xurkitree", "Duraludon", 
		"Skarmory", "Spinda", "Magnezone", "Garbodor", "Celesteela", "Dreepy",
		"Houndour", "Trapinch", "Lickilicky", "Zorua", "Kartana", "Drakloak",
		"Houndoom", "Vibrava", "Rhyperior", "Zoroark", "Guzzlord", "Dragapult", 
		"Kingdra", "Flygon", "Tangrowth", "Minccino", "Necrozma", "Zacian",
		"Slowbro", "Phanpy", "Cacnea", "Electivire", "Cinccino", "Magearna", 
		"Zamazenta", "Magnemite", "Donphan", "Cacturne", "Magmortar", "Gothita",
		"Marshadow", "Eternatus", "Magneton", "Porygon2", "Swablu", "Togekiss", 
		"Gothorita", "Poipole", "Kubfu", "Farfetch", "Stantler", "Altaria", 
		"Yanmega", "Gothitelle", "Naganadel", "Urshifu", "Doduo", "Smeargle", 
		"Zangoose", "Leafeon", "Solosis", "Stakataka", "Calyrex", "Dodrio", 
		"Tyrogue", "Seviper", "Glaceon", "Duosion", "Blacephalon", "Seel", 
		"Hitmontop", "Lunatone", "Gliscor", "Reuniclus", "Zeraora", "Dewgong",
		"Smoochum", "Solrock", "Mamoswine", "Ducklett", "Meltan", "Grimer", 
		"Elekid", "Barboach", "Porygon Z", "Swanna", "Melmetal", "Muk", "Magby",
		"Whiscash", "Gallade", "Vanillite", "Shellder", "Miltank", "Corphish",
		"Probopass", "Vanillish", "Dusknoir", "Vanilluxe", "Froslass",
		"Deerling", "Rotom", "Sawsbuck", "Uxie", "Emolga", "Mesprit",
		"Karrablast", "Azelf", "Escavalier", "Dialga", "Foongus", "Palkia", 
		"Amoonguss", "Milotic", "Heatran", "Frillish , ", "Castform",
		"Regigigas", "Jellicent", "Alomomol",
		*/
	};
	
	private List<String> names;
	
	public CharacterCreator () {
		names = new ArrayList<String>(Arrays.asList(names_collection));
	}
	
	/**
	 * @return the teamCount
	 */
	public int getTeamCount() {
		return teamCount;
	}

	/**
	 * @param teamCount the teamCount to set
	 */
	public void setTeamCount(int teamCount) {
		this.teamCount = teamCount;
	}
	
	public Playable createCharacter (String name, 
			int bending, boolean isAvatar, int team) {
		Random random = new Random();
		Playable playable = new Player();
		Bender bender = null;
		
		if (isAvatar) {
			bender = Avatar.getAvatar();
			((Avatar) bender).setPrimaryBending(
					(Bending) bender.getBending().get(bending));
		} else {
			bender = benderChooser(bending);
		}
		
		bender.setName(name);
		bender.setBendingPoints(random.nextInt(5) + 5);
		bender.setAgility(random.nextInt(bender.getAgility() - 5) + 10);
		playable.setBender(bender);
		playable.setTeam(team);
		
		return playable;
	}
	
	/**
	 * Create a character with a series of handled inputs
	 * @param playable (Player or AI)
	 * @return {@link Playable}
	 */
	public Playable createCharacter (Playable playable) {
		Random random = new Random();
		Bender bender = null;
		String input = "";
		boolean isAvatar = false;
		if (!Avatar.exists()) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Do you want to be the avatar?"
					+ "\n[1] Yes\n[Any other input] No\nInput: ");
			input = scanner.nextLine();
			if (input.equals("1")) {
				bender = Avatar.getAvatar();
				System.out.println("Select your primary bending (Greatly boost "
						+ "this bending)");
				List<Bending> bendings = bender.getBending();
				for (int i = 0; i < bendings.size(); i++) {
					System.out.println(" [" + (i + 1) + "]" + bendings.get(i));
				}
				System.out.print(" Input: ");
				input = scanner.nextLine();
				try {
					int primary = Integer.parseInt(input);
					((Avatar) bender).setPrimaryBending(
							bendings.get(primary - 1));
				} catch (NumberFormatException e) {
					((Avatar) bender).setPrimaryBending(
							bendings.get(random.nextInt(bendings.size())));
				}
				isAvatar = true;
			}
		}
		
		String name = inputName();
		if (!isAvatar) {
			bender = selectBending();
		}
		int team = selectTeam();
		bender.setName(name);
		bender.setBendingPoints(random.nextInt(5) + 5);
		bender.setAgility(random.nextInt(bender.getAgility() - 5) + 10);
		playable.setBender(bender);
		playable.setTeam(team);
		
		return playable;
	}
	
	/**
	 * Automatically generate a character
	 * @param playable
	 * @return {@link Playable}
	 */
	public Playable generateCharacter (Playable playable) {
		generateCharacter(playable, generateTeam());
		
		return playable;
	}
	
	/**
	 * Automatically generate a character
	 * @param playable
	 * @param team
	 * @return {@link Playable}
	 */
	public Playable generateCharacter (Playable playable, int team) {
		Random random = new Random();
		String name = generateName();
		Bender bender = generateBender();
		bender.setName(name);
		bender.setBendingPoints(random.nextInt(5) + 5);
		bender.setAgility(random.nextInt(bender.getAgility() - 5) + 10);
		playable.setBender(bender);
		playable.setTeam(team);
		
		return playable;
	}
	
	/**
	 * Automatically generate a character
	 * @param playable
	 * @param type
	 * @return {@link Playable}
	 */
	public Playable generateCharacter (Playable playable, ElementType type) {
		generateCharacter(playable, type, generateTeam());
		
		return playable;
	}
	
	/**
	 *  Automatically generate a character
	 * @param playable
	 * @param type
	 * @param team
	 * @return {@link Playable}
	 */
	public Playable generateCharacter (Playable playable, ElementType type,
			int team) {
		String name = generateName();
		Bender bender = null;
		switch (type) {
		case WATER:
			bender = benderChooser(0);
			break;
		case EARTH:
			bender = benderChooser(1);
			break;
		case FIRE:
			bender = benderChooser(2);
			break;
		case AIR:
			bender = benderChooser(3);
			break;
		}
		bender.setName(name);
		playable.setBender(bender);
		playable.setTeam(team);
		
		return playable;
	}
	
	private String inputName () {
		Scanner scanner = new Scanner(System.in);
		String name;
		System.out.println("Enter your name (Leave blank for a random name)");
		System.out.print("Input: ");
		name = scanner.nextLine();
		if (name.trim().isEmpty()) {
			name = generateName();
		}
		return name;
	}
	
	private Bender selectBending () {
		Scanner scanner = new Scanner(System.in);
		Bender bender;
		String select;
		System.out.println("Select bending to learn "
				+ "(Invalid input will select a random bending");
		System.out.println("[0] Water bending");
		System.out.println("[1] Earth bending");
		System.out.println("[2] Fire bending");
		System.out.println("[3] Air bending");
		System.out.print("Input: ");
		select = scanner.nextLine();
		try {			
			bender = benderChooser (Integer.parseInt(select));			
		} catch (java.lang.NumberFormatException e) {			
			bender = generateBender ();
		}
		return bender;
	}
	
	public String generateName () {
		int size = names.size();
		int index;
		String name;
		
		if (size == 0) {
			names.addAll(Arrays.asList(names_collection));
			size = names.size();
		}
		index = new Random().nextInt(size);
		name = names.get(index);
		names.remove(index);
		
		return name;
	}
	
	public Bender generateBender () {
		int select = new Random().nextInt(4);
		
		return benderChooser(select);
	}
	
	public Bender benderChooser (int select) {
		Bender bender = null;
		switch (select) {
		case 0:
			bender = new WaterBender();
			break;
		case 1:
			bender = new EarthBender();
			break;
		case 2:
			bender = new FireBender();
			break;
		case 3: 
			bender = new AirBender();
			break;
		default:
			bender = generateBender();
			break;
		}
		return bender;
	}
	
	private int selectTeam () {
		Scanner scanner = new Scanner(System.in);
		String input;
		int team;
		
		System.out.print("Select team from 1 to " + teamCount 
				+ " (Invalid input will randomize team assignation)"
				+ "\nInput: ");
		input = scanner.nextLine();
		
		try {
			team = Integer.parseInt(input);
			if (team < 1 || team > teamCount) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			team = generateTeam();
		}
		
		return team;
	}
	
	public int generateTeam () {
		Random random = new Random();
		int team = random.nextInt(teamCount) + 1;
		return team;
	}

}
