import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

/**
 * This class contains an iterator implements Iterator Interface for the Java
 * Vector class.
 */
public class VectorIterator<T> implements Iterator<T> {

	private int myPosition;
	private Vector<T> myVector;
	private boolean myCheck;
	
	/**
	 * This is the constructor for the class. It takes a vector as a parameter and creates an iterator.
	 * @param newVector This is the vector that is passed as an argument.
	 */
	
	public VectorIterator(Vector<T> newVector) {
		myPosition = 0;
		myVector = newVector;
	}
	
	/**
	 * This method checks if there is a next element in the vector. Returns true if there is one and false otherwise. 
	 *
	 */
	
	public boolean hasNext() {
		return myVector.size() > myPosition;
	}
	
	/**
	 * This method moves the current position to the next one and returns the next element in the vector.
	 * It throws an exception if there is no next element.
	 */
	
	public T next() {
		if (myPosition == 0 && myVector.get(0) != null) {
			myCheck = true;
			myPosition++;
			return myVector.get(0);
		} else if (hasNext()) {
			myCheck = true;
			T tmp = myVector.get(myPosition);
			myPosition++;
			return tmp;
		} else {
			throw new NoSuchElementException();
		}
	}
	
	/**
	 * This method removes the element at the current position from the vector. This method can be called
	 * only if the next method has been called and if not throws an exception.
	 */
	
	public void remove() {
		if (myCheck == true) {
			myVector.remove(myPosition);
			myPosition--;
		} else {
			throw new IllegalStateException();
		}
	}
}
