package lab2;

/**
 * @author Hannah James
 * @since 9/5/17
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SeatMap {

	/**
	 * main: reads names from file and stores 
	 * them in an array
	 * When given a seat coordinate, it returns
	 * the name of the person in the seat
	 * 
	 */
	
	public static void main(String[] args) {
		
		int rows =100;
		int cols = 100;
		try {
			File file = new File("Names.dat");
			Scanner in = new Scanner(file);
			
			String [][]names = new String [rows][cols];
			
			for(int ir=0;ir<rows;ir++)
			{
				for(int ic =0;ic<cols;ic++)
				{
					if(in.hasNextLine())
					{
						String s = in.nextLine();
						names[ir][ic]=s;
					}
				}
			}
			
			Scanner input = new Scanner(System.in);
			System.out.println("What is the seat of the student?");
			
			input.useDelimiter(",");
			String seat = input.next();
			int nr = Integer.parseInt(seat.replaceAll(",", ""));
			int nc = Integer.parseInt(seat.replaceAll(",", ""));
			
			if(names[nr][nc]!=null)
			{
				System.out.println(names[nr][nc]);
			}
			else
			{
				System.out.println("That seat is empty");
			}
			
			in.close();
			input.close();
			
		}
		catch(FileNotFoundException er){
			er.getMessage();
		}
		

	}

}
