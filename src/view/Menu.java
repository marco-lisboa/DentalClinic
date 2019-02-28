package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import viewTavisos.TavisoConfirma;
import viewTavisos.TavisoConfirmaDesloga;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Window.Type;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Font;
import javax.swing.JTextField;

public class Menu extends JFrame {
	private JPanel contentPane;
	private JLabel btMenu;
	private JPanel menu;
	TavisoConfirmaDesloga avisoconf = new TavisoConfirmaDesloga();
	private Tlivro_consulta tlivro = new Tlivro_consulta();
	private Tficha_paciente tficha = new Tficha_paciente();
	private Tagenda_marcacao tagenda = new Tagenda_marcacao();
	private Tfinanceiro tfinanceiro = new Tfinanceiro();
	private Tcalculadora tcalcular = new Tcalculadora();
	private Tlivrocaixa tcaixa = new Tlivrocaixa();
	private Tconfigurar tconfig = new Tconfigurar();
	public JLabel nomeUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setUndecorated(true);
		setTitle("Dental Clinic");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/img/tooth.png")));
		setBounds(100, 100, 839, 573);
		contentPane = new JPanel();
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				 if(evt.getKeyCode() == KeyEvent.VK_ENTER){
					 System.out.println("teste funciona?");
				       tlivro.setVisible(false);
				    }
				
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btMenu = new JLabel("");
		btMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btMenu.getX()<203) {				
					new Mover().start();					

				}else {
					
					new Mover2().start();
				}
				
			}
		});
		
		JLabel fechar = new JLabel("");
		fechar.setToolTipText("Fecha");
		fechar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		fechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				sair();
				setVisible(false);
			}
		});
		fechar.setBounds(795, 0, 46, 47);
		contentPane.add(fechar);
		fechar.setHorizontalAlignment(SwingConstants.CENTER);
		fechar.setIcon(new ImageIcon(Menu.class.getResource("/img/fechar.png")));
		btMenu.setBounds(0, 207, 46, 47);
		contentPane.add(btMenu);
		btMenu.setIcon(new ImageIcon(Menu.class.getResource("/img/exibir.png")));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setToolTipText("Minimizar");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/img/minus.png")));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExtendedState(ICONIFIED);
			}
		});
		lblNewLabel.setBounds(744, 0, 46, 47);
		contentPane.add(lblNewLabel);
		
		
		tlivro.setBounds(243, 53, 586, 435);
		contentPane.add(tlivro);
		tlivro.setVisible(false);
		
		tficha.setBounds(243, 53, 586, 435);
		contentPane.add(tficha);
		tficha.setVisible(false);
		
		tagenda.setBounds(243, 53, 586, 435);
		contentPane.add(tagenda);
		tagenda.setVisible(false);
		
		tfinanceiro.setBounds(243, 53, 586, 435);
		contentPane.add(tfinanceiro);
		tfinanceiro.setVisible(false);
		
		tcalcular.setBounds(243, 53, 586, 435);
		contentPane.add(tcalcular);
		tcalcular.setVisible(false);
		
		tcaixa.setBounds(243, 53, 586, 435);
		contentPane.add(tcaixa);
		tcaixa.setVisible(false);
		
		tconfig.setBounds(243, 53, 586, 435);
		contentPane.add(tconfig);
		tconfig.setVisible(false);
		
		
		menu = new JPanel();
		menu.setBackground(Color.DARK_GRAY);
		menu.setOpaque(false);
		menu.setBounds(-200, 0, 201, 461);
		contentPane.add(menu);
		menu.setLayout(null);
		
		JLabel fotoUsuario = new JLabel("");
		fotoUsuario.setIcon(new ImageIcon(Menu.class.getResource("/img/toothgrande.png")));
		fotoUsuario.setBounds(33, 9, 135, 134);
		menu.add(fotoUsuario);
		
		nomeUsuario = new JLabel("Dental Clinic");
		nomeUsuario.setFont(new Font("Arial", Font.PLAIN, 15));
		nomeUsuario.setForeground(Color.WHITE);
		nomeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		nomeUsuario.setBounds(0, 160, 200, 14);
		menu.add(nomeUsuario);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(7, 183, 191, 2);
		menu.add(separator);
		
		JLabel btconsulta = new JLabel("");
		btconsulta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btconsulta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tficha.setVisible(false);
				tagenda.setVisible(false);
				tfinanceiro.setVisible(false);
				tcalcular.setVisible(false);
				tcaixa.setVisible(false);
				tconfig.setVisible(false);
				tlivro.setVisible(true);
				
			}
		});
		btconsulta.setToolTipText("Livro de Consultas Agendadas");
		btconsulta.setHorizontalAlignment(SwingConstants.CENTER);
		btconsulta.setIcon(new ImageIcon(Menu.class.getResource("/img/livro de consulta.png")));
		btconsulta.setBounds(28, 201, 43, 58);
		menu.add(btconsulta);
		
		JLabel btFichaPaciente = new JLabel("");
		btFichaPaciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btFichaPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				tlivro.setVisible(false);
				tagenda.setVisible(false);
				tfinanceiro.setVisible(false);
				tcalcular.setVisible(false);
				tcaixa.setVisible(false);
				tconfig.setVisible(false);
				tficha.setVisible(true);
				
			}
		});
		btFichaPaciente.setToolTipText("Ficha do Paciente ");
		btFichaPaciente.setIcon(new ImageIcon(Menu.class.getResource("/img/ficha paciente.png")));
		btFichaPaciente.setHorizontalAlignment(SwingConstants.CENTER);
		btFichaPaciente.setBounds(82, 201, 43, 58);
		menu.add(btFichaPaciente);
		
		JLabel btAgendaMarcacao = new JLabel("");
		btAgendaMarcacao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btAgendaMarcacao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tlivro.setVisible(false);
				tficha.setVisible(false);
				tfinanceiro.setVisible(false);
				tcalcular.setVisible(false);
				tcaixa.setVisible(false);
				tconfig.setVisible(false);
				tagenda.setVisible(true);
			}
		});
		btAgendaMarcacao.setToolTipText("Agenda de Marca\u00E7\u00E3o");
		btAgendaMarcacao.setIcon(new ImageIcon(Menu.class.getResource("/img/agenda de marcacao.png")));
		btAgendaMarcacao.setHorizontalAlignment(SwingConstants.CENTER);
		btAgendaMarcacao.setBounds(136, 201, 43, 58);
		menu.add(btAgendaMarcacao);
		
		JLabel btRecebimentoPagamento = new JLabel("");
		btRecebimentoPagamento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btRecebimentoPagamento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tlivro.setVisible(false);
				tficha.setVisible(false);
				tagenda.setVisible(false);
				tcalcular.setVisible(false);
				tcaixa.setVisible(false);
				tconfig.setVisible(false);
				tfinanceiro.setVisible(true);
			}
		});
		btRecebimentoPagamento.setToolTipText("Recebimento e Pagamento");
		btRecebimentoPagamento.setIcon(new ImageIcon(Menu.class.getResource("/img/gambler.png")));
		btRecebimentoPagamento.setHorizontalAlignment(SwingConstants.CENTER);
		btRecebimentoPagamento.setBounds(28, 270, 43, 58);
		menu.add(btRecebimentoPagamento);
		
		JLabel btCalculadoraOrcamento = new JLabel("");
		btCalculadoraOrcamento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btCalculadoraOrcamento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tlivro.setVisible(false);
				tficha.setVisible(false);
				tagenda.setVisible(false);
				tfinanceiro.setVisible(false);
				tcaixa.setVisible(false);
				tconfig.setVisible(false);
				tcalcular.setVisible(true);
			}
		});
		btCalculadoraOrcamento.setToolTipText("Calculadora Or\u00E7amentaria");
		btCalculadoraOrcamento.setIcon(new ImageIcon(Menu.class.getResource("/img/calculator.png")));
		btCalculadoraOrcamento.setHorizontalAlignment(SwingConstants.CENTER);
		btCalculadoraOrcamento.setBounds(82, 270, 43, 58);
		menu.add(btCalculadoraOrcamento);
		
		JLabel btLivrocaixa = new JLabel("");
		btLivrocaixa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btLivrocaixa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tlivro.setVisible(false);
				tficha.setVisible(false);
				tagenda.setVisible(false);
				tfinanceiro.setVisible(false);
				tcalcular.setVisible(false);
				tconfig.setVisible(false);
				tcaixa.setVisible(true);
			}
		});
		btLivrocaixa.setToolTipText("Livro Caixa");
		btLivrocaixa.setIcon(new ImageIcon(Menu.class.getResource("/img/receipt.png")));
		btLivrocaixa.setHorizontalAlignment(SwingConstants.CENTER);
		btLivrocaixa.setBounds(136, 270, 43, 58);
		menu.add(btLivrocaixa);
		
		JLabel btFilachegada = new JLabel("");
		btFilachegada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btFilachegada.setToolTipText("Fila de chamada");
		btFilachegada.setIcon(new ImageIcon(Menu.class.getResource("/img/fila.png")));
		btFilachegada.setHorizontalAlignment(SwingConstants.CENTER);
		btFilachegada.setBounds(28, 339, 43, 58);
		menu.add(btFilachegada);
		
		JLabel btObterSenha = new JLabel("");
		btObterSenha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btObterSenha.setToolTipText("Obter Senha");
		btObterSenha.setIcon(new ImageIcon(Menu.class.getResource("/img/coins.png")));
		btObterSenha.setHorizontalAlignment(SwingConstants.CENTER);
		btObterSenha.setBounds(82, 339, 43, 58);
		menu.add(btObterSenha);
		
		JLabel btRealizarChamada = new JLabel("");
		btRealizarChamada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btRealizarChamada.setToolTipText("Realizar Chamada");
		btRealizarChamada.setIcon(new ImageIcon(Menu.class.getResource("/img/realizar chamada.png")));
		btRealizarChamada.setHorizontalAlignment(SwingConstants.CENTER);
		btRealizarChamada.setBounds(136, 339, 43, 58);
		menu.add(btRealizarChamada);
		
		JLabel btAjustaSite = new JLabel("");
		btAjustaSite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btAjustaSite.setToolTipText("Atualizar Site");
		btAjustaSite.setIcon(new ImageIcon(Menu.class.getResource("/img/worldwide.png")));
		btAjustaSite.setHorizontalAlignment(SwingConstants.CENTER);
		btAjustaSite.setBounds(28, 408, 43, 58);
		menu.add(btAjustaSite);
		
		JLabel btAtualizarSistema = new JLabel("");
		btAtualizarSistema.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btAtualizarSistema.setToolTipText("Verifica\u00E7\u00E3o de Atualiza\u00E7\u00E3o");
		btAtualizarSistema.setIcon(new ImageIcon(Menu.class.getResource("/img/refresh.png")));
		btAtualizarSistema.setHorizontalAlignment(SwingConstants.CENTER);
		btAtualizarSistema.setBounds(82, 408, 43, 58);
		menu.add(btAtualizarSistema);
		
		JLabel btConfiguracao = new JLabel("");
		btConfiguracao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btConfiguracao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tlivro.setVisible(false);
				tficha.setVisible(false);
				tagenda.setVisible(false);
				tfinanceiro.setVisible(false);
				tcalcular.setVisible(false);
				tcaixa.setVisible(false);
				tconfig.setVisible(true);
			}
		});
		btConfiguracao.setToolTipText("Configura\u00E7\u00E3o");
		btConfiguracao.setIcon(new ImageIcon(Menu.class.getResource("/img/cogwheel.png")));
		btConfiguracao.setHorizontalAlignment(SwingConstants.CENTER);
		btConfiguracao.setBounds(136, 408, 43, 58);
		menu.add(btConfiguracao);
		
		
	
		
		JLabel backgraund = new JLabel("\r\n");
		backgraund.setIcon(new ImageIcon(Menu.class.getResource("/img/bk.jpeg")));
		backgraund.setBounds(0, 0, 841, 573);
		contentPane.add(backgraund);
	}
	
	public class Mover extends Thread {
		public void run() {
			while(btMenu.getX()<203) {
				try {
					sleep(20);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				if(btMenu.getX()<203) {
					btMenu.setBounds(btMenu.getX()+10, 239, 46, 47);

				}
				if(menu.getX()<0) {
					menu.setBounds(menu.getX()+10, 0, 201, 461);
					btMenu.setIcon(new ImageIcon(Menu.class.getResource("/img/esconder.png")));
					
				}
			}
		}
	}
	
	public class Mover2 extends Thread{
		public void run() {
			while(btMenu.getX()>0) {
				try {
					sleep(20);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				if(btMenu.getX()>0) {
					btMenu.setBounds(btMenu.getX()-10, 239, 46, 47);

				}
				if(menu.getX()>-200) {
					menu.setBounds(menu.getX()-10, 0, 201, 461);
					btMenu.setIcon(new ImageIcon(Menu.class.getResource("/img/exibir.png")));
					
				}
			}
		}
	}

	public void sair() {
		avisoconf.texto.setText("Tem certeza que deseja sair?");
		avisoconf.texto.setIcon(new ImageIcon(TavisoConfirma.class.getResource("/img/atencao.png")));
		avisoconf.setLocationRelativeTo(null);
		avisoconf.show();
	}
	
	public void fechakrai() {
		this.dispose();
	}
}
