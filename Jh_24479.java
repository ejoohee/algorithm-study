import java.util.*;

public class Jh_24479 {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] seq;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int start = sc.nextInt();

        graph = new ArrayList<>();
        seq = new int[n+1];
        visited = new boolean[n+1];

        for (int i = 0; i <=n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <=n; i++)
            Collections.sort(graph.get(i));

        seq[start] = 1;
        visited[start] = true;
        cnt = 2;
        dfs(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
            sb.append(seq[i] + "\n");

        System.out.println(sb);

    }
    public static void dfs(int root) {

        for (int vertex : graph.get(root)) {
            if (!visited[vertex]) {
                seq[vertex] = cnt++;
                visited[vertex] = true;
                dfs(vertex);
            }
        }
    }
}