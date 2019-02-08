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
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TavisoErro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JLabel erro;
	public JTextArea textPaneErro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TavisoErro dialog = new TavisoErro();
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
	public TavisoErro() {
		setUndecorated(true);
		setBounds(100, 100, 450, 158);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setModalityType(ModalityType.TOOLKIT_MODAL);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			erro = new JLabel("ATEN\u00C7\u00C3O");
			erro.setIcon(new ImageIcon(TavisoErro.class.getResource("/img/atencao.png")));
			erro.setHorizontalAlignment(SwingConstants.CENTER);
			erro.setForeground(Color.WHITE);
			erro.setFont(new Font("Tahoma", Font.BOLD, 15));
			erro.setBounds(175, 0, 129, 36);
			contentPanel.add(erro);
		}
		{
			JButton button = new JButton("OK");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 32, 430, 85);
			contentPanel.add(scrollPane);
			
			textPaneErro = new JTextArea();
			textPaneErro.setEditable(false);
			textPaneErro.setWrapStyleWord(true);
			textPaneErro.setFont(new Font("Arial", Font.BOLD, 11));
			textPaneErro.setLineWrap(true);
			scrollPane.setViewportView(textPaneErro);
			button.setForeground(Color.WHITE);
			button.setFocusable(false);
			button.setBackground(new Color(32, 178, 170));
			button.setBounds(182, 120, 89, 23);
			contentPanel.add(button);
		}
		{
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(TavisoErro.class.getResource("/img/bk.jpeg")));
			label.setVerticalAlignment(SwingConstants.BOTTOM);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setBounds(0, 0, 450, 160);
			contentPanel.add(label);
		}
	}
}
