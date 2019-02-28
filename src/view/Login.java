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
	private JPanel panel;

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
		setBounds(100, 100, 839, 573);
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
		lblUsuario.setBounds(296, 371, 63, 14);
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
		tLogin.setBounds(352, 368, 182, 20);
		contentPane.add(tLogin);
		tLogin.setColumns(10);

		JLabel lblSenha = new JLabel("Senha : ");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(296, 401, 63, 14);
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
		tSenha.setBounds(352, 398, 182, 20);
		contentPane.add(tSenha);
		
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
				btnNewButton.setBounds(352, 428, 182, 23);
				contentPane.add(btnNewButton);
		
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(784, 496, 262, 77);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblEdenreoServidor = new JLabel("Endere\u00E7o Servidor :");
		lblEdenreoServidor.setBounds(70, 11, 182, 14);
		panel.add(lblEdenreoServidor);
		lblEdenreoServidor.setVisible(false);
		lblEdenreoServidor.setForeground(Color.WHITE);
		lblEdenreoServidor.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		ipserve = new JTextField();
		ipserve.setBounds(70, 26, 182, 20);
		panel.add(ipserve);
		ipserve.setHorizontalAlignment(SwingConstants.LEFT);
		ipserve.setVisible(false);
		ipserve.setColumns(10);
		
		btnConfirma = new JButton("Confirma");
		btnConfirma.setBounds(70, 49, 182, 20);
		panel.add(btnConfirma);
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
		
				btConfig = new JLabel("");
				btConfig.setBounds(10, 26, 32, 32);
				panel.add(btConfig);
				btConfig.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btConfig.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(panel.getX()>552) {				
							new Mover().start();					

						}else {
							
							new Mover2().start();
						}
					}
				});
				btConfig.setToolTipText("Configura\u00E7\u00E3o de Acesso ao Servidor");
				btConfig.setHorizontalAlignment(SwingConstants.CENTER);
				btConfig.setIcon(new ImageIcon(Login.class.getResource("/img/cogwheel.png")));




		JLabel backgraund = new JLabel("\r\n");
		backgraund.setIcon(new ImageIcon(Login.class.getResource("/img/bk.jpeg")));
		backgraund.setBounds(0, 0, 841, 573);
		contentPane.add(backgraund);
	}
	public class Mover extends Thread {
		public void run() {
		
			while(panel.getX()>552) {
				try {
					sleep(20);
				} catch (InterruptedException e) {
					
				}
				if(panel.getX()>552) {
					panel.setBounds(panel.getX()-10,496,262,77);
				}
				
					lblEdenreoServidor.setVisible(true);
					ipserve.setVisible(true);
					btnConfirma.setVisible(true);
			}
		}
	}

	public class Mover2 extends Thread{
		public void run() {
				
				while(panel.getX()<784) {
					try {
						sleep(20);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					if(panel.getX()<784) {
						panel.setBounds(panel.getX()+10,496,262,77);
					}
				}
				
				lblEdenreoServidor.setVisible(false);
				ipserve.setVisible(false);
				btnConfirma.setVisible(false);

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
			try {
				iniciar.EscritaUsuarioLogado(Integer.toString( usuario.getUsuarioLogado()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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


