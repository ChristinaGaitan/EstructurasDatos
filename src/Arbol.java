import java.util.Scanner;


public class Arbol {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//PENDIENTE: Buscar elemento y decir si se encuentra en el �rbol o no
		//			eliminar un elemento y balancear el �rbol
		
		Scanner sc = new Scanner (System.in);
		
		NodoArbol raiz = null;
		
		String linea;
		while ((linea = sc.nextLine())!=null)
		{
			char c = linea.charAt(0);
			
			if ( c== 'a') //agregar elementos al �rbol
			{
				int n= Integer.parseInt( linea.split(" ")[1]);
				
				//�rbol vac�o
				if (raiz == null)
				{
					raiz = new NodoArbol (n);
				}
				else
				{
					raiz.inserta(n);
				}
			}
			else if (c == 'p') //imprimir elementos del �rbol
			{
				//Recorrer todos los elementos del �rbol
				
				//PREORDEN: Nodo actual se imprimer primero,
				//			despu�s hijo izquierdo y
				//			despu�s hijo derecho
				
				//POSTORDEN: Hijo izquierdo,
				//			despu�s hijo derecho y
				//			despu�s nodo actual
				
				//INORDEN: Hijo izquierdo,
				//			despu�s nodo actual y
				//			despu�s hijo derecho

				/*
				 * En general, la diferencia entre preorden, inorden y postorden es cu�ndo se recorre la ra�z. En los tres, se recorre primero el sub-�rbol izquierdo y luego el derecho.
					En preorden, la ra�z se recorre antes que los recorridos de los sub�rboles izquierdo y derecho
					En inorden, la ra�z se recorre entre los recorridos de los �rboles izquierdo y derecho, y
					En postorden, la ra�z se recorre despu�s de los recorridos por el sub�rbol izquierdo y el derecho
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
		//Imprimer  ra�z, izquierdo, derecho
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
		//Imprimer  izquierdo, derecho, ra�z
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