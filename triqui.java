import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class triqui extends JFrame implements ActionListener {
	public int contador = 20;
	JLabel eleccion;
	JButton machine, player2 ;
	public static void main(String[] args) {
		triqui grafico = new triqui();
		grafico.setBounds(100,50,400,500);
		grafico.setVisible(true);
		grafico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		grafico.setLocation(500, 100);
		grafico.setLocationRelativeTo(null);
		grafico.setResizable(false);
	}
	
	public triqui() {
		
		//Etiquetas
		setLayout(null);

		Font font1 = new Font("SansSerif",Font.BOLD, 29);
		
		eleccion = new JLabel("Elija el modo de juego");
		eleccion.setBounds(45,125,400,50);
		eleccion.setFont(font1);
		
		add(eleccion);
		
		
		//Botones
		machine = new JButton ("Solitario");
		machine.setBounds(10,250,180,80);
		add(machine);
		machine.setFont(font1);
		machine.addActionListener(this);
		machine.setBackground(Color.DARK_GRAY);
		machine.setForeground(Color.white);
		
		player2 = new JButton ("Multi");
		player2.setBounds(198,250,180,80);
		add(player2);
		player2.setFont(font1);
		player2.addActionListener(this);
		player2.setBackground(Color.getHSBColor(29, 15, 50));
		
		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == machine ) {
			triquiMachine maquina = new triquiMachine();
			maquina.setVisible(true);
			this.setVisible(false);
		}
		
		if (e.getSource() == player2) {
			triquiMulti maquinaMulti = new triquiMulti();
			maquinaMulti.setVisible(true);
			this.setVisible(false);
		}
		
	}
}
