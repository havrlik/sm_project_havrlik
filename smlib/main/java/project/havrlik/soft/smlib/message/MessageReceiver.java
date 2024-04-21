package main.java.project.havrlik.soft.smlib.message;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import main.java.project.havrlik.soft.smguiswing.listener.MessagesListener_Interface;
import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.data.Data;
import main.java.project.havrlik.soft.smlib.data.Data_StringSmList;
import main.java.project.havrlik.soft.smlib.file.DirectoriesAndFiles;
import main.java.project.havrlik.soft.smlib.other.MarkLabelStringEtc;
import main.java.project.havrlik.soft.smlib.other.TimeType;
import main.java.project.havrlik.soft.smlib.other.ValuePerform;
import main.java.project.havrlik.soft.smlib.smlist.SmList_1D_String;
import main.java.project.havrlik.soft.smlib.smlist.SmList_2D_String;
import main.java.project.havrlik.soft.smlib.smlist.SmList_Size;

/**
 * messageType: viz list 'list_messageTypes' in class MessageType_Lists.
 *
 */

/*

System.out.println(this.getClass().getSimpleName() + "      ");


0)
Deprecated, DEL.

//messageReceiver.message(MessageType., "-PLACEMENT-  " + this.getClass().getName() + " . ()", 
//		"");
//
//// Exception:
//messageReceiver.message(MessageType., "-PLACEMENT-  " + this.getClass().getName() + " . ()", 
//		":  " + ex.toString());
//		":  '" + ex.toString() + "'.");


1)
Method message() receiving message tyme, and notes, where first record have to be placement.
If constructor, include to placement 'MessageList.CONSTRUCTOR', otherwise insert method name without brackets as string.

messageReceiver.message(
		MessageType., 
		MessageList.assemblePlacement(this.getClass(), ""), 
		"");

// Exception:
messageReceiver.message(
		MessageType., 
		MessageList.assemblePlacement(this.getClass(), ""), 
		":  '" + ex.toString() + "'.");


2)
Note get method name throws exception at constructor, insert string instead.

messageReceiver.message(
		MessageType., 
		MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
		"");

// Exception:
messageReceiver.message(
		MessageType., 
		MessageList.assemblePlacement(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName()), 
		":  '" + ex.toString() + "'.");


3)

messageReceiver.message(
		MessageType., 
		this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
		"");

// Exception:
messageReceiver.message(
		MessageType., 
		this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
		":  '" + ex.toString() + "'.");



MessageList process_messages = new MessageList(this.getClass(), "", 
		"");

MessageList process_messages = new MessageList(this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
		"");

failMessages.add_wholeBlock();

messageReceiver.message(MessageType., process_messages);



// Values which returning methods of the exception:
e1.printStackTrace();  // Returns void. Prints stack trace to console, as uncatched exception does.
e1.getMessage()  // Returns e.g. '4'.
e1.getCause()  // 
e1.toString()  // Returns e.g. 'java.lang.ArrayIndexOutOfBoundsException: 4'.
e1.getStackTrace();  // ??

Get line of exception:
			String aa = "Problem Exception. " + e.getMessage() + " " + e.getCause();
			int size = e.getStackTrace().length - 1;
			String aa2 = "    Root cause: " + e.getStackTrace()[size].getMethodName() + " " + e.getStackTrace()[size].getClassName();
			if (size > 1) { 
				String aa3 = "    method=" + e.getStackTrace()[size-1].getMethodName() + " class=" + e.getStackTrace()[size-1].getClassName() + " line=" + e.getStackTrace()[size-1].getLineNumber();
			}

e1.getClass().getSimpleName() + ":  " + e1.toString()  // Returns class name of catched exception, also when is catching Exception.
E.g. 'ArrayIndexOutOfBoundsException:  java.lang.ArrayIndexOutOfBoundsException: 4'.


this.getClass().getName()  // Returns e.g. 'main.java.project.havrlik.soft.sm.Playground'.
this.getClass().getSimpleName()  // Returns e.g. 'Playground'.

 */

public class MessageReceiver {
	
	protected SmLib smLib;
//	public MessageType_Lists messageType_Lists;

	protected SimpleDateFormat sdf_date;
	protected SimpleDateFormat sdf_time;
	protected SimpleDateFormat sdf_dateTime;
	protected String last_date = "";
	protected String last_time = "";
//	String last_dateTime = "";
	
	protected MessageType messageType;  // Columns: ID ; priority ; 
	protected SmList_2D_String list_messages;  // [XX][0] = line number ; [XX][1] = time ; [XX][2] = type ; [XX][3 and other] = text messages ;
	protected int list_messages_maxSize = 200_000;
	protected String[] table_messages_columnNames;
	protected int[] table_messages_columnWidth;
	protected String[][] table_messages;
	protected int table_messages_maxSize = 5_000;
	protected boolean list_messages_tooBig = false;
	protected boolean isNewUnseenMessage = false;
	
	protected TimeType addEmptyRow_movingTimeType = TimeType.m;
	protected int addEmptyRow_movingTimeLength = +59;
	
	
	public MessageReceiver(SmLib smLib) {
		this.smLib = smLib;
		
        sdf_date = new SimpleDateFormat("yyyyMMdd");
        sdf_time = new SimpleDateFormat("HHmmss");
        sdf_dateTime = new SimpleDateFormat("yyyyMMdd  HHmmss  SSS");
		
		list_messages = new SmList_2D_String(4, SmList_Size.SMALL_512);
		table_messages_columnNames = new String[] {"Line", "Date time", "Type", "Message"};
		table_messages_columnWidth = new int[] {40, 150, 150, 2000};
		
		Calendar calendar = Calendar.getInstance();
		last_date = sdf_date.format(calendar.getTime());
		last_time = sdf_time.format(calendar.getTime());
		addRowToMessageList(new String[] {MarkLabelStringEtc.CHARS_dashes8, "", ""});
		
		call_constructorContinues();
	}
	
	
	protected void call_constructorContinues() {
		// Recommended to disable this method by overriding by empty method in your sub class 
		// and call method bellow at the end of your constructor.
		constructorContinues();
	}
	
	
	protected void constructorContinues() {
		constructor3();
		constructor4_sub();
		constructor5();
		constructor6_sub();
	}
	
	
	protected void constructor3() {  }
	protected void constructor4_sub() {  }
	protected void constructor5() {  }
	protected void constructor6_sub() {  }
	
	
	public void setup1() {  }
	public void setup2_sub() {  }
	public void setup3() {  }
	public void setup4_sub() {  }
	
	
	public void message(MessageType messageType, String ... notes) {
		performMessage(messageType, array_paddingFromSecond(notes));
	}
	public void message(MessageType messageType, Class<?> clazz, String ... notes) {
		performMessage(messageType, array_paddingFromSecond(clazz, notes));
	}
//	public void message(MessageType messageType, ArrayList<String> notes) {
//		performMessage(messageType, toArray(notes));
//	}
	public void message(MessageType messageType, MessageList notes) {
		performMessage(messageType, toArray(notes));
	}
	
	
//	public void message(MessageType messageType, Class<?> type, String methodName, String ... notes) {
//		// notes: [0] placement ; [1] name of method ; [2 and other] notes ; 
//		performMessage(messageType, array_paddingFromSecond(true, notes));
//	}
	
	
	public void n1_fatal(String ... notes) {
		performMessage(MessageType.N1_FATAL, array_paddingFromSecond(notes));
	}
	public void n1_fatal(Class<?> clazz, String ... notes) {
		performMessage(MessageType.N1_FATAL, array_paddingFromSecond(clazz, notes));
	}
//	public void n1_fatal(ArrayList<String> notes) {
//		performMessage(MessageType.N1_FATAL, toArray(notes));
//	}
	public void n1_fatal(MessageList notes) {
		performMessage(MessageType.N1_FATAL, toArray(notes));
	}
	
	
	public void n2_error(String ... notes) {
		performMessage(MessageType.N2_ERROR, array_paddingFromSecond(notes));
	}
	public void n2_error(Class<?> clazz, String ... notes) {
		performMessage(MessageType.N2_ERROR, array_paddingFromSecond(clazz, notes));
	}
//	public void n2_error(ArrayList<String> notes) {
//		performMessage(MessageType.N2_ERROR, toArray(notes));
//	}
	public void n2_error(MessageList notes) {
		performMessage(MessageType.N2_ERROR, toArray(notes));
	}
	
	
	public void n3_fail(String ... notes) {
		performMessage(MessageType.N3_FAIL, array_paddingFromSecond(notes));
	}
	public void n3_fail(Class<?> clazz, String ... notes) {
		performMessage(MessageType.N3_FAIL, array_paddingFromSecond(clazz, notes));
	}
//	public void n3_fail(ArrayList<String> notes) {
//		performMessage(MessageType.N3_FAIL, toArray(notes));
//	}
	public void n3_fail(MessageList notes) {
		performMessage(MessageType.N3_FAIL, toArray(notes));
	}
	
	
	public void n4_warn(String ... notes) {
		performMessage(MessageType.N4_WARN, array_paddingFromSecond(notes));
	}
	public void n4_warn(Class<?> clazz, String ... notes) {
		performMessage(MessageType.N4_WARN, array_paddingFromSecond(clazz, notes));
	}
//	public void n4_warn(ArrayList<String> notes) {
//		performMessage(MessageType.N4_WARN, toArray(notes));
//	}
	public void n4_warn(MessageList notes) {
		performMessage(MessageType.N4_WARN, toArray(notes));
	}
	
	
	public void n11_info(String ... notes) {
		performMessage(MessageType.N11_INFO, array_paddingFromSecond(notes));
	}
	public void n11_info(Class<?> clazz, String ... notes) {
		performMessage(MessageType.N11_INFO, array_paddingFromSecond(clazz, notes));
	}
//	public void n11_info(ArrayList<String> notes) {
//		performMessage(MessageType.N11_INFO, toArray(notes));
//	}
	public void n11_info(MessageList notes) {
		performMessage(MessageType.N11_INFO, toArray(notes));
	}
	
	
	public void n12_infoNoRefer(String ... notes) {
		performMessage(MessageType.N12_INFONOREFER, array_paddingFromSecond(notes));
	}
	public void n12_infoNoRefer(Class<?> clazz, String ... notes) {
		performMessage(MessageType.N12_INFONOREFER, array_paddingFromSecond(clazz, notes));
	}
//	public void n12_infoNoRefer(ArrayList<String> notes) {
//		performMessage(MessageType.N12_INFONOREFER, toArray(notes));
//	}
	public void n12_infoNoRefer(MessageList notes) {
		performMessage(MessageType.N12_INFONOREFER, toArray(notes));
	}
	
	
	public void n13_app(String ... notes) {
		performMessage(MessageType.N13_APP, array_paddingFromSecond(notes));
	}
	public void n13_app(Class<?> clazz, String ... notes) {
		performMessage(MessageType.N13_APP, array_paddingFromSecond(clazz, notes));
	}
//	public void n13_app(ArrayList<String> notes) {
//		performMessage(MessageType.N13_APP, toArray(notes));
//	}
	public void n13_app(MessageList notes) {
		performMessage(MessageType.N13_APP, toArray(notes));
	}
	
	
	public void n14_user(String ... notes) {
		performMessage(MessageType.N14_USER, array_paddingFromSecond(notes));
	}
	public void n14_user(Class<?> clazz, String ... notes) {
		performMessage(MessageType.N14_USER, array_paddingFromSecond(clazz, notes));
	}
//	public void n14_user(ArrayList<String> notes) {
//		performMessage(MessageType.N14_USER, toArray(notes));
//	}
	public void n14_user(MessageList notes) {
		performMessage(MessageType.N14_USER, toArray(notes));
	}
	
	
	public void n21_another(String ... notes) {
		performMessage(MessageType.N21_ANOTHER, array_paddingFromSecond(notes));
	}
	public void n21_another(Class<?> clazz, String ... notes) {
		performMessage(MessageType.N21_ANOTHER, array_paddingFromSecond(clazz, notes));
	}
//	public void n21_another(ArrayList<String> notes) {
//		performMessage(MessageType.N21_ANOTHER, toArray(notes));
//	}
	public void n21_another(MessageList notes) {
		performMessage(MessageType.N21_ANOTHER, toArray(notes));
	}
	
	
	public void n91_developer(String ... notes) {
		performMessage(MessageType.N91_DEVELOPER, array_paddingFromSecond(notes));
	}
	public void n91_developer(Class<?> clazz, String ... notes) {
		performMessage(MessageType.N91_DEVELOPER, array_paddingFromSecond(clazz, notes));
	}
//	public void n91_developer(ArrayList<String> notes) {
//		performMessage(MessageType.N91_DEVELOPER, toArray(notes));
//	}
	public void n91_developer(MessageList notes) {
		performMessage(MessageType.N91_DEVELOPER, toArray(notes));
	}
	
	
	public void n92_fast(String ... notes) {
		performMessage(MessageType.N92_DEVELOPER_FAST, array_paddingFromSecond(notes));
	}
	public void n92_fast(Class<?> clazz, String ... notes) {
		performMessage(MessageType.N92_DEVELOPER_FAST, array_paddingFromSecond(clazz, notes));
	}
//	public void n92_fast(ArrayList<String> notes) {
//		performMessage(MessageType.M92_DEVELOPER_FAST, toArray(notes));
//	}
	public void n92_fast(MessageList notes) {
		performMessage(MessageType.N92_DEVELOPER_FAST, toArray(notes));
	}
	
	
	public void message(MessageType messageType, MessageList processMessagesAdd, Class<?> clazz, String methodName, String ... notes) {
		MessageList process_failMessages = new MessageList(clazz, methodName, notes);
		process_failMessages.add_wholeBlock(processMessagesAdd);
		
		performMessage(messageType, toArray(process_failMessages));
	}
	public void message(MessageType messageType, Data data_processMessagesAdd, Class<?> clazz, String methodName, String ... notes) {
		message(messageType, data_processMessagesAdd.getAndClear_processMessages(), clazz, methodName, notes);
	}
	
	
	protected void performMessage(MessageType messageType, String ... notes) {  // notes: [0] placement ; [1 and other] notes ; 
		if (messageType == null) {
			messageType = MessageType.N0_UNKNOWN;
		}
		notes = toArray_notNull(notes);
		addMessage(messageType, notes);
		notifyListeners();
	}
	
	
	private String return_messageType(MessageType messageType) {
		return Integer.toString(messageType.get_id()) + "  " + messageType.get_shortDescription();
	}
	
	
	private String[] toArray_notNull(String[] array) {
		if (array == null) {
			array = new String[] {""};
		}
		
		return array;
	}
	
	
//	private String[] toArray(ArrayList<String> arrayList) {
//		String[] array;
//		
//		if (arrayList == null) {
//			array = null;
//		}
//		else {
//			array = new String[arrayList.size()];
//			for (short s = 0; s < array.length; s++) {
//				array[s] = arrayList.get(s);
//			}
//		}
//		
//		return array;
//	}
	
	
	private String[] toArray(MessageList messageList) {
		String[] array;
		
		SmList_1D_String list = messageList.get_list();
		if (list == null) {
			array = null;
		}
		else {
			array = new String[list.size()];
			for (short s = 0; s < array.length; s++) {
				array[s] = list.getValue(s);
			}
		}
		
		return array;
	}
	
	
	private String[] array_paddingFromSecond(String[] array) {
		for (int i1 = 1; i1 < array.length; i1++) {
			array[i1] = MessageList.PADDING_bigger + array[i1];
		}
		
		return array;
	}
	
	
	private String[] array_paddingFromSecond(Class<?> clazz, String[] array) {
		array[0] = MessageList.assemblePlacement(clazz, array[0]);
		
		return array_paddingFromSecond(array);
	}
	
	
	public String[][] returnRefreshedTableForGui() {
		/*
		 *  Rewrite list to array, and refresh table.
		 */
		
		if (!isNewUnseenMessage) {
			return table_messages;
		}
		isNewUnseenMessage = false;
		
		int list_messages_size = list_messages.size();
		int table_messages_size = list_messages_size;
		if (table_messages_size > table_messages_maxSize) {  // If is list too long, show last table_messages_maxSize rows.
			table_messages_size = table_messages_maxSize;
		}
		table_messages = new String[table_messages_size][3];
		for (int i1 = list_messages_size - table_messages_size; i1 < list_messages_size; i1++) {
			table_messages[i1 - (list_messages_size - table_messages_size)] = list_messages.getRow(i1);
		}
		if (table_messages_size < list_messages_size) {  // When is table cut, add notice.
			String messageType_str = return_messageType(MessageType.N13_APP);
			table_messages[0] = new String[] {"", messageType_str, ""};
			table_messages[1] = new String[] {
					"", messageType_str, "Table cut. You can obtain whole list when you export the list to file."};
			table_messages[2] = new String[] {"", messageType_str, ""};
		}
		
		return table_messages;
	}
	
	
	public void button_insertLabel(String textField1_string) {
		MessageType messageType_user = MessageType.N14_USER;
		String message = "(INSERTED LABEL)  ";
		if (textField1_string == null || textField1_string.length() == 0) {
			message += "(No text.  ---------------------------------------------------------------- )";
		}
		else {
			message += textField1_string;
		}
		addMessage(messageType_user, message);
	}
	
	
	public void button_saveList() {
		MessageType messageType_app = MessageType.N13_APP;
		DirectoriesAndFiles fileFullPath = smLib.fileDialogSm.fileDialog_save_chooseDirectoryAndFileName(null, ".txt");
		if (fileFullPath == null) {
			return;
		}
		addMessage(messageType_app, "Event messages exporting.");
		
		Data_StringSmList data = new Data_StringSmList(smLib);
		data.initContent(SmList_Size.SMALL_512);
		
		data.addRow("");
		data.addRow("SM App: event messages exported into file '" + fileFullPath.getSingle_fileInDirectory() + 
				"', at '" + sdf_dateTime.format(Calendar.getInstance().getTime()) + "'.");
		data.addRow("");
		for (int i1 = 0; i1 < list_messages.size(); i1++) {
			String row = 
					ValuePerform.textFile_insertPrefixBeforeKeyCharacters(list_messages.getValue(i1, 0)) + 
					";" + ValuePerform.textFile_insertPrefixBeforeKeyCharacters(list_messages.getValue(i1, 1)) + 
					";" + ValuePerform.textFile_insertPrefixBeforeKeyCharacters(list_messages.getValue(i1, 2)) + 
					";" + ValuePerform.textFile_insertPrefixBeforeKeyCharacters(list_messages.getValue(i1, 3));
			if (row.length() < 3) {
				row = "";
			}
			data.addRow(row);
		}
		data.addRow("");
		
		data.set_fileDirectory(fileFullPath.getSingle_directory());
		data.set_fileName(fileFullPath.getSingle_fileInDirectory());
		data.set_processResult_success();
		Data_StringSmList result = smLib.fileIo.write_smList1DString(data);
		if (result.isFailed()) {
			addMessage(messageType_app, "Event messages export: mistake: '" + result.rowNumber_fileOverall + "'.");
		}
		else {
			addMessage(messageType_app, "Event messages exported rows: '" + result.rowNumber_fileOverall + "'.");
		}
	}
	
	
	protected void addMessage(MessageType messageType, String ... messages) {
		isNewUnseenMessage = true;
		if (messageType == null) {
			messageType = MessageType.N0_UNKNOWN;
		}
		this.messageType = messageType;
		String dateTime = sdf_dateTime.format(Calendar.getInstance().getTime());
		String messageType_str = return_messageType(messageType);
		
		if (list_messages.size() > list_messages_maxSize) {
			if (!list_messages_tooBig) {
				String messageType_app_str = return_messageType(MessageType.N13_APP);
				list_messages_tooBig = true;
				table_messages[0] = new String[] {"", messageType_app_str, ""};
				table_messages[1] = new String[] {
						dateTime, 
						messageType_app_str, 
						"Adding messages stopped. Too big list size."};
				table_messages[2] = new String[] {"", messageType_app_str, ""};
			}
			return;
		}
		
		Calendar calendar = Calendar.getInstance();
		String current_date = sdf_date.format(calendar.getTime());
		String current_time = sdf_time.format(calendar.getTime());
		// Add empty row when:
		if (!current_date.equals(last_date)) {  // When event at new day, add new date and empty row.
			last_date = current_date;
			addRowToMessageList(new String[] {"", "", ""});
			addRowToMessageList(new String[] {"", "", ""});
			addRowToMessageList(new String[] {current_date, return_messageType(MessageType.N13_APP), "New day"});
			addRowToMessageList(new String[] {"", "", ""});
		}
		else {
			int compareTime = Integer.parseInt(smLib.timePerform.return_datePlusTimeLength(
					last_time, addEmptyRow_movingTimeType, addEmptyRow_movingTimeLength));
			if (Integer.parseInt(current_time) > compareTime && 
					compareTime < addEmptyRow_movingTimeLength) {
				// When new message time is more then certain time length (e.g. 10 s) then last message, add empty row.
				addRowToMessageList(new String[] {"", "", ""});
			}
		}
		last_time = current_time;
		
		// Add messages to rowData_arrayList.
		if (messages == null) {
			addRowToMessageList(new String[] {dateTime, messageType_str, "(Message not received.)"});
		}
		else {
			int numberOfMessages = messages.length;
			if (numberOfMessages == 0) {
				addRowToMessageList(new String[] {dateTime, messageType_str, "(Received empty message.)"});
			}
			else if (numberOfMessages == 1) {
				addRowToMessageList(new String[] {dateTime, messageType_str, messages[0]});
			}
			else if (numberOfMessages > 1) {
				addRowToMessageList(new String[] {dateTime, messageType_str, messages[0]});
				for (int i1 = 1; i1 < numberOfMessages; i1++) {
					addRowToMessageList(new String[] {"", "", messages[i1]});
				}
			}
		}
	}
	
	
	protected void addRowToMessageList(String[] rowWith3Items) {
		list_messages.addRow_shallow(new String[] {
				Integer.toString(list_messages.size()), 
				rowWith3Items[0], 
				rowWith3Items[1], 
				rowWith3Items[2]
		});
	}
	
	
	public SmList_2D_String return_list_messages() { return list_messages; }
	public MessageType return_messageType() { return messageType; }
	public String[] return_table_messages_columnNames() { return table_messages_columnNames; }
	public int[] return_table_messages_columnWidth() { return table_messages_columnWidth; }
	public boolean get_isNewUnseenMessage() { return isNewUnseenMessage; }
	
	
	private List<MessagesListener_Interface> listeners = new ArrayList<MessagesListener_Interface>();
	public void addListener(MessagesListener_Interface toAdd) { listeners.add(toAdd); }
	private void notifyListeners() {
		// Notify everybody that may be interested.
		for (MessagesListener_Interface hl : listeners) {
			hl.messageEvent();
		}
	}
	
}

