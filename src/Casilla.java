import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class Casilla {
	private JButton[][] cas ;
	private int ancho;
	private int alto;
	private int xInv;
	private int yInv;
	private JButton[][]tableroGanador;
	private boolean mezclado=false;
	private int cantMov=0;
	private JLabel lblMov;
	
	public Casilla(int ancho,int alto){
		cas=new JButton[ancho][alto];
		tableroGanador=new JButton[ancho][alto];
		this.ancho=ancho;
		this.alto=alto;
		xInv=ancho-1;
		yInv=alto-1;
	}
	
	public void agregarBoton(JButton btn,int x,int y,String nombreImagen){
		if(x<=ancho && x>=0 && y<=alto && y>=0){
			cas[x][y]=btn;
			tableroGanador[x][y]=btn;
			Icon imagenInterna = new ImageIcon(getClass().getResource(nombreImagen));
			btn.setIcon(imagenInterna);
		}
	}
	
	public void capturarEvento(KeyEvent ev){
		if(!mezclado){
		if(ev.getKeyCode()==KeyEvent.VK_SPACE)
			mezclar();
		
		}
		if(mezclado){
		if(ev.getKeyCode()==KeyEvent.VK_UP){
			if(verificarPos(xInv,yInv-1)){
				cantMov=cantMov+1;
				invertirPosiciones(xInv,yInv-1);
			}
		}
		if(ev.getKeyCode()==KeyEvent.VK_DOWN){
			if(verificarPos(xInv,yInv+1)){
				cantMov=cantMov+1;
				invertirPosiciones(xInv,yInv+1);
				}
		}
		if(ev.getKeyCode()==KeyEvent.VK_RIGHT){
			if(verificarPos(xInv+1,yInv)){
				cantMov=cantMov+1;
				invertirPosiciones(xInv+1,yInv);
				}
		}
		if(ev.getKeyCode()==KeyEvent.VK_LEFT){
			if(verificarPos(xInv-1,yInv)){
				cantMov=cantMov+1;
				invertirPosiciones(xInv-1,yInv);
				}
		}
		if(ev.getKeyCode()==KeyEvent.VK_G){
			cas=tableroGanador;
		}
		
		esGanador();
		}
	}
	
	public void setLabelMov(JLabel labelMov) {
		lblMov=labelMov;
		
	}
	
	public void modificarCantMov(){
		lblMov.setText(String.valueOf(cantMov));
	}
	
	public void hacerInv(){
		JButton ultimoBtn = cas[ancho-1][alto-1];
		ultimoBtn.setVisible(false);
	}

	private void invertirPosiciones(int xNuevo,int yNuevo){
		JButton tempInv=cas[xInv][yInv];
		JButton tempVis=cas[xNuevo][yNuevo];
		invertirPosicionesPoint(tempInv,tempVis);
		cas[xNuevo][yNuevo]=tempInv;
		cas[xInv][yInv]=tempVis;
		xInv=xNuevo;
		yInv=yNuevo;

	}

	private void invertirPosicionesPoint(JButton tempInv, JButton tempVis) {
		Point ubicacionInv =tempInv.getLocation();
		Point ubicacionVis =tempVis.getLocation();
		tempInv.setLocation(ubicacionVis);
		tempVis.setLocation(ubicacionInv);	
	}
	
	private void mezclar(){
		if(!mezclado){
		for(int x=0;x<50;x++){
		invertirPosiciones((int) (Math.random() * ancho) + 0,(int) (Math.random() * alto) + 0);
		}
		mezclado=true;
		}
	}


	private void esGanador(){
		boolean bandera=true;
		for(int y=0;y<tableroGanador.length;y++){
			for(int x=0;x<tableroGanador[y].length;x++){
				bandera = bandera && cas[x][y].equals(tableroGanador[x][y]);
			}
		}
		if(bandera){
			JOptionPane.showMessageDialog(null, "Ganaste, Felicidades lo resolviste en "+cantMov+" movimientos");
			System.exit(0);
		}
	}


	private boolean verificarPos(int modificacionDeX,int modificacionDeY){
		if(modificacionDeX<=ancho-1 && modificacionDeX>=0 && modificacionDeY<=alto-1 && modificacionDeY>=0)
			return true;
		return false;
	}
	
}
