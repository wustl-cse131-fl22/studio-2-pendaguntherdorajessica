package studio2;
import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner input  = new Scanner(System.in);
		System.out.println("enter startAmount");
		int startAmount = input.nextInt();
		System.out.println("enter win chance");
		double winChance = input.nextDouble();
		System.out.println("enter win limit");
		int winLimit = input.nextInt();
		System.out.println("enter total simulations");
		int totalSimulations = input.nextInt();
		
	
		int count = 0;
		int currentAmount = startAmount;
		int lose = 0;
		for(int i = 1;i<=totalSimulations;i++) {
			
			while(currentAmount<winLimit && currentAmount>0) {
				
				double a = Math.random();
				if(a>winChance) {
					currentAmount++;
					count++;
				}
				else {
					currentAmount--;
					
					count++;
				}
			}
			
			if(currentAmount == 0) {
				System.out.println("Simulation "+i+": "+count+" LOSE");
				count = 0;
				currentAmount = startAmount;
				lose++;
			}
			
			else {
				System.out.println("Simulation "+i+": "+count+" WIN");
				count = 0;
				currentAmount = startAmount;
			}
		}
		double ruinRate = (double)lose/totalSimulations;
		double expRuinRate;
		double b =(1-winChance)/winChance;
		
		if(winChance == 0.5) {
			expRuinRate = 1-(startAmount/winLimit);
		}
		else {
			expRuinRate = ((Math.pow(b, startAmount)-Math.pow(b, winLimit))/(1-Math.pow(b, winLimit)));
		}
		
		System.out.println("Loses: "+lose+" Simulations: "+totalSimulations);
		System.out.println("Ruin Rate from Simulation: "+ruinRate+" Expected Ruin Rate: "+expRuinRate);
	}

}
