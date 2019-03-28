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

public class T_018_livrocaixa extends JPanel {
	private JComboBox textField_1;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public T_018_livrocaixa() {
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
		tabbedPane.addTab("Livro Caixa", new ImageIcon(T_018_livrocaixa.class.getResource("/img/receiptpequeno.png")), panel, null);
		tabbedPane.setBackgroundAt(0, new Color(32, 178, 170));
		tabbedPane.setForegroundAt(0, Color.WHITE);
		panel.setLayout(null);
		
		JLabel lblData = new JLabel("De : ");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblData.setForeground(Color.WHITE);
		lblData.setBounds(10, 11, 46, 14);
		panel.add(lblData);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooser.setBounds(38, 5, 115, 20);
		panel.add(dateChooser);
		
		JLabel lblAte = new JLabel("Ate : ");
		lblAte.setForeground(Color.WHITE);
		lblAte.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAte.setBounds(10, 39, 46, 14);
		panel.add(lblAte);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooser_1.setBounds(38, 33, 115, 20);
		panel.add(dateChooser_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setToolTipText("Buscar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(T_003_livro_consulta.class.getResource("/img/buscar.png")));
		lblNewLabel.setBounds(391, 2, 38, 32);
		panel.add(lblNewLabel);
		
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
		
		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o : ");
		lblSituao.setForeground(Color.WHITE);
		lblSituao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSituao.setBounds(163, 8, 89, 14);
		panel.add(lblSituao);
		
		textField_1 = new JComboBox();
		textField_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		textField_1.setForeground(Color.BLACK);
		textField_1.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Aberto", "Fechado"}));
		textField_1.setBounds(226, 5, 145, 20);
		panel.add(textField_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 550, 186);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Descri\u00E7\u00E3o", "Data", "Valor Integral", "Valor Desconto", "Procedimento", "Situa\u00E7\u00E3o"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("Registros encontrados");
		label.setIcon(new ImageIcon(T_018_livrocaixa.class.getResource("/img/confimado.png")));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 284, 187, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Valor Integral de : ");
		label_1.setIcon(new ImageIcon(T_018_livrocaixa.class.getResource("/img/integral.png")));
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(10, 309, 187, 14);
		panel.add(label_1);
		
		JLabel lblValorTotalDescontos = new JLabel("Valor Total Descontos : ");
		lblValorTotalDescontos.setIcon(new ImageIcon(T_018_livrocaixa.class.getResource("/img/banking.png")));
		lblValorTotalDescontos.setForeground(Color.WHITE);
		lblValorTotalDescontos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValorTotalDescontos.setBounds(184, 284, 187, 14);
		panel.add(lblValorTotalDescontos);
		
		JLabel lblValorTotalRecebido = new JLabel("Valor Total  Recebido : ");
		lblValorTotalRecebido.setIcon(new ImageIcon(T_018_livrocaixa.class.getResource("/img/recebidos.png")));
		lblValorTotalRecebido.setForeground(Color.WHITE);
		lblValorTotalRecebido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValorTotalRecebido.setBounds(184, 309, 187, 14);
		panel.add(lblValorTotalRecebido);
		
		JLabel lblValorTotalDe = new JLabel("Valor Total de Saidas : ");
		lblValorTotalDe.setIcon(new ImageIcon(T_018_livrocaixa.class.getResource("/img/saida.png")));
		lblValorTotalDe.setForeground(Color.WHITE);
		lblValorTotalDe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValorTotalDe.setBounds(373, 284, 187, 14);
		panel.add(lblValorTotalDe);
		
		JLabel lblValorLivroCaixa = new JLabel("Valor Em Caixa : ");
		lblValorLivroCaixa.setIcon(new ImageIcon(T_018_livrocaixa.class.getResource("/img/caixa.png")));
		lblValorLivroCaixa.setForeground(Color.WHITE);
		lblValorLivroCaixa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValorLivroCaixa.setBounds(373, 309, 187, 14);
		panel.add(lblValorLivroCaixa);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setToolTipText("Imprimir");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(T_018_livrocaixa.class.getResource("/img/imprimir.png")));
		lblNewLabel_2.setBounds(243, 363, 46, 24);
		panel.add(lblNewLabel_2);
		
		JLabel bk = new JLabel("");
		bk.setHorizontalAlignment(SwingConstants.CENTER);
		bk.setIcon(new ImageIcon(T_003_livro_consulta.class.getResource("/img/bk.jpeg")));
		bk.setBounds(0, 2, 570, 409);
		panel.add(bk);

	}
}
