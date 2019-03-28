package viewTavisos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.T_024_configurar;
import view.T_004_ficha_paciente;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dialog.ModalityType;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TavisoPacientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JLabel texto;
	private JButton btNao;
	public JButton btSim;
	public int id,acao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TavisoPacientes dialog = new TavisoPacientes();
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
	public TavisoPacientes() {
		setUndecorated(true);
		setBounds(100, 100, 450, 158);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setModalityType(ModalityType.TOOLKIT_MODAL);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			texto = new JLabel("");
			texto.setIcon(new ImageIcon(TavisoPacientes.class.getResource("/img/atencao.png")));
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
					T_004_ficha_paciente p = new T_004_ficha_paciente();
					if(acao==1) {
						p.excluir(id);
					}else {
						p.desativa(id);
					}
					
					dispose();
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
			label.setIcon(new ImageIcon(TavisoPacientes.class.getResource("/img/bk.jpeg")));
			label.setVerticalAlignment(SwingConstants.BOTTOM);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(0, 0, 450, 160);
			contentPanel.add(label);
		}
	}
}
