package topic.designpatterns.book.hfdp.st.proxy;

public class PersonBean implements Person{
	private String name;
	private String interests;
	private int rating;
	private int ratingCount = 1;
	
	public PersonBean(String n, String interests, int rating){
		this.interests = interests;
		this.name = n;
		this.rating = rating;
		
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public String getInterests() {
		return this.interests;
	}
	
	@Override
	public int getRating() {
		return ratingCount == 0 ? (rating !=0 ? rating : 5): rating/ratingCount;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void setInterests(String interest) {
		this.interests = interest;
		
	}
	
	@Override
	public void setHotOrNotRating(int rating) {
		this.rating += rating;
		ratingCount++;
	}
}
