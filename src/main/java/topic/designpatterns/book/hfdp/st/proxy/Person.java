package topic.designpatterns.book.hfdp.st.proxy;

public interface Person {
	String getName();
	String getInterests();
	int getRating();
	void setName(String name);
	void setInterests(String interest);
	void setHotOrNotRating(int rating);
}
