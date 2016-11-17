package com.molczak.seleniumDownloader.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.molczak.seleniumDownloader.entity.SubjectNameAndUrl;

public class JsonConverter {

	private StringUtils stringUtils = new StringUtils(); 

	public Optional<List<SubjectNameAndUrl>> parseJsonToEntity(BufferedReader reader) throws IOException {
		
		String jsonString = stringUtils.parseBufferedReaderToJsonString(reader);

		ArrayList<String> subjectNames = stringUtils.findAllOccursOfPattern(jsonString, "NazwaPrzedmiotu");
		ArrayList<String> subjectUrls = stringUtils.findAllOccursOfPattern(jsonString, "Ids");
		
		List<SubjectNameAndUrl> zippedList = ListUtils.zip(subjectNames, subjectUrls);
		
		return Optional.ofNullable(zippedList);
	}
}
