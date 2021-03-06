package arrays;

public class Person {
	
	public static final String[] FIRST_START = {"Chr","M","L","Gr","S","Ph","And","St","Cth"};
	public static final String[] FIRST_MIDDLE = {"isti","icha","ere","eta","are","an","ina","eta","y","ulu"};
	public static final String[] FIRST_END = {"","na","n","r","tian","s","rs","mp","les"};
	
	public static final String[] LAST_START = {"Tr","Br","L","Gr","S","Ph","Sh","St"};
	public static final String[] LAST_MIDDLE = {"om","o","on","ola","et","e","ina","eta","y"};
	public static final String[] LAST_END = {"","son","n","ers","rian","ston","ck","mp","sk"};
	
	private String firstName;
	private String lastName;
	private Borough home;
	private Hobby hobby;
	private Person[] friends;
	private String nickname;
			
	public Person(String f, String l, Borough h) {
		this.firstName = f;
		this.lastName = l;
		this.home = h;
		this.hobby = Hobby.randomHobby();
		friends = new Person[3];
		this.nickname = createNickname(firstName);
	}
	
	public void mingle(Person[] people) {
		for(Person p:people)
		{
			if(p != this && p != friends[0])
			{
				p = betterFriend(p, friends[0]);
				addFriendToFirstPlace(p);
			}
		}
		
	}
	
	private Person betterFriend(Person p, Person q) {
		if(p == null) {return q;}
		if(q == null) {return p;}
		
		if(p.getClass() == this.getClass() && q.getClass() == this.getClass()) {
			if(p.getHobby() == this.hobby)
				return p;
			if(q.getHobby() == this.hobby)
				return q;
		}
		
		if(p.getClass() == this.getClass()) {return p;}
		if(q.getClass() == this.getClass()) {return q;}
		
		return p;
	}

	public Hobby getHobby() {
		return this.hobby;
	}
	
	public void printFriends() {
		System.out.println("My name is "+firstName+" "+lastName+" and my friends are:");
		for(Person f: friends) {
			if(f != null) System.out.println(f);
		}
	}
	
	public void addFriendToFirstPlace(Person p) {
		for(int i = friends.length-1; i>0; i--)
		{
			friends[i] = friends[i-1];
		}
		friends[0] = p;
	}
	
	public String toString() {
		return "My name is "+firstName+" "+lastName+" and I live in "+home+". Call me "+nickname+". I like "+hobby;
	}
	
	//JAVA IS PASS-BY-VALUE
	//the parameters of a method are just values, not references
	public static String createNickname(String name) {
		String[] vowels = {"a","e","i","o","u"};
		String returnWord = "";
		boolean firstVowel = false;
		for(int i = 0; i < name.length(); i++) {
			for(String v:vowels) {
				if(firstVowel && name.substring(i,i+1).equals(v)) {
					return returnWord;
				}else if(name.substring(i,i+1).equals(v)) {
						firstVowel = true;
						break;
					}
			}
			returnWord += name.substring(i,i+1);
		}
		return returnWord;
	}
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
		this.nickname = createNickname(firstName);
	}
}
