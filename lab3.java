import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JOptionPane;

public class lab3 {

		// Number of records in the file.
	final private static int MAX_RECORD_NUMBER = 20;
			// Size of record.
	final private static int RECORD_LENGTH = 71;
	
	
	private static String fileLoc;
	
	private static MTqueue queue;
		
	private static boolean isReadDead;
	
	public static void main(String[] args) throws FileNotFoundException, IOException{
		// TODO Auto-generated method stub

		
		//asking for file loc and or create new file
		String fileName = "";
		fileName = JOptionPane.showInputDialog(null, "Please input the file location with file name: ");
//		File loc = new File("D:\\Users\\workspace\\116 Lab 3\\demoLab3.txt");
		File loc = new File(fileName);
		fileLoc = fileName;
		try {
			RandomAccessFile store = new RandomAccessFile(loc, "rw");
			
			String Dummy = "No record exsit here yet";
			while(Dummy.length() < 71){
				Dummy += " ";
			}

			store.seek(0);
			try{
				store.readUTF();			
			}
			catch(EOFException ex){
				for (int i = 0; i < lab3.getMaxRecordNum(); ++i){
					store.writeUTF(Dummy);	// Fill file with dummy records.
				}
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				

		
		queue = new MTqueue();
		UpdateThread updateThread = new UpdateThread(queue);
		ReadThread readThread = new ReadThread(queue);
		
		//start threads
		updateThread.start();
		readThread.start();	
		isReadDead = false;
		while((readThread.isAlive())){
			//just wait until readThread dies
		}
		isReadDead = true;
		
	}
	
	public static int getMaxRecordNum(){
		return MAX_RECORD_NUMBER;
	}
	
	public static int getRecordLength(){
		return RECORD_LENGTH;
	}
	
	public static String getFileLoc(){
		return fileLoc;
	}
	
	public static boolean isReadDead(){
		return isReadDead;
	}

}
