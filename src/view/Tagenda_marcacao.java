package view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;

import control.Iniciador;
import control.Paciente;
import control.Usuario;
import dao.DaoConnect;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
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
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import java.awt.Cursor;
import java.awt.Dimension;

public class Tagenda_marcacao extends JPanel {
	
	Paciente paciente = new Paciente();
	Usuario usuario  = new Usuario();
	Iniciador iniciar = new Iniciador();
	DaoConnect dao = new DaoConnect();
	private JComboBox textField_1;
	private JTable table;
	private int totalregistro;
	private JTextField txnomepaciente;
	private JTable tablePaciente;
	private JTabbedPane tabbedPaneagendamento;
	private JTabbedPane tabbedPaneAgenda;
	private JTextField textField_2;
	private JScrollPane scrollPane2;
	String[] coluna2  = {"Matricula", "Nome", "Função"};
	String [][] linhas2 = {};
	private DefaultTableModel tabela = new DefaultTableModel(linhas2, coluna2){
		public boolean isCellEditable(int linhas, int coluna) {
			
			if(coluna==1){
				return true;
			}else{
				return false;
			}
			
		}
	};
	private JLabel dadoNomePaciente;
	
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
			if (scrollPane2==null){
				scrollPane2= new JScrollPane();
				scrollPane2.setBackground(SystemColor.text);
				scrollPane2.setViewportView(getTabela());
				scrollPane2.setBounds(56,166,225,256);
				defineRenderers();
			}
			
			
			
			return scrollPane2;
			
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
	public Tagenda_marcacao() {
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
		
		tabbedPaneAgenda = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneAgenda.setBorder(null);
		tabbedPaneAgenda.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneAgenda.setBackground(new Color(32, 178, 170));
		tabbedPaneAgenda.setBounds(0, 0, 575, 428);
	//	add(tabbedPaneAgenda);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setForeground(Color.WHITE);
		tabbedPaneAgenda.addTab("Agenda de Marca\u00E7\u00E3o", new ImageIcon(Tagenda_marcacao.class.getResource("/img/agenda de marcacao pequeno.png")), panel, null);
		tabbedPaneAgenda.setBackgroundAt(0, new Color(32, 178, 170));
		tabbedPaneAgenda.setForegroundAt(0, Color.WHITE);
		panel.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(67, 8, 170, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPaciente = new JLabel("Paciente :");
		lblPaciente.setForeground(Color.WHITE);
		lblPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPaciente.setBounds(10, 14, 68, 14);
		panel.add(lblPaciente);
		
		JLabel lblData = new JLabel("Data : ");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblData.setForeground(Color.WHITE);
		lblData.setBounds(10, 51, 46, 14);
		panel.add(lblData);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooser.setBounds(47, 45, 154, 20);
		panel.add(dateChooser);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setToolTipText("Buscar");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setIcon(new ImageIcon(Tlivro_consulta.class.getResource("/img/buscar.png")));
		lblNewLabel.setBounds(483, 33, 39, 32);
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
		lblNewLabel_1.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/voltar.png")));
		lblNewLabel_1.setBounds(535, 2, 25, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblSituao = new JLabel("Situa\u00E7\u00E3o : ");
		lblSituao.setForeground(Color.WHITE);
		lblSituao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSituao.setBounds(221, 48, 89, 14);
		panel.add(lblSituao);
		
		textField_1 = new JComboBox();
		textField_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		textField_1.setForeground(Color.BLACK);
		textField_1.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Confirmado", "Confirma\u00E7\u00E3o Pedente"}));
		textField_1.setBounds(284, 45, 189, 20);
		panel.add(textField_1);
		
		JLabel lblProcedimento_2 = new JLabel("Procedimento : ");
		lblProcedimento_2.setForeground(Color.WHITE);
		lblProcedimento_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProcedimento_2.setBounds(268, 11, 89, 14);
		panel.add(lblProcedimento_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Clinico", "Estetico"}));
		comboBox_1.setForeground(Color.BLACK);
		comboBox_1.setBounds(356, 8, 145, 20);
		panel.add(comboBox_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 550, 279);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Nome", "Telefone", "Procedimento", "Situa\u00E7\u00E3o"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel btAdd = new JLabel("");
		btAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPaneAgenda.setVisible(false);
				tabbedPaneagendamento.setVisible(true);
			}
		});
		btAdd.setToolTipText("Nova Marca\u00E7\u00E3o");
		btAdd.setHorizontalAlignment(SwingConstants.CENTER);
		btAdd.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/add.png")));
		btAdd.setBounds(221, 355, 46, 43);
		panel.add(btAdd);
		
		JLabel btDeleta = new JLabel("");
		btDeleta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btDeleta.setToolTipText("Remover Paciente");
		btDeleta.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/deleta.png")));
		btDeleta.setHorizontalAlignment(SwingConstants.CENTER);
		btDeleta.setBounds(281, 355, 46, 43);
		panel.add(btDeleta);
		
		JLabel label = new JLabel(totalregistro+" registros encontrados");
		label.setIcon(new ImageIcon(Tagenda_marcacao.class.getResource("/img/confimado.png")));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 368, 208, 14);
		panel.add(label);
		
		JLabel btImprimir = new JLabel("");
		btImprimir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btImprimir.setIcon(new ImageIcon(Tagenda_marcacao.class.getResource("/img/imprimir.png")));
		btImprimir.setToolTipText("Imprimir");
		btImprimir.setHorizontalAlignment(SwingConstants.CENTER);
		btImprimir.setBounds(514, 355, 46, 43);
		panel.add(btImprimir);
		
		JLabel bk = new JLabel("");
		bk.setToolTipText("");
		bk.setHorizontalAlignment(SwingConstants.CENTER);
		bk.setIcon(new ImageIcon(Tlivro_consulta.class.getResource("/img/bk.jpeg")));
		bk.setBounds(0, 2, 570, 409);
		panel.add(bk);
		
		tabbedPaneagendamento = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneagendamento.setBounds(0, 0, 575, 428);
		add(tabbedPaneagendamento);
		
		JPanel panel_1 = new JPanel();
		tabbedPaneagendamento.addTab("Agendamento", null, panel_1, null);
		tabbedPaneagendamento.setForegroundAt(0, Color.WHITE);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Buscar Paciente :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(10, 11, 111, 14);
		panel_1.add(lblNewLabel_2);
		
		txnomepaciente = new JTextField();
		txnomepaciente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
		});
		txnomepaciente.setBounds(113, 8, 141, 20);
		panel_1.add(txnomepaciente);
		txnomepaciente.setColumns(10);
		
		JLabel buscar = new JLabel("");
		buscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buscarPaciente();
			}
		});
		buscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buscar.setToolTipText("Buscar");
		buscar.setIcon(new ImageIcon(Tagenda_marcacao.class.getResource("/img/buscar.png")));
		buscar.setBounds(264, 0, 46, 35);
		panel_1.add(buscar);
		
		
		
		scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(10, 39, 550, 168);
		panel_1.add(scrollPane2);
		
		tablePaciente = new JTable();
		tablePaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent click) {
				
				if(click.getClickCount()==2) {
					int linha;
					Object codigo,nome;
					linha= tablePaciente.getSelectedRow();
					codigo =  tablePaciente.getValueAt(linha, 0);
					nome =tablePaciente.getValueAt(linha, 1);
					paciente.setIdpaciente(Integer.parseInt(codigo.toString()));
					dadoNomePaciente.setText("Paciente nome: "+nome);
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
		scrollPane2.setViewportView(tablePaciente);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooser_1.setBounds(321, 218, 154, 20);
		panel_1.add(dateChooser_1);
		
		JLabel lblProcedimento = new JLabel("Procedimento :");
		lblProcedimento.setForeground(Color.WHITE);
		lblProcedimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProcedimento.setBounds(20, 224, 111, 14);
		panel_1.add(lblProcedimento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ambos", "Clinico", "Estetico"}));
		comboBox.setBounds(113, 218, 141, 20);
		panel_1.add(comboBox);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 249, 550, 2);
		panel_1.add(separator);
		
		dadoNomePaciente = new JLabel("Paciente nome:");
		dadoNomePaciente.setForeground(Color.WHITE);
		dadoNomePaciente.setIcon(new ImageIcon("C:\\Users\\SED\\Downloads\\user.png"));
		dadoNomePaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		dadoNomePaciente.setBounds(20, 272, 540, 14);
		panel_1.add(dadoNomePaciente);
		
		JLabel lblProcedimento_1 = new JLabel("Procedimento :");
		lblProcedimento_1.setForeground(Color.WHITE);
		lblProcedimento_1.setIcon(new ImageIcon("C:\\Users\\SED\\Downloads\\tooth.png"));
		lblProcedimento_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProcedimento_1.setBounds(20, 307, 243, 14);
		panel_1.add(lblProcedimento_1);
		
		JLabel lblData_1 = new JLabel("Data :");
		lblData_1.setIcon(new ImageIcon(Tagenda_marcacao.class.getResource("/img/agenda de marcacao pequeno.png")));
		lblData_1.setForeground(Color.WHITE);
		lblData_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblData_1.setBounds(280, 307, 280, 14);
		panel_1.add(lblData_1);
		
		JLabel btSalva = new JLabel("");
		btSalva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btSalva.setIcon(new ImageIcon(Tagenda_marcacao.class.getResource("/img/savep.png")));
		btSalva.setToolTipText("Salva");
		btSalva.setBounds(224, 365, 30, 35);
		panel_1.add(btSalva);
		
		JLabel btVoltar = new JLabel("");
		btVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabbedPaneagendamento.setVisible(false);
				tabbedPaneAgenda.setVisible(true);
			}
		});
		btVoltar.setIcon(new ImageIcon(Tagenda_marcacao.class.getResource("/img/voltar.png")));
		btVoltar.setToolTipText("Voltar");
		btVoltar.setBounds(280, 365, 30, 35);
		panel_1.add(btVoltar);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Confirmar Consulta");
		chckbxNewCheckBox.setForeground(Color.WHITE);
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxNewCheckBox.setOpaque(false);
		chckbxNewCheckBox.setBounds(195, 335, 180, 23);
		panel_1.add(chckbxNewCheckBox);
		
		JLabel bkagenda = new JLabel("");
		bkagenda.setIcon(new ImageIcon(Tagenda_marcacao.class.getResource("/img/bk.jpeg")));
		bkagenda.setHorizontalAlignment(SwingConstants.CENTER);
		bkagenda.setBounds(0, 0, 570, 409);
		panel_1.add(bkagenda);

	}
	
	public void varreCamposPaciente() {
		
	}
	
	public void buscarPaciente() {
		paciente.setNomepaciente(txnomepaciente.getText());
			paciente.setSit(1);
		
		leitura();
		
		dao.listaPaciente(tablePaciente, paciente);
	
	}
	public void leitura() {
		try {
			iniciar.LeituraIp();
			iniciar.leituraUsuarioLogado();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		dao.conectar(iniciar.getIp_server());
		usuario.setUsuarioLogado(iniciar.getUsuarioLogado());
	}
}
