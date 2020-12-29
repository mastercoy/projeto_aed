package sample;

import java.util.ArrayList;
import java.util.Collections;


public class ListaArvore {

		private Node start;
		private Node fim;
		private ArrayList<Integer> lista = new ArrayList<Integer>(31);

		public ListaArvore() {
				start = null;
				fim = null;
		}

		public boolean isEmpty() {
				return start == null && fim == null;
		}

		public Node getStart() {
				return start;
		}

		public void setStart(Node start) {
				this.start = start;
		}

		public Node getFim() {
				return fim;
		}

		public void setFim(Node fim) {
				this.fim = fim;
		}

		public int numeroNoLista() { //Conta quantos nós existe na lista.
				int no = 1;
				Node temp = start;
				while (temp != fim) {
						temp = temp.getNext();
						no++;
				}
				return no;
		}

		public void OrdenarinsertOnSort() {
				int n = lista.size();
				for (int i = 1, j; i < n; i++) {
						int t = lista.get(i);
						for (j = i; (j > 0) && (t < lista.get(j - 1)); j--) {
								lista.set(j, lista.get(j - 1));
						}
						lista.set(j, t);
				}
				Collections.reverse(lista);
		}

		// Este método irá "partir ao meio" uma lista ordenada recursivamente, de forma que esta se transforme em uma árvore.
		public Node listaParaArvore(Node x, Arvore arvore) {

				if ((isEmpty())) {
						System.out.println("A lista está vazia!");
				} else if (numeroNoLista() == 1) {
						arvore.inserir(arvore.getRaiz(), start.getInfo());
				} else if (numeroNoLista() == 2) {

						ListaArvore lista1 = new ListaArvore();
						lista1.setStart(start.getNext());
						lista1.setFim(fim);
						arvore.inserir(arvore.getRaiz(), start.getInfo());
						lista1.listaParaArvore(lista1.getStart(), arvore);
				} else if (numeroNoLista() % 2 == 0) {
						int cont = 1;
						Node temp = start;
						while (numeroNoLista() / 2 != cont) {
								temp = temp.getNext();
								cont++;
						}
						ListaArvore lista1 = new ListaArvore();
						ListaArvore lista2 = new ListaArvore();
						lista1.setStart(start);
						lista1.setFim(temp.getDad());
						lista2.setStart(temp.getNext());
						lista2.setFim(fim);
						arvore.inserir(arvore.getRaiz(), temp.getInfo());
						lista1.listaParaArvore(lista1.getStart(), arvore);
						lista2.listaParaArvore(lista2.getStart(), arvore);

				} else {
						int cont = 1;
						Node temp = start;
						while ((numeroNoLista() + 1) / 2 != cont) {
								temp = temp.getNext();
								cont++;
						}
						int q = temp.getInfo();
						ListaArvore lista1 = new ListaArvore();
						ListaArvore lista2 = new ListaArvore();
						lista1.setStart(start);
						lista1.setFim(temp.getDad());
						lista2.setStart(temp.getNext());
						lista2.setFim(fim);
						arvore.inserir(arvore.getRaiz(), q);
						lista1.listaParaArvore(lista1.getStart(), arvore);
						lista2.listaParaArvore(lista2.getStart(), arvore);
				}
				return arvore.getRaiz();
		}

		public Node incluirElemento(int elem) { // Adiciona elementos na árvore.

				Node novo = new Node(elem);

				// O nó adicionado será tanto o início(start) como o fim, caso a árvore esteja vazia.
				if ((isEmpty()) || (elem < start.getInfo())) {
						if (isEmpty()) {
								fim = novo;
						}
						novo.setNext(start);
						//caso o programa tente acessar um objeto da memória que não foi instanciado (null point).
						if (start != null) {
								start.setDad(novo);
						}
						start = novo;
				} else {

						Node temp = start;
						while ((temp.getNext() != null) && (elem > temp.getNext().getInfo())) {
								temp = temp.getNext();
						}
						novo.setNext(temp.getNext());
						if (temp.getNext() != null) {
								temp.getNext().setDad(novo);
						} else {
								fim = novo; //
						}
						temp.setNext(novo);
						novo.setDad(temp);
				}
				return start;
		}

		public void imprime() {
				Node temp = start;
				while (temp != null) {
						System.out.println(temp + "-");
						temp = temp.getNext();
				}
		}

}
