package main;

import javax.swing.*;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.EventQueue;
import app.NarratorApp;

public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new FlatDarkLaf());
			EventQueue.invokeLater(() -> {
				new NarratorApp();
			});
		}catch(UnsupportedLookAndFeelException e) {
            System.out.println("Can't set Look & Feel: " + e.getMessage());			
		}
	}
}