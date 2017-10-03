package com.nightn.basic.array;

public class ArrayUtil {
	
	/**
	 * �Զ���Ĵ�ӡ����ķ���
	 * @param array
	 */
	public void printArray(int[] array) {
		int length = array.length;
		for(int i = 0; i < length; i++) {
			if(i == 0) {
				System.out.print("[" + array[i] + ", ");
			} else if (i < length - 1) {
				System.out.print(array[i] + ", ");
			} else {
				System.out.print(array[i] + "]  ");
			}
		}
		System.out.println("����ĳ���Ϊ��" + length);
		System.out.println();
	}
	
	/**
	 * �������������
	 * @param origin
	 */
	public void reverseArray(int[] origin) {
		int temp;
		int length = origin.length;
		for(int i = 0; i < length/2; i++) {
			temp = origin[i];
			origin[i] = origin[length - 1 - i];
			origin[length - 1 - i] = temp;
		}	
	}
	
	/**
	 * �Ƴ�������ֵΪ0������������顣�˴����������α�������̫����
	 * @param oldArray
	 * @return
	 */
	public int[] removeZero(int[] oldArray) {
		// ��һ�α����ҵ�Ŀ������Ĵ�С
		int newLength = 0;
		for(int ele : oldArray) {
			if(ele != 0) {
				newLength++;
			}
		}
		int[] newArray = new int[newLength];
		// �ڶ��α���ΪĿ�����鸳ֵ
		for(int i = 0, j = 0; i < oldArray.length; i++) {
			if(oldArray[i] != 0) {
				newArray[j] = oldArray[i];
				j++;
			}
		}
		return newArray;
	}
	
	/**
	 * ������������õ�����(����)��������кϲ����ϲ����������Ȼ������õģ�ע�������ظ�Ԫ��
	 * ������ǽ�����Ҫ�ڷ����н�һ���жϣ��ı�ȽϷ���
	 * @param array1
	 * @param array2
	 * @return
	 */
	public int[] merge(int[] array1, int[] array2) {
		int length1 = array1.length, length2 = array2.length;
		int newLength = length1 + length2;
		int[] newArray = new int[newLength];
		int i = 0, j = 0, k = 0;
		while(i < length1 && j < length2) {
			if(array1[i] == array2[j]) {
				newArray[k] = array1[i];
				i++; j++; k++;
			} else if(array1[i] < array2[j]) {
				newArray[k] = array1[i];
				i++; k++;
			} else {
				newArray[k] = array2[j];
				j++; k++;
			}
		}
		while(i < length1) {
			newArray[k] = array1[i];
			i++; k++;
		}
		while(j < length2) {
			newArray[k] = array2[j];
			j++; k++;
		}
		// shrink
		int[] array3 = new int[k];
		for(int x = 0; x < k; x++) {
			array3[x] = newArray[x];
		}
		return array3;
	}
	
	/**
	 * ��һ���������ݵ����� oldArray �������ݣ��µ������СΪ oldArray.length + size
	 * ע�⣺������Ԫ����Ҫ��������Ԫ���б���
	 * @param oldArray
	 * @param size
	 * @return
	 */
	public int[] grow(int[] oldArray, int size) {
		int length = oldArray.length + size;
		int[] newArray = new int[length];
		for(int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
		return newArray;
	}
	
	/**
	 * ����һ��쳲��������飬���������Ԫ��ҪС�ڸ����� max
	 * @param max
	 * @return
	 */
	public int[] fibonacci(int max) {
		if(max <= 1) {
			return new int[]{};
		}
		// ���趨һ���Ƚϴ�����飬����Ϊ max
		int[] array = new int[max];
		array[0] = 1;
		array[1] = 1;
		int i = 1;
		while(array[i] < max) {
			i++;
			array[i] = array[i - 1] + array[i - 2];	
		}
		// shrink
		int[] newArray = new int[i];
		for(int j = 0; j < newArray.length; j++) {
			newArray[j] = array[j];
		}
		return newArray;
	}
	
	/**
	 * ����С�ڸ��� max ������������ɵ�����
	 * @return
	 */
	public int[] getPrimes(int max) {
		int[] array = new int[max];
		int k = 0;
		for(int i = 2; i < max; i++) {
			boolean isPrime = true;
			for(int j = 2; j < i/2+1; j++) {
				if(i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				array[k++] = i;
			}
		}
		// shrink
		int[] newArray = new int[k];
		for(int x = 0; x < newArray.length; x++) {
			newArray[x] = array[x];
		}
		return newArray;
	}
	
	/**
	 * PerfectNumber ָ����ǡ�õ�����������֮�ͣ��� 6 = 1 + 2 + 3
	 * �������ֵС�ڸ��� max �� PerfectNumber ����
	 * @param max
	 * @return
	 */
	public int[] getPerfectNumbers(int max) {
		int[] array = new int[max];
		int k = 0;
		for(int i = 1; i < max; i++) {
			int factorSum = 0;
			for(int j = 1; j < i; j++) {
				if(i % j == 0) {
					factorSum += j;
				}
			}
			if(factorSum == i) {
				array[k++] = i;
			}
		}
		// shrink
		int[] newArray = new int[k];
		for(int x = 0; x < newArray.length; x++) {
			newArray[x] = array[x];
		}
		return newArray;
	}
	
	/**
	 * ��separator ������ array����������
	 * @param array
	 * @param seperator
	 * @return
	 */
	public String join(int[] array, String separator) {
		String s = "";
		for(int i = 0; i < array.length - 1; i++) {
			s += (array[i] + separator);	
		}
		s += array[array.length - 1];
		return s;
	}
	
	
//	/**
//	 * Test for ArrayUtil
//	 * @param args
//	 */
//	public static void main(String args[]) {
//		
//		ArrayUtil arrayUtil = new ArrayUtil();
//		
//		// reverseArray test
//		int[] array1 = new int[] {1, 2, 3, 4, 0, 29, 0, -2, 0, 23, 15};
//		arrayUtil.reverseArray(array1);
//		arrayUtil.printArray(array1);
//		
//		// removeZero test
//		int[] array2 = new int[] {1, 2, 3, 4, 0, 29, 0, -2, 0, 23, 15};
//		int[] newArray = arrayUtil.removeZero(array2);
//		arrayUtil.printArray(newArray);
//		
//		// merge test
//		int[] array3 = new int[]{3, 5, 7, 8};
//		int[] array4 = new int[]{4, 5, 6, 7};
//		int[] array5 = arrayUtil.merge(array3, array4);
//		arrayUtil.printArray(array5);
//		
//		// grow test
//		int[] array6 = new int[]{2, 4, 8, 1, 5};
//		int[] array7 = arrayUtil.grow(array6, 5);
//		arrayUtil.printArray(array7);
//		
//		// fibonacci test
//		int max = 13;
//		int[] array8 = arrayUtil.fibonacci(max);
//		arrayUtil.printArray(array8);
//		
//		// getPrimes test
//		int max2 = 23;
//		int[] array9 = arrayUtil.getPrimes(max2);
//		arrayUtil.printArray(array9);
//		
//		// getPerfectNumbers test
//		int max3 = 100;
//		int[] array10 = arrayUtil.getPerfectNumbers(max3);
//		arrayUtil.printArray(array10);
//		
//		// join test
//		int[] array11 = new int[]{2, 34, 54, 21, 9};
//		String s = arrayUtil.join(array11, ", ");
//		System.out.println(s);
//		System.out.println();
//		
//	}
	
}
