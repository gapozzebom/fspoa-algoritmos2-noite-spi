import java.util.Scanner;

public class RouteParser implements Parser<Route> {
	@Override
	public Route parse(String dados) {
		Scanner arquivo = new Scanner(dados);
		arquivo.useDelimiter(",");
		
		String id = arquivo.next();
		arquivo.next(); // agency_id
		String shortName = arquivo.next();
		String longName = arquivo.next();
		arquivo.next(); // route_desc
		int type = arquivo.nextInt();
		arquivo.next(); // route_url
		arquivo.next(); // route_color
		arquivo.next(); // route_text_color

		arquivo.close();
		return new Route(id, shortName, longName, type);
	}
}
