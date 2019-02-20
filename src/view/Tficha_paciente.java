package view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;

import control.*;
import dao.DaoConnect;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;

public class Tficha_paciente extends JPanel {
	private int acao;
	Paciente paciente = new Paciente();
	Iniciador iniciar = new Iniciador();
	DaoConnect dao = new DaoConnect();
	private JTextField txnomebuscar;
	private JComboBox situacao;
	private JTextField txnome;
	private JFormattedTextField txcpf;
	private JTextField txmatricula;
	private JFormattedTextField txcontato1;
	private JFormattedTextField txcontato2;
	private JTextField email1;
	private JTextField email2;
	private JTabbedPane tabbedPaneCadastro;
	private JTabbedPane tabbedPaneFicha;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnSim;
	private JRadioButton rdbtnNo;
	private JTextPane textPaneobs;
	private JLabel lblQuais;
	private JComboBox nacionalidade;
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
	private JLabel av24;
	private JLabel av25;
	private JLabel av27;
	private JLabel av28;
	private JLabel av45;
	private JLabel av46;
	private JLabel av47;
	private JLabel av48;
	private JLabel av31;
	private JLabel av32;
	private JLabel av33;
	private JLabel av34;
	private JLabel av35;
	private JLabel av36;
	private JLabel av37;
	private JLabel av38;
	private JLabel salva;
	private JTabbedPane tabbedPaneav;
	private JLabel bkav;
	private JLabel textoav;
	private JCheckBox p1;
	private JCheckBox p2;
	private JCheckBox p3;
	private JCheckBox p4;
	private JTextArea obsClinica;
	private JComboBox estado;
	private JComboBox cidade;
	private JCheckBox dt36;
	private JCheckBox dt37;
	private JCheckBox dt38;
	private JTable tablePaciente;
	private JFormattedTextField dtnascimento;
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
	private JLabel numRegistro;
	private JLabel label_4;
	
	
	  private JTable getTabela(){
	    	if(tablePaciente==null){
	    		tablePaciente = new JTable(tabela);
	    		tablePaciente.addMouseListener(new MouseAdapter() {
	    			public void mouseReased(MouseEvent e){
	    				
	    				int i = tablePaciente.getSelectedRow();
	    				Object x = tablePaciente.getValueAt(i, 1);
	    				String codigo = x+"";
	    			}

	    		});
	    	}
	    	return tablePaciente;

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
			
			tablePaciente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			JTableHeader header = tablePaciente.getTableHeader();
			header.setPreferredSize(new Dimension(2000, 25));
			TableColumnModel modColuna = tablePaciente.getColumnModel();
			
			modColuna.getColumn(0).setPreferredWidth(50);
			modColuna.getColumn(1).setPreferredWidth(150);
			modColuna.getColumn(2).setPreferredWidth(150);
			
			
		}
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
		
		tabbedPaneFicha = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneFicha.setBorder(null);
		tabbedPaneFicha.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneFicha.setBackground(new Color(32, 178, 170));
		tabbedPaneFicha.setBounds(0, 0, 575, 428);
		//add(tabbedPaneFicha);
		
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
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buscar();
			}
		});
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
		
		txnomebuscar = new JTextField();
		txnomebuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
					buscar();
				}
			}
		});
		txnomebuscar.setBounds(52, 8, 145, 20);
		panel.add(txnomebuscar);
		txnomebuscar.setColumns(10);
		
		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o : ");
		lblSituao.setForeground(Color.WHITE);
		lblSituao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSituao.setBounds(10, 39, 89, 14);
		panel.add(lblSituao);
		
		situacao = new JComboBox();
		situacao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		situacao.setModel(new DefaultComboBoxModel(new String[] {"Ativo", "Inativo", "Todos"}));
		situacao.setBounds(73, 36, 145, 20);
		panel.add(situacao);
		
		
		tablePaciente = new JTable();
		tablePaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent click) {
				if(click.getClickCount()==2) {
					acao =0;
					int linha;
					Object codigo;
					linha= tablePaciente.getSelectedRow();
					codigo =  tablePaciente.getValueAt(linha, 0);
					
					paciente.setIdpaciente(Integer.parseInt(codigo.toString()));
					prencheCampos();
				}
			}
		});
		tablePaciente.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo", "Nome", "Contato"
				}
			));
		scroll = new JScrollPane();
		scroll.setBounds(10, 100, 550, 244);
		panel.add(scroll);
		scroll.setViewportView(tablePaciente);
		
		JLabel adcionar = new JLabel("");
		adcionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		adcionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				acao=1;
				limpaCampos();
				tabbedPaneFicha.setVisible(false);
				tabbedPaneCadastro.setVisible(true);
				tabbedPaneCadastro.setEnabledAt( 1, false);
				
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
		
		numRegistro = new JLabel();
		numRegistro.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/confimado.png")));
		numRegistro.setForeground(Color.WHITE);
		numRegistro.setFont(new Font("Tahoma", Font.BOLD, 11));
		numRegistro.setBounds(10, 368, 208, 14);
		panel.add(numRegistro);
		
		JLabel bk = new JLabel("");
		bk.setHorizontalAlignment(SwingConstants.CENTER);
		bk.setIcon(new ImageIcon(Tlivro_consulta.class.getResource("/img/bk.jpeg")));
		bk.setBounds(0, 2, 570, 409);
		panel.add(bk);
		tabbedPaneCadastro.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneCadastro.setBorder(null);
		tabbedPaneCadastro.setBackground(new Color(32, 178, 170));
		tabbedPaneCadastro.setBounds(0, 0, 575, 428);
		add(tabbedPaneCadastro);
		
		JPanel dados = new JPanel();
		dados.setLayout(null);
		dados.setForeground(Color.WHITE);
		dados.setBackground(new Color(32, 178, 170));
		tabbedPaneCadastro.addTab("Ficha Cadastral", null, dados, null);
		tabbedPaneCadastro.setForegroundAt(0, Color.WHITE);
		
		JLabel lblNomePaciente = new JLabel("Nome Paciente : ");
		lblNomePaciente.setForeground(Color.WHITE);
		lblNomePaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomePaciente.setBounds(10, 11, 123, 14);
		dados.add(lblNomePaciente);
		
		JLabel label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(505, 357, 25, 32);
		dados.add(label_2);
		
		txnome = new JTextField();
		txnome.setColumns(10);
		txnome.setBounds(102, 8, 458, 20);
		dados.add(txnome);
		
		JLabel lblCpf = new JLabel("cpf : ");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setBounds(10, 39, 123, 14);
		dados.add(lblCpf);
		
		txcpf = new JFormattedTextField();
		txcpf.setColumns(10);
		txcpf.setBounds(43, 36, 116, 20);
		try {
			txcpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("***.***.***-**")));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dados.add(txcpf);
		
		JLabel label_5 = new JLabel("");
		label_5.setToolTipText("Remover Paciente");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(281, 355, 46, 43);
		dados.add(label_5);
		
		JLabel lblDataNascimento = new JLabel("Data Nascimento : ");
		lblDataNascimento.setForeground(Color.WHITE);
		lblDataNascimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDataNascimento.setBounds(278, 42, 123, 14);
		dados.add(lblDataNascimento);
		
		dtnascimento = new JFormattedTextField();
		dtnascimento.setBounds(387, 39, 123, 20);
		try {
			dtnascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("**/**/****")));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dados.add(dtnascimento);
		dtnascimento.setColumns(10);
		
		JLabel lblCidade = new JLabel("Nascionalidade :");
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCidade.setBounds(10, 79, 123, 14);
		dados.add(lblCidade);
		
		nacionalidade = new JComboBox();
		nacionalidade.setModel(new DefaultComboBoxModel(new String[] {"Brasil"}));
		nacionalidade.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nacionalidade.setBounds(102, 75, 152, 22);
		dados.add(nacionalidade);
		
		JLabel lblEstado = new JLabel("Estado :");
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEstado.setBounds(264, 79, 54, 14);
		dados.add(lblEstado);
		
		estado = new JComboBox();
		estado.setModel(new DefaultComboBoxModel(new String[] {"PB"}));
		estado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		estado.setBounds(312, 75, 54, 22);
		dados.add(estado);
		
		cidade = new JComboBox();
		cidade.setModel(new DefaultComboBoxModel(new String[] {"Campina Grande"}));
		cidade.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cidade.setBounds(424, 75, 136, 22);
		dados.add(cidade);
		
		JLabel lblCidade_1 = new JLabel("Cidade :");
		lblCidade_1.setForeground(Color.WHITE);
		lblCidade_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCidade_1.setBounds(376, 79, 54, 14);
		dados.add(lblCidade_1);
		
		JLabel lblConvenio = new JLabel("Convenio :");
		lblConvenio.setForeground(Color.WHITE);
		lblConvenio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConvenio.setBounds(10, 221, 123, 14);
		dados.add(lblConvenio);
		
		convenios = new JComboBox();
		convenios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		convenios.setModel(new DefaultComboBoxModel(new String[] {"Planos"}));
		convenios.setBounds(77, 217, 235, 22);
		dados.add(convenios);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.setToolTipText("Abrir site");
		lblNewLabel_2.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/play.png")));
		lblNewLabel_2.setBounds(322, 213, 32, 32);
		dados.add(lblNewLabel_2);
		
		JLabel lblCodigoMatricula = new JLabel("Codigo/Matricula : ");
		lblCodigoMatricula.setForeground(Color.WHITE);
		lblCodigoMatricula.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigoMatricula.setBounds(10, 249, 123, 14);
		dados.add(lblCodigoMatricula);
		
		txmatricula = new JTextField();
		txmatricula.setColumns(10);
		txmatricula.setBounds(119, 246, 225, 20);
		dados.add(txmatricula);
		
		JLabel lblPossuiAlergia = new JLabel("Possui Alergia Algum Medicamento ? ");
		lblPossuiAlergia.setForeground(Color.WHITE);
		lblPossuiAlergia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPossuiAlergia.setBounds(14, 277, 377, 14);
		dados.add(lblPossuiAlergia);
		
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
		dados.add(rdbtnSim);
		
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
		dados.add(rdbtnNo);
		
		lblQuais = new JLabel("Quais?");
		lblQuais.setVisible(false);
		lblQuais.setForeground(Color.WHITE);
		lblQuais.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuais.setBounds(10, 316, 377, 14);
		dados.add(lblQuais);
		
		textPaneobs = new JTextPane();
		textPaneobs.setVisible(false);
		textPaneobs.setBounds(10, 340, 317, 49);
		dados.add(textPaneobs);
		
		txcontato1 = new JFormattedTextField();
		txcontato1.setColumns(10);
		txcontato1.setBounds(64, 104, 127, 20);
		try {
			txcontato1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(**)****-****")));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dados.add(txcontato1);
		
		JLabel lblContato = new JLabel("Contato : ");
		lblContato.setForeground(Color.WHITE);
		lblContato.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContato.setBounds(9, 107, 61, 14);
		dados.add(lblContato);
		
		JLabel label = new JLabel("Contato : ");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(9, 135, 61, 14);
		dados.add(label);
		
		txcontato2 = new JFormattedTextField();
		txcontato2.setColumns(10);
		txcontato2.setBounds(64, 132, 127, 20);
		try {
			txcontato2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(**)****-****")));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dados.add(txcontato2);
		
		JLabel lblOp = new JLabel("Op :");
		lblOp.setForeground(Color.WHITE);
		lblOp.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOp.setBounds(202, 106, 32, 14);
		dados.add(lblOp);
		
		op1 = new JComboBox();
		op1.setModel(new DefaultComboBoxModel(new String[] {"Vivo", "Claro", "Oi", "Tim", "Outros"}));
		op1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		op1.setBounds(234, 103, 152, 22);
		dados.add(op1);
		
		w1 = new JCheckBox("WhatsApp");
		w1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		w1.setForeground(Color.WHITE);
		w1.setOpaque(false);
		w1.setBounds(400, 104, 97, 23);
		dados.add(w1);
		
		JLabel label_1 = new JLabel("Op :");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(201, 135, 32, 14);
		dados.add(label_1);
		
		op2 = new JComboBox();
		op2.setModel(new DefaultComboBoxModel(new String[] {"Vivo", "Claro", "Oi", "Tim", "Outros"}));
		op2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		op2.setBounds(234, 131, 152, 22);
		dados.add(op2);
		
		w2 = new JCheckBox("WhatsApp");
		w2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		w2.setOpaque(false);
		w2.setForeground(Color.WHITE);
		w2.setBounds(400, 131, 97, 23);
		dados.add(w2);
		
		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(10, 163, 123, 14);
		dados.add(lblEmail);
		
		email1 = new JTextField();
		email1.setColumns(10);
		email1.setBounds(52, 160, 458, 20);
		dados.add(email1);
		
		email2 = new JTextField();
		email2.setColumns(10);
		email2.setBounds(52, 188, 458, 20);
		dados.add(email2);
		
		JLabel label_3 = new JLabel("Email : ");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(10, 191, 123, 14);
		dados.add(label_3);
		
		JLabel salvar = new JLabel("");
		salvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(acao==1) {salvar();}else {atualiza();}
				
			}
		});
		salvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		salvar.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/savep.png")));
		salvar.setToolTipText("Salvar");
		salvar.setBounds(414, 320, 32, 49);
		dados.add(salvar);
		
		JLabel limpar = new JLabel("");
		limpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		limpar.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/eraser.png")));
		limpar.setToolTipText("Limpar");
		limpar.setBounds(472, 320, 32, 49);
		dados.add(limpar);
		
		JLabel voltar = new JLabel("");
		voltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		voltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabbedPaneFicha.setVisible(true);
				tabbedPaneCadastro.setVisible(false);
			}
		});
		voltar.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/voltar.png")));
		voltar.setToolTipText("Voltar");
		voltar.setBounds(528, 320, 32, 49);
		dados.add(voltar);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/bk.jpeg")));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(0, 2, 570, 409);
		dados.add(label_6);
		
		label_4 = new JLabel("Nascionalidade :");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(387, 277, 123, 14);
		dados.add(label_4);
		
		JPanel avaliacao = new JPanel();
		avaliacao.setEnabled(false);
		avaliacao.setVerifyInputWhenFocusTarget(false);
		avaliacao.setLayout(null);
		tabbedPaneCadastro.addTab("Avaliação Clinica", null, avaliacao, null);
		tabbedPaneCadastro.setForegroundAt(1, Color.WHITE);
		
		tabbedPaneav = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneav.setVisible(false);
		tabbedPaneav.setBounds(94, 0, 394, 378);
		avaliacao.add(tabbedPaneav);
		
		JPanel panel_3 = new JPanel();
		tabbedPaneav.addTab("Avalia\u00E7\u00E3o", null, panel_3, null);
		panel_3.setLayout(null);
		
		textoav = new JLabel("Avalia\u00E7\u00E3o referente ao dente ");
		textoav.setFont(new Font("Tahoma", Font.BOLD, 12));
		textoav.setForeground(Color.WHITE);
		textoav.setHorizontalAlignment(SwingConstants.CENTER);
		textoav.setBounds(6, 11, 373, 14);
		panel_3.add(textoav);
		
		p1 = new JCheckBox("Canal");
		p1.setOpaque(false);
		p1.setForeground(Color.WHITE);
		p1.setFont(new Font("Tahoma", Font.BOLD, 11));
		p1.setFocusable(false);
		p1.setBounds(16, 36, 155, 23);
		panel_3.add(p1);
		
		p2 = new JCheckBox("Restaura\u00E7\u00E3o");
		p2.setOpaque(false);
		p2.setForeground(Color.WHITE);
		p2.setFont(new Font("Tahoma", Font.BOLD, 11));
		p2.setFocusable(false);
		p2.setBounds(16, 62, 155, 23);
		panel_3.add(p2);
		
		p3 = new JCheckBox("Coroa");
		p3.setOpaque(false);
		p3.setForeground(Color.WHITE);
		p3.setFont(new Font("Tahoma", Font.BOLD, 11));
		p3.setFocusable(false);
		p3.setBounds(256, 32, 155, 23);
		panel_3.add(p3);
		
		p4 = new JCheckBox("Extra\u00E7\u00E3o");
		p4.setOpaque(false);
		p4.setForeground(Color.WHITE);
		p4.setFont(new Font("Tahoma", Font.BOLD, 11));
		p4.setFocusable(false);
		p4.setBounds(256, 62, 155, 23);
		panel_3.add(p4);
		
		JLabel lblObservaesClinicas = new JLabel("Observa\u00E7\u00F5es Clinicas");
		lblObservaesClinicas.setHorizontalAlignment(SwingConstants.LEFT);
		lblObservaesClinicas.setForeground(Color.WHITE);
		lblObservaesClinicas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblObservaesClinicas.setBounds(16, 225, 363, 14);
		panel_3.add(lblObservaesClinicas);
		
		obsClinica = new JTextArea();
		obsClinica.setBounds(16, 242, 363, 65);
		panel_3.add(obsClinica);
		
		JLabel btConfirma = new JLabel("");
		btConfirma.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btConfirma.setHorizontalAlignment(SwingConstants.CENTER);
		btConfirma.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/savep.png")));
		btConfirma.setBounds(144, 306, 46, 33);
		panel_3.add(btConfirma);
		
		JLabel btCancela = new JLabel("");
		btCancela.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btCancela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabbedPaneav.setVisible(false);
			}
		});
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
		avaliacao.add(dt18);
		
		dt17 = new JCheckBox("17");
		dt17.setOpaque(false);
		dt17.setForeground(Color.WHITE);
		dt17.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt17.setFocusable(false);
		dt17.setBounds(10, 253, 50, 23);
		avaliacao.add(dt17);
		
		dt16 = new JCheckBox("16");
		dt16.setOpaque(false);
		dt16.setForeground(Color.WHITE);
		dt16.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt16.setFocusable(false);
		dt16.setBounds(10, 222, 50, 23);
		avaliacao.add(dt16);
		
		dt15 = new JCheckBox("15");
		dt15.setOpaque(false);
		dt15.setForeground(Color.WHITE);
		dt15.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt15.setFocusable(false);
		dt15.setBounds(10, 190, 50, 23);
		avaliacao.add(dt15);
		
		dt14 = new JCheckBox("14");
		dt14.setOpaque(false);
		dt14.setForeground(Color.WHITE);
		dt14.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt14.setFocusable(false);
		dt14.setBounds(10, 162, 50, 23);
		avaliacao.add(dt14);
		
		dt13 = new JCheckBox("13");
		dt13.setOpaque(false);
		dt13.setForeground(Color.WHITE);
		dt13.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt13.setFocusable(false);
		dt13.setBounds(10, 132, 50, 23);
		avaliacao.add(dt13);
		
		dt12 = new JCheckBox("12");
		dt12.setOpaque(false);
		dt12.setForeground(Color.WHITE);
		dt12.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt12.setFocusable(false);
		dt12.setBounds(10, 104, 50, 23);
		avaliacao.add(dt12);
		
		dt11 = new JCheckBox("11");
		dt11.setOpaque(false);
		dt11.setForeground(Color.WHITE);
		dt11.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt11.setFocusable(false);
		dt11.setBounds(10, 72, 50, 23);
		avaliacao.add(dt11);
		
		dt21 = new JCheckBox("21");
		dt21.setOpaque(false);
		dt21.setForeground(Color.WHITE);
		dt21.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt21.setFocusable(false);
		dt21.setBounds(154, 72, 50, 23);
		avaliacao.add(dt21);
		
		dt22 = new JCheckBox("22");
		dt22.setOpaque(false);
		dt22.setForeground(Color.WHITE);
		dt22.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt22.setFocusable(false);
		dt22.setBounds(154, 104, 50, 23);
		avaliacao.add(dt22);
		
		dt23 = new JCheckBox("23");
		dt23.setOpaque(false);
		dt23.setForeground(Color.WHITE);
		dt23.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt23.setFocusable(false);
		dt23.setBounds(154, 132, 50, 23);
		avaliacao.add(dt23);
		
		dt24 = new JCheckBox("24");
		dt24.setOpaque(false);
		dt24.setForeground(Color.WHITE);
		dt24.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt24.setFocusable(false);
		dt24.setBounds(154, 162, 50, 23);
		avaliacao.add(dt24);
		
		dt25 = new JCheckBox("25");
		dt25.setOpaque(false);
		dt25.setForeground(Color.WHITE);
		dt25.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt25.setFocusable(false);
		dt25.setBounds(154, 190, 50, 23);
		avaliacao.add(dt25);
		
		dt26 = new JCheckBox("26");
		dt26.setOpaque(false);
		dt26.setForeground(Color.WHITE);
		dt26.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt26.setFocusable(false);
		dt26.setBounds(154, 222, 50, 23);
		avaliacao.add(dt26);
		
		dt27 = new JCheckBox("27");
		dt27.setOpaque(false);
		dt27.setForeground(Color.WHITE);
		dt27.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt27.setFocusable(false);
		dt27.setBounds(154, 253, 50, 23);
		avaliacao.add(dt27);
		
		dt28 = new JCheckBox("28");
		dt28.setOpaque(false);
		dt28.setForeground(Color.WHITE);
		dt28.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt28.setFocusable(false);
		dt28.setBounds(154, 283, 50, 23);
		avaliacao.add(dt28);
		
		dt31 = new JCheckBox("31");
		dt31.setOpaque(false);
		dt31.setForeground(Color.WHITE);
		dt31.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt31.setFocusable(false);
		dt31.setBounds(442, 73, 50, 23);
		avaliacao.add(dt31);
		
		dt32 = new JCheckBox("32");
		dt32.setOpaque(false);
		dt32.setForeground(Color.WHITE);
		dt32.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt32.setFocusable(false);
		dt32.setBounds(442, 104, 50, 23);
		avaliacao.add(dt32);
		
		dt33 = new JCheckBox("33");
		dt33.setOpaque(false);
		dt33.setForeground(Color.WHITE);
		dt33.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt33.setFocusable(false);
		dt33.setBounds(442, 134, 50, 23);
		avaliacao.add(dt33);
		
		dt34 = new JCheckBox("34");
		dt34.setOpaque(false);
		dt34.setForeground(Color.WHITE);
		dt34.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt34.setFocusable(false);
		dt34.setBounds(442, 162, 50, 23);
		avaliacao.add(dt34);
		
		dt35 = new JCheckBox("35");
		dt35.setOpaque(false);
		dt35.setForeground(Color.WHITE);
		dt35.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt35.setFocusable(false);
		dt35.setBounds(442, 190, 50, 23);
		avaliacao.add(dt35);
		
		dt36 = new JCheckBox("36");
		dt36.setOpaque(false);
		dt36.setForeground(Color.WHITE);
		dt36.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt36.setFocusable(false);
		dt36.setBounds(442, 224, 50, 23);
		avaliacao.add(dt36);
		
		dt37 = new JCheckBox("37");
		dt37.setOpaque(false);
		dt37.setForeground(Color.WHITE);
		dt37.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt37.setFocusable(false);
		dt37.setBounds(442, 255, 50, 23);
		avaliacao.add(dt37);
		
		dt38 = new JCheckBox("38");
		dt38.setOpaque(false);
		dt38.setForeground(Color.WHITE);
		dt38.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt38.setFocusable(false);
		dt38.setBounds(442, 281, 50, 23);
		avaliacao.add(dt38);
		
		dt41 = new JCheckBox("41");
		dt41.setOpaque(false);
		dt41.setForeground(Color.WHITE);
		dt41.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt41.setFocusable(false);
		dt41.setBounds(311, 72, 50, 23);
		avaliacao.add(dt41);
		
		dt42 = new JCheckBox("42");
		dt42.setOpaque(false);
		dt42.setForeground(Color.WHITE);
		dt42.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt42.setFocusable(false);
		dt42.setBounds(311, 106, 50, 23);
		avaliacao.add(dt42);
		
		dt43 = new JCheckBox("43");
		dt43.setOpaque(false);
		dt43.setForeground(Color.WHITE);
		dt43.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt43.setFocusable(false);
		dt43.setBounds(311, 134, 50, 23);
		avaliacao.add(dt43);
		
		dt44 = new JCheckBox("44");
		dt44.setOpaque(false);
		dt44.setForeground(Color.WHITE);
		dt44.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt44.setFocusable(false);
		dt44.setBounds(311, 164, 50, 23);
		avaliacao.add(dt44);
		
		dt45 = new JCheckBox("45");
		dt45.setOpaque(false);
		dt45.setForeground(Color.WHITE);
		dt45.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt45.setFocusable(false);
		dt45.setBounds(311, 196, 50, 23);
		avaliacao.add(dt45);
		
		dt46 = new JCheckBox("46");
		dt46.setOpaque(false);
		dt46.setForeground(Color.WHITE);
		dt46.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt46.setFocusable(false);
		dt46.setBounds(311, 222, 50, 23);
		avaliacao.add(dt46);
		
		dt47 = new JCheckBox("47");
		dt47.setOpaque(false);
		dt47.setForeground(Color.WHITE);
		dt47.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt47.setFocusable(false);
		dt47.setBounds(311, 253, 50, 23);
		avaliacao.add(dt47);
		
		dt48 = new JCheckBox("48");
		dt48.setOpaque(false);
		dt48.setForeground(Color.WHITE);
		dt48.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt48.setFocusable(false);
		dt48.setBounds(311, 281, 50, 23);
		avaliacao.add(dt48);
		
		JLabel label_11 = new JLabel("Arco Superior");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_11.setBounds(10, 45, 274, 14);
		avaliacao.add(label_11);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(283, 45, 1, 281);
		avaliacao.add(separator);
		
		JLabel label_12 = new JLabel("Arco Inferior");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_12.setBounds(283, 45, 274, 14);
		avaliacao.add(label_12);
		
		av11 = new JLabel("");
		av11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(11);
			}
		});
		av11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av11.setToolTipText("Avalia");
		av11.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av11.setBounds(66, 70, 31, 25);
		avaliacao.add(av11);
		
		av12 = new JLabel("");
		av12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(12);
				
			}
		});
		av12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av12.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av12.setToolTipText("Avaliar");
		av12.setBounds(66, 102, 31, 25);
		avaliacao.add(av12);
		
		av13 = new JLabel("");
		av13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(13);
			}
		});
		av13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av13.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av13.setToolTipText("Avaliar");
		av13.setBounds(66, 130, 31, 25);
		avaliacao.add(av13);
		
		av14 = new JLabel("");
		av14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(14);
			}
		});
		av14.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av14.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av14.setToolTipText("Avaliar");
		av14.setBounds(66, 162, 31, 25);
		avaliacao.add(av14);
		
		av15 = new JLabel("");
		av15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(15);
			}
		});
		av15.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av15.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av15.setToolTipText("Avaliar");
		av15.setBounds(66, 188, 31, 25);
		avaliacao.add(av15);
		
		av16 = new JLabel("");
		av16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(16);
			}
		});
		av16.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av16.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av16.setToolTipText("Avaliar");
		av16.setBounds(66, 220, 31, 25);
		avaliacao.add(av16);
		
		av17 = new JLabel("");
		av17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(17);
				
			}
		});
		av17.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av17.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av17.setToolTipText("Avaliar");
		av17.setBounds(66, 251, 31, 25);
		avaliacao.add(av17);
		
		av18 = new JLabel("");
		av18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(18);
			}
		});
		av18.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av18.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av18.setToolTipText("Avaliar");
		av18.setBounds(66, 279, 31, 25);
		avaliacao.add(av18);
		
		av21 = new JLabel("");
		av21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(21);
			}
		});
		av21.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av21.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av21.setToolTipText("Avalia");
		av21.setBounds(210, 70, 31, 25);
		avaliacao.add(av21);
		
		av22 = new JLabel("");
		av22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(22);
			}
		});
		av22.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av22.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av22.setToolTipText("Avalia");
		av22.setBounds(210, 104, 31, 25);
		avaliacao.add(av22);
		
		av23 = new JLabel("");
		av23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(23);
			}
		});
		av23.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av23.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av23.setToolTipText("Avalia");
		av23.setBounds(210, 132, 31, 25);
		avaliacao.add(av23);
		
		av24 = new JLabel("");
		av24.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(24);
			}
		});
		av24.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av24.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av24.setToolTipText("Avalia");
		av24.setBounds(210, 162, 31, 25);
		avaliacao.add(av24);
		
		av25 = new JLabel("");
		av25.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(25);
			}
		});
		av25.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av25.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av25.setToolTipText("Avalia");
		av25.setBounds(210, 190, 31, 25);
		avaliacao.add(av25);
		
		JLabel av26 = new JLabel("");
		av26.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(26);
			}
		});
		av26.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av26.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av26.setToolTipText("Avalia");
		av26.setBounds(210, 222, 31, 25);
		avaliacao.add(av26);
		
		av27 = new JLabel("");
		av27.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(27);
			}
		});
		av27.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av27.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av27.setToolTipText("Avalia");
		av27.setBounds(210, 253, 31, 25);
		avaliacao.add(av27);
		
		av28 = new JLabel("");
		av28.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(28);
			}
		});
		av28.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av28.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av28.setToolTipText("Avalia");
		av28.setBounds(210, 281, 31, 25);
		avaliacao.add(av28);
		
		JLabel av41 = new JLabel("");
		av41.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(41);
			}
		});
		av41.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av41.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av41.setToolTipText("Avalia");
		av41.setBounds(367, 70, 31, 25);
		avaliacao.add(av41);
		
		JLabel av42 = new JLabel("");
		av42.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(42);
			}
		});
		av42.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av42.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av42.setToolTipText("Avalia");
		av42.setBounds(367, 104, 31, 25);
		avaliacao.add(av42);
		
		JLabel av43 = new JLabel("");
		av43.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(43);
			}
		});
		av43.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av43.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av43.setToolTipText("Avalia");
		av43.setBounds(367, 132, 31, 25);
		avaliacao.add(av43);
		
		JLabel av44 = new JLabel("");
		av44.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(44);
			}
		});
		av44.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av44.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av44.setToolTipText("Avalia");
		av44.setBounds(367, 162, 31, 25);
		avaliacao.add(av44);
		
		av45 = new JLabel("");
		av45.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(45);
			}
		});
		av45.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av45.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av45.setToolTipText("Avalia");
		av45.setBounds(367, 194, 31, 25);
		avaliacao.add(av45);
		
		av46 = new JLabel("");
		av46.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(46);
			}
		});
		av46.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av46.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av46.setToolTipText("Avalia");
		av46.setBounds(367, 222, 31, 25);
		avaliacao.add(av46);
		
		av47 = new JLabel("");
		av47.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(47);
			}
		});
		av47.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av47.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av47.setToolTipText("Avalia");
		av47.setBounds(367, 253, 31, 25);
		avaliacao.add(av47);
		
		av48 = new JLabel("");
		av48.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(48);
			}
		});
		av48.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av48.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av48.setToolTipText("Avalia");
		av48.setBounds(367, 281, 31, 25);
		avaliacao.add(av48);
		
		av31 = new JLabel("");
		av31.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(31);
			}
		});
		av31.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av31.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av31.setToolTipText("Avalia");
		av31.setBounds(498, 72, 31, 25);
		avaliacao.add(av31);
		
		av32 = new JLabel("");
		av32.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(32);
			}
		});
		av32.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av32.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av32.setToolTipText("Avalia");
		av32.setBounds(498, 104, 31, 25);
		avaliacao.add(av32);
		
		av33 = new JLabel("");
		av33.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(33);
			}
		});
		av33.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av33.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av33.setToolTipText("Avalia");
		av33.setBounds(498, 134, 31, 25);
		avaliacao.add(av33);
		
		av34 = new JLabel("");
		av34.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(34);
			}
		});
		av34.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av34.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av34.setToolTipText("Avalia");
		av34.setBounds(498, 162, 31, 25);
		avaliacao.add(av34);
		
		av35 = new JLabel("");
		av35.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(35);
			}
		});
		av35.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av35.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av35.setToolTipText("Avalia");
		av35.setBounds(498, 190, 31, 25);
		avaliacao.add(av35);
		
		av36 = new JLabel("");
		av36.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(36);
			}
		});
		av36.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av36.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av36.setToolTipText("Avalia");
		av36.setBounds(498, 222, 31, 25);
		avaliacao.add(av36);
		
		av37 = new JLabel("");
		av37.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(37);
			}
		});
		av37.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av37.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av37.setToolTipText("Avalia");
		av37.setBounds(498, 253, 31, 25);
		avaliacao.add(av37);
		
		av38 = new JLabel("");
		av38.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exibiAv(38);
			}
		});
		av38.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		av38.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/avalia\u00E7\u00E3o.png")));
		av38.setToolTipText("Avalia");
		av38.setBounds(498, 281, 31, 25);
		avaliacao.add(av38);
		
		JLabel duvidas = new JLabel("");
		duvidas.setToolTipText("O que fazer ?");
		duvidas.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/document.png")));
		duvidas.setBounds(10, 0, 31, 36);
		avaliacao.add(duvidas);
		
		salva = new JLabel("");
		salva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		salva.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/savep.png")));
		salva.setToolTipText("Salvar");
		salva.setBounds(204, 351, 32, 49);
		avaliacao.add(salva);
		
		JLabel limpa = new JLabel("");
		limpa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		limpa.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/eraser.png")));
		limpa.setToolTipText("Limpar");
		limpa.setBounds(262, 351, 32, 49);
		avaliacao.add(limpa);
		
		JLabel volta = new JLabel("");
		volta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPaneFicha.setVisible(true);
				tabbedPaneCadastro.setVisible(false);
			}
		});
		volta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		volta.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/voltar.png")));
		volta.setToolTipText("Voltar");
		volta.setBounds(318, 351, 32, 49);
		avaliacao.add(volta);
		
		JLabel bkAvc = new JLabel("");
		bkAvc.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/bk.jpeg")));
		bkAvc.setHorizontalAlignment(SwingConstants.CENTER);
		bkAvc.setBounds(0, 0, 570, 409);
		avaliacao.add(bkAvc);

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
	
	public void varreCampos() {
		paciente.setNomepaciente(txnome.getText());
		paciente.setCpf(txcpf.getText());
		//paciente.getData(dtnascimento.getDate())
		paciente.setNascionalidade(nacionalidade.getSelectedItem().toString());
		paciente.setEstado(estado.getSelectedItem().toString());
		paciente.setCidade(cidade.getSelectedItem().toString());
		paciente.setContato1(txcontato1.getText());
		paciente.setOp1(op1.getSelectedItem().toString());
		paciente.setContato2(txcontato2.getText());
		paciente.setOp2(op2.getSelectedItem().toString());
		paciente.setEmail1(email1.getText());
		paciente.setEmail2(email2.getText());
		//paciente.setConvenio(convenio);
		paciente.setObsmedicamento(textPaneobs.getText());
		if(w1.isSelected()==true) {	paciente.setWhats1(1);}else {paciente.setWhats1(0);}
		if(w2.isSelected()==true) {paciente.setWhats2(1);}else {paciente.setWhats2(0);}
		if(rdbtnSim.isSelected()==true) {paciente.setAlegia(1);}else {paciente.setAlegia(0);}
	//-----------------------------------------------------------------------------
		if(dt11.isSelected()==true) {paciente.setDt11(1);}else {paciente.setDt11(0);}
		if(dt12.isSelected()==true) {paciente.setDt12(1);}else {paciente.setDt12(0);}
		if(dt13.isSelected()==true) {paciente.setDt13(1);}else {paciente.setDt13(0);}
		if(dt14.isSelected()==true) {paciente.setDt14(1);}else {paciente.setDt14(0);}
		if(dt15.isSelected()==true) {paciente.setDt15(1);}else {paciente.setDt15(0);}
		if(dt16.isSelected()==true) {paciente.setDt16(1);}else {paciente.setDt16(0);}
		if(dt17.isSelected()==true) {paciente.setDt17(1);}else {paciente.setDt17(0);}
		if(dt18.isSelected()==true) {paciente.setDt18(1);}else {paciente.setDt18(0);}
		if(dt21.isSelected()==true) {paciente.setDt21(1);}else {paciente.setDt21(0);}
		if(dt22.isSelected()==true) {paciente.setDt22(1);}else {paciente.setDt22(0);}
		if(dt23.isSelected()==true) {paciente.setDt23(1);}else {paciente.setDt23(0);}
		if(dt24.isSelected()==true) {paciente.setDt24(1);}else {paciente.setDt24(0);}
		if(dt25.isSelected()==true) {paciente.setDt25(1);}else {paciente.setDt25(0);}
		if(dt26.isSelected()==true) {paciente.setDt26(1);}else {paciente.setDt26(0);}
		if(dt27.isSelected()==true) {paciente.setDt27(1);}else {paciente.setDt27(0);}
		if(dt28.isSelected()==true) {paciente.setDt28(1);}else {paciente.setDt28(0);}
		if(dt31.isSelected()==true) {paciente.setDt31(1);}else {paciente.setDt31(0);}
		if(dt32.isSelected()==true) {paciente.setDt32(1);}else {paciente.setDt32(0);}
		if(dt33.isSelected()==true) {paciente.setDt33(1);}else {paciente.setDt33(0);}
		if(dt34.isSelected()==true) {paciente.setDt34(1);}else {paciente.setDt34(0);}
		if(dt35.isSelected()==true) {paciente.setDt35(1);}else {paciente.setDt35(0);}
		if(dt36.isSelected()==true) {paciente.setDt36(1);}else {paciente.setDt36(0);}
		if(dt37.isSelected()==true) {paciente.setDt37(1);}else {paciente.setDt37(0);}
		if(dt38.isSelected()==true) {paciente.setDt38(1);}else {paciente.setDt38(0);}
		if(dt41.isSelected()==true) {paciente.setDt41(1);}else {paciente.setDt41(0);}
		if(dt42.isSelected()==true) {paciente.setDt42(1);}else {paciente.setDt42(0);}
		if(dt43.isSelected()==true) {paciente.setDt43(1);}else {paciente.setDt43(0);}
		if(dt44.isSelected()==true) {paciente.setDt44(1);}else {paciente.setDt44(0);}
		if(dt45.isSelected()==true) {paciente.setDt45(1);}else {paciente.setDt45(0);}
		if(dt46.isSelected()==true) {paciente.setDt46(1);}else {paciente.setDt46(0);}
		if(dt47.isSelected()==true) {paciente.setDt47(1);}else {paciente.setDt47(0);}
		if(dt48.isSelected()==true) {paciente.setDt48(1);}else {paciente.setDt48(0);}
		
	//-------------------------------------------------------------------------------
		
		
		
	}
	
	public void limpaCampos() {
		txnome.setText("");
		txcpf.setText("");
		dtnascimento.setText("");
		txcontato1.setText("");
		op1.setSelectedIndex(0);
		w1.setSelected(false);
		txcontato2.setText("");
		op2.setSelectedIndex(1);
		w2.setSelected(false);
		email1.setText("");
		email2.setText("");
		convenios.setSelectedIndex(0);
		txmatricula.setText("");
		rdbtnSim.setSelected(false);
		rdbtnNo.setSelected(false);
		textPaneobs.setText("");
		dt11.setSelected(false);
		dt12.setSelected(false);
		dt13.setSelected(false);
		dt14.setSelected(false);
		dt15.setSelected(false);
		dt16.setSelected(false);
		dt17.setSelected(false);
		dt18.setSelected(false);
		dt21.setSelected(false);
		dt22.setSelected(false);
		dt23.setSelected(false);
		dt24.setSelected(false);
		dt25.setSelected(false);
		dt26.setSelected(false);
		dt27.setSelected(false);
		dt28.setSelected(false);
		dt31.setSelected(false);
		dt32.setSelected(false);
		dt33.setSelected(false);
		dt34.setSelected(false);
		dt35.setSelected(false);
		dt36.setSelected(false);
		dt37.setSelected(false);
		dt38.setSelected(false);
		dt41.setSelected(false);
		dt42.setSelected(false);
		dt43.setSelected(false);
		dt44.setSelected(false);
		dt45.setSelected(false);
		dt46.setSelected(false);
		dt47.setSelected(false);
		dt48.setSelected(false);
		limpaav();
	}
	
	public void prencheCampos() {
		
		try {
			iniciar.LeituraIp();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		dao.conectar(iniciar.getIp_server());
		dao.dadosPaciente(paciente);
		txnome.setText(paciente.getNomepaciente());
		txcpf.setText(paciente.getCpf());
		//dtnascimento.setText(paciente.getData());
		txmatricula.setText(paciente.getMatricula());
		textPaneobs.setText(paciente.getObsmedicamento());
		txcontato1.setText(paciente.getContato1());
		txcontato2.setText(paciente.getContato2());
		email1.setText(paciente.getEmail1());
		email2.setText(paciente.getEmail2());
		
		
		if(paciente.getWhats1()==1) {
			w1.setSelected(true);
		}else {
			w1.setSelected(false);
		}
		
		if(paciente.getWhats2()==1) {
			w2.setSelected(true);
		}else {
			w2.setSelected(false);
		}
//--------------------------------------------------------------------------------------------------------
		if(paciente.getDt11()==1) {dt11.setSelected(true);}else {dt11.setSelected(false);}
		if(paciente.getDt12()==1) {dt12.setSelected(true);}else {dt12.setSelected(false);}
		if(paciente.getDt13()==1) {dt13.setSelected(true);}else {dt13.setSelected(false);}
		if(paciente.getDt14()==1) {dt14.setSelected(true);}else {dt14.setSelected(false);}
		if(paciente.getDt15()==1) {dt15.setSelected(true);}else {dt15.setSelected(false);}
		if(paciente.getDt16()==1) {dt16.setSelected(true);}else {dt16.setSelected(false);}
		if(paciente.getDt17()==1) {dt17.setSelected(true);}else {dt17.setSelected(false);}
		if(paciente.getDt18()==1) {dt18.setSelected(true);}else {dt18.setSelected(false);}
		
		if(paciente.getDt21()==1) {dt21.setSelected(true);}else {dt21.setSelected(false);}
		if(paciente.getDt22()==1) {dt22.setSelected(true);}else {dt22.setSelected(false);}
		if(paciente.getDt23()==1) {dt23.setSelected(true);}else {dt23.setSelected(false);}
		if(paciente.getDt24()==1) {dt24.setSelected(true);}else {dt24.setSelected(false);}
		if(paciente.getDt25()==1) {dt25.setSelected(true);}else {dt25.setSelected(false);}
		if(paciente.getDt26()==1) {dt26.setSelected(true);}else {dt26.setSelected(false);}
		if(paciente.getDt27()==1) {dt27.setSelected(true);}else {dt27.setSelected(false);}
		if(paciente.getDt28()==1) {dt28.setSelected(true);}else {dt28.setSelected(false);}
		
		if(paciente.getDt31()==1) {dt31.setSelected(true);}else {dt31.setSelected(false);}
		if(paciente.getDt32()==1) {dt32.setSelected(true);}else {dt32.setSelected(false);}
		if(paciente.getDt33()==1) {dt33.setSelected(true);}else {dt33.setSelected(false);}
		if(paciente.getDt34()==1) {dt34.setSelected(true);}else {dt34.setSelected(false);}
		if(paciente.getDt35()==1) {dt35.setSelected(true);}else {dt35.setSelected(false);}
		if(paciente.getDt36()==1) {dt36.setSelected(true);}else {dt36.setSelected(false);}
		if(paciente.getDt37()==1) {dt37.setSelected(true);}else {dt37.setSelected(false);}
		if(paciente.getDt38()==1) {dt38.setSelected(true);}else {dt38.setSelected(false);}
		
		if(paciente.getDt41()==1) {dt41.setSelected(true);}else {dt41.setSelected(false);}
		if(paciente.getDt42()==1) {dt42.setSelected(true);}else {dt42.setSelected(false);}
		if(paciente.getDt43()==1) {dt43.setSelected(true);}else {dt43.setSelected(false);}
		if(paciente.getDt44()==1) {dt44.setSelected(true);}else {dt44.setSelected(false);}
		if(paciente.getDt45()==1) {dt45.setSelected(true);}else {dt45.setSelected(false);}
		if(paciente.getDt46()==1) {dt46.setSelected(true);}else {dt46.setSelected(false);}
		if(paciente.getDt47()==1) {dt47.setSelected(true);}else {dt47.setSelected(false);}
		if(paciente.getDt48()==1) {dt48.setSelected(true);}else {dt48.setSelected(false);}
		
		tabbedPaneFicha.setVisible(false);
		tabbedPaneCadastro.setVisible(true);
	}
	
	public void limpaav() {
		textoav.setText("");
		p1.setSelected(false);
		p2.setSelected(false);
		p3.setSelected(false);
		p4.setSelected(false);
		obsClinica.setText("");
	}
	
	public void exibiAv(int i) {
		textoav.setText("Avaliação referente ao dente "+i);
		tabbedPaneav.setVisible(true);
	}
	
	public void buscar() {
		paciente.setNomepaciente(txnomebuscar.getText());
		if(situacao.getSelectedItem()=="Ativo") {
			paciente.setSit(1);
		}else if(situacao.getSelectedItem()=="Inativo"){
			paciente.setSit(0);
		}else {
			paciente.setSit(3);
		}
		
		try {
			iniciar.LeituraIp();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dao.conectar(iniciar.getIp_server());
		
		dao.listaPaciente(tablePaciente, paciente);
		if(paciente.getNumeroregistro()==1) {
			numRegistro.setText(paciente.getNumeroregistro()+" registro encontrado");
		}else {
			numRegistro.setText(paciente.getNumeroregistro()+" registros encontrados");
		}
		
	}
	
	public void salvar() {
		varreCampos();
		try {
			iniciar.LeituraIp();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		dao.conectar(iniciar.getIp_server());
		dao.inserirPaciente(paciente);
		dao.fecharCon();
		limpaCampos();
		buscar();
		tabbedPaneCadastro.setVisible(false);
		tabbedPaneFicha.setVisible(true);
	}
	
	public void atualiza() {
		varreCampos();
		try {
			iniciar.LeituraIp();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		dao.conectar(iniciar.getIp_server());
		dao.alteraPaciente(paciente);
		dao.fecharCon();
		limpaCampos();
		buscar();
		tabbedPaneCadastro.setVisible(false);
		tabbedPaneFicha.setVisible(true);
	}
}
