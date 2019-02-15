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
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import java.awt.Cursor;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import javax.swing.JTextArea;

public class Tficha_paciente extends JPanel {
	private JTextField textField;
	private JComboBox textField_1;
	private JTable table;
	private JTextField txnome;
	private JTextField txcpf;
	private JTextField txmatricula;
	private JTextField txcontato1;
	private JTextField txcontato2;
	private JTextField email1;
	private JTextField email2;
	private JTabbedPane tabbedPaneCadastro;
	private JTabbedPane tabbedPaneFicha;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnSim;
	private JRadioButton rdbtnNo;
	private JTextPane textPaneobs;
	private JLabel lblQuais;
	private JComboBox comboBox;
	private JDateChooser dtnascimento;
	private JComboBox op1;
	private JCheckBox w1;
	private JComboBox op2;
	private JCheckBox w2;
	private JComboBox convenios;
	private JCheckBox dt18;
	private JCheckBox dt17;
	private JCheckBox dt16;
	private JCheckBox dt15;
	private JCheckBox dt14;
	private JCheckBox dt13;
	private JCheckBox dt12;
	private JCheckBox dt11;
	private JCheckBox dt21;
	private JCheckBox dt22;
	private JCheckBox dt23;
	private JCheckBox dt24;
	private JCheckBox dt25;
	private JCheckBox dt26;
	private JCheckBox dt27;
	private JCheckBox dt28;
	private JCheckBox dt31;
	private JCheckBox dt32;
	private JCheckBox dt33;
	private JCheckBox dt34;
	private JCheckBox dt35;
	private JCheckBox dt41;
	private JCheckBox dt42;
	private JCheckBox dt43;
	private JCheckBox dt44;
	private JCheckBox dt45;
	private JCheckBox dt46;
	private JCheckBox dt47;
	private JCheckBox dt48;
	private JLabel av11;
	private JLabel av12;
	private JLabel av13;
	private JLabel av14;
	private JLabel av15;
	private JLabel av16;
	private JLabel av17;
	private JLabel av18;
	private JLabel av21;
	private JLabel av22;
	private JLabel av23;
	private JLabel label_10;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_16;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_19;
	private JLabel label_20;
	private JLabel label_21;
	private JLabel label_23;
	private JLabel label_24;
	private JLabel label_29;
	private JLabel label_30;
	private JLabel label_31;
	private JLabel label_32;
	private JLabel label_4;
	private JTabbedPane tabbedPaneav;
	private JLabel bkav;
	private JLabel textoav;

	/**
	 * Create the panel.
	 */
	public Tficha_paciente() {
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
		
		tabbedPaneCadastro = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneCadastro.setVisible(false);
		tabbedPaneCadastro.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneCadastro.setBorder(null);
		tabbedPaneCadastro.setBackground(new Color(32, 178, 170));
		tabbedPaneCadastro.setBounds(0, 0, 575, 428);
		add(tabbedPaneCadastro);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(32, 178, 170));
		tabbedPaneCadastro.addTab("Ficha Cadastral", null, panel_1, null);
		tabbedPaneCadastro.setForegroundAt(0, Color.WHITE);
		
		JLabel lblNomePaciente = new JLabel("Nome Paciente : ");
		lblNomePaciente.setForeground(Color.WHITE);
		lblNomePaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomePaciente.setBounds(10, 11, 123, 14);
		panel_1.add(lblNomePaciente);
		
		JLabel label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(505, 357, 25, 32);
		panel_1.add(label_2);
		
		txnome = new JTextField();
		txnome.setColumns(10);
		txnome.setBounds(102, 8, 458, 20);
		panel_1.add(txnome);
		
		JLabel lblCpf = new JLabel("cpf : ");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setBounds(10, 39, 123, 14);
		panel_1.add(lblCpf);
		
		txcpf = new JTextField();
		txcpf.setColumns(10);
		txcpf.setBounds(43, 36, 225, 20);
		panel_1.add(txcpf);
		
		JLabel label_5 = new JLabel("");
		label_5.setToolTipText("Remover Paciente");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(281, 355, 46, 43);
		panel_1.add(label_5);
		
		JLabel lblDataNascimento = new JLabel("Data Nascimento : ");
		lblDataNascimento.setForeground(Color.WHITE);
		lblDataNascimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataNascimento.setBounds(278, 42, 123, 14);
		panel_1.add(lblDataNascimento);
		
		dtnascimento = new JDateChooser();
		dtnascimento.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dtnascimento.setBounds(387, 39, 123, 20);
		panel_1.add(dtnascimento);
		
		JLabel lblCidade = new JLabel("Nascionalidade :");
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCidade.setBounds(10, 79, 123, 14);
		panel_1.add(lblCidade);
		
		comboBox = new JComboBox();
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox.setBounds(102, 75, 152, 22);
		panel_1.add(comboBox);
		
		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstado.setBounds(264, 79, 54, 14);
		panel_1.add(lblEstado);
		
		JComboBox estado = new JComboBox();
		estado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		estado.setBounds(312, 75, 54, 22);
		panel_1.add(estado);
		
		JComboBox cidade = new JComboBox();
		cidade.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cidade.setBounds(424, 75, 136, 22);
		panel_1.add(cidade);
		
		JLabel lblCidade_1 = new JLabel("Cidade :");
		lblCidade_1.setForeground(Color.WHITE);
		lblCidade_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCidade_1.setBounds(376, 79, 54, 14);
		panel_1.add(lblCidade_1);
		
		JLabel lblConvenio = new JLabel("Convenio :");
		lblConvenio.setForeground(Color.WHITE);
		lblConvenio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConvenio.setBounds(10, 221, 123, 14);
		panel_1.add(lblConvenio);
		
		convenios = new JComboBox();
		convenios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		convenios.setModel(new DefaultComboBoxModel(new String[] {"Planos"}));
		convenios.setBounds(77, 217, 235, 22);
		panel_1.add(convenios);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setToolTipText("Abrir site");
		lblNewLabel_2.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/play.png")));
		lblNewLabel_2.setBounds(322, 213, 32, 32);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblCodigoMatricula = new JLabel("Codigo/Matricula : ");
		lblCodigoMatricula.setForeground(Color.WHITE);
		lblCodigoMatricula.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigoMatricula.setBounds(10, 249, 123, 14);
		panel_1.add(lblCodigoMatricula);
		
		txmatricula = new JTextField();
		txmatricula.setColumns(10);
		txmatricula.setBounds(119, 246, 225, 20);
		panel_1.add(txmatricula);
		
		JLabel lblPossuiAlergia = new JLabel("Possui Alergia Algum Medicamento ? ");
		lblPossuiAlergia.setForeground(Color.WHITE);
		lblPossuiAlergia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPossuiAlergia.setBounds(14, 277, 377, 14);
		panel_1.add(lblPossuiAlergia);
		
		rdbtnSim = new JRadioButton("sim");
		rdbtnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				medicamento(1);
				
			}
		});
		buttonGroup.add(rdbtnSim);
		rdbtnSim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnSim.setForeground(Color.WHITE);
		rdbtnSim.setOpaque(false);
		rdbtnSim.setBounds(10, 298, 85, 23);
		panel_1.add(rdbtnSim);
		
		rdbtnNo = new JRadioButton("N\u00E3o");
		rdbtnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				medicamento(0);
			}
		});
		buttonGroup.add(rdbtnNo);
		rdbtnNo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnNo.setOpaque(false);
		rdbtnNo.setForeground(Color.WHITE);
		rdbtnNo.setBounds(106, 298, 85, 23);
		panel_1.add(rdbtnNo);
		
		lblQuais = new JLabel("Quais?");
		lblQuais.setVisible(false);
		lblQuais.setForeground(Color.WHITE);
		lblQuais.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuais.setBounds(10, 316, 377, 14);
		panel_1.add(lblQuais);
		
		textPaneobs = new JTextPane();
		textPaneobs.setVisible(false);
		textPaneobs.setBounds(10, 340, 317, 49);
		panel_1.add(textPaneobs);
		
		txcontato1 = new JTextField();
		txcontato1.setColumns(10);
		txcontato1.setBounds(64, 104, 127, 20);
		panel_1.add(txcontato1);
		
		JLabel lblContato = new JLabel("Contato : ");
		lblContato.setForeground(Color.WHITE);
		lblContato.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContato.setBounds(9, 107, 61, 14);
		panel_1.add(lblContato);
		
		JLabel label = new JLabel("Contato : ");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(9, 135, 61, 14);
		panel_1.add(label);
		
		txcontato2 = new JTextField();
		txcontato2.setColumns(10);
		txcontato2.setBounds(64, 132, 127, 20);
		panel_1.add(txcontato2);
		
		JLabel lblOp = new JLabel("Op :");
		lblOp.setForeground(Color.WHITE);
		lblOp.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOp.setBounds(202, 106, 123, 14);
		panel_1.add(lblOp);
		
		op1 = new JComboBox();
		op1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		op1.setBounds(234, 103, 152, 22);
		panel_1.add(op1);
		
		w1 = new JCheckBox("WhatsApp");
		w1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		w1.setForeground(Color.WHITE);
		w1.setOpaque(false);
		w1.setBounds(400, 104, 97, 23);
		panel_1.add(w1);
		
		JLabel label_1 = new JLabel("Op :");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(201, 135, 32, 14);
		panel_1.add(label_1);
		
		op2 = new JComboBox();
		op2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		op2.setBounds(234, 131, 152, 22);
		panel_1.add(op2);
		
		w2 = new JCheckBox("WhatsApp");
		w2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		w2.setOpaque(false);
		w2.setForeground(Color.WHITE);
		w2.setBounds(400, 131, 97, 23);
		panel_1.add(w2);
		
		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(10, 163, 123, 14);
		panel_1.add(lblEmail);
		
		email1 = new JTextField();
		email1.setColumns(10);
		email1.setBounds(52, 160, 458, 20);
		panel_1.add(email1);
		
		email2 = new JTextField();
		email2.setColumns(10);
		email2.setBounds(52, 188, 458, 20);
		panel_1.add(email2);
		
		JLabel label_3 = new JLabel("Email : ");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(10, 191, 123, 14);
		panel_1.add(label_3);
		
		JLabel salvar = new JLabel("");
		salvar.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/save.png")));
		salvar.setToolTipText("Salvar");
		salvar.setBounds(407, 299, 32, 49);
		panel_1.add(salvar);
		
		JLabel limpar = new JLabel("");
		limpar.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/eraser.png")));
		limpar.setToolTipText("Limpar");
		limpar.setBounds(465, 299, 32, 49);
		panel_1.add(limpar);
		
		JLabel voltar = new JLabel("");
		voltar.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/voltar.png")));
		voltar.setToolTipText("Voltar");
		voltar.setBounds(521, 299, 32, 49);
		panel_1.add(voltar);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/bk.jpeg")));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(0, 2, 570, 409);
		panel_1.add(label_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		tabbedPaneCadastro.addTab("Avaliação Clinica", null, panel_2, null);
		tabbedPaneCadastro.setForegroundAt(1, Color.WHITE);
		
		tabbedPaneav = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneav.setVisible(false);
		tabbedPaneav.setBounds(98, 11, 394, 378);
		panel_2.add(tabbedPaneav);
		
		JPanel panel_3 = new JPanel();
		tabbedPaneav.addTab("Avalia\u00E7\u00E3o", null, panel_3, null);
		panel_3.setLayout(null);
		
		textoav = new JLabel("Avalia\u00E7\u00E3o referente ao dente ");
		textoav.setFont(new Font("Tahoma", Font.BOLD, 12));
		textoav.setForeground(Color.WHITE);
		textoav.setHorizontalAlignment(SwingConstants.CENTER);
		textoav.setBounds(6, 11, 373, 14);
		panel_3.add(textoav);
		
		JCheckBox chckbxRestaurao = new JCheckBox("Canal");
		chckbxRestaurao.setOpaque(false);
		chckbxRestaurao.setForeground(Color.WHITE);
		chckbxRestaurao.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxRestaurao.setFocusable(false);
		chckbxRestaurao.setBounds(16, 36, 155, 23);
		panel_3.add(chckbxRestaurao);
		
		JCheckBox chckbxObturao = new JCheckBox("Restaura\u00E7\u00E3o");
		chckbxObturao.setOpaque(false);
		chckbxObturao.setForeground(Color.WHITE);
		chckbxObturao.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxObturao.setFocusable(false);
		chckbxObturao.setBounds(16, 62, 155, 23);
		panel_3.add(chckbxObturao);
		
		JCheckBox chckbxCoroa = new JCheckBox("Coroa");
		chckbxCoroa.setOpaque(false);
		chckbxCoroa.setForeground(Color.WHITE);
		chckbxCoroa.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxCoroa.setFocusable(false);
		chckbxCoroa.setBounds(16, 88, 155, 23);
		panel_3.add(chckbxCoroa);
		
		JCheckBox chckbxExtrao = new JCheckBox("Extra\u00E7\u00E3o");
		chckbxExtrao.setOpaque(false);
		chckbxExtrao.setForeground(Color.WHITE);
		chckbxExtrao.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxExtrao.setFocusable(false);
		chckbxExtrao.setBounds(16, 114, 155, 23);
		panel_3.add(chckbxExtrao);
		
		JCheckBox checkBox = new JCheckBox("Canal");
		checkBox.setOpaque(false);
		checkBox.setForeground(Color.WHITE);
		checkBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBox.setFocusable(false);
		checkBox.setBounds(224, 36, 155, 23);
		panel_3.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("Restaura\u00E7\u00E3o");
		checkBox_1.setOpaque(false);
		checkBox_1.setForeground(Color.WHITE);
		checkBox_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBox_1.setFocusable(false);
		checkBox_1.setBounds(224, 62, 155, 23);
		panel_3.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("Coroa");
		checkBox_2.setOpaque(false);
		checkBox_2.setForeground(Color.WHITE);
		checkBox_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBox_2.setFocusable(false);
		checkBox_2.setBounds(224, 88, 155, 23);
		panel_3.add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("Extra\u00E7\u00E3o");
		checkBox_3.setOpaque(false);
		checkBox_3.setForeground(Color.WHITE);
		checkBox_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBox_3.setFocusable(false);
		checkBox_3.setBounds(224, 114, 155, 23);
		panel_3.add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("Coroa");
		checkBox_4.setOpaque(false);
		checkBox_4.setForeground(Color.WHITE);
		checkBox_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBox_4.setFocusable(false);
		checkBox_4.setBounds(16, 140, 155, 23);
		panel_3.add(checkBox_4);
		
		JCheckBox checkBox_5 = new JCheckBox("Extra\u00E7\u00E3o");
		checkBox_5.setOpaque(false);
		checkBox_5.setForeground(Color.WHITE);
		checkBox_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBox_5.setFocusable(false);
		checkBox_5.setBounds(16, 166, 155, 23);
		panel_3.add(checkBox_5);
		
		JCheckBox checkBox_6 = new JCheckBox("Coroa");
		checkBox_6.setOpaque(false);
		checkBox_6.setForeground(Color.WHITE);
		checkBox_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBox_6.setFocusable(false);
		checkBox_6.setBounds(224, 143, 155, 23);
		panel_3.add(checkBox_6);
		
		JCheckBox checkBox_7 = new JCheckBox("Extra\u00E7\u00E3o");
		checkBox_7.setOpaque(false);
		checkBox_7.setForeground(Color.WHITE);
		checkBox_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		checkBox_7.setFocusable(false);
		checkBox_7.setBounds(224, 169, 155, 23);
		panel_3.add(checkBox_7);
		
		JLabel lblObservaesClinicas = new JLabel("Observa\u00E7\u00F5es Clinicas");
		lblObservaesClinicas.setHorizontalAlignment(SwingConstants.LEFT);
		lblObservaesClinicas.setForeground(Color.BLACK);
		lblObservaesClinicas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblObservaesClinicas.setBounds(16, 196, 363, 14);
		panel_3.add(lblObservaesClinicas);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(16, 220, 363, 87);
		panel_3.add(textArea);
		
		JLabel btConfirma = new JLabel("");
		btConfirma.setHorizontalAlignment(SwingConstants.CENTER);
		btConfirma.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/savep.png")));
		btConfirma.setBounds(144, 306, 46, 33);
		panel_3.add(btConfirma);
		
		JLabel btCancela = new JLabel("");
		btCancela.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/fechar.png")));
		btCancela.setHorizontalAlignment(SwingConstants.CENTER);
		btCancela.setBounds(200, 306, 46, 33);
		panel_3.add(btCancela);
		
		bkav = new JLabel("");
		bkav.setHorizontalAlignment(SwingConstants.CENTER);
		bkav.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/bk.jpeg")));
		bkav.setBounds(0, 0, 389, 350);
		panel_3.add(bkav);
		
		dt18 = new JCheckBox("18");
		dt18.setOpaque(false);
		dt18.setForeground(Color.WHITE);
		dt18.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt18.setFocusable(false);
		dt18.setBounds(10, 281, 50, 23);
		panel_2.add(dt18);
		
		dt17 = new JCheckBox("17");
		dt17.setOpaque(false);
		dt17.setForeground(Color.WHITE);
		dt17.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt17.setFocusable(false);
		dt17.setBounds(10, 253, 50, 23);
		panel_2.add(dt17);
		
		dt16 = new JCheckBox("16");
		dt16.setOpaque(false);
		dt16.setForeground(Color.WHITE);
		dt16.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt16.setFocusable(false);
		dt16.setBounds(10, 222, 50, 23);
		panel_2.add(dt16);
		
		dt15 = new JCheckBox("15");
		dt15.setOpaque(false);
		dt15.setForeground(Color.WHITE);
		dt15.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt15.setFocusable(false);
		dt15.setBounds(10, 190, 50, 23);
		panel_2.add(dt15);
		
		dt14 = new JCheckBox("14");
		dt14.setOpaque(false);
		dt14.setForeground(Color.WHITE);
		dt14.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt14.setFocusable(false);
		dt14.setBounds(10, 162, 50, 23);
		panel_2.add(dt14);
		
		dt13 = new JCheckBox("13");
		dt13.setOpaque(false);
		dt13.setForeground(Color.WHITE);
		dt13.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt13.setFocusable(false);
		dt13.setBounds(10, 132, 50, 23);
		panel_2.add(dt13);
		
		dt12 = new JCheckBox("12");
		dt12.setOpaque(false);
		dt12.setForeground(Color.WHITE);
		dt12.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt12.setFocusable(false);
		dt12.setBounds(10, 104, 50, 23);
		panel_2.add(dt12);
		
		dt11 = new JCheckBox("11");
		dt11.setOpaque(false);
		dt11.setForeground(Color.WHITE);
		dt11.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt11.setFocusable(false);
		dt11.setBounds(10, 72, 50, 23);
		panel_2.add(dt11);
		
		dt21 = new JCheckBox("21");
		dt21.setOpaque(false);
		dt21.setForeground(Color.WHITE);
		dt21.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt21.setFocusable(false);
		dt21.setBounds(154, 72, 50, 23);
		panel_2.add(dt21);
		
		dt22 = new JCheckBox("22");
		dt22.setOpaque(false);
		dt22.setForeground(Color.WHITE);
		dt22.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt22.setFocusable(false);
		dt22.setBounds(154, 104, 50, 23);
		panel_2.add(dt22);
		
		dt23 = new JCheckBox("23");
		dt23.setOpaque(false);
		dt23.setForeground(Color.WHITE);
		dt23.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt23.setFocusable(false);
		dt23.setBounds(154, 132, 50, 23);
		panel_2.add(dt23);
		
		dt24 = new JCheckBox("24");
		dt24.setOpaque(false);
		dt24.setForeground(Color.WHITE);
		dt24.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt24.setFocusable(false);
		dt24.setBounds(154, 162, 50, 23);
		panel_2.add(dt24);
		
		dt25 = new JCheckBox("25");
		dt25.setOpaque(false);
		dt25.setForeground(Color.WHITE);
		dt25.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt25.setFocusable(false);
		dt25.setBounds(154, 190, 50, 23);
		panel_2.add(dt25);
		
		dt26 = new JCheckBox("26");
		dt26.setOpaque(false);
		dt26.setForeground(Color.WHITE);
		dt26.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt26.setFocusable(false);
		dt26.setBounds(154, 222, 50, 23);
		panel_2.add(dt26);
		
		dt27 = new JCheckBox("27");
		dt27.setOpaque(false);
		dt27.setForeground(Color.WHITE);
		dt27.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt27.setFocusable(false);
		dt27.setBounds(154, 253, 50, 23);
		panel_2.add(dt27);
		
		dt28 = new JCheckBox("28");
		dt28.setOpaque(false);
		dt28.setForeground(Color.WHITE);
		dt28.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt28.setFocusable(false);
		dt28.setBounds(154, 283, 50, 23);
		panel_2.add(dt28);
		
		dt31 = new JCheckBox("31");
		dt31.setOpaque(false);
		dt31.setForeground(Color.WHITE);
		dt31.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt31.setFocusable(false);
		dt31.setBounds(442, 73, 50, 23);
		panel_2.add(dt31);
		
		dt32 = new JCheckBox("32");
		dt32.setOpaque(false);
		dt32.setForeground(Color.WHITE);
		dt32.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt32.setFocusable(false);
		dt32.setBounds(442, 104, 50, 23);
		panel_2.add(dt32);
		
		dt33 = new JCheckBox("33");
		dt33.setOpaque(false);
		dt33.setForeground(Color.WHITE);
		dt33.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt33.setFocusable(false);
		dt33.setBounds(442, 134, 50, 23);
		panel_2.add(dt33);
		
		dt34 = new JCheckBox("34");
		dt34.setOpaque(false);
		dt34.setForeground(Color.WHITE);
		dt34.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt34.setFocusable(false);
		dt34.setBounds(442, 162, 50, 23);
		panel_2.add(dt34);
		
		dt35 = new JCheckBox("35");
		dt35.setOpaque(false);
		dt35.setForeground(Color.WHITE);
		dt35.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt35.setFocusable(false);
		dt35.setBounds(442, 190, 50, 23);
		panel_2.add(dt35);
		
		JCheckBox dt36 = new JCheckBox("36");
		dt36.setOpaque(false);
		dt36.setForeground(Color.WHITE);
		dt36.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt36.setFocusable(false);
		dt36.setBounds(442, 224, 50, 23);
		panel_2.add(dt36);
		
		JCheckBox dt37 = new JCheckBox("37");
		dt37.setOpaque(false);
		dt37.setForeground(Color.WHITE);
		dt37.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt37.setFocusable(false);
		dt37.setBounds(442, 255, 50, 23);
		panel_2.add(dt37);
		
		JCheckBox dt38 = new JCheckBox("38");
		dt38.setOpaque(false);
		dt38.setForeground(Color.WHITE);
		dt38.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt38.setFocusable(false);
		dt38.setBounds(442, 281, 50, 23);
		panel_2.add(dt38);
		
		dt41 = new JCheckBox("41");
		dt41.setOpaque(false);
		dt41.setForeground(Color.WHITE);
		dt41.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt41.setFocusable(false);
		dt41.setBounds(311, 72, 50, 23);
		panel_2.add(dt41);
		
		dt42 = new JCheckBox("42");
		dt42.setOpaque(false);
		dt42.setForeground(Color.WHITE);
		dt42.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt42.setFocusable(false);
		dt42.setBounds(311, 106, 50, 23);
		panel_2.add(dt42);
		
		dt43 = new JCheckBox("43");
		dt43.setOpaque(false);
		dt43.setForeground(Color.WHITE);
		dt43.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt43.setFocusable(false);
		dt43.setBounds(311, 134, 50, 23);
		panel_2.add(dt43);
		
		dt44 = new JCheckBox("44");
		dt44.setOpaque(false);
		dt44.setForeground(Color.WHITE);
		dt44.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt44.setFocusable(false);
		dt44.setBounds(311, 164, 50, 23);
		panel_2.add(dt44);
		
		dt45 = new JCheckBox("45");
		dt45.setOpaque(false);
		dt45.setForeground(Color.WHITE);
		dt45.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt45.setFocusable(false);
		dt45.setBounds(311, 196, 50, 23);
		panel_2.add(dt45);
		
		dt46 = new JCheckBox("46");
		dt46.setOpaque(false);
		dt46.setForeground(Color.WHITE);
		dt46.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt46.setFocusable(false);
		dt46.setBounds(311, 222, 50, 23);
		panel_2.add(dt46);
		
		dt47 = new JCheckBox("47");
		dt47.setOpaque(false);
		dt47.setForeground(Color.WHITE);
		dt47.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt47.setFocusable(false);
		dt47.setBounds(311, 253, 50, 23);
		panel_2.add(dt47);
		
		dt48 = new JCheckBox("48");
		dt48.setOpaque(false);
		dt48.setForeground(Color.WHITE);
		dt48.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt48.setFocusable(false);
		dt48.setBounds(311, 281, 50, 23);
		panel_2.add(dt48);
		
		JLabel label_11 = new JLabel("Arco Superior");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_11.setBounds(10, 45, 274, 14);
		panel_2.add(label_11);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(283, 45, 1, 281);
		panel_2.add(separator);
		
		JLabel label_12 = new JLabel("Arco Inferior");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_12.setBounds(283, 45, 274, 14);
		panel_2.add(label_12);
		
		av11 = new JLabel("");
		av11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av11.setToolTipText("Avalia");
		av11.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av11.setBounds(66, 70, 31, 25);
		panel_2.add(av11);
		
		av12 = new JLabel("");
		av12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av12.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av12.setToolTipText("Avaliar");
		av12.setBounds(66, 102, 31, 25);
		panel_2.add(av12);
		
		av13 = new JLabel("");
		av13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av13.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av13.setToolTipText("Avaliar");
		av13.setBounds(66, 130, 31, 25);
		panel_2.add(av13);
		
		av14 = new JLabel("");
		av14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av14.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av14.setToolTipText("Avaliar");
		av14.setBounds(66, 162, 31, 25);
		panel_2.add(av14);
		
		av15 = new JLabel("");
		av15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av15.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av15.setToolTipText("Avaliar");
		av15.setBounds(66, 188, 31, 25);
		panel_2.add(av15);
		
		av16 = new JLabel("");
		av16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av16.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av16.setToolTipText("Avaliar");
		av16.setBounds(66, 220, 31, 25);
		panel_2.add(av16);
		
		av17 = new JLabel("");
		av17.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av17.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av17.setToolTipText("Avaliar");
		av17.setBounds(66, 251, 31, 25);
		panel_2.add(av17);
		
		av18 = new JLabel("");
		av18.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av18.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av18.setToolTipText("Avaliar");
		av18.setBounds(66, 279, 31, 25);
		panel_2.add(av18);
		
		av21 = new JLabel("");
		av21.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av21.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av21.setToolTipText("Avalia");
		av21.setBounds(210, 70, 31, 25);
		panel_2.add(av21);
		
		av22 = new JLabel("");
		av22.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av22.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av22.setToolTipText("Avalia");
		av22.setBounds(210, 104, 31, 25);
		panel_2.add(av22);
		
		av23 = new JLabel("");
		av23.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av23.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av23.setToolTipText("Avalia");
		av23.setBounds(210, 132, 31, 25);
		panel_2.add(av23);
		
		label_10 = new JLabel("");
		label_10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_10.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		label_10.setToolTipText("Avalia");
		label_10.setBounds(210, 162, 31, 25);
		panel_2.add(label_10);
		
		label_13 = new JLabel("");
		label_13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_13.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		label_13.setToolTipText("Avalia");
		label_13.setBounds(210, 190, 31, 25);
		panel_2.add(label_13);
		
		JLabel label_22 = new JLabel("");
		label_22.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_22.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		label_22.setToolTipText("Avalia");
		label_22.setBounds(210, 222, 31, 25);
		panel_2.add(label_22);
		
		label_14 = new JLabel("");
		label_14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_14.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		label_14.setToolTipText("Avalia");
		label_14.setBounds(210, 253, 31, 25);
		panel_2.add(label_14);
		
		label_15 = new JLabel("");
		label_15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_15.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		label_15.setToolTipText("Avalia");
		label_15.setBounds(210, 281, 31, 25);
		panel_2.add(label_15);
		
		JLabel label_25 = new JLabel("");
		label_25.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_25.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		label_25.setToolTipText("Avalia");
		label_25.setBounds(367, 70, 31, 25);
		panel_2.add(label_25);
		
		JLabel duvidas = new JLabel("");
		duvidas.setToolTipText("O que fazer ?");
		duvidas.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/document.png")));
		duvidas.setBounds(10, 0, 31, 36);
		panel_2.add(duvidas);
		
		JLabel label_26 = new JLabel("");
		label_26.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_26.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		label_26.setToolTipText("Avalia");
		label_26.setBounds(367, 104, 31, 25);
		panel_2.add(label_26);
		
		JLabel label_27 = new JLabel("");
		label_27.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_27.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		label_27.setToolTipText("Avalia");
		label_27.setBounds(367, 132, 31, 25);
		panel_2.add(label_27);
		
		JLabel label_28 = new JLabel("");
		label_28.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_28.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		label_28.setToolTipText("Avalia");
		label_28.setBounds(367, 162, 31, 25);
		panel_2.add(label_28);
		
		label_16 = new JLabel("");
		label_16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_16.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		label_16.setToolTipText("Avalia");
		label_16.setBounds(367, 194, 31, 25);
		panel_2.add(label_16);
		
		label_17 = new JLabel("");
		label_17.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_17.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		label_17.setToolTipText("Avalia");
		label_17.setBounds(367, 222, 31, 25);
		panel_2.add(label_17);
		
		label_18 = new JLabel("");
		label_18.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_18.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		label_18.setToolTipText("Avalia");
		label_18.setBounds(367, 253, 31, 25);
		panel_2.add(label_18);
		
		label_19 = new JLabel("");
		label_19.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_19.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		label_19.setToolTipText("Avalia");
		label_19.setBounds(367, 281, 31, 25);
		panel_2.add(label_19);
		
		label_20 = new JLabel("");
		label_20.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_20.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		label_20.setToolTipText("Avalia");
		label_20.setBounds(498, 72, 31, 25);
		panel_2.add(label_20);
		
		label_21 = new JLabel("");
		label_21.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_21.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		label_21.setToolTipText("Avalia");
		label_21.setBounds(498, 104, 31, 25);
		panel_2.add(label_21);
		
		label_23 = new JLabel("");
		label_23.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_23.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		label_23.setToolTipText("Avalia");
		label_23.setBounds(498, 134, 31, 25);
		panel_2.add(label_23);
		
		label_24 = new JLabel("");
		label_24.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_24.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		label_24.setToolTipText("Avalia");
		label_24.setBounds(498, 162, 31, 25);
		panel_2.add(label_24);
		
		label_29 = new JLabel("");
		label_29.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_29.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		label_29.setToolTipText("Avalia");
		label_29.setBounds(498, 190, 31, 25);
		panel_2.add(label_29);
		
		label_30 = new JLabel("");
		label_30.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_30.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		label_30.setToolTipText("Avalia");
		label_30.setBounds(498, 222, 31, 25);
		panel_2.add(label_30);
		
		label_31 = new JLabel("");
		label_31.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_31.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		label_31.setToolTipText("Avalia");
		label_31.setBounds(498, 253, 31, 25);
		panel_2.add(label_31);
		
		label_32 = new JLabel("");
		label_32.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_32.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		label_32.setToolTipText("Avalia");
		label_32.setBounds(498, 281, 31, 25);
		panel_2.add(label_32);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/savep.png")));
		label_4.setToolTipText("Salvar");
		label_4.setBounds(204, 351, 32, 49);
		panel_2.add(label_4);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/eraser.png")));
		label_8.setToolTipText("Limpar");
		label_8.setBounds(262, 351, 32, 49);
		panel_2.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/voltar.png")));
		label_9.setToolTipText("Voltar");
		label_9.setBounds(318, 351, 32, 49);
		panel_2.add(label_9);
		
		JLabel bkAvc = new JLabel("");
		bkAvc.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/bk.jpeg")));
		bkAvc.setHorizontalAlignment(SwingConstants.CENTER);
		bkAvc.setBounds(0, 0, 570, 409);
		panel_2.add(bkAvc);
		
		tabbedPaneFicha = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneFicha.setBorder(null);
		tabbedPaneFicha.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneFicha.setBackground(new Color(32, 178, 170));
		tabbedPaneFicha.setBounds(0, 0, 575, 428);
		add(tabbedPaneFicha);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setForeground(Color.WHITE);
		tabbedPaneFicha.addTab("Ficha de Paciente", new ImageIcon(Tficha_paciente.class.getResource("/img/ficha paciente pequeno.png")), panel, null);
		tabbedPaneFicha.setForegroundAt(0, Color.WHITE);
		panel.setLayout(null);
		
		JLabel lblData = new JLabel("Nome : ");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblData.setForeground(Color.WHITE);
		lblData.setBounds(10, 11, 46, 14);
		panel.add(lblData);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setToolTipText("Buscar");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setIcon(new ImageIcon(Tlivro_consulta.class.getResource("/img/buscar.png")));
		lblNewLabel.setBounds(207, 2, 46, 32);
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
		
		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o : ");
		lblSituao.setForeground(Color.WHITE);
		lblSituao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSituao.setBounds(10, 39, 89, 14);
		panel.add(lblSituao);
		
		textField_1 = new JComboBox();
		textField_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		textField_1.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Ativos", "Inativos"}));
		textField_1.setBounds(73, 36, 145, 20);
		panel.add(textField_1);
		
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
		
		JLabel adcionar = new JLabel("");
		adcionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		adcionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				tabbedPaneFicha.setVisible(false);
				tabbedPaneCadastro.setVisible(true);
				
				
				
			}
		});
		adcionar.setToolTipText("Adicionar Novo Paciente");
		adcionar.setHorizontalAlignment(SwingConstants.CENTER);
		adcionar.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/add.png")));
		adcionar.setBounds(221, 355, 46, 43);
		panel.add(adcionar);
		
		JLabel delete = new JLabel("");
		delete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		delete.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/deleta.png")));
		delete.setToolTipText("Remover Paciente");
		delete.setHorizontalAlignment(SwingConstants.CENTER);
		delete.setBounds(337, 355, 46, 43);
		panel.add(delete);
		
		JLabel editar = new JLabel("");
		editar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editar.setToolTipText("Editar");
		editar.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/editar (2).png")));
		editar.setHorizontalAlignment(SwingConstants.CENTER);
		editar.setBounds(281, 355, 46, 43);
		panel.add(editar);
		
		JLabel label_7 = new JLabel("null registros encontrados");
		label_7.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/confimado.png")));
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_7.setBounds(10, 368, 208, 14);
		panel.add(label_7);
		
		JLabel bk = new JLabel("");
		bk.setHorizontalAlignment(SwingConstants.CENTER);
		bk.setIcon(new ImageIcon(Tlivro_consulta.class.getResource("/img/bk.jpeg")));
		bk.setBounds(0, 2, 570, 409);
		panel.add(bk);

	}
	
	public void medicamento(int i) {
		
		if(i==1) {
			lblQuais.setVisible(true);
			textPaneobs.setVisible(true);
		}else {
			lblQuais.setVisible(false);
			textPaneobs.setVisible(false);
		}
		
	}
	
	public void checaCampos() {
		
	}
	public void limpaCampos() {
		
	}
}
