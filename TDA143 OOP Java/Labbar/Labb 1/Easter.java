import javax.swing.JOptionPane;

public class Easter {
	public static void main(String[] arg) {
		
		while (true) {
		String indata = JOptionPane.showInputDialog("Vänligen skriv in önskat år mellan 1900 & 2099");
		if (indata == null)
			  break; // bör ligga innan omvandlingen till y 
	 	int y = (int) Integer.parseInt(indata);
		
		
		
			if(y>=1900) {
			
			if(y<=2099) {
				
				int n ; int a ; int b ; int m ; int q ; int w ; int d ;  
				n= y-1900; a= n%19; b= (7*a+1)/19; m= (11*a+4-b)%29; q= n/4; w=(n+q+31-m)%7; d= (25-m-w); 
			
				if(d>0) {
				JOptionPane.showMessageDialog(null,"Påsk är den " + d + " April");
				}
				else if (d<=0) {
				JOptionPane.showMessageDialog(null,"Påsk är den " + (d+31) + " Mars");
					}
				}
			else 	
				JOptionPane.showMessageDialog(null,"Året var ej mellan 1900 o 2099");
			
			}	
		
		}
	}
}
