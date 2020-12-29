package sample;

import javax.swing.*;


public class Arvore {

		int contHeap = 0;
		private Node raiz;

		public Arvore() {
				this.raiz = null;
		}

		public Node getRaiz() {
				return raiz;
		}

		public void setRaiz(Node raiz) {
				this.raiz = raiz;
		}

		public boolean isEmpty() {
				return raiz == null;
		}

		public int numeroNoArvore(Node y) { //Informa o número de nós existentes na árvore.

				int i = 0;
				if (isEmpty()) {
						return i;
				} else if (y.getRight() == null && y.getLeft() != null) {
						i = numeroNoArvore(y.getLeft()) + 1;
				} else if (y.getLeft() == null && y.getRight() != null) {
						i = numeroNoArvore(y.getRight()) + 1;
				} else if (y.getLeft() != null && y.getRight() != null) {
						i = numeroNoArvore(y.getRight()) + numeroNoArvore(y.getLeft()) + 1;
				} else {
						return 1;
				}
				return i;
		}

		public Node inserir(Node x, int elemento) { //Insere elementos na árvore

				if (isEmpty()) {
						raiz = new Node(elemento);
				} else {
						//O número de nós foi pre estabelecido. Se o número de nós atingir o limite, a árvore estará cheia.
						if (numeroNoArvore(raiz) == 31) {
								JOptionPane.showMessageDialog(null, "A árvore está cheia");
								return x;
						}
						if (elemento < x.getInfo()) {
								if (x.getLeft() == null) {
										Node novo = new Node(elemento);
										x.setLeft(novo);
										novo.setDad(x);
								} else {
										inserir(x.getLeft(), elemento);
								}
						} else if (elemento == x.getInfo()) {
								JOptionPane.showMessageDialog(null, "Este número já existe na árvore!");
						} else if (x.getRight() == null) {
								Node novo = new Node(elemento);
								x.setRight(novo);
								novo.setDad(x);
						} else {
								inserir(x.getRight(), elemento);
						}
				}
				return x;
		}

		public void inserirMaxHeapFormat(int elemento) {

				switch (contHeap) {

						case 0:
								setRaiz(new Node(elemento));
								contHeap++;
								break;

						case 1:
								getRaiz().setLeft(new Node(elemento));
								contHeap++;
								break;

						case 2:
								getRaiz().setRight(new Node(elemento));
								contHeap++;
								break;

						case 3:
								getRaiz().getLeft().setLeft(new Node(elemento));
								contHeap++;
								break;

						case 4:
								getRaiz().getLeft().setRight(new Node(elemento));
								contHeap++;
								break;

						case 5:
								getRaiz().getRight().setLeft(new Node(elemento));
								contHeap++;
								break;

						case 6:
								getRaiz().getRight().setRight(new Node(elemento));
								contHeap++;
								break;

						case 7:
								getRaiz().getLeft().getLeft().setLeft(new Node(elemento));
								contHeap++;
								break;

						case 8:
								getRaiz().getLeft().getLeft().setRight(new Node(elemento));
								contHeap++;
								break;

						case 9:
								getRaiz().getLeft().getRight().setLeft(new Node(elemento));
								contHeap++;
								break;

						case 10:
								getRaiz().getLeft().getRight().setRight(new Node(elemento));
								contHeap++;
								break;

						case 11:
								getRaiz().getRight().getLeft().setLeft(new Node(elemento));
								contHeap++;
								break;

						case 12:
								getRaiz().getRight().getLeft().setRight(new Node(elemento));
								contHeap++;
								break;

						case 13:
								getRaiz().getRight().getRight().setLeft(new Node(elemento));
								contHeap++;
								break;

						case 14:
								getRaiz().getRight().getRight().setRight(new Node(elemento));
								contHeap++;
								break;

						case 15:
								getRaiz().getLeft().getLeft().getLeft().setLeft(new Node(elemento));
								contHeap++;
								break;

						case 16:
								getRaiz().getLeft().getLeft().getLeft().setRight(new Node(elemento));
								contHeap++;
								break;

						case 17:
								getRaiz().getLeft().getLeft().getRight().setLeft(new Node(elemento));
								contHeap++;
								break;

						case 18:
								getRaiz().getLeft().getLeft().getRight().setRight(new Node(elemento));
								contHeap++;
								break;

						case 19:
								getRaiz().getLeft().getRight().getLeft().setLeft(new Node(elemento));
								contHeap++;
								break;

						case 20:
								getRaiz().getLeft().getRight().getLeft().setRight(new Node(elemento));
								contHeap++;
								break;

						case 21:
								getRaiz().getLeft().getRight().getRight().setLeft(new Node(elemento));
								contHeap++;
								break;

						case 22:
								getRaiz().getLeft().getRight().getRight().setRight(new Node(elemento));
								contHeap++;
								break;

						case 23:
								getRaiz().getRight().getLeft().getLeft().setLeft(new Node(elemento));
								contHeap++;
								break;

						case 24:
								getRaiz().getRight().getLeft().getLeft().setRight(new Node(elemento));
								contHeap++;
								break;

						case 25:
								getRaiz().getRight().getLeft().getRight().setLeft(new Node(elemento));
								contHeap++;
								break;

						case 26:
								getRaiz().getRight().getLeft().getRight().setRight(new Node(elemento));
								contHeap++;
								break;

						case 27:
								getRaiz().getRight().getRight().getLeft().setLeft(new Node(elemento));
								contHeap++;
								break;

						case 28:
								getRaiz().getRight().getRight().getLeft().setRight(new Node(elemento));
								contHeap++;
								break;

						case 29:
								getRaiz().getRight().getRight().getRight().setLeft(new Node(elemento));
								contHeap++;
								break;

						case 30:
								getRaiz().getRight().getRight().getRight().setRight(new Node(elemento));
								contHeap++;
								break;

				}

		}

		// Cria vetor para ser usado na interface (heap)
		public Node[] DeArvoreParaVetor(Node lista[], Node z, int n) {

				if (z != null && n < 31) {
						lista[n] = z;
						int n2 = n;
						if (z.getLeft() != null) {
								n = (2 * n) + 1;
								DeArvoreParaVetor(lista, z.getLeft(), n);
						}
						if (z.getRight() != null) {
								n2 = (2 * n2) + 2;
								DeArvoreParaVetor(lista, z.getRight(), n2);
						}
				}

				return lista;
		}

		public Node remove(Node r, int n) {

				if (r == null) {
						return null;
				} else if (n < r.getInfo()) {
						r.setLeft(remove(r.getLeft(), n));
				} else if (n > r.getInfo()) {
						r.setRight(remove(r.getRight(), n));
				} else if (r.getLeft() == null && r.getRight() == null) {
						if (r == raiz) {
								raiz = null;
						} else {
								r = null;
						}
				} else if (r.getRight() == null) {
						Node temp = r;
						r.getLeft().setDad(r.getDad());
						if (r == raiz) {
								raiz = r.getLeft();
						} else {
								r = r.getLeft();
						}
						temp = null;
				} else if (r.getLeft() == null) {
						Node temp = r;
						r.getRight().setDad(r.getDad());
						if (r == raiz) {
								raiz = r.getRight();
						} else {
								r = r.getRight();
						}
						temp = null;
				} else {
						Node temp = r.getLeft();
						while (temp.getRight() != null) {
								temp = temp.getRight();
						}
						r.setInfo(temp.getInfo());
						temp.setInfo(n);
						r.setLeft(remove(r.getLeft(), n));
						//balanceamentoAVL(raiz); // balanceamento após remoção
				}

				return r;
		}

		//Calcula a altura do nó.
		public int alturaDoNo(Node r) {

				if (r == null) {
						return -1;
				} else if (r.getLeft() == null && r.getRight() == null) {
						return 0;
				} else if (r.getRight() == null) {
						return alturaDoNo(r.getLeft()) + 1;

				} else if (r.getLeft() == null) {
						return alturaDoNo(r.getRight()) + 1;
				} else {
						return Math.max(alturaDoNo(r.getLeft()), alturaDoNo(r.getRight())) + 1;
				}
		}

		//Transforma a árvore em uma lista ordenada.
		public Node ArvoreParaLista(Node r, ListaArvore lista) {

				if (isEmpty()) {
						System.out.println("A árvore está vazia!");
				} else {

						lista.incluirElemento(r.getInfo());
						if (r.getRight() == null && r.getLeft() != null) {
								ArvoreParaLista(r.getLeft(), lista);
						} else if (r.getLeft() == null && r.getRight() != null) {
								ArvoreParaLista(r.getRight(), lista);
						} else if (r.getLeft() != null && r.getRight() != null) {
								ArvoreParaLista(r.getLeft(), lista);
								ArvoreParaLista(r.getRight(), lista);
						}
				}
				return lista.getStart();
		}

		//Balanceamento por lista.
		public void balanceamentoLista() {

				ListaArvore lista = new ListaArvore();
				// Transforma a arvore numa lista ordenada
				ArvoreParaLista(raiz, lista);
				Arvore arv = new Arvore();
				// A lista ordenada passa a ser uma nova árvore balanceada.
				raiz = lista.listaParaArvore(lista.getStart(), arv);
		}

		//Rotaciona os elementos da árvore para a direita.
		public void rotacionaDireita(Node r) {

				Node temp1, temp2;
				temp1 = r.getLeft();
				temp2 = temp1.getRight();
				temp1.setRight(r);
				// Muda o pai de temp1
				temp1.setDad(r.getDad());
				//caso o programa tente acessar um objeto da memória que não foi instanciado (null point).
				if (temp1.getDad() != null) {
						// muda a direita do pai de temp1 de r para temp1
						temp1.getDad().setRight(temp1);
				}
				r.setDad(temp1); // muda o pai de r
				r.setLeft(temp2);
				//caso o programa tente acessar um objeto da memória que não foi instanciado (null point).
				if (temp2 != null) {
						temp2.setDad(r); // Muda o pai de temp2
				}
				if (r == raiz) { // Quando r for a raiz
						raiz = temp1; // q será  a nova raiz
				}
		}

		//Rotaciona os elementos da árvore para a esquerda.
		public void rotacionaEsquerda(Node r) {

				Node temp1, temp2;
				temp1 = r.getRight();
				temp2 = temp1.getLeft();
				temp1.setLeft(r);
				// Muda o pai de temp1;
				temp1.setDad(r.getDad());
				if (temp1.getDad() != null) {
						// Muda a esquerda do pai de temp1 de r para temp1;
						temp1.getDad().setLeft(temp1);
				}
				r.setDad(temp1); // muda o pai de r
				r.setRight(temp2);
				if (temp2 != null) {
						temp2.setDad(r); // Muda o pai de temp2
				}
				if (r == raiz) {
						raiz = temp1;
				}
		}

		public void balanceamentoAVL(Node r) {

				if (isEmpty()) {
						System.out.println("A árvore está vazia!");
				} else if ((alturaDoNo(r.getLeft())) - (alturaDoNo(r.getRight())) == 2) { //Quando o fator de balanceamento  de r for = 2
						if ((alturaDoNo(r.getLeft().getLeft())) - (alturaDoNo(r.getLeft().getRight())) >= 0) { // Quando o fator de balanceamento do filho a esquerda de r for  >= 0
								rotacionaDireita(r);
						} else if ((alturaDoNo(r.getLeft().getLeft())) - (alturaDoNo(r.getLeft().getRight())) <= 0) { // Quando o fator de balanceamento do filho a esquerda de r for <= 0
								rotacionaEsquerda(r.getLeft());
								rotacionaDireita(r);
						}
				} else if ((alturaDoNo(r.getLeft())) - (alturaDoNo(r.getRight())) == -2) { //Quando o fator de balanceamento  de r for = -2
						if ((alturaDoNo(r.getRight().getLeft())) - (alturaDoNo(r.getRight().getRight())) <= 0) { // Quando o fator de balanceamento do filho a direita de r for <= 0
								rotacionaEsquerda(r);
						} else if ((alturaDoNo(r.getRight().getLeft())) - (alturaDoNo(r.getRight().getRight())) >= 0) { // Quando o fator de balanceamento do filho a direita de r for >= 0
								rotacionaDireita(r.getRight());
								rotacionaEsquerda(r);
						}
				}
		}

		public void imprime(Node r) {
				if (r != null) {
						imprime(r.getLeft());
						System.out.println(r);
						imprime(r.getRight());
				}
		}

}
