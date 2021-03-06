package com.ntt.driver;
import java.util.Iterator;
import java.util.List;
import java.util.Date;
import java.time.LocalDate;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Scanner;
import javax.net.ssl.SSLException;
import java.util.ArrayList;
import com.ntt.dbcon.DBConnectionException;
import com.ntt.dbfw.DBFWException;
import com.ntt.domain.AlbumCategory;
import com.ntt.domain.AlbumDetails;
import com.ntt.domain.Hire;
import com.ntt.domain.User;
import com.ntt.dao.*;
public class Driver {
	
public static void actions() throws DBConnectionException{
	List alist=null;
	int ch=0;
	int adminStatus=0;
	Scanner sc=new Scanner(System.in);
	do {
		System.out.println("--MENU--");
		System.out.println("1.Add Album");
		System.out.println("2.View All Albums");
		System.out.println("3.View available Albums");
		System.out.println("4.View Rental Table");
		System.out.println("Enter ur ch");
		ch=sc.nextInt();
		switch(ch) {
		case 1:
			//inserting
			int result=0;
			System.out.println("enter Album id");
			int Albumid=sc.nextInt();
			System.out.println("Enter Category ID");
			int CategoryId=sc.nextInt();
			sc.nextLine();
		System.out.println("Enter Album Title");
			String albumTitle=sc.nextLine();
			System.out.println("Enter HirePrice ");
			int hirePrice=sc.nextInt();
			System.out.println("Enter no of CDs");
			int noofCDs=sc.nextInt();
			System.out.println("Enter Status ");
			String status=sc.next();
			AlbumDetails a=new AlbumDetails(Albumid,CategoryId,albumTitle,hirePrice,noofCDs,status);
			result=AlbumDetailsDAO.insertAlbum(a);
			if(result!=0)
			{
				System.out.println("Album inserted successfully");
			}
			else
			{
				System.out.println("Failed to insert");
			}
			
			break;
		case 2:
			try {
				alist=AlbumDetailsDAO.getAlbum();
				System.out.println("Details of Album are");
				System.out.println("****************");
				for(Iterator it=alist.iterator();it.hasNext();)
				{
					AlbumDetails a2=(AlbumDetails) it.next();
					System.out.println(a2);
					System.out.println("----------------");
//				}
				
			}}
			catch (DBFWException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				e.printStackTrace();
			} catch (AlbumDetailsDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			try {
				alist=AlbumDetailsDAO.getAvailAlbum();
				System.out.println("Details of Available Album are");
				System.out.println("*************************");
				for(Iterator it=alist.iterator();it.hasNext();)
				{
					AlbumDetails a3=(AlbumDetails) it.next();
					System.out.println(a3);
					System.out.println("----------------");
//				}
				
			}}
			catch (DBFWException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				e.printStackTrace();
			} catch (AlbumDetailsDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case 4:
			try {
				alist=HireDAO.getHireDetails();
				System.out.println("Details of Album are");
				System.out.println("****************");
				for(Iterator it=alist.iterator();it.hasNext();)
				{
					Hire h2=(Hire) it.next();
					System.out.println(h2);
					System.out.println("----------------");
//				}
				
			}}
			catch (DBFWException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				e.printStackTrace();
			} catch (HireDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		System.out.println("Do you wish to continue(press any number not zero)");
		adminStatus=sc.nextInt();
		if(adminStatus==0) {
			System.out.println("You have successsfully logged out");
			System.out.println("Returning to Main Menu");
		}
		
	}while(!(adminStatus==0));
}
public static void custActions(int cid) throws DBConnectionException{
	int cId=cid;
	List clist=null;
	List clist2=null;
	int ch=0;
	int s=0;
	int id=0;
	int custStatus=0;
	Scanner sc=new Scanner(System.in);
	do {
		System.out.println("--MENU--");
		System.out.println("1.Search Album ");
		System.out.println("2.Book Album");
		System.out.println("3.View Booked album");
		
		System.out.println("Enter ur ch");
		ch=sc.nextInt();
		int result;
		switch(ch) {
		case 1:
			System.out.println("To search Album by category press 1");
			System.out.println("To view all albums press 2");
			s=sc.nextInt();
			if(s==1) {
			try {
				clist=AlbumCategoryDAO.getAlbumCategory();
				System.out.println("****************");
				for(Iterator it=clist.iterator();it.hasNext();)
				{
					AlbumCategory a2=(AlbumCategory) it.next();
					System.out.println(a2);
					System.out.println("----------------");
//				}
				
			}}
			catch (DBFWException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				e.printStackTrace();
			} catch (AlbumCategoryDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(s==2) {
				try {
					clist=AlbumDetailsDAO.getAlbum();
					System.out.println("Details of Album are");
					System.out.println("****************");
					for(Iterator it=clist.iterator();it.hasNext();)
					{
						AlbumDetails a2=(AlbumDetails) it.next();
						System.out.println(a2);
						System.out.println("----------------");
//					}
					
				}}
				catch (DBFWException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
					e.printStackTrace();
				} catch (AlbumDetailsDAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		case 2:
			try {
				clist=AlbumDetailsDAO.getAlbum();
				System.out.println("Details of Album are here ");
				System.out.println("****************");
				for(Iterator it=clist.iterator();it.hasNext();)
				{
					AlbumDetails a2=(AlbumDetails) it.next();
					System.out.println(a2);
					System.out.println("----------------");
//				}
				
			}}
			catch (DBFWException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				e.printStackTrace();
			} catch (AlbumDetailsDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Enter AlbumId to book particular Album");
	           id=sc.nextInt();
	           sc.nextLine();
	           clist2=AlbumDetailsDAO.getAlbum(id);
	           String s1=clist2.toString();   
	           String []arr=s1.split(",");
	           ArrayList<String> b=new ArrayList<String>();
	           for(String s2:arr){
	               String []a=s2.split("=");
	               b.add(a[1]);
	           }
	           int aid=Integer.valueOf(b.get(0));
	           int cd=Integer.valueOf(b.get(4));
	           int hp=Integer.valueOf(b.get(3));
	           String status=b.get(5).substring(0,b.get(5).length()-1);
	           if(status.equals("Unavailable")) {
	        	   System.out.println("No CD left to book");
	        	   break;
	           }
	           cd=cd-1;
	           if(cd==0) {
	        	   status="Unavailable";
	           }
	           System.out.println("Enter Hire Id");
	           int hid=sc.nextInt();
	           sc.nextLine();
	           DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	           Date date = new Date();
	           String sHireDate=dateFormat.format(date);
	           System.out.println(sHireDate);
	           System.out.println("Enter at what date will you return the book in (dd/MM/yyyy) ?");
	           String sReturnDate=sc.nextLine();
	           int d1=0,d2=0;
	   	    if (sHireDate.charAt(0)=='0')
	   	    {
	   	         d1=Character.getNumericValue(sHireDate.charAt(1));
	   	        
	   	    }
	   	    else{
	   	         d1=Integer.valueOf(sHireDate.substring(0,2));
	   	    }
	   	  if (sReturnDate.charAt(0)=='0')
	   	    {
	   	         d2=Character.getNumericValue(sReturnDate.charAt(1));
	   	        
	   	    }
	   	    else{
	   	         d2=Integer.valueOf(sReturnDate.substring(0,2));
	   	    }
	   	  int netD=d2-d1;
	   	  int totalHirePrice=netD*hp;
	  	Hire h=new Hire(hid,cId,aid,sHireDate,sReturnDate,status,totalHirePrice);
		result=HireDAO.insertHire(h);
		if(result!=0)
		{
			System.out.println("Rental details inserted successfully");
		}
		else
		{
			System.out.println("Failed to insert");
		}  
		case 3:
			clist=HireDAO.getHireDetails(cid);
			System.out.println("Details of Album are");
			System.out.println("****************");
			for(Iterator it=clist.iterator();it.hasNext();)
			{
				Hire a2=(Hire) it.next();
				System.out.println(a2);
				System.out.println("----------------");
//				}
			
}
			break;
		}
		System.out.println("Do you wish to continue(press any number not zero)");
		custStatus=sc.nextInt();
		if(custStatus==0) {
			System.out.println("You have successsfully logged out");
			System.out.println("Returning to Main Menu");
		}
	
			
			
	}
	while(!(custStatus==0));
	
}
	
static void userRegistration() {
	int result=0;
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter new Customer ID");
	int  customerId=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter new Password");
	String password=sc.nextLine();
	System.out.println("Enter First_Name");
	String firstName=sc.nextLine();
	System.out.println("Enter Second_Name");
	String secondName=sc.nextLine();
	System.out.println("Enter Date of Birth");
	int dob=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter Address");
	String address=sc.nextLine();
	System.out.println("Enter Contact Number");
	long ctNo=sc.nextLong();
	System.out.println("Enter Credit Card No");
	long ccNo=sc.nextLong();
	sc.nextLine();
	System.out.println("Enter Credit Card Type");
	  String ccType=sc.nextLine();
	  System.out.println("Enter Credit Card Expiry Date");
	  int ccExp=sc.nextInt();
	  User u=new User(customerId,password,firstName,secondName,dob,address,ctNo,ccNo,ccType,ccExp);
		result=UserDAO.insertCustomer(u);
		if(result!=0)
		{
			System.out.println("User registered successfully");
		}
		else
		{
			System.out.println("Failed to insert");
		}
	  
}
	public static void main(String arg[])throws DBConnectionException
	{
		List clist=null;
		int ch=0;
		int login=0;
		int status=0;
		
		Scanner sc=new Scanner(System.in);
		do{
			System.out.println("--MENU--");
			System.out.println("1.User Registration");
			System.out.println("2.User Login");
			System.out.println("3.Admin Login");
			System.out.println("Enter ur ch");
			ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
				userRegistration();
				System.out.println("For login press 1");
				login=sc.nextInt();
				if(login!=1)
				break;
			case 2 :
				List list1=null;
				 sc=new Scanner(System.in);
				System.out.println("\nEnter customer id\n");
				int cid=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the customer password");
				String cpassword=sc.nextLine();
				System.out.println("");
				list1=UserDAO.getCust(cid,cpassword);
				
				if(!(list1.isEmpty()))
				{
				System.out.println("Successfully Logged in ");
				       custActions(cid);
				}
				else
				{
					System.out.println("Invalid customer details");
				}
				break;
			case 3:
				final int aid=1;
				final String password="super";
				 sc=new Scanner(System.in);
				System.out.println("\nEnter the admin id\n");
				int id=sc.nextInt();
				System.out.println("Enter the admin password");
				String pass=sc.next();
				
				if(id==aid && pass.equals(password))
				{
				System.out.println("Successfully Logged in ");
				       actions();
				}
				else
				{
					System.out.println("Invalid admin details");
				}
				break;
			
			
			
			
			
			}//switch
			System.out.println("Do you wish to continue(press any number not zero)");
			status=sc.nextInt();
			
			
			
		}
		while(!(status==0));
		System.out.println("\n\n Thank You \n\n");
			
	}
}
