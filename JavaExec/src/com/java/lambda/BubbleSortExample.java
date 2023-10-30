package com.java.lambda;

import java.util.Arrays;

public class BubbleSortExample {

	public static void main(String args[]) {
		int[] arry = { 9, 4, 6, 2, 1 };
		System.out.println(Arrays.toString(arry));
		bubblesort(arry);
		System.out.println("Bubble Sort:" + Arrays.toString(arry));

	}

	private static void bubblesort(int[] a) {

		int n = a.length;
		int temp = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n; j++) {

				if (a[j - 1] > a[j]) {
					temp = a[j - 1];  //temp
					a[j - 1] = a[j]; // 
					a[j] = temp;
				}

			}
		}
	}

}
