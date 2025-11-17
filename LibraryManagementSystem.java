package satya3;
class library
{
	int capacity;
	book[] books;
	book[] borroweditems;
	library(int capacity)
	{
		this.capacity=capacity;
		books=new book[capacity];
	}
	void addbook(book b,int index)
	{
		if(index>=0 && index<=capacity)
		{
			books[index]=b;
		}
	}
	void issuebook(String bookname,user i)
	{
		for(book b1:books)
		{
			if(b1!=null && b1.bookname.contentEquals(bookname) && !b1.isissued)
			{
				if(i.borrowedbook(b1))
				{
				b1.issue();
				}
				return;
				
				
			}
		}
		System.out.println("book is not available");
	}
	void returnbook(String bookname,user i)
	{
		for(book b1:books)
		{
			if(b1!=null && b1.bookname.contentEquals(bookname) && b1.isissued)
			{
				if(i.returnedbook(b1))
				{
				b1.returnBook();
				return;
				}
			}
		}
		System.out.println("book is not issued");
	}
	void showbooks()
	{
		for(book b1:books)
		{
			if(b1!=null)
			{
				b1.display();
				
			}
		}
	}
}
class user
{
	
	book[] borroweditems=new book[5];
	String name;
	user(String name)
	{
		this.name=name;
	}
	 boolean borrowedbook(book b2)
	{
		for(int i=0;i<borroweditems.length;i++)
		{
			if(borroweditems[i]==null)
			{
				borroweditems[i]=b2;
				return true;
			}
		}
		return false;
	}
	boolean returnedbook(book b2)
	{
		for(int i=0;i<borroweditems.length;i++)
		{
			if(borroweditems[i]==b2)
			{
				borroweditems[i]=null;
				return true;
			}
		}
		return false;
	}
	void showborrowedbooks()
	{
		System.out.println(name+"'s borrowed books are:");
		for(book b3:borroweditems)
		{
			if(b3!=null)
			{
			System.out.println("-"+b3.bookname);
			}
		}
	}
	
}
class book
{
	String bookname;
	String authorname;
	boolean isissued=false;
	book(String bookname,String authorname)
	{
		this.bookname=bookname;
		this.authorname=authorname;
		isissued=false;
	}
	void issue()
	{
		isissued=true;
		System.out.println(bookname +"has been issued");
		
	}
	void returnBook()
	{
		isissued=false;
		System.out.println(bookname+"has been returned");
	}
	void display()
	{
		
	        System.out.println(bookname + " by " + authorname + " - " + (isissued ? "Issued" : "Available"));
	}
}
public class LibraryManagementSystem 
{

	public static void main(String[] args) 
	{
		library lib = new library(100);
		lib.addbook(new book("hello to world","satya"),0);
		lib.addbook(new book("hello to world1","satyaraj"),1);
		lib.addbook(new book("hello to world2","ranil"),2 );
		lib.addbook(new book("hello to world3","silruti"),3);
		lib.addbook(new book("hello to world4","satyajit"),4);
		lib.addbook(new book("hello to world5","shanaya"),5);
		lib.addbook(new book("secrets of life","edin"),6);
		lib.showbooks();
		user u1=new user("sneha");
		user u2=new user("shree");
		lib.issuebook("hello to world",u1);
		lib.issuebook("hello to world1",u2);
		lib.issuebook("hello to world2",u2);
		u1.showborrowedbooks();
		u2.showborrowedbooks();
		lib.showbooks();
	}

}
