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

public class Trebimento extends JPanel {
	private JTextField textField;
	private JComboBox textField_1;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public Trebimento() {
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBackground(new Color(32, 178, 170));
		tabbedPane.setBounds(0, 0, 575, 428);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setForeground(Color.WHITE);
		tabbedPane.addTab("Ficha de Paciente", new ImageIcon(Tficha_paciente.class.getResource("/img/ficha paciente pequeno.png")), panel, null);
		tabbedPane.setBackgroundAt(0, new Color(32, 178, 170));
		tabbedPane.setForegroundAt(0, Color.WHITE);
		panel.setLayout(null);
		
		JLabel lblData = new JLabel("Nome : ");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblData.setForeground(Color.WHITE);
		lblData.setBounds(10, 11, 46, 14);
		panel.add(lblData);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setToolTipText("Buscar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setIcon(new ImageIcon(Tlivro_consulta.class.getResource("/img/buscar.png")));
		lblNewLabel.setBounds(207, 2, 40, 32);
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
		lblNewLabel_1.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/voltar.png")));
		lblNewLabel_1.setBounds(535, 2, 25, 32);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(52, 8, 145, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblSituao = new JLabel("Parcela : ");
		lblSituao.setForeground(Color.WHITE);
		lblSituao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSituao.setBounds(10, 51, 89, 14);
		panel.add(lblSituao);
		
		textField_1 = new JComboBox();
		textField_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		textField_1.setForeground(Color.BLACK);
		textField_1.setBounds(73, 48, 145, 20);
		panel.add(textField_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 281, 145);
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
		adcionar.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/add.png")));
		adcionar.setBounds(217, 36, 46, 43);
		panel.add(adcionar);
		
		JLabel deletar = new JLabel("");
		deletar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		deletar.setToolTipText("Confirma Recebimento");
		deletar.setIcon(new ImageIcon(Trebimento.class.getResource("/img/save.png")));
		deletar.setHorizontalAlignment(SwingConstants.CENTER);
		deletar.setBounds(120, 352, 46, 43);
		panel.add(deletar);
		
		JLabel lblValor = new JLabel("Valor : ");
		lblValor.setForeground(Color.WHITE);
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValor.setBounds(10, 237, 73, 14);
		panel.add(lblValor);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 251, 73, 20);
		panel.add(textField_2);
		
		JLabel lblValorDesconto = new JLabel("Valor Desconto: ");
		lblValorDesconto.setForeground(Color.WHITE);
		lblValorDesconto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValorDesconto.setBounds(93, 237, 104, 14);
		panel.add(lblValorDesconto);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(93, 251, 73, 20);
		panel.add(textField_3);
		
		JLabel lblJuros = new JLabel("Juros : ");
		lblJuros.setForeground(Color.WHITE);
		lblJuros.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJuros.setBounds(10, 282, 73, 14);
		panel.add(lblJuros);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 296, 73, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(93, 296, 73, 20);
		panel.add(textField_5);
		
		JLabel lblMulta = new JLabel("Multa : ");
		lblMulta.setForeground(Color.WHITE);
		lblMulta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMulta.setBounds(93, 282, 73, 14);
		panel.add(lblMulta);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Cobrar Juros e Multa?");
		chckbxNewCheckBox.setFocusTraversalKeysEnabled(false);
		chckbxNewCheckBox.setForeground(Color.WHITE);
		chckbxNewCheckBox.setOpaque(false);
		chckbxNewCheckBox.setBounds(172, 295, 155, 23);
		panel.add(chckbxNewCheckBox);
		
		JLabel lblDataRecebimento = new JLabel("Data Recebimento : ");
		lblDataRecebimento.setForeground(Color.WHITE);
		lblDataRecebimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataRecebimento.setBounds(10, 327, 172, 14);
		panel.add(lblDataRecebimento);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(125, 321, 166, 20);
		panel.add(dateChooser);
		
		JLabel bk = new JLabel("");
		bk.setHorizontalAlignment(SwingConstants.CENTER);
		bk.setIcon(new ImageIcon(Tlivro_consulta.class.getResource("/img/bk.jpeg")));
		bk.setBounds(0, 2, 570, 409);
		panel.add(bk);

	}
}
