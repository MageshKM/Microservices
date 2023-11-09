package com.java8.stream;

//Java equivalent code
import java.util.LinkedList;
import java.util.Queue;

class Example {

	// Function to find maximum sum of
	// a subarray of size k
	static int maxSum(int arr[], int n, int k) {
		// k must be smaller than n
		if (n < k) {
			System.out.println("Invalid");
			return -1;
		}

		// Create Queue
		Queue<Integer> q = new LinkedList<Integer>();

		// Initialize maximum and current sum
		int m = Integer.MIN_VALUE;
		int su = 0;

		// Compute sum of first k elements
		// and also store them inside queue
		for (int i = 0; i < k; i++) {
			q.add(arr[i]);
			su += arr[i];
		}

		// Compute sum of remaining elements
		for (int i = k; i < n; i++) {

			// remove first element from the queue
			su -= q.peek();
			q.remove();

			// add current element to the queue
			q.add(arr[i]);
			su += arr[i];

			// update maximum sum
			m = Math.max(m, su);
		}
		return m;
	}

	// Driver code
	public static void main(String[] args) {
		int arr[] = { 16, 12, 9, 19, 11, 8};
		int k = 3;
		int n = arr.length;
		System.out.println(maxSum(arr, n, k));
	}
}