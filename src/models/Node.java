package models;

public class Node<T>
{
	private T value;
	private Node<T> next;
	
	public Node()
	{
		
	}
	
	public Node(T value)
	{
		this.setValue(value);
	}
	
	public void setValue(T value)
	{
		this.value = value;
	}
	
	public void setNext(Node<T> value)
	{
		this.next = value;
	}
	
	public T getValue()
	{
		return this.value;
	}
	
	public Node<T> getNext()
	{
		return this.next;
	}
	
	public boolean hasNext()
	{
		return this.next != null;
	}
}

