import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;


public class Menu extends JFrame {

	private Panel contentPane;
	private Tablero tabl;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Menu() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 565, 300);
		Image imagenInterna = new ImageIcon(getClass().getResource("imagenFondo.jpg")).getImage();
		contentPane = new Panel(imagenInterna);
	
        
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);
	  
		JButton btnNewButton = new JButton("Facil");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabl=new Tablero(3,3,720,480);
				tabl.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 11, 202, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Dificil");
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabl=new Tablero(5,5,720,460);
				tabl.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(10, 142, 202, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Medio");
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabl=new Tablero(4,4,720,480);
				tabl.setVisible(true);
		
			}
		});
		btnNewButton_2.setBounds(10, 75, 202, 34);
		contentPane.add(btnNewButton_2);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFocusable(false);
		btnSalir.setBounds(461, 225, 88, 35);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnSalir);
		
		JButton btnSpace = new JButton("Espacio");
		btnSpace.setFocusable(false);
		btnSpace.setBounds(396, 17, 129, 23);
		contentPane.add(btnSpace);
		
		JLabel lblMezclar = new JLabel("Para mezclar casillas:");
		lblMezclar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMezclar.setForeground(Color.WHITE);
		lblMezclar.setBounds(250, 16, 129, 25);
		contentPane.add(lblMezclar);
		
		JButton btnNewButton_3 = new JButton("\u2191");
		btnNewButton_3.setFocusable(false);
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setBounds(429, 83, 51, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblParaMoverHacia = new JLabel("Para mover las piezas:");
		lblParaMoverHacia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblParaMoverHacia.setForeground(Color.WHITE);
		lblParaMoverHacia.setBounds(250, 80, 136, 24);
		contentPane.add(lblParaMoverHacia);
		
		JButton btnNewButton_4 = new JButton("\u2193");
		btnNewButton_4.setFocusable(false);
		btnNewButton_4.setBounds(429, 106, 51, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("\u2192");
		btnNewButton_5.setFocusable(false);
		btnNewButton_5.setBounds(478, 106, 51, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("\u2190");
		btnNewButton_6.setFocusable(false);
		btnNewButton_6.setBounds(380, 106, 51, 23);
		contentPane.add(btnNewButton_6);
	}
	
}
