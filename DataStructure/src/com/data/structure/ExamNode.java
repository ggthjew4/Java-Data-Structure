package com.data.structure;

public class ExamNode<T> {

	private T value;

	private ExamNode<T> next;

	public ExamNode(T value, ExamNode<T> next) {
		this.value = value;
		this.next = next;
	}

	public T value() {
		return value;
	}

	public ExamNode<T> next() {
		return next;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public void setNext(ExamNode<T> next) {
		this.next = next;
	}

}
