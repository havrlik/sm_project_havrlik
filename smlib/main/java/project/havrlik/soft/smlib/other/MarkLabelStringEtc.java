package main.java.project.havrlik.soft.smlib.other;

import main.java.project.havrlik.soft.smlib.SmLib;

public class MarkLabelStringEtc {
	
	protected SmLib smLib;
	
	
	public static final String MARK_yes = "yes";
	public static final String MARK_Yes = "Yes";
	public static final String MARK_YES = "YES";
	public static final String MARK_y = "y";
	public static final String MARK_Y = "Y";
	public static final String MARK_no = "no";
	public static final String MARK_No = "No";
	public static final String MARK_NO = "NO";
	public static final String MARK_n = "n";
	public static final String MARK_N = "N";
	public static final String MARK_ok = "ok";
	public static final String MARK_Ok = "Ok";
	public static final String MARK_OK = "OK";
	public static final String MARK_nok = "nok";
	public static final String MARK_Nok = "Nok";
	public static final String MARK_NOK = "NOK";
	public static final String MARK_falil = "falil";
	public static final String MARK_FAIL = "FAIL";
	public static final String MARK_faliled = "faliled";
	public static final String MARK_FAILED = "FAILED";
	public static final String MARK_0 = "0";
	public static final String MARK_1 = "1";
	
	public static final String MARK_part = "part";

	public static final String FILENAMEEXTENSION_dotTxt = ".txt";
	
	public static final String CHARS_emptyString = "";
	public static final String CHARS_space = " ";
	public static final String CHARS_spaces2 = "  ";
	public static final String CHARS_spaces4 = "    ";
	public static final String CHARS_spaces8 = "        ";
	public static final String CHARS_spaces16 = "                ";
	public static final String CHARS_spaces32 = "                                ";
	public static final String CHARS_dot = ".";
	public static final String CHARS_dash = "-";
	public static final String CHARS_dashes4 = "----";
	public static final String CHARS_dashes8 = "--------";
	public static final String CHARS_spaces4AndDashes4 = "    ----";
	public static final String CHARS_underscore = "_";
	public static final String CHARS_underscores2 = "__";
	public static final String CHARS_semicolon = ";";
	public static final char CHAR_comma = ',';
	public static final char CHAR_semicolon = ';';
	
	public static final String SEPARATOR_commaSpace = ", ";
	
	public static final String SENTENCE_DoneDot = "Done.";
	public static final String SENTENCE_NotfoundDot = "Not found.";
	
	// Preferred file ends.
	public static String[] LIST_fileNameExtensions_columns = {"Dot end"};
	public static String[] LIST_fileNameExtensions = {
			FILENAMEEXTENSION_dotTxt,
	};
	
	// Characters who need to be prefixed by backslash '\' in REGEX: '[]\^$.|?*+(){}'. Note not sure about '[' and ']'.
	// Note not sure how exactly works. "[]\\^$.|?*+(){}"
	public static final String REGEX_SPECIALCHARACTERS = "[]\\^$.|?*+(){}";
	
	public static final char FILE_TEXTKEYCHARACTERPREFIX = 92;  // 92 '\' backslash.
	public static final char[] FILE_TEXTKEYCHARACTERS = {
			';',
	};
	
	
	public MarkLabelStringEtc(SmLib smLib) {
		this.smLib = smLib;
		
		constructor1();
		
		call_constructorContinues();
		call_initializeFeatures();
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
	
	
	protected void constructor1() {  }
	
	
	protected void constructor3() {  }
	protected void constructor4_sub() {  }
	protected void constructor5() {  }
	protected void constructor6_sub() {  }
	
	
	protected void call_initializeFeatures() {
		// Recommended to disable this method by overriding by empty method in your sub class 
		// and call method bellow at the end of your constructor (2).
		initializeFeatures();
	}
	
	
	protected void initializeFeatures() {
		initFeat();
		initFeat_sub();
	}
	
	
	protected void initFeat() {  }
	protected void initFeat_sub() {  }
	
	
	public void setup1() {  }
	public void setup2_sub() {  }
	public void setup3() {  }
	public void setup4_sub() {  }
	
	
	public boolean isMark_okOrOkOrOK(String mark) {
		if (mark.length() == MARK_ok.length() && (mark.equals(MARK_ok) || mark.equals(MARK_Ok) || mark.equals(MARK_OK))) {
			return true;
		}
		return false;
	}
	
	
	public boolean isMark_yesOrYesYOrYESOryOrY(String mark) {
		if ((mark.length() == MARK_yes.length() && (mark.equals(MARK_yes) || mark.equals(MARK_Yes) || mark.equals(MARK_YES)))
				|| (mark.length() == MARK_y.length() && (mark.equals(MARK_y) || mark.equals(MARK_Y)))) {
			return true;
		}
		return false;
	}
	
	
	public static String adjustRegexSpecialCharacters(String string) {
		String newString = "";
		for (int i1 = 0; i1 < string.length(); i1++) {
			for (int i2 = 0; i2 < REGEX_SPECIALCHARACTERS.length(); i2++) {
				if (string.charAt(i1) == REGEX_SPECIALCHARACTERS.charAt(i2)) {
					newString += '\\';  // 92 '\' backslash.
					break;
				}
			}
			newString += string.charAt(i1);
		}
		
		return newString;
	}
	
	
//		constructor1() { adjustAllRegexSpecialCharacters();
	
//	public static final String FILENAME_NOTALLOWEDCHARACTERS = "\\/:*\"<>|?";  // if (fileName.matches(".*[" + MarkLabelStringEtc.get_filename_notAllowedCharacters_regex() + "].*")) {
	
//	private static String[][] stringsAdjustToRegex = {  // [0] list of characters ; [1] adjusted for REGEX ; 
//			{FILENAME_NOTALLOWEDCHARACTERS, null},
//	};
	
//	public static String get_filename_notAllowedCharacters_regex() { return stringsAdjustToRegex[0][1]; }
//	
//	
//	private void adjustAllRegexSpecialCharacters() {
//		for (int i1 = 0; i1 < stringsAdjustToRegex.length; i1++) {
//			stringsAdjustToRegex[i1][1] = adjustRegexSpecialCharacters(stringsAdjustToRegex[i1][0]);
//		}
//	}

}
