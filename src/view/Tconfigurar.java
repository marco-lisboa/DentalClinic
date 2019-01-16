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

public class Tconfigurar extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField textField_3;
	private JTextField passwordField;

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
		
		JTabbedPane tabbedPaneCadastroUsuario = new JTabbedPane(JTabbedPane.TOP);
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
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Usuario Ativo ?");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxNewCheckBox.setForeground(Color.WHITE);
		chckbxNewCheckBox.setFocusable(false);
		chckbxNewCheckBox.setOpaque(false);
		chckbxNewCheckBox.setBounds(10, 170, 125, 23);
		panel_2.add(chckbxNewCheckBox);
		
		JCheckBox chckbxAtivoParaAcesso = new JCheckBox("Ativo Para Acesso ao Site ?");
		chckbxAtivoParaAcesso.setOpaque(false);
		chckbxAtivoParaAcesso.setForeground(Color.WHITE);
		chckbxAtivoParaAcesso.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxAtivoParaAcesso.setFocusable(false);
		chckbxAtivoParaAcesso.setBounds(10, 196, 269, 23);
		panel_2.add(chckbxAtivoParaAcesso);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(301, 27, 2, 326);
		panel_2.add(separator_1);
		
		JLabel label_14 = new JLabel("");
		label_14.setIcon(new ImageIcon(Tconfigurar.class.getResource("/img/bk.jpeg")));
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBounds(0, 2, 570, 409);
		panel_2.add(label_14);
		
		JTabbedPane tabbedPaneUsuarios = new JTabbedPane(JTabbedPane.TOP);
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBackground(new Color(32, 178, 170));
		tabbedPane.setBounds(0, 0, 575, 428);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setForeground(Color.WHITE);
		tabbedPane.addTab("Configura\u00E7\u00E3o", new ImageIcon(Tconfigurar.class.getResource("/img/configPequena.png")), panel, null);
		tabbedPane.setBackgroundAt(0, new Color(32, 178, 170));
		tabbedPane.setForegroundAt(0, Color.WHITE);
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

	}
}
