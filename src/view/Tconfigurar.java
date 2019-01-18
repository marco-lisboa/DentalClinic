package view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Cursor;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tconfigurar extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField textField_3;
	private JTextField passwordField;
	private JTabbedPane tabbedPaneCadastroUsuario;
	private JTabbedPane tabbedPaneUsuarios;
	private JTabbedPane tabbedPanePrincipal;
	
	

	/**
	 * Create the panel.
	 */
	public Tconfigurar() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				 if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
				       setVisible(false);
				    }
				
			}
		});
		setOpaque(false);
		setBounds(243, 11, 575, 427);
		setLayout(null);
		
		tabbedPanePrincipal = new JTabbedPane(JTabbedPane.TOP);
		tabbedPanePrincipal.setBorder(null);
		tabbedPanePrincipal.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPanePrincipal.setBackground(new Color(32, 178, 170));
		tabbedPanePrincipal.setBounds(0, 0, 575, 428);
		add(tabbedPanePrincipal);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setForeground(Color.WHITE);
		tabbedPanePrincipal.addTab("Configura\u00E7\u00E3o", new ImageIcon(Tconfigurar.class.getResource("/img/configPequena.png")), panel, null);
		tabbedPanePrincipal.setBackgroundAt(0, new Color(32, 178, 170));
		tabbedPanePrincipal.setForegroundAt(0, Color.WHITE);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setToolTipText("Voltar");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/voltar.png")));
		lblNewLabel_1.setBounds(535, 2, 25, 32);
		panel.add(lblNewLabel_1);
		
		JButton btnUsuario = new JButton("Empresa");
		btnUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		btnUsuario.setForeground(Color.WHITE);
		btnUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUsuario.setBackground(new Color(32, 178, 170));
		btnUsuario.setBounds(14, 25, 257, 14);
		panel.add(btnUsuario);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setFocusable(false);
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPanePrincipal.setVisible(false);
				tabbedPaneUsuarios.setVisible(true);
			}
		});
		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		btnUsuarios.setForeground(Color.WHITE);
		btnUsuarios.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUsuarios.setBackground(new Color(32, 178, 170));
		btnUsuarios.setBounds(14, 50, 257, 14);
		panel.add(btnUsuarios);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(281, 11, 1, 324);
		panel.add(separator);
		
		JLabel bk = new JLabel("");
		bk.setHorizontalAlignment(SwingConstants.CENTER);
		bk.setIcon(new ImageIcon(Tlivro_consulta.class.getResource("/img/bk.jpeg")));
		bk.setBounds(0, 2, 570, 409);
		panel.add(bk);
		
		tabbedPaneCadastroUsuario = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneCadastroUsuario.setVisible(false);
		
		tabbedPaneUsuarios = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneUsuarios.setVisible(false);
		tabbedPaneUsuarios.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneUsuarios.setBorder(null);
		tabbedPaneUsuarios.setBackground(new Color(32, 178, 170));
		tabbedPaneUsuarios.setBounds(0, 0, 575, 428);
		add(tabbedPaneUsuarios);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(32, 178, 170));
		tabbedPaneUsuarios.addTab("USUARIO", new ImageIcon(Tconfigurar.class.getResource("/img/configPequena.png")), panel_1, null);
		
		JLabel voltarUsuarios = new JLabel("");
		voltarUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		voltarUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPaneUsuarios.setVisible(false);
				tabbedPanePrincipal.setVisible(true);
			}
		});
		voltarUsuarios.setIcon(new ImageIcon(Tconfigurar.class.getResource("/img/voltar.png")));
		voltarUsuarios.setToolTipText("Voltar");
		voltarUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		voltarUsuarios.setBounds(535, 2, 25, 32);
		panel_1.add(voltarUsuarios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 550, 244);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"CODIGO", "NOME", "NIVEL"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("Nome : ");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 11, 46, 14);
		panel_1.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(52, 8, 145, 20);
		panel_1.add(textField);
		
		JLabel btPesquisaUsuario = new JLabel("");
		btPesquisaUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btPesquisaUsuario.setIcon(new ImageIcon(Tconfigurar.class.getResource("/img/buscar.png")));
		btPesquisaUsuario.setToolTipText("Buscar");
		btPesquisaUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		btPesquisaUsuario.setForeground(Color.WHITE);
		btPesquisaUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		btPesquisaUsuario.setBounds(207, 2, 46, 32);
		panel_1.add(btPesquisaUsuario);
		
		JLabel label_2 = new JLabel("Situa\u00E7\u00E3o : ");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(10, 39, 89, 14);
		panel_1.add(label_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Ativo", "Inativo"}));
		comboBox.setBounds(73, 36, 145, 20);
		panel_1.add(comboBox);
		
		JLabel label_3 = new JLabel("null registros encontrados");
		label_3.setIcon(new ImageIcon(Tconfigurar.class.getResource("/img/confimado.png")));
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(10, 368, 208, 14);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPaneUsuarios.setVisible(false);
				tabbedPaneCadastroUsuario.setVisible(true);
			}
		});
		label_4.setIcon(new ImageIcon(Tconfigurar.class.getResource("/img/add.png")));
		label_4.setToolTipText("Adicionar Novo Paciente");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(221, 355, 46, 43);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Tconfigurar.class.getResource("/img/editar (2).png")));
		label_5.setToolTipText("Editar");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(281, 355, 46, 43);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Tconfigurar.class.getResource("/img/deleta.png")));
		label_6.setToolTipText("Remover Paciente");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(337, 355, 46, 43);
		panel_1.add(label_6);
		
		JLabel bkUsuarios = new JLabel("");
		bkUsuarios.setIcon(new ImageIcon(Tconfigurar.class.getResource("/img/bk.jpeg")));
		bkUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		bkUsuarios.setBounds(0, 2, 570, 409);
		panel_1.add(bkUsuarios);
		tabbedPaneCadastroUsuario.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneCadastroUsuario.setBorder(null);
		tabbedPaneCadastroUsuario.setBackground(new Color(32, 178, 170));
		tabbedPaneCadastroUsuario.setBounds(0, 0, 575, 428);
		add(tabbedPaneCadastroUsuario);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setForeground(Color.WHITE);
		panel_2.setBackground(new Color(32, 178, 170));
		tabbedPaneCadastroUsuario.addTab("USUARIO", new ImageIcon(Tconfigurar.class.getResource("/img/configPequena.png")), panel_2, null);
		tabbedPaneCadastroUsuario.setForegroundAt(0, Color.WHITE);
		
		JLabel label_1 = new JLabel("");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabbedPaneCadastroUsuario.setVisible(false);
				tabbedPaneUsuarios.setVisible(true);
				
			}
		});
		label_1.setIcon(new ImageIcon(Tconfigurar.class.getResource("/img/voltar.png")));
		label_1.setToolTipText("Voltar");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(535, 2, 25, 32);
		panel_2.add(label_1);
		
		JLabel label_7 = new JLabel("Nome : ");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_7.setBounds(10, 27, 41, 14);
		panel_2.add(label_7);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(52, 24, 227, 20);
		panel_2.add(textField_1);
		
		JLabel lblLogin = new JLabel("Login : ");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setBounds(10, 53, 47, 14);
		panel_2.add(lblLogin);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(52, 50, 227, 20);
		panel_2.add(textField_2);
		
		JLabel lblSenha = new JLabel("Senha : ");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(10, 81, 47, 14);
		panel_2.add(lblSenha);
		
		textField_3 = new JPasswordField();
		textField_3.setColumns(10);
		textField_3.setBounds(52, 78, 227, 20);
		panel_2.add(textField_3);
		
		JLabel lblFuno = new JLabel("Fun\u00E7\u00E3o : ");
		lblFuno.setForeground(Color.WHITE);
		lblFuno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFuno.setBounds(10, 109, 73, 14);
		panel_2.add(lblFuno);
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBounds(62, 106, 217, 20);
		panel_2.add(passwordField);
		
		JLabel lblNivel = new JLabel("Nivel : ");
		lblNivel.setForeground(Color.WHITE);
		lblNivel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNivel.setBounds(10, 134, 41, 14);
		panel_2.add(lblNivel);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"ADMINISTRADOR", "SUPERVISOR", "USUARIO"}));
		comboBox_1.setBounds(52, 134, 159, 20);
		panel_2.add(comboBox_1);
		
		JLabel lblPadroPrivilegios = new JLabel("Padr\u00E3o Privilegios :");
		lblPadroPrivilegios.setForeground(Color.WHITE);
		lblPadroPrivilegios.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPadroPrivilegios.setBounds(10, 159, 125, 14);
		panel_2.add(lblPadroPrivilegios);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"PADR\u00C3O USUARIO", "PERSONALIZADO"}));
		comboBox_2.setBounds(120, 156, 159, 20);
		panel_2.add(comboBox_2);
		
		JCheckBox chckbxPermitirCadastroE = new JCheckBox("Permitir Altera\u00E7\u00E3o e Cadastro de Usuarios?");
		chckbxPermitirCadastroE.setOpaque(false);
		chckbxPermitirCadastroE.setForeground(Color.WHITE);
		chckbxPermitirCadastroE.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxPermitirCadastroE.setFocusable(false);
		chckbxPermitirCadastroE.setBounds(10, 180, 269, 32);
		panel_2.add(chckbxPermitirCadastroE);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Permitir Altera\u00E7\u00E3o de Privilegio?");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxNewCheckBox.setForeground(Color.WHITE);
		chckbxNewCheckBox.setFocusable(false);
		chckbxNewCheckBox.setOpaque(false);
		chckbxNewCheckBox.setBounds(10, 209, 269, 23);
		panel_2.add(chckbxNewCheckBox);
		
		JCheckBox checkBox_10 = new JCheckBox("Usuario Ativo ?");
		checkBox_10.setOpaque(false);
		checkBox_10.setForeground(Color.WHITE);
		checkBox_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBox_10.setFocusable(false);
		checkBox_10.setBounds(10, 229, 125, 23);
		panel_2.add(checkBox_10);
		
		JCheckBox chckbxAtivoParaAcesso = new JCheckBox("Ativo Para Acesso ao Site ?");
		chckbxAtivoParaAcesso.setOpaque(false);
		chckbxAtivoParaAcesso.setForeground(Color.WHITE);
		chckbxAtivoParaAcesso.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxAtivoParaAcesso.setFocusable(false);
		chckbxAtivoParaAcesso.setBounds(10, 255, 269, 23);
		panel_2.add(chckbxAtivoParaAcesso);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(301, 27, 2, 326);
		panel_2.add(separator_1);
		
		JTabbedPane tabbedPanePrivilegios = new JTabbedPane(JTabbedPane.TOP);
		tabbedPanePrivilegios.setFocusable(false);
		tabbedPanePrivilegios.setBounds(313, 35, 247, 318);
		panel_2.add(tabbedPanePrivilegios);
		
		JPanel panel_3 = new JPanel();
		panel_3.setFocusable(false);
		panel_3.setBackground(Color.WHITE);
		tabbedPanePrivilegios.addTab("PRIVILEGIOS GERAIS", null, panel_3, null);
		tabbedPanePrivilegios.setForegroundAt(0, Color.WHITE);
		panel_3.setLayout(null);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Cadastro e Altera\u00E7\u00E3o de Dados e Clientes?");
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxNewCheckBox_1.setFocusable(false);
		chckbxNewCheckBox_1.setBounds(0, 7, 236, 23);
		panel_3.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxCadastroEAlterao = new JCheckBox("Cadastro e Altera\u00E7\u00E3o da Agenda");
		chckbxCadastroEAlterao.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxCadastroEAlterao.setFocusable(false);
		chckbxCadastroEAlterao.setBounds(0, 33, 236, 23);
		panel_3.add(chckbxCadastroEAlterao);
		
		JCheckBox chckbxCadastroDeProcedimentos = new JCheckBox("Acesso a Recebimentos e Pagamentos?");
		chckbxCadastroDeProcedimentos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxCadastroDeProcedimentos.setFocusable(false);
		chckbxCadastroDeProcedimentos.setBounds(0, 60, 236, 23);
		panel_3.add(chckbxCadastroDeProcedimentos);
		
		JCheckBox chckbxCadastroEAlterao_1 = new JCheckBox("Realizar Simula\u00E7\u00E3o de Or\u00E7amentos?");
		chckbxCadastroEAlterao_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxCadastroEAlterao_1.setFocusable(false);
		chckbxCadastroEAlterao_1.setBounds(0, 86, 236, 23);
		panel_3.add(chckbxCadastroEAlterao_1);
		
		JCheckBox chckbxSincronizaoDeDados = new JCheckBox("Sincroniza\u00E7\u00E3o de Dados com o Site?");
		chckbxSincronizaoDeDados.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxSincronizaoDeDados.setFocusable(false);
		chckbxSincronizaoDeDados.setBounds(0, 191, 236, 23);
		panel_3.add(chckbxSincronizaoDeDados);
		
		JCheckBox chckbxCadastroEAlterao_2 = new JCheckBox("Cadastro e Altera\u00E7\u00E3o de Servi\u00E7os?");
		chckbxCadastroEAlterao_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxCadastroEAlterao_2.setFocusable(false);
		chckbxCadastroEAlterao_2.setBounds(0, 112, 236, 23);
		panel_3.add(chckbxCadastroEAlterao_2);
		
		JCheckBox chckbxRealizarRecebimento = new JCheckBox("Acesso ao Livro Caixa?");
		chckbxRealizarRecebimento.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxRealizarRecebimento.setFocusable(false);
		chckbxRealizarRecebimento.setBounds(0, 138, 236, 23);
		panel_3.add(chckbxRealizarRecebimento);
		
		JCheckBox chckbxRecebimentoAvuso = new JCheckBox("Realizar Chamada de Fila?");
		chckbxRecebimentoAvuso.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxRecebimentoAvuso.setFocusable(false);
		chckbxRecebimentoAvuso.setBounds(0, 165, 236, 23);
		panel_3.add(chckbxRecebimentoAvuso);
		
		JCheckBox chckbxAcessoAConfiguraes = new JCheckBox("Acesso a Configura\u00E7\u00F5es");
		chckbxAcessoAConfiguraes.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxAcessoAConfiguraes.setFocusable(false);
		chckbxAcessoAConfiguraes.setBounds(0, 243, 236, 23);
		panel_3.add(chckbxAcessoAConfiguraes);
		
		JCheckBox chckbxAtualizarSistema = new JCheckBox("Atualizar Sistema?");
		chckbxAtualizarSistema.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxAtualizarSistema.setFocusable(false);
		chckbxAtualizarSistema.setBounds(0, 217, 236, 23);
		panel_3.add(chckbxAtualizarSistema);
		
		JCheckBox chckbxCadastroEAlterao_3 = new JCheckBox("Cadastro e Altera\u00E7\u00E3o de Empresa?");
		chckbxCadastroEAlterao_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxCadastroEAlterao_3.setFocusable(false);
		chckbxCadastroEAlterao_3.setBounds(0, 269, 236, 23);
		panel_3.add(chckbxCadastroEAlterao_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		tabbedPanePrivilegios.addTab("FINANCEIRO", null, panel_4, null);
		tabbedPanePrivilegios.setForegroundAt(1, Color.WHITE);
		panel_4.setLayout(null);
		
		JCheckBox chckbxRealizarRecebimento_1 = new JCheckBox("Realizar Recebimento?");
		chckbxRealizarRecebimento_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxRealizarRecebimento_1.setFocusable(false);
		chckbxRealizarRecebimento_1.setBounds(0, 7, 236, 23);
		panel_4.add(chckbxRealizarRecebimento_1);
		
		JCheckBox chckbxRecebimentoAvuso_1 = new JCheckBox("Realizar Recebimento Avuso?");
		chckbxRecebimentoAvuso_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxRecebimentoAvuso_1.setFocusable(false);
		chckbxRecebimentoAvuso_1.setBounds(0, 33, 236, 23);
		panel_4.add(chckbxRecebimentoAvuso_1);
		
		JCheckBox chckbxExcluirParcelasFinanceiras = new JCheckBox("Excluir Parcelas Financeiras?");
		chckbxExcluirParcelasFinanceiras.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxExcluirParcelasFinanceiras.setFocusable(false);
		chckbxExcluirParcelasFinanceiras.setBounds(0, 60, 236, 23);
		panel_4.add(chckbxExcluirParcelasFinanceiras);
		
		JCheckBox chckbxEstornarRecebimentos = new JCheckBox("Estornar Recebimentos?");
		chckbxEstornarRecebimentos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxEstornarRecebimentos.setFocusable(false);
		chckbxEstornarRecebimentos.setBounds(0, 86, 236, 23);
		panel_4.add(chckbxEstornarRecebimentos);
		
		JCheckBox chckbxAcessoAFolha = new JCheckBox("Acesso a Folha de Pagamento?");
		chckbxAcessoAFolha.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxAcessoAFolha.setFocusable(false);
		chckbxAcessoAFolha.setBounds(0, 191, 236, 23);
		panel_4.add(chckbxAcessoAFolha);
		
		JCheckBox chckbxAcessoAoGerenciador = new JCheckBox("Acesso ao Gerenciador Financeiro?");
		chckbxAcessoAoGerenciador.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxAcessoAoGerenciador.setFocusable(false);
		chckbxAcessoAoGerenciador.setBounds(0, 112, 236, 23);
		panel_4.add(chckbxAcessoAoGerenciador);
		
		JCheckBox chckbxCadastroEAlterao_4 = new JCheckBox("Cadastro e Altera\u00E7\u00E3o de Bancos e Contas?");
		chckbxCadastroEAlterao_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxCadastroEAlterao_4.setFocusable(false);
		chckbxCadastroEAlterao_4.setBounds(0, 138, 236, 23);
		panel_4.add(chckbxCadastroEAlterao_4);
		
		JCheckBox chckbxCadastroEAlterao_5 = new JCheckBox("Cadastro e Altera\u00E7\u00E3o de Despesas?");
		chckbxCadastroEAlterao_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxCadastroEAlterao_5.setFocusable(false);
		chckbxCadastroEAlterao_5.setBounds(0, 165, 236, 23);
		panel_4.add(chckbxCadastroEAlterao_5);
		
		JCheckBox chckbxAcessoARelatroios = new JCheckBox("Acesso a Relatroios?");
		chckbxAcessoARelatroios.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxAcessoARelatroios.setFocusable(false);
		chckbxAcessoARelatroios.setBounds(0, 243, 236, 23);
		panel_4.add(chckbxAcessoARelatroios);
		
		JCheckBox chckbxCadastroEAlterao_6 = new JCheckBox("Cadastro e Altera\u00E7\u00E3o de Fornecedores");
		chckbxCadastroEAlterao_6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxCadastroEAlterao_6.setFocusable(false);
		chckbxCadastroEAlterao_6.setBounds(0, 217, 236, 23);
		panel_4.add(chckbxCadastroEAlterao_6);
		
		JCheckBox chckbxCadastroDeFuncionarios = new JCheckBox("Cadastro de Funcionarios?");
		chckbxCadastroDeFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxCadastroDeFuncionarios.setFocusable(false);
		chckbxCadastroDeFuncionarios.setBounds(0, 269, 236, 23);
		panel_4.add(chckbxCadastroDeFuncionarios);
		
		JLabel label_8 = new JLabel("");
		label_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_8.setIcon(new ImageIcon(Tconfigurar.class.getResource("/img/save.png")));
		label_8.setToolTipText("Salvar");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(272, 366, 47, 32);
		panel_2.add(label_8);
		
		JLabel label_14 = new JLabel("");
		label_14.setIcon(new ImageIcon(Tconfigurar.class.getResource("/img/bk.jpeg")));
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBounds(0, 2, 570, 409);
		panel_2.add(label_14);

	}
}
