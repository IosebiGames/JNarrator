package app;

import javax.swing.*;
import java.awt.*;
import Narrating.Narration;

@SuppressWarnings("serial")
public class NarratorApp extends JFrame {
	public JTextArea narratorArea;
	private JLabel textLabel;
	public static JButton narrate, fileButton;
	private Narration na;
    private JScrollPane pane;
    
	@SuppressWarnings("static-access")
	public NarratorApp() {
		super("JNarrator");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setPreferredSize(new Dimension(854, 480));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setBackground(Color.white);
		setIconImage(new ImageIcon(getClass().getResource("/icons/jnarrator_icon.png")).getImage());
		
		this.narratorArea = new JTextArea("Hello, my name is Narrator\n\n and I'm reading the text aloud, how do you like it baby?");
		this.textLabel = new JLabel("Enter text to Narrate down below:");
		this.narrate = new JButton("Narrate");
		this.fileButton = new JButton("S");
		this.na = new Narration(this);
		this.pane = new JScrollPane();
		
        load();
    }
	private void load() {
		narratorArea.setBackground(Color.white);
	    narratorArea.setForeground(Color.black);
	    narratorArea.setCaretColor(Color.black);
	    narratorArea.setEditable(true);
	    narratorArea.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	    narratorArea.setLineWrap(true);       
	    narratorArea.setWrapStyleWord(true);  
	    
	    pane.setViewportView(narratorArea);
	    pane.setBounds(145, 50, 560, 270); 
	    pane.setBorder(BorderFactory.createLineBorder(Color.black, 3)); 
	    pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    
	    add(pane); 
	    
	    textLabel.setFocusable(false);
	    textLabel.setForeground(Color.black);
	    textLabel.setBounds(235, 10, 385, 40);
	    textLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
	    add(textLabel);
	    
	    narrate.setFocusable(false);
	    narrate.setFocusPainted(false);
	    narrate.setBackground(Color.white);
	    narrate.setForeground(Color.black);
	    narrate.setBounds(310, 370, 210, 40);
	    narrate.setBorder(BorderFactory.createLineBorder(Color.black, 1));
	    add(narrate);
	    
	    fileButton.setFocusable(false);
	    fileButton.setFocusPainted(false);
	    fileButton.setBackground(Color.white);
	    fileButton.setForeground(Color.black);
	    fileButton.setBounds(770, 371, 50, 40);
	    fileButton.setToolTipText("Select file to narrate.");
	    fileButton.setBorder(BorderFactory.createLineBorder(Color.black, 1));
	    add(fileButton);

	    na.setOnAction();
	}
}