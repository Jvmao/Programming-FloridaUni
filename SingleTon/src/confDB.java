
public class confDB {
	private String url;
	 private String baseDatos;
	 private static confDB miconfigurador;
	 
	 public  static confDB getConfigurador(String url,String baseDatos) {
	 
	 if (miconfigurador==null) {
	 
	 miconfigurador=new confDB(url,baseDatos);
	 }
	 return miconfigurador;
	 }
	 
	 private confDB(String url,String baseDatos){
	 
	 this.url=url;
	 this.baseDatos=baseDatos;
	 
	 }
	 
	public String getUrl() {
	 return url;
	 }
	 
	public void setUrl(String url) {
	 this.url = url;
	 }
	 
	public String getBaseDatos() {
	 return baseDatos;
	 }
	 
	public void setBaseDatos(String baseDatos) {
	 this.baseDatos = baseDatos;
	 }
	
}

