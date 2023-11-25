import javax.swing.JOptionPane;

public class DateFormats {
	public static void main(String[] arg) {
		
	while (true) 
		{
		String indata = JOptionPane.showInputDialog("Vänligen skriv in datumet enligt svenska system: ");
		int D = (int) Integer.parseInt(indata);
		
		int yy = D/10000;
		String x = Integer.toString(yy);
		if (yy <10) {
		x = "0"+yy; 
		}

		int m = D/100;
		int mm = m%100;
		String y = Integer.toString(mm);
		if (mm<10) {
		y = "0"+mm; 
		}
		
		int dd = D%100;
		String z = Integer.toString(dd);
		if (dd <10) {
		z = "0"+dd; 
		}
		
		JOptionPane.showMessageDialog(null, y + "/" + z + "/" + x ); 
		
		if (indata == null)
			  break;
		}		
} 
}


