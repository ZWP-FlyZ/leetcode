package test4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author zwp12
 *
 * https://leetcode-cn.com/problems/walking-robot-simulation/description/
 * 
 * 机器人移动
 * 
 */


public class AndroidMove {

	
	public static int[][] Axis= {{0,1}, //0
								 {1,0}, //1
								 {0,-1}, //2
								 {-1,0} //3
								 };
	public static int changedir(int dir,int cmd) {
		if(cmd==-1) return (dir+1)%4;
		else if(cmd==-2) return (dir+3)%4;
		return dir;
	}
	public static boolean isBlock(Map<Integer,Set<Integer>> blocks,int x,int y) {
		Set<Integer> ys = blocks.get(x);
		if(ys==null) return false;
		else return ys.contains(y);
	}
	
	public static int move(int[] loc,int dir,int step,Map<Integer,Set<Integer>> blocks) {
		int x=loc[0],y=loc[1],ms=0;
		int[]axis = Axis[dir];
		while(step-->0) {
			x+=axis[0];y+=axis[1];
			if(isBlock(blocks,x,y)) break;
			loc[0]=x;loc[1]=y;
			ms++;
		}
		return ms;
	}
	
    public static int robotSim(int[] commands, int[][] obstacles) {
        int dir=0;
        int[] loc = {0,0};
        Set<Integer> tmp=null;
        Map<Integer,Set<Integer>> blocks = new HashMap<>();
        for(int[] b:obstacles) {
        	if((tmp=blocks.get(b[0]))==null) {
        		tmp = new HashSet<>();
        		blocks.put(b[0], tmp);
        	}
        	tmp.add(b[1]);	
        }
        for(int cmd:commands) {
        	if(cmd<0) dir = changedir(dir,cmd);
        	else if(cmd>0) move(loc,dir,cmd,blocks);
        }
        System.err.println(Arrays.toString(loc));
    	return loc[0]*loc[0]+loc[1]*loc[1];
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cmd = {4,-1,4,-2,4};
		int[][] b= {{2,4}};
		System.err.println(robotSim(cmd,b));
	}

}
