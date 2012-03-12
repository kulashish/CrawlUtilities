package com.iitb.intranet.crawl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.iitb.intranet.data.PageContent;
/*
 * @author Ashish
 */
public class SegmentDumpParser {

	private String dumpPath;
	private File filePtr;
	private BufferedReader reader;

	public SegmentDumpParser(String path) throws FileNotFoundException {
		dumpPath = path;
		filePtr = new File(dumpPath);
		reader = new BufferedReader(new FileReader(filePtr));
	}

	public SegmentDumpParser(File path) throws FileNotFoundException {
		filePtr = path;
		reader = new BufferedReader(new FileReader(filePtr));
	}

	public void close() throws IOException {
		if (null != reader)
			reader.close();
	}

	public PageContent nextPageContent() throws IOException {
		String line = null;
		PageContent content = null;
		while (null != (line = reader.readLine())) {
			if (line.indexOf("contentType:") != -1
					&& line.indexOf(PageContent.CONTENT_TYPE_HTML) != -1) {
				content = new PageContent();
				content.setContentType(PageContent.CONTENT_TYPE_HTML);
				readContent(content);
				break;
			}
		}
		return content;
	}

	private void readContent(PageContent content) throws IOException {
		String line = null;
		while ((line = reader.readLine()).indexOf("Content:") == -1)
			;
		while ((line = reader.readLine()) != null) {
			if (line.indexOf("Recno") != -1)
				break;
			content.addContent(line);
		}
	}
}
