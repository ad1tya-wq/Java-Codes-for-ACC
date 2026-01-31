import java.util.*;

public class celeb 
{
    static int celmat(int mat[][])
    {
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < mat.length; i++)
        {
            s.push(i);
        }

        while(s.size() > 1)
        {
            int r = s.pop();
            int c = s.pop();
            if(mat[r][c] == 1) s.push(c);
            else s.push(r);
        }

        int x = s.peek();

        for(int i = 0; i < mat.length; i++)
        {
            if(i == x) continue;
            if(mat[x][i] == 1) return -1;
        }
        
        for(int j = 0; j < mat.length; j++)
        {
            if(j == x) continue;
            if(mat[j][x] == 0) return -1;
        }

        return x;
    } 
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];

        for(int i = 0; i < n; i++)
        {
            System.out.println("Person " + (i+1));
            for(int j = 0; j < n; j++)
            {
                matrix[i][j] = sc.nextInt();
            }
        }

        int res = celmat(matrix);
        if(res == -1) System.out.println("No celebs");
        else System.out.println("Celeb is person number " + (res+1));
    }
}
