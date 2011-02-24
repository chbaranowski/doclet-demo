package com.github.tux2323.doclet;

import java.util.LinkedList;
import java.util.List;

public class Documentation {

    private final List<TestClassDoc> testClassDocs = new LinkedList<TestClassDoc>();
    
    public void addTestClassDoc(TestClassDoc testClassDoc){
	getTestClassDocs().add(testClassDoc);
    }

    public List<TestClassDoc> getTestClassDocs() {
	return testClassDocs;
    }

    @Override
    public String toString() {
	return "Documentation [testClassDocs=" + testClassDocs + "]";
    }
    
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((testClassDocs == null) ? 0 : testClassDocs.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Documentation other = (Documentation) obj;
	if (testClassDocs == null) {
	    if (other.testClassDocs != null)
		return false;
	} else if (!testClassDocs.equals(other.testClassDocs))
	    return false;
	return true;
    }
    
    
}
