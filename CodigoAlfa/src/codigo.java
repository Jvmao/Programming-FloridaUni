import java.util.Random;

public class codigo {
	public static void main(String[] args) {
		//Variables para Generar el ID de Forma Aleatoria//
		Random aleatorio = new Random();
		String alfa = "ABCDEFGHIJKLMNOPQRSTVWXYZ";
		String cadena = "";//Inicializamos la Variable//
		int numero;
		int forma;
		
		//M�todo para el C�lculo de C�digo//
		forma=(int)(aleatorio.nextDouble() * alfa.length()-1+0);
		//Definimos la cantidad m�xima de n�meros aleatorios (999) y sumamos 100 para mantener 3 n�meros cada vez//
		numero=(int)(aleatorio.nextDouble() * 999+100); 
		cadena=cadena+alfa.charAt(forma)+numero;
		
		System.out.println("T� C�digo es: "+cadena);//Resultado Final//

	}

}
