package com.bharathy.show;

public class Players {  
        int row;
        int col;
        Players(int row,int col){
        	this.row=row;
        	this.col=col;
        }
}



package com.bharathy.show;
import java.util.Scanner;
public class Dungeongame {
         static int stepcalculate(Players start,Players target) {
        	  int steps=0;
        	  
              
              int i=0;   
              if(start.row>target.row) {
           	   steps+=start.row-target.row;        	
              }
              
              if(start.row<target.row)  {
           	   steps+=target.row-start.row;
              }
              
              if(start.col>target.col) {
           	   steps+=start.col-target.col;
              }
              
              if(start.col<target.col) {
           	   steps+=target.col-start.col;
              } 
              
              return steps;
              
          }
         static String footprint(int steps,Players adventure,Players gold,Players monster ) {
        	 
           	  StringBuilder strb=new StringBuilder();
                 strb.append("("+(adventure.row+","+adventure.col)+")-->");
                 int i=0;
                while(i<steps) {
                	if(monster!=null&&adventure.row<gold.row&&adventure.col!=monster.col) {
                		adventure.row++;
                	}
                	else if(monster!=null&&adventure.row>gold.row&&adventure.col!=monster.col) {
                		adventure.row--;
                	}
                	else if(monster!=null&&adventure.col>gold.col&&adventure.row!=monster.row) {
                		adventure.col--;
                	}
                	else if(monster!=null&&adventure.col<gold.col&&adventure.row!=monster.row) {
                		adventure.col++;
                	}
                	
                	else if(adventure.row==gold.row) {
//                		adventure.col=adventure.col>gold.col?adventure.col--:adventure.col++;
                		if(adventure.col<gold.col) {
                			adventure.col++;
                		}
                		if(adventure.col>gold.col) {
                			adventure.col--;
                		}
                	}
                	else if(adventure.col==gold.col) {
//                		adventure.row=adventure.row>gold.row?adventure.row--:adventure.row++;
                		if(adventure.row>gold.row) {
                			adventure.row--;
                		}
                		if(adventure.row<gold.row) {
                			adventure.row++;
                		}
                	}
                	strb.append("("+adventure.row+","+adventure.col+")-->");
                	
                	i++;
                }
                strb.delete(strb.length()-3, strb.length());
                 return strb.toString();
             
         }
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the dimensions of dungeon :");
        int row=scanner.nextInt();
        int column=scanner.nextInt();
        char dungeon [][]=new char[row][column];
        
        System.out.println("Enter the adventure position :");
        int adventureinrow=scanner.nextInt();
        int adventureincolumn=scanner.nextInt();
        Players adventure=new Players(adventureinrow,adventureincolumn);
        
        System.out.println("Enter the monster position :");
        int monsterinrow=scanner.nextInt();
        int monsterincolumn=scanner.nextInt();
        Players monster=new Players(monsterinrow,monsterincolumn);
        
        System.out.println("Enter the trigger position :");
        int triggerinrow=scanner.nextInt();
        int triggerincolumn=scanner.nextInt();
        Players trigger=new Players(triggerinrow,triggerincolumn);
        
        System.out.println("Enter the gold position :");
        int goldinrow=scanner.nextInt();
        int goldincolumn=scanner.nextInt();
        Players gold=new Players(goldinrow,goldincolumn);
        

       int stepsofadventure=stepcalculate(adventure,gold);
       int stepsofmonster=stepcalculate(monster,gold);
       int stepsadventuretotrigger=stepcalculate(adventure,trigger);
       int stepstriggertomonster=stepcalculate(trigger,monster);
       int stepsmonstertogold=stepcalculate(monster,gold);
     
      if(stepsofadventure<=stepsofmonster) {
    	  System.out.println("Minimum number of steps :"+stepsofadventure); 
    	  System.out.println(footprint(stepsofadventure,adventure,gold,monster));
      }
      else if(stepsadventuretotrigger<=stepstriggertomonster){
            System.out.println(stepsadventuretotrigger+stepstriggertomonster+stepsmonstertogold);
      }
      else {
    	  System.out.println("No possible solution");  
      }
      
 
	}

}
