package Menu;

import java.awt.BorderLayout;
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
		JPanel pan= new JPanel();
		pan.setLayout(new BorderLayout());
		JTextArea regle= new JTextArea(
				"                                             HOLA MOUSSAILLON !!! \n\n\n\n "
				+ "Bienvenu à bord du Mary Celeste !J'espère que tu es prêt pour une aventure !\n\n"
				+ "En effet le mois dernier, moi et le capitaine avons entendu des rumeurs sur une île.\n"
				+ "Il y aurait un trésor de caché … Nous devons le trouver !!\n"
				+ "Mais Barbe Rouge a également entendu parler de cette histoire, nous devons trouver le trésor avant lui.\n"
				+ "Pour cela, nous disposons d'un équipage composé de guerriers, de voleurs, de piegeur et d'explomaladroits.\n"
				+ "Le trésor et la clé seraient caché sous un rocher.\n"
				+ "Mais seul un explomaladroit ayant acquis certaines capacités peut regarder en dessous d'un rocher.\n"
				+ "Le voleur, quant à lui, peut voler les effets de l'équipage adverse.\n"
				+ "Les guerriers eux sont là pour leur montrer de quel bois on se chauffe !\n"
				+ "Les piegeurs nous aiderons à appuyer notre équipage déjà sur l'île.\n"
				+ "Si tu te sens fatigué, rentre au navire, le cuisto t'aura préparé un repas chaud pour te redonner de l'énergie.\n"
				+ "Lorsque tu auras trouvé le trésor n'oublie pas de le ramener au navire avant de te le faire voler !\n\n"
				+ "Sur ces entres faits, TIENS BON LA BARRE ET TIENS BON LE VENT MOUSSAILLON ET RAMÈNE MOI CE TRÉSOR!\n\n" );
		regle.setEditable(false);
		pan.add(regle,BorderLayout.NORTH);
		
		JTextArea commande= new JTextArea(
				"                                              COMMENT JOUER?\n\n\n\n"
				+ "Pour vous déplacer ou agir il vous suffit de cliquer sur le bouton correspondant sur la ligne du personnage voulu.\n"
				+ "Puis vous pouvez rentrer les coordonée dans le terminale de l'endroit où vous voulez effectuer l'action.\n"
				+ "Pour savoir ou jouer reporter vous à la numérotation autour du plateau.\n"
				+ "Pour savoir ou est le personnage, ses coordonées sont écrite a côter de son nom.\n"
				+ "Les explorateurs ne peuvent se deplacer et agir que en croix autour d'eux.\n"
				+ "Les autres peuvent se deplacer et agir dans tout les direction.\n\n"
				+ "Les explorateurs peuvent soulever les rochers, il leurs faut la clef et le coffre pour récupéré le trésor.\n"
				+ "Les voleurs ont une chance de prendre des objets que possède les enemis.\n"
				+ "Les guerriers peuvent attaquer l'adversaire, lui retirant de l'énergie, seulement si il a une arme sur lui.\n"
				+ "Les pigeurs peuvent cresser un trou grâce a leurs mine, elle immobilise durant trois tours la personne tomber dedans.\n"
				+ "Agir sur un alié vous permet de lui donner un item\n\n"
				+ "L'energie est de 100 au début et diminue avec les action, arriver a 0 le personnage meurt.\n"
				+ "Les déplacement coute 1 point, les action coute 5 ou 10 en fonction des personnages.\n"
				+ "Si un personnage meurt on peut voir un cadavre la ou il était, et son inventaire tombe par terre.\n"
				+ "Si quelqu'un marche sur le corps de quelqu'un d'autre il récupére son inventaire.\n"
				+ "Pour régénéré son énergie il faut rentrer au beateau, où l'energie regenére de 10 par tour.");
		commande.setEditable(false);
		pan.add(commande,BorderLayout.CENTER);
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
