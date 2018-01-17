import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JOptionPane;


public class UpdateThread extends Thread {

	
	private RandomAccessFile store;
	private MTqueue queue;
	
	private String processStr = "";
	
	public UpdateThread(MTqueue q){
		this.queue = q;
	}
	
	public void getString(){
		processStr = queue.MTGet();
	}
	
	@Override
	public void run(){
		
		try {
			store = new RandomAccessFile(lab3.getFileLoc(), "rw");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		while(1 == 1){
			
			getString();
			if(!(processStr == null)){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try{
					
					if(processStr.length() > 2){
						String temp = processStr.substring(0, 2);
						
						
						try{
							int recLocation = Integer.parseInt(temp.trim());
							store.seek((lab3.getRecordLength() + 2) * (recLocation - 1));  
							store.writeUTF(processStr);
							store.seek((lab3.getRecordLength() + 2) * (recLocation - 1));  
							String str = store.readUTF();
							System.out.println(str + " ...this is the readUTF");
						}
						catch(IOException ex){
							// do nothing
							System.out.println("IO Excep");
							
						}
						catch(NumberFormatException ex2){
							
						}

					}
					
					
				}
				catch(NullPointerException ex1){
					// do nothing
				}
				
			}
			
			if(lab3.isReadDead()){
				break;
			}

		}
		

	}
	
}
