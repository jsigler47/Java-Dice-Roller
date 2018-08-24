import java.util.*;
import java.io.File;

public class diceRoller{

	public static void main(String[] args){
		/* 
		 * Program to take input from a file to specify the number
		 * of dice to be rolled and the type of die to be rolled (number of sides).
		 * The program prints the result of each roll after it is determined.
		*/
		String separator = new String("--------------------\n");
		
		try{
		File inFile = new File("input.txt");
		Scanner sc = new Scanner(inFile);
		dice d1 = new dice();
		String[] inputs = new String[2];

		System.out.print(separator);
		while(sc.hasNext()){ // Process input
			String line = sc.nextLine();
			//System.out.print(line + " " + line.startsWith("//") +"\n");
			if(!line.startsWith("//")){
				//System.out.print(line + "\n");

				Arrays.fill(inputs, null); //Clear inputs
				inputs = line.split("d");
				//System.out.print(inputs[0] + " " + inputs[1]);

				d1.amount = Integer.parseInt(inputs[0]);
				d1.sides = Integer.parseInt(inputs[1]);
				//System.out.print(d1.amount + " " + d1.sides + "\n");
				d1.roll();
				System.out.print(separator);
			}
		}
	}
	catch(Exception e){
		System.out.println(e);
		System.out.println("File not found");
	}
}
	public static class dice{
		//Constructors for dice. First specifies size and amount of dice. Second is generic.
		public dice(int amount1, int sides1){
			sides = sides1;
			amount = amount1;
		}
		public dice(){
			sides = 0;
			amount = 0;
		}

		public int amount;
		public int sides;

		//Generate and print the roll of each die
		public void roll(){
			for(int i = 0; i < amount; i++){
				Random r = new Random();
				int roll = r.nextInt(sides);
				roll++; //Because nextInt returns 0 through 1-sides
				//System.out.print("Roll #" + (i + 1) + " of d" + sides + ": " + roll + "\n");
				System.out.format("Roll #%-2d of d%-3d: %-3d\n", (i+1), sides, roll);
			}
		}
	}
}