import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
	
	public class Frame extends JFrame { 
		 private JPanel panel;
		 private JTextField name;
		 private JButton button;
		 private Registry reg;
		
		 
		 
		 public Frame(Registry r) {
			 
			 panel= new JPanel();
			 reg=r;                                                  // Initialization of variables
			 name= new JTextField("Please Enter Suspect's Name");
			 button = new JButton ("Find");
			 
			 
			 panel.add(name);                                          
			 panel.add(button);                                       //adding entities on panel
			 this.setContentPane(panel);
			  
			 ButtonListener Bl= new ButtonListener();                  // creation of a button listener
		     button.addActionListener(Bl);                             // sends signal that user pressed the button
			 
			 this.setVisible(true);
			 this.setSize(300,150);
			 this.setTitle("Find Suspect");                          // Finalizing the frame
			 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 
			 
		 }
		 
		 
		 class ButtonListener implements ActionListener {
			 
			 
			
			public void actionPerformed(ActionEvent e) {
				boolean answer;
				String Sname= name.getText() ;
				answer= reg.includesName(Sname);                  // the answer is whether or not a name is in the registry
				
				
				if (answer){                                     // if name is in registry                    
					ViewSuspect view= new ViewSuspect(reg, Sname );        // Creation of new frame "View Suspect"
					dispose();                                            // Closes the previous "Find Suspect" frame
				}
				else {                                                    // if name is not in registry
					String message = "Suspect "+ Sname +" not found";
					JOptionPane.showMessageDialog(new JFrame(), message, "Message",   // opens new dialog window saying that suspect not found
				    JOptionPane.INFORMATION_MESSAGE);
					}
		}
	    }
		}
	


