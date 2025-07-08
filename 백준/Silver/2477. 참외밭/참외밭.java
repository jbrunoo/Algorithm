import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());
        int[] sides = new int[6];
        int widthMax = 0; int heightMax = 0;
        int widthMaxIdx = -1; int heightMaxIdx = -1;

        for(int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int side = Integer.parseInt(st.nextToken());
            sides[i] = side;

            if (direction == 3 || direction == 4) {
                if (widthMax < side) {
                    widthMax = side;
                    widthMaxIdx = i;
                }
            }
            if (direction == 1 || direction == 2) {
                if (heightMax < side) {
                    heightMax = side;
                    heightMaxIdx = i;
                }
            }
        }

        int widthMin = sides[(widthMaxIdx + 3) % 6];
        int heightMin = sides[(heightMaxIdx + 3) % 6];
        int size = widthMax * heightMax - widthMin * heightMin;

        System.out.print(k * size);
    }
}