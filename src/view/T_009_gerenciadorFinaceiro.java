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

public class T_009_gerenciadorFinaceiro extends JPanel {
	private JTextField textField;
	private JComboBox textField_1;
	private JTable table;
	

	/**
	 * Create the panel.
	 */
	public T_009_gerenciadorFinaceiro() {
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
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tabbedPane.setBorder(null);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBackground(new Color(32, 178, 170));
		tabbedPane.setBounds(0, 0, 575, 428);
		
		add(tabbedPane);
		
		JPanel panelGerenciadorArquivosRemessa = new JPanel();
		tabbedPane.addTab("Remessa Bancaria", new ImageIcon(T_009_gerenciadorFinaceiro.class.getResource("/img/gambler pequeno.png")), panelGerenciadorArquivosRemessa, null);
		tabbedPane.setForegroundAt(0, Color.WHITE);
		panelGerenciadorArquivosRemessa.setLayout(null);
		
		JLabel btvoltar1 = new JLabel("");
		btvoltar1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				voltar();
			}
		});
		btvoltar1.setIcon(new ImageIcon(T_009_gerenciadorFinaceiro.class.getResource("/img/voltar.png")));
		btvoltar1.setHorizontalAlignment(SwingConstants.CENTER);
		btvoltar1.setBounds(535, 0, 25, 32);
		panelGerenciadorArquivosRemessa.add(btvoltar1);
		
		JLabel bk1 = new JLabel("");
		bk1.setIcon(new ImageIcon(T_009_gerenciadorFinaceiro.class.getResource("/img/bk.jpeg")));
		bk1.setHorizontalAlignment(SwingConstants.CENTER);
		bk1.setBounds(0, 0, 570, 409);
		panelGerenciadorArquivosRemessa.add(bk1);
		
		JPanel panelGerenciadorArquivosRetorno = new JPanel();
		tabbedPane.addTab("Arquivos Retorno", new ImageIcon(T_009_gerenciadorFinaceiro.class.getResource("/img/gambler pequeno.png")), panelGerenciadorArquivosRetorno, null);
		tabbedPane.setForegroundAt(1, Color.WHITE);
		panelGerenciadorArquivosRetorno.setLayout(null);
		
		JLabel btVoltar2 = new JLabel("");
		btVoltar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				voltar();
			}
		});
		btVoltar2.setIcon(new ImageIcon(T_009_gerenciadorFinaceiro.class.getResource("/img/voltar.png")));
		btVoltar2.setHorizontalAlignment(SwingConstants.CENTER);
		btVoltar2.setBounds(535, 0, 25, 32);
		panelGerenciadorArquivosRetorno.add(btVoltar2);
		
		JLabel bk2 = new JLabel("");
		bk2.setIcon(new ImageIcon(T_009_gerenciadorFinaceiro.class.getResource("/img/bk.jpeg")));
		bk2.setHorizontalAlignment(SwingConstants.CENTER);
		bk2.setBounds(0, 0, 570, 409);
		panelGerenciadorArquivosRetorno.add(bk2);
		
		JPanel panelGerenciadorSaldo = new JPanel();
		tabbedPane.addTab("Saldo de Contas", new ImageIcon(T_009_gerenciadorFinaceiro.class.getResource("/img/gambler pequeno.png")), panelGerenciadorSaldo, null);
		tabbedPane.setForegroundAt(2, Color.WHITE);
		panelGerenciadorSaldo.setLayout(null);
		
		JLabel btvoltar3 = new JLabel("");
		btvoltar3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				voltar();
			}
		});
		btvoltar3.setIcon(new ImageIcon(T_009_gerenciadorFinaceiro.class.getResource("/img/voltar.png")));
		btvoltar3.setHorizontalAlignment(SwingConstants.CENTER);
		btvoltar3.setBounds(535, 0, 25, 32);
		panelGerenciadorSaldo.add(btvoltar3);
		
		JLabel bk3 = new JLabel("");
		bk3.setIcon(new ImageIcon(T_009_gerenciadorFinaceiro.class.getResource("/img/bk.jpeg")));
		bk3.setHorizontalAlignment(SwingConstants.CENTER);
		bk3.setBounds(0, 0, 570, 409);
		panelGerenciadorSaldo.add(bk3);
		
		JPanel panelGerenciadorDeAnalises = new JPanel();
		tabbedPane.addTab("Analise Finaceira", new ImageIcon(T_009_gerenciadorFinaceiro.class.getResource("/img/gambler pequeno.png")), panelGerenciadorDeAnalises, null);
		tabbedPane.setForegroundAt(3, Color.WHITE);
		panelGerenciadorDeAnalises.setLayout(null);
		
		JLabel btvoltar4 = new JLabel("");
		btvoltar4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				voltar();
			}
		});
		btvoltar4.setIcon(new ImageIcon(T_009_gerenciadorFinaceiro.class.getResource("/img/voltar.png")));
		btvoltar4.setHorizontalAlignment(SwingConstants.CENTER);
		btvoltar4.setBounds(535, 0, 25, 32);
		panelGerenciadorDeAnalises.add(btvoltar4);
		
		JLabel bk4 = new JLabel("");
		bk4.setIcon(new ImageIcon(T_009_gerenciadorFinaceiro.class.getResource("/img/bk.jpeg")));
		bk4.setHorizontalAlignment(SwingConstants.CENTER);
		bk4.setBounds(0, 0, 570, 409);
		panelGerenciadorDeAnalises.add(bk4);
		
		JPanel panelCartoes = new JPanel();
		tabbedPane.addTab("Cat\u00F5es", new ImageIcon(T_009_gerenciadorFinaceiro.class.getResource("/img/gambler pequeno.png")), panelCartoes, null);
		tabbedPane.setForegroundAt(4, Color.WHITE);
		panelCartoes.setLayout(null);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				voltar();
			}
		});
		label.setIcon(new ImageIcon(T_009_gerenciadorFinaceiro.class.getResource("/img/voltar.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(535, 0, 25, 32);
		panelCartoes.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(T_009_gerenciadorFinaceiro.class.getResource("/img/bk.jpeg")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(0, 0, 570, 409);
		panelCartoes.add(label_1);
		
		JPanel panelGerenciadorInadiplencia = new JPanel();
		panelGerenciadorInadiplencia.setBackground(new Color(32, 178, 170));
		panelGerenciadorInadiplencia.setForeground(Color.WHITE);
		tabbedPane.addTab("Inadiplentes", new ImageIcon(T_009_gerenciadorFinaceiro.class.getResource("/img/gambler pequeno.png")), panelGerenciadorInadiplencia, null);
		tabbedPane.setBackgroundAt(5, new Color(32, 178, 170));
		tabbedPane.setForegroundAt(5, Color.WHITE);
		panelGerenciadorInadiplencia.setLayout(null);
		
		JLabel lblData = new JLabel("Nome : ");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblData.setForeground(Color.WHITE);
		lblData.setBounds(10, 11, 46, 14);
		panelGerenciadorInadiplencia.add(lblData);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setToolTipText("Buscar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setIcon(new ImageIcon(T_003_livro_consulta.class.getResource("/img/buscar.png")));
		lblNewLabel.setBounds(207, 2, 40, 32);
		panelGerenciadorInadiplencia.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				voltar();
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(T_004_ficha_paciente.class.getResource("/img/voltar.png")));
		lblNewLabel_1.setBounds(535, 2, 25, 32);
		panelGerenciadorInadiplencia.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(52, 8, 145, 20);
		panelGerenciadorInadiplencia.add(textField);
		textField.setColumns(10);
		
		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o : ");
		lblSituao.setForeground(Color.WHITE);
		lblSituao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSituao.setBounds(10, 39, 89, 14);
		panelGerenciadorInadiplencia.add(lblSituao);
		
		textField_1 = new JComboBox();
		textField_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		textField_1.setForeground(Color.BLACK);
		textField_1.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Ativos", "Inativos"}));
		textField_1.setBounds(73, 36, 145, 20);
		panelGerenciadorInadiplencia.add(textField_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 550, 279);
		panelGerenciadorInadiplencia.add(scrollPane);
		
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
		
		JLabel bk = new JLabel("");
		bk.setHorizontalAlignment(SwingConstants.CENTER);
		bk.setIcon(new ImageIcon(T_003_livro_consulta.class.getResource("/img/bk.jpeg")));
		bk.setBounds(0, 2, 570, 409);
		panelGerenciadorInadiplencia.add(bk);

	}
	
	public void voltar() {
		setVisible(false);
		
	}
}
