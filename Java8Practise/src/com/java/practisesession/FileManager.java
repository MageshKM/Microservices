package com.java.practisesession;

public class FileManager {
	public static void main(String args[]) throws CloneNotSupportedException {
		File file = new File();
		FileLocation fileLoc = new FileLocation();
		fileLoc.setFilePath("C:\\TEST\\");
		fileLoc.setWrittenPermission(true);
		file.setFileloc(fileLoc);
		file.setId(1);
		
		
		
		File file2 = (File) file.clone();
		file2.setId(2);
		file2.getFileloc().setFilePath("D:\\Files\\");
		System.out.println("File Details:"+file.getId()+"|"+file.getFileloc().getFilePath()+"|"+file.getFileloc().isWrittenPermission);
		System.out.println("File2 Details:"+file2.getId()+"|"+file2.getFileloc().getFilePath()+"|"+file2.getFileloc().isWrittenPermission);
	}

}
