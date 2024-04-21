package main.java.project.havrlik.soft.smlib.data;

import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.introduction.Intoduction_CustomValues;
import main.java.project.havrlik.soft.smlib.message.MessageList;
import main.java.project.havrlik.soft.smlib.message.MessageReceiver;
import main.java.project.havrlik.soft.smlib.other.ListPerform;
import main.java.project.havrlik.soft.smlib.other.MarkLabelStringEtc;
import main.java.project.havrlik.soft.smlib.other.ValuePerform;
import main.java.project.havrlik.soft.smlib.smlist.SmList_2DFc_String;

/*
 * Divide name by two underscores '_' and dashes '-'.
 * 
 * Examples of names:
 * dt-aa_bb-cc-dd-ee_ff.txt
 * dt-aa_bb_ff.txt
 * dt-aa_bb-cc^dd'ee-ff_gg.txt
 * E:\xx\yy\dt-aa_bb_cc\  ->  take 'dt-aa_bb_cc'.
 * 
 * Hirearchy of separators: "_", "-". If you need deeper inner parts you can use another separators, e.g. " ' ^ { | } , ", but dividing handle by custom way for your purpose.
 * 'name extension' means here string after first dot in the name.
 * 
 * SM_List_2DFC_String listDataName content:
 * (Numbers bellow meaning: rows in list : columns in row.)
 * 0 : 0 Condition - name successfully divided ("ok" / "nok"), 1 Condition - determined valid certain data name (like SM) ("ok" or "nok"), 
 * 		2 Full data name, 3 Data name without extension, 4 Name extension, if contains; 
 * 1 : 0 First part divided by underscore, 1 and other - parts divided by dash; 
 * 2 : 0 Second part divided by underscore, 1 and other - parts divided by dash; 
 * ...
 */

public class ParseName {
	
	protected SmLib smLib;
	protected ValuePerform valuePerform;
	protected ListPerform listPerform;
	protected MessageReceiver messageReceiver;
	protected MarkLabelStringEtc markLabelStringEtc;
	
	protected String mark_ok;
	protected String mark_nok;
	protected String mark_dash;
	protected String mark_underscore;
	
	protected String notAllowedCharactersAtFirstAndLastIndexOfName = "._-\'^";
	
	protected char platform_slashType;
	
	protected SmList_2DFc_String listDataName;
	
	protected MessageList processMessages;
	
	
	public ParseName(SmLib smLib) {
		mutualConstructor(smLib);
	}
	
	
	public ParseName(SmLib smLib, String dataName) {
		mutualConstructor(smLib);
		
		list_divideName(dataName);
	}
	
	
	protected void mutualConstructor(SmLib smLib) {
		this.smLib = smLib;
		valuePerform = smLib.valuePerform;
		listPerform = smLib.listPerform;
		messageReceiver = smLib.messageReceiver;
		markLabelStringEtc = smLib.markLabelStringEtc;
		
		mark_ok = MarkLabelStringEtc.MARK_ok;
		mark_nok = MarkLabelStringEtc.MARK_nok;
		mark_dash = MarkLabelStringEtc.CHARS_dash;
		mark_underscore = MarkLabelStringEtc.CHARS_underscore;
		
		platform_slashType = smLib.introduction.get_platform_slashType();
		
		clearList();
	}
	
	
	protected void clearList() {
		clear_processMessages();
		
		listDataName = new SmList_2DFc_String();
		putValue(0, 0, mark_ok);
		putValue(0, 1, mark_dash);
	}
	
	
	public void clear_processMessages() {
		processMessages = new MessageList();
	}
	

	public MessageList get_processMessages() { return processMessages; }
	public MessageList getAndClear_processMessages() {
		MessageList processMessages_temp = this.processMessages;
		clear_processMessages();
		return processMessages_temp;
	}
	
	
	public SmList_2DFc_String get_list_shallow() {
		return listDataName;
	}
	
	
	protected void list_divideName(String dataName) {
		/*
		 * Receiving value: data name "dt-aa_bb-cc-dd-ee_ff.txt", or with whole path.
		 * Note, name extension means here after first 'dot' in the name.
		 */
		clearList();
		if (dataName == null || dataName.length() == 0) {
			setNok_0();
			processMessages.add(
					this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
					"received 'dataName == null || dataName.length() == 0'");
			return;
		}
		
		try {
			// Add values to first row.
			
			// Maybe received whole path, take only last part.
			int removeLastCharacter = 0;
			if (dataName.charAt(dataName.length() - 1) == '/' || dataName.charAt(dataName.length() - 1) == '\\') {
				removeLastCharacter = 1;
			}
			for (int i1 = dataName.length() - 2; i1 >= 0; i1--) {
				if (dataName.charAt(i1) == '/' || dataName.charAt(i1) == '\\') {
					String new_dataName = "";
					for (int i2 = i1 + 1; i2 < dataName.length() - removeLastCharacter; i2++) {
						new_dataName += dataName.charAt(i2);
					}
					dataName = new_dataName;
					removeLastCharacter = 0;
					break;
				}
			}
			if (removeLastCharacter != 0) {
				String new_dataName = "";
				for (int j1 = 0; j1 < dataName.length() - removeLastCharacter; j1++) {
					new_dataName += dataName.charAt(j1);
				}
				dataName = new_dataName;
			}
			putValue(0, 2, dataName);
			
			// Check if "dataName" contain name extension.
			String nameExtension = "";
			String dataName_withoutExtension = "";
			for (int j1 = 0; j1 < dataName.length(); j1++) {
				if (dataName.charAt(j1) == '.') {
					for (int j2 = j1; j2 < dataName.length(); j2++) {
						nameExtension += dataName.charAt(j2);
					}
					break;
				}
				dataName_withoutExtension += dataName.charAt(j1);
			}
			putValue(0, 3, dataName_withoutExtension);
			putValue(0, 4, nameExtension);
			if (dataName_withoutExtension.length() < 1) {
				setNok_0();
				processMessages.add(
						this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
						"'dataName_withoutExtension.length() < 1'");
				return;
			}
			
			// Check allowed characters and their quantity: dataName_withoutDotEnd.
			// Check first and last character.
			if (isContainsCharacter(String.valueOf(dataName_withoutExtension.charAt(0)), notAllowedCharactersAtFirstAndLastIndexOfName)) {
				setNok_0();
				processMessages.add(
						this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
						"'dataName_withoutDotEnd.charAt(0)' not allowed character '" + dataName_withoutExtension.charAt(0) + "'.");
				return;
			}
			if (isContainsCharacter(String.valueOf(dataName_withoutExtension.charAt(dataName_withoutExtension.length() - 1)), 
					notAllowedCharactersAtFirstAndLastIndexOfName)) {
				setNok_0();
				processMessages.add(
						this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
						"'dataName_withoutDotEnd.charAt(dataName_withoutDotEnd.length() - 1)' not allowed character '" + 
						dataName_withoutExtension.charAt(dataName_withoutExtension.length() - 1) + "'.");
				return;
			}
			// Check characters in whole string. Check: dashes and underscores, dots.
			char charAtDataName;
			charAtDataName = dataName_withoutExtension.charAt(0);
			if (charAtDataName == '_' || charAtDataName == '-' || charAtDataName == '.') {
				setNok_0();
				processMessages.add(
						this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
						"Data name 'dataName_withoutExtension' has forbidden character on first.");
				return;
			}
			charAtDataName = dataName_withoutExtension.charAt(dataName_withoutExtension.length() - 1);
			if (charAtDataName == '_' || charAtDataName == '-' || charAtDataName == '.') {
				setNok_0();
				processMessages.add(
						this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
						"Data name 'dataName_withoutExtension' has forbidden character on last position.");
				return;
			}
			for (int charAtDataName_num = 1; charAtDataName_num < dataName_withoutExtension.length() - 1; charAtDataName_num++) {
				charAtDataName = dataName_withoutExtension.charAt(charAtDataName_num);
				if (charAtDataName == '.') {
					setNok_0();
					processMessages.add(
							this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
							"Data name 'dataName_withoutExtension' has forbidden character: dot.");
					return;
				}
				// There are not characters for dividing beside.
				if (
						(charAtDataName == '_' || charAtDataName == '-' || charAtDataName == '.') &&
						(dataName_withoutExtension.charAt(charAtDataName_num + 1) == '_' || 
							dataName_withoutExtension.charAt(charAtDataName_num + 1) == '-' || 
							dataName_withoutExtension.charAt(charAtDataName_num + 1) == '.')
				) {
					setNok_0();
					processMessages.add(
							this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
							"Data name 'dataName_withoutExtension' has characters for dividing beside.");
					return;
				}
			}
			
			// Check allowed characters for filesystem at disks.
			if (!smLib.fileDirectoryAndNameCheck.check_filename_allOk(getValue(0, 2))) {
				setNok_0();
				processMessages.add(
						this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
						"Issue: file name characters, '!smLib.fileDirectoryAndNameCheck.check_filename_allOk(getValue(0, 2))'.");
				return;
			}
			
			// Check allowed characters and their quantity: dotEnd.
			if (nameExtension.length() > 0) {
				if (nameExtension.charAt(0) != 46) {  // 46 '.' dot.
					setNok_0();
					processMessages.add(
							this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
							"'dotEnd.charAt(0)' not allowed character '" + nameExtension.charAt(0) + "'.");
					return;
				}
				if (isContainsCharacter(nameExtension.substring(1), notAllowedCharactersAtFirstAndLastIndexOfName)) {
					setNok_0();
					processMessages.add(
							this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
							"'isContainsCharacter(...)' not allowed character of '" + nameExtension + "'.");
					return;
				}
			}
			
			// Divide dataName by underscore and dashe.
			int position_row_listDataName = 1;
			int position_column_listDataName = 1;
			String generalPartOfDataName = "";
			String partOfGeneralPartOfDataName = "";
			for (int charAtDataName_num = 0; charAtDataName_num < dataName_withoutExtension.length(); charAtDataName_num++) {
				charAtDataName = dataName_withoutExtension.charAt(charAtDataName_num);
				if (charAtDataName != '-' && charAtDataName != '_') {
					generalPartOfDataName += charAtDataName;
					partOfGeneralPartOfDataName += charAtDataName;
				}
				if (charAtDataName == '-') {
					generalPartOfDataName += charAtDataName;
					putValue(position_row_listDataName, position_column_listDataName, partOfGeneralPartOfDataName);
					position_column_listDataName++;
					partOfGeneralPartOfDataName = "";
				}
				if (charAtDataName == '_') {
					putValue(position_row_listDataName, 0, generalPartOfDataName);
					putValue(position_row_listDataName, position_column_listDataName, partOfGeneralPartOfDataName);
					
					position_row_listDataName++;
					position_column_listDataName = 1;
					generalPartOfDataName = "";
					partOfGeneralPartOfDataName = "";
					
				}
			}
			putValue(position_row_listDataName, 0, generalPartOfDataName);
			putValue(position_row_listDataName, position_column_listDataName, partOfGeneralPartOfDataName);
			
			check_nameSuccessfullyDivided();
			// Check valid SM name.
			name_check();
		}
		catch (Exception e) {
			setNok_0();
			processMessages.add(
					this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
					"Exception:  " + e.toString());
			return;
		}
	}
	
	
	protected boolean isContainsCharacter(String first, String second) {
		for (int i1 = 0; i1 < first.length(); i1++) {
			for (int i2 = 0; i2 < second.length(); i2++) {
				if (first.charAt(i1) == second.charAt(i2)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	public void name_check() {
		/*
		 * If inherited, need to be override.
		 * 
		 * Influence variable in list at first row second column.
		 */
		
		putValue(0, 1, mark_ok);  // Before checking, set "ok". In case of invalid data name, set "nok".
		
		try {
		}
		catch (Exception e) {
			setNok_1();
		}
	}
	
	
	void assembleDataName() {
		try {
			String dotEnd = getValue(0, 4);
			if (dotEnd.length() > 1 && !ListPerform.isArrayContainsValue(MarkLabelStringEtc.LIST_fileNameExtensions, dotEnd)) {
				setNok_0();
				setNok_1();
				processMessages.add(
						this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
						"Bad 'dotEnd' inside application:  ", 
						dotEnd);
				return;
			}
			
			String dataName = "";
			String dataName_generalPart = "";
			for (int i1 = 1; i1 < listDataName.size(); i1++) {
				dataName_generalPart = "";
				dataName_generalPart += getValue(i1, 1);
				for (int i2 = 2; i2 < listDataName.get_columnsQuantity(i1); i2++) {
					if (getValue(i1, i2) != null && getValue(i1, i2).length() > 0) {
						dataName_generalPart += mark_dash + getValue(i1, i2);
					}
				}
//				putValue(i1, 0, dataName_generalPart);  // Edited name will be again divided to clean list.
				if (dataName.length() > 0) {
					dataName += mark_underscore;
				}
				dataName += dataName_generalPart;
			}
			
			list_divideName(dataName + dotEnd);
		}
		catch (Exception ex) {
			setNok_0();
			setNok_1();
			processMessages.add(
					this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
					"Exception:  ", 
					ex.toString());
			return;
		}
	}
	
	
	public boolean is_validCertainDataName() {
		if (!is_nameSuccessfullyDivided()) {
			return false;
		}
		return getValue(0, 1).equals(mark_ok);
	}
	public boolean is_validCertainDataName_assembleDataName() {
		assembleDataName();
		return is_validCertainDataName();
	}
	
	
	protected String getValue(int rowNumber, int columnNumber) {
		if (rowNumber >= listDataName.size() || columnNumber >= listDataName.get_columnsQuantity(rowNumber)) {
			return null;
		}
		
		return listDataName.getValue(rowNumber, columnNumber);
	}
	
	
	// Methods determining data name content.
	// General.
	protected void putValue(int rowNumber, int columnNumber, String string) {
		// Check length.
		if (string.length() > Intoduction_CustomValues.defaultFileNameLengthLimit) {
			// Error.
			processMessages.add(
					this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
					"Problem: too long string '" + string + "'.");
			string = "null";
		}
		
		// Check if contains forbidden characters for name part.
		if (rowNumber != 0 && columnNumber != 0) {
			char character = 0;
			for (int i1 = 0; i1 < string.length(); i1++) {
				character = string.charAt(i1);
				if (character == '_' || character == '-' || character == '.') {
					// Error.
					processMessages.add(
							this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
							"Problem: string contains forbidden character in '" + string + "'.");
					string = "null";
				}
			}
		}
		
		// Put to list.
		listDataName.putValue(rowNumber, columnNumber, string);
	}
	
	
	public void clearRow(int rowNumber) {
		listDataName.clearRow(rowNumber);
	}
	
	
	public int size_mainParts() {
		return listDataName.size();
	}
	
	
	public int size_rowsPartsOfName() {
		return listDataName.size() - 1;
	}
	
	
	public int size_itemsAtRow(int rowNumber) {
		return listDataName.get_columnsQuantity(rowNumber);
	}
	
	
	protected void setNok_0() {
		putValue(0, 0, mark_nok);
	}
	
	
	protected void setNok_1() {
		putValue(0, 1, mark_nok);
	}
	
	
	public String get_listItem(int row, int column) {
		return getValue(row, column);
	}
	
	
	public boolean check_nameSuccessfullyDivided() {
		if (listDataName == null) {
			processMessages.add(
					this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
					"'listDataName == null'");
			return false;
		}
		else if (size_mainParts() < 2) {
			processMessages.add(
					this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
					"'size_mainParts() < 2'");
			return false;
		}
		else if (size_itemsAtRow(0) != 5) {
			processMessages.add(
					this.getClass(), (new Object() {}).getClass().getEnclosingMethod().getName(), 
					"'size_itemsAtRow(0) != 5'");
			return false;
		}
		
		return getValue(0, 0).equals(mark_ok);
	}
	
	
	public boolean is_nameSuccessfullyDivided() {
		return getValue(0, 0).equals(mark_ok);
	}
	
	
	public String get_dataName_whole() {
		return getValue(0, 2);
	}
	public String get_dataName_wholeWithoutDotEnd() {
		return getValue(0, 3);
	}
	public String get_dataName_onlyDotEnd() {
		return getValue(0, 4);
	}
	
	
	// Hard set value.
	public void set_listItem(int row, int column, String string) {
		putValue(row, column, string);
	}
	
	
	public void add_item(int rowNumber, String string) {
		/*
		 * Can add notes.
		 * Be careful to use - may set item to reserved place of another item.
		 */
		putValue(rowNumber, size_itemsAtRow(rowNumber), string);
	}
	public void set_dotEnd(String string) { putValue(0, 4, string); }

}
