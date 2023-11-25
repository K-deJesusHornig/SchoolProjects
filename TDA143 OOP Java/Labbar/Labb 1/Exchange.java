// Detta program läser valutakurs och ger motsvarande EUR till ett belopp SEK
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Exchange {
public static void main(String[] arg) {
		String indata = JOptionPane.showInputDialog("Ange gällande växelkurs från  SEK till Euro:");
		double KURS = Double.parseDouble(indata);
		
		String indata1 = JOptionPane.showInputDialog("Belopp SEK:");
		double SEK = Double.parseDouble(indata1);
		
		double EUR = SEK * KURS;
		JOptionPane.showMessageDialog(null, SEK + " SEK motsvarar " + new DecimalFormat("0.00").format(EUR) + "EUR");
	}
}