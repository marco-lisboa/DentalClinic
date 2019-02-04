package viewTavisos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dialog.ModalityType;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TavisoConfirmaUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JLabel texto;
	private JButton btNao;
	private JButton btSim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TavisoConfirmaUsuario dialog = new TavisoConfirmaUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TavisoConfirmaUsuario() {
		setUndecorated(true);
		setBounds(100, 100, 450, 158);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setModalityType(ModalityType.TOOLKIT_MODAL);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			texto = new JLabel("");
			texto.setIcon(new ImageIcon(TavisoConfirmaUsuario.class.getResource("/img/atencao.png")));
			texto.setHorizontalAlignment(SwingConstants.CENTER);
			texto.setForeground(Color.WHITE);
			texto.setFont(new Font("Tahoma", Font.BOLD, 15));
			texto.setBounds(10, 27, 430, 36);
			contentPanel.add(texto);
		}
		{
			btSim = new JButton("Sim");
			btSim.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btSim.setForeground(Color.WHITE);
			btSim.setFocusable(false);
			btSim.setBackground(new Color(32, 178, 170));
			btSim.setBounds(93, 124, 89, 23);
			contentPanel.add(btSim);
		}
		
		btNao = new JButton("N\u00E3o");
		btNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btNao.setForeground(Color.WHITE);
		btNao.setFocusable(false);
		btNao.setBackground(new Color(32, 178, 170));
		btNao.setBounds(257, 124, 89, 23);
		contentPanel.add(btNao);
		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(TavisoConfirmaUsuario.class.getResource("/img/bk.jpeg")));
			label.setVerticalAlignment(SwingConstants.BOTTOM);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(0, 0, 450, 160);
			contentPanel.add(label);
		}
	}
}
