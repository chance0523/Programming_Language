package com.boj;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_14002_가장긴증가하는부분수열4 {
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] lis = new int[n]; // 각 lis의 길이를 만족하는 맨 끝에 오는 최소값을 저장
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] indexArr = new int[n];

		// 동작
		int size = 0; // lis 길이 (뒤에 0들은 빼주기 위해)
		for (int i = 0; i < n; i++) {
			int temp = Arrays.binarySearch(lis, 0, size, arr[i]); // arr[i]:탐색 키 => 찾으면 인덱스, 못찾으면 음수값으로 자신이 삽입 될 위치
			if (temp >= 0) // (-index-1)
				continue;
			// 중복 값이 없다면 temp : 음수 값
			temp = Math.abs(temp) - 1; // 삽입위치 환산
			lis[temp] = arr[i];
			if (temp == size) { // 맨 뒤에 추가하는 상황
				size++;
				indexArr[i] = size;
			} else { // 업데이트 하는 상황이면
				indexArr[i] = temp+1;
			}
		}
		System.out.println(size);

		// 배열 출력
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = n - 1; i >= 0; i--) {
			if(size==0)break;
			if(indexArr[i] == size) {
				stack.push(arr[i]);
				size--;
			}
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		sc.close();
	}
}
