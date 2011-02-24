package com.github.tux2323.doclet;

public class TestDoc {

    private final String testName;
    
    private String testTitle;
    
    private String description;

    public TestDoc(String testName) {
	this.testName = testName;
    }
    
    public String getTestName() {
	return testName;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getDescription() {
	return description;
    }

    @Override
    public String toString() {
	return "TestDoc [testName=" + testName + ", testId=" + getTestTitle()
		+ ", description=" + description + "]";
    }

    public void setTestTitle(String testTile) {
	this.testTitle = testTile;
    }

    public String getTestTitle() {
	return testTitle;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((description == null) ? 0 : description.hashCode());
	result = prime * result
		+ ((testName == null) ? 0 : testName.hashCode());
	result = prime * result
		+ ((testTitle == null) ? 0 : testTitle.hashCode());
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
	TestDoc other = (TestDoc) obj;
	if (description == null) {
	    if (other.description != null)
		return false;
	} else if (!description.equals(other.description))
	    return false;
	if (testName == null) {
	    if (other.testName != null)
		return false;
	} else if (!testName.equals(other.testName))
	    return false;
	if (testTitle == null) {
	    if (other.testTitle != null)
		return false;
	} else if (!testTitle.equals(other.testTitle))
	    return false;
	return true;
    }
    
}
