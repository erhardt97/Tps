import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.JLabel;

import java.awt.Font;


public class Tablero extends JFrame implements KeyListener{

	private JPanel contentPane;
	private Casilla tablero;
	private LinkedList<String> nombresIm=new LinkedList<String>();
	private int anchoB;
	private int altoB;

	public Tablero(int ancho,int alto,int anchoV,int altoV) {
		tablero=new Casilla(ancho,alto);
		anchoB=anchoV/ancho;
		altoB=altoV/alto;
		
		
		if(ancho*alto==9){
			for(int i=1;i<=ancho*alto;i++){
				String nombre="imagen_1_"+String.valueOf(i)+".jpg";
			nombresIm.addFirst(nombre);
			}
		}
		
		if(ancho*alto==16){
			for(int i=1;i<=ancho*alto;i++){
				String nombre="imagen_2_"+String.valueOf(i)+".jpg";
			nombresIm.addFirst(nombre);
			}
		}
		
		if(ancho*alto==25){
			for(int i=1;i<=ancho*alto;i++){
				String nombre="imagen_3_"+String.valueOf(i)+".jpg";
			nombresIm.addFirst(nombre);
			}
		}

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0,anchoV, altoV+50);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		
		panel.setBounds(0, 0, anchoV, altoV);
		contentPane.add(panel);
		this.setResizable(false);
		panel.setFocusable(true);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, altoV, anchoV, altoV+50);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCantidadDeMovimientos = new JLabel("Cantidad de Movimientos:");
		lblCantidadDeMovimientos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCantidadDeMovimientos.setBounds(0, 0, 218, 21);
		panel_1.add(lblCantidadDeMovimientos);
		
		JLabel labelMov = new JLabel("0");
		labelMov.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelMov.setBounds(208, 4, 95, 14);
		tablero.setLabelMov(labelMov);
		panel_1.add(labelMov);
		panel.addKeyListener(this);
		panel_1.addKeyListener(this);
		

		
		for(int j=0;j<alto;j++){
			for(int i=0;i<ancho;i++){
				JButton btn=new JButton();
				btn.setVisible(true);
				btn.setFocusable(false);
				btn.addKeyListener(this);
				btn.setBounds(anchoB*i, altoB*j, anchoB, altoB);
				btn.setLocation(anchoB*i, altoB*j);
				panel.add(btn);
				tablero.agregarBoton(btn, i, j,nombresIm.removeLast());
				
			}
		}
		tablero.hacerInv();
		
	}

	@Override
	public void keyPressed(KeyEvent ev) {

		tablero.capturarEvento(ev);
		tablero.modificarCantMov();
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}


	

