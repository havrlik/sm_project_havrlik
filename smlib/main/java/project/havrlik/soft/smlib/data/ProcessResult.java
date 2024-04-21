package main.java.project.havrlik.soft.smlib.data;

/*
 * Enum name have to begin with letter. There, 'O' means OK and 'N' means NOK, as mnemonic.
 */


public enum ProcessResult {
	
	U0_NULL(false),
	U1_UNKNOWN(false),
	
	O1_OK(true),
	
	N1_FATAL(false),
	N2_ERROR(false),
	N3_FAIL(false),
	N4_WARN(false),
	
	N21_NOTSUPPORTEDDATACONTENT(false),  // D1_NOTSUPPORTEDDATACONTENT.
	
	N99_DEVELOPER(false);  // P1_DEVELOPER.
	
	
	private boolean isSuccess;
	
	
	ProcessResult(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	
	public boolean get_isSuccess() {
		return isSuccess;
	}

}
