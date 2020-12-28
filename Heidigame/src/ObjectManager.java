import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class ObjectManager implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
//	Rocketship rs;
//	Random random;
//	ArrayList<Projectile> pj;
//	ArrayList<Alien> al;
//
//	ObjectManager(Rocketship rs) {
//		this.rs = rs;
//		pj = new ArrayList<Projectile>();
//		al = new ArrayList<Alien>();
//	}
//
//	void addProjectile(Projectile pj) {
//
//	}
//
//	void addAlien() {
//		al.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
//	}
//
//	void update() {
//		rs.update();
//		for (int i = 0; i < pj.size(); i++) {
//			Projectile p1 = pj.get(i);
//			p1.update();
//			if (p1.y < 0) {
//				p1.isActive = false;
//			}
//		}
//		for (int i = 0; i < al.size(); i++) {
//			Alien a1 = al.get(i);
//			a1.update();
//
//			if (a1.y > LeagueInvaders.HEIGHT) {
//				a1.isActive = false;
//			}
//		}
//	}
//
//	void draw(Graphics g) {
//		rs.draw(g);
//		for (int i = 0; i < al.size(); i++) {
//			Alien a1 = al.get(i);
//			a1.draw(g);
//		}
//
//		for (int i = 0; i < pj.size(); i++) {
//			Projectile p1 = pj.get(i);
//			p1.draw(g);
//		}
//	}
//
//	void purgeObjects() {
//		for (int i = al.size() - 1; i >= 0; i--) {
//			if (al.get(i).isActive == false) {
//				al.remove(i);
//			}
//		}
//		for (int i = pj.size() - 1; i >= 0; i--) {
//			if (pj.get(i).isActive == false) {
//				pj.remove(i);
//			}
//		}
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent arg0) {
//		// TODO Auto-generated method stub
//		addAlien();
//	}
}