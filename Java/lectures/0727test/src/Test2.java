import java.io.FileInputStream;
import java.util.Scanner;

public class Test2 {
	static long Answer;
	static int N, S;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("Test2.txt"));
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();//테스트 케이스 수  
		
		for(int test_case=1; test_case<=T; test_case++){
			N=sc.nextInt(); //배열의 크기 N
			
			S=sc.nextInt();//돌의 수
			int[][] stone=new int[S][3];
			for(int i=0; i<S; i++){
				stone[i][0]=sc.nextInt();//힘
			}
			
			for(int i=0; i<S; i++){
				stone[i][1]=sc.nextInt();//행위치
				stone[i][2]=sc.nextInt();//열위치
			}
			//////////////////////////////
			//( 이 부분에 알고리즘 구현을 한다. )//
			//////////////////////////////

			
			
			
			
			

			
			System.out.println("#"+test_case+" "+Answer);
		}
	}
}
