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
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class T_002_Menu extends JFrame {
	private JPanel contentPane;
	private JLabel btMenu;
	private JPanel menu;
	TavisoConfirmaDesloga avisoconf = new TavisoConfirmaDesloga();
	private T_003_livro_consulta tlivro = new T_003_livro_consulta();
	private T_004_ficha_paciente tficha = new T_004_ficha_paciente();
	private T_005_agenda_marcacao tagenda = new T_005_agenda_marcacao();
	private T_006_recebimento trebimento = new T_006_recebimento();
	private T_007_recebimento_avulso trebimentoAvulso = new T_007_recebimento_avulso();
	private T_008_financeiroPaciente tfinanceiroPaciente = new T_008_financeiroPaciente();
	private T_009_gerenciadorFinaceiro tgerenciador = new T_009_gerenciadorFinaceiro();
	private T_010_contas_pagar tcontasPagar = new T_010_contas_pagar();
	private T_011_folha_pagamento tfolha = new T_011_folha_pagamento();
	private T_012_fornecedores tfornecedores = new T_012_fornecedores();
	private T_013_funcionario tfuncionario = new T_013_funcionario();
	private T_014_bancos tbancos = new T_014_bancos();
	private T_015_contas tcontas = new T_015_contas();
	private T_016_servicos tservico = new T_016_servicos();
	private T_017_calculadora tcalcular = new T_017_calculadora();
	private T_018_livrocaixa tcaixa = new T_018_livrocaixa();
	private T_024_configurar tconfig = new T_024_configurar();
	
	public JLabel nomeUsuario;
	public   JPanel tfinanceiro;
	private JTabbedPane tabbedPaneFinanceiro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					T_002_Menu frame = new T_002_Menu();
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
	public T_002_Menu() {
		setUndecorated(true);
		setTitle("Dental Clinic");
		setIconImage(Toolkit.getDefaultToolkit().getImage(T_002_Menu.class.getResource("/img/tooth.png")));
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
		fechar.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/fechar.png")));
		btMenu.setBounds(0, 207, 46, 47);
		contentPane.add(btMenu);
		btMenu.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/exibir.png")));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setToolTipText("Minimizar");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/minus.png")));
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
		
		tcalcular.setBounds(243, 53, 586, 435);
		contentPane.add(tcalcular);
		tcalcular.setVisible(false);
		
		tcaixa.setBounds(243, 53, 586, 435);
		contentPane.add(tcaixa);
		tcaixa.setVisible(false);
		
		tconfig.setBounds(243, 53, 586, 435);
		contentPane.add(tconfig);
		tconfig.setVisible(false);
		
		trebimento.setBounds(243, 53, 586, 435);
		contentPane.add(trebimento);
		trebimento.setVisible(false);
		
		trebimentoAvulso.setBounds(243, 53, 586, 435);
		contentPane.add(trebimentoAvulso);
		trebimentoAvulso.setVisible(false);
		
		tfinanceiroPaciente.setBounds(243, 53, 586, 435);
		contentPane.add(tfinanceiroPaciente);
		tfinanceiroPaciente.setVisible(false);
		
		tgerenciador.setBounds(243, 53, 586, 435);
		contentPane.add(tgerenciador);
		tgerenciador.setVisible(false);
		
		tcontasPagar.setBounds(243, 53, 586, 435);
		contentPane.add(tcontasPagar);
		tcontasPagar.setVisible(false);
		
		tfolha.setBounds(243, 53, 586, 435);
		contentPane.add(tfolha);
		tfolha.setVisible(false);
		
		tfornecedores.setBounds(243, 53, 586, 435);
		contentPane.add(tfornecedores);
		tfornecedores.setVisible(false);
		
		tfuncionario.setBounds(243, 53, 586, 435);
		contentPane.add(tfuncionario);
		tfuncionario.setVisible(false);
		
		tfuncionario.setBounds(243, 53, 586, 435);
		contentPane.add(tfuncionario);
		tfuncionario.setVisible(false);
		
		tbancos.setBounds(243, 53, 586, 435);
		contentPane.add(tbancos);
		tbancos.setVisible(false);
		
		
		tcontas.setBounds(243, 53, 586, 435);
		contentPane.add(tcontas);
		tcontas.setVisible(false);
		
		tservico.setBounds(243, 53, 586, 435);
		contentPane.add(tservico);
		tservico.setVisible(false);
		
		
		
		tfinanceiro = new JPanel();
		tfinanceiro.setVisible(false);
		
		
		menu = new JPanel();
		menu.setBackground(Color.DARK_GRAY);
		menu.setOpaque(false);
		menu.setBounds(-200, 0, 201, 461);
		contentPane.add(menu);
		menu.setLayout(null);
		
		JLabel fotoUsuario = new JLabel("");
		fotoUsuario.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/toothgrande.png")));
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
				tlivro.dataDia();
				
			}
		});
		btconsulta.setToolTipText("Livro de Consultas Agendadas");
		btconsulta.setHorizontalAlignment(SwingConstants.CENTER);
		btconsulta.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/livro de consulta.png")));
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
				tficha.buscar();
				
			}
		});
		btFichaPaciente.setToolTipText("Ficha do Paciente ");
		btFichaPaciente.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/ficha paciente.png")));
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
				tagenda.dataDia();
			}
		});
		btAgendaMarcacao.setToolTipText("Agenda de Marca\u00E7\u00E3o");
		btAgendaMarcacao.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/agenda de marcacao.png")));
		btAgendaMarcacao.setHorizontalAlignment(SwingConstants.CENTER);
		btAgendaMarcacao.setBounds(136, 201, 43, 58);
		menu.add(btAgendaMarcacao);
		
		JLabel btRecebimentoPagamento = new JLabel("");
		btRecebimentoPagamento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btRecebimentoPagamento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Mover2().start();
				menu.setVisible(false);
				tlivro.setVisible(false);
				tficha.setVisible(false);
				tagenda.setVisible(false);
				tcalcular.setVisible(false);
				tcaixa.setVisible(false);
				tconfig.setVisible(false);
				btMenu.setVisible(false);
				tfinanceiro.setVisible(true);
				
			}
		});
		btRecebimentoPagamento.setToolTipText("Recebimento e Pagamento");
		btRecebimentoPagamento.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/gambler.png")));
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
		btCalculadoraOrcamento.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/calculator.png")));
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
		btLivrocaixa.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/receipt.png")));
		btLivrocaixa.setHorizontalAlignment(SwingConstants.CENTER);
		btLivrocaixa.setBounds(136, 270, 43, 58);
		menu.add(btLivrocaixa);
		
		JLabel btFilachegada = new JLabel("");
		btFilachegada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btFilachegada.setToolTipText("Fila de chamada");
		btFilachegada.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/fila.png")));
		btFilachegada.setHorizontalAlignment(SwingConstants.CENTER);
		btFilachegada.setBounds(28, 339, 43, 58);
		menu.add(btFilachegada);
		
		JLabel btObterSenha = new JLabel("");
		btObterSenha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btObterSenha.setToolTipText("Obter Senha");
		btObterSenha.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/coins.png")));
		btObterSenha.setHorizontalAlignment(SwingConstants.CENTER);
		btObterSenha.setBounds(82, 339, 43, 58);
		menu.add(btObterSenha);
		
		JLabel btRealizarChamada = new JLabel("");
		btRealizarChamada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btRealizarChamada.setToolTipText("Realizar Chamada");
		btRealizarChamada.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/realizar chamada.png")));
		btRealizarChamada.setHorizontalAlignment(SwingConstants.CENTER);
		btRealizarChamada.setBounds(136, 339, 43, 58);
		menu.add(btRealizarChamada);
		
		JLabel btAjustaSite = new JLabel("");
		btAjustaSite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btAjustaSite.setToolTipText("Atualizar Site");
		btAjustaSite.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/worldwide.png")));
		btAjustaSite.setHorizontalAlignment(SwingConstants.CENTER);
		btAjustaSite.setBounds(28, 408, 43, 58);
		menu.add(btAjustaSite);
		
		JLabel btAtualizarSistema = new JLabel("");
		btAtualizarSistema.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btAtualizarSistema.setToolTipText("Verifica\u00E7\u00E3o de Atualiza\u00E7\u00E3o");
		btAtualizarSistema.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/refresh.png")));
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
		btConfiguracao.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/cogwheel.png")));
		btConfiguracao.setHorizontalAlignment(SwingConstants.CENTER);
		btConfiguracao.setBounds(136, 408, 43, 58);
		menu.add(btConfiguracao);
		tfinanceiro.setOpaque(false);
		tfinanceiro.setBounds(10, 53, 232, 435);
		contentPane.add(tfinanceiro);
		tfinanceiro.setLayout(null);
		
		tabbedPaneFinanceiro = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneFinanceiro.setBackground(new Color(32, 178, 170));
		tabbedPaneFinanceiro.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tabbedPaneFinanceiro.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneFinanceiro.setBounds(0, 0, 232, 428);
		tfinanceiro.add(tabbedPaneFinanceiro);
		
		JPanel panel_1 = new JPanel();
		panel_1.setFocusTraversalKeysEnabled(false);
		tabbedPaneFinanceiro.addTab("Receitas", new ImageIcon(T_002_Menu.class.getResource("/img/gambler pequeno.png")), panel_1, null);
		tabbedPaneFinanceiro.setForegroundAt(0, Color.WHITE);
		panel_1.setLayout(null);
		
		JButton btnRecebimento = new JButton("Recebimento");
		btnRecebimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuFinaceiro(1);
			}
		});
		btnRecebimento.setBackground(new Color(32, 178, 170));
		btnRecebimento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRecebimento.setFocusable(false);
		btnRecebimento.setForeground(Color.WHITE);
		btnRecebimento.setBounds(10, 11, 213, 15);
		panel_1.add(btnRecebimento);
		
		JButton btnRecebimentoAvuso = new JButton("Recebimento Avulso");
		btnRecebimentoAvuso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuFinaceiro(2);
			}
		});
		btnRecebimentoAvuso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRecebimentoAvuso.setBackground(new Color(32, 178, 170));
		btnRecebimentoAvuso.setForeground(Color.WHITE);
		btnRecebimentoAvuso.setFocusable(false);
		btnRecebimentoAvuso.setBounds(10, 45, 213, 15);
		panel_1.add(btnRecebimentoAvuso);
		
		JButton btnGeraoDeParcelamento = new JButton("Gera\u00E7\u00E3o de Parcelamento");
		btnGeraoDeParcelamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuFinaceiro(3);
			}
		});
		btnGeraoDeParcelamento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGeraoDeParcelamento.setBackground(new Color(32, 178, 170));
		btnGeraoDeParcelamento.setForeground(Color.WHITE);
		btnGeraoDeParcelamento.setFocusable(false);
		btnGeraoDeParcelamento.setBounds(10, 79, 213, 15);
		panel_1.add(btnGeraoDeParcelamento);
		
		JButton btnGerenciadorFinanceiro = new JButton("Gerenciador Financeiro");
		btnGerenciadorFinanceiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuFinaceiro(4);
			}
		});
		btnGerenciadorFinanceiro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGerenciadorFinanceiro.setBackground(new Color(32, 178, 170));
		btnGerenciadorFinanceiro.setForeground(Color.WHITE);
		btnGerenciadorFinanceiro.setFocusable(false);
		btnGerenciadorFinanceiro.setBounds(10, 113, 213, 15);
		panel_1.add(btnGerenciadorFinanceiro);
		
		JLabel bt = new JLabel("");
		bt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					voltarMenu();
					menuFinaceiro(100);
			}
		});
		bt.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/voltar.png")));
		bt.setToolTipText("Voltar");
		bt.setHorizontalAlignment(SwingConstants.CENTER);
		bt.setBounds(183, 348, 46, 47);
		panel_1.add(bt);
		
		JLabel bkfinaceiro = new JLabel("");
		bkfinaceiro.setVerticalAlignment(SwingConstants.BOTTOM);
		bkfinaceiro.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/bk.jpeg")));
		bkfinaceiro.setBounds(0, 0, 229, 408);
		panel_1.add(bkfinaceiro);
		
		JPanel panel_2 = new JPanel();
		panel_2.setFocusTraversalKeysEnabled(false);
		tabbedPaneFinanceiro.addTab("Despesas\r\n", new ImageIcon(T_002_Menu.class.getResource("/img/saida.png")), panel_2, null);
		tabbedPaneFinanceiro.setForegroundAt(1, Color.WHITE);
		panel_2.setLayout(null);
		
		JButton btnContasAPagar = new JButton("Contas a Pagar");
		btnContasAPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuFinaceiro(5);
			}
		});
		btnContasAPagar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnContasAPagar.setForeground(Color.WHITE);
		btnContasAPagar.setFocusable(false);
		btnContasAPagar.setBackground(new Color(32, 178, 170));
		btnContasAPagar.setBounds(10, 11, 213, 16);
		panel_2.add(btnContasAPagar);
		
		JButton btnFolhaDePagamento = new JButton("Folha de Pagamento");
		btnFolhaDePagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuFinaceiro(6);
			}
		});
		btnFolhaDePagamento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFolhaDePagamento.setForeground(Color.WHITE);
		btnFolhaDePagamento.setFocusable(false);
		btnFolhaDePagamento.setBackground(new Color(32, 178, 170));
		btnFolhaDePagamento.setBounds(10, 45, 213, 16);
		panel_2.add(btnFolhaDePagamento);
		
		JLabel bt2 = new JLabel("");
		bt2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bt2.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/voltar.png")));
		bt2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				voltarMenu();
				menuFinaceiro(100);
			}
		});
		bt2.setToolTipText("Voltar");
		bt2.setHorizontalAlignment(SwingConstants.CENTER);
		bt2.setBounds(181, 350, 46, 47);
		panel_2.add(bt2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/bk.jpeg")));
		lblNewLabel_2.setBounds(0, 0, 227, 408);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		tabbedPaneFinanceiro.addTab("Geral", new ImageIcon(T_002_Menu.class.getResource("/img/options.png")), panel_3, null);
		tabbedPaneFinanceiro.setForegroundAt(2, Color.WHITE);
		panel_3.setLayout(null);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				voltarMenu();
				menuFinaceiro(100);
			}
		});
		label.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/voltar.png")));
		label.setToolTipText("Voltar");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(181, 350, 46, 47);
		panel_3.add(label);
		
		JButton btnFornecedores = new JButton("Fornecedores");
		btnFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuFinaceiro(7);
			}
		});
		btnFornecedores.setForeground(Color.WHITE);
		btnFornecedores.setFocusable(false);
		btnFornecedores.setBackground(new Color(32, 178, 170));
		btnFornecedores.setBounds(10, 11, 213, 15);
		panel_3.add(btnFornecedores);
		
		JButton btnFuncionarios = new JButton("Funcionarios");
		btnFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuFinaceiro(8);
			}
		});
		btnFuncionarios.setForeground(Color.WHITE);
		btnFuncionarios.setFocusable(false);
		btnFuncionarios.setBackground(new Color(32, 178, 170));
		btnFuncionarios.setBounds(10, 45, 213, 15);
		panel_3.add(btnFuncionarios);
		
		JButton button = new JButton("Bancos");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuFinaceiro(9);
			}
		});
		button.setForeground(Color.WHITE);
		button.setFocusable(false);
		button.setBackground(new Color(32, 178, 170));
		button.setBounds(10, 79, 213, 15);
		panel_3.add(button);
		
		JButton button_1 = new JButton("Contas");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuFinaceiro(10);
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFocusable(false);
		button_1.setBackground(new Color(32, 178, 170));
		button_1.setBounds(10, 113, 213, 15);
		panel_3.add(button_1);
		
		JButton button_2 = new JButton("Servi\u00E7os e Orfertas");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuFinaceiro(11);
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFocusable(false);
		button_2.setBackground(new Color(32, 178, 170));
		button_2.setBounds(10, 143, 213, 15);
		panel_3.add(button_2);
		
		JLabel bkGeral = new JLabel("");
		bkGeral.setVerticalAlignment(SwingConstants.BOTTOM);
		bkGeral.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/bk.jpeg")));
		bkGeral.setHorizontalAlignment(SwingConstants.LEFT);
		bkGeral.setBounds(0, 0, 227, 412);
		panel_3.add(bkGeral);
		
		
	
		
		JLabel backgraund = new JLabel("\r\n");
		backgraund.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/bk.jpeg")));
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
					btMenu.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/esconder.png")));
					
					
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
					btMenu.setIcon(new ImageIcon(T_002_Menu.class.getResource("/img/exibir.png")));
					tlivro.setVisible(false);
					tficha.setVisible(false);
					tagenda.setVisible(false);
				
					tcalcular.setVisible(false);
					tcaixa.setVisible(false);
					tconfig.setVisible(false);
					
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
	
	public void voltarMenu() {
		tfinanceiro.setVisible(false);
		trebimento.setVisible(false);
		menu.setVisible(true);
		btMenu.setVisible(true);
		new Mover().start();
	}
	
	public void menuFinaceiro(int tl) {
		if(tl==1) {
			trebimentoAvulso.setVisible(false);
			tfinanceiroPaciente.setVisible(false);
			tgerenciador.setVisible(false);
			tcontasPagar.setVisible(false);
			tfolha.setVisible(false);
			tfornecedores.setVisible(false);
			tfuncionario.setVisible(false);
			tbancos.setVisible(false);
			tcontas.setVisible(false);
			tservico.setVisible(false);
			trebimento.setVisible(true);
		}else if (tl==2) {
			trebimento.setVisible(false);
			tfinanceiroPaciente.setVisible(false);
			tgerenciador.setVisible(false);
			tcontasPagar.setVisible(false);
			tfolha.setVisible(false);
			tfornecedores.setVisible(false);
			tfuncionario.setVisible(false);
			tbancos.setVisible(false);
			tcontas.setVisible(false);
			tservico.setVisible(false);
			trebimentoAvulso.setVisible(true);
		}else if(tl==3) {
			trebimento.setVisible(false);
			trebimentoAvulso.setVisible(false);
			tgerenciador.setVisible(false);
			tcontasPagar.setVisible(false);
			tfolha.setVisible(false);
			tfornecedores.setVisible(false);
			tfuncionario.setVisible(false);
			tbancos.setVisible(false);
			tcontas.setVisible(false);
			tservico.setVisible(false);
			tfinanceiroPaciente.setVisible(true);
		}else if(tl==4) {
			trebimento.setVisible(false);
			trebimentoAvulso.setVisible(false);
			tfinanceiroPaciente.setVisible(false);
			tcontasPagar.setVisible(false);
			tfolha.setVisible(false);
			tfornecedores.setVisible(false);
			tfuncionario.setVisible(false);
			tbancos.setVisible(false);
			tcontas.setVisible(false);
			tservico.setVisible(false);
			tgerenciador.setVisible(true);
			}else if(tl==5) {
				trebimento.setVisible(false);
				trebimentoAvulso.setVisible(false);
				tfinanceiroPaciente.setVisible(false);
				tgerenciador.setVisible(false);
				tfolha.setVisible(false);
				tfornecedores.setVisible(false);
				tfuncionario.setVisible(false);
				tbancos.setVisible(false);
				tcontas.setVisible(false);
				tservico.setVisible(false);
				tcontasPagar.setVisible(true);
				
			}else if(tl==6) {
				trebimento.setVisible(false);
				trebimentoAvulso.setVisible(false);
				tfinanceiroPaciente.setVisible(false);
				tgerenciador.setVisible(false);
				tcontasPagar.setVisible(false);
				tfornecedores.setVisible(false);
				tfuncionario.setVisible(false);
				tbancos.setVisible(false);
				tcontas.setVisible(false);
				tservico.setVisible(false);
				tfolha.setVisible(true);
			}else if(tl==7) {
				trebimento.setVisible(false);
				trebimentoAvulso.setVisible(false);
				tfinanceiroPaciente.setVisible(false);
				tgerenciador.setVisible(false);
				tcontasPagar.setVisible(false);
				tfolha.setVisible(false);
				tfuncionario.setVisible(false);
				tbancos.setVisible(false);
				tcontas.setVisible(false);
				tservico.setVisible(false);
				tfornecedores.setVisible(true);
				
			}else if (tl==8) {
				trebimento.setVisible(false);
				trebimentoAvulso.setVisible(false);
				tfinanceiroPaciente.setVisible(false);
				tgerenciador.setVisible(false);
				tcontasPagar.setVisible(false);
				tfolha.setVisible(false);
				tfornecedores.setVisible(false);
				tbancos.setVisible(false);
				tcontas.setVisible(false);
				tservico.setVisible(false);
				tfuncionario.setVisible(true);
			}else if(tl==9) {
				trebimento.setVisible(false);
				trebimentoAvulso.setVisible(false);
				tfinanceiroPaciente.setVisible(false);
				tgerenciador.setVisible(false);
				tcontasPagar.setVisible(false);
				tfolha.setVisible(false);
				tfornecedores.setVisible(false);
				tfuncionario.setVisible(false);
				tcontas.setVisible(false);
				tservico.setVisible(false);
				tbancos.setVisible(true);
			}else if(tl==10) {
				trebimento.setVisible(false);
				trebimentoAvulso.setVisible(false);
				tfinanceiroPaciente.setVisible(false);
				tgerenciador.setVisible(false);
				tcontasPagar.setVisible(false);
				tfolha.setVisible(false);
				tfornecedores.setVisible(false);
				tfuncionario.setVisible(false);
				tbancos.setVisible(false);
				tservico.setVisible(false);
				tcontas.setVisible(true);
				
			}else if(tl==11) {
				trebimento.setVisible(false);
				trebimentoAvulso.setVisible(false);
				tfinanceiroPaciente.setVisible(false);
				tgerenciador.setVisible(false);
				tcontasPagar.setVisible(false);
				tfolha.setVisible(false);
				tfornecedores.setVisible(false);
				tfuncionario.setVisible(false);
				tbancos.setVisible(false);
				tcontas.setVisible(false);
				tservico.setVisible(true);
				
			}else {
				trebimento.setVisible(false);
				trebimentoAvulso.setVisible(false);
				tfinanceiroPaciente.setVisible(false);
				tgerenciador.setVisible(false);
				tcontasPagar.setVisible(false);
				tfolha.setVisible(false);
				tfornecedores.setVisible(false);
				tfuncionario.setVisible(false);
				tbancos.setVisible(false);
				tcontas.setVisible(false);
				tservico.setVisible(false);
				tabbedPaneFinanceiro.setSelectedIndex(0);
				tgerenciador.voltar();
				
			}
		}
	};

