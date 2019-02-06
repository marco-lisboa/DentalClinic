package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Iniciador;
import control.Usuario;
import dao.DaoConnect;
import viewTavisos.TavisoConfirma;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Window.Type;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tLogin;
	private JPasswordField tSenha;
	private JLabel btConfig;
	public JTextField ipserve;
	private JLabel lblEdenreoServidor;
	private JButton btnConfirma;
	private DaoConnect banco = new DaoConnect();
	private Iniciador iniciar = new Iniciador();
	private Usuario usuario = new Usuario();
	Menu menu = new Menu();
	TavisoConfirma avisoconf = new TavisoConfirma();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Thread(new Carregando()).start();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setUndecorated(true);
		setTitle("Dental Clinic");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/tooth.png")));
		setBounds(100, 100, 839, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel btFechar = new JLabel("");
		btFechar.setToolTipText("Fechar");
		btFechar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btFechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				sair();
			}
		});
		btFechar.setBounds(795, 0, 46, 47);
		contentPane.add(btFechar);
		btFechar.setHorizontalAlignment(SwingConstants.CENTER);
		btFechar.setIcon(new ImageIcon(Login.class.getResource("/img/fechar.png")));

		JLabel btMinimizar = new JLabel("");
		btMinimizar.setToolTipText("Maximizar");
		btMinimizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btMinimizar.setHorizontalAlignment(SwingConstants.CENTER);
		btMinimizar.setIcon(new ImageIcon(Login.class.getResource("/img/minus.png")));
		btMinimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExtendedState(ICONIFIED);
			}
		});
		btMinimizar.setBounds(747, 0, 46, 47);
		contentPane.add(btMinimizar);

		JLabel lblUsuario = new JLabel("Usuario : ");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(298, 301, 63, 14);
		contentPane.add(lblUsuario);

		tLogin = new JTextField();
		tLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
					sair();
				}
			}
		});
		tLogin.setBounds(354, 298, 182, 20);
		contentPane.add(tLogin);
		tLogin.setColumns(10);

		JLabel lblSenha = new JLabel("Senha : ");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(298, 331, 63, 14);
		contentPane.add(lblSenha);

		tSenha = new JPasswordField();
		tSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					logar();
				}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
					sair();
				}
			}
		});
		tSenha.setColumns(10);
		tSenha.setBounds(354, 328, 182, 20);
		contentPane.add(tSenha);

		btConfig = new JLabel("");
		btConfig.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btConfig.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btConfig.getX()>298) {				
					new Mover().start();					

				}else {
					
					new Mover2().start();
				}
			}
		});
		
				JButton btnNewButton = new JButton("Acessar");
				btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						logar();
					}
					
	});
				btnNewButton.setFocusable(false);
				btnNewButton.setForeground(Color.WHITE);
				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnNewButton.setBackground(new Color(32, 178, 170));
				btnNewButton.setBounds(354, 358, 182, 23);
				contentPane.add(btnNewButton);
		btConfig.setToolTipText("Configura\u00E7\u00E3o de Acesso ao Servidor");
		btConfig.setHorizontalAlignment(SwingConstants.CENTER);
		btConfig.setIcon(new ImageIcon(Login.class.getResource("/img/cogwheel.png")));
		btConfig.setBounds(427, 407, 32, 32);
		contentPane.add(btConfig);
		
		lblEdenreoServidor = new JLabel("Endere\u00E7o Servidor :");
		lblEdenreoServidor.setVisible(false);
		lblEdenreoServidor.setForeground(Color.WHITE);
		lblEdenreoServidor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEdenreoServidor.setBounds(354, 392, 182, 14);
		contentPane.add(lblEdenreoServidor);
		
		ipserve = new JTextField();
		ipserve.setHorizontalAlignment(SwingConstants.LEFT);
		ipserve.setVisible(false);
		ipserve.setColumns(10);
		ipserve.setBounds(354, 407, 182, 20);
		contentPane.add(ipserve);
		
		btnConfirma = new JButton("Confirma");
		btnConfirma.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					iniciar.LeituraIp();
					banco.conectar(iniciar.getIp_server());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnConfirma.setVisible(false);
		btnConfirma.setForeground(Color.WHITE);
		btnConfirma.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirma.setFocusable(false);
		btnConfirma.setBackground(new Color(32, 178, 170));
		btnConfirma.setBounds(354, 430, 182, 20);
		contentPane.add(btnConfirma);




		JLabel backgraund = new JLabel("\r\n");
		backgraund.setIcon(new ImageIcon(Login.class.getResource("/img/bk.jpeg")));
		backgraund.setBounds(0, 0, 841, 461);
		contentPane.add(backgraund);
	}
	public class Mover extends Thread {
		public void run() {
			while(btConfig.getX()>298) {
				try {
					sleep(20);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				if(btConfig.getX()>298) {
					btConfig.setBounds(btConfig.getX()-20, 407, 32, 32);
					
				}
				
				
					lblEdenreoServidor.setVisible(true);
					ipserve.setVisible(true);
					btnConfirma.setVisible(true);
				
				

			}
		}
	}

	public class Mover2 extends Thread{
		public void run() {
			while(btConfig.getX()<427) {
				try {
					sleep(20);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				if(btConfig.getX()<427) {
					btConfig.setBounds(btConfig.getX()+10, 407, 32, 32);

				}
				
				lblEdenreoServidor.setVisible(false);
				ipserve.setVisible(false);
				btnConfirma.setVisible(false);

			}
		}
	}

	public void logar() {
		usuario.setLoginUsuario(tLogin.getText());
		usuario.setSenhaUsuario(tSenha.getText());
		try {
			iniciar.LeituraIp();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		banco.Acesso(usuario.getLoginUsuario(), usuario.getSenhaUsuario(),iniciar.getIp_server(),usuario);

		if(banco.logado == true){

			
			menu.show();
			menu.setLocationRelativeTo(null);
			
			menu.nomeUsuario.setText(usuario.getNomeUsuarioLogado());
			dispose();
		}
		if(banco.logado==false){
			tLogin.setText("");
			tSenha.setText("");
			tLogin.requestFocus();
			
		}
		
		banco.logado=false;
		
	}
	
	public void sair() {
		avisoconf.texto.setText("Tem certeza que deseja sair?");
		avisoconf.texto.setIcon(new ImageIcon(TavisoConfirma.class.getResource("/img/atencao.png")));
		avisoconf.setLocationRelativeTo(null);
		avisoconf.show();
	}
}


