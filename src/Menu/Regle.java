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
				"                                             HOLA MOUSSAILLON�!!! \n\n\n\n "
				+ "Bienvenu � bord du Mary Celeste�!J'esp�re que tu es pr�t pour une aventure�!\n\n"
				+ "En effet le mois dernier, moi et le capitaine avons entendu des rumeurs sur une �le.\n"
				+ "Il y aurait un tr�sor de cach� � Nous devons le trouver�!!\n"
				+ "Mais Barbe Rouge a �galement entendu parler de cette histoire, nous devons trouver le tr�sor avant lui.\n"
				+ "Pour cela, nous disposons d'un �quipage compos� de guerriers, de voleurs, de piegeur et d'explomaladroits.\n"
				+ "Le tr�sor et la cl� seraient cach� sous un rocher.\n"
				+ "Mais seul un explomaladroit ayant acquis certaines capacit�s peut regarder en dessous d'un rocher.\n"
				+ "Le voleur, quant � lui, peut voler les effets de l'�quipage adverse.\n"
				+ "Les guerriers eux sont l� pour leur montrer de quel bois on se chauffe�!\n"
				+ "Les piegeurs nous aiderons � appuyer notre �quipage d�j� sur l'�le.\n"
				+ "Si tu te sens fatigu�, rentre au navire, le cuisto t'aura pr�par� un repas chaud pour te redonner de l'�nergie.\n"
				+ "Lorsque tu auras trouv� le tr�sor n'oublie pas de le ramener au navire avant de te le faire voler�!\n\n"
				+ "Sur ces entres faits, TIENS BON LA BARRE ET TIENS BON LE VENT MOUSSAILLON�ET RAM�NE MOI CE TR�SOR!\n\n" );
		regle.setEditable(false);
		pan.add(regle,BorderLayout.NORTH);
		
		JTextArea commande= new JTextArea(
				"                                              COMMENT JOUER?\n\n\n\n"
				+ "Pour vous d�placer ou agir il vous suffit de cliquer sur le bouton correspondant sur la ligne du personnage voulu.\n"
				+ "Puis vous pouvez rentrer les coordon�e dans le terminale de l'endroit o� vous voulez effectuer l'action.\n"
				+ "Pour savoir ou jouer reporter vous � la num�rotation autour du plateau.\n"
				+ "Pour savoir ou est le personnage, ses coordon�es sont �crite a c�ter de son nom.\n"
				+ "Les explorateurs ne peuvent se deplacer et agir que en croix autour d'eux.\n"
				+ "Les autres peuvent se deplacer et agir dans tout les direction.\n\n"
				+ "Les explorateurs peuvent soulever les rochers, il leurs faut la clef et le coffre pour r�cup�r� le tr�sor.\n"
				+ "Les voleurs ont une chance de prendre des objets que poss�de les enemis.\n"
				+ "Les guerriers peuvent attaquer l'adversaire, lui retirant de l'�nergie, seulement si il a une arme sur lui.\n"
				+ "Les pigeurs peuvent cresser un trou gr�ce a leurs mine, elle immobilise durant trois tours la personne tomber dedans.\n"
				+ "Agir sur un ali� vous permet de lui donner un item\n\n"
				+ "L'energie est de 100 au d�but et diminue avec les action, arriver a 0 le personnage meurt.\n"
				+ "Les d�placement coute 1 point, les action coute 5 ou 10 en fonction des personnages.\n"
				+ "Si un personnage meurt on peut voir un cadavre la ou il �tait, et son inventaire tombe par terre.\n"
				+ "Si quelqu'un marche sur le corps de quelqu'un d'autre il r�cup�re son inventaire.\n"
				+ "Pour r�g�n�r� son �nergie il faut rentrer au beateau, o� l'energie regen�re de 10 par tour.");
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
