
/**
 * This ArrayLog object represents a Log ADT implemented as
 * a generic data type array using the EnhancedLogInterface.
 * 
 * @author  Matthew
 * @version 1
 */
@SuppressWarnings("unchecked")  // eliminates compiler warnings from cast below
public class ArrayStack<T> implements StackInterface<T>
{
    // Instance variables
    private T[] log;
    private String name;
    private int size;
    
    // Create a new String array with a capacity of 4 elements
    // and assign values to instance variables.
    public ArrayStack()
    {
        this.name = name;
        // cannot create a generic array object, so has to be cast
        // from an Object back into the generic in order to compile
        this.log = (T[])new Object[4];
        this.size = 0;
    }

    // Returns the name of this StringLog.
    public String getName()
    {
        return name;
    }

    // Returns the logical size of this StringLog.
    public int size()
    {
        return this.size;
    }

    @Override
    public T peek() throws StackUnderflowException {
        if (size == 0) {
            throw new StackUnderflowException("Stack is empty");
        }
        return this.log[size-1];
    }

    @Override
    public T pop() throws StackUnderflowException {
        if (size == 0) {
            throw new StackUnderflowException("Stack is empty");
        }
        T element = peek();
        log[size-1] = null;
        size--;
        manageSize();

        return element;
    }

    @Override
    public T push(T item) {


        size++;
        manageSize();
        log[size-1] = item;


        return item;
    }

    // Returns true if this list contains no elements.
    public boolean empty()
    {
        return this.size == 0;
    }
    
    // Returns true if this list is completely full.
    public boolean isFull()
    {
        return this.size >= this.log.length;
    }

    // Makes sure the array's size is correct
    public void manageSize() {
        int newArraySize = 4;

        while(newArraySize < size) {
            newArraySize*=2;
        }

        if (newArraySize != this.log.length) {

            T[] temp = (T[])new Object[newArraySize];

            int copyingSize = Math.min(this.log.length, size);

            for (int i = 0; i < copyingSize; i++) {
                temp[i] = this.log[i];
            }
            this.log = temp;
        }
    }

    // Appends the specified element to the end of this list.
    public void add(T element)
    {
        size++;
        manageSize();
        log[size-1] = element;
    }
  
    // Returns the element at the specified position in this list.
    public T get(int index)
    {
        if (index < 0 || index >= size) {
            return null;
        }

        return this.log[index];
    }
    
    // Returns the index of the first occurance of the specified element
    // in this list, or -1 if this list does not contain the element.
    public int indexOf(T element)
    {
        for (int i = 0; i < size; i++) {
            if (log[i] == element) {
                return i;
            }
        }
        return -1;
    }
    
    // Returns true if this list contains the specified element.
    public boolean contains(T element)
    {
        return indexOf(element) != -1;
    }
    
    // Returns a formatted string representation of this StringLog.
    public String toString()
    {
        String result = "Log: " + name + "\n";
        for (int i = 0; i < size; i++)
        {
            result += (i + 1) + ". " + log[i] + "\n";
        }
        return result;
    }
    
    // Replaces the element at the specified position in this list
    // with the specified element.  Returns what was at that location
    public T set(int index, T element)
    {
        T elementAtIndex = this.get(index);
        this.log[index] = element;
        return elementAtIndex;
    }
    
    // Inserts the specified element at the specified position in this list.
    public void add(int index, T element)
    {
        size++;
        manageSize();

        for (int i = size; i > index; i--) {
            log[i] = log[i-1];
        }
        log[index] = element;
    }
    
    // Removes the element at the specified position in this list, and
    // returns the element that was removed.  Any unused array elements
    // are set to null.
    public T remove(int index)
    {
        T elementAtIndex = log[index];

        for (int i = index; i < size-1; i++) {
            log[i] = log[i+1];
        }
        log[size-1] = null;

        size--;
        manageSize();

        return elementAtIndex;
    }
    
    // Removes the first occurance of the specified element from this
    // list, if it is present.  Returns true if element was found (and 
    // removed), false otherwise.
    public boolean remove(T element)
    {
        int index = indexOf(element);
        if (index == -1) {
            return false;
        }

        remove(index);
        return true;
    }
    
    // Removes all of the elements from this list.
    public void clear()
    {
        this.log = (T[])new Object[4];
        this.size = 0;
    }

    @Override
    public int search(Object o) {
        int realIndex = 0;
        for (int i = size; i >= 0; i--) {
            if (log[i] != null && log[i].equals(o)) {
                return realIndex;
            }
            realIndex++;
        }
        return -1;
    }
}
