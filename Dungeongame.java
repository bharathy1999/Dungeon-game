package com.bharathy.show;
import java.util.Scanner;
public class Dungeongame {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the dimensions of dungeon :");
        int row=scanner.nextInt();
        int column=scanner.nextInt();
        char dungeon [][]=new char[row][column];
        System.out.println("Enter the adventure position :");
        int adventureinrow=scanner.nextInt();
        int adventureincolumn=scanner.nextInt();
        dungeon[adventureinrow-1][adventureincolumn-1]='A';
        System.out.println("Enter a monster position :");
        int monsterinrow=scanner.nextInt();
        int monsterincolumn=scanner.nextInt();
        dungeon[monsterinrow][monsterincolumn]='M';
        System.out.println("Enter the gold position :");
        int goldinrow=scanner.nextInt();
        int goldincolumn=scanner.nextInt();
        dungeon[goldinrow-1][goldincolumn-1]='G';
        
        int steps=0;
        StringBuilder strb=new StringBuilder();
        strb.append("("+(adventureinrow+","+adventureincolumn)+")");
        int i=0;
        if(adventureinrow>goldinrow) {
        	steps+=adventureinrow-goldinrow;

        	while(i<steps) {
        		i++;
        		strb.append("-->("+((adventureinrow-i)+","+adventureincolumn)+")");
        	}
        }
        
        else {
        	steps+=goldinrow-adventureinrow;
        	while(i<steps) {
    		i++;
    		strb.append("-->("+((adventureinrow+i)+","+adventureincolumn)+")") ;
    	}
        }
        int j=0;
        
        if(adventureincolumn>goldincolumn) {
        	steps+=adventureincolumn-goldincolumn;
        	while(j<(adventureincolumn-goldincolumn)) {
        		j++;
        		strb.append("-->("+(goldinrow+","+(adventureincolumn-j))+")");
        	}
        }
        
        else {
        	steps+=goldincolumn-adventureincolumn;
        	while(j<(goldincolumn-adventureincolumn)) {
        		j++;
        		strb.append("-->("+(goldinrow+","+(adventureincolumn+j))+")");
        	}
        }
        
       
       int monsteps=0;
       if(monsterinrow>goldinrow) {
    	   monsteps+=monsterinrow-goldinrow;
    	   
       }
       else {
    	   monsteps+=goldinrow-monsterinrow;
       }
       if(monsterincolumn>goldincolumn) {
    	   monsteps+=monsterincolumn-goldincolumn;
       }
       else {
    	   monsteps+=goldincolumn-monsterincolumn;
       }
       
      if(steps<=monsteps) {
    	  System.out.println("Minimum number of steps :"+steps);
      }
      else {
    	  System.out.println("No possible solution");
      }
      System.out.println(strb.toString());
	}

}
