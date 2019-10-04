public class Lklist {

	private Node head;

	public Lklist() {
		this.head = null;
	}

	public boolean isEmpity() {
		if (this.head == null) {
			return true;
		}
		return false;
	}

	public int size() {
		return size(this.head);
	}

	private int size(Node aux) {
		if (aux == null) {
			return 0;
		} else {
			return 1 + size(aux.next);
		}
	}

	public int soma() {
		return soma(this.head);

	}

	private int soma(Node aux) {
		if (aux == null) {
			return 0;
		} else {
			return aux.value + soma(aux.next);
		}
	}

	public boolean isSorted() {
		if (this.head.next == null) {
			return true;
		} else {
			return isSorted(head.next);
		}
	}

	private boolean isSorted(Node aux) {
		if (aux.next == null) {
			return true;
		} else {
			if (aux.value > aux.next.value) {
				return false;
			} else {
				return isSorted(aux.next);
			}
		}
	}

	public void addLast(int element) {
		if (this.head == null) {
			this.head.value = element;
		} else {
			addLast(head.next, element);
		}
	}

	private void addLast(Node aux, int element) {
		if (aux == null) {
			Node novo = new Node(element);
			novo.previus = aux.previus;
			aux = novo;
		} else {
			addLast(aux.next, element);
		}
	}

	public void remove(int index) {
		if (index == 0 && this.head.next == null) {
			this.head = null;
		} else if (index == 0) {
			this.head = this.head.next;
			this.head.previus = null;

		} else {
			Node aux = this.head;
			int count = 0;
			while (count < index) {
				aux = aux.next;
				count++;
			}

			if (index == size() - 1) {
				aux.previus.next = null;
				aux.previus = null;
			} else {

				aux.previus.next = aux.next;
				aux.next.previus = aux.previus;
				aux.next = null;
				aux.previus = null;
			}
		}
	}

	public void Add(int index, int element) {

		if (index == 0 && this.head.next == null) {
			Node novo = new Node(element);
			this.head = novo;

		} else if (index == 0) {
			
			Node novo = new Node(element);
			novo.next = this.head.next;
			this.head.previus = novo;
			this.head = novo;
			
		} else {
			Node aux = this.head;
			int count = 0;
			if (index <= this.size() - 1) {
				while (count < index) {
					aux = aux.next;
					count++;
				}
			}

			Node novo = new Node(element);
			aux.previus.next = novo;
			novo.previus = aux.previus;
			novo.next = aux;
			aux.previus = novo;
		}
	}
}

class Node {
	int value;
	Node next;
	Node previus;

	Node(int value) {
		this.value = value;
		this.next = null;
		this.previus = null;
	}

}
