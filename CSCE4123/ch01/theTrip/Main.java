package theTrip;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] arg) {

		Scanner scanner = new Scanner(System.in);

		int size = scanner.nextInt();
		double numPeople = size;
		while(numPeople != 0){
			double total = 0;
			double totalDifference = 0;
			double [] costs = new double[size];
			
			for (int i = 0; i < numPeople; i++){
				Double input = scanner.nextDouble();
				input = input * 100.0;
				costs[i] = input;
				total+=input;
			}
			double average = total/(double)numPeople;
//			System.out.println("total: " + total + ", numppl: " + numPeople);
			for (int i = 0; i < numPeople; i++){
				totalDifference += Math.abs(costs[i]- average);
			}
			

			double output=  totalDifference/(double)200.0;
//			NumberFormat nf = new DecimalFormatter("##.##");
			System.out.printf("$%.2f", output);
			System.out.print("\n");
			
			size = scanner.nextInt();
			numPeople = size;
			
		}
	}
}
