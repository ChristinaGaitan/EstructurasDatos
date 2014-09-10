import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Grafo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//PENDIENTE: Despues de eliminar un elemento del arbol balacearlo
		Scanner sc = new Scanner (System.in);

		//Numero de nodos
		int nodos= Integer.parseInt(sc.nextLine());
		//Numero de conexiones
		int aristas= Integer.parseInt(sc.nextLine());
		
		ArrayList<Integer> arreglo[] = new ArrayList[nodos+1];
		
		
		//Inicializar el arreglo
		for (int i = 0; i<=nodos; ++i)
		{
			arreglo[i] = new ArrayList<Integer>();
		}
		
		//Se leen las relaciones
		//Se llena la lista de adyacencia
		String line;
		for (int i=0; i<aristas; ++i)
		{
			line = sc.nextLine();
			int x = new Integer (line.split(" ")[0]);
			int y = new Integer (line.split(" ")[1]);
			
			//x tiene a y como conexion
			arreglo[x].add(y);
			//Como es un grafo no dirigido tambien y tiene como conexiones a x
			arreglo[y].add(x);
		}
		
		//Recorrer el grafo
		//ANCHURA
		//Se necesita una cola (primero en entrar, primero en salir)
		Queue<Integer> cola = new LinkedList<Integer>();
		
		//Con este arreglo verificaremos si ya visitamos un nodo o no
		boolean visitados[] = new boolean[nodos+1];
		cola.offer(1);
		
		while(!cola.isEmpty())
		{
			//Quita el elemento al principio de la cola
			int temp = cola.remove();
			
			//Lo marcamos como visitado
			visitados[temp] = true;
			System.out.print(temp+" ");
			
			//Agarramos a los "hijos" del elemento visitado
			for (int i=0;i<arreglo[temp].size();++i)
			{
				int nodo = arreglo[temp].get(i);
				
				//Si ya esta visitado => NO agregarlo a la cola
				if(!visitados[nodo])
				{
					cola.offer(nodo);
				}
			}
		}
		System.out.println();
		
		sc.close();
	}

}
