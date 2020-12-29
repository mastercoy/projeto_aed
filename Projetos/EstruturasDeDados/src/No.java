/**
 * Created by Nylo on 23/08/2016.
 */
public class No {

		private int info;
		private No proximo; // espaço na memória

		public No(int i) {
				info = i;
				proximo = null;
		}



		public void setInfo(int info) {
				this.info = info;
		}

		public int getInfo() {
				return info;
		}

		public No getProximo() {
				return proximo;
		}

		public void setProximo(No proximo) {
				this.proximo = proximo;
		}

}