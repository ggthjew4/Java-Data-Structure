package com.data.structure;

public class ExamLinkedList<T> {

	private ExamNode<T> head = null;

	private int size = 0;

	public int size() {
		return size;
	}

	public ExamNode<T> get(int index) {
		if ((index < 0) || (index > size)) {
			throw new IllegalArgumentException(String.format(
					"invalid index %d is illegal", index));
		}
		int count = 0;
		ExamNode<T> currentNode = head;
		while (head.next() != null) {
			if (count == index) {
				return currentNode;
			}
			count++;
			currentNode = currentNode.next();
		}
		return null;
	}

	public void add(T value) {
		if (head == null) {
			head = new ExamNode<T>(value, null);
		} else {
			ExamNode<T> current = head;
			ExamNode<T> next = current.next();
			while (next != null) {
				current = current.next();
				next = current.next();
			}
			current.setNext(new ExamNode<T>(value, null));
		}
		size++;
	}

	public void remove(int index) {
		if ((index < 0) || (index > size)) {
			throw new IllegalArgumentException(String.format(
					"invalid index %d is illegal", index));
		}
		if (index == 0) {
			head = head.next();
		} else {
			ExamNode<T> currentNode = head;
			int count = 0;
			while (head.next() != null) {
				if (count == index - 1) {
					currentNode.setNext(currentNode.next().next());
					return;
				}
				count++;
				currentNode = currentNode.next();
			}
		}
		size--;
	}

	public void insert(T value, int index) {
		int count = 0;
		ExamNode<T> currentNode = head;
		while (head.next() != null) {
			if (count == index - 1) {
				ExamNode<T> newNode = new ExamNode<T>(value, head.next());
				newNode.setNext(currentNode.next());
				currentNode.setNext(newNode);
				return;
			}
			count++;
			currentNode = currentNode.next();
		}
		size++;
	}

	public void reverse() {
		ExamNode<T> prevNode = null;
		ExamNode<T> nextNode = null;
		if (null == head) {
			return;
		}
		while (true) {
			nextNode = head.next();
			head.setNext(prevNode);
			prevNode = head;
			if (null == nextNode) {
				break;
			}
			head = nextNode;
		}
	}

	private String toString(ExamNode<T> node) {
		if (null == node) {
			return "";
		}
		ExamNode<T> next = node.next();
		return new StringBuffer().append(node.value())
				.append(next == null ? "" : "\n").append(toString(next))
				.toString();
	}

	@Override
	public String toString() {
		return toString(head);
	}

	public final static void main(final String[] arg) {
		ExamLinkedList<Integer> list = new ExamLinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.reverse();
		System.out.print(list);
	}

}
