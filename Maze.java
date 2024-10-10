package Backtracking;

import java.util.ArrayList;

public class Maze {
    //IT WILL RETURN THE TOTAL POSIBLE STEPS TO REACH NEXT END ONLY WITH RIGHT AND DOWN

    static int count(int r,int c){
        if(r==1 || c==1){
            return 1;
        }
        int left=count(r-1,c);
        int right=count(r,c-1);
        return left+right;
    }

    ////IT WILL RETURN THE DIRECTION TO REACH NEXT END ONLY WITH RIGHT AND DOWN

    static void path(String p,int r,int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
        if (r>1){
            path(p+'D',r-1,c);
        }
        if(c>1){
            path(p+'R',r,c-1);
        }
    }
    //IT WILL RETURN THE DIRECTION TO REACH NEXT END ONLY WITH RIGHT AND DOWN AND STORE IN ARRAYLIST
    static ArrayList<String> direction(String p,int r,int c){
        if(r==1 &&c==1){
            ArrayList<String>list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String>list=new ArrayList<>();
        if(r>1){
            list.addAll(direction(p+'D',r-1,c));
        }
        if (c>1){
            list.addAll(direction(p+'R',r,c-1));
        }
        return list;
    }
    //DIRECTION CAN BE HORIZONTAL VERTICAL DIOGNAL DIRECTION
    static ArrayList<String> directionAllSide(String p,int r,int c){
        if(r==1 &&c==1){
            ArrayList<String>list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String>list=new ArrayList<>();
        if(r>1&&c>1){
            list.addAll(directionAllSide(p+'D',r-1,c-1));
        }
        if(r>1){
            list.addAll(directionAllSide(p+'V',r-1,c));
        }
        if (c>1){
            list.addAll(directionAllSide(p+'H',r,c-1));
        }
        return list;
    }

    //THERE IS SOMETHING BETWEEN MAZE.
    static void MazeRiver(String p,boolean[][] maze,int r,int c){
        if (r ==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        if(r<maze.length-1){
            MazeRiver(p+'D',maze,r+1,c);
        }
        if(c<maze[c].length-1){
            MazeRiver(p+'R',maze,r,c+1);
        }
    }
    public static void main(String[] args) {
//        System.out.println(count(3,3));
//        System.out.println(direction("",3,3));
        System.out.println(directionAllSide("",3,3));
        boolean[][] maze={
                {true,true,true},
                {true,false,true},
                {true,true,true},
        };
//       MazeRiver("",maze,0,0);
    }
}
