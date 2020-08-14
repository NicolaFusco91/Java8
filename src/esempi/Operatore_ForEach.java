package esempi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/*
 * 
 * In questa classe vengono mostrate le diverse forme per iterare una collection
 * 1 Con iterator classico
 * 2 forEach con lambda
 * 3 forEach con classe implementata (utile nel caso bisogna replicare la funzione
 * 4 forEach con classe anonima
 */

public class Operatore_ForEach {
	
public static void main(String[] args) {
		
		//Creiamo una semplice lista di interi
		List<Integer> myList = new ArrayList<Integer>();
		//Inseriamo i numeri da 0 a 9
		for(int i=0; i<10; i++) myList.add(i);
		
		//Oltre al classico ciclo for, possiamo utilizzare l'Iterator
		Iterator<Integer> it = myList.iterator();
		while(it.hasNext()){
			Integer i = it.next();
			System.out.println("Iterator::"+i);
		}
		
		////Utilizzando il metodo forEach attraverso l'operatore lambda
		myList.forEach(numero -> System.out.println("forEach con lambda::"+numero));
		
		//Utilizzando il metodo forEach ed implementanto la functional Interface
		OperatorePerInteri action = new OperatorePerInteri();
		myList.forEach(action);
		
		//Utilizzando il metodo forEach di Iterable con l'utilizzo 
		//di una classe anonima Consumer.
		myList.forEach(new Consumer<Integer>() {
			public void accept(Integer t) {
				System.out.println("forEach classe anonima::"+t);
			}
		});
		

	}

}

//Classe che implementa la functional Interface Consumer in modo da poter 
// essere riutilizzata
class OperatorePerInteri implements Consumer<Integer>{

	public void accept(Integer t) {
		System.out.println("OperatorePerInteri::"+t);
	}


}
