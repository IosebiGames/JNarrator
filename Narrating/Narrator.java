package Narrating;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import app.NarratorApp;

public class Narrator {
	private Voice voice;
    private Thread narratorThread;
    private boolean running = false;
    
	public Narrator() {
         setNarrator();
	}
	private void setNarrator() {
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		voice = VoiceManager.getInstance().getVoice("kevin16");
		if(voice != null) {
            voice.allocate();
            voice.setRate(130);
            voice.setPitch(85);
		}
	}
	public void say(String text) {
		narratorThread = new Thread(() -> { 
			  running = true;
			  voice.speak(text);
			  running = false;
			  if(running != true) {
				  NarratorApp.narrate.setEnabled(true);
				  NarratorApp.fileButton.setEnabled(true);
			  }
		});
		narratorThread.start();
	} 
	public void finishNarrator() {
		voice.deallocate();
	}
}