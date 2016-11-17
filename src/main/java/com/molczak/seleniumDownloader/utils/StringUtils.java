package com.molczak.seleniumDownloader.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	public String parseBufferedReaderToJsonString(BufferedReader reader) throws IOException {
		StringBuilder builder = new StringBuilder();

		String line = "";
		while ((line = reader.readLine()) != null) {
			builder.append(line);
		}

		String stringWithoutSlashesh = builder.toString().replace("\\", "");

		return stringWithoutSlashesh;
	}

	public ArrayList<String> findAllOccursOfPattern(String stringToProcess, String fieldId) {
		ArrayList<String> allMatches = new ArrayList<>();
		Matcher m = Pattern.compile("\"" + fieldId + "\":\"(.+?)\",").matcher(stringToProcess);
		while (m.find()) {
			allMatches.add(m.group(1));
		}

		return allMatches;
	}

	public static String removeWhiteSpaces(String newName) {
		
		return newName.trim().replace(" ", "_").toLowerCase();
	}

}
