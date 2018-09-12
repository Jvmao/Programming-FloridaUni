
public class inicioDB {

	public static void main(String[] args) {
		confDB c= confDB.getConfigurador("localhost", "bbddmathdice");
		 
		 System.out.println(c.getUrl());
		 
		 System.out.println(c.getBaseDatos());

	}

}
