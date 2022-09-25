package com.nk.datastructures.stack;

public class CustomStack<T> {

	private T[] data;
	private int stackPointer;

	public CustomStack() {
		data = (T[]) new Object[16];
		stackPointer = 0;
	}

	public void push(T item) {
		data[stackPointer++] = item;
	}

	public T pop() {
		if (stackPointer == 0)
			throw new IllegalStateException("No more items on the stack");
		return data[--stackPointer];
	}

	public boolean contains(T item) {
		for (int i = 0; i < stackPointer; i++) {
			if (data[i].equals(item)) {
				return true;
			}
		}

		return false;
	}

	public T access(T item) {
		while (stackPointer > 0) {
			T pop = pop();
			if (pop.equals(item)) {
				return item;
			}
		}

		throw new IllegalStateException("Could not find the item on the stack : " + item);
	}

	public int size() {
		return stackPointer;
	}
}
