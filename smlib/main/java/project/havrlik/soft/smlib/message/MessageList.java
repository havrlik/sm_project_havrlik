package main.java.project.havrlik.soft.smlib.message;

import main.java.project.havrlik.soft.smlib.other.MarkLabelStringEtc;
import main.java.project.havrlik.soft.smlib.smlist.SmList_1D_String;
import main.java.project.havrlik.soft.smlib.smlist.SmList_Size;

/**
 * Using for hold messages.
 * 
 * Standart format:
 * - First row contains placement, usualy class and method name.
 * - Other rows contains message. They are with padding.
 * - When is added another block of messages, whole block with padding.
 */

public class MessageList {
	
	private SmList_1D_String list;
	
	public static final String PADDING_no = MarkLabelStringEtc.CHARS_emptyString;
	public static final String PADDING_smaller = MarkLabelStringEtc.CHARS_spaces4;
	public static final String PADDING_bigger = MarkLabelStringEtc.CHARS_spaces8;
	public static final String PLACEMENT = "PLACEMENT:  ";
//	public static final String MESSAGE = "Message:  ";
//	public static final String EXCEPTION = "Exception:  ";
	public static final String CONSTRUCTOR = "-constructor-";
	
	
	public MessageList() {
		list = new SmList_1D_String(SmList_Size.TINY_16);
	}
	
	
	public MessageList(String placement) {
		list = new SmList_1D_String(SmList_Size.TINY_16);
		
		addPlacement(placement);
	}
	
	
	public MessageList(Class<?> clazz, String methodName) {
		list = new SmList_1D_String(SmList_Size.TINY_16);
		
		addPlacement(clazz, methodName);
	}
	
	
	public MessageList(String placement, String ... messages) {
		list = new SmList_1D_String(SmList_Size.TINY_16);
		
		add(placement, messages);
	}
	
	
	public MessageList(Class<?> clazz, String methodName, String ... messages) {
		list = new SmList_1D_String(SmList_Size.TINY_16);
		
		add(clazz, methodName, messages);
	}
	
	
	public MessageList add(String placement, String ... messages) {
		addPlacement(placement);
		addFurtherMessages(messages);
		
		return this;
	}
	
	
	public MessageList add(Class<?> clazz, String methodName, String ... messages) {
		addPlacement(clazz, methodName);
		addFurtherMessages(messages);
		
		return this;
	}
	
	
	public MessageList add_singleMessages(String ... messages) {
		if (list.size() == 0) {
			list.addValue(messages[0]);
			for (int i1 = 1; i1 < messages.length; i1++) {
				list.addValue(PADDING_bigger + messages[i1]);
			}
		}
		else {
			list.addValue(PADDING_bigger + messages[0]);
			for (int i1 = 1; i1 < messages.length; i1++) {
				list.addValue(PADDING_bigger + PADDING_bigger + messages[i1]);
			}
		}
		
		return this;
	}
	
	
	private MessageList addFurtherMessages(String ... messages) {
		for (int i1 = 0; i1 < messages.length; i1++) {
			list.addValue(PADDING_bigger + messages[i1]);
		}
		
		return this;
	}
	
	
	public MessageList add_wholeBlock(MessageList messages) {
		for (int i1 = 0; i1 < messages.size(); i1++) {
			list.addValue(PADDING_smaller + messages.get_list().getValue(i1));
		}
		
		return this;
	}
	
	
	public SmList_1D_String get_list() {
		return list;
	}
	
	
	public int size() {
		return list.size();
	}
	
	
	public static String assemblePlacement(Class<?> clazz, String methodName) {
		return PLACEMENT + clazz.getName() + " . " + methodName + "()";
	}
	
	
	private void addPlacement(String placement) {
		list.addValue(PLACEMENT + placement);
	}
	
	
	private void addPlacement(Class<?> clazz, String methodName) {
		list.addValue(assemblePlacement(clazz, methodName));
	}

}
