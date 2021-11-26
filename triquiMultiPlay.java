import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class triquiMultiPlay extends JFrame implements ActionListener  {
	

	public static JButton [][] matrizBotones = new JButton [3][3];
	
	
	static Color colorJugador;
	static Color colorJugador2;

	
	static int posibilidadGanarI = 0;
	static int posibilidadGanarJ = 0;
	static int posibilidadTruncarI = 0;
	static int posibilidadTruncarJ = 0;
	static int primerJugada = 0;
	static boolean desact = false;
	static boolean noCentro = false;

	
	static String playerName;
	static String machineName;
	static String difficulty;
	
	static int playerPoints = 0;
	static int machinePoints = 0;
	static int drawPoints = 0;
	
	static JLabel winnerPlayer;
	static JLabel winnerMachine;
	static JLabel draw;
	static JLabel start;
	static JLabel showDifficulty;

	
	
	static boolean ganadorJugador = false;
	static boolean drawPlay = false;
	static int contador = 0;
	
	static JTextField ganador;
	JButton volver;
	static JLabel jugador;
	static JLabel maquina; 
	static JButton esquinaSupIzq;
	static JButton izq;
	static JButton esquinaInfIzq;
	static JButton inf;
	static JButton centro;
	static JButton sup;
	static JButton esquinaSupDer;
	static JButton der;
	static JButton esquinaInfDer;
	static JButton machine;
	static JButton restart;
	public static String figuraJugador = "X";
	public static String figuraJugador2 = "O";
	public static int primerTurno = 0;
	
	public triquiMultiPlay(Color colorJugador, Color colorJugador2, String nombreJugador, String nombreMaquina ) {
		
		
		this.setBounds(100,50,600,800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(500, 100);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		

		triquiMultiPlay.colorJugador = colorJugador;
		triquiMultiPlay.colorJugador2 = colorJugador2;
		triquiMultiPlay.playerName = nombreJugador;
		triquiMultiPlay.machineName = nombreMaquina;

		
		//Etiquetas
		setLayout(null);
		Font font1 = new Font("SanSerif",Font.BOLD, 25);
		Font font2 = new Font(Font.SANS_SERIF, Font.BOLD, 16);
		Font font3 = new Font ("SanSerif", Font.BOLD | Font.ITALIC, 30);

		jugador = new JLabel(playerName+": "+figuraJugador);
		jugador.setBounds(40,120,160,40);
		jugador.setFont(font1);
		jugador.setHorizontalAlignment(JTextField.CENTER);
		add(jugador);
		
		maquina = new JLabel(machineName+": "+figuraJugador2);
		maquina.setBounds(380,120,160,40);
		maquina.setHorizontalAlignment(JTextField.CENTER);
		maquina.setFont(font1);
		add(maquina);
		
		winnerPlayer = new JLabel("Victorias: "+playerPoints);
		winnerPlayer.setBounds(30,150,160,40);
		winnerPlayer.setForeground(colorJugador);
		winnerPlayer.setHorizontalAlignment(JTextField.CENTER);
		winnerPlayer.setFont(font2);
		add(winnerPlayer);
		
		start = new JLabel("Inicia el juego "+playerName);
		start.setBounds(30,50,500,40);
		start.setForeground(colorJugador);
		start.setHorizontalAlignment(JTextField.CENTER);
		start.setFont(font3);
		add(start);
		
		winnerMachine = new JLabel("Victorias: "+machinePoints);
		winnerMachine.setBounds(360,150,160,40);
		winnerMachine.setForeground(colorJugador2);
		winnerMachine.setHorizontalAlignment(JTextField.CENTER);
		winnerMachine.setFont(font2);
		add(winnerMachine);
		
		draw = new JLabel("Empates "+drawPoints);
		draw.setBounds(200,165,160,40);
		draw.setHorizontalAlignment(JTextField.CENTER);
		draw.setFont(font2);
		add(draw);
		
		
		//TextField
		
		ganador = new JTextField("");
		ganador.setBounds(20,540,540,60);
		add(ganador);
		ganador.setEditable(false);
		ganador.setHorizontalAlignment(JTextField.CENTER);
		ganador.setFont(font3);
		ganador.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

		
		//Botones
		
		esquinaSupIzq = new JButton();
		esquinaSupIzq.setBounds(150, 230, 80, 80);
		add(esquinaSupIzq);
		esquinaSupIzq.setFont(font3);
		esquinaSupIzq.addActionListener(this);
        esquinaSupIzq.setBorder(BorderFactory.createLineBorder(Color.black, 5));

		
		sup = new JButton();
		sup.setBounds(240, 230, 80, 80);
		add(sup);
		sup.setFont(font3);
		sup.addActionListener(this);
        sup.setBorder(BorderFactory.createLineBorder(Color.black, 5));

		
		esquinaSupDer = new JButton();
		esquinaSupDer.setBounds(330, 230, 80, 80);
		add(esquinaSupDer);
		esquinaSupDer.setFont(font3);
		esquinaSupDer.addActionListener(this);
        esquinaSupDer.setBorder(BorderFactory.createLineBorder(Color.black, 5));

		
	
		izq = new JButton();
		izq.setBounds(150, 320, 80, 80);
		add(izq);
		izq.setFont(font3);
		izq.addActionListener(this);
        izq.setBorder(BorderFactory.createLineBorder(Color.black, 5));

		
		
		centro = new JButton();
		centro.setBounds(240, 320, 80, 80);
		add(centro);
		centro.setFont(font3);
		centro.addActionListener(this);
        centro.setBorder(BorderFactory.createLineBorder(Color.black, 5));


		
		der = new JButton();
		der.setBounds(330, 320, 80, 80);
		add(der);
		der.setFont(font3);
		der.addActionListener(this);
        der.setBorder(BorderFactory.createLineBorder(Color.black, 5));

		

		esquinaInfIzq = new JButton();
		esquinaInfIzq.setBounds(150, 410, 80, 80);
		add(esquinaInfIzq);		
		esquinaInfIzq.setFont(font3);
		esquinaInfIzq.addActionListener(this);
        esquinaInfIzq.setBorder(BorderFactory.createLineBorder(Color.black, 5));


		inf = new JButton();
		inf.setBounds(240, 410, 80, 80);
		add(inf);
		inf.setFont(font3);
		inf.addActionListener(this);
        inf.setBorder(BorderFactory.createLineBorder(Color.black, 5));


		
		esquinaInfDer = new JButton();
		esquinaInfDer.setBounds(330, 410, 80, 80);
		add(esquinaInfDer);
		esquinaInfDer.setFont(font3);
		esquinaInfDer.addActionListener(this);
        esquinaInfDer.setBorder(BorderFactory.createLineBorder(Color.black, 5));

		
		
		matrizBotones [0][0] = esquinaSupIzq;
		matrizBotones [0][1] = sup;
		matrizBotones [0][2] = esquinaSupDer;
		matrizBotones [1][0] = izq;
		matrizBotones [1][1] = centro;
		matrizBotones [1][2] = der;
		matrizBotones [2][0] = esquinaInfIzq;
		matrizBotones [2][1] = inf;
		matrizBotones [2][2] = esquinaInfDer;

		

		
		volver = new JButton("Volver");
		volver.setBounds(0,0,200,40);
		add(volver);
		volver.setFont(font1);
		volver.addActionListener(this);
		volver.setBackground(Color.DARK_GRAY);
		volver.setForeground(Color.white);
		
		restart = new JButton("Restart");
		restart.setBounds(0,700,600,60);
		add(restart);
		restart.setFont(font1);
		restart.addActionListener(this);

		restart.setBackground(Color.getHSBColor(29, 15, 50));
		restart.setForeground(Color.black);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		
		if (e.getSource() == esquinaSupIzq ) {
			if (esquinaSupIzq.getText().equalsIgnoreCase("")) {
				if (contador == 0) {
					esquinaSupIzq.setForeground(colorJugador);
					esquinaSupIzq.setText(figuraJugador);
					contador++;
					start.setText("Turno de "+machineName);
					start.setForeground(colorJugador2);
					comprobarGanador(figuraJugador);

				}else {
					esquinaSupIzq.setForeground(colorJugador2);
					esquinaSupIzq.setText(figuraJugador2);
					contador--;
					start.setText("Turno de "+playerName);
					start.setForeground(colorJugador);
					comprobarGanador(figuraJugador2);

				}
			}
		}
		
		if (e.getSource() == sup ) {
			if (sup.getText().equalsIgnoreCase("")) {
				if (contador == 0) {
					sup.setForeground(colorJugador);
					sup.setText(figuraJugador);
					contador++;
					start.setText("Turno de "+machineName);
					start.setForeground(colorJugador2);
					comprobarGanador(figuraJugador);

				}else {
					sup.setForeground(colorJugador2);
					sup.setText(figuraJugador2);
					contador--;
					start.setText("Turno de "+playerName);
					start.setForeground(colorJugador);
					comprobarGanador(figuraJugador2);

				}
			}
		}
		
		if (e.getSource() == esquinaSupDer ) {
			if (esquinaSupDer.getText().equalsIgnoreCase("")) {
				if (contador == 0) {
					esquinaSupDer.setForeground(colorJugador);
					esquinaSupDer.setText(figuraJugador);
					contador++;
					start.setText("Turno de "+machineName);
					start.setForeground(colorJugador2);
					comprobarGanador(figuraJugador);

				}else {
					esquinaSupDer.setForeground(colorJugador2);
					esquinaSupDer.setText(figuraJugador2);
					contador--;
					start.setText("Turno de "+playerName);
					start.setForeground(colorJugador);
					comprobarGanador(figuraJugador2);

				}
			}
		}
		
		if (e.getSource() == izq ) {
			if (izq.getText().equalsIgnoreCase("")) {
				if (contador == 0) {
					izq.setForeground(colorJugador);
					izq.setText(figuraJugador);
					contador++;
					start.setText("Turno de "+machineName);
					start.setForeground(colorJugador2);
					comprobarGanador(figuraJugador);

				}else {
					izq.setForeground(colorJugador2);
					izq.setText(figuraJugador2);
					contador--;
					start.setText("Turno de "+playerName);
					start.setForeground(colorJugador);
					comprobarGanador(figuraJugador2);

				}
			}
	
		}
		
		if (e.getSource() == centro ) {
			if (centro.getText().equalsIgnoreCase("")) {
				if (contador == 0) {
					centro.setForeground(colorJugador);
					centro.setText(figuraJugador);
					contador++;
					start.setText("Turno de "+machineName);
					start.setForeground(colorJugador2);
					comprobarGanador(figuraJugador);

				}else {
					centro.setForeground(colorJugador2);
					centro.setText(figuraJugador2);
					contador--;
					start.setText("Turno de "+playerName);
					start.setForeground(colorJugador);
					comprobarGanador(figuraJugador2);

				}
			}

		}
		
		if (e.getSource() == der ) {
			if (der.getText().equalsIgnoreCase("")) {
				if (contador == 0) {
					der.setForeground(colorJugador);
					der.setText(figuraJugador);
					contador++;
					start.setText("Turno de "+machineName);
					start.setForeground(colorJugador2);
					comprobarGanador(figuraJugador);

				}else {
					der.setForeground(colorJugador2);
					der.setText(figuraJugador2);
					contador--;
					start.setText("Turno de "+playerName);
					start.setForeground(colorJugador);
					comprobarGanador(figuraJugador2);

				}	
			}

		}
		
		if (e.getSource() == esquinaInfIzq ) {
			if (esquinaInfIzq.getText().equalsIgnoreCase("")) {
				if (contador == 0) {
					esquinaInfIzq.setForeground(colorJugador);
					esquinaInfIzq.setText(figuraJugador);
					contador++;
					start.setText("Turno de "+machineName);
					start.setForeground(colorJugador2);
					comprobarGanador(figuraJugador);

				}else {
					esquinaInfIzq.setForeground(colorJugador2);
					esquinaInfIzq.setText(figuraJugador2);
					contador--;
					start.setText("Turno de "+playerName);
					start.setForeground(colorJugador);
					comprobarGanador(figuraJugador2);

				}
			}

		}
		
		if (e.getSource() == inf ) {
			if (inf.getText().equalsIgnoreCase("")) {
				if (contador == 0) {
					inf.setForeground(colorJugador);
					inf.setText(figuraJugador);
					contador++;
					start.setText("Turno de "+machineName);
					start.setForeground(colorJugador2);
					comprobarGanador(figuraJugador);

				}else {
					inf.setForeground(colorJugador2);
					inf.setText(figuraJugador2);
					contador--;
					start.setText("Turno de "+playerName);
					start.setForeground(colorJugador);
					comprobarGanador(figuraJugador2);

				}

			}
		}
		
		if (e.getSource() == esquinaInfDer ) {
			if (esquinaInfDer.getText().equalsIgnoreCase("")) {
				if (contador == 0) {
					esquinaInfDer.setForeground(colorJugador);
					esquinaInfDer.setText(figuraJugador);
					contador++;
					start.setText("Turno de "+machineName);
					start.setForeground(colorJugador2);
					comprobarGanador(figuraJugador);

				}else {
					esquinaInfDer.setForeground(colorJugador2);
					esquinaInfDer.setText(figuraJugador2);
					contador--;
					start.setText("Turno de "+playerName);
					start.setForeground(colorJugador);
					comprobarGanador(figuraJugador2);

				}
			}
		}
		
		
		if (e.getSource() == restart ) {
			reiniciar();
		}
		
		if(e.getSource() == volver){
			triquiMulti maquina = new triquiMulti();
			maquina.setVisible(true);
			this.setVisible(false);
		}
	}
	
	public static void reiniciar() {
		ganador.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		matrizBotones [0][0].setText("");
		matrizBotones [0][1].setText("");
		matrizBotones [0][2].setText("");
		matrizBotones [1][0].setText("");
		matrizBotones [1][1].setText("");
		matrizBotones [1][2].setText("");
		matrizBotones [2][0].setText("");
		matrizBotones [2][1].setText("");
		matrizBotones [2][2].setText("");
		ganador.setText("");
		primerJugada = 0;
        for (int i = 0; i < matrizBotones.length; i++) {
			for (int j = 0; j < matrizBotones.length; j++) {
				matrizBotones[i][j].setEnabled(true);
		        matrizBotones[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
			}
		}
		
		desact = false;
		ganadorJugador = false;
		drawPlay = false;
		noCentro = false;
		
		if (primerTurno == 0) {
			primerTurno = 1;
			figuraJugador = "O";
			figuraJugador2 = "X";
			contador = 1;
			start.setForeground(colorJugador2);
			start.setText("Inicia el juego "+machineName);

		}else if(primerTurno == 1) {
			start.setForeground(colorJugador);
			start.setText("Inicia el juego "+playerName);
			figuraJugador = "X";
			figuraJugador2 = "O";
			primerTurno = 0;
			contador = 0;
		}
		
		jugador.setText(playerName+": "+figuraJugador);
		maquina.setText(machineName+": "+figuraJugador2);
	}
	
	public static void comprobarGanador(String figura) {

		if (ganadorJugador == false && matrizBotones[0][0].getText().contentEquals(figura)
				&& matrizBotones[1][1].getText().contentEquals(figura)
				&& matrizBotones[2][2].getText().contentEquals(figura)) {
			condecorarGanador(matrizBotones[0][0],matrizBotones[1][1],matrizBotones[2][2]);
			ganadorJugador = true;
		}

		if (ganadorJugador == false && matrizBotones[0][2].getText().contentEquals(figura)
				&& matrizBotones[1][1].getText().contentEquals(figura)
				&& matrizBotones[2][0].getText().contentEquals(figura)) {
			condecorarGanador(matrizBotones[0][2],matrizBotones[1][1],matrizBotones[2][0]);
			ganadorJugador = true;
		}

		if (ganadorJugador == false && matrizBotones[0][0].getText().contentEquals(figura)
				&& matrizBotones[0][1].getText().contentEquals(figura)
				&& matrizBotones[0][2].getText().contentEquals(figura)) {
			condecorarGanador(matrizBotones[0][0],matrizBotones[0][1],matrizBotones[0][2]);
			ganadorJugador = true;
		}

		if (ganadorJugador == false && matrizBotones[1][0].getText().contentEquals(figura)
				&& matrizBotones[1][1].getText().contentEquals(figura)
				&& matrizBotones[1][2].getText().contentEquals(figura)) {
			condecorarGanador(matrizBotones[1][0],matrizBotones[1][1],matrizBotones[1][2]);

			ganadorJugador = true;
		}

		if (ganadorJugador == false && matrizBotones[2][0].getText().contentEquals(figura)
				&& matrizBotones[2][1].getText().contentEquals(figura)
				&& matrizBotones[2][2].getText().contentEquals(figura)) {
			condecorarGanador(matrizBotones[2][0],matrizBotones[2][1],matrizBotones[2][2]);
			ganadorJugador = true;
			
		}

		if (ganadorJugador == false && matrizBotones[0][0].getText().contentEquals(figura)
				&& matrizBotones[1][0].getText().contentEquals(figura)
				&& matrizBotones[2][0].getText().contentEquals(figura)) {
			condecorarGanador(matrizBotones[0][0],matrizBotones[1][0],matrizBotones[2][0]);

			ganadorJugador = true;
			
			
		}

		if (ganadorJugador == false && matrizBotones[0][1].getText().contentEquals(figura)
				&& matrizBotones[1][1].getText().contentEquals(figura)
				&& matrizBotones[2][1].getText().contentEquals(figura)) {
			condecorarGanador(matrizBotones[0][1],matrizBotones[1][1],matrizBotones[2][1]);
			ganadorJugador = true;
		}
		
		if (ganadorJugador == false && matrizBotones[0][2].getText().contentEquals(figura)
				&& matrizBotones[1][2].getText().contentEquals(figura)
				&& matrizBotones[2][2].getText().contentEquals(figura)) {
			condecorarGanador(matrizBotones[0][2],matrizBotones[1][2],matrizBotones[2][2]);
			ganadorJugador = true;
		}
		
		
		if (!ganadorJugador && !drawPlay) {
			int contador = 0;
			for (int i = 0; i < matrizBotones.length; i++) {
				for (int j = 0; j < matrizBotones.length; j++) {
					if (matrizBotones[i][j].getText().equalsIgnoreCase("")) {
						contador++;
					}
				}
			}
			
			if (contador == 0) {
				drawPlay = true;
				condecorarGanador(null,null,null);
				
			}
		}


	}
	
	public static void condecorarGanador(JButton ganador1, JButton ganador2, JButton ganador3) {
		if (drawPlay) {
			start.setText("");
			ganador.setText("Ha ocurrido un empate!");
			drawPoints++;
			draw.setText("Empates: "+drawPoints);
		}else {
			start.setText("");
	        ganador1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
	        ganador2.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
	        ganador3.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
	        
	        
	        if (ganador1.getText().contentEquals(figuraJugador)) {	        	
	        	playerPoints++;
				winnerPlayer.setText("Victorias: "+playerPoints);
	        	ganador.setText("El ganador es "+playerName);
				ganador.setBorder(BorderFactory.createLineBorder(colorJugador, 5));

			}
	        else if (ganador1.getText().equalsIgnoreCase(figuraJugador2)) {
				machinePoints++;
				winnerMachine.setText("Victorias: "+machinePoints);
	        	ganador.setText("El ganador es "+machineName);
				ganador.setBorder(BorderFactory.createLineBorder(colorJugador2, 5));
				
			}
		}
		
        
        
        for (int i = 0; i < matrizBotones.length; i++) {
			for (int j = 0; j < matrizBotones.length; j++) {
				matrizBotones[i][j].setEnabled(false);
			}
		}
        

	}
	
	
	
	



}