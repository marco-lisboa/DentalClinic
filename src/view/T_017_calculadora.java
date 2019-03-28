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

public class T_017_calculadora extends JPanel {
	private JTextField textField_1;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public T_017_calculadora() {
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
		tabbedPane.addTab("Simulador Or\u00E7amentario", new ImageIcon(T_017_calculadora.class.getResource("/img/calculatorpequeno.png")), panel, null);
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
		lblNewLabel_1.setIcon(new ImageIcon(T_004_ficha_paciente.class.getResource("/img/voltar.png")));
		lblNewLabel_1.setBounds(535, 2, 25, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblSituao = new JLabel("Paciente : ");
		lblSituao.setForeground(Color.WHITE);
		lblSituao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSituao.setBounds(10, 13, 139, 14);
		panel.add(lblSituao);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setForeground(Color.BLACK);
		textField_1.setBounds(77, 10, 168, 20);
		panel.add(textField_1);
		
		JLabel label = new JLabel("");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setToolTipText("Buscar Paciente");
		label.setIcon(new ImageIcon(T_017_calculadora.class.getResource("/img/buscar.png")));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(255, 2, 46, 32);
		panel.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 550, 195);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Nome", "Valor", "Desconto", "Valor Total"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblTotal = new JLabel("Registros encontrados");
		lblTotal.setIcon(new ImageIcon(T_017_calculadora.class.getResource("/img/confimado.png")));
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotal.setBounds(10, 276, 187, 14);
		panel.add(lblTotal);
		
		JLabel lblValorIntegralDe = new JLabel("Valor Integral de : ");
		lblValorIntegralDe.setIcon(new ImageIcon(T_017_calculadora.class.getResource("/img/integral.png")));
		lblValorIntegralDe.setForeground(Color.WHITE);
		lblValorIntegralDe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValorIntegralDe.setBounds(10, 301, 187, 14);
		panel.add(lblValorIntegralDe);
		
		JLabel lblValorTotalA = new JLabel("Valor Total a Pagar : ");
		lblValorTotalA.setIcon(new ImageIcon(T_017_calculadora.class.getResource("/img/pagamento.png")));
		lblValorTotalA.setForeground(Color.WHITE);
		lblValorTotalA.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValorTotalA.setBounds(373, 301, 187, 14);
		panel.add(lblValorTotalA);
		
		JLabel lblValorTotalDesconto = new JLabel("Valor Total Desconto : ");
		lblValorTotalDesconto.setIcon(new ImageIcon(T_017_calculadora.class.getResource("/img/banking.png")));
		lblValorTotalDesconto.setForeground(Color.WHITE);
		lblValorTotalDesconto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValorTotalDesconto.setBounds(373, 267, 187, 14);
		panel.add(lblValorTotalDesconto);
		
		JLabel adcionar = new JLabel("");
		adcionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		adcionar.setToolTipText("Adicionar Procedimento");
		adcionar.setHorizontalAlignment(SwingConstants.CENTER);
		adcionar.setIcon(new ImageIcon(T_004_ficha_paciente.class.getResource("/img/add.png")));
		adcionar.setBounds(221, 355, 46, 43);
		panel.add(adcionar);
		
		JLabel deletar = new JLabel("");
		deletar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		deletar.setToolTipText("Remover Procedimento");
		deletar.setIcon(new ImageIcon(T_004_ficha_paciente.class.getResource("/img/deleta.png")));
		deletar.setHorizontalAlignment(SwingConstants.CENTER);
		deletar.setBounds(281, 355, 46, 43);
		panel.add(deletar);
		
		JLabel bk = new JLabel("");
		bk.setHorizontalAlignment(SwingConstants.CENTER);
		bk.setIcon(new ImageIcon(T_003_livro_consulta.class.getResource("/img/bk.jpeg")));
		bk.setBounds(0, 2, 570, 409);
		panel.add(bk);

	}
}
