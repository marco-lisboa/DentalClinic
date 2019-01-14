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
