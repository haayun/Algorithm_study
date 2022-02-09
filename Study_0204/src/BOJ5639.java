import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Node {
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
public class BOJ5639 {

	/*
	 * 트리 탐색
	 */
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		List<Integer> input = new ArrayList<>();
		
		while((s = br.readLine()) != null && s.length() != 0)	// 입력 제한이 없을 때 입력 받는 방법
			input.add(Integer.parseInt(s));
		
		Node root = preorder(input);
		postorder(root);
		System.out.print(sb.toString());
	}
	
	// List를 매개변수로 받아서 이진 트리를 만들고 루트 노드를 반환
	static Node preorder(List<Integer> input) {
		Node root = new Node(input.get(0));
		
		for(int i = 1; i < input.size(); i++) {
			boolean flag = false;
			Node curr = root;
			
			while(!flag) {	// flag가 false일 때 : 노드가 이미 있는 경우
				int temp = input.get(i);
				if(temp < curr.data) {	// 다음 숫자가 현재 노드의 값보다 작으면 -> 왼쪽 노드 검사
					if(curr.left == null) {	
						curr.left = new Node(temp);	// 왼쪽 노드가 null이면 삽입
						flag = true;
					} else {
						curr = curr.left;	//왼쪽 노드가 이미 있다면 현재 노드로 전환
					}
				} else {	// 다음 숫자가 현재 노드의 값보다 크면 -> 오른쪽 노드 검사
					if(curr.right == null) {
						curr.right = new Node(temp);
						flag = true;
					} else {
						curr = curr.right;
					}
				}
			}
		}
		return root;
	}
	
	//이진 트리의 루트 노드를 매개변수로 받아서 후위 선회하고 결과 출력
	static void postorder(Node root) {
		if(root != null) {
			postorder(root.left);
			postorder(root.right);
			sb.append(root.data).append('\n');
		}
	}
}
