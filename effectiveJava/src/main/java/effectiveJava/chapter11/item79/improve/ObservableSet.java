package effectiveJava.chapter11.item79.improve;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import effectiveJava.chapter4.item18.ForwardingSet;

/**
 * 
 * 类 @code(ObservableSet)
 *
 * <p>
 *  功能简介：
 * <p>
* 可观察集合包装器
* 观察者模式简单实现经典案例(使用{@code CopyOnWriteArrayList}确保了线程安全)、
* 这个集合特别适合修改少，但是经常用于迭代的业务场景构造
 * <p>
 *  创建时间：2019年5月31日
 *
 * @author chenxj
 */
//Broken - invokes alien method from synchronized block!
public class ObservableSet<E> extends ForwardingSet<E> {
	public ObservableSet(Set<E> set) {
		super(set);
	}

	private final List<SetObserver<E>> observers = new CopyOnWriteArrayList<>();

	public void addObserver(SetObserver<E> observer) {		
			observers.add(observer);
		
	}

	public boolean removeObserver(SetObserver<E> observer) {	
			return observers.remove(observer);
	}

	// Alien method moved outside of synchronized block - open calls
    private void notifyElementAdded(E element) {     
        for (SetObserver<E> observer : observers)
            observer.added(this, element);
    }
	@Override
	public boolean add(E element) {
		boolean added = super.add(element);
		if (added)
			notifyElementAdded(element);
		return added;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean result = false;
		for (E element : c)
			result |= add(element); // Calls notifyElementAdded
		return result;
	}
	
	public static void main(String[] args) {
	    ObservableSet<Integer> set =
	            new ObservableSet<>(new HashSet<>());
	    set.addObserver(new SetObserver<>() {
	        public void added(ObservableSet<Integer> s, Integer e) {
	            System.out.println(e);
	            if (e == 23)
	                s.removeObserver(this);
	        }
	    });
	    	 
	    for (int i = 0; i < 100; i++)
	        set.add(i);
	}
}
