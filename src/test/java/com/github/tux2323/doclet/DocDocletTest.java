package com.github.tux2323.doclet;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Before;
import org.junit.Test;
import com.sun.tools.javadoc.Main;
import com.thoughtworks.xstream.XStream;

public class DocDocletTest {

    private DocDoclet docDoclet;

    @Before
    public void setup() {
	docDoclet = new DocDoclet();
    }

    @Test
    public void testDocDoclet() throws Exception {
	com.sun.tools.javadoc.Main.execute(new String[] { "-doclet",
		DocDoclet.class.getName(), "-sourcepath", "src/test/java",
		"com.github.tux2323.doclet.demo" });
	
	XStream xStream = new XStream();
	Documentation actualDocumentation = (Documentation) xStream
		.fromXML(new FileInputStream(docDoclet.getDocumentationFile()));
	
	Documentation expectedDocumentation = new Documentation();
	TestClassDoc testClassDoc = new TestClassDoc("DemoTest");
	TestDoc testDoc = new TestDoc("testDemo");
	testDoc.setTestTitle("Doclet Demo Test");
	testDoc.setDescription("A demo test case for the doc doclet.");
	testClassDoc.addTestDoc(testDoc);
	expectedDocumentation.addTestClassDoc(testClassDoc);
	
	assertEquals(expectedDocumentation, actualDocumentation);
    }

}
