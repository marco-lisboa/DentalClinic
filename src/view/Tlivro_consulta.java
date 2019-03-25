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

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import java.awt.Dimension;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tlivro_consulta extends JPanel {
	

	Paciente paciente = new Paciente();
	Usuario usuario  = new Usuario();
	Iniciador iniciar = new Iniciador();
	DaoConnect dao = new DaoConnect();
	Agenda agenda = new Agenda();
	Taviso aviso = new Taviso();
	private JTable tableAgendas;
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
	private JTextField textField;
	private JComboBox textField_1;
	private JScrollPane scrollPane;
	private JLabel btImprimir;
	private JComboBox procedimentoPaciente;
	private JDateChooser dtConsulta;
	private JTextField txnomepaciente;
	private JLabel rg;

	 private JTable getTabela(){
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
	 private JScrollPane getScroll1(){
			if (scrollPane==null){
				scrollPane= new JScrollPane();
				scrollPane.setBackground(SystemColor.text);
				scrollPane.setViewportView(getTabela());
				scrollPane.setBounds(56,166,225,256);
				defineRenderers();
			}
			
			return scrollPane;
			
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
		
	/**
	 * Create the panel.
	 */
	public Tlivro_consulta() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				 if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
				       setVisible(false);
				    }
				
			}
		});
		setOpaque(false);
		setBounds(243, 11, 575, 439);
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
		tabbedPane.addTab("Consultas Agendadas", new ImageIcon(Tlivro_consulta.class.getResource("/img/livro de consulta pequeno.png")), panel, null);
		tabbedPane.setBackgroundAt(0, new Color(32, 178, 170));
		tabbedPane.setForegroundAt(0, Color.WHITE);
		panel.setLayout(null);
		
		JLabel label_3 = new JLabel("Paciente :");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(10, 25, 68, 14);
		panel.add(label_3);
		
		txnomepaciente = new JTextField();
		txnomepaciente.setColumns(10);
		txnomepaciente.setBounds(67, 19, 170, 20);
		panel.add(txnomepaciente);
		
		JLabel lblData = new JLabel("Data :");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblData.setForeground(Color.WHITE);
		lblData.setBounds(10, 50, 46, 14);
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
		dtConsulta.setBounds(47, 50, 156, 20);
		panel.add(dtConsulta);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buscarAgendamentos();
			}
		});
		lblNewLabel.setToolTipText("Buscar");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setIcon(new ImageIcon(Tlivro_consulta.class.getResource("/img/buscar.png")));
		lblNewLabel.setBounds(487, 2, 38, 32);
		panel.add(lblNewLabel);
		
		JLabel voltar1 = new JLabel("");
		voltar1.setToolTipText("Voltar");
		voltar1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		voltar1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				setVisible(false);
			}
		});
		voltar1.setHorizontalAlignment(SwingConstants.CENTER);
		voltar1.setIcon(new ImageIcon(Tlivro_consulta.class.getResource("/img/voltar.png")));
		voltar1.setBounds(535, 2, 25, 32);
		panel.add(voltar1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 550, 267);
		panel.add(scrollPane);
		
		tableAgendas = new JTable();
		tableAgendas.setGridColor(new Color(32, 178, 170));
		tableAgendas.setForeground(new Color(255, 255, 255));
		tableAgendas.setBackground(new Color(32, 178, 170));
		tableAgendas.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
					"Codigo Agendamento","Nome", "Telefone", "Procedimento"
			}
		));
		scrollPane.setViewportView(tableAgendas);
		
		rg = new JLabel();
		rg.setIcon(new ImageIcon(Tlivro_consulta.class.getResource("/img/confimado.png")));
		rg.setForeground(Color.WHITE);
		rg.setFont(new Font("Tahoma", Font.BOLD, 11));
		rg.setBounds(10, 359, 208, 14);
		panel.add(rg);
		
		JLabel lblProcedimento_1 = new JLabel("Procedimento :");
		lblProcedimento_1.setForeground(Color.WHITE);
		lblProcedimento_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProcedimento_1.setBounds(262, 17, 109, 14);
		panel.add(lblProcedimento_1);
		
		procedimentoPaciente = new JComboBox();
		procedimentoPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agenda.setVlProcedimento(procedimentoPaciente.getSelectedIndex());
			}
		});
		procedimentoPaciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		procedimentoPaciente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		procedimentoPaciente.setModel(new DefaultComboBoxModel(new String[] {"Ambos", "Clinico", "Estetico", "Todos"}));
		procedimentoPaciente.setBounds(357, 14, 120, 20);
		panel.add(procedimentoPaciente);
		
		btImprimir = new JLabel("");
		btImprimir.setIcon(new ImageIcon(Tlivro_consulta.class.getResource("/img/imprimir.png")));
		btImprimir.setToolTipText("Imprimir");
		btImprimir.setHorizontalAlignment(SwingConstants.CENTER);
		btImprimir.setBounds(514, 359, 46, 24);
		panel.add(btImprimir);
		
		JLabel bk = new JLabel("");
		bk.setHorizontalAlignment(SwingConstants.CENTER);
		bk.setIcon(new ImageIcon(Tlivro_consulta.class.getResource("/img/bk.jpeg")));
		bk.setBounds(0, 2, 570, 409);
		panel.add(bk);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setVisible(false);
		tabbedPane_1.setBounds(0, 0, 575, 428);
		add(tabbedPane_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("Consultas Agendadas", new ImageIcon(Tlivro_consulta.class.getResource("/img/livro de consulta pequeno.png")), panel_1, null);
		tabbedPane_1.setForegroundAt(0, Color.WHITE);
		panel_1.setLayout(null);
		
		JLabel lblPaciente = new JLabel("Paciente : ");
		lblPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPaciente.setForeground(Color.WHITE);
		lblPaciente.setBounds(10, 22, 105, 14);
		panel_1.add(lblPaciente);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 36, 333, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblPlano = new JLabel("Plano : ");
		lblPlano.setForeground(Color.WHITE);
		lblPlano.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlano.setBounds(383, 22, 105, 14);
		panel_1.add(lblPlano);
		
		textField_1 = new JComboBox();
		textField_1.setEditable(false);
		textField_1.setBounds(383, 36, 166, 20);
		panel_1.add(textField_1);
		
		JLabel lblProcedimento = new JLabel("Procedimento :");
		lblProcedimento.setForeground(Color.WHITE);
		lblProcedimento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProcedimento.setBounds(10, 60, 105, 14);
		panel_1.add(lblProcedimento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(false);
		comboBox.setBounds(10, 74, 166, 20);
		panel_1.add(comboBox);
		
		JCheckBox dt18 = new JCheckBox("18");
		dt18.setFocusable(false);
		dt18.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt18.setOpaque(false);
		dt18.setForeground(Color.WHITE);
		dt18.setBounds(72, 319, 50, 23);
		panel_1.add(dt18);
		
		JCheckBox dt17 = new JCheckBox("17");
		dt17.setOpaque(false);
		dt17.setForeground(Color.WHITE);
		dt17.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt17.setFocusable(false);
		dt17.setBounds(72, 293, 50, 23);
		panel_1.add(dt17);
		
		JCheckBox dt16 = new JCheckBox("16");
		dt16.setOpaque(false);
		dt16.setForeground(Color.WHITE);
		dt16.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt16.setFocusable(false);
		dt16.setBounds(72, 267, 50, 23);
		panel_1.add(dt16);
		
		JCheckBox dt15 = new JCheckBox("15");
		dt15.setOpaque(false);
		dt15.setForeground(Color.WHITE);
		dt15.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt15.setFocusable(false);
		dt15.setBounds(72, 241, 50, 23);
		panel_1.add(dt15);
		
		JCheckBox dt14 = new JCheckBox("14");
		dt14.setOpaque(false);
		dt14.setForeground(Color.WHITE);
		dt14.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt14.setFocusable(false);
		dt14.setBounds(72, 215, 50, 23);
		panel_1.add(dt14);
		
		JCheckBox dt13 = new JCheckBox("13");
		dt13.setOpaque(false);
		dt13.setForeground(Color.WHITE);
		dt13.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt13.setFocusable(false);
		dt13.setBounds(72, 189, 50, 23);
		panel_1.add(dt13);
		
		JCheckBox dt12 = new JCheckBox("12");
		dt12.setOpaque(false);
		dt12.setForeground(Color.WHITE);
		dt12.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt12.setFocusable(false);
		dt12.setBounds(72, 163, 50, 23);
		panel_1.add(dt12);
		
		JCheckBox dt11 = new JCheckBox("11");
		dt11.setOpaque(false);
		dt11.setForeground(Color.WHITE);
		dt11.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt11.setFocusable(false);
		dt11.setBounds(72, 137, 50, 23);
		panel_1.add(dt11);
		
		JCheckBox dt21 = new JCheckBox("21");
		dt21.setOpaque(false);
		dt21.setForeground(Color.WHITE);
		dt21.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt21.setFocusable(false);
		dt21.setBounds(154, 137, 50, 23);
		panel_1.add(dt21);
		
		JCheckBox dt22 = new JCheckBox("22");
		dt22.setOpaque(false);
		dt22.setForeground(Color.WHITE);
		dt22.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt22.setFocusable(false);
		dt22.setBounds(154, 163, 50, 23);
		panel_1.add(dt22);
		
		JCheckBox st23 = new JCheckBox("23");
		st23.setOpaque(false);
		st23.setForeground(Color.WHITE);
		st23.setFont(new Font("Tahoma", Font.BOLD, 11));
		st23.setFocusable(false);
		st23.setBounds(154, 189, 50, 23);
		panel_1.add(st23);
		
		JCheckBox dt24 = new JCheckBox("24");
		dt24.setOpaque(false);
		dt24.setForeground(Color.WHITE);
		dt24.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt24.setFocusable(false);
		dt24.setBounds(154, 215, 50, 23);
		panel_1.add(dt24);
		
		JCheckBox dt25 = new JCheckBox("25");
		dt25.setOpaque(false);
		dt25.setForeground(Color.WHITE);
		dt25.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt25.setFocusable(false);
		dt25.setBounds(154, 241, 50, 23);
		panel_1.add(dt25);
		
		JCheckBox dt26 = new JCheckBox("26");
		dt26.setOpaque(false);
		dt26.setForeground(Color.WHITE);
		dt26.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt26.setFocusable(false);
		dt26.setBounds(154, 267, 50, 23);
		panel_1.add(dt26);
		
		JCheckBox dt27 = new JCheckBox("27");
		dt27.setOpaque(false);
		dt27.setForeground(Color.WHITE);
		dt27.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt27.setFocusable(false);
		dt27.setBounds(154, 293, 50, 23);
		panel_1.add(dt27);
		
		JCheckBox dt28 = new JCheckBox("28");
		dt28.setOpaque(false);
		dt28.setForeground(Color.WHITE);
		dt28.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt28.setFocusable(false);
		dt28.setBounds(154, 319, 50, 23);
		panel_1.add(dt28);
		
		JCheckBox dt31 = new JCheckBox("31");
		dt31.setOpaque(false);
		dt31.setForeground(Color.WHITE);
		dt31.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt31.setFocusable(false);
		dt31.setBounds(442, 137, 50, 23);
		panel_1.add(dt31);
		
		JCheckBox dt32 = new JCheckBox("32");
		dt32.setOpaque(false);
		dt32.setForeground(Color.WHITE);
		dt32.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt32.setFocusable(false);
		dt32.setBounds(442, 163, 50, 23);
		panel_1.add(dt32);
		
		JCheckBox dt33 = new JCheckBox("33");
		dt33.setOpaque(false);
		dt33.setForeground(Color.WHITE);
		dt33.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt33.setFocusable(false);
		dt33.setBounds(442, 189, 50, 23);
		panel_1.add(dt33);
		
		JCheckBox dt34 = new JCheckBox("34");
		dt34.setOpaque(false);
		dt34.setForeground(Color.WHITE);
		dt34.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt34.setFocusable(false);
		dt34.setBounds(442, 215, 50, 23);
		panel_1.add(dt34);
		
		JCheckBox dt35 = new JCheckBox("35");
		dt35.setOpaque(false);
		dt35.setForeground(Color.WHITE);
		dt35.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt35.setFocusable(false);
		dt35.setBounds(442, 241, 50, 23);
		panel_1.add(dt35);
		
		JCheckBox dt36 = new JCheckBox("36");
		dt36.setOpaque(false);
		dt36.setForeground(Color.WHITE);
		dt36.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt36.setFocusable(false);
		dt36.setBounds(442, 267, 50, 23);
		panel_1.add(dt36);
		
		JCheckBox dt37 = new JCheckBox("37");
		dt37.setOpaque(false);
		dt37.setForeground(Color.WHITE);
		dt37.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt37.setFocusable(false);
		dt37.setBounds(442, 293, 50, 23);
		panel_1.add(dt37);
		
		JCheckBox dt38 = new JCheckBox("38");
		dt38.setOpaque(false);
		dt38.setForeground(Color.WHITE);
		dt38.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt38.setFocusable(false);
		dt38.setBounds(442, 319, 50, 23);
		panel_1.add(dt38);
		
		JCheckBox dt41 = new JCheckBox("41");
		dt41.setOpaque(false);
		dt41.setForeground(Color.WHITE);
		dt41.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt41.setFocusable(false);
		dt41.setBounds(360, 137, 50, 23);
		panel_1.add(dt41);
		
		JCheckBox dt42 = new JCheckBox("42");
		dt42.setOpaque(false);
		dt42.setForeground(Color.WHITE);
		dt42.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt42.setFocusable(false);
		dt42.setBounds(360, 163, 50, 23);
		panel_1.add(dt42);
		
		JCheckBox dt43 = new JCheckBox("43");
		dt43.setOpaque(false);
		dt43.setForeground(Color.WHITE);
		dt43.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt43.setFocusable(false);
		dt43.setBounds(360, 189, 50, 23);
		panel_1.add(dt43);
		
		JCheckBox dt44 = new JCheckBox("44");
		dt44.setOpaque(false);
		dt44.setForeground(Color.WHITE);
		dt44.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt44.setFocusable(false);
		dt44.setBounds(360, 215, 50, 23);
		panel_1.add(dt44);
		
		JCheckBox dt45 = new JCheckBox("45");
		dt45.setOpaque(false);
		dt45.setForeground(Color.WHITE);
		dt45.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt45.setFocusable(false);
		dt45.setBounds(360, 241, 50, 23);
		panel_1.add(dt45);
		
		JCheckBox dt46 = new JCheckBox("46");
		dt46.setOpaque(false);
		dt46.setForeground(Color.WHITE);
		dt46.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt46.setFocusable(false);
		dt46.setBounds(360, 267, 50, 23);
		panel_1.add(dt46);
		
		JCheckBox dt47 = new JCheckBox("47");
		dt47.setOpaque(false);
		dt47.setForeground(Color.WHITE);
		dt47.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt47.setFocusable(false);
		dt47.setBounds(360, 293, 50, 23);
		panel_1.add(dt47);
		
		JCheckBox dt48 = new JCheckBox("48");
		dt48.setOpaque(false);
		dt48.setForeground(Color.WHITE);
		dt48.setFont(new Font("Tahoma", Font.BOLD, 11));
		dt48.setFocusable(false);
		dt48.setBounds(360, 319, 50, 23);
		panel_1.add(dt48);
		
		JLabel arco1 = new JLabel("Arco Superior");
		arco1.setHorizontalAlignment(SwingConstants.CENTER);
		arco1.setForeground(Color.WHITE);
		arco1.setFont(new Font("Tahoma", Font.BOLD, 11));
		arco1.setBounds(10, 105, 274, 14);
		panel_1.add(arco1);
		
		JLabel arco2 = new JLabel("Arco Inferior");
		arco2.setHorizontalAlignment(SwingConstants.CENTER);
		arco2.setForeground(Color.WHITE);
		arco2.setFont(new Font("Tahoma", Font.BOLD, 11));
		arco2.setBounds(283, 105, 274, 14);
		panel_1.add(arco2);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(283, 123, 1, 219);
		panel_1.add(separator);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Tlivro_consulta.class.getResource("/img/voltar.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(545, 0, 25, 32);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon(Tlivro_consulta.class.getResource("/img/atencao.png")));
		label_1.setBounds(186, 60, 41, 32);
		panel_1.add(label_1);
		
		JLabel bk02 = new JLabel("");
		bk02.setIcon(new ImageIcon(Tlivro_consulta.class.getResource("/img/bk.jpeg")));
		bk02.setHorizontalAlignment(SwingConstants.CENTER);
		bk02.setBounds(0, 0, 570, 409);
		panel_1.add(bk02);

	}
	
	public void varreCampos() {
		paciente.setNomepaciente(txnomepaciente.getText());
		agenda.setSituacao(1);
		agenda.setVlProcedimento(procedimentoPaciente.getSelectedIndex());
		
	}
	

	public void buscarAgendamentos() {
		varreCampos();
		leitura();
		if(procedimentoPaciente.getSelectedIndex()==3) {
			dao.listConsultas(tableAgendas, paciente, agenda,2);
		}else {
			dao.listConsultas(tableAgendas, paciente, agenda,4);
		}
		
		if(agenda.getRegistroAgenda()<=1) {
			rg.setText(agenda.getRegistroAgenda()+" registro encontrado");
		}else {
			rg.setText(agenda.getRegistroAgenda()+" registros encontrados");
		}
	
		
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
	
	public void dataDia() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); //DEFINE FORMATO DE DATA  
		Date date = new Date();
	    dtConsulta.setDate(date);
	    procedimentoPaciente.setSelectedIndex(3);
	    buscarAgendamentos();
	}
}
