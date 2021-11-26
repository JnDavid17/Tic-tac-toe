import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;

public class triquiMachine extends JFrame implements ActionListener  {
	JLabel eleccion, nombre, nombreRobot, dificultad;
	JComboBox<String> dificultadBox;
	JButton volver, jugar;
	JTextField nombrePersona, nombreRobotField;
	JColorChooser color;
	
	public triquiMachine() {
		
		this.setBounds(100,50,850,700);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(500, 100);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		
		//Etiquetas
		setLayout(null);

		Font font1 = new Font("SansSerif",Font.BOLD, 19);
		Font font2 = new Font("SansSerif",Font.BOLD, 29);

		eleccion = new JLabel("Que color desea elegir");
		eleccion.setBounds(85,175,500,50);
		eleccion.setFont(font2);
		add(eleccion);


		nombre = new JLabel("Cuál es su nombre?");
		nombre.setBounds(560,110,300,50);
		nombre.setFont(font1);
		add(nombre);
		
		dificultad = new JLabel("Que dificultad desea?");
		dificultad.setBounds(555,400,300,50);
		dificultad.setFont(font1);
		add(dificultad);
		
		nombreRobot = new JLabel("Nombre para el contricante");
		nombreRobot.setBounds(535,250,300,50);
		nombreRobot.setFont(font1);
		add(nombreRobot);
		
		
		//Botones
		
		volver = new JButton("Volver");
		volver.setBounds(0,0,100,40);
		add(volver);
		volver.setFont(font1);
		volver.addActionListener(this);
		volver.setBackground(Color.getHSBColor(29, 15, 50));
		volver.setForeground(Color.black);
		
		jugar = new JButton("Jugar");
		jugar.setBounds(0,610,850,50);
		add(jugar);
		jugar.setFont(font1);
		jugar.addActionListener(this);
		jugar.setBackground(Color.DARK_GRAY);
		jugar.setForeground(Color.white);
		
		//Choose
		
		color = new JColorChooser();
		color.setBounds(0,250,500,300);
		add(color);
		
		//Text field
		nombrePersona = new JTextField();
		nombrePersona.setBounds(550,160,220,30);
		add(nombrePersona);
		nombrePersona.setHorizontalAlignment(JTextField.CENTER);

		nombreRobotField = new JTextField();
		nombreRobotField.setBounds(550,300,220,30);
		add(nombreRobotField);
		nombreRobotField.setHorizontalAlignment(JTextField.CENTER);
		
		//Combo
		dificultadBox = new JComboBox<String>();
		dificultadBox.setBounds(535,445,280,40);
		dificultadBox.setFont(font1);
		add(dificultadBox);
		dificultadBox.addItem("Facil");
		dificultadBox.addItem("Normal");
		dificultadBox.addItem("Dificil");
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
			Color compare2 = new Color(0,153,153);
			
			if (compare.getRGB() == compare2.getRGB()) {
	            JOptionPane.showMessageDialog(null, "El color elegido se puede confundir con el de la maquina, elija otro color, por favor");
			}else if(nombrePersona.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null, "El campo del nombre se encuentra vacio, por favor llénelo");
			}else if(nombreRobotField.getText().equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null, "El campo del nombre del contricante se encuentra vacio, por favor llénelo");
			}
			
			else {
				triquiMachinePlay maquinaPlay = new triquiMachinePlay(color.getColor(), nombrePersona.getText(), nombreRobotField.getText(), (String) dificultadBox.getSelectedItem());
				maquinaPlay.setVisible(true);
				this.setVisible(false);
			}

		}
	}
}
