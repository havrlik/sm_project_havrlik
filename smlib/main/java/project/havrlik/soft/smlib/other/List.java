package main.java.project.havrlik.soft.smlib.other;

import main.java.project.havrlik.soft.smlib.SmLib;
import main.java.project.havrlik.soft.smlib.smlist.SmList_Sort;
import main.java.project.havrlik.soft.smlib.smlist.SmList_Util;

public class List {
	
	protected SmLib smLib;
	
	public SmList_Util smList_Util;
	public SmList_Sort smList_Sort;
	
	
	public List(SmLib smLib) {
		this.smLib = smLib;
		
		smList_Util = new SmList_Util();
		smList_Sort = new SmList_Sort();
		
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

}
