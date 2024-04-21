package main.java.project.havrlik.soft.filefixtures.smlib;

import main.java.project.havrlik.soft.filefixtures.smlib.introduction.Introduction;

public class SmLib extends main.java.project.havrlik.soft.smlib.SmLib {
	
	public Introduction introduction;
	
	
	public SmLib() {
		super();
		
		constructorContinues();
		initializeFeatures();
		initializeCheck();
	}
	
	
	@Override
	protected void call_constructorContinues() {  }
	@Override
	protected void call_initializeFeatures() {  }
	@Override
	protected void call_initializeCheck() {  }
	
	
	@Override
	protected void initFeat_introduction() {
		introduction = new Introduction(this);
		super.introduction = introduction;
	}

}
