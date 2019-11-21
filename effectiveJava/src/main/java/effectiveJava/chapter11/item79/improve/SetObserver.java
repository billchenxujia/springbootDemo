package effectiveJava.chapter11.item79.improve;

@FunctionalInterface
public interface SetObserver<E> {
	// Invoked when an element is added to the observable set
	void added(ObservableSet<E> set, E element);
}
