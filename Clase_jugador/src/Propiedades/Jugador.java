package Propiedades;

public class Jugador {
	//Variables// (Una vez tengamos las variables sacamos los Getters and Setters)
	private String nombre;
	private String apellidos;
	private int edad;
	private int id;
	private int puntos;
	
	
	//Constructor//
	public Jugador() {
		System.out.println("Jugador");
	}

	//Método mediante Getters y Setters, apartir de las variables//
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPuntos() {
		return puntos;
	}


	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	
	
	public String toString(){
		return this.nombre+ " " +this.apellidos+ " " +this.edad+ " " +this.id+ " " +this.puntos;
	}
}
