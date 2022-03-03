package paint.src.udc.psw;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppLinhas extends JFrame {

	private LinePanel contentPane;
	public JLabel message;
	private JMenuBar menuBar;
	private JMenu botaoMenu;
	private JMenuItem botaoPonto;
	private JMenuItem botaoLinha;
	private JMenuItem botaoCirculo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppLinhas frame = new AppLinhas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AppLinhas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		botaoMenu = new JMenu("Figuras");
		menuBar.add(botaoMenu);

		botaoPonto = new JMenuItem("Ponto");
		botaoPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.escolhe(1);

			}
		});
		botaoMenu.add(botaoPonto);

		botaoLinha = new JMenuItem("Linha");
		botaoLinha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.escolhe(2);

			}
		});
		botaoMenu.add(botaoLinha);

		botaoCirculo = new JMenuItem("Circulo");
		botaoCirculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.escolhe(3);
			}
		});
		botaoMenu.add(botaoCirculo);
		JPanel content = new JPanel();
		content.setBorder(new EmptyBorder(5, 5, 5, 5));
		content.setLayout(new BorderLayout());
		setContentPane(content);

		message = new JLabel("Messages");
		content.add(message, BorderLayout.SOUTH);

		contentPane = new LinePanel(message);
		content.add(contentPane, BorderLayout.CENTER);
	}

}