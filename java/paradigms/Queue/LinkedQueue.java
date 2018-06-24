public class LinkedQueue extends AbstractQueue {
    private Node begin;
    private Node end;

    public LinkedQueue() {
        clear();
    }

    public void clear() {
        begin = null;
        end = null;
        size = 0;
    }

    protected void del() {      
        begin = begin.next;
        size--;
    }

    public void enqueue(Object x) {
        if (isEmpty()) {
            begin = new Node(x, null);
            end = begin;
            size = 1;
            return;
        }
        end.next = new Node(x, null);
        end = end.next;
        size++;
    }


    public Object element() {
        if(isEmpty()) {
            return null;
        }
        return begin.val;
    }

    protected Queue emptyClone() {
        return new LinkedQueue();
    }

    protected Object[] toArray() {
        Object[] a = new Object[size];
        Node i = begin;
		int j = 0;                        
        while (i != null) {       
			a[j] = i.val;
            i = i.next;
	    	j++;
        }
		
        return a;
    }



    private class Node {
        public Object val;
        public Node next;
        public Node(Object val, Node next) {
            this.val = val;
            this.next = next;
        }
    }



}
