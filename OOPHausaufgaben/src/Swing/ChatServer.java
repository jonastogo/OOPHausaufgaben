package Swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

public class ChatServer extends Observable implements ActionListener {

	private JPanel					contentPane;
	private JTextField				txtUsername;
	private JEditorPane				editorPane;
	private JToggleButton			red;
	private JToggleButton			purple;
	private JToggleButton			blue;
	private JToggleButton			cyan;
	private JToggleButton			green;
	private JToggleButton			neongreen;
	private JToggleButton			yellow;
	private JToggleButton			orange;
	private JToggleButton			brown;
	private JToggleButton			black;
	private JButton					addUser;
	private ArrayList<ChatClient>	clients;
	Document						doc;
	StyleSheet						styleSheet;
	HTMLEditorKit					kit;
	private ImageIcon				smile, sad, angry, cry, bsmile, cool, nerd, ohh, strich, zunge, zwinker;
	private JToggleButton[]			tbtn;
	final String					SMILE		= ":)", SAD = ":(", ANGRY = ":@", CRY = ";(", BSMILE = ":D", COOL = "8)", NERD = ":8", OHH = ":O", STRICH = ":|", ZUNGE = ":P", ZWINKER = ";)";
	private String[]				emoticons	= {
			SMILE, SAD, ANGRY, CRY, BSMILE, COOL, NERD, OHH, STRICH, ZUNGE, ZWINKER
												};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatServer frame = new ChatServer("ChatServer");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChatServer(String title) {
		JFrame guiFrame = new JFrame(title);
		clients = new ArrayList<ChatClient>();
		tbtn = new JToggleButton[10];
		red = new JToggleButton("");
		tbtn[0] = red;
		purple = new JToggleButton("");
		tbtn[1] = purple;
		blue = new JToggleButton("");
		tbtn[2] = blue;
		cyan = new JToggleButton("");
		tbtn[3] = cyan;
		green = new JToggleButton("");
		tbtn[4] = green;
		neongreen = new JToggleButton("");
		tbtn[5] = neongreen;
		yellow = new JToggleButton("");
		tbtn[6] = yellow;
		orange = new JToggleButton("");
		tbtn[7] = orange;
		brown = new JToggleButton("");
		tbtn[8] = brown;
		black = new JToggleButton("");
		tbtn[9] = black;

		smile = new ImageIcon("smile.jpg");
		sad = new ImageIcon("sad.jpg");
		angry = new ImageIcon("angry.jpg");
		cry = new ImageIcon("cry.jpg");
		bsmile = new ImageIcon("bigsmile.jpg");
		cool = new ImageIcon("cool.jpg");
		nerd = new ImageIcon("nerd.jpg");
		ohh = new ImageIcon("ohhh.jpg");
		strich = new ImageIcon("strich.jpg");
		zunge = new ImageIcon("zunge.jpg");
		zwinker = new ImageIcon("zwinker.jpg");

		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		guiFrame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(5, 5, 232, 251);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setVisible(true);

		kit = new HTMLEditorKit();
		editorPane.setEditorKit(kit);

		// add some styles to the html
		styleSheet = kit.getStyleSheet();
		styleSheet.addRule("body {color:#000; font-family:times; margin: 4px; }");
		styleSheet.addRule("h1 {color: blue;}");
		styleSheet.addRule("h2 {color: #ff0000;}");
		styleSheet.addRule("pre {font : 10px monaco; color : black; background-color : #fafafa; }");
		doc = kit.createDefaultDocument();
		editorPane.setDocument(doc);
		// editorPane.setContentType("text/html");

		JScrollPane scrollPane = new JScrollPane(editorPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(247, 5, 182, 251);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		addUser = new JButton("Neuen User erstellen");
		addUser.setBounds(10, 122, 162, 23);
		panel_1.add(addUser);
		addUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color c = Color.BLACK;
				if (red.isSelected()) {
					c = red.getBackground();
				} else if (purple.isSelected()) {
					c = purple.getBackground();
				} else if (blue.isSelected()) {
					c = blue.getBackground();
				} else if (cyan.isSelected()) {
					c = cyan.getBackground();
				} else if (green.isSelected()) {
					c = green.getBackground();
				} else if (neongreen.isSelected()) {
					c = neongreen.getBackground();
				} else if (yellow.isSelected()) {
					c = yellow.getBackground();
				} else if (orange.isSelected()) {
					c = orange.getBackground();
				} else if (brown.isSelected()) {
					c = brown.getBackground();
				} else if (black.isSelected()) {
					c = black.getBackground();
				}
				addClient(c);
			}
		});

		red.setBackground(Color.RED);
		red.setForeground(Color.RED);
		red.setBounds(10, 11, 24, 23);
		red.addActionListener(this);
		panel_1.add(red);

		blue.setForeground(Color.BLUE);
		blue.setBackground(Color.BLUE);
		blue.setBounds(78, 11, 24, 23);
		blue.addActionListener(this);
		panel_1.add(blue);

		green.setForeground(new Color(34, 139, 34));
		green.setBackground(new Color(34, 139, 34));
		green.setBounds(10, 45, 24, 23);
		green.addActionListener(this);
		panel_1.add(green);

		purple.setForeground(new Color(186, 85, 211));
		purple.setBackground(new Color(186, 85, 211));
		purple.setBounds(44, 11, 24, 23);
		purple.addActionListener(this);
		panel_1.add(purple);

		cyan.setForeground(new Color(0, 255, 255));
		cyan.setBackground(new Color(0, 255, 255));
		cyan.setBounds(112, 11, 24, 23);
		cyan.addActionListener(this);
		panel_1.add(cyan);

		neongreen.setForeground(new Color(173, 255, 47));
		neongreen.setBackground(new Color(173, 255, 47));
		neongreen.setBounds(44, 45, 24, 23);
		neongreen.addActionListener(this);
		panel_1.add(neongreen);

		yellow.setForeground(Color.YELLOW);
		yellow.setBackground(Color.YELLOW);
		yellow.setBounds(78, 45, 24, 23);
		yellow.addActionListener(this);
		panel_1.add(yellow);

		orange.setForeground(Color.ORANGE);
		orange.setBackground(Color.ORANGE);
		orange.setBounds(112, 45, 24, 23);
		orange.addActionListener(this);
		panel_1.add(orange);

		black.setForeground(Color.BLACK);
		black.setBackground(Color.BLACK);
		black.setBounds(146, 11, 24, 23);
		black.addActionListener(this);
		panel_1.add(black);

		brown.setForeground(new Color(139, 69, 19));
		brown.setBackground(new Color(139, 69, 19));
		brown.setBounds(146, 45, 24, 23);
		brown.addActionListener(this);
		panel_1.add(brown);

		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.setBounds(10, 88, 162, 23);
		txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				txtUsername.setText("");
			}
		});
		panel_1.add(txtUsername);
		txtUsername.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(10, 156, 162, 84);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JButton clear = new JButton("Chat leeren");
		clear.setBounds(10, 11, 142, 23);
		panel_2.add(clear);
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateChat("");
			}
		});

		JButton exit = new JButton("Chat beenden");
		exit.setBounds(10, 50, 142, 23);
		panel_2.add(exit);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Iterator<ChatClient> iter = clients.iterator();
				while (iter.hasNext()) {
					ChatClient cc = iter.next();
					cc.dispose();
					updateChat("");
				}
			}
		});

		guiFrame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		for (JToggleButton t : tbtn)
			if (t != ((JToggleButton) e.getSource()))
				if (t.isSelected())
					t.setSelected(false);
	}

	public void removeClient(ChatClient c) {
		Iterator<ChatClient> iter = clients.iterator();
		while (iter.hasNext()) {
			ChatClient cc = iter.next();
			if (cc.equals(c)) {
				iter.remove();
				this.deleteObserver(cc);
			}
		}
	}

	public void addClient(Color c) {
		Observer cc = new ChatClient("ChatClient", txtUsername.getText(), c, this);
		clients.add((ChatClient) cc);
		this.addObserver(cc);
	}

	public void printList() {
		System.out.println("---------------");
		clients.forEach((cc) -> {
			System.out.println(cc.getUser() + " - " + cc.getRgb());
		});
		System.out.println("_______________");
	}

	protected JEditorPane getEditorPane() {
		return editorPane;
	}

	protected void setEditorPane(JEditorPane editorPane) {
		this.editorPane = editorPane;
	}

	public void updateChat(String s) {
		setChanged();
		editorPane.setText(s);
		notifyObservers(s);
	}
}
