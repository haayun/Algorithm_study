import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ2108 {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N];
		final int SIZE = 4000;
		
		//각 수의 빈도수를 저장하는 배열
		int[] count = new int[SIZE * 2 + 1]; // [0]: -4000 ~ [4000]: 0 ~ [8000]: 4000
		double sum = 0;	//전체 합
		
		
		int max_value = 0;	//최빈값, 최다 빈도수
		for (int i = 0; i < N; i++) {	
			list[i] = Integer.parseInt(br.readLine());
			sum += list[i];
			count[list[i] + SIZE]++;
			if(count[list[i] + SIZE] > max_value)
				max_value = count[list[i] + 4000];
		}
		
		
		//두번째로 작은 최빈값 구하기
		int mode = 0, cnt = 0;	//최빈값, 최빈값 개수
		for (int i = 0; i < count.length; i++) {
			if (count[i] == max_value) {
				mode = i - SIZE;
				cnt++;
				if(cnt == 2)	//두번째라면 바로 break
					break;
			}
		}
		
		Arrays.sort(list);	//정렬
		
		System.out.println(Math.round(sum / N));
		System.out.println(list[N/2]);
		System.out.println(mode);
		System.out.println(list[N-1] - list[0]);
		
	}

}
