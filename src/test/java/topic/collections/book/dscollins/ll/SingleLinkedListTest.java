package topic.collections.book.dscollins.ll;

import org.junit.Before;
import org.junit.Test;


//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class SingleLinkedListTest {
	
	protected SingleLinkedList<String> ll;
	
	@Before
	public void runBeforeEachTest(){
		ll = new SingleLinkedList<>();
	}
	
	@Test
	public void testSize1(){
		assertThat(ll.size(), is(equalTo(0)));
		// TODO diff between Matchers.is and CoreMatchers.is ?
	}
	
	@Test
	public void testSize2(){
		ll.addToFront("John");
		ll.addToFront("Francisco");
		ll.addToFront("Ragner");
		assertThat(ll.size(), is(equalTo(3)));
	}
	
	@Test
	public void testContains(){
		ll.addToFront("John");
		ll.addToFront("Francisco");
		ll.addToFront("Ragner");
		assertThat(ll.contains("John"), is(true));
	}
	
	@Test
	public void testContains2(){
		ll.addToFront("John");
		ll.addToFront("Francisco");
		ll.addToFront("Ragner");
		assertThat(ll.contains("Dagny"), is(false));
	}
	
	
	@Test
	public void testAdd(){
		ll.addToFront("Elon");
		ll.addToFront("Satyajit");
		ll.addToFront("Arijit");
		
		assertEquals("[Arijit, Satyajit, Elon]", ll.toString());
		assertThat(ll, containsInAnyOrder("Arijit", "Satyajit", "Elon"));
		assertThat(ll, contains("Arijit", "Satyajit", "Elon"));
	}
}