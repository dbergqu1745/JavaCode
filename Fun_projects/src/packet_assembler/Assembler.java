package packet_assembler;

import java.util.ArrayList;
import java.util.Scanner;
//import java.nio.file.*;


public class Assembler {
	
	/*
	 * TODO:
	 * Reads disorganized packets from console into ArrayList of messages.
	 * 
	 * Example line:
	 * 2997    0   19  Did you ever hear the tragedy of Darth
	 *  ID    ind  msg             String
	 *             length
	 * Checks incoming ID against IDs of messages already present in Messages.
	 * If ID is present, add the string to the list of strings in the correct
	 * index. Else, add a new message to the messages with the ID
	 * 
	 * 
	 */
	public ArrayList<Message> read() {
		Scanner in = new Scanner(System.in);
		ArrayList<Message> messages = new ArrayList<Message>(1); 
		
		int ID;
		int index;
		int msgSize;
		String txt;
		
		while (in.hasNext()) {
			System.out.println("While Entered");
			ID = in.nextInt();
			System.out.println(ID);
			index = in.nextInt();
			System.out.println(index);
			msgSize = in.nextInt();
			System.out.println(msgSize);
			txt = in.nextLine();
			System.out.println(txt);
			
			System.out.println(ID + '\t' + index + '\t' + msgSize + '\t' + txt);

//			for (int i = 0; i < messages.size(); i++) {
//				System.out.println("For entered");
//				if (messages.get(i).messageID == ID) {
//					System.out.println("If entered");
//					messages.get(i).text.add(index, txt);
//				} else {
//					System.out.println("Else entered");
//					messages.add(new Message(ID, msgSize, index, txt));
//					break;
//				}
//			}
		}
		
		in.close();
		return messages;
	}
	
	/*
	 * TODO:
	 * prints messages from an arraylist of messages
	 * iterates through outer to get the message ID
	 * then iterates through the inner to print the info formatted correctly:
	 * 2997    0   19  Did you ever hear the tragedy of Darth
	 *  ID   ind   len            String
	 */
	public void printMessages(ArrayList<Message> messages) {
		int outerLen = messages.size();
		int innerLen;
		int msgID;
		
		for (int i = 0; i < outerLen; i++) {
			innerLen = messages.get(i).messageSize;
			msgID = messages.get(i).messageID;
			for (int j = 0; j < innerLen; j++) {
				System.out.println(msgID + "\t" + j + "\t" + (innerLen + 1) + messages.get(i).text.get(j));
			}
		}
	}
	
	public static void main(String[] args) {
		Assembler a = new Assembler();
		ArrayList<Message> messages = a.read();
		a.printMessages(messages);
	}
	
}
