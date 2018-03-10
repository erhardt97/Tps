import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;


public class Panel extends JPanel {
	private Image imagen;
	/**
	 * Create the panel.
	 */
	public Panel(Image imagenInicial) {
		if (imagenInicial != null) {
	        imagen = imagenInicial;
		}
	}
	
	public void paint(Graphics g){
		g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
		setOpaque(false);
		super.paint(g);
	}

}
