import java.util.*;

class Data{
	Data(){}
	Data(int v,int s){
		vertex = v;
		step = s;
	}
	int vertex;
	int step;
}

public class E06 {
	int maxn = 10;
	int graph[][] = new int[maxn][maxn];
	
	public void addEdge(int u,int v) {
		graph[u][v]=1;
		graph[v][u]=1;
	}
	
	public int dijkstra(int u,int v) {
		int dist[] = new int[maxn];
		boolean visited[] = new boolean[maxn];
		for(int i = 0;i<maxn;i++)dist[i]=maxn+1;
		dist[u]=0;
		Queue<Data> que = new LinkedList<>();
		que.add(new Data(u,0));
		while(!que.isEmpty()) {
			Data t = que.poll();
			if(visited[t.vertex]==true)continue;
			visited[t.vertex]=true;
			for(int i = 0;i<maxn;i++) {
				if(graph[t.vertex][i]==1) {
					que.add(new Data(i,t.step+1));
					dist[i] = Math.min(dist[i], t.step+1);
				}
			}
		}
		if(dist[v]==maxn+1)return -1;
		return dist[v];
	}
	
	public static void main(String args[]) {
		//²âÊÔ´úÂë
		E06 e = new E06();
		e.addEdge(1, 5);
		e.addEdge(2, 5);
		e.addEdge(2, 7);
		e.addEdge(5, 7);
		e.addEdge(8, 9);
		System.out.println(e.dijkstra(1, 7));
		System.out.println(e.dijkstra(1, 9));
	}
}
