package com.java.lambda;

public class FileLocation implements Cloneable {
	String filePath;
	boolean isWrittenPermission = false;
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public boolean isWrittenPermission() {
		return isWrittenPermission;
	}
	public void setWrittenPermission(boolean isWrittenPermission) {
		this.isWrittenPermission = isWrittenPermission;
	}
	
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
