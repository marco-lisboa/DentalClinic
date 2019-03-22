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
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Cursor;

public class Tfinanceiro extends JPanel {

	/**
	 * Create the panel.
	 */
	public Tfinanceiro() {
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
		
		JTabbedPane tabbedPanePrincipal = new JTabbedPane(JTabbedPane.TOP);
		tabbedPanePrincipal.setBorder(null);
		tabbedPanePrincipal.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPanePrincipal.setBackground(new Color(32, 178, 170));
		tabbedPanePrincipal.setBounds(0, 0, 575, 428);
		add(tabbedPanePrincipal);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setForeground(Color.WHITE);
		tabbedPanePrincipal.addTab("Recebimentos e Pagamentos", new ImageIcon(Tfinanceiro.class.getResource("/img/gambler pequeno.png")), panel, null);
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
		
		JLabel lblNewLabel = new JLabel("Receitas");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 32, 272, 14);
		panel.add(lblNewLabel);
		
		JButton lblNewLabel_2 = new JButton("Recebimento");
		lblNewLabel_2.setFocusable(false);
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setBackground(new Color(32, 178, 170));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 68, 257, 14);
		panel.add(lblNewLabel_2);
		
		JButton lblGeraoDeParcelamento = new JButton("Gera\u00E7\u00E3o de Parcelamento");
		lblGeraoDeParcelamento.setFocusable(false);
		lblGeraoDeParcelamento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGeraoDeParcelamento.setBackground(new Color(32, 178, 170));
		lblGeraoDeParcelamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeraoDeParcelamento.setForeground(Color.WHITE);
		lblGeraoDeParcelamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGeraoDeParcelamento.setBounds(10, 118, 257, 14);
		panel.add(lblGeraoDeParcelamento);
		
		JButton lblGerenciadorFinanceiro = new JButton("Gerenciador Financeiro");
		lblGerenciadorFinanceiro.setFocusable(false);
		lblGerenciadorFinanceiro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGerenciadorFinanceiro.setBackground(new Color(32, 178, 170));
		lblGerenciadorFinanceiro.setHorizontalAlignment(SwingConstants.CENTER);
		lblGerenciadorFinanceiro.setForeground(Color.WHITE);
		lblGerenciadorFinanceiro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGerenciadorFinanceiro.setBounds(10, 140, 257, 14);
		panel.add(lblGerenciadorFinanceiro);
		
		JButton lblRecebimentoAvuso = new JButton("Recebimento Avuso");
		lblRecebimentoAvuso.setFocusable(false);
		lblRecebimentoAvuso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRecebimentoAvuso.setBackground(new Color(32, 178, 170));
		lblRecebimentoAvuso.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecebimentoAvuso.setForeground(Color.WHITE);
		lblRecebimentoAvuso.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRecebimentoAvuso.setBounds(10, 93, 257, 14);
		panel.add(lblRecebimentoAvuso);
		
		JButton lblBancosEContas = new JButton("Bancos e Contas");
		lblBancosEContas.setFocusable(false);
		lblBancosEContas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBancosEContas.setBackground(new Color(32, 178, 170));
		lblBancosEContas.setHorizontalAlignment(SwingConstants.CENTER);
		lblBancosEContas.setForeground(Color.WHITE);
		lblBancosEContas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBancosEContas.setBounds(10, 164, 257, 14);
		panel.add(lblBancosEContas);
		
		JButton btnServios = new JButton("Servi\u00E7os e Ofertas");
		btnServios.setFocusable(false);
		btnServios.setHorizontalAlignment(SwingConstants.CENTER);
		btnServios.setForeground(Color.WHITE);
		btnServios.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnServios.setBackground(new Color(32, 178, 170));
		btnServios.setBounds(10, 185, 257, 14);
		panel.add(btnServios);
		
		JLabel lblDespesas = new JLabel("Despesas");
		lblDespesas.setHorizontalAlignment(SwingConstants.CENTER);
		lblDespesas.setForeground(Color.WHITE);
		lblDespesas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDespesas.setBounds(288, 32, 272, 14);
		panel.add(lblDespesas);
		
		JButton lblContasAPagar = new JButton("Contas a Pagar");
		lblContasAPagar.setFocusable(false);
		lblContasAPagar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblContasAPagar.setBackground(new Color(32, 178, 170));
		lblContasAPagar.setHorizontalAlignment(SwingConstants.CENTER);
		lblContasAPagar.setForeground(Color.WHITE);
		lblContasAPagar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContasAPagar.setBounds(292, 68, 257, 14);
		panel.add(lblContasAPagar);
		
		JButton lblFolhaDePagamento = new JButton("Folha de Pagamento");
		lblFolhaDePagamento.setFocusable(false);
		lblFolhaDePagamento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblFolhaDePagamento.setBackground(new Color(32, 178, 170));
		lblFolhaDePagamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblFolhaDePagamento.setForeground(Color.WHITE);
		lblFolhaDePagamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFolhaDePagamento.setBounds(292, 93, 257, 14);
		panel.add(lblFolhaDePagamento);
		
		JButton lblCadastroDeFornecedores = new JButton("Cadastro de fornecedores");
		lblCadastroDeFornecedores.setFocusable(false);
		lblCadastroDeFornecedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCadastroDeFornecedores.setBackground(new Color(32, 178, 170));
		lblCadastroDeFornecedores.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeFornecedores.setForeground(Color.WHITE);
		lblCadastroDeFornecedores.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCadastroDeFornecedores.setBounds(292, 118, 257, 14);
		panel.add(lblCadastroDeFornecedores);
		
		JButton lblRelatorios = new JButton("Relatorios");
		lblRelatorios.setFocusable(false);
		lblRelatorios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRelatorios.setBackground(new Color(32, 178, 170));
		lblRelatorios.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatorios.setForeground(Color.WHITE);
		lblRelatorios.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRelatorios.setBounds(292, 137, 257, 14);
		panel.add(lblRelatorios);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(281, 32, 1, 324);
		panel.add(separator);
		
		JLabel bk = new JLabel("");
		bk.setHorizontalAlignment(SwingConstants.CENTER);
		bk.setIcon(new ImageIcon(Tlivro_consulta.class.getResource("/img/bk.jpeg")));
		bk.setBounds(0, 2, 570, 409);
		panel.add(bk);
		
		JTabbedPane tabbedPaneReceitaAvuso = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneReceitaAvuso.setVisible(false);
		
		JTabbedPane tabbedPaneReceitaRecebimento = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneReceitaRecebimento.setVisible(false);
		tabbedPaneReceitaRecebimento.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneReceitaRecebimento.setBorder(null);
		tabbedPaneReceitaRecebimento.setBackground(new Color(32, 178, 170));
		tabbedPaneReceitaRecebimento.setBounds(0, 0, 575, 428);
		add(tabbedPaneReceitaRecebimento);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(32, 178, 170));
		tabbedPaneReceitaRecebimento.addTab("Recebimento", new ImageIcon(Tfinanceiro.class.getResource("/img/gambler pequeno.png")), panel_1, null);
		tabbedPaneReceitaRecebimento.setForegroundAt(0, Color.WHITE);
		
		JLabel voltarRecebimento = new JLabel("");
		voltarRecebimento.setIcon(new ImageIcon(Tfinanceiro.class.getResource("/img/voltar.png")));
		voltarRecebimento.setToolTipText("Voltar");
		voltarRecebimento.setHorizontalAlignment(SwingConstants.CENTER);
		voltarRecebimento.setBounds(535, 2, 25, 32);
		panel_1.add(voltarRecebimento);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Tfinanceiro.class.getResource("/img/bk.jpeg")));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(0, 2, 570, 409);
		panel_1.add(label_3);
		tabbedPaneReceitaAvuso.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneReceitaAvuso.setBorder(null);
		tabbedPaneReceitaAvuso.setBackground(new Color(32, 178, 170));
		tabbedPaneReceitaAvuso.setBounds(0, 0, 575, 428);
		add(tabbedPaneReceitaAvuso);
		
		JTabbedPane tabbedPaneReceitaGeracaPacerla = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneReceitaGeracaPacerla.setVisible(false);
		tabbedPaneReceitaGeracaPacerla.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneReceitaGeracaPacerla.setBorder(null);
		tabbedPaneReceitaGeracaPacerla.setBackground(new Color(32, 178, 170));
		tabbedPaneReceitaGeracaPacerla.setBounds(0, 0, 575, 428);
		add(tabbedPaneReceitaGeracaPacerla);
		
		JTabbedPane tabbedPaneReceitaGerenciador = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneReceitaGerenciador.setVisible(false);
		tabbedPaneReceitaGerenciador.setBounds(0, 0, 570, 400);
		add(tabbedPaneReceitaGerenciador);
		tabbedPaneReceitaGerenciador.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneReceitaGerenciador.setBorder(null);
		tabbedPaneReceitaGerenciador.setBackground(new Color(32, 178, 170));
		
		JTabbedPane tabbedPaneReceitaBancoContas = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneReceitaBancoContas.setVisible(false);
		tabbedPaneReceitaBancoContas.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneReceitaBancoContas.setBorder(null);
		tabbedPaneReceitaBancoContas.setBackground(new Color(32, 178, 170));
		tabbedPaneReceitaBancoContas.setBounds(0, 0, 575, 428);
		add(tabbedPaneReceitaBancoContas);
		
		JTabbedPane tabbedPaneServicoOrfertas = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneServicoOrfertas.setVisible(false);
		tabbedPaneServicoOrfertas.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneServicoOrfertas.setBorder(null);
		tabbedPaneServicoOrfertas.setBackground(new Color(32, 178, 170));
		tabbedPaneServicoOrfertas.setBounds(0, 0, 575, 428);
		add(tabbedPaneServicoOrfertas);
		
		JTabbedPane tabbedPaneDespesasContasPagar = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneDespesasContasPagar.setVisible(false);
		tabbedPaneDespesasContasPagar.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneDespesasContasPagar.setBorder(null);
		tabbedPaneDespesasContasPagar.setBackground(new Color(32, 178, 170));
		tabbedPaneDespesasContasPagar.setBounds(0, 0, 575, 428);
		add(tabbedPaneDespesasContasPagar);
		
		JTabbedPane tabbedPaneDespesasFolha = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneDespesasFolha.setVisible(false);
		tabbedPaneDespesasFolha.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneDespesasFolha.setBorder(null);
		tabbedPaneDespesasFolha.setBackground(new Color(32, 178, 170));
		tabbedPaneDespesasFolha.setBounds(0, 0, 575, 428);
		add(tabbedPaneDespesasFolha);
		
		JTabbedPane tabbedPaneDespesasFornecedores = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneDespesasFornecedores.setVisible(false);
		tabbedPaneDespesasFornecedores.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneDespesasFornecedores.setBorder(null);
		tabbedPaneDespesasFornecedores.setBackground(new Color(32, 178, 170));
		tabbedPaneDespesasFornecedores.setBounds(0, 0, 575, 428);
		add(tabbedPaneDespesasFornecedores);
		
		JTabbedPane tabbedPaneRelatorios = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneRelatorios.setVisible(false);
		tabbedPaneRelatorios.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneRelatorios.setBorder(null);
		tabbedPaneRelatorios.setBackground(new Color(32, 178, 170));
		tabbedPaneRelatorios.setBounds(0, 0, 575, 428);
		add(tabbedPaneRelatorios);

	}
}
