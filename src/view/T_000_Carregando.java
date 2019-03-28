package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import org.edisoncor.gui.util.WindowsUtil;

import control.Iniciador;

import javax.swing.SwingConstants;


public class T_000_Carregando extends JFrame  implements Runnable {

	Thread hilo;
	private JPanel contentPane;
	T_001_Login login = new T_001_Login();
	Iniciador iniciar = new Iniciador();
	JProgressBar pbSplashScreen = new JProgressBar();
	private int vlAjusta;
	
	/**
	 * Create the frame.
	 */
	public T_000_Carregando() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(T_000_Carregando.class.getResource("/img/tooth.png")));
		
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		pbSplashScreen.setVisible(false);
		pbSplashScreen.setForeground(SystemColor.activeCaption);
		
		
	
		
		pbSplashScreen.setBounds(0, 428, 719, 24);
		contentPane.add(pbSplashScreen);
		
		JLabel lblMaynoresoftLtdaTodos = new JLabel("MaynoreSoft LTDA. Todos direitos resevados 2019");
		lblMaynoresoftLtdaTodos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaynoresoftLtdaTodos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaynoresoftLtdaTodos.setForeground(Color.WHITE);
		lblMaynoresoftLtdaTodos.setBounds(185, 403, 342, 14);
		contentPane.add(lblMaynoresoftLtdaTodos);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(T_000_Carregando.class.getResource("/img/carregando.gif")));
		lblNewLabel.setBounds(285, 280, 149, 100);
		contentPane.add(lblNewLabel);
		
		JLabel backgraund = new JLabel("");
		backgraund.setHorizontalAlignment(SwingConstants.CENTER);
		backgraund.setIcon(new ImageIcon(T_000_Carregando.class.getResource("/img/bk.jpeg")));
		backgraund.setBounds(0, 0, 719, 461);
		contentPane.add(backgraund);
		setLocationRelativeTo(null);
		
		
		
	}
	
	

	@Override
	public void run() {
		
		this.setVisible(true);
		WindowsUtil.makeWindowsOpacity(this, 0.7f);
		try{
			for(int i=0;i<150;i++){
				pbSplashScreen.setValue(i);
				hilo.sleep(30);
			}
			
		}catch(InterruptedException ex){
			Logger.getLogger(T_000_Carregando.class.getName()).log(Level.SEVERE,null, ex);
		}
		
		this.dispose();
		try {
			iniciar.LeituraIp();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		login.ipserve.setText(iniciar.getIp_server());
		login.setVisible(true);
		
		
		
	}
}
