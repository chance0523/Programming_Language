package com.ssafy.live02;

import java.util.Arrays;
import java.util.Scanner;

// 입력받은 N개의 숫자중 R개를 선택하는 순열
public class P2_PermutationInputtest {
	private static int N, R;
	private static int[] numbers; // 순열 저장 배열
	private static int[] input; // 입력된 숫자 배열
	private static boolean[] isSelected;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		
		numbers = new int[R]; // 0으로 초기화
		isSelected = new boolean[N]; // false로 초기화
		input = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		permutation(0);
	}

	// 지정된 자리에 순열 뽑기
	private static void permutation(int cnt) { // cnt : 현재까지 뽑은 순열의 갯수

		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 0; i < N; i++) {
			// 중복 확인
			if (isSelected[i])
				continue;

			numbers[cnt] = input[i]; // 해당 숫자 사용
			isSelected[i] = true; // 해당 숫자의 위치로 사용 처리

			permutation(cnt + 1);

			isSelected[i] = false;
		}
	}
}
