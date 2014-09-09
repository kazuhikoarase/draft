package s3.form;

import groovy.transform.ToString;

@ToString(includeNames=true,includeFields=true)
class HelloForm implements Serializable {
	String firstName;
	String lastName;
	List<HelloForm_Item> history = new ArrayList<HelloForm_Item>();
}

@ToString(includeNames=true,includeFields=true)
class HelloForm_Item implements Serializable {
	String firstName;
	String lastName;
	String date;

	String field1;
	String field2;
	boolean field3;
	// to avoid getter confliction
	boolean getField3() { return field3; }
}


