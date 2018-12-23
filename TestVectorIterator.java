import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Vector;
import java.util.NoSuchElementException;

public class TestVectorIterator {

	private Vector myEmptyVector;
	private Vector myExampleVector;
	private VectorIterator myIterator1;
	private VectorIterator myIterator2;

	@Before
	public void initialize() {

		myEmptyVector = new Vector();
		myExampleVector = new Vector();
		myExampleVector.add(5);
		myExampleVector.add(6);
		myExampleVector.add(7);
		myIterator1 = new VectorIterator(myEmptyVector);
		myIterator2 = new VectorIterator(myExampleVector);
	}

	@Test
	public void testHasNext() {
		assertFalse(myIterator1.hasNext());// test when the vector is empty

		myEmptyVector.add(8);
		assertEquals(true, myIterator1.hasNext());// test when an item is added to exampleVector

		myEmptyVector.remove(0);
		assertEquals(false, myIterator1.hasNext());// test when an item is removed from exampleVector

		for (int i = 0; i < myExampleVector.size(); i++) {
			myIterator2.next();
		}
		assertEquals(false, myIterator2.hasNext());// test when the end of the vector has already been reached
	}

	@Test
	public void testNext() {
		myEmptyVector.add(8);
		assertEquals(8, myIterator1.next());// Test when an item is added to the vector

		myEmptyVector.remove(0);
		try {
			myIterator1.next();
		} catch (NoSuchElementException e) {
		} // Test when an item is removed from the vector

		for (int i = 0; i < myExampleVector.size(); i++) {
			myIterator2.next();
		}
		try {
			myIterator2.next();
		} catch (NoSuchElementException e) {
		} // test when the end of the vector has already been reached
	}

	@Test
	public void testRemove() {
		try {
			myIterator1.remove();
		} catch (IllegalStateException e) {
		} // test when the Vector is empty

		myEmptyVector.add(1);
		myEmptyVector.add(2);
		myIterator1.next();
		myIterator1.remove();
		assertEquals(1, myEmptyVector.size());// Test when an item is added to the vector

		myEmptyVector.add(3);
		myIterator1.next();
		try {
			myIterator1.remove();
		} catch (IllegalStateException e) {
		} // test when the end of the vector has already been reached
	}
}
