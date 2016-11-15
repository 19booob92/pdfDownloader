package com.molczak.seleniumDownloader.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.molczak.seleniumDownloader.entity.SubjectNameAndUrl;

public class ListUtils {

	public static List<SubjectNameAndUrl> zip(Iterable<String> listA, Iterable<String> listB) {
		Iterator<String> iteratoA = listA.iterator();
		Iterator<String> iteratoB = listB.iterator();

		List<SubjectNameAndUrl> list = new ArrayList<>();

		while (iteratoA.hasNext() && iteratoB.hasNext()) {
			SubjectNameAndUrl subjectNameAndUrl = new SubjectNameAndUrl(iteratoA.next(), iteratoB.next());

			list.add(subjectNameAndUrl);
		}

		return list;
	}
}
