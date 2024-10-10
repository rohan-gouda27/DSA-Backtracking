package Backtracking;

import java.util.Arrays;

public class MazeWithPath {
    static void maze(String p,boolean[][] maze,int r,int c,int[][] path,int step){
        if (r==maze.length-1 && c==maze[0].length-1){
            for (int[] arr :path) {
                path[r][c]=step;
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
                return;
            }
            if(!maze[r][c]){
                return;
            }
            path[r][c]=step;
            maze[r][c]=false;
            if(r<maze.length-1){
                maze(p+'D',maze,r+1,c,path,step+1);
            }
            if(c<maze[0].length-1){
                maze(p+'R',maze,r,c+1,path,step+1);
            }
            if (r>0){
                maze(p+'U',maze,r-1,c,path,step+1);
            }
            if (c>0){
                maze(p+'L',maze,r,c-1,path,step+1);
            }
            maze[r][c]=true;
            path[r][c]=0;
        }


    public static void main(String[] args) {
        boolean[][] maze={
                {true,true,true},
                {true,true,true},
                {true,true,true},
        };
        int[][]path=new int[maze.length][maze[0].length];
        maze("",maze,0,0,path,1);
//        System.out.println();
    }
}
