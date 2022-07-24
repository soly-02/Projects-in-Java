import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;

public class ViewSuspect extends JFrame  {

	
	     private Container contentPane;
		 private JTextField name,codeName,snum;
         private JList numbers, SMSs, partners,Spartners;
		 private JButton findButton,backButton;
		 private Registry regi;
		 private ArrayList<String> nums;
		 private  JPanel panel, panel2, panel3,panel4;
		 private  Suspect s; 
		
		
		 public ViewSuspect(Registry r, String n) {
			 
			 super("Suspect Page");
			  
			 
			 contentPane = this.getContentPane();            // Creation of Content Pane
			 contentPane.setLayout(new FlowLayout());

			  
			  // **FIRST PANEL CREATION** INCLUDES NAME,CODE NAME AND NUMBERS!!!
			 
			 // Initialization of variables
			 name= new JTextField(n);
			 name.setColumns(10);
			 s= r.GetSuspect(n);          
			 panel= new JPanel();
			 numbers= new JList();
			 regi=r;
			 codeName= new JTextField(s.getCodeName());                 
			 codeName.setColumns(10);
			
			
			
			
			DefaultListModel model= new DefaultListModel();                // Creation of a Model used to view the list with the numbers
			String str= (s.getNumbers().toString().replace("[", "")).replace("]", "").replace(" ", "").replace(" ", "");  // formatting of the string
		    String[] nums3= str.split(",");   // splitting the numbers and adding them in a table 
			nums= new ArrayList<>();
			
			for (int index = 0; index < nums3.length; index++) {
				nums.add(nums3[index]);
			    model.addElement(nums3[index]);                   // adding the numbers in the model
			}
			
			 
		
			numbers.setModel(model);                          // setting the model
			
			
			 // adding all the elements on the panel and formatting it
		     panel.setPreferredSize(new Dimension(400, 100));
			 panel.setBorder(BorderFactory.createLineBorder(Color.gray));
			 panel.add(name);
			 panel.add(codeName);                              
			 panel.add(numbers);
			 
			
			
			 contentPane.add(panel);    // adding first panel on content pane
			 
			 
			 //**SECOND PANEL CREATION** SMS TEXT FRAME, MESSAGES AND BUTTON.
			 
			 
			 // Initialization of variables
			 findButton= new JButton("Find SMS");
			 snum= new JTextField("Enter Number");
			 snum.setColumns(10);
			 SMSs= new JList();
			 panel2= new JPanel();
			 findButton.setActionCommand("Find");
             ButtonListener Bl= new ButtonListener();
			 
		     findButton.addActionListener(Bl);                    // sends signal that user pressed the button
	 
		     
		     // adding all the elements on the panel and formatting it
		 	 panel2.setPreferredSize(new Dimension(400, 100));
		     panel2.setBorder(BorderFactory.createLineBorder(Color.gray));
		     panel2.add(snum);
		     panel2.add(SMSs);
		     panel2.add(findButton);
		     
		     contentPane.add(panel2);
		     
		     
		  // **THIRD PANEL CREATION** PARTNERS LIST AND TAG
		     
		     //Creation of new Lists,Model and panel
		     partners= new JList();
		     DefaultListModel model3= new DefaultListModel();
		     panel3= new JPanel();
			 ArrayList<Suspect> listOfPartners= new	ArrayList<Suspect>();
			 ArrayList<String> PartnerNames= new	ArrayList<String>();
				
				listOfPartners=s.GetPartners();  //gets partner list of suspect
		     
				//saving the partners names and code names
				for(Suspect sus: listOfPartners) {
					PartnerNames.add(sus.getName()+ "-"+ sus.getCodeName());
				}
				
				// sorting names on ascending order
				Collections.sort(PartnerNames);
				
				 // formatting of the string, saving messages in a  table and adding them in a model 
				String str3= (PartnerNames.toString().replace("[", "")).replace("]", "").replace(" ", "").replace(" ", "");
				String[] strpar= str3.split(",");
				
				for(int index=0; index<PartnerNames.size();index++ ) {
					model3.addElement(strpar[index].replace("-", ","));
				}
				
				partners.setModel(model3);
				
				
				
				// Initialization of label
				JLabel lpartners= new JLabel();
				lpartners.setText("Partners");
				
				 // adding all the elements on the panel and formatting it
				 panel3.setPreferredSize(new Dimension(400, 100));
				 panel3.setBorder(BorderFactory.createLineBorder(Color.gray));
				 panel3.add(lpartners);
			     panel3.add(partners);
			   
				contentPane.add(panel3);
		     
				// **FORTH PANEL CREATION** LIST OF SUGGESTED PARTNERS
				
				
				  //Creation and Initialization of new Lists,Model and panel
				 Spartners= new JList();
				 DefaultListModel model4= new DefaultListModel();
				 panel4= new JPanel();
				 ArrayList<Suspect> listOfSuggPartners= new	ArrayList<Suspect>();
				 ArrayList<String> suggPartnerNames= new ArrayList<String>();
				 listOfSuggPartners=s.SuggestedSuspects(); // gets suggested suspects
				     
		                // Saves the names of the suggested partners 
						for(Suspect sus: listOfSuggPartners) {
							suggPartnerNames.add(sus.getName()+ "-"+ sus.getCodeName());
						}
						// If there are no suggested partners saves "NONE"
						if (suggPartnerNames.isEmpty())
							suggPartnerNames.add("NONE");
						
						
						// sorting names on ascending order
						Collections.sort(suggPartnerNames);
						
						
					
						
						
						// formatting of the string, saving messages in a  table and adding them in a model 
						String str4= (suggPartnerNames.toString().replace("[", "")).replace("]", "").replace(" ", "").replace(" ", "");
						String[] strpar4= str4.split(",");
						for(int index=0; index<suggPartnerNames.size();index++ ) {
							model4.addElement(strpar4[index].replace("-", ","));
							}
						
						Spartners.setModel(model4);
						
						
						// Initialization of label
						JLabel lsuggpartners= new JLabel();
						lsuggpartners.setText("Suggested Partners -->");
					
						
						// adding all the elements on the panel and formatting it
						 panel4.setPreferredSize(new Dimension(400, 100));
						 panel4.setBorder(BorderFactory.createLineBorder(Color.gray));
						 panel4.add(lsuggpartners);
						 panel4.add(Spartners);
					     contentPane.add(panel4);
				
				// **RETURN TO FIND SUSPECT BUTTON**
						
					     // Creation and initialization of button
						 backButton= new JButton("Back To Search Screen");
						 backButton.setActionCommand("Back");
			             ButtonListener bb= new ButtonListener();
						 backButton.addActionListener(bb);     // sends signal that user pressed the button
				         contentPane.add(backButton);
				
		     // finalizing content pane
			    this.pack();
		        this.setSize(500, 600);
		        this.setVisible(true);
		        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 
		
			 
		 }


		 
		 class ButtonListener implements ActionListener {
			 
			 
				
				public void actionPerformed(ActionEvent e) {
					
					// checks which of the two buttons was pressed "Find" or "Back"
					 String choice = e.getActionCommand();
					 
					 
					 // if it was the find button
					if (choice.equals("Find")) {
					    DefaultListModel model2= new DefaultListModel();   //creates new model
					    String OGNum= snum.getText();                     // gets the number that was given
					    
					    
					    //creation of two new ArrayLists to store the SMSs
					    ArrayList<String> AllSmss= new ArrayList<String>();
					    ArrayList<SMS> listOfMessages= new	ArrayList<SMS>();
					
					    for (int index=0; index< nums.size(); index++ ) { //for all the messages between the number given and all of our main suspect's numbers
					                listOfMessages=regi.getMessagesBetween( OGNum, nums.get(index));                  // the list of messages is saved in an arrayList
					                       for(SMS sms: listOfMessages)                                 // For all the SMS elements that were save, we save only the messages that were included
						                         AllSmss.add(sms.getText());         //we add the text messages in another arraylist
				    	
					    }
					
					    if (AllSmss.isEmpty())            // If there are no messages between the suspect and the phone number "None" is saved
						    AllSmss.add("NONE");
				
					 // formatting of the string, saving messages in a  table and adding them in a model 
					   String str= (AllSmss.toString().replace("[", " ")).replace("]", "");
					   String[] mess= str.split(","); 
					   for (int index = 0; index < mess.length; index++) {
							nums.add(mess[index]);
						    model2.addElement(mess[index]);
						}
					    
						 
					
						SMSs.setModel(model2);   //Setting the model for the all the messages
					   
					   
					
					}
					 // if it was the back button
					else if (choice.equals("Back")) {
						
						Frame fr= new Frame(regi);  // creates a new frame "Find Suspect"
						dispose();                  // closes current window
					
				}
				}	
				}
				
				
				
				
					
					
				


}
