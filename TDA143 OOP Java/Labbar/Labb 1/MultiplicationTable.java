import javax.swing.JOptionPane;

public class MultiplicationTable {
			public static void main(String[] arg) {
				String indata = JOptionPane.showInputDialog("Vänligen skriv in ett gradtal N");
				int n = (int) Integer.parseInt(indata);
		
				System.out.println("Ange Gradtal: " + n ); 
				for(int i = 0; i<=n; i++) { // yttre, antal rader 
			
					for(int j = 1; j<=i; j++) { // inre, antal kolumner
					System.out.print( j + " * " + i + " = " + i*j + "  "); 
					}
		 System.out.println(); 
		}
	}
}

// VZTIV, NZCGN, PSTAP, VTSIV, EWDXE 
