package Swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ChatClient extends JFrame implements Observer {

	private JPanel		contentPane;
	private JTextField	text;
	JEditorPane			textPane;
	private String		user;
	private Color		rgb;
	private ChatServer	server;

	/**
	 * Create the frame.
	 */
	public ChatClient(String title, String user, Color rgb, ChatServer server) {
		super(title);
		this.user = user;
		this.rgb = rgb;
		this.server = server;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		textPane = new JEditorPane();
		textPane.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));

		text = new JTextField();
		panel_1.add(text, BorderLayout.CENTER);

		text.setColumns(10);

		JButton send = new JButton("Send");
		panel_1.add(send, BorderLayout.EAST);
		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = textPane.getText() + user + ": " + text.getText() + "\n";
				server.updateChat(s);
			}
		});

		JTextArea username = new JTextArea(user);
		username.setBackground(rgb);
		Color c = new Color(Math.abs(rgb.getRed() - 255), Math.abs(rgb.getGreen() - 255), Math.abs(rgb.getBlue() - 255));
		username.setForeground(c);
		panel_1.add(username, BorderLayout.WEST);

		setVisible(true);

		WindowListener exitListener = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				closeWindowAssist();
			}
		};
		addWindowListener(exitListener);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Color getRgb() {
		return rgb;
	}

	public void setRgb(Color rgb) {
		this.rgb = rgb;
	}

	public ChatClient retCC() {
		return this;
	}

	public void closeWindowAssist() {
		server.printList();
		server.removeClient(retCC());
		server.printList();
	}

	@Override
	public void update(Observable o, Object arg) {
		textPane.setText((String) arg);

	}
}
