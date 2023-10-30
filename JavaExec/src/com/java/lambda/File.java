package com.java.lambda;

public class File implements Cloneable {
	
	int id =0;
	FileLocation fileloc = null;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public FileLocation getFileloc() {
		return fileloc;
	}
	public void setFileloc(FileLocation fileloc) {
		this.fileloc = fileloc;
	}
	
	protected Object clone() throws CloneNotSupportedException {
		File file = (File) super.clone();
		file.setFileloc((FileLocation)fileloc.clone());
		return file;
	}

}
