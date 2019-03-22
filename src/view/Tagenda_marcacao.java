package view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;

import control.Agenda;
import control.Iniciador;
import control.Paciente;
import control.Usuario;
import dao.DaoConnect;
import viewTavisos.Taviso;
import viewTavisos.TavisoAgenda;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuItem;

public class Tagenda_marcacao extends JPanel {
	
	Paciente paciente = new Paciente();
	Usuario usuario  = new Usuario();
	Iniciador iniciar = new Iniciador();
	DaoConnect dao = new DaoConnect();
	Agenda agenda = new Agenda();
	Taviso aviso = new Taviso();
	TavisoAgenda confima = new TavisoAgenda();
	int acao;
	private JComboBox situacao;
	private JTable tableAgendas;
	private int totalregistro;
	private JTextField txnomepaciente;
	private JTable tablePaciente;
	private JTabbedPane tabbedPaneagendamento;
	private JTabbedPane tabbedPaneAgenda;
	private JTextField txbuscar;
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
	private JComboBox procedimento;
	private JDateChooser data;
	private JLabel pro;
	private JLabel dt;
	private JScrollPane scrollPane;
	private JCheckBox sit;
	private JDateChooser dtConsulta;
	private JComboBox procedimentoPaciente;
	private JLabel buscar;
	private JLabel rg;
	
	 private JTable getTabela1(){
	    	if(tableAgendas==null){
	    		tableAgendas = new JTable(tabela);
	    		tableAgendas.addMouseListener(new MouseAdapter() {
	    			public void mouseReased(MouseEvent e){
	    				
	    				int i = tableAgendas.getSelectedRow();
	    				Object x = tableAgendas.getValueAt(i, 1);
	    				String codigo = x+"";
	    			}

	    		});
	    	}
	    	return tableAgendas;

	    }
	
	 private JTable getTabela2(){
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

	    

		private JScrollPane getScroll1(){
			if (scrollPane==null){
				scrollPane= new JScrollPane();
				scrollPane.setBackground(SystemColor.text);
				scrollPane.setViewportView(getTabela2());
				scrollPane.setBounds(56,166,225,256);
				defineRenderers2();
			}
			
			return scrollPane;
			
		}
	    
		private JScrollPane getScroll2(){
			if (scrollPane2==null){
				scrollPane2= new JScrollPane();
				scrollPane2.setBackground(SystemColor.text);
				scrollPane2.setViewportView(getTabela2());
				scrollPane2.setBounds(56,166,225,256);
				defineRenderers2();
			}
			
			return scrollPane2;
			
		}

		private void defineRenderers() {

			tableAgendas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			JTableHeader header = tableAgendas.getTableHeader();
			header.setPreferredSize(new Dimension(2000, 25));
			TableColumnModel modColuna = tableAgendas.getColumnModel();

			modColuna.getColumn(0).setPreferredWidth(50);
			modColuna.getColumn(1).setPreferredWidth(150);
			modColuna.getColumn(2).setPreferredWidth(150);


		}
		
		private void defineRenderers2() {
			
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
		add(tabbedPaneAgenda);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setForeground(Color.WHITE);
		tabbedPaneAgenda.addTab("Agenda de Marca\u00E7\u00E3o", new ImageIcon(Tagenda_marcacao.class.getResource("/img/agenda de marcacao pequeno.png")), panel, null);
		tabbedPaneAgenda.setBackgroundAt(0, new Color(32, 178, 170));
		tabbedPaneAgenda.setForegroundAt(0, Color.WHITE);
		panel.setLayout(null);
		
		txbuscar = new JTextField();
		txbuscar.setBounds(67, 8, 170, 20);
		panel.add(txbuscar);
		txbuscar.setColumns(10);
		
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
		
		dtConsulta = new JDateChooser();
		dtConsulta.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {

				if(dtConsulta.getDate()==null) {

				}else {
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //DEFINE FORMATO DE DATA  
				    String date = formato.format(dtConsulta.getDate());
					agenda.setData(date);
				}
			}
		});
		dtConsulta.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dtConsulta.setBounds(47, 45, 154, 20);
		panel.add(dtConsulta);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarAgendamentos();
				
			}
		});
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
		
		situacao = new JComboBox();
		situacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agenda.setSituacao(situacao.getSelectedIndex());
			}
		});
		situacao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		situacao.setForeground(Color.BLACK);
		situacao.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Confirmado", "Confirma\u00E7\u00E3o Pedente"}));
		situacao.setBounds(284, 45, 189, 20);
		panel.add(situacao);
		
		JLabel lblProcedimento_2 = new JLabel("Procedimento : ");
		lblProcedimento_2.setForeground(Color.WHITE);
		lblProcedimento_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProcedimento_2.setBounds(268, 11, 89, 14);
		panel.add(lblProcedimento_2);
		
		procedimentoPaciente = new JComboBox();
		procedimentoPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agenda.setVlProcedimento(procedimentoPaciente.getSelectedIndex());
			}
		});
		procedimentoPaciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		procedimentoPaciente.setModel(new DefaultComboBoxModel(new String[] {"Ambos", "Clinico", "Estetico", "Todos"}));
		procedimentoPaciente.setForeground(Color.BLACK);
		procedimentoPaciente.setBounds(356, 8, 145, 20);
		panel.add(procedimentoPaciente);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 550, 279);
		panel.add(scrollPane);
		
		tableAgendas = new JTable();
		tableAgendas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent click) {
				
				if(click.getClickCount()==2) {
					int linha;
					Object codigo;
					linha= tableAgendas.getSelectedRow();
					codigo =  tableAgendas.getValueAt(linha, 0);
					agenda.setIdAgenda(Integer.parseInt(codigo.toString()));
					prencheCampos();
					acao=0;
				}
				
			}
		});
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(scrollPane, popupMenu);
		
		JMenuItem mntmNovoAgendamento = new JMenuItem("Nova Consulta");
		mntmNovoAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checaPrivilegio();
			}
		});
		popupMenu.add(mntmNovoAgendamento);
		
		JSeparator separator_1 = new JSeparator();
		popupMenu.add(separator_1);
		
		JMenuItem mntmEditarConsulta = new JMenuItem("Editar Consulta");
		mntmEditarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha;
				Object codigo;
				linha= tableAgendas.getSelectedRow();
				if(linha<=0) {
					aviso.texto.setText("Nenhum Consulta Selecionada.");
					aviso.setLocationRelativeTo(null);
					aviso.show();
					
				}else {
					codigo =  tableAgendas.getValueAt(linha, 0);
					agenda.setIdAgenda(Integer.parseInt(codigo.toString()));
					prencheCampos();
					acao=0;
				}
				
			}
		});
		popupMenu.add(mntmEditarConsulta);
		
		JSeparator separator_4 = new JSeparator();
		popupMenu.add(separator_4);
		
		JMenuItem mntmConfirmaConsulta = new JMenuItem("Confirma Consulta");
		mntmConfirmaConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha;
				Object codigo;
				linha= tableAgendas.getSelectedRow();
				if(linha<0) {
					aviso.texto.setText("Nenhum Consulta Selecionada.");
					aviso.setLocationRelativeTo(null);
					aviso.show();
					
				}else {
					codigo =  tableAgendas.getValueAt(linha, 0);
					agenda.setIdAgenda(Integer.parseInt(codigo.toString()));
					atualizaConsulta(1);
				}
				
			}
		});
		popupMenu.add(mntmConfirmaConsulta);
		
		JSeparator separator_2 = new JSeparator();
		popupMenu.add(separator_2);
		
		JMenuItem mntmReagendar = new JMenuItem("Reagendar Consulta");
		mntmReagendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha;
				Object codigo;
				linha= tableAgendas.getSelectedRow();
				if(linha<0) {
					aviso.texto.setText("Nenhum Consulta Selecionada.");
					aviso.setLocationRelativeTo(null);
					aviso.show();
					
				}else {
					codigo =  tableAgendas.getValueAt(linha, 0);
					agenda.setIdAgenda(Integer.parseInt(codigo.toString()));
					atualizaConsulta(0);
				}
			}
		});
		popupMenu.add(mntmReagendar);
		
		JSeparator separator_3 = new JSeparator();
		popupMenu.add(separator_3);
		
		JMenuItem mntmDeletar = new JMenuItem("Deletar");
		mntmDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linha;
				Object codigo;
				linha= tableAgendas.getSelectedRow();
				if(linha<0) {
					aviso.texto.setText("Nenhum Consulta Selecionada.");
					aviso.setLocationRelativeTo(null);
					aviso.show();
					
				}else {
					
					codigo =  tableAgendas.getValueAt(linha, 0);
					agenda.setIdAgenda(Integer.parseInt(codigo.toString()));
				
					confima.setLocationRelativeTo(null);
					confima.show();
					
				}
			}
		});
		popupMenu.add(mntmDeletar);
		tableAgendas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo Agendamento","Nome", "Telefone", "Procedimento"
			}
		));
		scrollPane.setViewportView(tableAgendas);
		
		JLabel btAdd = new JLabel("");
		btAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				checaPrivilegio();
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
		
		rg = new JLabel();
		rg.setIcon(new ImageIcon(Tagenda_marcacao.class.getResource("/img/confimado.png")));
		rg.setForeground(Color.WHITE);
		rg.setFont(new Font("Tahoma", Font.BOLD, 11));
		rg.setBounds(10, 368, 208, 14);
		panel.add(rg);
		
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
		tabbedPaneagendamento.setVisible(false);
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
		
		buscar = new JLabel("");
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
					agenda.setIdPaciente(Integer.parseInt(codigo.toString()));
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
		
		data = new JDateChooser();
		data.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
				if(data.getDate()==null) {
					dt.setText("Data : ");
				}else {
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //DEFINE FORMATO DE DATA  
				    String date = formato.format(data.getDate());
					dt.setText("Data : "+date);
					agenda.setData(date);
				}
				
				
			}
		});
		data.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		data.setBounds(321, 218, 154, 20);
		panel_1.add(data);
		
		JLabel lblProcedimento = new JLabel("Procedimento :");
		lblProcedimento.setForeground(Color.WHITE);
		lblProcedimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProcedimento.setBounds(20, 224, 111, 14);
		panel_1.add(lblProcedimento);
		procedimento = new JComboBox();
		procedimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					pro.setText("Procedimento : "+procedimento.getSelectedItem());
					agenda.setProcedimento(procedimento.getSelectedItem().toString());
					agenda.setVlProcedimento(procedimento.getSelectedIndex());
					
			}
		});
		procedimento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		procedimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		procedimento.setModel(new DefaultComboBoxModel(new String[] {"Ambos", "Clinico", "Estetico"}));
		procedimento.setBounds(113, 218, 141, 20);
		panel_1.add(procedimento);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 249, 550, 2);
		panel_1.add(separator);
		
		dadoNomePaciente = new JLabel("Paciente nome:");
		dadoNomePaciente.setForeground(Color.WHITE);
		dadoNomePaciente.setIcon(new ImageIcon("C:\\Users\\SED\\Downloads\\user.png"));
		dadoNomePaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		dadoNomePaciente.setBounds(20, 272, 540, 14);
		panel_1.add(dadoNomePaciente);
		
		pro = new JLabel("Procedimento :");
		pro.setForeground(Color.WHITE);
		pro.setIcon(new ImageIcon("C:\\Users\\SED\\Downloads\\tooth.png"));
		pro.setFont(new Font("Tahoma", Font.BOLD, 11));
		pro.setBounds(20, 307, 243, 14);
		panel_1.add(pro);
		
		dt = new JLabel("Data :");
		dt.setIcon(new ImageIcon(Tagenda_marcacao.class.getResource("/img/agenda de marcacao pequeno.png")));
		dt.setForeground(Color.WHITE);
		dt.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt.setBounds(280, 307, 280, 14);
		panel_1.add(dt);
		
		JLabel btSalva = new JLabel("");
		btSalva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(acao==1) {
					salvar();
				}else {
					atualizar();
				}
				limpaCampos();
			}
		});
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
				limpaCampos();
			}
		});
		btVoltar.setIcon(new ImageIcon(Tagenda_marcacao.class.getResource("/img/voltar.png")));
		btVoltar.setToolTipText("Voltar");
		btVoltar.setBounds(280, 365, 30, 35);
		panel_1.add(btVoltar);
		
		sit = new JCheckBox("Confirmar Consulta");
		sit.setForeground(Color.WHITE);
		sit.setFont(new Font("Tahoma", Font.BOLD, 11));
		sit.setOpaque(false);
		sit.setBounds(195, 335, 180, 23);
		panel_1.add(sit);
		
		JLabel bkagenda = new JLabel("");
		bkagenda.setIcon(new ImageIcon(Tagenda_marcacao.class.getResource("/img/bk.jpeg")));
		bkagenda.setHorizontalAlignment(SwingConstants.CENTER);
		bkagenda.setBounds(0, 0, 570, 409);
		panel_1.add(bkagenda);

	}
	
	public void dataDia() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //DEFINE FORMATO DE DATA  
		Date date = new Date();
	    dtConsulta.setDate(date);
	    procedimentoPaciente.setSelectedIndex(3);
	    situacao.setSelectedIndex(1);
	    buscarAgendamentos();
	}
	
	public void varreCampos() {
		paciente.setNomepaciente(txnomepaciente.getText());
		if(situacao.getSelectedIndex()==1) {agenda.setSituacao(1);}else {agenda.setSituacao(0);}
		agenda.setVlProcedimento(procedimentoPaciente.getSelectedIndex());
		
	}
	
	public void limpaCampos() {
		txnomepaciente.setText("");
		txnomepaciente.setEnabled(true);
		buscar.setEnabled(true);
		procedimento.setSelectedIndex(0);
		data.setDate(null);
		sit.setSelected(false);
		
		
		tablePaciente.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo", "Nome", "Contato"
				}
			));
		
		
		
		dadoNomePaciente.setText("Paciente nome:");
		pro.setText("Procedimento :");
		dt.setText("Data :");
		
	}
	public void salvar() {
		
		if(sit.isSelected()==true) {agenda.setSituacao(1);}else {agenda.setSituacao(0);}
		
		leitura();
		
		if(agenda.getIdPaciente()!= 0) {
			if(agenda.getData()==null) {
				aviso.texto.setText("DATA DE CONSULTA NÃO INFORMADA !");
				aviso.show();
				aviso.setLocationRelativeTo(null);
			}else {
				dao.inserirAgendamento(agenda);
				tabbedPaneagendamento.setVisible(false);
				dataDia();
				buscarAgendamentos();
				tabbedPaneAgenda.setVisible(true);
				limpaCampos();
			}
		}else {
			aviso.texto.setText("NENHUM PACIENTE SELECIONADO !");
			aviso.show();
			aviso.setLocationRelativeTo(null);
		}
		
	}
	
	public void atualizar() {
		agenda.setProcedimento(procedimento.getSelectedItem().toString());
		agenda.setVlProcedimento(procedimento.getSelectedIndex());
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //DEFINE FORMATO DE DATA  
	    String date = formato.format(data.getDate());
		agenda.setData(date);
		if(sit.isSelected()==true) {agenda.setSituacao(1);}else {agenda.setSituacao(0);}
		leitura();
		dao.alteraAgendamento(agenda);
		
		
		tabbedPaneagendamento.setVisible(false);
		dataDia();
		buscarAgendamentos();
		tabbedPaneAgenda.setVisible(true);
		limpaCampos();
		
	}

	public void buscarAgendamentos() {
		varreCampos();
		leitura();
		
	if(procedimentoPaciente.getSelectedIndex()==3) {
		
		if(situacao.getSelectedIndex()==0) {
			dao.listConsultas(tableAgendas, paciente, agenda,1);
		}else {
			dao.listConsultas(tableAgendas, paciente, agenda,2);
		}
	}else {
		if(situacao.getSelectedIndex()==0) {
			dao.listConsultas(tableAgendas, paciente, agenda,3);
		}else {
			dao.listConsultas(tableAgendas, paciente, agenda,4);
		}
	}
		if(agenda.getRegistroAgenda()<=1) {
			rg.setText(agenda.getRegistroAgenda()+" registro encontrado");
		}else {
			rg.setText(agenda.getRegistroAgenda()+" registros encontrados");
		}
		
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

	public void prencheCampos() {
		
		leitura();
		dao.privilegio(usuario);
		if(usuario.getpCadAgenda()==1) {
		dao.dadosAgendamento(paciente,agenda);
		
		txnomepaciente.setText(paciente.getNomepaciente());
		procedimento.setSelectedIndex(agenda.getVlProcedimento());
		Date date = new Date();
		SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");	
		try {
			date = (Date) formataData.parse(agenda.getData());
			data.setDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(agenda.getSituacao()==1) {
			sit.setSelected(true);
		}else {
			sit.setSelected(false);
		}
		
		buscar.setEnabled(false);
		
		dadoNomePaciente.setText("Paciente nome: "+paciente.getNomepaciente());
		dt.setText("Data : "+agenda.getData());
		pro.setText("Procedimento : "+agenda.getProcedimento());
		
		txnomepaciente.setEnabled(false);
		
		buscarPaciente();
		tabbedPaneAgenda.setVisible(false);
		tabbedPaneagendamento.setVisible(true);
		}else {
			aviso.texto.setIcon(new ImageIcon(Taviso.class.getResource("/img/atencao.png")));
			aviso.texto.setText("VOCE NÃO TEM PRIVILEGIO PARA ESTA AÇÃO");
			aviso.setLocationRelativeTo(null);
			aviso.show();
		}
		
		
	}
	
	public void atualizaConsulta(int vl) {
		leitura();
		dao.privilegio(usuario);
		if(usuario.getpCadAgenda()==1) {
		if(vl==1) {
			dao.alteraSituacaoAgenda(agenda, 1);
		}else {
			dao.alteraSituacaoAgenda(agenda, 0);
		}
		buscarAgendamentos();
		}else {
			aviso.texto.setIcon(new ImageIcon(Taviso.class.getResource("/img/atencao.png")));
			aviso.texto.setText("VOCE NÃO TEM PRIVILEGIO PARA ESTA AÇÃO");
			aviso.setLocationRelativeTo(null);
			aviso.show();

		}
	}
	
	public void excluir() {
		leitura();
		dao.privilegio(usuario);
		
		if(usuario.getpCadAgenda()==1) {
			dao.excluiAgendamento(agenda);
			buscarAgendamentos();
			
		}else {
			aviso.texto.setIcon(new ImageIcon(Taviso.class.getResource("/img/atencao.png")));
			aviso.texto.setText("VOCE NÃO TEM PRIVILEGIO PARA ESTA AÇÃO");
			aviso.setLocationRelativeTo(null);
			aviso.show();
		}
		
	}
	
	public void checaPrivilegio() {
		leitura();
		dao.privilegio(usuario);
		
		if(usuario.getpCadAgenda()==1) {
		acao=1;
		tabbedPaneAgenda.setVisible(false);
		tabbedPaneagendamento.setVisible(true);
		}else {
			aviso.texto.setIcon(new ImageIcon(Taviso.class.getResource("/img/atencao.png")));
			aviso.texto.setText("VOCE NÃO TEM PRIVILEGIO PARA ESTA AÇÃO");
			aviso.setLocationRelativeTo(null);
			aviso.show();
		}
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
