import java.io.*;
import java.util.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static HashMap<Character, char[]> map = new HashMap<>();;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        for (int i = 0; i < n; i++) {
    	    st = new StringTokenizer(br.readLine());
        	char key = st.nextToken().charAt(0);
            char[] value = { st.nextToken().charAt(0), st.nextToken().charAt(0) };
    	
        	map.put(key, value);
        }

        preorder('A');
        sb.append("\n");
        inorder('A');
        sb.append("\n");
        postorder('A');

        System.out.println(sb);
    }

    static void preorder(char start) {
        if (start == '.') return;

        sb.append(start);
        preorder(map.get(start)[0]);
        preorder(map.get(start)[1]);
    }

    static void inorder(char start) {
        if (start == '.') return;

        inorder(map.get(start)[0]);
        sb.append(start);
        inorder(map.get(start)[1]);
	}

    static void postorder(char start) {
        if (start == '.') return;

        postorder(map.get(start)[0]);
        postorder(map.get(start)[1]);
        sb.append(start);    
    }
}