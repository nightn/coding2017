package com.nightn.basic.array;

public class ArrayUtil {
	
	/**
	 * 自定义的打印数组的方法
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
		System.out.println("数组的长度为：" + length);
		System.out.println();
	}
	
	/**
	 * 求数组的逆序列
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
	 * 移除数组中值为0的项，返回新数组。此处进行了两次遍历，不太优雅
	 * @param oldArray
	 * @return
	 */
	public int[] removeZero(int[] oldArray) {
		// 第一次遍历找到目标数组的大小
		int newLength = 0;
		for(int ele : oldArray) {
			if(ele != 0) {
				newLength++;
			}
		}
		int[] newArray = new int[newLength];
		// 第二次遍历为目标数组赋值
		for(int i = 0, j = 0; i < oldArray.length; i++) {
			if(oldArray[i] != 0) {
				newArray[j] = oldArray[i];
				j++;
			}
		}
		return newArray;
	}
	
	/**
	 * 给定两个排序好的数组(升序)，对其进行合并，合并后的数组仍然是排序好的，注意消除重复元素
	 * 如果考虑降序，需要在方法中进一步判断，改变比较符号
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
	 * 将一个存满数据的数组 oldArray 进行扩容，新的数组大小为 oldArray.length + size
	 * 注意：老数组元素需要在新数组元素中保持
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
	 * 返回一个斐波那契数组，该数组最大元素要小于给定的 max
	 * @param max
	 * @return
	 */
	public int[] fibonacci(int max) {
		if(max <= 1) {
			return new int[]{};
		}
		// 先设定一个比较大的数组，长度为 max
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
	 * 返回小于给定 max 的所有素数组成的数组
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
	 * PerfectNumber 指该数恰好等于它的因子之和，如 6 = 1 + 2 + 3
	 * 返回最大值小于给定 max 的 PerfectNumber 数组
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
	 * 用separator 把数组 array给连接起来
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
