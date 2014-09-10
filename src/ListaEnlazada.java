import java.util.*;

public class ListaEnlazada {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//PENDIENTE: Al insertar ordenar de menor a mayor
		
		Scanner sc = new Scanner (System.in);
		
		NodoLista primero = null;
		NodoLista ultimo = null;
		
		String linea;
		while ((linea = sc.nextLine())!=null)
		{
			char c = linea.charAt(0);
			if ( c== 'a') //agregar elementos a la lista
			{
				int n= Integer.parseInt( linea.split(" ")[1]);
				NodoLista nuevo = new NodoLista (n);
				nuevo.sig = null;
				
				//Lista vacía
				if (primero == null && ultimo == null)
				{
					primero = nuevo;
					ultimo = nuevo;
				}
				else
				{
					ultimo.sig = nuevo;
					ultimo = nuevo;
				}
			}
			else if (c == 'p') //imprimir elementos de la lista
			{
				//Recorrer todos los elementos de la lista
				NodoLista temp = primero;
				
				while(temp != null)
				{
					System.out.print(temp.num + " ") ;
					temp = temp.sig;
				}
				System.out.println();
			}
		}
		sc.close();
	}

}

class NodoLista
{
	int num;
	NodoLista sig;
	
	public NodoLista (int n)
	{
		num = n;
	}
	
}