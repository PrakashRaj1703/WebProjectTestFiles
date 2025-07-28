package org.testrunner;

import java.io.File;
import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.ReportBuilder;

public class JVM {
	public static void generate(String jvmFilePath) {
		File f = new File("target/JVM Report");
		net.masterthought.cucumber.Configuration c = new net.masterthought.cucumber.Configuration(f, "Testing");
		c.addClassifications("Author", "Prakash");
		c.addClassifications("Platform", "Web");
		c.addClassifications("OS", "Windows");
		c.addClassifications("Environment", "QA");
		List<String> s = new ArrayList<String>();
		s.add(jvmFilePath);
		ReportBuilder r = new ReportBuilder(s, c);
		r.generateReports();

	}

}
