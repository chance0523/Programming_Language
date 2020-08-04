package com.swea;

import java.util.Scanner;

// Stack 대신 2진 Tree 를 배열로 표현 
// 시작 Index 를 1 로 하면
//		2진 Tree 에서 부모 Node index = 자신  Node index / 2 <-- 홀수/2 도 포함
//		2진 Tree 에서 옆 Node index = 자신 Node index -1 또는 +1

public class SW_1233_사칙연산유효성검사_Array {

	static String[] nodes;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {

			int N = sc.nextInt();
			int result = 1;

			nodes = new String[N + 1];

			sc.nextLine();

			// [0] - Node 번호 <-- index j 로 대체, [1] Node 항목 [2] 하위 정점 또는 숫자
			for (int j = 1; j <= N; j++) {
				String str = sc.nextLine();
				nodes[j] = str.split(" ")[1];
			}

			// 마지막 index 에서 부터 ( 2진 Tree 의 오른쪽 밑에서 부터 )
			// (연산자) index/2
			// /\
			// / \
			// (숫자) (숫자)
			// index-1 index

			int index = N;

			while (index != 1) {

				if (is_number(index) && is_number(index - 1) && !is_number(index / 2)) {

					switch (nodes[index / 2]) {
					// 자식 노드가 모두 정수이고 부모가 연산자일 때, 부모의 연산자 요소에 따라 계산 후 부모 노드 초기화
					case "+": {
						nodes[index / 2] = (Integer.parseInt(nodes[index - 1]) + Integer.parseInt(nodes[index])) + "";
						break;
					}
					case "-": {
						nodes[index / 2] = (Integer.parseInt(nodes[index - 1]) - Integer.parseInt(nodes[index])) + "";
						break;
					}
					case "*": {
						nodes[index / 2] = (Integer.parseInt(nodes[index - 1]) * Integer.parseInt(nodes[index])) + "";
						break;
					}
					case "/": {
						// 나누기 0 는 1로 표기
						if (nodes[index].equals("0"))
							nodes[index] = "1";
						nodes[index / 2] = (Integer.parseInt(nodes[index - 1]) / Integer.parseInt(nodes[index])) + "";
						break;
					}
					}

					index -= 2; // 2진 Tree 를 왼쪽으로 또는 위쪽 오른쪽 끝으로 이동
				} else {
					result = 0;
					break;
				}
			}

			System.out.println("#" + i + " " + result);
		}

		sc.close();
	}

	static boolean is_number(int idx) {// 숫자와 연산자를 구분하기 위한 함수
		if (!nodes[idx].equals("+") && !nodes[idx].equals("-") && !nodes[idx].equals("*") && !nodes[idx].equals("/"))
			return true;
		return false;
	}
}

