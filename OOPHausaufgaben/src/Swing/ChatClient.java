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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

public class ChatClient extends JFrame implements Observer {

	private JPanel		contentPane;
	private JTextPane	text;
	JEditorPane			textPane;
	Document			doc;
	StyleSheet			styleSheet;
	HTMLEditorKit		kit;
	JScrollPane			scrollPane;
	private String		user;
	private Color		rgb;
	private ChatServer	server;
	private ImageIcon	smile, sad, angry, cry, bsmile, cool, nerd, ohh, strich, zunge, zwinker;
	final String		SMILE		= ":)", SAD = ":(", ANGRY = ":@", CRY = ";(", BSMILE = ":D", COOL = "8)", NERD = ":8", OHH = ":O", STRICH = ":|", ZUNGE = ":P", ZWINKER = ";)";
	private String[]	emoticons	= {
			SMILE, SAD, ANGRY, CRY, BSMILE, COOL, NERD, OHH, STRICH, ZUNGE, ZWINKER
									};

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

		kit = new HTMLEditorKit();
		textPane.setEditorKit(kit);

		// add some styles to the html
		styleSheet = kit.getStyleSheet();
		styleSheet.addRule("body {color:#000; font-family:times; margin: 4px; }");
		styleSheet.addRule("h1 {color: blue;}");
		styleSheet.addRule("h2 {color: #ff0000;}");

		styleSheet.addRule("pre {font : 10px monaco; color : black; background-color : #fafafa; }");
		doc = kit.createDefaultDocument();
		textPane.setDocument(doc);
		//
		// String imgsrc = "file:res/sad.jpg";
		//
		// String htmlString = "<html>&#1F601;</html>";
		// textPane.setText(htmlString);

		scrollPane = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));

		text = new JTextPane();
		panel_1.add(text, BorderLayout.CENTER);

		JButton send = new JButton("Send");
		panel_1.add(send, BorderLayout.EAST);
		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String textPaneText = textPane.getText();
				String username = user;
				String newText = text.getText();
				String test = textPaneText.replace("</p>", "<span style=\"color: #" + Integer.toHexString(rgb.getRGB()).substring(2) + ";\">" + username + "</span>: " + newText + "<br></p>");
				server.updateChat(test);
				// textPane.setText("<html>" + text + "</html>");
				// textPane.repaint();
				// System.out.println(text);
				// System.out.println("2ASFJBKVDSAFGKAEROILFJDGVBOJLKASDFHIOLLBHUIOADLFRGOHLIUASDFOIHULG " + text);
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
		String text = (String) arg;
		text = text.replace(":)", "<img src=\"file:res/smile.jpg\" alt=\"eine grafik\"></img>");
		text = text.replace(":(", "<img src=\"file:res/sad.jpg\" alt=\"eine grafik\"></img>");
		text = text.replace(";)", "<img src=\"file:res/zwinker.jpg\" alt=\"eine grafik\"></img>");
		text = text.replace(":P", "<img src=\"file:res/zunge.jpg\" alt=\"eine grafik\"></img>");
		text = text.replace(":@", "<img src=\"file:res/angry.gif\" alt=\"eine grafik\" width=\"20\" height=\"20\"></img>");
		text = text.replace(":O", "<img src=\"file:res/ohhh.jpg\" alt=\"eine grafik\"></img>");
		text = text.replace(";(", "<img src=\"file:res/cry.jpg\" alt=\"eine grafik\"></img>");
		text = text.replace("8)", "<img src=\"file:res/cool.jpg\" alt=\"eine grafik\"></img>");
		text = text.replace("8|", "<img src=\"file:res/nerd.jpg\" alt=\"eine grafik\"></img>");
		text = text.replace(":D", "<img src=\"file:res/bigsmile.jpg\" alt=\"eine grafik\"></img>");
		text = text.replace(":|", "<img src=\"file:res/strich.jpg\" alt=\"eine grafik\"></img>");
		textPane.setText(text);
	}
}
