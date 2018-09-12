import java.util.Random;

public class codigo {
	public static void main(String[] args) {
		//Variables para Generar el ID de Forma Aleatoria//
		Random aleatorio = new Random();
		String alfa = "ABCDEFGHIJKLMNOPQRSTVWXYZ";
		String cadena = "";//Inicializamos la Variable//
		int numero;
		int forma;
		
		//Método para el Cálculo de Código//
		forma=(int)(aleatorio.nextDouble() * alfa.length()-1+0);
		//Definimos la cantidad máxima de números aleatorios (999) y sumamos 100 para mantener 3 números cada vez//
		numero=(int)(aleatorio.nextDouble() * 999+100); 
		cadena=cadena+alfa.charAt(forma)+numero;
		
		System.out.println("Tú Código es: "+cadena);//Resultado Final//

	}

}
