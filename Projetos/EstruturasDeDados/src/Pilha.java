/**
 * Created by Nylo on 23/08/2016.
 */
class Pilha {

		private No topo;

		public Pilha() {
				topo = null;
		}

		private boolean isEmpty() {
				return topo == null;
		}

		public No getTopo() {
				return topo;
		}

		public void setTopo(No topo) {
				this.topo = topo;
		}

		public void push(int e) {
				No novo = new No(e);
				if (isEmpty()) {
						topo = novo;
				} else {
						novo.setProximo(topo);
						topo = novo;

				}
		}

		public void pop() {
				topo = topo.getProximo();

		}

		public void imprimePilha() {

				if (isEmpty()) {
						System.out.println("Pilha vazia!");
				} else {
						No temp = topo;
						String info = "";
						while (temp != null) {
								info += temp.getInfo() + " ";
								temp = temp.getProximo();
						}

						System.out.println(info);

				}
		}

		public No[] pilhaParaVetor(No pilha[], No z, int n) {
				if (z != null && n < 10) {
						pilha[n] = z;
				}
				return pilha;
		}

}
