package Narrating;

import javax.swing.JFileChooser;
import app.NarratorApp;
import java.io.*;

public class Narration {
	private NarratorApp na;
	private Narrator n;
	private JFileChooser chooser;
	private int operation;
	private File selectedFile;
	private String content;
	
	public Narration(NarratorApp na) {
		this.na = na;
		this.n = new Narrator();
		this.chooser = new JFileChooser("JNarrator");
	}
	public void setOnAction() {
		NarratorApp.narrate.addActionListener(e -> {
			if(e.getSource()==NarratorApp.narrate) {
			   NarratorApp.narrate.setEnabled(false);	
			   NarratorApp.fileButton.setEnabled(false);
			   n.say(na.narratorArea.getText());
			}  
		});
		NarratorApp.fileButton.addActionListener(e -> {
			if(e.getSource()==NarratorApp.fileButton) {
	            operation = chooser.showOpenDialog(null);
	            
	            if(operation == JFileChooser.APPROVE_OPTION && chooser.getSelectedFile().getName().endsWith(".txt")) {
	            	selectedFile = chooser.getSelectedFile();
	                readDisplay(selectedFile);
	            }else if(operation == JFileChooser.CANCEL_OPTION) {
	            	return;
	            }
			}
		});
	}
	private String readDisplay(File f) {
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			   content = br.readLine();
		       na.narratorArea.setText(String.join("\n", content.split(",")));
		       br.close();
		}catch(IOException e) {
			System.out.println("Failed to read: " + e.getMessage());
		}
		return content;
	}
}
