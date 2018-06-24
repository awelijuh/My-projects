public class ArrayQueue extends AbstractQueue {
    private int begin;
    private Object[] array;


    public ArrayQueue() {
        clear();
    }


    public void clear() {
        begin = 0;
        size = 0;
        array = new Object[3];
    }


    public Object element() {
        return array[begin];
    }


    public void enqueue(Object x) {
        if (size == array.length) {
            arrayUpdate();
        }

        array[(begin + size) % array.length] = x;
        size++;
    }


    protected void del() {
        
        array[begin] = null;
        begin = (begin + 1) % array.length;
        size--;
        if (size * 4 < array.length) {
            arrayUpdate();
        }
    }


    private void arrayUpdate() {
        if (isEmpty()) {
            clear();
            return;
        }

        Object[] a = new Object[size*2];           
        if (array.length - begin >= size) {
			System.arraycopy(array, begin, a, 0, size);
		} else {
        	System.arraycopy(array, begin, a, 0, array.length - begin);
			System.arraycopy(array, 0, a, array.length - begin, size - array.length + begin );
        }

        array = a;
        begin = 0;
    }

    protected Queue emptyClone() {
        return new ArrayQueue();
    }

    protected Object[] toArray() {
        Object[] a = new Object[size];             
        if (array.length - begin >= size) {
			System.arraycopy(array, begin, a, 0, size);
		} else {
        	System.arraycopy(array, begin, a, 0, array.length - begin);
			System.arraycopy(array, 0, a, array.length - begin, size - array.length + begin );
        }

        return a;
    }


}
