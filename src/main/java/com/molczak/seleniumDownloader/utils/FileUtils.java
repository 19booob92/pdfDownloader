package com.molczak.seleniumDownloader.utils;

import java.io.File;

public class FileUtils {

	public void changeLastFileName(String newName) {
		String processedNewName = StringUtils.removeWhiteSpaces(newName);
		
		File existsFile = new File("/home/booob/Dokumenty/sylabus2/Report.pdf");
		
		File fileWithNewName = new File("/home/booob/Dokumenty/sylabus2/"+ processedNewName +".pdf");
		
		existsFile.renameTo(fileWithNewName);
	}

}
