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

public class triquiMachinePlay extends JFrame implements ActionListener  {
	

	public static JButton [][] matrizBotones = new JButton [3][3];
	
	
	static Color colorJugador;
	static Color colorMaquina = new Color(0,153,153);

	
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
	public static String figuraMaquina = "O";
	public static int primerTurno = 0;
	
	public triquiMachinePlay(Color colorJugador, String nombreJugador, String nombreMaquina, String dificultad) {
		
		
		this.setBounds(100,50,600,800);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(500, 100);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		

		triquiMachinePlay.colorJugador = colorJugador;
		triquiMachinePlay.playerName = nombreJugador;
		triquiMachinePlay.machineName = nombreMaquina;
		triquiMachinePlay.difficulty = dificultad;

		
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
		
		maquina = new JLabel(machineName+": "+figuraMaquina);
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
		
		start = new JLabel("Inicia el juego: "+playerName);
		start.setBounds(30,50,500,40);
		start.setForeground(colorJugador);
		start.setHorizontalAlignment(JTextField.CENTER);
		start.setFont(font3);
		add(start);
		
		winnerMachine = new JLabel("Victorias: "+machinePoints);
		winnerMachine.setBounds(360,150,160,40);
		winnerMachine.setForeground(colorMaquina);
		winnerMachine.setHorizontalAlignment(JTextField.CENTER);
		winnerMachine.setFont(font2);
		add(winnerMachine);
		
		draw = new JLabel("Empates "+drawPoints);
		draw.setBounds(200,165,160,40);
		draw.setHorizontalAlignment(JTextField.CENTER);
		draw.setFont(font2);
		add(draw);
		
		showDifficulty = new JLabel("Dificultad actual: "+difficulty);
		showDifficulty.setBounds(40,640,500,40);
		showDifficulty.setHorizontalAlignment(JTextField.CENTER);
		showDifficulty.setFont(font3);
		add(showDifficulty);
		
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
		volver.setBounds(0,0,200,30);
		add(volver);
		volver.setFont(font1);
		volver.addActionListener(this);
		volver.setBackground(Color.getHSBColor(29, 15, 50));
		volver.setForeground(Color.black);
		
		restart = new JButton("Restart");
		restart.setBounds(0,700,600,60);
		add(restart);
		restart.setFont(font1);
		restart.addActionListener(this);
		restart.setBackground(Color.DARK_GRAY);
		restart.setForeground(Color.white);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		
		


		
		if (e.getSource() == esquinaSupIzq ) {
			if (esquinaSupIzq.getText().equalsIgnoreCase("")) {
				esquinaSupIzq.setText(figuraJugador);
				esquinaSupIzq.setForeground(colorJugador);
				comprobarGanador(figuraJugador);
				proceso();
			}
		}
		
		if (e.getSource() == sup ) {
			if (sup.getText().equalsIgnoreCase("")) {
				sup.setText(figuraJugador);
				sup.setForeground(colorJugador);
				comprobarGanador(figuraJugador);
				proceso();
			}
		}
		
		if (e.getSource() == esquinaSupDer ) {
			if (esquinaSupDer.getText().equalsIgnoreCase("")) {
				esquinaSupDer.setText(figuraJugador);
				esquinaSupDer.setForeground(colorJugador);
				comprobarGanador(figuraJugador);
				proceso();

			}
		}
		
		if (e.getSource() == izq ) {
			if (izq.getText().equalsIgnoreCase("")) {
				izq.setText(figuraJugador);
				izq.setForeground(colorJugador);
				comprobarGanador(figuraJugador);
				proceso();

			}
		}
		
		if (e.getSource() == centro ) {
			if (centro.getText().equalsIgnoreCase("")) {
				centro.setText(figuraJugador);
				centro.setForeground(colorJugador);
				comprobarGanador(figuraJugador);
				proceso();

			}
		}
		
		if (e.getSource() == der ) {
			if (der.getText().equalsIgnoreCase("")) {
				der.setText(figuraJugador);
				der.setForeground(colorJugador);
				comprobarGanador(figuraJugador);
				proceso();

			}		
		}
		
		if (e.getSource() == esquinaInfIzq ) {
			if (esquinaInfIzq.getText().equalsIgnoreCase("")) {
				esquinaInfIzq.setText(figuraJugador);
				esquinaInfIzq.setForeground(colorJugador);
				comprobarGanador(figuraJugador);
				proceso();

			}
		}
		
		if (e.getSource() == inf ) {
			if (inf.getText().equalsIgnoreCase("")) {
				inf.setText(figuraJugador);
				inf.setForeground(colorJugador);
				comprobarGanador(figuraJugador);
				proceso();

			}
		}
		
		if (e.getSource() == esquinaInfDer ) {
			if (esquinaInfDer.getText().equalsIgnoreCase("")) {
				esquinaInfDer.setText(figuraJugador);
				esquinaInfDer.setForeground(colorJugador);
				comprobarGanador(figuraJugador);
				proceso();
			}
		}
		
		
		if (e.getSource() == restart ) {
			reiniciar();
		}
		
		if(e.getSource() == volver){
			triquiMachine maquina = new triquiMachine();
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
			figuraMaquina = "X";
			start.setForeground(colorMaquina);
			start.setText("Inicia el juego: "+machineName);
			proceso();

		}else if(primerTurno == 1) {
			start.setForeground(colorJugador);
			start.setText("Inicia el juego: "+playerName);
			figuraJugador = "X";
			figuraMaquina = "O";
			primerTurno = 0;
			
		}
		
		jugador.setText(playerName+": "+figuraJugador);
		maquina.setText(machineName+": "+figuraMaquina);
	}
	
	public static void proceso() {
		matrizBotones [0][0] = esquinaSupIzq;
		matrizBotones [0][1] = sup;
		matrizBotones [0][2] = esquinaSupDer;
		matrizBotones [1][0] = izq;
		matrizBotones [1][1] = centro;
		matrizBotones [1][2] = der;
		matrizBotones [2][0] = esquinaInfIzq;
		matrizBotones [2][1] = inf;
		matrizBotones [2][2] = esquinaInfDer;
		
		int aleatorio;

		int aleatorio2; 
		
		//Intentar truncar jugadas
		
		boolean search = false;
		
		search = quitarJugadas(matrizBotones);
		
		boolean searchWin = false;

		posibilidadGanarI = 0;
		posibilidadGanarJ = 0;
		if (desact == true) {
			desact = false;
			primerJugada++;
		}else {
			primerJugada++;
		
			//Jugadas posibles
			
			//Posibilidad 2,2
				if (matrizBotones[2][2].getText().equalsIgnoreCase("")&& matrizBotones[1][1].getText().equalsIgnoreCase(figuraMaquina) && matrizBotones[0][0].getText().equalsIgnoreCase(figuraMaquina)) {
									
					posibilidadGanarI = 2;
					posibilidadGanarJ = 2;
					searchWin = true;
					
				}else if(matrizBotones[2][2].getText().equalsIgnoreCase("")&& matrizBotones[1][2].getText().equalsIgnoreCase(figuraMaquina) && matrizBotones[0][2].getText().equalsIgnoreCase(figuraMaquina)) {

					posibilidadGanarI = 2;
					posibilidadGanarJ = 2;
					searchWin = true;
					
				}else if(matrizBotones[2][2].getText().equalsIgnoreCase("")&& matrizBotones[2][1].getText().equalsIgnoreCase(figuraMaquina) && matrizBotones[2][0].getText().equalsIgnoreCase(figuraMaquina)) {
					
					posibilidadGanarI = 2;
					posibilidadGanarJ = 2;
					searchWin = true;
					
				}

			//Posibilidad 1,2
			else if (matrizBotones[1][2].getText().equalsIgnoreCase("")&&  matrizBotones[1][1].getText().equalsIgnoreCase(figuraMaquina) && matrizBotones[1][0].getText().equalsIgnoreCase(figuraMaquina)) {
					
					posibilidadGanarI = 1;
					posibilidadGanarJ = 2;
					searchWin = true;
					
				}else if(matrizBotones[1][2].getText().equalsIgnoreCase("")&& matrizBotones[0][2].getText().equalsIgnoreCase(figuraMaquina) && matrizBotones[2][2].getText().equalsIgnoreCase(figuraMaquina)) {
					
					posibilidadGanarI = 1;
					posibilidadGanarJ = 2;
					searchWin = true;
					
				}
			
			// Posibilidad 0,2
			else if (matrizBotones[0][2].getText().equalsIgnoreCase("")&& matrizBotones[1][1].getText().equalsIgnoreCase(figuraMaquina) && matrizBotones[2][0].getText().equalsIgnoreCase(figuraMaquina)) {
				
				posibilidadGanarI = 0;
				posibilidadGanarJ = 2;
				searchWin = true;
				
				}else if(matrizBotones[0][2].getText().equalsIgnoreCase("")&& matrizBotones[0][1].getText().equalsIgnoreCase(figuraMaquina) && matrizBotones[0][0].getText().equalsIgnoreCase(figuraMaquina)) {
				
					posibilidadGanarI = 0;
					posibilidadGanarJ = 2;
					searchWin = true;
					
				}else if(matrizBotones[0][2].getText().equalsIgnoreCase("")&& matrizBotones[1][2].getText().equalsIgnoreCase(figuraMaquina) && matrizBotones[2][2].getText().equalsIgnoreCase(figuraMaquina)) {
				
					posibilidadGanarI = 0;
					posibilidadGanarJ = 2;
					searchWin = true;
					
				}
			
			
			// Posibilidad 0,1
			
			else if (matrizBotones[0][1].getText().equalsIgnoreCase("")&& matrizBotones[0][2].getText().equalsIgnoreCase(figuraMaquina) && matrizBotones[0][0].getText().equalsIgnoreCase(figuraMaquina)) {
			
				posibilidadGanarI = 0;
				posibilidadGanarJ = 1;
				searchWin = true;
				
			}else if(matrizBotones[0][1].getText().equalsIgnoreCase("")&& matrizBotones[1][1].getText().equalsIgnoreCase(figuraMaquina) && matrizBotones[2][1].getText().equalsIgnoreCase(figuraMaquina)) {
				
				posibilidadGanarI = 0;
				posibilidadGanarJ = 1;
				searchWin = true;
				
			}
			
			
			//Posibilidad 0,0
			
			else if (matrizBotones[0][0].getText().equalsIgnoreCase("")&& matrizBotones[1][1].getText().equalsIgnoreCase(figuraMaquina) && matrizBotones[2][2].getText().equalsIgnoreCase(figuraMaquina)) {
				searchWin = true;
				}else if(matrizBotones[0][0].getText().equalsIgnoreCase("")&& matrizBotones[0][1].getText().equalsIgnoreCase(figuraMaquina) && matrizBotones[0][2].getText().equalsIgnoreCase(figuraMaquina)) {
					searchWin = true;
				}else if(matrizBotones[0][0].getText().equalsIgnoreCase("")&& matrizBotones[1][0].getText().equalsIgnoreCase(figuraMaquina) && matrizBotones[2][0].getText().equalsIgnoreCase(figuraMaquina)) {
					searchWin = true;
				}
			
			
			//Posibilidad 1,0
			else if (matrizBotones[1][0].getText().equalsIgnoreCase("") && matrizBotones[1][1].getText().equalsIgnoreCase(figuraMaquina) && matrizBotones[1][2].getText().equalsIgnoreCase(figuraMaquina)) {
				
				posibilidadGanarI = 1;
				posibilidadGanarJ = 0;
				searchWin = true;
				
			}else if(matrizBotones[1][0].getText().equalsIgnoreCase("") && matrizBotones[0][0].getText().equalsIgnoreCase(figuraMaquina) && matrizBotones[2][0].getText().equalsIgnoreCase(figuraMaquina)) {
				
				posibilidadGanarI = 1;
				posibilidadGanarJ = 0;
				searchWin = true;
				
			}
		
			
			//Posibilidad 2,0
			else if (matrizBotones[2][0].getText().equalsIgnoreCase("")&& matrizBotones[1][1].getText().equalsIgnoreCase(figuraMaquina) && matrizBotones[0][2].getText().equalsIgnoreCase(figuraMaquina)) {
				
				posibilidadGanarI = 2;
				posibilidadGanarJ = 0;
				searchWin = true;
				
			}else if(matrizBotones[2][0].getText().equalsIgnoreCase("")&& matrizBotones[1][0].getText().equalsIgnoreCase(figuraMaquina) && matrizBotones[0][0].getText().equalsIgnoreCase(figuraMaquina)) {
				
				posibilidadGanarI = 2;
				posibilidadGanarJ = 0;
				searchWin = true;
				
			}else if(matrizBotones[2][0].getText().equalsIgnoreCase("")&& matrizBotones[2][1].getText().equalsIgnoreCase(figuraMaquina) && matrizBotones[2][2].getText().equalsIgnoreCase(figuraMaquina)) {
				
				posibilidadGanarI = 2;
				posibilidadGanarJ = 0;
				searchWin = true;
				
			}
			
			
			// Posibilidad 2,1
			
			else if (matrizBotones[2][1].getText().equalsIgnoreCase("")&& matrizBotones[2][0].getText().equalsIgnoreCase(figuraMaquina) && matrizBotones[2][2].getText().equalsIgnoreCase(figuraMaquina)) {
				
				posibilidadGanarI = 2;
				posibilidadGanarJ = 1;
				searchWin = true;
				
			}else if(matrizBotones[2][1].getText().equalsIgnoreCase("")&& matrizBotones[1][1].getText().equalsIgnoreCase(figuraMaquina) && matrizBotones[0][1].getText().equalsIgnoreCase(figuraMaquina)) {
				
				posibilidadGanarI = 2;
				posibilidadGanarJ = 1;
				searchWin = true;
				
			}
			
			
			//Posibilidad 1,1
			
			else if (matrizBotones[1][1].getText().equalsIgnoreCase("")&& matrizBotones[0][1].getText().equalsIgnoreCase(figuraMaquina) && matrizBotones[2][1].getText().equalsIgnoreCase(figuraMaquina)) {
				
				posibilidadGanarI = 1;
				posibilidadGanarJ = 1;
				searchWin = true;
				
			}else if(matrizBotones[1][1].getText().equalsIgnoreCase("")&& matrizBotones[1][0].getText().equalsIgnoreCase(figuraMaquina) && matrizBotones[1][2].getText().equalsIgnoreCase(figuraMaquina)) {
				
				posibilidadGanarI = 1;
				posibilidadGanarJ = 1;
				searchWin = true;
				
			}else if(matrizBotones[1][1].getText().equalsIgnoreCase("")&& matrizBotones[0][2].getText().equalsIgnoreCase(figuraMaquina) && matrizBotones[2][0].getText().equalsIgnoreCase(figuraMaquina)) {
				
				posibilidadGanarI = 1;
				posibilidadGanarJ = 1;
				searchWin = true;
				
			}else if(matrizBotones[1][1].getText().equalsIgnoreCase("")&& matrizBotones[0][0].getText().equalsIgnoreCase(figuraMaquina) && matrizBotones[2][2].getText().equalsIgnoreCase(figuraMaquina)) {
				
				posibilidadGanarI = 1;
				posibilidadGanarJ = 1;
				searchWin = true;
				
			}
			
				
			if (difficulty.equalsIgnoreCase("Facil")) {
				searchWin = false;
			}	
			
			if (!searchWin && !search && ganadorJugador == false) {
				
				int contador = 0;
				
				
				boolean terminado = false;
				
				while (terminado == false) {
					
					aleatorio = (int) Math.floor(Math.random()*3);
					aleatorio2 = (int) Math.floor(Math.random()*3);
					
					
					
					
					if (matrizBotones[aleatorio][aleatorio2].getText().equalsIgnoreCase("")) {
						matrizBotones[aleatorio][aleatorio2].setForeground(colorMaquina);
						matrizBotones[aleatorio][aleatorio2].setText(figuraMaquina);
						terminado = true;
					}else {
						contador++;
					}
					
					if (contador>20) {
						terminado = true;
					}
					


				}
			}
				
				if (searchWin && search && ganadorJugador == false) {

					matrizBotones[posibilidadGanarI][posibilidadGanarJ].setForeground(colorMaquina);
					matrizBotones[posibilidadGanarI][posibilidadGanarJ].setText(figuraMaquina);
					
				}else if(searchWin && !search && ganadorJugador == false){
					
					matrizBotones[posibilidadGanarI][posibilidadGanarJ].setForeground(colorMaquina);
					matrizBotones[posibilidadGanarI][posibilidadGanarJ].setText(figuraMaquina);
					
				}else if(!searchWin && search && ganadorJugador == false) {
					matrizBotones[posibilidadTruncarI][posibilidadTruncarJ].setForeground(colorMaquina);
					matrizBotones[posibilidadTruncarI][posibilidadTruncarJ].setText(figuraMaquina);
				}
				
				comprobarGanador(figuraMaquina);
		}
			
			
		}
		
		
		

			
		

	
	public static boolean quitarJugadas(JButton matrizBotones[][]) {
		
		int posibilidad = (int) Math.floor(Math.random()*2);
		boolean encontrado = false;
		posibilidadTruncarI = 0;
		posibilidadTruncarJ = 0;
		
		
		if (difficulty.equalsIgnoreCase("Facil")) {
			return false;
		}else if(difficulty.equalsIgnoreCase("Dificil")) {
			posibilidad = 0;
			if (primerJugada == 0) {
				if (matrizBotones[1][1].getText().equalsIgnoreCase("")) {
					matrizBotones[1][1].setForeground(colorMaquina);
					matrizBotones[1][1].setText(figuraMaquina);

					encontrado = true;
					desact = true;
				}else if (matrizBotones[0][0].getText().equalsIgnoreCase("")){
					
					matrizBotones[0][0].setForeground(colorMaquina);
					matrizBotones[0][0].setText(figuraMaquina);
					encontrado = true;
					noCentro = true;
					desact = true;
				}
				else {
					encontrado = false;
				}
			}else if(primerJugada == 1){
				if(matrizBotones[1][2].getText().equalsIgnoreCase(figuraJugador) && matrizBotones[2][2].getText().equalsIgnoreCase(figuraJugador)) {
					matrizBotones[0][2].setForeground(colorMaquina);
					matrizBotones[0][2].setText(figuraMaquina);
					encontrado = true;
					desact = true;
				}else if(matrizBotones[1][0].getText().equalsIgnoreCase(figuraJugador) && matrizBotones[2][0].getText().equalsIgnoreCase(figuraJugador)) {
					matrizBotones[0][0].setForeground(colorMaquina);
					matrizBotones[0][0].setText(figuraMaquina);
					encontrado = true;
					desact = true;
				}else if(matrizBotones[0][2].getText().equalsIgnoreCase(figuraJugador) && matrizBotones[1][2].getText().equalsIgnoreCase(figuraJugador)) {
					matrizBotones[2][2].setForeground(colorMaquina);
					matrizBotones[2][2].setText(figuraMaquina);
					encontrado = true;
					desact = true;
				}else if(matrizBotones[0][0].getText().equalsIgnoreCase(figuraJugador) && matrizBotones[1][0].getText().equalsIgnoreCase(figuraJugador)) {
					matrizBotones[2][0].setForeground(colorMaquina);
					matrizBotones[2][0].setText(figuraMaquina);
					encontrado = true;
					desact = true;
				}else if(matrizBotones[1][0].getText().equalsIgnoreCase(figuraJugador) && noCentro == false) {
					if (matrizBotones[2][2].getText().equalsIgnoreCase(figuraJugador)) {
						matrizBotones[2][0].setForeground(colorMaquina);
						matrizBotones[2][0].setText(figuraMaquina);
					}else {
						matrizBotones[2][2].setForeground(colorMaquina);
						matrizBotones[2][2].setText(figuraMaquina);
					}
					encontrado = true;
					desact = true;
				}else if(matrizBotones[1][2].getText().equalsIgnoreCase(figuraJugador) && noCentro == false) {
					if (matrizBotones[2][0].getText().equalsIgnoreCase(figuraJugador)) {
						matrizBotones[2][2].setForeground(colorMaquina);
						matrizBotones[2][2].setText(figuraMaquina);
					}else {
						matrizBotones[2][0].setForeground(colorMaquina);
						matrizBotones[2][0].setText(figuraMaquina);
					}
					encontrado = true;
					desact = true;
				}else {
					desact = false;
				}
			}
		}else if(difficulty.equalsIgnoreCase("Normal")) {
			encontrado = false;
		}
		
		

		if (encontrado == false && posibilidad == 0) {
			// Bloquear esquina 0,0
			if (matrizBotones[0][0].getText().equalsIgnoreCase("") && encontrado == false) {
				if (matrizBotones[0][1].getText().equalsIgnoreCase(figuraJugador)
						&& matrizBotones[0][2].getText().equalsIgnoreCase(figuraJugador)) {

					encontrado = true;
				} else if (matrizBotones[1][0].getText().equalsIgnoreCase(figuraJugador)
						&& matrizBotones[2][0].getText().equalsIgnoreCase(figuraJugador)) {
					
					encontrado = true;
				} else if (matrizBotones[1][1].getText().equalsIgnoreCase(figuraJugador)
						&& matrizBotones[2][2].getText().equalsIgnoreCase(figuraJugador)) {
					
					encontrado = true;
				}
			}
	

			
			//Bloquear esquina 0,2
			if (matrizBotones[0][2].getText().equalsIgnoreCase("") && encontrado == false) {
				if (matrizBotones[0][1].getText().equalsIgnoreCase(figuraJugador)
						&& matrizBotones[0][0].getText().equalsIgnoreCase(figuraJugador)) {
					
					posibilidadTruncarI = 0;
					posibilidadTruncarJ = 2;
					encontrado = true;
				} else if (matrizBotones[1][2].getText().equalsIgnoreCase(figuraJugador)
						&& matrizBotones[2][2].getText().equalsIgnoreCase(figuraJugador)) {
					
					posibilidadTruncarI = 0;
					posibilidadTruncarJ = 2;
					encontrado = true;
				} else if (matrizBotones[1][1].getText().equalsIgnoreCase(figuraJugador)
						&& matrizBotones[2][0].getText().equalsIgnoreCase(figuraJugador)) {
					
					posibilidadTruncarI = 0;
					posibilidadTruncarJ = 2;
					encontrado = true;
				}
			}
			

			// Bloquear esquina 2,2
			if (matrizBotones[2][2].getText().equalsIgnoreCase("") && encontrado == false) {
				if (matrizBotones[1][1].getText().equalsIgnoreCase(figuraJugador)
						&& matrizBotones[0][0].getText().equalsIgnoreCase(figuraJugador)) {
					
					posibilidadTruncarI = 2;
					posibilidadTruncarJ = 2;
					encontrado = true;
				} else if (matrizBotones[1][2].getText().equalsIgnoreCase(figuraJugador)
						&& matrizBotones[0][2].getText().equalsIgnoreCase(figuraJugador)) {
					
					posibilidadTruncarI = 2;
					posibilidadTruncarJ = 2;
					encontrado = true;
				} else if (matrizBotones[2][1].getText().equalsIgnoreCase(figuraJugador)
						&& matrizBotones[2][0].getText().equalsIgnoreCase(figuraJugador)) {
					
					posibilidadTruncarI = 2;
					posibilidadTruncarJ = 2;
					encontrado = true;
				}
			}

			
			// Bloquear esquina 2,0
			if (matrizBotones[2][0].getText().equalsIgnoreCase("") && encontrado == false) {
				if (matrizBotones[1][1].getText().equalsIgnoreCase(figuraJugador)
						&& matrizBotones[0][2].getText().equalsIgnoreCase(figuraJugador)) {
					
					posibilidadTruncarI = 2;
					posibilidadTruncarJ = 0;
					encontrado = true;
				} else if (matrizBotones[2][1].getText().equalsIgnoreCase(figuraJugador)
						&& matrizBotones[2][2].getText().equalsIgnoreCase(figuraJugador)) {
					
					posibilidadTruncarI = 2;
					posibilidadTruncarJ = 0;
					encontrado = true;
				} else if (matrizBotones[1][0].getText().equalsIgnoreCase(figuraJugador)
						&& matrizBotones[0][0].getText().equalsIgnoreCase(figuraJugador)) {
					
					posibilidadTruncarI = 2;
					posibilidadTruncarJ = 0;
					encontrado = true;
				}
			}

				
			//Bloquear centro
			
			if (matrizBotones[1][1].getText().equalsIgnoreCase("") && encontrado == false) {
				if (matrizBotones[0][2].getText().equalsIgnoreCase(figuraJugador)
						&& matrizBotones[2][0].getText().equalsIgnoreCase(figuraJugador)) {
					
					posibilidadTruncarI = 1;
					posibilidadTruncarJ = 1;
					encontrado = true;
				} else if (matrizBotones[2][1].getText().equalsIgnoreCase(figuraJugador)
						&& matrizBotones[0][1].getText().equalsIgnoreCase(figuraJugador)) {
					
					posibilidadTruncarI = 1;
					posibilidadTruncarJ = 1;
					encontrado = true;
				} else if (matrizBotones[1][0].getText().equalsIgnoreCase(figuraJugador)
						&& matrizBotones[1][2].getText().equalsIgnoreCase(figuraJugador)) {
					
					posibilidadTruncarI = 1;
					posibilidadTruncarJ = 1;
					encontrado = true;
				} else if (matrizBotones[0][0].getText().equalsIgnoreCase(figuraJugador)
						&& matrizBotones[2][2].getText().equalsIgnoreCase(figuraJugador)) {
					matrizBotones[1][1].setText(figuraMaquina);
					
					posibilidadTruncarI = 1;
					posibilidadTruncarJ = 1;
					encontrado = true;
				}
			}
			
			//Bloquear 0,1
			if (matrizBotones[0][1].getText().equalsIgnoreCase("") && encontrado == false) {
				if (matrizBotones[1][1].getText().equalsIgnoreCase(figuraJugador)
						&& matrizBotones[2][1].getText().equalsIgnoreCase(figuraJugador)) {
					
					posibilidadTruncarI = 0;
					posibilidadTruncarJ = 1;
					encontrado = true;
					
				} else if (matrizBotones[0][0].getText().equalsIgnoreCase(figuraJugador)
						&& matrizBotones[0][2].getText().equalsIgnoreCase(figuraJugador)) {
					
					posibilidadTruncarI = 0;
					posibilidadTruncarJ = 1;
					encontrado = true;
				}
			}
			
			//Bloquear 1,0
			if (matrizBotones[1][0].getText().equalsIgnoreCase("") && encontrado == false) {
				if (matrizBotones[1][1].getText().equalsIgnoreCase(figuraJugador)
						&& matrizBotones[1][2].getText().equalsIgnoreCase(figuraJugador)) {
					
					posibilidadTruncarI = 1;
					posibilidadTruncarJ = 0;
					encontrado = true;
				} else if (matrizBotones[0][0].getText().equalsIgnoreCase(figuraJugador)
						&& matrizBotones[2][0].getText().equalsIgnoreCase(figuraJugador)) {
					
					posibilidadTruncarI = 1;
					posibilidadTruncarJ = 0;
					encontrado = true;
				}
			}
			
			//Bloquear 2,1
			if (matrizBotones[2][1].getText().equalsIgnoreCase("") && encontrado == false) {
				if (matrizBotones[1][1].getText().equalsIgnoreCase(figuraJugador)
						&& matrizBotones[0][1].getText().equalsIgnoreCase(figuraJugador)) {
					
					posibilidadTruncarI = 2;
					posibilidadTruncarJ = 1;
					encontrado = true;
					
				} else if (matrizBotones[2][0].getText().equalsIgnoreCase(figuraJugador)
						&& matrizBotones[2][2].getText().equalsIgnoreCase(figuraJugador)) {
					
					posibilidadTruncarI = 2;
					posibilidadTruncarJ = 1;
					encontrado = true;
					
				}
			}
			
			if (matrizBotones[1][2].getText().equalsIgnoreCase("") && encontrado == false) {
				if (matrizBotones[0][2].getText().equalsIgnoreCase(figuraJugador)
						&& matrizBotones[2][2].getText().equalsIgnoreCase(figuraJugador)) {
					
					posibilidadTruncarI = 1;
					posibilidadTruncarJ = 2;
					encontrado = true;
				} else if (matrizBotones[1][1].getText().equalsIgnoreCase(figuraJugador)
						&& matrizBotones[1][0].getText().equalsIgnoreCase(figuraJugador)) {
					
					posibilidadTruncarI = 1;
					posibilidadTruncarJ = 2;
					encontrado = true;
					
				}
			}


		

		}
		if (encontrado) {
			return true;
		}else {
			return false;
		}
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
			ganador.setText("Ha ocurrido un empate!");
			drawPoints++;
			draw.setText("Empates: "+drawPoints);
		}else {
	        ganador1.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
	        ganador2.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
	        ganador3.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
	        
	        
	        if (ganador1.getText().contentEquals(figuraJugador)) {	        	
	        	playerPoints++;
				winnerPlayer.setText("Victorias: "+playerPoints);
	        	ganador.setText("El ganador es "+playerName);
				ganador.setBorder(BorderFactory.createLineBorder(colorJugador, 5));

			}
	        else if (ganador1.getText().equalsIgnoreCase(figuraMaquina)) {
				machinePoints++;
				winnerMachine.setText("Victorias: "+machinePoints);
	        	ganador.setText("El ganador es: " +machineName);
				ganador.setBorder(BorderFactory.createLineBorder(colorMaquina, 5));
				
			}
		}
		
        
        
        for (int i = 0; i < matrizBotones.length; i++) {
			for (int j = 0; j < matrizBotones.length; j++) {
				matrizBotones[i][j].setEnabled(false);
			}
		}
        

	}
	
	
	
	



}