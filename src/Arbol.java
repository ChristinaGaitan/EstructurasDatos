import java.util.Scanner;


public class Arbol {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//PENDIENTE: Buscar elemento y decir si se encuentra en el árbol o no
		//			eliminar un elemento y balancear el árbol
		
		Scanner sc = new Scanner (System.in);
		
		NodoArbol raiz = null;
		
		String linea;
		while ((linea = sc.nextLine())!=null)
		{
			char c = linea.charAt(0);
			
			if ( c== 'a') //agregar elementos al árbol
			{
				int n= Integer.parseInt( linea.split(" ")[1]);
				
				//Árbol vacío
				if (raiz == null)
				{
					raiz = new NodoArbol (n);
				}
				else
				{
					raiz.inserta(n);
				}
			}
			else if (c == 'p') //imprimir elementos del árbol
			{
				//Recorrer todos los elementos del árbol
				
				//PREORDEN: Nodo actual se imprimer primero,
				//			después hijo izquierdo y
				//			después hijo derecho
				
				//POSTORDEN: Hijo izquierdo,
				//			después hijo derecho y
				//			después nodo actual
				
				//INORDEN: Hijo izquierdo,
				//			después nodo actual y
				//			después hijo derecho

				/*
				 * En general, la diferencia entre preorden, inorden y postorden es cuándo se recorre la raíz. En los tres, se recorre primero el sub-árbol izquierdo y luego el derecho.
					En preorden, la raíz se recorre antes que los recorridos de los subárboles izquierdo y derecho
					En inorden, la raíz se recorre entre los recorridos de los árboles izquierdo y derecho, y
					En postorden, la raíz se recorre después de los recorridos por el subárbol izquierdo y el derecho
				 * */
				
				inorden(raiz);
				//preorden(raiz);
				//postorden(raiz);
				System.out.println();
			}
		}
		sc.close();
	}
	
	static void inorden (NodoArbol raiz)
	{
		//Imprimer en orden ascendente
		if (raiz == null)
		{
			return;
		}
		else
		{
			inorden(raiz.izq);
			System.out.print(raiz.num + " ");
			inorden(raiz.der);
		}
		
	}
	
	static void preorden (NodoArbol raiz)
	{
		//Imprimer  raíz, izquierdo, derecho
		if (raiz == null)
		{
			return;
		}
		else
		{
			System.out.print(raiz.num + " ");
			inorden(raiz.izq); //recorre subarbol izquierdo
			inorden(raiz.der); //recorre subarbol derecho
		}
		
	}
	
	static void postorden (NodoArbol raiz)
	{
		//Imprimer  izquierdo, derecho, raíz
		if (raiz == null)
		{
			return;
		}
		else
		{
			inorden(raiz.izq); //recorre subarbol izquierdo
			inorden(raiz.der); //recorre subarbol derecho
			System.out.print(raiz.num + " ");
		}
		
	}

}

class NodoArbol
{
	int num;
	NodoArbol izq;
	NodoArbol der;
	
	public NodoArbol (int n)
	{
		num = n;
	}
	
	void inserta(int n)
	{
		if (n<num)
		{
			if (izq == null)
				izq = new NodoArbol(n);
			else
				izq.inserta(n);
		}
		else if (n>num)
		{
			if(der == null)
				der = new NodoArbol(n);
			else
				der.inserta(n);
		}
	}
	
}