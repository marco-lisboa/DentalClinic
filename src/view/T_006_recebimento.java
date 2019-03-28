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
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

public class T_006_recebimento extends JPanel {
	private JTextField textField;
	private JComboBox textField_1;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table_1;
	private JTabbedPane tabbedPanePacientes;
	private JTabbedPane tabbedPane;
	private JTextField textField_7;

	/**
	 * Create the panel.
	 */
	public T_006_recebimento() {
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
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBackground(new Color(32, 178, 170));
		tabbedPane.setBounds(0, 0, 575, 428);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setForeground(Color.WHITE);
		tabbedPane.addTab("Recebimento", new ImageIcon(T_006_recebimento.class.getResource("/img/gambler pequeno.png")), panel, null);
		tabbedPane.setBackgroundAt(0, new Color(32, 178, 170));
		tabbedPane.setForegroundAt(0, Color.WHITE);
		panel.setLayout(null);
		
		JLabel lblData = new JLabel("Nome : ");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblData.setForeground(Color.WHITE);
		lblData.setBounds(10, 11, 46, 14);
		panel.add(lblData);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabbedPane.setVisible(false);
				tabbedPanePacientes.setVisible(true);
			}
		});
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setToolTipText("Buscar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setIcon(new ImageIcon(T_003_livro_consulta.class.getResource("/img/buscar.png")));
		lblNewLabel.setBounds(251, 2, 40, 32);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
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
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(52, 8, 189, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblSituao = new JLabel("Parcela : ");
		lblSituao.setForeground(Color.WHITE);
		lblSituao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSituao.setBounds(10, 51, 60, 14);
		panel.add(lblSituao);
		
		textField_1 = new JComboBox();
		textField_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		textField_1.setForeground(Color.BLACK);
		textField_1.setBounds(73, 48, 145, 20);
		panel.add(textField_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 281, 78);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Codigo", "Parcela", "Situa\u00E7\u00E3o"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel adcionar = new JLabel("");
		adcionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		adcionar.setToolTipText("Adicionar Novo Paciente");
		adcionar.setHorizontalAlignment(SwingConstants.CENTER);
		adcionar.setIcon(new ImageIcon(T_004_ficha_paciente.class.getResource("/img/add.png")));
		adcionar.setBounds(217, 36, 46, 43);
		panel.add(adcionar);
		
		JLabel lblValor = new JLabel("Valor : ");
		lblValor.setForeground(Color.WHITE);
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValor.setBounds(10, 160, 73, 14);
		panel.add(lblValor);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 174, 73, 20);
		panel.add(textField_2);
		
		JLabel lblValorDesconto = new JLabel("Valor Desconto: ");
		lblValorDesconto.setForeground(Color.WHITE);
		lblValorDesconto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValorDesconto.setBounds(93, 160, 104, 14);
		panel.add(lblValorDesconto);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(93, 174, 73, 20);
		panel.add(textField_3);
		
		JLabel lblJuros = new JLabel("Juros : ");
		lblJuros.setForeground(Color.WHITE);
		lblJuros.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJuros.setBounds(10, 205, 73, 14);
		panel.add(lblJuros);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 219, 73, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(93, 219, 73, 20);
		panel.add(textField_5);
		
		JLabel lblMulta = new JLabel("Multa : ");
		lblMulta.setForeground(Color.WHITE);
		lblMulta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMulta.setBounds(93, 205, 73, 14);
		panel.add(lblMulta);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Cobrar Juros e Multa?");
		chckbxNewCheckBox.setFocusTraversalKeysEnabled(false);
		chckbxNewCheckBox.setForeground(Color.WHITE);
		chckbxNewCheckBox.setOpaque(false);
		chckbxNewCheckBox.setBounds(10, 246, 271, 23);
		panel.add(chckbxNewCheckBox);
		
		JLabel lblDataRecebimento = new JLabel("Data Recebimento : ");
		lblDataRecebimento.setForeground(Color.WHITE);
		lblDataRecebimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataRecebimento.setBounds(10, 323, 119, 14);
		panel.add(lblDataRecebimento);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(125, 317, 166, 20);
		panel.add(dateChooser);
		
		JLabel lblTipoDeRecebimento = new JLabel("Tipo de Recebimento :");
		lblTipoDeRecebimento.setForeground(Color.WHITE);
		lblTipoDeRecebimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoDeRecebimento.setBounds(10, 343, 137, 14);
		panel.add(lblTipoDeRecebimento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.BLACK);
		comboBox.setBounds(146, 340, 145, 20);
		panel.add(comboBox);
		
		JCheckBox checkLivroCaixa = new JCheckBox("Realizar Lan\u00E7amento em Livro Caixa ?");
		checkLivroCaixa.setOpaque(false);
		checkLivroCaixa.setForeground(Color.WHITE);
		checkLivroCaixa.setFocusTraversalKeysEnabled(false);
		checkLivroCaixa.setBounds(20, 364, 271, 23);
		panel.add(checkLivroCaixa);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(295, 36, 265, 351);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblInformativoDeRecebimento = new JLabel("Informativo de Recebimento");
		lblInformativoDeRecebimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformativoDeRecebimento.setForeground(Color.WHITE);
		lblInformativoDeRecebimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInformativoDeRecebimento.setBounds(10, 11, 236, 14);
		panel_1.add(lblInformativoDeRecebimento);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 23, 236, 2);
		panel_1.add(separator);
		
		JLabel lblParcelas = new JLabel("Parcelas : ");
		lblParcelas.setForeground(Color.WHITE);
		lblParcelas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblParcelas.setBounds(10, 36, 64, 14);
		panel_1.add(lblParcelas);
		
		JLabel lbParcelas = new JLabel("");
		lbParcelas.setForeground(Color.WHITE);
		lbParcelas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbParcelas.setBounds(78, 36, 168, 14);
		panel_1.add(lbParcelas);
		
		JLabel lbValorTotal = new JLabel("");
		lbValorTotal.setForeground(Color.WHITE);
		lbValorTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbValorTotal.setBounds(88, 61, 158, 14);
		panel_1.add(lbValorTotal);
		
		JLabel lblValorTotal = new JLabel("Valor Total : ");
		lblValorTotal.setForeground(Color.WHITE);
		lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValorTotal.setBounds(10, 61, 78, 14);
		panel_1.add(lblValorTotal);
		
		JLabel lblValorTotalDesconto = new JLabel("Valor Total Desconto : ");
		lblValorTotalDesconto.setForeground(Color.WHITE);
		lblValorTotalDesconto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValorTotalDesconto.setBounds(10, 86, 126, 14);
		panel_1.add(lblValorTotalDesconto);
		
		JLabel lbDesconto = new JLabel("");
		lbDesconto.setForeground(Color.WHITE);
		lbDesconto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbDesconto.setBounds(140, 86, 106, 14);
		panel_1.add(lbDesconto);
		
		JLabel lblDataRecebimento_1 = new JLabel("Data Recebimento : ");
		lblDataRecebimento_1.setForeground(Color.WHITE);
		lblDataRecebimento_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataRecebimento_1.setBounds(10, 110, 114, 14);
		panel_1.add(lblDataRecebimento_1);
		
		JLabel lbData = new JLabel("");
		lbData.setForeground(Color.WHITE);
		lbData.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbData.setBounds(125, 110, 121, 14);
		panel_1.add(lbData);
		
		JLabel lblJuros_1 = new JLabel("Juros :");
		lblJuros_1.setForeground(Color.WHITE);
		lblJuros_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJuros_1.setBounds(10, 135, 43, 14);
		panel_1.add(lblJuros_1);
		
		JLabel lbJuros = new JLabel("");
		lbJuros.setForeground(Color.WHITE);
		lbJuros.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbJuros.setBounds(52, 135, 194, 14);
		panel_1.add(lbJuros);
		
		JLabel lblMulta_1 = new JLabel("Multa :");
		lblMulta_1.setForeground(Color.WHITE);
		lblMulta_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMulta_1.setBounds(10, 160, 43, 14);
		panel_1.add(lblMulta_1);
		
		JLabel lbMulta = new JLabel("");
		lbMulta.setForeground(Color.WHITE);
		lbMulta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbMulta.setBounds(52, 160, 194, 14);
		panel_1.add(lbMulta);
		
		JLabel lblTipoDeRecebimento_1 = new JLabel("Tipo de Recebimento :");
		lblTipoDeRecebimento_1.setForeground(Color.WHITE);
		lblTipoDeRecebimento_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTipoDeRecebimento_1.setBounds(10, 185, 133, 14);
		panel_1.add(lblTipoDeRecebimento_1);
		
		JLabel lbRecebimento = new JLabel("");
		lbRecebimento.setForeground(Color.WHITE);
		lbRecebimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbRecebimento.setBounds(150, 185, 96, 14);
		panel_1.add(lbRecebimento);
		
		JLabel confirma = new JLabel("Confirma o Recebimento");
		confirma.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		confirma.setFont(new Font("Tahoma", Font.BOLD, 11));
		confirma.setForeground(Color.WHITE);
		confirma.setBounds(26, 297, 207, 43);
		panel_1.add(confirma);
		confirma.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		confirma.setToolTipText("Confirma Recebimento");
		confirma.setIcon(new ImageIcon(T_006_recebimento.class.getResource("/img/bank.png")));
		confirma.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblValorRecebido = new JLabel("Valor Recebido : ");
		lblValorRecebido.setForeground(Color.WHITE);
		lblValorRecebido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValorRecebido.setBounds(10, 278, 166, 14);
		panel.add(lblValorRecebido);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(10, 292, 98, 20);
		panel.add(textField_7);
		
		JLabel bk = new JLabel("");
		bk.setHorizontalAlignment(SwingConstants.CENTER);
		bk.setIcon(new ImageIcon(T_003_livro_consulta.class.getResource("/img/bk.jpeg")));
		bk.setBounds(0, 2, 570, 409);
		panel.add(bk);
		
		tabbedPanePacientes = new JTabbedPane(JTabbedPane.TOP);
		tabbedPanePacientes.setVisible(false);
		tabbedPanePacientes.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPanePacientes.setFocusable(false);
		tabbedPanePacientes.setBorder(null);
		tabbedPanePacientes.setBackground(new Color(32, 178, 170));
		tabbedPanePacientes.setBounds(0, 0, 575, 428);
		add(tabbedPanePacientes);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setForeground(Color.WHITE);
		panel_2.setBackground(new Color(32, 178, 170));
		tabbedPanePacientes.addTab("Pacientes", new ImageIcon(T_006_recebimento.class.getResource("/img/ficha paciente pequeno.png")), panel_2, null);
		
		JLabel label = new JLabel("Nome : ");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setFocusable(false);
		label.setBounds(10, 11, 46, 14);
		panel_2.add(label);
		
		JLabel buscarPacientes = new JLabel("");
		buscarPacientes.setIcon(new ImageIcon(T_006_recebimento.class.getResource("/img/buscar.png")));
		buscarPacientes.setToolTipText("Buscar");
		buscarPacientes.setHorizontalAlignment(SwingConstants.LEFT);
		buscarPacientes.setForeground(Color.WHITE);
		buscarPacientes.setFont(new Font("Tahoma", Font.BOLD, 11));
		buscarPacientes.setFocusable(false);
		buscarPacientes.setBounds(207, 2, 46, 32);
		panel_2.add(buscarPacientes);
		
		JLabel voltar2 = new JLabel("");
		voltar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPanePacientes.setVisible(false);
				tabbedPane.setVisible(true);
				
			}
		});
		voltar2.setIcon(new ImageIcon(T_006_recebimento.class.getResource("/img/voltar.png")));
		voltar2.setHorizontalAlignment(SwingConstants.CENTER);
		voltar2.setBounds(535, 2, 25, 32);
		panel_2.add(voltar2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(52, 8, 145, 20);
		panel_2.add(textField_6);
		
		JLabel label_3 = new JLabel("Situa\u00E7\u00E3o : ");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setFocusable(false);
		label_3.setBounds(10, 39, 89, 14);
		panel_2.add(label_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Ativo", "Inativo", "Todos"}));
		comboBox_1.setFocusable(false);
		comboBox_1.setBounds(73, 36, 145, 20);
		panel_2.add(comboBox_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 100, 550, 244);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setColumnHeaderView(table_1);
		
		JLabel registros = new JLabel();
		registros.setIcon(new ImageIcon(T_006_recebimento.class.getResource("/img/confimado.png")));
		registros.setForeground(Color.WHITE);
		registros.setFont(new Font("Tahoma", Font.BOLD, 11));
		registros.setFocusable(false);
		registros.setBounds(10, 368, 208, 14);
		panel_2.add(registros);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(T_006_recebimento.class.getResource("/img/bk.jpeg")));
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(0, 2, 570, 409);
		panel_2.add(label_8);

	}
}
