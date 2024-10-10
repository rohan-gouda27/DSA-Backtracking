package Backtracking;

public class BackTracking {
    static void backtracking(String p,boolean[][]maze,int r,int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c]=false;
        if(r<maze.length-1){
            backtracking(p+'D',maze,r+1,c);
        }
        if(c<maze[0].length-1){
            backtracking(p+'R',maze,r,c+1);
        }
        if(r>0){
            backtracking(p+'U',maze,r-1,c);
        }
        if (c>0){
            backtracking(p+'L',maze,r,c-1);
        }
        maze[r][c]=true;
    }

    public static void main(String[] args) {
        boolean[][] maze={
                {true,true,true},
                {true,false,true},
                {true,true,true},
        };
        backtracking("",maze,0,0);
    }
}
