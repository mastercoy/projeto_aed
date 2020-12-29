package sample;


public class MaxHeap {

		private static final int FRONT = 1;
		private int[] Heap;
		private int size;
		private int maxsize;

		public MaxHeap(int maxsize) {
				this.maxsize = maxsize;
				this.size = 0;
				Heap = new int[this.maxsize + 1];
				Heap[0] = Integer.MAX_VALUE;
		}

		private int parent(int pos) {
				return (pos / 2);
		}

		private int leftChild(int pos) {
				return (2 * pos);
		}

		private int rightChild(int pos) {
				return (2 * pos) + 1;
		}

		private boolean isLeaf(int pos) {
				//antes pos <= size
				return (pos >= (size / 2)) && (pos < size);
		}

		private void swap(int fpos, int spos) {
				int temp;
				temp = Heap[fpos];
				Heap[fpos] = Heap[spos];
				Heap[spos] = temp;
		}

		private void maxHeapify(int pos) {
				if (!isLeaf(pos)) {
						if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {
								if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
										swap(pos, leftChild(pos));
										maxHeapify(leftChild(pos));
								} else {
										swap(pos, rightChild(pos));
										maxHeapify(rightChild(pos));
								}
						}
				}
		}

		public void print() {
				for (int i = 1; i <= size / 2; i++) {
						System.out.print(" Pai : " + Heap[i] + " Filho da esquerda : " + Heap[2 * i]
									+ " Filho da direita :" + Heap[2 * i + 1]);
						System.out.println();
				}
		}

		public int retornaHeapMax(int n) {
				return Heap[n];
		}

		public void insert(int element) {
				Heap[++ size] = element;
				int current = size;

				while (Heap[current] > Heap[parent(current)]) {
						swap(current, parent(current));
						current = parent(current);
				}
		}

		public int getSize() {
				return size;
		}

		public void maxHeap() {
				for (int pos = (size / 2); pos >= 1; pos--) {
						maxHeapify(pos);
				}
		}

		public int remove() {
				int popOut = Heap[FRONT];
				Heap[FRONT] = Heap[size--];
				maxHeapify(FRONT);
				return popOut;
		}

}
