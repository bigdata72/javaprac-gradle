package topic.core.book.corejava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class CallBackTest {
	public static void main(String[] args) {
		TalkingClock clock = new TalkingClock(10000, true);
		
		//clock.start(); // regular private inner class
		
		clock.startLocalInnerClass(5000, true);// local inner class
		
		//clock.startAnonymousInnerClass(2000, true); // anonymous inner class
		
		JOptionPane.showMessageDialog(null, "Click ok to cancel");
		System.exit(-1);
		
	}
}

class TalkingClock {
	private boolean beep = false;
	private int delay = 1000;
	
	TalkingClock(int delay, boolean flag){
		this.beep = flag;
		this.delay = delay;
	}
	
	public void start(){
		// Refer to Inner class as - OuterClass.innerclass
		TalkingClock.TimerPrinter listener = this.new TimerPrinter();
		javax.swing.Timer timer = new javax.swing.Timer(delay, listener);
		timer.start();
	}
	
	public void startLocalInnerClass(int delay, final boolean beep){
		class TimerPrinterLocal implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Local Inner Class Impl >> At the tone, the time is now :"+new Date());
				if(beep)Toolkit.getDefaultToolkit().beep();
			}
		}
		ActionListener listener = new TimerPrinterLocal();
		Timer timer = new Timer(delay, listener);
		timer.start();
	}
	
	public void startAnonymousInnerClass(int delay, final boolean flag){
		ActionListener listener = new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Anonymous Inner Class Impl >> At the tone, the time is now :"+new Date());
				if(beep)Toolkit.getDefaultToolkit().beep();
			}
		};
		Timer timer = new Timer(delay, listener);
		timer.start();
	}
	
	private class TimerPrinter implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Inner Class Impl >> At the tone, the time is now :"+new Date());
				// Refer to Outer class as - Outerclass.this
				if(TalkingClock.this.beep) Toolkit.getDefaultToolkit().beep();
		}
	}
}
