import java.util.Arrays;

public class DisjointSetTest {
	static int N;
	static int[] parents;

	// 단위 집합 생
	public static void makeSet() {
		parents = new int[N];
		for (int i = 0; i < N; i++)
			parents[i] = i;
	}

	// a의 집합 찾기 : a의 대표자 찾
	public static int findSet(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = findSet(parents[a]); // path compression
	}

	// a, b 두 집합 합치기
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = 5;

		makeSet();
		System.out.println(union(0, 1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(2, 1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(3, 2));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(4, 3));
		System.out.println(Arrays.toString(parents));

		System.out.println("========find========");
		System.out.println(findSet(4));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(3));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(2));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(0));
		System.out.println(Arrays.toString(parents));
		System.out.println(findSet(1));

	}

}
