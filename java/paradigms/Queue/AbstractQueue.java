import java.util.function.Function;
import java.util.function.Predicate;

public abstract class AbstractQueue implements Queue{
    protected int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

	abstract public Object element();
	abstract protected void del();
	
	public Object dequeue() {
		if (size == 0) {
			return null;
		}
		Object x = element();
		del();
		return x;

	}
	
	

    protected abstract Queue emptyClone();
    protected abstract Object[] toArray();

    public Queue filter(Predicate<Object> predicate) {
		Queue q = this.emptyClone();
        Object[] a = this.toArray();

        for (int i = 0; i < size; i++) {
            if (predicate.test(a[i])) {
                q.enqueue(a[i]);
            }
        }
        return q;
    }

    public Queue map(Function<Object, Object> function) {
        Queue q = this.emptyClone();
        Object[] a = this.toArray();

        for (int i = 0; i < size; i++) {
            q.enqueue(function.apply(a[i]));
        }
        return q;
    }





}
