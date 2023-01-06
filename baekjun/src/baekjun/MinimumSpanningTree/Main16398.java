package baekjun.MinimumSpanningTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//������ �����׷����� ���, ������ n���϶�, ������ ������ n(n-2)/2�̰�, 
//�༺�� ������ �ִ� 1000���̱⶧����, 1000(999)/2�� �Ǽ�, �ð����⵵�� �뷫 500000log500000�̸�
//1�� �ȿ� Ǯ���ִٴ� ���缺�� ���� �� ����.
//��, ������ �����׷�����, �ִ� 1000���� ���, ��� ������ ����� �ִ� 1���̶�� ������ ���,
//�ּҽ���Ʈ���� ������ ������ ������ �������� -1�Ѱ��̹Ƿ�, ������ �� 50�������� �����ϴٴ� ���̰�,
//�� 50������ ������� 1������ ����� ����Ǿ��ٰ� �����ϸ�, 50��*1���� �Ǽ�
//21�ﺸ�� ������ Ŀ���� ������ ����� int�� �ƴ� long���� �Ի��ؾߵȴ�.
public class Main16398 {
	
	public static int N;
	public static long cost;
	public static StringTokenizer st;
	public static PriorityQueue<E> edges = new PriorityQueue<E>();
	public static int[] parent = new int[1001];

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = 0;
		
		for(int i=1; i<=N; i++) {
			parent[i] = i;
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=N; j++) {
				edges.add(new E(i,j,Integer.parseInt(st.nextToken())));
			}
		}
		
		while(!edges.isEmpty()) {
			E edge = edges.poll();
			if(find(edge.getNodeA()) != find(edge.getNodeB())){
				union(edge.getNodeA(),edge.getNodeB());
				cost += edge.getWeight();
			}
		}
		
		System.out.println(cost);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}
	
	public static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	

}

class E implements Comparable<E>{
	private int nodeA;
	private int nodeB;
	private int weight;
	
	public E(int nodeA, int nodeB, int weight) {
		this.nodeA = nodeA;
		this.nodeB = nodeB;
		this.weight = weight;
	}
	
	public int getNodeA() {
		return this.nodeA;
	}
	
	public int getNodeB() {
		return this.nodeB;
	}
	
	public int getWeight() {
		return this.weight;
	}
	
	public int compareTo(E edge) {
		return this.weight - edge.weight;
	}
}