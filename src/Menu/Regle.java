package Menu;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Regle {
	
	public Regle (){
		JFrame f= new JFrame("Regle");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation((int)((dim.width-f.getSize().width)/2.5), (dim.height-f.getSize().height)/3);
		
		JPanel pan= new JPanel();
		JTextArea regle= new JTextArea(/*String texte de regle, int ligne, int colone*/);
		// format du String ("texte/n"+"texte/n")
		regle.setEditable(false);
		pan.add(regle);
		
		f.getContentPane().add(pan);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}

}
