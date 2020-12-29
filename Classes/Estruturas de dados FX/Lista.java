/**
 * Created by Nylo on 26/08/2016.
 */
 class Lista {

		private No inicio;
		private int numPos;

		public Lista() {
				inicio = null;
				numPos = 0;
		}

		public int getNumPos() {
				return numPos;
		}

		private boolean isEmpty() {
				return (inicio == null);
		}

		public void incluirInicio(int e) {
				No novo = new No(e);
				if (isEmpty()) {
						inicio = novo;
				} else {
						novo.setProximo(inicio);
						inicio = novo;
				}
				numPos++;
		}

		private int remove() {
				int valor = inicio.getInfo();
				inicio = inicio.getProximo();
				//   System.out.println("Elemento removido da fila: " + valor);
				return valor;
		}

		public No getInicio() {
				return inicio;
		}

		public void removerElemento(int e) {
				No temp = inicio;
				No ant = inicio;
				int valor = inicio.getInfo();
				if (inicio.getInfo() == e) {
						inicio = temp.getProximo();
						numPos--;
				} else {
						while ((temp.getProximo() != null) && (valor != e)) {
								ant = temp;
								temp = temp.getProximo();
								valor = temp.getInfo();
						}
						if (valor == e) {
								ant.setProximo(temp.getProximo());
								numPos--;

						}
				}
		}

		public void removerPosicao(int pos) {
				int p = 1;
				No temp = inicio;
				No ant = inicio;
				if (pos == 1) {
						inicio = inicio.getProximo();
						numPos--;
				} else if ((pos
							< 1) || (pos
							> numPos)) {
						System.out.println("Posição inválida");
				} else {
						while (p < pos) {
								ant = temp;
								temp = temp.getProximo();
								p++;
						}
						ant.setProximo(temp.getProximo());
						numPos--;
				}
		}

		public No[] listaParaVetor(No lista[], No z, int n) {
				if (z != null && n < 10) {
						lista[n] = z;
						listaParaVetor(lista, z.getProximo(), n + 1);

				}
				return lista;
		}

		public void imprime() {
				if (!isEmpty()) {
						No temp = inicio;
						String info = "";
						while (temp != null) {
								info += temp.getInfo() + " - ";
								temp = temp.getProximo();
						}
						System.out.println(info);
						System.out.println("Número de elementos: " + numPos);
				} else {
						System.out.println("Lista vazia");
				}
		}

		public void incluirPosicao(int pos, int e) { // recebe a posição e o elemento a ser adicionado como argumentos.
				No novo = new No(e);
				int p = 1;
				No temp = inicio;
				No ant = inicio;
				if (isEmpty()) {
						inicio = novo;
						numPos++;
				} else if ((pos < 1) || (pos > numPos)) {//verifica se a posição inserida é maior que a quantidade de osições na lista, se for, imprime um aviso.
						System.out.println("Posição inválida!");
				} else if (pos == p) { //Se a posição for a primeira, o novo objeto é adicionado no inicio
						novo.setProximo(inicio);
						inicio = novo;
						numPos++; // incrementa o número de poisções.
				} else {
						while (p < pos) { //enquanto a variavel p for menor que a posição inserida, temp irá apontar para cada elemento da lista, até chegar na posição desejada.
								ant = temp;
								temp = temp.getProximo();
								p++;
						}
						novo.setProximo(temp); //Faz o proximo do novo apontar para elemento da posição a ser ocupada.
						ant.setProximo(novo); // Substitui o elemento da posição a ser ocupada pelo novo. Ou seja, insere o novo entre os que já existiam.
						numPos++; // incrementa o número de poisções.
				}
		}

		public boolean pesquisaElemento(int e) {

				if (isEmpty()) {
						System.out.println("Lista vazia!");
				} else {
						No temp = inicio;
						while (temp != null) {
								if (temp.getInfo() == e) {
										System.out.println("Elemento " + e + " está na lista.");
										return true;
								}
								temp = temp.getProximo();
						}
				}
				System.out.println("Elemento " + e + " não está na lista.");
				return false;

		}

		public void pesquisaConteudoPos(int pos) {

				if (isEmpty()) {
						System.out.println("Pilha vazia!");
				} else {
						No temp = inicio;
						for (int i = 0; i < numPos; i++) {

								if (pos == i) {
										System.out.println("Elemento da posição " + pos + " é: " + temp.getInfo());
								} else {
										temp = temp.getProximo();
								}
						}
				}

		}

		public Lista concatenaListas(Lista a, Lista b) {
				while (!b.isEmpty()) {
						a.incluirInicio(b.remove());
				}
				return a;
		}

		private void trocaElementoPos(int pos, int e) {
				No temp = inicio;
				int p = 1;
				if (pos < 1 || pos > numPos) {
						System.out.println("Posição inválida!");
				} else {
						while (p < pos) {
								temp = temp.getProximo();
								p++;
						}
						temp.setInfo(e);
				}
		}

		public void insertionSort(Lista lista) {
				for (int i = 2, j; i < numPos + 1; i++) {
						int t = lista.buscaPosicao(i);//retorna o elemento da posição passada no parâmetro

						for (j = i; j > 1 && t < lista.buscaPosicao(j - 1); j--) {
								lista.trocaElementoPos(j, lista.buscaPosicao(j - 1));
						}

						lista.trocaElementoPos(j, t);

				}
		}

		public void selectionSort(Lista lista) {
				for (int i = 1, j, min; i < numPos; i++) {
						for (j = i + 1, min = i; j <= numPos; j++) {
								if (lista.buscaPosicao(j) < lista.buscaPosicao(min)) {
										min = j;

								}
						}
						troca(lista, min, i);
				}
		}

		public void bubbleSort() {
				for (int i = 1; i < numPos; i++) {
						for (int j = numPos; j > i; j--) {
								if (this.buscaPosicao(j) < this.buscaPosicao(j - 1)) {
										troca(this, j, j - 1);
								}
						}
				}
		}

		private int buscaPosicao(int pos) { //recebe como argumento  posição desejada
				int p = 1;
				No temp = inicio;
				if ((pos < 1) || (pos > numPos)) { //verifica se a posição inserida é maior que a quantidade de osições na lista, se for, imprime um aviso.
						System.out.println("Posição inválida!");
				} else {
						while (p < pos) { //enquanto a variavel p for menor que a posição inserida, temp irá apontar para cada elemento da lista, até chegar no desejado.
								temp = temp.getProximo();
								p++;
						}
						//System.out.println("O valor da posição "+pos+" é: "+temp.getInfo()); //imprime o valor da posição digitada.
				}
				return temp.getInfo();
		}

		private void troca(Lista lista, int pos1, int pos2) {
				int valor = lista.buscaPosicao(pos1);
				lista.trocaElementoPos(pos1, lista.buscaPosicao(pos2));
				lista.trocaElementoPos(pos2, valor);
		}

}
