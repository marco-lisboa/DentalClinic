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
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Cursor;

public class Tconfigurar extends JPanel {
	private JTable table;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Tconfigurar() {
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
		
		JTabbedPane tabbedPaneUsuarios = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneUsuarios.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPaneUsuarios.setBorder(null);
		tabbedPaneUsuarios.setBackground(new Color(32, 178, 170));
		tabbedPaneUsuarios.setBounds(0, 0, 575, 428);
		add(tabbedPaneUsuarios);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(32, 178, 170));
		tabbedPaneUsuarios.addTab("USUARIO", new ImageIcon(Tconfigurar.class.getResource("/img/configPequena.png")), panel_1, null);
		
		JLabel voltarUsuarios = new JLabel("");
		voltarUsuarios.setIcon(new ImageIcon(Tconfigurar.class.getResource("/img/voltar.png")));
		voltarUsuarios.setToolTipText("Voltar");
		voltarUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		voltarUsuarios.setBounds(535, 2, 25, 32);
		panel_1.add(voltarUsuarios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 550, 244);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"CODIGO", "NOME", "NIVEL"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("Nome : ");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 11, 46, 14);
		panel_1.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(52, 8, 145, 20);
		panel_1.add(textField);
		
		JLabel label_1 = new JLabel("");
		label_1.setToolTipText("Buscar");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(207, 2, 46, 32);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Situa\u00E7\u00E3o : ");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(10, 39, 89, 14);
		panel_1.add(label_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(73, 36, 145, 20);
		panel_1.add(comboBox);
		
		JLabel label_3 = new JLabel("null registros encontrados");
		label_3.setIcon(new ImageIcon(Tconfigurar.class.getResource("/img/confimado.png")));
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(10, 368, 208, 14);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Tconfigurar.class.getResource("/img/add.png")));
		label_4.setToolTipText("Adicionar Novo Paciente");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(221, 355, 46, 43);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Tconfigurar.class.getResource("/img/editar (2).png")));
		label_5.setToolTipText("Editar");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(281, 355, 46, 43);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Tconfigurar.class.getResource("/img/deleta.png")));
		label_6.setToolTipText("Remover Paciente");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(337, 355, 46, 43);
		panel_1.add(label_6);
		
		JLabel bkUsuarios = new JLabel("");
		bkUsuarios.setIcon(new ImageIcon(Tconfigurar.class.getResource("/img/bk.jpeg")));
		bkUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		bkUsuarios.setBounds(0, 2, 570, 409);
		panel_1.add(bkUsuarios);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBackground(new Color(32, 178, 170));
		tabbedPane.setBounds(0, 0, 575, 428);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setForeground(Color.WHITE);
		tabbedPane.addTab("Configura\u00E7\u00E3o", new ImageIcon(Tconfigurar.class.getResource("/img/configPequena.png")), panel, null);
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
		lblNewLabel_1.setIcon(new ImageIcon(Tficha_paciente.class.getResource("/img/voltar.png")));
		lblNewLabel_1.setBounds(535, 2, 25, 32);
		panel.add(lblNewLabel_1);
		
		JButton btnUsuario = new JButton("Empresa");
		btnUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		btnUsuario.setForeground(Color.WHITE);
		btnUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUsuario.setBackground(new Color(32, 178, 170));
		btnUsuario.setBounds(14, 25, 257, 14);
		panel.add(btnUsuario);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		btnUsuarios.setForeground(Color.WHITE);
		btnUsuarios.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUsuarios.setBackground(new Color(32, 178, 170));
		btnUsuarios.setBounds(14, 50, 257, 14);
		panel.add(btnUsuarios);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(281, 11, 1, 324);
		panel.add(separator);
		
		JLabel bk = new JLabel("");
		bk.setHorizontalAlignment(SwingConstants.CENTER);
		bk.setIcon(new ImageIcon(Tlivro_consulta.class.getResource("/img/bk.jpeg")));
		bk.setBounds(0, 2, 570, 409);
		panel.add(bk);

	}
}
