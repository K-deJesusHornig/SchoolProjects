/** rikemans-definitionen av en 12:a 
 I formeln betecknar d båtens omfång, A båtens segelyta, L båtens längd och f båtens fribordshöjd.
 ex 6.3 63.7 8.85 1.02  är en 12:a */

import javax.swing.JOptionPane;
import static java.lang.Math.* ;
import java.util.Scanner;
import java.util.Locale;

public class Boat  {
public static void main (String[] args) {
		  Locale.setDefault(Locale.UK);
		
		  String indata = JOptionPane.showInputDialog("Ange d  omfång, A  segelyta, L  längd och f  fribordshöjd: ");
		  //Man kan sätta SC är variabel 
		  Scanner sc = new Scanner(indata) ; 
		  
		double d =  sc.nextDouble();
		double a =	sc.nextDouble();
		double l = sc.nextDouble();
		double f = sc.nextDouble();
		
		sc.close();
			
		double t = (2*d + sqrt(a) +l -f)/2.37 ;
				
		if (Math.abs(t-12) <= 0.05 ) 	
		JOptionPane.showMessageDialog(null, "Båten är en steekig båt " ) ;
		else 
		JOptionPane.showMessageDialog(null, "Tyvärr kompis du är inte schteek nog" ) ;
		// notera att man skulle kunnat köra && istället 
	}
}
