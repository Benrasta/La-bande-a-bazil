package Menu;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Autre.Jeu;

public class Containerz extends JPanel {
	private JButton bu1;
	private JButton bu2;
	private JButton bu3;
	private Box bx1;
	private Box bx2;
	private Box bx3;
	private FirstPanel fp;

	public Containerz (JFrame f){
		super();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		fp=new FirstPanel();
		add(fp);
		bu1=new JButton("Humain VS Humain");
		bu2=new JButton("Humain VS IA");
		bu3=new JButton("IA VS IA");
		bu1.setPreferredSize(new Dimension(50,50));
		bu2.setPreferredSize(new Dimension(50,50));
		bu3.setPreferredSize(new Dimension(50,50));
		bu1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.setVisible(false);
				new Jeu().LancementHVH(fp.getdimension(),fp.getobstacles());
			}
		});
		bx1=Box.createHorizontalBox();
		bx1.add(bu1);
		add(bx1);
		bx2=Box.createHorizontalBox();
		bx2.add(bu2);
		add(bx2);
		bx3=Box.createHorizontalBox();
		bx3.add(bu3);
		add(bx3);

	}
}
