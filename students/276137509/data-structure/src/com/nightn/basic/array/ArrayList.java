package com.nightn.basic.array;

import com.nightn.basic.Iterator;
import com.nightn.basic.List;

public class ArrayList implements List{
	
	private int size = 0;
	
	private int capacity = 100;
	
	private Object[] elementData = new Object[capacity];
	
	public void add(Object o) {
		if(size < capacity) {
			elementData[size++] = o;
		} else {
			capacity *= 2;
			Object[] oldElementData = elementData;
			elementData = new Object[capacity];
			for(int i = 0; i < oldElementData.length; i++) {
				elementData[i] = oldElementData[i];
			}
			elementData[size++] = o;	
		}
	}
	
	public void add(int index, Object o) {
		Object[] oldElementData = elementData;
		if(size >= capacity) {
			capacity *= 2;
		}
		elementData = new Object[capacity];
		for(int i = 0; i < index + 1; i++) {
			elementData[i] = oldElementData[i];
		}
		elementData[index + 1] = o;
		size++;
		for(int j = index + 2; j < size; j++) {
			elementData[j] = oldElementData[j - 1];
		}
	}
	
	public Object get(int index) {
		if(index >= 0 && index < size) {
			return elementData[index];
		} else {
			return null;
		}
	}
	
	public Object remove(int index) {
		if(index >= 0 && index < size) {
			Object[] oldElementData = elementData;
			elementData = new Object[capacity];
			
			for(int i = 0; i < index; i++) {
				elementData[i] = oldElementData[i];
			}
			for(int i = index + 1; i < size; i++) {
				elementData[i - 1] = oldElementData[i];
			}
			size--;
			return oldElementData[index];
		} else {
			return null;
		}
	}
	
	public int size() {
		return size;
	}
	
	public Iterator iterator() {
		return null;
	}
	
	public void printSelf() {
		for(int i = 0; i < size; i++) {
			if(i == 0) {
				System.out.print("[" + elementData[i] + ", ");
			} else if(i < size - 1) {
				System.out.print(elementData[i] + ", ");
			} else {
				System.out.println(elementData[i] + "]");
			}
		}
	}
	
	
	/**
	 * test for ArrayList
	 */
	public static void main(String args[]) {
		ArrayList arrayList = new ArrayList();
		
		// add test
		arrayList.add(12);
		arrayList.add(14);
		for(int i = 0; i < 10; i++) {
			arrayList.add(i);
		}
		arrayList.printSelf();
		System.out.println("size=" + arrayList.size());
		arrayList.add(1, 999);
		arrayList.printSelf();
		
		// size test
		System.out.println("size=" + arrayList.size());
		
		// remove test
		arrayList.remove(3);
		arrayList.printSelf();
		System.out.println("size=" + arrayList.size());
		
		// get test
		System.out.println("第5个元素为" + arrayList.get(5));
		
	}
	
	
	
}
