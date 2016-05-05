package Menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Regle {
	
	JFrame f;
	
	public Regle (){
		f= new JFrame("Regle");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation((int)((dim.width-f.getSize().width)/2.5), (dim.height-f.getSize().height)/3);
		
		JPanel pan= new JPanel();
		pan.setLayout(new BorderLayout());
		JTextArea regle= new JTextArea(/*String texte de regle, int ligne, int colone*/);
		// format du String ("texte/n"+"texte/n")
		regle.setEditable(false);
		pan.add(regle,BorderLayout.CENTER);
		
		JButton bu=new JButton("Quitter");
		bu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
			}
		});
		pan.add(bu, BorderLayout.SOUTH);
		
		f.getContentPane().add(pan);
		f.setUndecorated(true);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}

}
