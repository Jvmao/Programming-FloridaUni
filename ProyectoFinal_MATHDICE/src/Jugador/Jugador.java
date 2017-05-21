package Jugador;

import com.mysql.jdbc.Connection;

import Modelo.JugadorDB;

public class Jugador {
			//Atributos Jugador// 
			private int id;
			private String nombre;
			private String apellido1;
			private String apellido2;
			private int edad;
			private String genero;
			private String email;
			private String code;
			private int puntos;
			
			//Inicializamos el Jugador para la BBDD//
			private JugadorDB jdb;
		
			//Método Jugador//
			public Jugador() {
			}
			
			
			//Generación de Getters and Setters//
			public int getId(){
				return id;
			}
			public void setId(int id){
				this.id=id;
			}
			public String getNombre() {
				return nombre;
			}

			public void setNombre(String nombre) {
				this.nombre = nombre;
			}

			public String getApellido1() {
				return apellido1;
			}

			public void setApellido1(String apellido1) {
				this.apellido1 = apellido1;
			}

			public String getApellido2() {
				return apellido2;
			}

			public void setApellido2(String apellido2) {
				this.apellido2 = apellido2;
			}

			public int getEdad() {
				return edad;
			}

			public void setEdad(int edad) {
				this.edad = edad;
			}
			
			public String getGenero() {
				return genero;
			}
			public void setGenero(String genero) {
				this.genero = genero;
			}
			
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}

			public String getCode() {
				return code;
			}
			public void setCode(String code) {
				this.code = code;
			}

			public int getPuntos() {
				return puntos;
			}

			public void setPuntos(int puntos) {
				this.puntos = puntos;
			}

			//Datos Jugador//
			public String toString(){
					return "ID: "+this.getId()+" \nNombre: " +this.nombre+ " \nApellido1: " +this.apellido1+
							" \nApellido2:  " +this.apellido2+ " \nEdad: " +this.edad+ " años " 
							+" \nE-Mail: "+this.email+" \nGénero: "+this.genero+ " \nCódigo: "+this.code
							+ " \nPuntos Jugador: "+this.puntos;
			}
			
		
	}
