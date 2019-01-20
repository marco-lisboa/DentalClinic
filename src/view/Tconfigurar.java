package view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;

import control.Usuario;

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
	private JTextField tx_nome;
	private JTextField tx_login;
	private JPasswordField tx_senha;
	private JTextField tx_funcao;
	private JTabbedPane tabbedPaneCadastroUsuario;
	private JTabbedPane tabbedPaneUsuarios;
	private JTabbedPane tabbedPanePrincipal;
	private Usuario usuario = new Usuario();
	private JComboBox nivelUsuario;
	private JComboBox padraoPrivilegios;
	private JCheckBox PermitirCadastroE;
	private JCheckBox alteraPrivilegio;
	private JCheckBox situacao;
	private JCheckBox ativoSite;
	private JCheckBox priviCadastroEAlteraoAgenda;
	private JCheckBox priviCadastroAlteraCliente;
	private JCheckBox priviAcessoRebimentosPagamentos;
	private JCheckBox priviSimuOrcamento;
	private JCheckBox priviCadastroAlteraServico;
	private JCheckBox priviAcessoLivroCaixa;
	private JCheckBox priviChamadaFila;
	private JCheckBox priviAcessoAConfiguraes;
	private JCheckBox priviAtualizarSistema;
	private JCheckBox priviSincronizaoDeDados;
	private JCheckBox priviCadastroEAlterao;
	private JCheckBox priviRealizarRecebimento;
	private JCheckBox priviRecebimentoAvuso;
	private JCheckBox priviExcluirParcelasFinanceiras;
	private JCheckBox priveCadastroEAlteraoBacosContas;
	private JCheckBox priveCadastroDeFuncionarios;
	private JCheckBox priviAcessoRelatroios;
	private JCheckBox priveCadastroEAlteraoDespesas;
	private JCheckBox priveAcessoAFolha;
	private JCheckBox priveAcessoAoGerenciador;
	private JCheckBox priveEstornarRecebimentos;
	private JCheckBox priveCadastroEAlteraoFornecedores;
	
	

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
		
		tabbedPaneCadastroUsuario = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneCadastroUsuario.setVisible(false);
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
		
		tx_nome = new JTextField();
		tx_nome.setColumns(10);
		tx_nome.setBounds(52, 24, 227, 20);
		panel_2.add(tx_nome);
		
		JLabel lblLogin = new JLabel("Login : ");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setBounds(10, 53, 47, 14);
		panel_2.add(lblLogin);
		
		tx_login = new JTextField();
		tx_login.setColumns(10);
		tx_login.setBounds(52, 50, 227, 20);
		panel_2.add(tx_login);
		
		JLabel lblSenha = new JLabel("Senha : ");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(10, 81, 47, 14);
		panel_2.add(lblSenha);
		
		tx_senha = new JPasswordField();
		tx_senha.setColumns(10);
		tx_senha.setBounds(52, 78, 227, 20);
		panel_2.add(tx_senha);
		
		JLabel lblFuno = new JLabel("Fun\u00E7\u00E3o : ");
		lblFuno.setForeground(Color.WHITE);
		lblFuno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFuno.setBounds(10, 109, 73, 14);
		panel_2.add(lblFuno);
		
		tx_funcao = new JTextField();
		tx_funcao.setColumns(10);
		tx_funcao.setBounds(62, 106, 217, 20);
		panel_2.add(tx_funcao);
		
		JLabel lblNivel = new JLabel("Nivel : ");
		lblNivel.setForeground(Color.WHITE);
		lblNivel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNivel.setBounds(10, 134, 41, 14);
		panel_2.add(lblNivel);
		
		nivelUsuario = new JComboBox();
		nivelUsuario.setModel(new DefaultComboBoxModel(new String[] {"ADMINISTRADOR", "SUPERVISOR", "USUARIO"}));
		nivelUsuario.setBounds(52, 134, 159, 20);
		panel_2.add(nivelUsuario);
		
		JLabel lblPadroPrivilegios = new JLabel("Padr\u00E3o Privilegios :");
		lblPadroPrivilegios.setForeground(Color.WHITE);
		lblPadroPrivilegios.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPadroPrivilegios.setBounds(10, 159, 125, 14);
		panel_2.add(lblPadroPrivilegios);
		
		padraoPrivilegios = new JComboBox();
		padraoPrivilegios.setModel(new DefaultComboBoxModel(new String[] {"PADR\u00C3O USUARIO", "PERSONALIZADO"}));
		padraoPrivilegios.setBounds(120, 156, 159, 20);
		panel_2.add(padraoPrivilegios);
		
		PermitirCadastroE = new JCheckBox("Permitir Altera\u00E7\u00E3o e Cadastro de Usuarios?");
		PermitirCadastroE.setOpaque(false);
		PermitirCadastroE.setForeground(Color.WHITE);
		PermitirCadastroE.setFont(new Font("Tahoma", Font.BOLD, 11));
		PermitirCadastroE.setFocusable(false);
		PermitirCadastroE.setBounds(10, 180, 269, 32);
		panel_2.add(PermitirCadastroE);
		
		alteraPrivilegio = new JCheckBox("Permitir Altera\u00E7\u00E3o de Privilegio?");
		alteraPrivilegio.setFont(new Font("Tahoma", Font.BOLD, 11));
		alteraPrivilegio.setForeground(Color.WHITE);
		alteraPrivilegio.setFocusable(false);
		alteraPrivilegio.setOpaque(false);
		alteraPrivilegio.setBounds(10, 209, 269, 23);
		panel_2.add(alteraPrivilegio);
		
		situacao = new JCheckBox("Usuario Ativo ?");
		situacao.setOpaque(false);
		situacao.setForeground(Color.WHITE);
		situacao.setFont(new Font("Tahoma", Font.BOLD, 11));
		situacao.setFocusable(false);
		situacao.setBounds(10, 229, 125, 23);
		panel_2.add(situacao);
		
		ativoSite = new JCheckBox("Ativo Para Acesso ao Site ?");
		ativoSite.setOpaque(false);
		ativoSite.setForeground(Color.WHITE);
		ativoSite.setFont(new Font("Tahoma", Font.BOLD, 11));
		ativoSite.setFocusable(false);
		ativoSite.setBounds(10, 255, 269, 23);
		panel_2.add(ativoSite);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(301, 27, 2, 326);
		panel_2.add(separator_1);
		
		JTabbedPane tabbedPanePrivilegios = new JTabbedPane(JTabbedPane.TOP);
		tabbedPanePrivilegios.setFocusable(false);
		tabbedPanePrivilegios.setBounds(313, 35, 247, 318);
		panel_2.add(tabbedPanePrivilegios);
		
		JPanel geral = new JPanel();
		geral.setFocusable(false);
		geral.setBackground(Color.WHITE);
		tabbedPanePrivilegios.addTab("PRIVILEGIOS GERAIS", null, geral, null);
		tabbedPanePrivilegios.setForegroundAt(0, Color.WHITE);
		geral.setLayout(null);
		
		priviCadastroAlteraCliente = new JCheckBox("Cadastro e Altera\u00E7\u00E3o de Dados e Clientes?");
		priviCadastroAlteraCliente.setFont(new Font("Tahoma", Font.PLAIN, 10));
		priviCadastroAlteraCliente.setFocusable(false);
		priviCadastroAlteraCliente.setBounds(0, 7, 236, 23);
		geral.add(priviCadastroAlteraCliente);
		
		priviCadastroEAlteraoAgenda = new JCheckBox("Cadastro e Altera\u00E7\u00E3o da Agenda");
		priviCadastroEAlteraoAgenda.setFont(new Font("Tahoma", Font.PLAIN, 10));
		priviCadastroEAlteraoAgenda.setFocusable(false);
		priviCadastroEAlteraoAgenda.setBounds(0, 33, 236, 23);
		geral.add(priviCadastroEAlteraoAgenda);
		
		priviAcessoRebimentosPagamentos = new JCheckBox("Acesso a Recebimentos e Pagamentos?");
		priviAcessoRebimentosPagamentos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		priviAcessoRebimentosPagamentos.setFocusable(false);
		priviAcessoRebimentosPagamentos.setBounds(0, 60, 236, 23);
		geral.add(priviAcessoRebimentosPagamentos);
		
		priviSimuOrcamento = new JCheckBox("Realizar Simula\u00E7\u00E3o de Or\u00E7amentos?");
		priviSimuOrcamento.setFont(new Font("Tahoma", Font.PLAIN, 10));
		priviSimuOrcamento.setFocusable(false);
		priviSimuOrcamento.setBounds(0, 86, 236, 23);
		geral.add(priviSimuOrcamento);
		
		priviCadastroAlteraServico = new JCheckBox("Cadastro e Altera\u00E7\u00E3o de Servi\u00E7os?");
		priviCadastroAlteraServico.setFont(new Font("Tahoma", Font.PLAIN, 10));
		priviCadastroAlteraServico.setFocusable(false);
		priviCadastroAlteraServico.setBounds(0, 112, 236, 23);
		geral.add(priviCadastroAlteraServico);
		
		priviAcessoLivroCaixa = new JCheckBox("Acesso ao Livro Caixa?");
		priviAcessoLivroCaixa.setFont(new Font("Tahoma", Font.PLAIN, 10));
		priviAcessoLivroCaixa.setFocusable(false);
		priviAcessoLivroCaixa.setBounds(0, 138, 236, 23);
		geral.add(priviAcessoLivroCaixa);
		
		priviChamadaFila = new JCheckBox("Realizar Chamada de Fila?");
		priviChamadaFila.setFont(new Font("Tahoma", Font.PLAIN, 10));
		priviChamadaFila.setFocusable(false);
		priviChamadaFila.setBounds(0, 165, 236, 23);
		geral.add(priviChamadaFila);
		
		priviSincronizaoDeDados = new JCheckBox("Sincroniza\u00E7\u00E3o de Dados com o Site?");
		priviSincronizaoDeDados.setFont(new Font("Tahoma", Font.PLAIN, 10));
		priviSincronizaoDeDados.setFocusable(false);
		priviSincronizaoDeDados.setBounds(0, 191, 236, 23);
		geral.add(priviSincronizaoDeDados);
		
		priviAtualizarSistema = new JCheckBox("Atualizar Sistema?");
		priviAtualizarSistema.setFont(new Font("Tahoma", Font.PLAIN, 10));
		priviAtualizarSistema.setFocusable(false);
		priviAtualizarSistema.setBounds(0, 217, 236, 23);
		geral.add(priviAtualizarSistema);
		
		priviAcessoAConfiguraes = new JCheckBox("Acesso a Configura\u00E7\u00F5es");
		priviAcessoAConfiguraes.setFont(new Font("Tahoma", Font.PLAIN, 10));
		priviAcessoAConfiguraes.setFocusable(false);
		priviAcessoAConfiguraes.setBounds(0, 243, 236, 23);
		geral.add(priviAcessoAConfiguraes);
		
		priviCadastroEAlterao = new JCheckBox("Cadastro e Altera\u00E7\u00E3o de Empresa?");
		priviCadastroEAlterao.setFont(new Font("Tahoma", Font.PLAIN, 10));
		priviCadastroEAlterao.setFocusable(false);
		priviCadastroEAlterao.setBounds(0, 269, 236, 23);
		geral.add(priviCadastroEAlterao);
		
		JPanel financeiro = new JPanel();
		financeiro.setBackground(Color.WHITE);
		tabbedPanePrivilegios.addTab("FINANCEIRO", null, financeiro, null);
		tabbedPanePrivilegios.setForegroundAt(1, Color.WHITE);
		financeiro.setLayout(null);
		
		priviRealizarRecebimento = new JCheckBox("Realizar Recebimento?");
		priviRealizarRecebimento.setFont(new Font("Tahoma", Font.PLAIN, 10));
		priviRealizarRecebimento.setFocusable(false);
		priviRealizarRecebimento.setBounds(0, 7, 236, 23);
		financeiro.add(priviRealizarRecebimento);
		
		priviRecebimentoAvuso = new JCheckBox("Realizar Recebimento Avuso?");
		priviRecebimentoAvuso.setFont(new Font("Tahoma", Font.PLAIN, 10));
		priviRecebimentoAvuso.setFocusable(false);
		priviRecebimentoAvuso.setBounds(0, 33, 236, 23);
		financeiro.add(priviRecebimentoAvuso);
		
		priviExcluirParcelasFinanceiras = new JCheckBox("Excluir Parcelas Financeiras?");
		priviExcluirParcelasFinanceiras.setFont(new Font("Tahoma", Font.PLAIN, 10));
		priviExcluirParcelasFinanceiras.setFocusable(false);
		priviExcluirParcelasFinanceiras.setBounds(0, 60, 236, 23);
		financeiro.add(priviExcluirParcelasFinanceiras);
		
		priveEstornarRecebimentos = new JCheckBox("Estornar Recebimentos?");
		priveEstornarRecebimentos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		priveEstornarRecebimentos.setFocusable(false);
		priveEstornarRecebimentos.setBounds(0, 86, 236, 23);
		financeiro.add(priveEstornarRecebimentos);
		
		priveAcessoAoGerenciador = new JCheckBox("Acesso ao Gerenciador Financeiro?");
		priveAcessoAoGerenciador.setFont(new Font("Tahoma", Font.PLAIN, 10));
		priveAcessoAoGerenciador.setFocusable(false);
		priveAcessoAoGerenciador.setBounds(0, 112, 236, 23);
		financeiro.add(priveAcessoAoGerenciador);
		
		priveCadastroEAlteraoBacosContas = new JCheckBox("Cadastro e Altera\u00E7\u00E3o de Bancos e Contas?");
		priveCadastroEAlteraoBacosContas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		priveCadastroEAlteraoBacosContas.setFocusable(false);
		priveCadastroEAlteraoBacosContas.setBounds(0, 138, 236, 23);
		financeiro.add(priveCadastroEAlteraoBacosContas);
		
		priveCadastroEAlteraoDespesas = new JCheckBox("Cadastro e Altera\u00E7\u00E3o de Despesas?");
		priveCadastroEAlteraoDespesas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		priveCadastroEAlteraoDespesas.setFocusable(false);
		priveCadastroEAlteraoDespesas.setBounds(0, 165, 236, 23);
		financeiro.add(priveCadastroEAlteraoDespesas);
		
		priveAcessoAFolha = new JCheckBox("Acesso a Folha de Pagamento?");
		priveAcessoAFolha.setFont(new Font("Tahoma", Font.PLAIN, 10));
		priveAcessoAFolha.setFocusable(false);
		priveAcessoAFolha.setBounds(0, 191, 236, 23);
		financeiro.add(priveAcessoAFolha);
		
		priveCadastroEAlteraoFornecedores = new JCheckBox("Cadastro e Altera\u00E7\u00E3o de Fornecedores");
		priveCadastroEAlteraoFornecedores.setFont(new Font("Tahoma", Font.PLAIN, 10));
		priveCadastroEAlteraoFornecedores.setFocusable(false);
		priveCadastroEAlteraoFornecedores.setBounds(0, 217, 236, 23);
		financeiro.add(priveCadastroEAlteraoFornecedores);
		
		priviAcessoRelatroios = new JCheckBox("Acesso a Relatroios?");
		priviAcessoRelatroios.setFont(new Font("Tahoma", Font.PLAIN, 10));
		priviAcessoRelatroios.setFocusable(false);
		priviAcessoRelatroios.setBounds(0, 243, 236, 23);
		financeiro.add(priviAcessoRelatroios);
		
		priveCadastroDeFuncionarios = new JCheckBox("Cadastro de Funcionarios?");
		priveCadastroDeFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 10));
		priveCadastroDeFuncionarios.setFocusable(false);
		priveCadastroDeFuncionarios.setBounds(0, 269, 236, 23);
		financeiro.add(priveCadastroDeFuncionarios);
		
		JLabel btSalvar = new JLabel("");
		btSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btSalvar.setIcon(new ImageIcon(Tconfigurar.class.getResource("/img/save.png")));
		btSalvar.setToolTipText("Salvar");
		btSalvar.setHorizontalAlignment(SwingConstants.CENTER);
		btSalvar.setBounds(272, 366, 47, 32);
		panel_2.add(btSalvar);
		
		JLabel label_14 = new JLabel("");
		label_14.setIcon(new ImageIcon(Tconfigurar.class.getResource("/img/bk.jpeg")));
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBounds(0, 2, 570, 409);
		panel_2.add(label_14);
		
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
		label_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		label_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_5.setIcon(new ImageIcon(Tconfigurar.class.getResource("/img/editar (2).png")));
		label_5.setToolTipText("Editar");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(281, 355, 46, 43);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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

	}
	
	public void varreDados() {
		
	}
}
