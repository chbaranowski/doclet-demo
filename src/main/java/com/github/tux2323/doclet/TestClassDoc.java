package com.github.tux2323.doclet;

import java.util.LinkedList;
import java.util.List;

public class TestClassDoc {

    final String testClassName;
    
    final List<TestDoc> testDocs = new LinkedList<TestDoc>();
    
    public TestClassDoc(String name) {
	this.testClassName = name;
    }
    
    public void addTestDoc(TestDoc testDoc){
	testDocs.add(testDoc);
    }

    @Override
    public String toString() {
	return "TestClassDoc [testClassName=" + testClassName + ", testDocs="
		+ testDocs + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((testClassName == null) ? 0 : testClassName.hashCode());
	result = prime * result
		+ ((testDocs == null) ? 0 : testDocs.hashCode());
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
	TestClassDoc other = (TestClassDoc) obj;
	if (testClassName == null) {
	    if (other.testClassName != null)
		return false;
	} else if (!testClassName.equals(other.testClassName))
	    return false;
	if (testDocs == null) {
	    if (other.testDocs != null)
		return false;
	} else if (!testDocs.equals(other.testDocs))
	    return false;
	return true;
    }
    
}
