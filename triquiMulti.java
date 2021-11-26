import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;

public class triquiMulti extends JFrame implements ActionListener  {
	JLabel eleccion, nombre, nombreRobot, dificultad, eleccion2;
	JComboBox<String> dificultadBox;
	JButton volver, jugar;
	JTextField nombrePersona, nombreRobotField;
	JColorChooser color, color2;
	JLabel line;
	
	public triquiMulti() {
		
		this.setBounds(100,50,1250,700);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(500, 100);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		
		//Etiquetas
		setLayout(null);		
		
		Font font1 = new Font("SansSerif",Font.BOLD, 19);
		Font font2 = new Font("SansSerif",Font.BOLD, 29);

		eleccion = new JLabel("Que color desea elegir el jugador 1");
		eleccion.setBounds(25,175,500,50);
		eleccion.setFont(font2);
		add(eleccion);
		
		eleccion2 = new JLabel("Que color desea elegir el jugador 2");
		eleccion2.setBounds(705,175,500,50);
		eleccion2.setFont(font2);
		add(eleccion2);


		nombre = new JLabel("Cuál es su nombre?");
		nombre.setBounds(120,70,300,50);
		nombre.setFont(font1);
		add(nombre);
		
		
		nombreRobot = new JLabel("Nombre para el segundo jugador");
		nombreRobot.setBounds(765,70,320,50);
		nombreRobot.setFont(font1);
		add(nombreRobot);
		
		
		//Botones
		
		volver = new JButton("Volver");
		volver.setBounds(0,0,100,40);
		add(volver);
		volver.setFont(font1);
		volver.addActionListener(this);
		volver.setBackground(Color.DARK_GRAY);
		volver.setForeground(Color.white);
		
		jugar = new JButton("Jugar");
		jugar.setBounds(0,610,1250,50);
		add(jugar);
		jugar.setFont(font1);
		jugar.addActionListener(this);
		jugar.setBackground(Color.getHSBColor(29, 15, 50));
		jugar.setForeground(Color.black);
		jugar.setHorizontalAlignment(JButton.CENTER);

		
		//Choose
		
		color = new JColorChooser();
		color.setBounds(0,250,500,300);
		add(color);
		color2 = new JColorChooser();
		color2.setBounds(700,250,500,300);
		add(color2);
		
		//Text field
		nombrePersona = new JTextField();
		nombrePersona.setBounds(100,115,220,30);
		add(nombrePersona);
		nombrePersona.setHorizontalAlignment(JTextField.CENTER);

		nombreRobotField = new JTextField();
		nombreRobotField.setBounds(810,115,220,30);
		add(nombreRobotField);
		nombreRobotField.setHorizontalAlignment(JTextField.CENTER);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == volver ) {
			
			
			String [] auxArg = new String [1];
			triqui maquina = new triqui();
			maquina.main(auxArg);
			this.setVisible(false);
		}
		
		if(e.getSource() == jugar) {
			
			Color compare = color.getColor();
			Color compare2 = color2.getColor();
			
			if (compare.getRGB() == compare2.getRGB()) {
	            JOptionPane.showMessageDialog(null, "El color no puede ser el mismo en ambos jugadores");
			}else if(nombrePersona.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null, "El campo del nombre se encuentra vacio, por favor llénelo");
			}else if(nombreRobotField.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null, "El campo del nombre del contricante se encuentra vacio, por favor llénelo");
			}
			
			else {
				triquiMultiPlay maquinaPlay = new triquiMultiPlay(color.getColor(), color2.getColor(), nombrePersona.getText(), nombreRobotField.getText());
				maquinaPlay.setVisible(true);
				this.setVisible(false);
			}

		}
	}
}
