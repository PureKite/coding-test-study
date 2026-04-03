import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

int n = Integer.parseInt(st.nextToken());
st = new StringTokenizer(br.readLine());

int sx = Integer.parseInt(st.nextToken());
int sy = Integer.parseInt(st.nextToken());
int ex = Integer.parseInt(st.nextToken());
int ey = Integer.parseInt(st.nextToken());

long minDist = Long.MAX_VALUE;
int answer = 1;

for (int i = 1; i <= n; i++) {
    st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    
    long result = 0;
    long tempX = sx;
    long tempY = sy;
    
    for (int j = 0; j < m; j++) {
        st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        
        result += Math.abs(tempX - x) + Math.abs(tempY - y);
        tempX = x;
        tempY = y;
    }
    
    result += Math.abs(tempX - ex) + Math.abs(tempY - ey);
    
    if (result < minDist) {
        minDist = result;
        answer = i;
    }
}

System.out.println(answer);
    }
}