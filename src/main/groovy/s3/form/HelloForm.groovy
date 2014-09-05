package s3.form;

import groovy.transform.ToString;

@ToString(includeNames=true,includeFields=true)
class HelloForm implements Serializable {
	String firstName;
	String lastName;
	List<Item> history = new ArrayList<Item>();
}

@ToString(includeNames=true,includeFields=true)
class Item implements Serializable {
	String firstName;
	String lastName;
	String date;
}