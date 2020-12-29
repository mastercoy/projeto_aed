/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Nylo
 */
class Fila {

		private No ultimo;
		private No primeiro;

		public Fila() {
				primeiro = ultimo = null;
		}

		private boolean isEmpty() {
				return primeiro == null;
		}

		public No getUltimo() {
				return ultimo;
		}

		public void setUltimo(No ultimo) {
				this.ultimo = ultimo;
		}

		public No getPrimeiro() {
				return primeiro;
		}

		public void setPrimeiro(No primeiro) {
				this.primeiro = primeiro;

		}

		public No[] filaParaVetor(No fila[], No z, int n) {
				if (z != null && n < 10) {
						fila[n] = z;

				}
				return fila;
		}

		public void enQueue(int e) {
				No novo = new No(e);
				if (isEmpty()) {
						primeiro = novo;
						ultimo = novo;
				} else {
						ultimo.setProximo(novo);
						ultimo = novo;
				}
				System.out.println("Elemento incluido na fila: " + ultimo.getInfo());
		}

		public void deQueue() {
				int valor;
				valor = primeiro.getInfo();
				primeiro = primeiro.getProximo();
				System.out.println("Elemento removido da fila: " + valor);

		}

		public void imprimeFila() {

				if (isEmpty()) {
						System.out.println("Fila vazia!");
				} else {
						No temp = primeiro;
						String info = "";
						while (temp != null) {
								info += temp.getInfo() + " ";
								temp = temp.getProximo();
						}
						System.out.println(info);
				}
		}
}
