
/**
 * This LinkedLog object represents a Log ADT implemented as
 * a LinkedList using the EnhancedLogInterface.
 *
 * @author
 * @version
 */
public class LinkedStack<T> implements StackInterface<T>
{
    public LLNode<T> log;
    public String name;
    public int size;

    public LinkedStack()
    {
        this.log = null;
        this.name = name;
        this.size = 0;
    }

    // returns the name of this StringLog
    public String getName()
    {
        return name;
    }

    // returns the logical size of this StringLog
    public int size()
    {
        return size;
    }

    @Override
    public T peek() throws StackUnderflowException {
        if (this.log == null) {
            throw new StackUnderflowException("The log is empty!");
        }
        return this.log.getInfo();
    }

    @Override
    public T pop() throws StackUnderflowException {
        if (this.log == null) {
            throw new StackUnderflowException("The log is empty!");
        }

        LLNode<T> currentNode = this.log;
        this.log = this.log.getLink();

        size--;

        return currentNode.getInfo();
    }

    @Override
    public T push(T item) {
        LLNode<T> newNode = new LLNode<T>(item);
        LLNode<T> oldNode = this.log;

        this.log = newNode;
        if (oldNode != null) {
            newNode.setLink(oldNode);
        }

        

        this.size++;

        return item;
    }

    // returns true if this list contains no elements
    public boolean empty()
    {
        return size <= 0;
    }

    // returns true if this list is completely full
    public boolean isFull()
    {
        return (this.size >= Integer.MAX_VALUE);
    }

    // appends the specified element to the end of this list
    public void add(T element) {
        if (this.log == null || this.log.getInfo() == null) {
            this.log = new LLNode<T>(element);
        } else {
            LLNode<T> current = this.log;
            while (current.getLink() != null) {
                current = current.getLink();
            }
            current.setLink(new LLNode<T>(element));
        }

        this.size++;
    }
    // returns the element at the specified position in this list
    public T get(int index)
    {
        LLNode<T> current = this.log;
        for (int i = 0; i < index; i++) {
            current = current.getLink();
        }
        return current.getInfo();
    }

    // returns the index of the first occurance of the specified element
    // in this list, or -1 if this list does not contain the element
    public int indexOf(T element)
    {
        LLNode<T> current = this.log;
        for (int i = 0; i < size; i++) {

            if (current.getInfo() == element) {
                return i;
            }
            current = current.getLink();
        }
        return -1;
    }

    // returns true if this list contains the specified element
    public boolean contains(T element)
    {
        return indexOf(element) != -1;
    }

    // returns a formatted string representation of this StringLog
    public String toString()
    {
        String result = "Log: " + name + "\n";
        LLNode<T> curNode = log;
        int count = 0;

        while (curNode != null)
        {
            count++;
            result += count + ". " + curNode.getInfo() + "\n";
            curNode = curNode.getLink();
        }
        return result;
    }

    // replaces the element at the specified position in this list
    // with the specified element
    public T set(int index, T element)
    {
        LLNode<T> current = this.log;
        for (int i = 0; i < index; i++) {
            current = current.getLink();
        }
        T oldElement = current.getInfo();
        current.setInfo(element);
        return oldElement;
    }

    // inserts the specified element at the specified position in this list
    public void add(int index, T element)
    {
        LLNode<T> current = this.log;
        for (int i = 0; i < index-1; i++) {
            current = current.getLink();
        }

        LLNode<T> next = current.getLink();
        LLNode<T> newLink = new LLNode<T>(element);

        current.setLink(newLink);
        newLink.setLink(next);

        this.size++;
    }

    // removes the element at the specified position in this list
    public T remove(int index)
    {
        if (index == 0) {
            T oldElement = this.log.getInfo();
            this.log = this.log.getLink();
            this.size--;
            return oldElement;
        }

        LLNode<T> previous = this.log;
        for (int i = 0; i < index-1; i++) {
            previous = previous.getLink();
        }



        LLNode<T> current = previous.getLink();
        LLNode<T> next = current.getLink();

        T oldElement = current.getInfo();

        previous.setLink(next);
        this.size--;

        return oldElement;
    }

    // removes the first occurance of the specified element from this
    // list, if it is present
    public boolean remove(T element)
    {
        int index = indexOf(element);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    // removes all of the elements from this list
    public void clear()
    {
        this.log = null;
        this.size = 0;
    }

    @Override
    public int search(Object o) {
        LLNode<T> current = this.log;
        if (current == null) {
            return -1;
        }
        int realIndex = 0;
        for (int i = size; i >= 0; i--) {
            if (current == null) {
                return -1;
            }
            if (current.getInfo() == o) {
                return realIndex;
            }
            realIndex++;
            current = current.getLink();
        }
        return -1;
    }
}
