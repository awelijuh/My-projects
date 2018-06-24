import java.util.function.Function;
import java.util.function.Predicate;

//model: a[];
//inv: a.length >= 0
public interface Queue {
	//pre:
	//post: a.length == k + 1 && 0 <= i < a.length-1: a[i] == b[i] && a[a.length-1] == x
	void enqueue(Object x);
    
    //pre: a.length > 0
	//post: R == a[0]
	Object element();

	//pre: a.length > 0
	//post: R == a[0] && 0 < i < a.length : a[i] == a'[i - 1] && a.length = a'.length - 1
    Object dequeue();
	
	//pre: 
	//post: R ==a.length
    int size();
	
	//pre:
	//post: (R == true && a.length == 0) || (R == false && a.length > 0)
    boolean isEmpty();
	
	//pre:                                                               
	//post: a.length == 0;
    void clear();
	
	//pre: 
	//post: R.length == cnt(i : (0 <= i < a.length && predicate(a[i]) == true)) == j.length && 
	// (0 < i < j.length : j[i - 1] < j[i]) && 0 <= j[0] < j[j.length - 1]< a.length && 
	// (0 <= i < j.length : predicate(a[j[i]]) == true) && (0 <= i < R.length : R[i] == a[j[i]]) 
    Queue filter(Predicate<Object> predicate);
    
	//pre:
	//post: 0 <= i < a.length : function(a[i]) == R[i] && R.length == a.length
	Queue map(Function<Object, Object> function);

}
