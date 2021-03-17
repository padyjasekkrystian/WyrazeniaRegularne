package wyrazenia;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;

public class Main {

	public static void main(String[] args) {
		
		//kompilujemy wyrazenie regularne Tomek uzyskujac instancje klasy Pattern
		Pattern pattern = Pattern.compile("Tomek");
		
		//wywolujemy metode matcher otrzymujac instancje klasy Matcher, parametr to lancuch znakow na ktorym uzywamy wyrazenia regularnego
		Matcher matcher = pattern.matcher("Tomek lubi grac w pilke");
		
		//find() zwraca true jesli w ³ancuchu znakow znajduje sie cos co pasuje do regexa
		System.out.println(matcher.find());
		
		//matches() zwraca true jesli lancuch w calosc pasuje do regexa
		System.out.println(matcher.matches());
		System.out.println();
		
		// znak ? - oznacza ze element znajdujacy sie bezposrednio przed nim jest opcjonalny
		Pattern pattern1 = Pattern.compile("Tom?ek");
		System.out.println(pattern1.matcher("Tomek").matches());
		System.out.println(pattern1.matcher("Toek").matches());
		System.out.println(pattern1.matcher("Tofek").matches());
		System.out.println(pattern1.matcher("To ek").matches());
		System.out.println();
		
		// znak * - ozancza ze element znadjujacy sie bezposrednio przed nim moze byc powtorzony 0 lub wiecej razy
		Pattern pattern2 = Pattern.compile("Tom*ek");
		System.out.println(pattern2.matcher("Tomek").matches());
		System.out.println(pattern2.matcher("Toek").matches());
		System.out.println(pattern2.matcher("Tommmmek").matches());
		System.out.println(pattern2.matcher("Tofek").matches());
		System.out.println();
		
		// znak + ozancza ze element znadjujacy sie bezposrednio przed nim moze byc powtorzony 1 lub wiecej razy
		
		Pattern pattern3 = Pattern.compile("Tom+ek");
		System.out.println(pattern3.matcher("Tomek").matches());
		System.out.println(pattern3.matcher("Toek").matches());
		System.out.println(pattern3.matcher("Tommmmek").matches());
		System.out.println(pattern3.matcher("Tofek").matches());
		System.out.println();
		
		// znak . oznacza dowolny symbol (poza znakiem nowej linii)
		
		Pattern pattern4 = Pattern.compile("To.ek");
		System.out.println(pattern4.matcher("Tomek").matches());
		System.out.println(pattern4.matcher("Toek").matches());
		System.out.println(pattern4.matcher("Tommmek").matches());
		System.out.println(pattern4.matcher("Tofek").matches());
		System.out.println();
		
		// {x} oznacaz ze element bezposrednio przed symbolem jest powtorzony dokaldnie x razy
		
		Pattern pattern5 = Pattern.compile("Tom{3}ek");
		System.out.println(pattern5.matcher("Tommmek").matches());
		System.out.println();
		
		// {x,} oznacaz ze element bezposrednio przed symbolem jest powtorzony conajmniej x razy

		// {x,y} oznacaz ze element bezposrednio przed symbolem jest powtorzony od x do y razy
		
		Pattern pattern6 = Pattern.compile("k+a.*ta");
		System.out.println(pattern6.matcher("kkkattta").matches());
		System.out.println(pattern6.matcher("kata").matches());
		System.out.println(pattern6.matcher("kkkkkkkabcdeeta").matches());
		System.out.println(pattern6.matcher("kkarta").matches());
		
		System.out.println(pattern6.matcher("arta").matches());
		System.out.println(pattern6.matcher("kwita").matches());
		System.out.println(pattern6.matcher("kkkarty").matches());
		System.out.println(pattern6.matcher("kkara").matches());
		System.out.println();
		
		System.out.println(pattern6.matcher("kkkatapulta").matches()); //true
		System.out.println(pattern6.matcher("kkkaaaatzafpulta").matches()); //true
		System.out.println(pattern6.matcher("karta").matches());  //true
		System.out.println(pattern6.matcher("kasia ma kota").matches()); //true
		System.out.println(pattern6.matcher("kkkka#$*&JHDFSta").matches()); //true	
		System.out.println(pattern6.matcher("ata").matches()); //false
		System.out.println(pattern6.matcher("kta").matches()); //false
		System.out.println();
		
		//klasy to grupy symboli opisywane za pomoca [ ]
		
		Pattern pattern7 = Pattern.compile("[a-d]uma");
		System.out.println(pattern7.matcher("duma").matches());
		System.out.println(pattern7.matcher("cuma").matches());
		System.out.println(pattern7.matcher("guma").matches());
		System.out.println();
		
		Pattern pattern8 = Pattern.compile("[A-z]uma");
		System.out.println(pattern8.matcher("Guma").matches());
		System.out.println(pattern8.matcher("Euma").matches());
		System.out.println(pattern8.matcher("muma").matches());
		System.out.println();
		
		Pattern pattern9 = Pattern.compile("[0-5]abc");
		System.out.println(pattern9.matcher("0abc").matches());
		System.out.println(pattern9.matcher("3abc").matches());
		System.out.println(pattern9.matcher("6abc").matches());
		System.out.println();
		
		Pattern pattern10 = Pattern.compile("[D-Ga-c0-4]abc");
		System.out.println(pattern10.matcher("0abc").matches());
		System.out.println(pattern10.matcher("Dabc").matches());
		System.out.println(pattern10.matcher("babc").matches());
		System.out.println();
		
		//^ zaprzeczenie
		Pattern pattern11 = Pattern.compile("[^abc]abc");
		System.out.println(pattern11.matcher("0abc").matches());
		System.out.println(pattern11.matcher("Dabc").matches());
		System.out.println(pattern11.matcher("babc").matches());
		System.out.println();
		
		// stwórz pattern na imie (uwzglednij ze ktos moze miec dwa imiona)
		
		Pattern pattern12 = Pattern.compile("[A-Z][a-z]{2,}( [A-Z][a-z]{2,})?");
		System.out.println(pattern12.matcher("Krystian Tomek").matches());
		System.out.println(pattern12.matcher("Krystian").matches());
		System.out.println(pattern12.matcher("Ab").matches());
		System.out.println(pattern12.matcher("bartek").matches());
		
		System.out.println();
		
		// stwórz pattern na imie i nazwisko
		// Jan Kowalski, Jan Bartek Kowalski, Jan Bartek Kowalski Jankowski, Janusz Korwin-Mikke
		
		Pattern pattern13 = Pattern.compile("[A-Z][a-z]{2,}( [A-Z][a-z]{2,}){0,2} [A-Z][a-z]{2,}(-[A-Z][a-z]{2,})?");
		System.out.println(pattern13.matcher("Janusz Korwin-Mikke").matches());
		System.out.println(pattern13.matcher("Janusz Mariusz Korwin-Mikke").matches());
		System.out.println(pattern13.matcher("Jan Kowalski").matches());
		System.out.println(pattern13.matcher("Jan Bartek Kowalski").matches());
		System.out.println(pattern13.matcher("Jan Bartek Kowalski Jankowski").matches());
		System.out.println();

		/*
		 * Klasy predefiniowane
		 * \d - jakakolwiek cyfra [0-9]
		 * \D - jakikowliek znak, który nie jest cyfra [^0-9]
		 * \w - znak u¿ywany w s³owach [a-zA-Z0-9_]
		 * \W - zaprzeczenie grupy \w
		 * \s - whitespacy czyli znaki ktorych nie widac na wydruku np \t \n \r
		 * \S - zaprzecznie tej grupy
		 */

		//napisz pattern na datê w postaci xx-xx-xxxx		
		Pattern pattern14 = Pattern.compile("\\d{2}-\\d{2}-\\d{4}");
		System.out.println(pattern14.matcher("31-07-1997").matches());
		System.out.println();
		
		//napisz pattern na maila
		
		Pattern pattern15 = Pattern.compile("\\w+(.?-?\\w+?)+@[a-z]{2,}.[a-z]{2,3}");
		System.out.println(pattern15.matcher("padyjasekkrystian@gmail.com").matches());
		System.out.println(pattern15.matcher("padyjasek_krystian12@gmail.com").matches());
		System.out.println(pattern15.matcher("padyjasek.krystian@gmail.com").matches());
		System.out.println(pattern15.matcher("padyjasek-kryst-ia-n12@gmail.com").matches());
		System.out.println();
		
		  /*
	     * Sprawdz czy liczba zmiennoprzecinkowa podana przez u¿ytkownika ma poprawny format. Na przyk³ad liczba 123,2341515132135 czy 
	     * -10 s¹ poprawne ale 18-12 czy 123, ju¿ nie,
	     */
		
		Pattern pattern16 = Pattern.compile("-?\\d+(,\\d+)?");
		System.out.println(pattern16.matcher("12,53141").matches());
		System.out.println(pattern16.matcher("-12,53141").matches());
		System.out.println(pattern16.matcher("123,").matches());
		System.out.println(pattern16.matcher("18-12").matches());
		System.out.println(pattern16.matcher("12").matches());
		System.out.println();


		/*
		 * sprawdz czy numer domu jest w formacie numer\numer. 
		 * Poprawnym numerem jest 123\2A, 24B\3 czy 12\5, ale ju¿ numer abc\cba nie,
		 */
		
		Pattern pattern17 = Pattern.compile("\\d+[A-Z]?\\\\\\d+[A-Z]?");
		System.out.println(pattern17.matcher("123\\2A").matches());
		System.out.println(pattern17.matcher("24B\\3").matches());
		System.out.println(pattern17.matcher("12\\5").matches());
		System.out.println(pattern17.matcher("abc\\cba").matches());
		System.out.println();

		/*
		 * sprawdz czy u¿ytkownik wprowadzi³ poprawn¹ nazwê miasta. Na przyk³ad Wroc³aw, Zielona Gora czy Bielsko-Biala jest ok, 
		 * jednak Ptysiow123 ju¿ nie. Dla uproszczenia za³ó¿my, ¿e ¿adna nazwa miejscowoœci nie zwiera polskich znaków.
		 */
		
		Pattern pattern18 = Pattern.compile("[A-Z][a-z]+(( |-)[A-Z][a-z]+)?");
		System.out.println(pattern18.matcher("Wroclaw").matches());
		System.out.println(pattern18.matcher("Zielona Gora").matches());
		System.out.println(pattern18.matcher("Bielsko-Biala").matches());
		System.out.println(pattern18.matcher("ZielonaGora").matches());
		System.out.println();
		
		//alternatywa czyli | 
		
		Pattern pattern19 = Pattern.compile("Skrec w (lewo|prawo)");
		System.out.println(pattern19.matcher("Skrec w lewo").matches());
		System.out.println(pattern19.matcher("Skrec w prawo").matches());
		System.out.println(pattern19.matcher("Skrec w  lewo").matches());
		System.out.println(pattern19.matcher("Skrec w prosto").matches());
		System.out.println();

		//alternatywe mozemy wykorzystywac do wiecej niz jednej warotsci
		
		Pattern pattern20 = Pattern.compile("pies|kot|ryba");
		System.out.println(pattern20.matcher("pies").matches());
		System.out.println(pattern20.matcher("kot").matches());
		System.out.println(pattern20.matcher("ryba").matches());
		System.out.println(pattern20.matcher("lew").matches());
		System.out.println();
		
		//grupy oznaczamy ( ) po to zeby moc do nich potem sie dostac
		//regexy sa zach³anne, oznacza to ze z defaultu regex dopasouje najwieksza mozlwia czesc ³ancucha znakow
		
		Pattern pattern21 = Pattern.compile("<(.+)>");
		Matcher matcher21 = pattern21.matcher("<html> bla bla bla bla </html>");
		matcher21.find();
		System.out.println(matcher21.group(1));
		
		//zachlannosc mozemy wylaczyc za pomoca znaku ? 		
		Pattern pattern22 = Pattern.compile("<(.+?)>");
		Matcher matcher22 = pattern22.matcher("<html> bla bla bla bla </html>");
		matcher22.find();
		System.out.println(matcher22.group(1));

		//Korzystajac z grup stworz regexa ktory zaakceptuje Ala ma kota, Ala ma psa, Ola ma kota, Ola ma psa
		//Uzyj grup
		
		Pattern pattern23 = Pattern.compile("(Ala|Ola) ma (psa|kota)");
		Matcher matcher23 = pattern23.matcher("Ola ma psa");
		matcher23.find();
		System.out.println(matcher23.groupCount());
		System.out.println(matcher23.group(1));
		System.out.println(matcher23.group(2));
		System.out.println();
		
		//napisz wzor na date uzywjaac grup
		//grupy mozemy nazywac
		
		Pattern pattern24 = Pattern.compile("(?<day>\\d{2}).(?<month>\\d{2}).(?<year>\\d{4})");
		Matcher matcher24 = pattern24.matcher("24.05.2005");
		matcher24.find();
		System.out.println(matcher24.groupCount());
		System.out.println(matcher24.group(1));
		System.out.println(matcher24.group(2));
		System.out.println(matcher24.group(3));
		
		System.out.println();
		System.out.println(matcher24.group("day"));
		System.out.println(matcher24.group("month"));
		System.out.println(matcher24.group("year"));
		System.out.println();
		
		//kotwice
		//^ onzacza poczatek lancucha znakow
		//$ oznacza koniec ³ancucha znakow
		
		Pattern pattern25 = Pattern.compile("^\\d+");
		Matcher matcher25 = pattern25.matcher("2a111");
		System.out.println(matcher25.find());
		System.out.println();
		
		Pattern pattern26 = Pattern.compile("\\d+$");
		Matcher matcher26 = pattern26.matcher("2a2");
		System.out.println(matcher26.find());
		
		System.out.println(kantor(100, "PLN"));
		

		
 
	}

	//napisz metode zamien(int ilosc, String waluta) ktora dzia³a jak kantor, zamienia ilosc danej waluty na euro
	//czyli np zamien(100, "PLN") powinno wypluc 439,79
	
	public static double kantor(double ilosc, String waluta) {
		double wynik = 0;;
		String kursy = "{\"rates\":{\"CAD\":1.5563,\"HKD\":9.1212,\"ISK\":162.6,\"PHP\":57.324,\"DKK\":7.4441,\"HUF\":350.68,\"CZK\":26.083,\"AUD\":1.6442,"
				+ "\"RON\":4.8405,\"SEK\":10.363,\"IDR\":17383.99,\"INR\":88.198,\"BRL\":6.5908,\"RUB\":87.735,\"HRK\":7.5243,\"JPY\":124.53,\"THB\":37.161,"
				+ "\"CHF\":1.0744,\"SGD\":1.6131,\"PLN\":4.3979,\"BGN\":1.9558,\"TRY\":8.5925,\"CNY\":8.1483,\"NOK\":10.5913,\"NZD\":1.8045,\"ZAR\":20.2977,"
				+ "\"USD\":1.1769,\"MXN\":26.066,\"ILS\":4.0029,\"GBP\":0.89755,\"KRW\":1403.15,\"MYR\":4.9194},\"base\":\"EUR\",\"date\":\"2020-08-21\"}";
		
		Map<String, Double> mapa = new HashMap<>();
		
		String[] tablica = kursy.substring(kursy.indexOf("CAD") - 1, kursy.indexOf("base") - 3).split(","); //wyciinamy od do i splitujemy wzgledem n
		Pattern pattern = Pattern.compile("\"([A-Z]{3})\":(\\d+.\\d+)");
		for(String element: tablica) {
			Matcher matcher = pattern.matcher(element);
			matcher.find();
			mapa.put(matcher.group(1), Double.parseDouble(matcher.group(2)));
		}
		
		if (mapa.containsKey(waluta)) {
			wynik = (ilosc * mapa.get(waluta) * 100) / 100.0;
		} else {
			throw new IllegalArgumentException("nie ma takiej waluty!");
		}

		return wynik;
	}
}
