package effectiveJava.chapter11.item79.original;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import effectiveJava.chapter4.item18.ForwardingSet;

/**
 * 
 * 类 @code(ObservableSet)
 *
 * <p>
 *  功能简介：
 * <p>
* 可观察集合包装器
* 观察者模式简单实现经典案例
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

	private final List<SetObserver<E>> observers = new ArrayList<>();

	public void addObserver(SetObserver<E> observer) {
		synchronized (observers) {
			observers.add(observer);
		}
	}

	public boolean removeObserver(SetObserver<E> observer) {
		synchronized (observers) {
			return observers.remove(observer);
		}
	}
//该方法同步块调用了外来的方法，非常容易造成死锁
//	private void notifyElementAdded(E element) {
//		synchronized (observers) {
//			for (SetObserver<E> observer : observers)
//				observer.added(this, element);
//		}
//	}

	// Alien method moved outside of synchronized block - open calls
    private void notifyElementAdded(E element) {
        List<SetObserver<E>> snapshot = null;
        synchronized(observers) {
            snapshot = new ArrayList<>(observers);
        }

        for (SetObserver<E> observer : snapshot)
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
//	    set.addObserver((s, e) -> System.out.println(e));
	    set.addObserver(new SetObserver<>() {
	        public void added(ObservableSet<Integer> s, Integer e) {
	            System.out.println(e);
	            if (e == 23)
	                s.removeObserver(this);
	        }
	    });
	    
	 // Observer that uses a background thread needlessly
	    set.addObserver(new SetObserver<>() {
	       public void added(ObservableSet<Integer> s, Integer e) {
	          System.out.println(e);
	          if (e == 23) {
	             ExecutorService exec =
	                   Executors.newSingleThreadExecutor();
	             try {
	                exec.submit(() -> s.removeObserver(this)).get();
	             } catch (ExecutionException | InterruptedException ex) {
	                throw new AssertionError(ex);
	             } finally {
	                exec.shutdown();
	             }
	          }
	       }
	    });
	    
	 
	    for (int i = 0; i < 100; i++)
	        set.add(i);
	}
}
