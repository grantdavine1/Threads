import javax.swing.JOptionPane;

public class ReadThread extends Thread{
		
	private String l71 = "";
	
	
	private MTqueue queue;
		
	
	public ReadThread(MTqueue q){
		this.queue = q;
	}
		

	public void insertStr(){
		queue.MTPut(getl71());
	}
		
		
	@Override
	public void run(){
		
		String Description = "";
		int recLocation = 0;
		String where = "0";
		String cmd = "start";
		
		
		while (cmd.compareToIgnoreCase("end") != 0 ){
					
					cmd = JOptionPane.showInputDialog(null, "Please input a command:");
					l71 = "";
					
					if(cmd.compareToIgnoreCase("end") == 0){
						l71 = "END";
						System.out.println(l71);
					}
					
				    if (cmd.compareToIgnoreCase("new") == 0){
				    	// Command is "new"  -  user wants to make a new record
				    	
				    	//ID 5 charas
				    	int temp = 0;
				    	try{
				    		Description = JOptionPane.showInputDialog(null, "Please input an ID between 1 and 20: ");
					    	temp = Integer.parseInt(Description);
					    	while(temp > 20 || temp <= 0){
					    		Description = JOptionPane.showInputDialog(null, "Please reinput an ID between 1 and 20: ");
					    		temp = Integer.parseInt(Description);
					    	}
					    	while(Description.length() < 5){
					    		Description += " ";
					    	}
					    	assert Description.length() == 5;
					    	l71 += Description;
				    	}
				    	catch(NumberFormatException ex){
				    		System.out.println("Try again. (Incorrect input: an integer is required)");
				    		while(1 == 1){
				    			try{
				    				Description = JOptionPane.showInputDialog(null, "Please input an ID between 1 and 20: ");
		
							    	temp = Integer.parseInt(Description);
							    	while(temp > 20 || temp <= 0){
							    		Description = JOptionPane.showInputDialog(null, "Please reinput an ID between 1 and 20: ");
							    		temp = Integer.parseInt(Description);
							    	}
							    	while(Description.length() < 5){
							    		Description += " ";
							    	}
							    	l71 += Description;
								    break;
							    	
							    	
				    			}
				    			catch(NumberFormatException ex2){
				    				System.out.println("Try again. (Incorrect input: an integer is required)");
				    			}
				    		}
				    	}
		
							
				    	
				    	//name 26 charas
				    	Description = JOptionPane.showInputDialog(null, "Please input a name: ");
				    	String tempStr = "";
				    	if(Description.length() > 26){
				    		tempStr = Description.substring(0, 26);
				    		Description = tempStr;
				    	}
				    	else{
				    		while(Description.length() != 26){
					    		Description += " ";
					    	}
				    	}
				    	assert Description.length() == 26;
				    	l71 += Description;
				    	
				    	//team name 26 charas
				    	Description = JOptionPane.showInputDialog(null, "Please input a team name: ");
				    	if(Description.length() > 26){
				    		tempStr = Description.substring(0, 26);
				    		Description = tempStr;
				    	}
				    	else{
				    		while(Description.length() != 26){
					    		Description += " ";
					    	}
				    	}
				    	assert Description.length() == 26;
				    	l71 += Description;
				    	
				    	
				    	//skill lv 5 charas
				    	try{
				    		Description = JOptionPane.showInputDialog(null, "Please input a skill level: ");
				    		int temp1 = Integer.parseInt(Description);
				    		while(temp1 > 99 || temp1 < 0){
					    		Description = JOptionPane.showInputDialog(null, "Please reinput an skill level between 0 and 99: ");
					    		temp1 = Integer.parseInt(Description);
					    	}
					    	while(Description.length() < 5){
					    		Description += " ";
					    	}
					    	assert Description.length() == 5;
					    	l71 += Description;
				    	}
				    	catch(NumberFormatException ex){
				    		System.out.println("Try again. (Incorrect input: an integer is required)");
				    		while(1 == 1){
				    			try{
					    			Description = JOptionPane.showInputDialog(null, "Please reinput a skill level: ");
					    			int temp1 = Integer.parseInt(Description);
						    		while(temp1 > 99 || temp1 < 0){
							    		Description = JOptionPane.showInputDialog(null, "Please reinput an skill level between 0 and 99: ");
							    		temp1 = Integer.parseInt(Description);
							    	}
							    	while(Description.length() < 5){
							    		Description += " ";
							    	}
							    	assert Description.length() == 5;
							    	l71 += Description;
							    	break;
					    		}
					    		catch(NumberFormatException ex2){
					    			System.out.println("Try again. (Incorrect input: an integer is required)");
					    		}
				    		}
				    		
				    		
				    	}
				    	
				    	
				    	//draft date 9 charas
				    	Description = JOptionPane.showInputDialog(null, "Please input today's date: ");
				    	if(Description.length() > 9){
				    		tempStr = Description.substring(0, 9);
				    		Description = tempStr;
				    	}
				    	l71 += Description;
		
				    	recLocation = temp;
				    	
						if (recLocation == 0){
							recLocation = 1;
						}
						
						
						insertStr();
						System.out.println("Update is scheduled");
				    }
				    
				    
			}
		
			
		
	}
	
	public String getl71(){
		return l71;
	}
	
}

