package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import control.Iniciador;
import control.Usuario;
import dao.DaoConnect;
import viewTavisos.*;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuItem;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class T_024_configurar extends JPanel {
	int acao;
	TavisoConfiguracao avisoAcao = new TavisoConfiguracao();
	Taviso aviso = new Taviso();
	public int idUusuarioLogado;
	private JTable tableUsuario;
	private JTextField txbuscar;
	private JTextField tx_nome;
	private JTextField tx_login;
	private JPasswordField tx_senha;
	private JTextField tx_funcao;
	private JTabbedPane tabbedPaneCadastroUsuario;
	private JTabbedPane tabbedPaneUsuarios;
	private JTabbedPane tabbedPanePrincipal;
	private Iniciador iniciar = new Iniciador();
	private Usuario usuario = new Usuario();
	private DaoConnect dao = new DaoConnect();
	private JComboBox nivelUsuario;
	private JComboBox padraoPrivilegios;
	private JCheckBox PermitirCadastroUsuarios;
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
	private JCheckBox priviCadastroEAlteraEmpresa;
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
	String[] coluna  = {"Matricula", "Nome", "Função"};
	String [][] linhas = {};
	private DefaultTableModel tabela = new DefaultTableModel(linhas, coluna){
		public boolean isCellEditable(int linhas, int coluna) {
			
			if(coluna==1){
				return true;
			}else{
				return false;
			}
			
		}
	};
	private JScrollPane scroll;
	private JComboBox cbsit;
	private JLabel numRegistro;
	private JTextField textField;
	private JTable table;
	private JTabbedPane tabbedPaneEmpresa;
	
	  private JTable getTabela(){
	    	if(tableUsuario==null){
	    		tableUsuario = new JTable(tabela);
	    		tableUsuario.addMouseListener(new MouseAdapter() {
	    			public void mouseReased(MouseEvent e){
	    				
	    				int i = tableUsuario.getSelectedRow();
	    				Object x = tableUsuario.getValueAt(i, 1);
	    				String codigo = x+"";
	    			}

	    		});
	    	}
	    	return tableUsuario;

	    }

	    
	    
	    
		private JScrollPane getScroll(){
			if (scroll==null){
				scroll = new JScrollPane();
				scroll.setBackground(SystemColor.text);
				scroll.setViewportView(getTabela());
				scroll.setBounds(56,166,225,256);
				defineRenderers();
			}
			
			
			
			return scroll;
			
		}

		private void defineRenderers() {
			
			tableUsuario.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			JTableHeader header = tableUsuario.getTableHeader();
			header.setPreferredSize(new Dimension(2000, 25));
			TableColumnModel modColuna = tableUsuario.getColumnModel();
			
			modColuna.getColumn(0).setPreferredWidth(50);
			modColuna.getColumn(1).setPreferredWidth(150);
			modColuna.getColumn(2).setPreferredWidth(150);
			
			
		}
	/**
	 * Create the panel.
	 */
	public T_024_configurar() {
		
		
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
		tabbedPanePrincipal.addTab("Configura\u00E7\u00E3o", new ImageIcon(T_024_configurar.class.getResource("/img/configPequena.png")), panel, null);
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
		lblNewLabel_1.setIcon(new ImageIcon(T_004_ficha_paciente.class.getResource("/img/voltar.png")));
		lblNewLabel_1.setBounds(535, 2, 25, 32);
		panel.add(lblNewLabel_1);
		
		JButton btnUsuario = new JButton("Empresa");
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPanePrincipal.setVisible(false);
				tabbedPaneUsuarios.setVisible(false);
				tabbedPaneEmpresa.setVisible(true);
			}
		});
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
				tabbedPaneEmpresa.setVisible(false);
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
		bk.setIcon(new ImageIcon(T_003_livro_consulta.class.getResource("/img/bk.jpeg")));
		bk.setBounds(0, 2, 570, 409);
		panel.add(bk);
		tabbedPaneUsuarios = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneUsuarios.setVisible(false);
		
		tabbedPaneEmpresa = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneEmpresa.setVisible(false);
		tabbedPaneEmpresa.setBounds(0, 0, 575, 428);
		add(tabbedPaneEmpresa);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setForeground(Color.WHITE);
		panel_3.setBackground(new Color(32, 178, 170));
		tabbedPaneEmpresa.addTab("Empresa", new ImageIcon(T_024_configurar.class.getResource("/img/configPequena.png")), panel_3, null);
		tabbedPaneEmpresa.setForegroundAt(0, Color.WHITE);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabbedPaneEmpresa.setVisible(false);
				tabbedPanePrincipal.setVisible(true);
			}
		});
		label_3.setIcon(new ImageIcon(T_024_configurar.class.getResource("/img/voltar.png")));
		label_3.setToolTipText("Voltar");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(535, 2, 25, 32);
		panel_3.add(label_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 550, 244);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel label_4 = new JLabel("Nome : ");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(10, 11, 46, 14);
		panel_3.add(label_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(52, 8, 145, 20);
		panel_3.add(textField);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(T_024_configurar.class.getResource("/img/buscar.png")));
		label_5.setToolTipText("Buscar");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(207, 2, 46, 32);
		panel_3.add(label_5);
		
		JLabel label_6 = new JLabel("Situa\u00E7\u00E3o : ");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(10, 39, 89, 14);
		panel_3.add(label_6);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(73, 36, 145, 20);
		panel_3.add(comboBox);
		
		JLabel label_8 = new JLabel();
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_8.setBounds(10, 368, 208, 14);
		panel_3.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(T_024_configurar.class.getResource("/img/add.png")));
		label_9.setToolTipText("Adicionar Novo Paciente");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(221, 355, 46, 43);
		panel_3.add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(T_024_configurar.class.getResource("/img/editar (2).png")));
		label_10.setToolTipText("Editar");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBounds(281, 355, 46, 43);
		panel_3.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(T_024_configurar.class.getResource("/img/deleta.png")));
		label_11.setToolTipText("Remover Usuario");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(337, 355, 46, 43);
		panel_3.add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(T_024_configurar.class.getResource("/img/bk.jpeg")));
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(0, 2, 570, 409);
		panel_3.add(label_12);
		tabbedPaneUsuarios.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneUsuarios.setBorder(null);
		tabbedPaneUsuarios.setBackground(new Color(32, 178, 170));
		tabbedPaneUsuarios.setBounds(0, 0, 575, 428);
		add(tabbedPaneUsuarios);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(32, 178, 170));
		tabbedPaneUsuarios.addTab("USUARIO", new ImageIcon(T_024_configurar.class.getResource("/img/configPequena.png")), panel_1, null);
		tabbedPaneUsuarios.setForegroundAt(0, Color.WHITE);
		
		JLabel voltarUsuarios = new JLabel("");
		voltarUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		voltarUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPaneUsuarios.setVisible(false);
				tabbedPanePrincipal.setVisible(true);
				limpaCampos();
			}
		});
		voltarUsuarios.setIcon(new ImageIcon(T_024_configurar.class.getResource("/img/voltar.png")));
		voltarUsuarios.setToolTipText("Voltar");
		voltarUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		voltarUsuarios.setBounds(535, 2, 25, 32);
		panel_1.add(voltarUsuarios);
		
		scroll = new JScrollPane();
		scroll.setBounds(10, 100, 550, 244);
		panel_1.add(scroll);
		
		tableUsuario = new JTable();
		tableUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent click) {
				if(click.getClickCount()==2) {
					acao =1;
					int linha;
					Object codigo;
					linha= tableUsuario.getSelectedRow();
					codigo =  tableUsuario.getValueAt(linha, 0);
					
					usuario.setUsuarioId(Integer.parseInt(codigo.toString()));
					prencheCampos();
				}
			}
		});
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(scroll, popupMenu);
		
		JMenuItem menuItem = new JMenuItem("Novo Cadastro");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				acao= 0;
				checaPrivilegio();
			}
		});
		menuItem.setHorizontalAlignment(SwingConstants.CENTER);
		popupMenu.add(menuItem);
		
		JSeparator separator_2 = new JSeparator();
		popupMenu.add(separator_2);
		
		JMenuItem menuItem_1 = new JMenuItem("Editar Cadastro");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acao =1;
				int linha;
				Object codigo;
				linha= tableUsuario.getSelectedRow();
				codigo =  tableUsuario.getValueAt(linha, 0);
				
				usuario.setUsuarioId(Integer.parseInt(codigo.toString()));
				prencheCampos();
			}
		});
		popupMenu.add(menuItem_1);
		
		JSeparator separator_3 = new JSeparator();
		popupMenu.add(separator_3);
		
		JMenuItem menuItem_2 = new JMenuItem("Desativar");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int linha;
				Object codigo;
				linha= tableUsuario.getSelectedRow();
				codigo =  tableUsuario.getValueAt(linha, 0);

				if(linha < 0) {
					aviso.texto.setText("Nenhum Usuario Selecionado.");
					aviso.setLocationRelativeTo(null);
					aviso.show();
					
				}else {

					usuario.setUsuarioId(Integer.parseInt(codigo.toString()));
					avisoAcao.id=usuario.getUsuarioId();
					avisoAcao.acao=2;
					avisoAcao.texto.setText("Tem Certeza Deseja Realizar Esta Ação?");
					avisoAcao.setLocationRelativeTo(null);
					avisoAcao.show();
					
				}
				
				buscar();
			}
		});
		popupMenu.add(menuItem_2);
		
		JSeparator separator_4 = new JSeparator();
		popupMenu.add(separator_4);
		
		JMenuItem menuItem_3 = new JMenuItem("Excluir");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int linha;
				Object codigo;
				linha= tableUsuario.getSelectedRow();
				
				
				if(linha < 0) {
					aviso.texto.setText("Nenhum Usuario Selecionado.");
					aviso.setLocationRelativeTo(null);
					aviso.show();
					
				}else {
					codigo =  tableUsuario.getValueAt(linha, 0);
					usuario.setUsuarioId(Integer.parseInt(codigo.toString()));
					avisoAcao.id=usuario.getUsuarioId();
					avisoAcao.acao=1;
					avisoAcao.texto.setText("Tem Certeza Deseja Realizar Esta Ação?");
					avisoAcao.setLocationRelativeTo(null);
					avisoAcao.show();
				}
				
				buscar();
			}
		});
		popupMenu.add(menuItem_3);
		tableUsuario.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nome", "Função"
			}
		));
		scroll.setViewportView(tableUsuario);
		
		JLabel label = new JLabel("Nome : ");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 11, 46, 14);
		panel_1.add(label);
		
		txbuscar = new JTextField();
		txbuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					buscar();
				}
			}
		});
		txbuscar.setColumns(10);
		txbuscar.setBounds(52, 8, 145, 20);
		panel_1.add(txbuscar);
		
		JLabel btPesquisaUsuario = new JLabel("");
		btPesquisaUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buscar();
			}
		});
		btPesquisaUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btPesquisaUsuario.setIcon(new ImageIcon(T_024_configurar.class.getResource("/img/buscar.png")));
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
		
		cbsit = new JComboBox();
		cbsit.setModel(new DefaultComboBoxModel(new String[] {"Ativo", "Inativo", "Todos"}));
		cbsit.setBounds(73, 36, 145, 20);
		panel_1.add(cbsit);
		
		numRegistro = new JLabel();
		numRegistro.setIcon(new ImageIcon(T_024_configurar.class.getResource("/img/confimado.png")));
		numRegistro.setForeground(Color.WHITE);
		numRegistro.setFont(new Font("Tahoma", Font.BOLD, 11));
		numRegistro.setBounds(10, 368, 208, 14);
		panel_1.add(numRegistro);
		
		JLabel btAdicionar = new JLabel("");
		btAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btAdicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				acao= 0;
				checaPrivilegio();
			}
		});
		btAdicionar.setIcon(new ImageIcon(T_024_configurar.class.getResource("/img/add.png")));
		btAdicionar.setToolTipText("Adicionar Novo Paciente");
		btAdicionar.setHorizontalAlignment(SwingConstants.CENTER);
		btAdicionar.setBounds(221, 355, 46, 43);
		panel_1.add(btAdicionar);
		
		JLabel btEditar = new JLabel("");
		btEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				acao =1;
				int linha;
				Object codigo;
				linha= tableUsuario.getSelectedRow();
				codigo =  tableUsuario.getValueAt(linha, 0);
				
				usuario.setUsuarioId(Integer.parseInt(codigo.toString()));
				prencheCampos();
			}
		});
		btEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btEditar.setIcon(new ImageIcon(T_024_configurar.class.getResource("/img/editar (2).png")));
		btEditar.setToolTipText("Editar");
		btEditar.setHorizontalAlignment(SwingConstants.CENTER);
		btEditar.setBounds(281, 355, 46, 43);
		panel_1.add(btEditar);
		
		JLabel btDelete = new JLabel("");
		btDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				

				int linha;
				Object codigo;
				linha= tableUsuario.getSelectedRow();
				
				
				if(linha < 0) {
					aviso.texto.setText("Nenhum Usuario Selecionado.");
					aviso.setLocationRelativeTo(null);
					aviso.show();
					
				}else {
					codigo =  tableUsuario.getValueAt(linha, 0);
					usuario.setUsuarioId(Integer.parseInt(codigo.toString()));
					avisoAcao.id=usuario.getUsuarioId();
					avisoAcao.acao=1;
					avisoAcao.texto.setText("Tem Certeza Deseja Realizar Esta Ação?");
					avisoAcao.setLocationRelativeTo(null);
					avisoAcao.show();
				}
				
				buscar();
				
			}
		});
		btDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btDelete.setIcon(new ImageIcon(T_024_configurar.class.getResource("/img/deleta.png")));
		btDelete.setToolTipText("Remover Usuario");
		btDelete.setHorizontalAlignment(SwingConstants.CENTER);
		btDelete.setBounds(337, 355, 46, 43);
		panel_1.add(btDelete);
		
		JLabel bkUsuarios = new JLabel("");
		bkUsuarios.setIcon(new ImageIcon(T_024_configurar.class.getResource("/img/bk.jpeg")));
		bkUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		bkUsuarios.setBounds(0, 2, 570, 409);
		panel_1.add(bkUsuarios);
		
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
		tabbedPaneCadastroUsuario.addTab("USUARIO", new ImageIcon(T_024_configurar.class.getResource("/img/configPequena.png")), panel_2, null);
		tabbedPaneCadastroUsuario.setForegroundAt(0, Color.WHITE);
		
		JLabel label_1 = new JLabel("");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				limpaCampos();
				tabbedPaneCadastroUsuario.setVisible(false);
				tabbedPaneUsuarios.setVisible(true);
				
			}
		});
		label_1.setIcon(new ImageIcon(T_024_configurar.class.getResource("/img/voltar.png")));
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
		nivelUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
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
		
		PermitirCadastroUsuarios = new JCheckBox("Permitir Altera\u00E7\u00E3o e Cadastro de Usuarios?");
		PermitirCadastroUsuarios.setOpaque(false);
		PermitirCadastroUsuarios.setForeground(Color.WHITE);
		PermitirCadastroUsuarios.setFont(new Font("Tahoma", Font.BOLD, 11));
		PermitirCadastroUsuarios.setFocusable(false);
		PermitirCadastroUsuarios.setBounds(10, 180, 269, 32);
		panel_2.add(PermitirCadastroUsuarios);
		
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
		
		priviCadastroEAlteraEmpresa = new JCheckBox("Cadastro e Altera\u00E7\u00E3o de Empresa?");
		priviCadastroEAlteraEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 10));
		priviCadastroEAlteraEmpresa.setFocusable(false);
		priviCadastroEAlteraEmpresa.setBounds(0, 269, 236, 23);
		geral.add(priviCadastroEAlteraEmpresa);
		
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
		btSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				varreCampos();
				if(acao==1) {
					atualiza();
					}else {
						salvar();
						}
				
				buscar();
				
				tabbedPaneCadastroUsuario.setVisible(false);
				tabbedPaneUsuarios.setVisible(true);
			}
		});
		btSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btSalvar.setIcon(new ImageIcon(T_024_configurar.class.getResource("/img/save.png")));
		btSalvar.setToolTipText("Salvar");
		btSalvar.setHorizontalAlignment(SwingConstants.CENTER);
		btSalvar.setBounds(272, 366, 47, 32);
		panel_2.add(btSalvar);
		
		JLabel label_14 = new JLabel("");
		label_14.setIcon(new ImageIcon(T_024_configurar.class.getResource("/img/bk.jpeg")));
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBounds(0, 2, 570, 409);
		panel_2.add(label_14);

	}
	
	
	public void buscar() {
		usuario.setNomeUsuario(txbuscar.getText());
		if(cbsit.getSelectedItem()=="Ativo") {
			usuario.setSituacao(1);
		}else if(cbsit.getSelectedItem()=="Inativo") {
			usuario.setSituacao(0);
		}else {
			usuario.setSituacao(3);
		}
		
		leitura();
		try {
			dao.listUsuarios(tableUsuario, usuario);
			if(usuario.getNumeroRegistro()==1) {
				numRegistro.setText(usuario.getNumeroRegistro()+" registro encontrado");
			}else {
				numRegistro.setText(usuario.getNumeroRegistro()+" registros encontrados");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void varreCampos() {
		usuario.setNomeUsuario(tx_nome.getText());
		usuario.setLoginUsuario(tx_login.getText());
		usuario.setSenhaUsuario(tx_senha.getText());
		usuario.setFuncao(tx_funcao.getText());
		//Nivel usuario
		if(nivelUsuario.getSelectedItem()=="ADMINISTRADOR"){
			usuario.setNivelUsuario(1);
		}else if(nivelUsuario.getSelectedItem()=="SUPERVISOR") {
			usuario.setNivelUsuario(2);
		}else {
			usuario.setNivelUsuario(3);
		}
		//Padrão privilegios
		if(padraoPrivilegios.getSelectedItem()=="PADR\u00C3O USUARIO") {
			usuario.setPadrao(1);
		}else {
			usuario.setPadrao(0);
		}
		//Privilegios Padrão
		if(PermitirCadastroUsuarios.isSelected()==true) {
			usuario.setCadastro(1);
		}else {
			usuario.setCadastro(0);
		}
		if(alteraPrivilegio.isSelected()==true) {
			usuario.setAltera_privi(1);
		}else {
			usuario.setAltera_privi(0);
		}
		if(situacao.isSelected()==true) {
			usuario.setSituacao(1);
		}else {
			usuario.setSituacao(0);
		}
		if(ativoSite.isSelected()==true) {
			usuario.setAtivo_site(1);
		}else {
			usuario.setAtivo_site(0);
		}
		//Privilegio Geral
		if(priviCadastroAlteraCliente.isSelected()==true) {
			usuario.setpCadCliente(1);
		}else {
			usuario.setpCadCliente(0);
		}
		if(priviCadastroEAlteraoAgenda.isSelected()==true) {
			usuario.setpCadAgenda(1);
		}else {
			usuario.setpCadAgenda(0);
		}
		if(priviAcessoRebimentosPagamentos.isSelected()==true) {
			usuario.setpAcessReceber(1);
		}else {
			usuario.setpAcessReceber(0);
		}
		if(priviSimuOrcamento.isSelected()==true) {
			usuario.setpRealizaOrcamento(1);
		}else {
			usuario.setpRealizaOrcamento(0);
		}
		if(priviCadastroAlteraServico.isSelected()==true) {
			usuario.setpCadServico(1);
		}else {
			usuario.setpCadServico(0);
		}
		if(priviAcessoLivroCaixa.isSelected()==true) {
			usuario.setpLivroCaixa(1);
		}else {
			usuario.setpLivroCaixa(0);
		}
		if(priviChamadaFila.isSelected()==true) {
			usuario.setpChamada(1);
		}else {
			usuario.setpChamada(0);
		}
		if(priviSincronizaoDeDados.isSelected()==true) {
			usuario.setpSincroniza(1);
		}else {
			usuario.setpSincroniza(0);
		}
		if(priviAtualizarSistema.isSelected()==true) {
			usuario.setpAtualizar(1);
		}else {
			usuario.setpAtualizar(0);
		}
		if(priviAcessoAConfiguraes.isSelected()==true) {
			usuario.setpAcessConfig(1);
		}else {
			usuario.setpAcessConfig(0);
		}
		if(priviCadastroEAlteraEmpresa.isSelected()==true) {
			usuario.setpCadEmpresas(1);
		}else {
			usuario.setpCadEmpresas(0);
		}
		//Privilegio Financeiro
		if(priviRealizarRecebimento.isSelected()==true) {
			usuario.setpRealizaRecebimento(1);
		}else {
			usuario.setpRealizaRecebimento(0);
		}
		if(priviRecebimentoAvuso.isSelected()==true) {
			usuario.setpRealizaRecebimentoAvulso(1);
		}else {
			usuario.setpRealizaRecebimentoAvulso(0);
		}
		if(priviExcluirParcelasFinanceiras.isSelected()==true) {
			usuario.setpExcluirFinanceiro(1);
		}else {
			usuario.setpExcluirFinanceiro(0);
		}
		if(priveEstornarRecebimentos.isSelected()==true) {
			usuario.setpEstorna(1);
		}else {
			usuario.setpEstorna(0);
		}
		if(priveAcessoAoGerenciador.isSelected()==true) {
			usuario.setpAcessGenFin(1);
		}else {
			usuario.setpAcessGenFin(0);
		}
		if(priveCadastroEAlteraoBacosContas.isSelected()==true) {
			usuario.setpCadContasBancos(1);
		}else {
			usuario.setpCadContasBancos(0);
		}
		if(priveCadastroEAlteraoDespesas.isSelected()==true) {
			usuario.setpCadDespesas(1);
		}else {
			usuario.setpCadDespesas(0);
		}
		if(priveAcessoAFolha.isSelected()==true) {
			usuario.setpAcessFolha(1);
		}else {
			usuario.setpAcessFolha(0);
		}
		if(priveCadastroEAlteraoFornecedores.isSelected()==true) {
			usuario.setpCadFornecedor(1);
		}else {
			usuario.setpCadFornecedor(0);
		}
		if(priviAcessoRelatroios.isSelected()==true) {
			usuario.setpAcessRelatorios(1);
		}else {
			usuario.setpAcessRelatorios(0);
		}
		if(priveCadastroDeFuncionarios.isSelected()==true) {
			usuario.setpCadFuncionarios(1);
		}else {
			usuario.setpCadFuncionarios(0);
		}
	}
	
	public void prencheCampos() {
		leitura();
		dao.dadosUsuario(usuario);
		tx_nome.setText(usuario.getNomeUsuario());
		tx_login.setText(usuario.getLoginUsuario());
		tx_senha.setText(usuario.getSenhaUsuario());
		tx_funcao.setText(usuario.getFuncao());
		
		if(usuario.getNivelUsuario()==1) {
			nivelUsuario.setSelectedItem("ADMINISTRADOR");
		}else if(usuario.getNivelUsuario()==2) {
			nivelUsuario.setSelectedItem("SUPERVISOR");
		}else{
			nivelUsuario.setSelectedItem("USUARIO");
		}
		
		if(usuario.getPadrao()==1){
			padraoPrivilegios.setSelectedItem("PADR\u00C3O USUARIO");
		}else {
			padraoPrivilegios.setSelectedItem("PERSONALIZADO");
		}
		
		if(usuario.getCadastro()==1) {
			PermitirCadastroUsuarios.setSelected(true);
		}else {
			PermitirCadastroUsuarios.setSelected(false);
		}
		
		if(usuario.getAltera_privi()==1) {
			alteraPrivilegio.setSelected(true);
		}else {
			alteraPrivilegio.setSelected(false);
		}
		if(usuario.getSituacao()==1) {
			situacao.setSelected(true);
		}else {
			situacao.setSelected(false);
		}
		
		if(usuario.getAtivo_site()==1) {
			ativoSite.setSelected(true);
		}else {
			ativoSite.setSelected(false);
		}
		
		if(usuario.getpCadCliente()==1) {
			priviCadastroAlteraCliente.setSelected(true);
		}else {
			priviCadastroAlteraCliente.setSelected(false);
		}
		
		if(usuario.getpCadAgenda()==1) {
			priviCadastroEAlteraoAgenda.setSelected(true);
		}else {
			priviCadastroEAlteraoAgenda.setSelected(false);
		}
		
		if(usuario.getpAcessReceber()==1) {
			priviAcessoRebimentosPagamentos.setSelected(true);
		}else {
			priviAcessoRebimentosPagamentos.setSelected(false);
		}
		
		if(usuario.getpRealizaOrcamento()==1) {
			priviSimuOrcamento.setSelected(true);
		}else {
			priviSimuOrcamento.setSelected(false);
		}
		
		if(usuario.getpCadServico()==1) {
			priviCadastroAlteraServico.setSelected(true);
		}else {
			priviCadastroAlteraServico.setSelected(false);
		}
		
		if(usuario.getpLivroCaixa()==1) {
			priviAcessoLivroCaixa.setSelected(true);
		}else {
			priviAcessoLivroCaixa.setSelected(false);
		}
		
		if(usuario.getpChamada()==1) {
			priviChamadaFila.setSelected(true);
		}else {
			priviChamadaFila.setSelected(false);
		}
		
		if(usuario.getpSincroniza()==1) {
			priviSincronizaoDeDados.setSelected(true);
		}else {
			priviSincronizaoDeDados.setSelected(false);
		}
		
		if(usuario.getpAtualizar()==1) {
			priviAtualizarSistema.setSelected(true);
		}else {
			priviAtualizarSistema.setSelected(false);
		}
		
		if(usuario.getpAcessConfig()==1) {
			priviAcessoAConfiguraes.setSelected(true);
		}else {
			priviAcessoAConfiguraes.setSelected(false);
		}
		
		if(usuario.getpCadEmpresas()==1) {
			priviCadastroEAlteraEmpresa.setSelected(true);
		}else {
			priviCadastroEAlteraEmpresa.setSelected(false);
		}
		
		if(usuario.getpRealizaRecebimento()==1) {
			priviRealizarRecebimento.setSelected(true);
		}else {
			priviRealizarRecebimento.setSelected(false);
		}
		
		if(usuario.getpRealizaRecebimentoAvulso()==1) {
			priviRecebimentoAvuso.setSelected(true);
		}else {
			priviRecebimentoAvuso.setSelected(false);
		}
		
		if(usuario.getpExcluirFinanceiro()==1) {
			priviExcluirParcelasFinanceiras.setSelected(true);
		}else {
			priviExcluirParcelasFinanceiras.setSelected(false);
		}
		
		if(usuario.getpEstorna()==1) {
			priveEstornarRecebimentos.setSelected(true);
		}else {
			priveEstornarRecebimentos.setSelected(false);
		}
		
		if(usuario.getpAcessGenFin()==1) {
			priveAcessoAoGerenciador.setSelected(true);
		}else {
			priveAcessoAoGerenciador.setSelected(false);
		}
		
		if(usuario.getpCadContasBancos()==1) {
			priveCadastroEAlteraoBacosContas.setSelected(true);
		}else {
			priveCadastroEAlteraoBacosContas.setSelected(false);
		}
		
		if(usuario.getpCadDespesas()==1) {
			priveCadastroEAlteraoDespesas.setSelected(true);
		}else {
			priveCadastroEAlteraoDespesas.setSelected(false);
		}
		
		if(usuario.getpAcessFolha()==1) {
			priveAcessoAFolha.setSelected(true);
		}else {
			priveAcessoAFolha.setSelected(false);
		}
		
		if(usuario.getpCadFornecedor()==1) {
			priveCadastroEAlteraoFornecedores.setSelected(true);
		}else {
			priveCadastroEAlteraoFornecedores.setSelected(false);
		}
		
		if(usuario.getpAcessRelatorios()==1) {
			priviAcessoRelatroios.setSelected(true);
		}else {
			priviAcessoRelatroios.setSelected(false);
		}
		
		if(usuario.getpCadFuncionarios()==1) {
			priveCadastroDeFuncionarios.setSelected(true);
		}else {
			priveCadastroDeFuncionarios.setSelected(false);
		}
		
	checaPrivilegio();
	
		
	}
	
	public void limpaCampos() {
		tx_nome.setText("");
		tx_login.setText("");
		tx_senha.setText("");
		tx_funcao.setText("");
		nivelUsuario.setSelectedItem("ADMINISTRADOR");
		padraoPrivilegios.setSelectedItem("PADRÃO USUARIO");
		PermitirCadastroUsuarios.setSelected(false);
		alteraPrivilegio.setSelected(false);
		situacao.setSelected(false);
		ativoSite.setSelected(false);
		
		priviCadastroAlteraCliente.setSelected(false);
		priviCadastroEAlteraoAgenda.setSelected(false);
		priviAcessoRebimentosPagamentos.setSelected(false);
		priviSimuOrcamento.setSelected(false);
		priviCadastroAlteraServico.setSelected(false);
		priviAcessoLivroCaixa.setSelected(false);
		priviChamadaFila.setSelected(false);
		priviSincronizaoDeDados.setSelected(false);
		priviAtualizarSistema.setSelected(false);
		priviAcessoAConfiguraes.setSelected(false);
		priviCadastroEAlteraEmpresa.setSelected(false);
		
		priviRealizarRecebimento.setSelected(false);
		priviRecebimentoAvuso.setSelected(false);
		priviExcluirParcelasFinanceiras.setSelected(false);
		priveEstornarRecebimentos.setSelected(false);
		priveAcessoAoGerenciador.setSelected(false);
		priveCadastroEAlteraoBacosContas.setSelected(false);
		priveCadastroEAlteraoDespesas.setSelected(false);
		priveAcessoAFolha.setSelected(false);
		priveCadastroEAlteraoFornecedores.setSelected(false);
		priviAcessoRelatroios.setSelected(false);
		priveCadastroDeFuncionarios.setSelected(false);
	}
	
	public void salvar() {
		try {
			iniciar.LeituraIp();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dao.conectar(iniciar.getIp_server());
		dao.inserirUsuario(usuario);
		dao.fecharCon();
		limpaCampos();
	}
	
	public void atualiza() {
		try {
			iniciar.LeituraIp();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dao.conectar(iniciar.getIp_server());
		dao.alteraUsuario(usuario);
		dao.fecharCon();
		limpaCampos();
	}
	
	public void nivelPadrao() {
		
		if(nivelUsuario.getSelectedItem()=="") {
			
		}
	}
	
	public void checaPrivilegio() {
		
		
		leitura();
		
		if(usuario.getCadastroUsuario()==1) {
			
			tabbedPaneUsuarios.setVisible(false);
			tabbedPaneCadastroUsuario.setVisible(true);
			
			if(usuario.getAltera_privi()!=1) {
				
				PermitirCadastroUsuarios.setEnabled(false);
				alteraPrivilegio.setEnabled(false);
				priviCadastroAlteraCliente.setEnabled(false);
				priviCadastroEAlteraoAgenda.setEnabled(false);
				priviAcessoRebimentosPagamentos.setEnabled(false);
				priviSimuOrcamento.setEnabled(false);
				priviCadastroAlteraServico.setEnabled(false);
				priviAcessoLivroCaixa.setEnabled(false);
				priviChamadaFila.setEnabled(false);
				priviSincronizaoDeDados.setEnabled(false);
				priviAtualizarSistema.setEnabled(false);
				priviAcessoAConfiguraes.setEnabled(false);
				priviCadastroEAlteraEmpresa.setEnabled(false);
				
				priviRealizarRecebimento.setEnabled(false);
				priviRecebimentoAvuso.setEnabled(false);
				priviExcluirParcelasFinanceiras.setEnabled(false);
				priveEstornarRecebimentos.setEnabled(false);
				priveAcessoAoGerenciador.setEnabled(false);
				priveCadastroEAlteraoBacosContas.setEnabled(false);
				priveCadastroEAlteraoDespesas.setEnabled(false);
				priveAcessoAFolha.setEnabled(false);
				priveCadastroEAlteraoFornecedores.setEnabled(false);
				priviAcessoRelatroios.setEnabled(false);
				priveCadastroDeFuncionarios.setEnabled(false);
				
			}
			
			
		}else {
			
			aviso.texto.setIcon(new ImageIcon(Taviso.class.getResource("/img/atencao.png")));
			aviso.texto.setText("VOCE NÃO TEM PRIVILEGIO PARA ESTA AÇÃO");
			aviso.setLocationRelativeTo(null);
			aviso.show();
		}
	}

	public void desativa(int i) {
		
			usuario.setUsuarioId(i);
			
			leitura();
			
			if(usuario.getCadastroUsuario()==1) {
				
			dao.desativarUsuario(usuario);
			dao.fecharCon();
			
			}else {
				aviso.texto.setIcon(new ImageIcon(Taviso.class.getResource("/img/atencao.png")));
				aviso.texto.setText("VOCE NÃO TEM PRIVILEGIO PARA ESTA AÇÃO");
				aviso.setLocationRelativeTo(null);
				aviso.show();
				
			}
			
		
	}
	
	public void excluir(int i) {
		
		usuario.setUsuarioId(i);
		
		leitura();
		
		if(usuario.getCadastroUsuario()==1) {
			dao.excluiUsuario(usuario);
			dao.fecharCon();
		}else {
			
			aviso.texto.setIcon(new ImageIcon(Taviso.class.getResource("/img/atencao.png")));
			aviso.texto.setText("VOCE NÃO TEM PRIVILEGIO PARA ESTA AÇÃO");
			aviso.setLocationRelativeTo(null);
			aviso.show();
		}
		
		
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	public void leitura() {
		try {
			iniciar.LeituraIp();
			iniciar.leituraUsuarioLogado();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		dao.conectar(iniciar.getIp_server());
		dao.privilegio(usuario);
	}
}
