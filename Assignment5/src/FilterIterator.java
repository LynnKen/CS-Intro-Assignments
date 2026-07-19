import java.util.Iterator;
import java.util.NoSuchElementException;


public class FilterIterator<T> implements Iterator<T> {
	Iterator<T> iterator;
	Iterable<Filter<T>> filters;
	T next;

	//assume element and filters aren't null
	public FilterIterator(Iterable<T> elements, Iterable<Filter<T>> filters) {
		if (elements == null || filters == null)
			throw new IllegalArgumentException("input is Illegal");
		this.iterator = elements.iterator();
		this.filters = filters;

		boolean isFound = false;
		while (!isFound && iterator.hasNext()) {
			T elementToCheck = iterator.next();
			boolean passFilters = checkAllFilters(elementToCheck);

			if (passFilters) {
				next = elementToCheck;
				isFound = true;
			}
		}
		if (!isFound)
			next=null;
	}
	// returns true if the element passes all filters
	private boolean checkAllFilters(T element){
		if (element==null)
			return false;
		for (Filter<T> filterToCheck: filters){
			if (!filterToCheck.accept(element))
				return false;
		}
		return true;
	}
	@Override
	public boolean hasNext() {
		return next!=null;
	}

	@Override
	public T next() {
		if (!hasNext())
			throw new NoSuchElementException();

		T currNext=this.next;
		boolean found=false;

		while (!found && iterator.hasNext()) {
			T tempNext = iterator.next();
			if (checkAllFilters(tempNext)){
				found=true;
				next=tempNext;
			}
		}
		if (!found)
			next=null;
		return currNext;
	}
}
