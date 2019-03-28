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
import java.awt.Cursor;

public class T_008_financeiroPaciente extends JPanel {
	private JTextField textField;
	private JComboBox situacao;
	private JTable table;
	private JTable table_1;
	private JTabbedPane tabbedPanePrincipal;
	private JTabbedPane tabbedPaneFinanceiro;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public T_008_financeiroPaciente() {
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
		tabbedPanePrincipal.addTab("Financeiro de Paciente", new ImageIcon(T_008_financeiroPaciente.class.getResource("/img/gambler pequeno.png")), panel, null);
		tabbedPanePrincipal.setBackgroundAt(0, new Color(32, 178, 170));
		tabbedPanePrincipal.setForegroundAt(0, Color.WHITE);
		panel.setLayout(null);
		
		JLabel lblData = new JLabel("Nome : ");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblData.setForeground(Color.WHITE);
		lblData.setBounds(10, 11, 46, 14);
		panel.add(lblData);
		
		JLabel btBuscasPaciente = new JLabel("");
		btBuscasPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPaneFinanceiro.setVisible(true);
				tabbedPanePrincipal.setVisible(false);
			}
		});
		btBuscasPaciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btBuscasPaciente.setToolTipText("Buscar");
		btBuscasPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btBuscasPaciente.setForeground(Color.WHITE);
		btBuscasPaciente.setHorizontalAlignment(SwingConstants.LEFT);
		btBuscasPaciente.setIcon(new ImageIcon(T_003_livro_consulta.class.getResource("/img/buscar.png")));
		btBuscasPaciente.setBounds(207, 2, 40, 32);
		panel.add(btBuscasPaciente);
		
		JLabel btVoltar = new JLabel("");
		btVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btVoltar.setHorizontalAlignment(SwingConstants.CENTER);
		btVoltar.setIcon(new ImageIcon(T_004_ficha_paciente.class.getResource("/img/voltar.png")));
		btVoltar.setBounds(535, 2, 25, 32);
		panel.add(btVoltar);
		
		textField = new JTextField();
		textField.setBounds(52, 8, 145, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o : ");
		lblSituao.setForeground(Color.WHITE);
		lblSituao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSituao.setBounds(10, 39, 89, 14);
		panel.add(lblSituao);
		
		situacao = new JComboBox();
		situacao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		situacao.setForeground(Color.BLACK);
		situacao.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Ativos", "Inativos"}));
		situacao.setBounds(73, 36, 145, 20);
		panel.add(situacao);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 550, 279);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Nome", "Telefone", "Situa\u00E7\u00E3o"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel rg = new JLabel("");
		rg.setIcon(new ImageIcon(T_008_financeiroPaciente.class.getResource("/img/confimado.png")));
		rg.setForeground(Color.WHITE);
		rg.setFont(new Font("Tahoma", Font.BOLD, 11));
		rg.setBounds(15, 368, 545, 14);
		panel.add(rg);
		
		JLabel bk = new JLabel("");
		bk.setHorizontalAlignment(SwingConstants.CENTER);
		bk.setIcon(new ImageIcon(T_003_livro_consulta.class.getResource("/img/bk.jpeg")));
		bk.setBounds(0, 2, 570, 409);
		panel.add(bk);
		
		tabbedPaneFinanceiro = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneFinanceiro.setVisible(false);
		tabbedPaneFinanceiro.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneFinanceiro.setBorder(null);
		tabbedPaneFinanceiro.setBackground(new Color(32, 178, 170));
		tabbedPaneFinanceiro.setBounds(0, 0, 575, 428);
		add(tabbedPaneFinanceiro);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(32, 178, 170));
		tabbedPaneFinanceiro.addTab("Financeiro", new ImageIcon(T_008_financeiroPaciente.class.getResource("/img/gambler pequeno.png")), panel_1, null);
		tabbedPaneFinanceiro.setForegroundAt(0, Color.WHITE);
		
		JLabel buscar = new JLabel("");
		buscar.setIcon(new ImageIcon(T_008_financeiroPaciente.class.getResource("/img/buscar.png")));
		buscar.setToolTipText("Buscar");
		buscar.setHorizontalAlignment(SwingConstants.LEFT);
		buscar.setForeground(Color.WHITE);
		buscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		buscar.setBounds(228, 44, 40, 32);
		panel_1.add(buscar);
		
		JLabel btVoltar2 = new JLabel("");
		btVoltar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabbedPaneFinanceiro.setVisible(false);
				tabbedPanePrincipal.setVisible(true);
			}
		});
		btVoltar2.setIcon(new ImageIcon(T_008_financeiroPaciente.class.getResource("/img/voltar.png")));
		btVoltar2.setHorizontalAlignment(SwingConstants.CENTER);
		btVoltar2.setBounds(535, 2, 25, 32);
		panel_1.add(btVoltar2);
		
		JLabel lblData_1 = new JLabel("Data : ");
		lblData_1.setForeground(Color.WHITE);
		lblData_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblData_1.setBounds(10, 20, 89, 14);
		panel_1.add(lblData_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(73, 14, 145, 20);
		panel_1.add(dateChooser);
		
		JLabel label_3 = new JLabel("Situa\u00E7\u00E3o : ");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(10, 39, 89, 14);
		panel_1.add(label_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Todos", "A Receber", "Recebido"}));
		comboBox.setForeground(Color.BLACK);
		comboBox.setBounds(73, 36, 145, 20);
		panel_1.add(comboBox);
		
		JLabel lblTipo = new JLabel("Tipo : ");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipo.setBounds(10, 62, 89, 14);
		panel_1.add(lblTipo);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setForeground(Color.BLACK);
		comboBox_1.setBounds(73, 59, 145, 20);
		panel_1.add(comboBox_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 87, 550, 259);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(T_008_financeiroPaciente.class.getResource("/img/confimado.png")));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 357, 550, 14);
		panel_1.add(label);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(T_008_financeiroPaciente.class.getResource("/img/bk.jpeg")));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(0, 2, 570, 409);
		panel_1.add(label_5);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBorder(null);
		tabbedPane.setBackground(new Color(32, 178, 170));
		tabbedPane.setBounds(0, 0, 575, 428);
		add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setForeground(Color.WHITE);
		panel_2.setBackground(new Color(32, 178, 170));
		tabbedPane.addTab("New tab", null, panel_2, null);
		
		JLabel label_1 = new JLabel("Nome : ");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(10, 11, 46, 14);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setToolTipText("Buscar");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(207, 2, 40, 32);
		panel_2.add(label_2);
		
		JLabel label_4 = new JLabel("");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(535, 2, 25, 32);
		panel_2.add(label_4);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(52, 8, 145, 20);
		panel_2.add(textField_1);
		
		JLabel label_6 = new JLabel("Situa\u00E7\u00E3o : ");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(10, 39, 89, 14);
		panel_2.add(label_6);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setForeground(Color.BLACK);
		comboBox_2.setBounds(73, 36, 145, 20);
		panel_2.add(comboBox_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 78, 550, 279);
		panel_2.add(scrollPane_2);
		
		JLabel label_7 = new JLabel("");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_7.setBounds(15, 368, 545, 14);
		panel_2.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(0, 2, 570, 409);
		panel_2.add(label_8);

	}
}
