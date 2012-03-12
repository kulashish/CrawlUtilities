package com.iitb.intranet.crawl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.iitb.intranet.data.PageContent;
/*
 * @author Ashish
 */
public class PageContentDumper {

	private String dumpDir;
	private String outDir;
	private File outFile;
	private PageContentWriter writer;

	public PageContentDumper(String dir, String out) {
		dumpDir = dir;
		outDir = out;
		outFile = new File(out);
		writer = new PageContentWriter(outFile);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PageContentDumper dumper = new PageContentDumper(args[0], args[1]);
		dumper.dump();
		System.out.println("Total HTMLs : " + PageContentWriter.filecounter);
	}

	private void dump() {
		File dumpFilePtr = new File(dumpDir);
		dumpFile(dumpFilePtr);
	}

	private void dumpFile(File dumpFilePtr) {
		if (dumpFilePtr.isDirectory())
			for (File f : dumpFilePtr.listFiles())
				dumpFile(f);
		if (dumpFilePtr.isFile())
			try {
				SegmentDumpParser parser = new SegmentDumpParser(dumpFilePtr);
				PageContent content = null;
				while (null != (content = parser.nextPageContent())) {
					writer.write(content);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}
