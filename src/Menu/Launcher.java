package Menu;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Autre.Jeu;
import Autre.Test;

public class Launcher extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFrame f;
	private JSlider  dimension;
	private JSlider  obstacles;
	private JSlider  nbperso;
	private JLabel dim;
	private JLabel obs;
	private JLabel nbp;

	public Launcher(){	
		f = new JFrame("Launcher");
		Containerz();

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation((int)((dim.width-f.getSize().width)/2.5), (dim.height-f.getSize().height)/3);

		f.getContentPane().add(this);
		f.pack();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	public void Containerz (){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		FirstPanel();
		
		
		JButton bu1=new JButton("Humain VS Humain");
		bu1.setPreferredSize(new Dimension(50,50));
		bu1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new Jeu().LancementHVH(dimension.getValue(), obstacles.getValue(), nbperso.getValue());
			}
		});
		Box bx1=Box.createHorizontalBox();
		bx1.add(bu1);
		this.add(bx1);
		
		
		JButton bu2=new JButton("Humain VS IA");
		bu2.setPreferredSize(new Dimension(50,50));
		bu2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new Jeu().LancementHVI(dimension.getValue(), obstacles.getValue(), nbperso.getValue());
			}
		});
		Box bx2=Box.createHorizontalBox();
		bx2.add(bu2);
		this.add(bx2);
		
		
		JButton bu3=new JButton("IA VS IA");
		bu3.setPreferredSize(new Dimension(50,50));
		bu3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new Jeu().LancementIVI(dimension.getValue(), obstacles.getValue(), nbperso.getValue());
			}
		});
		Box bx3=Box.createHorizontalBox();
		bx3.add(bu3);
		this.add(bx3);
		
		
		JButton bu5=new JButton("Regle");
		bu5.setPreferredSize(new Dimension(50,50));
		bu5.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			
			public void mouseClicked(MouseEvent e) {
				new Regle();
			}
		});
		Box bx5=Box.createHorizontalBox();
		bx5.add(bu5);
		this.add(bx5);
		
		
		JButton bu4=new JButton("Test");
		bu4.setPreferredSize(new Dimension(50,50));
		bu4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				new Test();
			}
		});
		Box bx4=Box.createHorizontalBox();
		bx4.add(bu4);
		this.add(bx4);
	
		
	}

	public void FirstPanel(){
		JPanel fp=new JPanel();
		fp.setLayout(new GridLayout(3,3));
		
		
		fp.add(new JLabel("Taille du plateau:"));
		dimension= new JSlider(7, 20, 10);
		dim=new JLabel(": "+dimension.getValue());
		dimension.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				dim.setText(": "+dimension.getValue());
			}
		});
		fp.add(dimension);
		fp.add(dim);
		
		
		obstacles= new JSlider(10, 50, 30);
		obs=new JLabel(": "+obstacles.getValue());
		fp.add(new JLabel("Pourcentage de rocher:"));
		obstacles.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				obs.setText(": "+obstacles.getValue());
			}
		});
		fp.add(obstacles);
		fp.add(obs);
		
		
		nbperso=new JSlider(1, 20, 4);
		nbp=new JLabel(": "+nbperso.getValue());
		fp.add(new JLabel("Nombre de personnage de l'IA:"));
		nbperso.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				nbp.setText(": "+nbperso.getValue());
			}
		});
		fp.add(nbperso);
		fp.add(nbp);

		this.add(fp);
	}
}
