// v i m/sek , a i grader
// import static java.lang.Math.*
// Ersätter Math. i varje anrop

import java.text.DecimalFormat;
import javax.swing.JOptionPane;
	
public class Parabola {
public static void main(String[] arg) {
		String indata = JOptionPane.showInputDialog("Ange hastighet");
		double v = Double.parseDouble(indata);
	
		String indata1 = JOptionPane.showInputDialog("Ange vinkel i grader");
		double vg = Double.parseDouble(indata1);
		double vr = vg * (Math.PI/180); 
		double g = 9.81; 
		
		double h = (Math.pow(v, 2) * Math.pow(Math.sin(vr), 2) ) / (2*g); 
		double d = (Math.pow(v, 2) * Math.sin(2*vr) ) / (g); 
		JOptionPane.showMessageDialog(null, "Banhöjd: " + new DecimalFormat("0.00").format(h) + " och längden är " + new DecimalFormat("0.00").format(d) ) ;

}}
