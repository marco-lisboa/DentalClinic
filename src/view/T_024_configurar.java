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
import javax.swing.JFormattedTextField;

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
	private JTabbedPane tabbedPaneCadastroEmpresa;
	private JTextField textField_1;
	private JTextField textField_2;
	private JFormattedTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	
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
		
		JButton btnConfiguraoNfs = new JButton("Configura\u00E7\u00E3o NFS");
		btnConfiguraoNfs.setHorizontalAlignment(SwingConstants.CENTER);
		btnConfiguraoNfs.setForeground(Color.WHITE);
		btnConfiguraoNfs.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfiguraoNfs.setFocusable(false);
		btnConfiguraoNfs.setBackground(new Color(32, 178, 170));
		btnConfiguraoNfs.setBounds(14, 75, 257, 14);
		panel.add(btnConfiguraoNfs);
		
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
		
		JLabel btAdcEmpresa = new JLabel("");
		btAdcEmpresa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabbedPaneEmpresa.setVisible(false);
				tabbedPaneCadastroEmpresa.setVisible(true);
			}
		});
		btAdcEmpresa.setIcon(new ImageIcon(T_024_configurar.class.getResource("/img/add.png")));
		btAdcEmpresa.setToolTipText("Adicionar Nova Empresa");
		btAdcEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		btAdcEmpresa.setBounds(221, 355, 46, 43);
		panel_3.add(btAdcEmpresa);
		
		JLabel btEditarEmpresa = new JLabel("");
		btEditarEmpresa.setIcon(new ImageIcon(T_024_configurar.class.getResource("/img/editar (2).png")));
		btEditarEmpresa.setToolTipText("Editar");
		btEditarEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		btEditarEmpresa.setBounds(281, 355, 46, 43);
		panel_3.add(btEditarEmpresa);
		
		JLabel btDeletaEmpresa = new JLabel("");
		btDeletaEmpresa.setIcon(new ImageIcon(T_024_configurar.class.getResource("/img/deleta.png")));
		btDeletaEmpresa.setToolTipText("Remover Usuario");
		btDeletaEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		btDeletaEmpresa.setBounds(337, 355, 46, 43);
		panel_3.add(btDeletaEmpresa);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(T_024_configurar.class.getResource("/img/bk.jpeg")));
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(0, 2, 570, 409);
		panel_3.add(label_12);
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
		
		tabbedPaneCadastroEmpresa = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneCadastroEmpresa.setVisible(false);
		tabbedPaneCadastroEmpresa.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneCadastroEmpresa.setBorder(null);
		tabbedPaneCadastroEmpresa.setBackground(new Color(32, 178, 170));
		tabbedPaneCadastroEmpresa.setBounds(0, 0, 575, 428);
		add(tabbedPaneCadastroEmpresa);
		
		JPanel panel_4 = new JPanel();
		tabbedPaneCadastroEmpresa.addTab("Empresa", new ImageIcon(T_024_configurar.class.getResource("/img/configPequena.png")), panel_4, null);
		tabbedPaneCadastroEmpresa.setForegroundAt(0, Color.WHITE);
		panel_4.setLayout(null);
		
		JLabel btvoltarempresa = new JLabel("");
		btvoltarempresa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				tabbedPaneCadastroEmpresa.setVisible(false);
				tabbedPaneEmpresa.setVisible(true);
			}
		});
		btvoltarempresa.setIcon(new ImageIcon(T_024_configurar.class.getResource("/img/voltar.png")));
		btvoltarempresa.setToolTipText("Voltar");
		btvoltarempresa.setHorizontalAlignment(SwingConstants.CENTER);
		btvoltarempresa.setBounds(535, 0, 25, 32);
		panel_4.add(btvoltarempresa);
		
		JLabel lblRazoSocial = new JLabel("Raz\u00E3o Social : ");
		lblRazoSocial.setForeground(Color.WHITE);
		lblRazoSocial.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRazoSocial.setBounds(10, 28, 96, 14);
		panel_4.add(lblRazoSocial);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(93, 25, 432, 20);
		panel_4.add(textField_1);
		
		JLabel lblNomeFantasia = new JLabel("Nome Fantasia: ");
		lblNomeFantasia.setForeground(Color.WHITE);
		lblNomeFantasia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomeFantasia.setBounds(10, 53, 96, 14);
		panel_4.add(lblNomeFantasia);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(103, 50, 422, 20);
		panel_4.add(textField_2);
		
		JLabel lblCnpj = new JLabel("CNPJ : ");
		lblCnpj.setForeground(Color.WHITE);
		lblCnpj.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCnpj.setBounds(10, 82, 96, 14);
		panel_4.add(lblCnpj);
		
		textField_3 = new JFormattedTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(47, 79, 211, 20);
		panel_4.add(textField_3);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(20, 127, 540, 2);
		panel_4.add(separator_5);
		
		JLabel label_13 = new JLabel("Nascionalidade :");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_13.setFocusable(false);
		label_13.setBounds(10, 144, 123, 14);
		panel_4.add(label_13);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Antiguano", "Argentino", "Bahamense", "Barbadiano, barbadense", "Belizenho", "Boliviano", "Brasileiro", "Chileno", "Colombiano", "Costarriquenho", "Cubano", "Dominicano", "Equatoriano", "Salvadorenho", "Granadino", "Guatemalteco", "Guian\u00EAs", "Guianense", "Haitiano", "Hondurenho", "Jamaicano", "Mexicano", "Nicaraguense", "Rep\u00FAblica Dominicana - Dominicana", "S\u00E3o-cristovense", "S\u00E3o-vicentino", "Santa-lucense", "Surinam\u00EAs", "Trindadense", "Uruguaio", "Venezuelano", "Alem\u00E3o", "Austr\u00EDaco", "Belga", "Croata", "Dinamarqu\u00EAs", "Eslovaco", "Esloveno", "Espanhol", "Franc\u00EAs", "Grego", "H\u00FAngaro", "Irland\u00EAs", "Italiano", "Noruego", "Holand\u00EAs", "Polon\u00EAs", "Portugu\u00EAs", "Brit\u00E2nico", "Ingl\u00EAs", "Gal\u00EAs", "Escoc\u00EAs", "Romeno", "Russo", "S\u00E9rvio", "Sueco", "Su\u00ED\u00E7o", "Turco", "Ucraniano", "Americano", "Canadense", "Angolano", "Mo\u00E7ambicano", "Sul-africano", "Zimbabuense", "Arg\u00E9lia", "Comorense", "Eg\u00EDpcio", "L\u00EDbio", "Marroquino", "Gan\u00E9s", "Queniano", "Ruand\u00EAs", "Ugandense", "Bechuano", "Marfinense", "Camaronense", "Nigeriano", "Somali", "Australiano", "Neozeland\u00EAs", "Afeg\u00E3o", "Saudita", "Armeno", "Bangladesh", "Chin\u00EAs", "Norte-coreano, coreano", "Sul-coreano, coreano", "Indiano", "Indon\u00E9sio", "Iraquiano", "Iraniano", "Israelita", "Japon\u00EAs", "Malaio", "Nepal\u00EAs", "Omanense", "Paquistan\u00EAs", "Palestino", "Qatarense", "S\u00EDrio", "Cingal\u00EAs", "Tailand\u00EAs", "Timorense, maubere", "\u00C1rabe, emiratense", "Vietnamita", "I\u00EAmen - Iemenita"}));
		comboBox_1.setFocusable(false);
		comboBox_1.setBounds(102, 140, 152, 22);
		panel_4.add(comboBox_1);
		
		JLabel label_15 = new JLabel("Estado :");
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_15.setFocusable(false);
		label_15.setBounds(264, 144, 54, 14);
		panel_4.add(label_15);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFocusable(false);
		comboBox_2.setBounds(312, 140, 54, 22);
		panel_4.add(comboBox_2);
		
		JLabel label_16 = new JLabel("Cidade :");
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_16.setFocusable(false);
		label_16.setBounds(376, 144, 54, 14);
		panel_4.add(label_16);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFocusable(false);
		comboBox_3.setBounds(424, 140, 136, 22);
		panel_4.add(comboBox_3);
		
		JLabel lblRua = new JLabel("Rua : ");
		lblRua.setForeground(Color.WHITE);
		lblRua.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRua.setFocusable(false);
		lblRua.setBounds(10, 172, 38, 14);
		panel_4.add(lblRua);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(52, 169, 508, 20);
		panel_4.add(textField_4);
		
		JLabel lblCep = new JLabel("N\u00BA : ");
		lblCep.setForeground(Color.WHITE);
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCep.setBounds(10, 200, 38, 14);
		panel_4.add(lblCep);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setColumns(10);
		formattedTextField.setBounds(47, 197, 176, 20);
		panel_4.add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setColumns(10);
		formattedTextField_1.setBounds(315, 200, 176, 20);
		panel_4.add(formattedTextField_1);
		
		JLabel label_17 = new JLabel("CEP : ");
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_17.setBounds(278, 203, 96, 14);
		panel_4.add(label_17);
		
		JLabel label_18 = new JLabel("Email : ");
		label_18.setForeground(Color.WHITE);
		label_18.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_18.setFocusable(false);
		label_18.setBounds(10, 256, 48, 14);
		panel_4.add(label_18);
		
		JLabel label_19 = new JLabel("Email : ");
		label_19.setForeground(Color.WHITE);
		label_19.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_19.setFocusable(false);
		label_19.setBounds(10, 228, 123, 14);
		panel_4.add(label_19);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(52, 225, 458, 20);
		panel_4.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(52, 253, 458, 20);
		panel_4.add(textField_6);
		
		JLabel label_20 = new JLabel("Contato : ");
		label_20.setForeground(Color.WHITE);
		label_20.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_20.setFocusable(false);
		label_20.setBounds(10, 281, 61, 14);
		panel_4.add(label_20);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setColumns(10);
		formattedTextField_2.setBounds(65, 278, 127, 20);
		panel_4.add(formattedTextField_2);
		
		JLabel label_21 = new JLabel("Op :");
		label_21.setForeground(Color.WHITE);
		label_21.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_21.setFocusable(false);
		label_21.setBounds(203, 280, 32, 14);
		panel_4.add(label_21);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFocusable(false);
		comboBox_4.setBounds(235, 277, 152, 22);
		panel_4.add(comboBox_4);
		
		JCheckBox checkBox = new JCheckBox("WhatsApp");
		checkBox.setOpaque(false);
		checkBox.setForeground(Color.WHITE);
		checkBox.setFocusable(false);
		checkBox.setBounds(401, 278, 97, 23);
		panel_4.add(checkBox);
		
		JLabel label_22 = new JLabel("Contato : ");
		label_22.setForeground(Color.WHITE);
		label_22.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_22.setFocusable(false);
		label_22.setBounds(10, 309, 61, 14);
		panel_4.add(label_22);
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setColumns(10);
		formattedTextField_3.setBounds(64, 305, 127, 20);
		panel_4.add(formattedTextField_3);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setFocusable(false);
		comboBox_5.setBounds(234, 304, 152, 22);
		panel_4.add(comboBox_5);
		
		JLabel label_23 = new JLabel("Op :");
		label_23.setForeground(Color.WHITE);
		label_23.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_23.setFocusable(false);
		label_23.setBounds(201, 308, 32, 14);
		panel_4.add(label_23);
		
		JCheckBox checkBox_1 = new JCheckBox("WhatsApp");
		checkBox_1.setOpaque(false);
		checkBox_1.setForeground(Color.WHITE);
		checkBox_1.setFocusable(false);
		checkBox_1.setBounds(400, 304, 97, 23);
		panel_4.add(checkBox_1);
		
		JLabel bkempresas = new JLabel("");
		bkempresas.setIcon(new ImageIcon(T_024_configurar.class.getResource("/img/bk.jpeg")));
		bkempresas.setHorizontalAlignment(SwingConstants.CENTER);
		bkempresas.setBounds(0, 0, 570, 409);
		panel_4.add(bkempresas);
		
		JPanel panel_5 = new JPanel();
		tabbedPaneCadastroEmpresa.addTab("Propriet\u00E1rio", new ImageIcon(T_024_configurar.class.getResource("/img/configPequena.png")), panel_5, null);
		tabbedPaneCadastroEmpresa.setForegroundAt(1, Color.WHITE);
		panel_5.setLayout(null);
		
		JLabel bt = new JLabel("");
		bt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPaneCadastroEmpresa.setVisible(false);
				tabbedPaneEmpresa.setVisible(true);
			}
		});
		bt.setIcon(new ImageIcon(T_024_configurar.class.getResource("/img/voltar.png")));
		bt.setToolTipText("Voltar");
		bt.setHorizontalAlignment(SwingConstants.CENTER);
		bt.setBounds(535, 0, 25, 32);
		panel_5.add(bt);
		
		JLabel lblNome = new JLabel("Nome : ");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(10, 32, 96, 14);
		panel_5.add(lblNome);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(57, 29, 432, 20);
		panel_5.add(textField_7);
		
		JLabel lblCpf = new JLabel("CPF :");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setBounds(10, 57, 39, 14);
		panel_5.add(lblCpf);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(47, 54, 205, 20);
		panel_5.add(textField_8);
		
		JLabel lblCro = new JLabel("CRO : ");
		lblCro.setForeground(Color.WHITE);
		lblCro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCro.setBounds(262, 57, 96, 14);
		panel_5.add(lblCro);
		
		JFormattedTextField formattedTextField_4 = new JFormattedTextField();
		formattedTextField_4.setColumns(10);
		formattedTextField_4.setBounds(299, 54, 211, 20);
		panel_5.add(formattedTextField_4);
		
		JLabel label_9 = new JLabel("Email : ");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_9.setFocusable(false);
		label_9.setBounds(10, 85, 123, 14);
		panel_5.add(label_9);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(52, 82, 458, 20);
		panel_5.add(textField_9);
		
		JLabel label_10 = new JLabel("Contato : ");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_10.setFocusable(false);
		label_10.setBounds(10, 110, 61, 14);
		panel_5.add(label_10);
		
		JFormattedTextField formattedTextField_5 = new JFormattedTextField();
		formattedTextField_5.setColumns(10);
		formattedTextField_5.setBounds(65, 107, 127, 20);
		panel_5.add(formattedTextField_5);
		
		JLabel label_11 = new JLabel("Op :");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_11.setFocusable(false);
		label_11.setBounds(203, 109, 32, 14);
		panel_5.add(label_11);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setFocusable(false);
		comboBox_6.setBounds(235, 106, 152, 22);
		panel_5.add(comboBox_6);
		
		JCheckBox checkBox_2 = new JCheckBox("WhatsApp");
		checkBox_2.setOpaque(false);
		checkBox_2.setForeground(Color.WHITE);
		checkBox_2.setFocusable(false);
		checkBox_2.setBounds(401, 107, 97, 23);
		panel_5.add(checkBox_2);
		
		JLabel label_25 = new JLabel("Contato : ");
		label_25.setForeground(Color.WHITE);
		label_25.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_25.setFocusable(false);
		label_25.setBounds(10, 138, 61, 14);
		panel_5.add(label_25);
		
		JFormattedTextField formattedTextField_6 = new JFormattedTextField();
		formattedTextField_6.setColumns(10);
		formattedTextField_6.setBounds(64, 134, 127, 20);
		panel_5.add(formattedTextField_6);
		
		JLabel label_26 = new JLabel("Op :");
		label_26.setForeground(Color.WHITE);
		label_26.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_26.setFocusable(false);
		label_26.setBounds(201, 137, 32, 14);
		panel_5.add(label_26);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setFocusable(false);
		comboBox_7.setBounds(234, 133, 152, 22);
		panel_5.add(comboBox_7);
		
		JCheckBox checkBox_3 = new JCheckBox("WhatsApp");
		checkBox_3.setOpaque(false);
		checkBox_3.setForeground(Color.WHITE);
		checkBox_3.setFocusable(false);
		checkBox_3.setBounds(400, 133, 97, 23);
		panel_5.add(checkBox_3);
		
		JLabel bkempresas2 = new JLabel("");
		bkempresas2.setIcon(new ImageIcon(T_024_configurar.class.getResource("/img/bk.jpeg")));
		bkempresas2.setHorizontalAlignment(SwingConstants.CENTER);
		bkempresas2.setBounds(0, 0, 570, 409);
		panel_5.add(bkempresas2);

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
