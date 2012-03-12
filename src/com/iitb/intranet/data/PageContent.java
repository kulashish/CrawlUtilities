package com.iitb.intranet.data;

import java.util.ArrayList;
import java.util.List;

public class PageContent {

	public static final String CONTENT_TYPE_HTML = "html";

	private String URL;
	private String contentType;
	private List<String> content;

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public List<String> getContent() {
		return content;
	}

	public void setContent(List<String> content) {
		this.content = content;
	}

	public void addContent(String line) {
		if (null == content)
			content = new ArrayList<String>();
		content.add(line);
	}

}
