package com.github.tux2323.doclet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.sun.javadoc.*;
import com.thoughtworks.xstream.XStream;

public class DocDoclet {

    private static final String DOCU_XML_FILE = "docu.xml";
    
    private static final String JAVADOC_DESCRIPTION_TAG = "description";
    private static final String JAVADOC_TITLE_TAG = "title";
    
    private final File reportDirectory = new File("target/test-docu/");
    
    private final XStream xStream = new XStream();
    
    public static boolean start(RootDoc root) throws Exception {
	new DocDoclet().createTestDocumentation(root.classes());
	return true;
    }
    
    protected final void createTestDocumentation(ClassDoc[] classes) throws Exception {
        final Documentation documentation = new Documentation();
        for (ClassDoc classDoc : classes) {
	    final TestClassDoc testClassDoc = new TestClassDoc(classDoc.name());
            documentation.addTestClassDoc(testClassDoc);
	    for (MethodDoc methodDoc : classDoc.methods()) {
		TestDoc testDoc = new TestDoc(methodDoc.name());
	        testClassDoc.addTestDoc(testDoc);
		testDoc.setTestTitle(extractTitle(methodDoc));
		testDoc.setDescription(extractDescription(methodDoc));
	    }
        }
	writeXmlModel(documentation);
    }

    private String extractDescription(MethodDoc methodDoc) {
	return extractTag(methodDoc, JAVADOC_DESCRIPTION_TAG);
    }

    private String extractTitle(MethodDoc methodDoc) {
	return extractTag(methodDoc, JAVADOC_TITLE_TAG);
    }
    
    private String extractTag(MethodDoc methodDoc, String tagName){
	String tagTextContent = null;
	final Tag[] tags = methodDoc.tags(tagName);
	if (tags.length > 0) {
	  tagTextContent = tags[0].text();
	}
	return tagTextContent;
    }

    private void writeXmlModel(Documentation documentation) throws FileNotFoundException {
	getReportDirectory().mkdirs();
	xStream.toXML(documentation, new FileOutputStream(getDocumentationFile()));
    }

    public File getDocumentationFile() {
	return new File(getReportDirectory(), DOCU_XML_FILE);
    }

    public File getReportDirectory() {
	return reportDirectory;
    }

}
