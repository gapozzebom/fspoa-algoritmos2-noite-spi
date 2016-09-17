
public class Route {
		private String route_id;
		//private Agency agency_id;
		private String route_short_name;
		private String route_long_name;
		// private String route_desc;
		private int route_type;
		//private String route_url;
		//private Color route_color;
		//private Color route_text_color;
		public Route(String route_id,
				     String route_short_name,
				     String route_long_name,
				     int route_type)
		{
			this.route_id = route_id;
			this.route_short_name = route_short_name;
			this.route_long_name = route_long_name;
			this.route_type = route_type;
		}
		@Override
		public String toString() {
			return "Route [route_id=" + route_id +
				   ", route_short_name=" + route_short_name +
				   ", route_long_name=" + route_long_name +
				   ", route_type=" + route_type + "]";
		}
		
}
