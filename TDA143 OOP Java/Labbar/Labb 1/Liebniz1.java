
public class Liebniz1 {
		public static void main(String[] arg) {
			double PI=0;
			double numerator = -4; // sätter startvärdet 
			double denominator = 1;
			
			for(int i = 0; i<500; i++) {
				numerator *= (-1); // alternerar -4 <--> 4. 
				PI += ((numerator)/denominator); // uppdatera värde för pi
				denominator += 2 ;  //short cut
				}
		System.out.print(PI); 
	}
}