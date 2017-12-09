package packet_assembler;

import java.util.ArrayList;

public class Message {
	//The ID corresponding to the message
	protected int messageID;
	//The size of the message
	protected int messageSize;
	//Integer is index within message, String is line of text
	protected ArrayList<String> text;

	public Message(int id, int len, int ind, String txt) {
		messageID = id;
		messageSize = len;
		text = new ArrayList<String>(len);
		text.add(ind, txt);
	}
	
	/*
	 * TODO:
	 * Takes message object and sorts the indTexts by index
	 */
	public static void sort() {
		
	}
}
