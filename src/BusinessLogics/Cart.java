package BusinessLogics;

import java.util.HashMap;

import JavaBeans.SachOrder;

public class Cart extends HashMap<String,Integer> {
	public Cart()
	{
		super();
	}
	public void addBook(SachOrder book)
	{
		String key = book.getID();
		int k=1;
		if(this.containsKey(key))
		{
			int SoLuongMoi = this.get(key)+1;
			this.remove(key);
			this.put(key, SoLuongMoi);
		} else 
		{
			this.put(book.getID(),k);
		}
	}
	public boolean removeBook(String id)
	{
		if(this.containsKey(id))
		{
			this.remove(id);
			return true;
		}
		return false;
	}
}
