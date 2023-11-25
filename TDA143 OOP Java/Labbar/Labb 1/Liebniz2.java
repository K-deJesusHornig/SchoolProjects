import java.text.DecimalFormat;

public class Liebniz2 {
		public static void main(String[] arg) {
			double PI=0;
			int counter = 0; 
			double numerator = 4*(-1); // sätter startvärdet 
			double denominator = 1;
			
			while (Math.abs((PI) - Math.PI) > 0.00001) {
				numerator = numerator * (-1); // alternerar -4 <--> 4. 
				PI += ((numerator)/denominator);
				denominator += 2 ;  //short cut för att lägga till 2
				counter ++; 
				}
		
			System.out.print(PI + "   ");
			System.out.print("Antal iterationer: " + counter );
		
		  DecimalFormat numberFormat = new DecimalFormat("#.00000");
		System.out.println("   " + "" + numberFormat.format(PI));
	/**	 Juicy kod för önskat antal decimaler */
		
	}
}