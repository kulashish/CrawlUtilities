package com.iitb.intranet.crawl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.iitb.intranet.data.PageContent;
/*
 * @author Ashish
 */
public class PageContentWriter {

	public static int filecounter = 0;

	public PageContentWriter(File outFile) {
		dir = outFile;
	}

	private File dir;

	public void write(PageContent content) throws IOException {
		List<String> pagecontent = content.getContent();
		if (null != pagecontent) {
			File file = new File(dir.getAbsolutePath() + "/" + (filecounter++)
					+ ".txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			Iterator<String> iter = pagecontent.iterator();
			while (iter.hasNext()) {
				writer.write(iter.next());
				writer.newLine();
			}
			writer.close();
		}
	}

}
