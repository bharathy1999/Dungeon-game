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
        System.out.println("Enter the gold position :");
        int goldinrow=scanner.nextInt();
        int goldincolumn=scanner.nextInt();
        dungeon[goldinrow-1][goldincolumn-1]='G';
        int steps=0;
        if(adventureinrow>goldinrow) {
        	steps+=adventureinrow-goldinrow;
        }
        else {
        	steps+=goldinrow-adventureinrow;
        }
        if(adventureincolumn>goldincolumn) {
        	steps+=adventureincolumn-goldincolumn;
        }
        else {
        	steps+=goldincolumn-adventureincolumn;
        }
        System.out.println("Minimum number of steps"+steps);
	}

}
