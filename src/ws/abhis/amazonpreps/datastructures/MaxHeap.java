package ws.abhis.amazonpreps.datastructures;

public class MaxHeap {
	private int[] heap;
	private int size;
	private int maxSize;
	
	private static final int FRONT = 1;
	
	//Initialize max size and array
	//Initialize first or max element to the 
	//maximum possible value
	public MaxHeap(int maxSize) {
		this.maxSize = maxSize;
		this.size = 0;
		heap = new int[this.maxSize + 1];
		heap[0] = Integer.MAX_VALUE;
	}
	
	private int parent (int pos) {
		return pos/2;
	}
	
	private int leftChild (int pos) {
		return (2*pos);
	}
	
	private int rightChild (int pos) {
		return (2*pos) + 1;
	}
	
	 private boolean isLeaf(int pos)
	    {
	        if (pos >=  (size / 2)  &&  pos <= size)
	        {
	            return true;
	        }
	        return false;
	    }
	 
	    private void swap(int fpos,int spos)
	    {
	        int tmp;
	        tmp = heap[fpos];
	        heap[fpos] = heap[spos];
	        heap[spos] = tmp;
	    }
	 
	    private void maxHeapify(int pos)
	    {
	        if (!isLeaf(pos))
	        { 
	            if ( heap[pos] < heap[leftChild(pos)]  || heap[pos] < heap[rightChild(pos)])
	            {
	                if (heap[leftChild(pos)] > heap[rightChild(pos)])
	                {
	                    swap(pos, leftChild(pos));
	                    maxHeapify(leftChild(pos));
	                }else
	                {
	                    swap(pos, rightChild(pos));
	                    maxHeapify(rightChild(pos));
	                }
	            }
	        }
	    }
	 
	    public void insert(int element)
	    {
	    	heap[++size] = element;
	        int current = size;
	 
	        while(heap[current] > heap[parent(current)])
	        {
	            swap(current,parent(current));
	            current = parent(current);
	        }	
	    }
	 
	    public void print()
	    {
	        for (int i = 1; i <= size / 2; i++ )
	        {
	            System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " + heap[2*i]
	                  + " RIGHT CHILD :" + heap[2 * i  + 1]);
	            System.out.println();
	        }
	    }
	 
	    public void maxHeap()
	    {
	        for (int pos = (size / 2); pos >= 1; pos--)
	        {
	            maxHeapify(pos);
	        }
	    }
	 
	    public int remove()
	    {
	        int popped = heap[FRONT];
	        heap[FRONT] = heap[size--]; 
	        maxHeapify(FRONT);
	        return popped;
	    }
	 
	    public static void main(String...arg)
	    {
	        System.out.println("The Max Heap is ");
	        MaxHeap maxHeap = new MaxHeap(15);
	        maxHeap.insert(5);
	        maxHeap.insert(3);
	        maxHeap.insert(17);
	        maxHeap.insert(10);
	        maxHeap.insert(84);
	        maxHeap.insert(19);
	        maxHeap.insert(6);
	        maxHeap.insert(22);
	        maxHeap.insert(9);
	        maxHeap.maxHeap();
	 
	        maxHeap.print();
	        System.out.println("The max val is " + maxHeap.remove());
	        System.out.println("The max val is " + maxHeap.remove());
	    }
}
