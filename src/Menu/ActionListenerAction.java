package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Autre.Jeu;

/**
 * Classe permmetant de cree des bouttons indépendant
 * @author Gaby
 *
 */
public class ActionListenerAction{

	private int cpt;
	
	/**
	 * Permmet de cree des bouttons indépendant
	 * 
	 * @param j
	 * @param i
	 * @param jeu
	 */
	public ActionListenerAction(JButton j, int i, final Jeu jeu ){
		cpt=i;
		j.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jeu.Action(jeu.getIle().getlistperso().get(cpt));
			}
		});
	}
}
