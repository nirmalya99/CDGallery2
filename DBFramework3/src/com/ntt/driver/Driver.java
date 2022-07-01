package com.ntt.driver;
import com.ntt.dao.AdminDAOException;
import com.ntt.dao.AlbumDAOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.net.ssl.SSLException;
import com.ntt.dao.AdminDAO;
import com.ntt.dao.AlbumDAO;
import com.ntt.dbcon.DBConnectionException;
import com.ntt.dbfw.DBFWException;
import com.ntt.domain.Admin;
import com.ntt.domain.Album;
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
		System.out.println("Enter Album Title");
			String albumTitle=sc.next();
			System.out.println("Enter HirePrice ");
			int hirePrice=sc.nextInt();
			System.out.println("Enter no of CDs");
			int noofCDs=sc.nextInt();
			System.out.println("Enter Status ");
			String status=sc.next();
			Album a=new Album(Albumid,CategoryId,albumTitle,hirePrice,noofCDs,status);
			result=AlbumDAO.insertAlbum(a);
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
				alist=AlbumDAO.getAlbum();
				System.out.println("Details of Album are");
				System.out.println("****************");
				for(Iterator it=alist.iterator();it.hasNext();)
				{
					Album a2=(Album) it.next();
					System.out.println(a2);
					System.out.println("----------------");
//				}
				
			}}
			catch (DBFWException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				e.printStackTrace();
			} catch (AdminDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			try {
				alist=AlbumDAO.getAvailAlbum();
				System.out.println("Details of Available Album are");
				System.out.println("*************************");
				for(Iterator it=alist.iterator();it.hasNext();)
				{
					Album a3=(Album) it.next();
					System.out.println(a3);
					System.out.println("----------------");
//				}
				
			}}
			catch (DBFWException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				e.printStackTrace();
			} catch (AdminDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Do you wish to continue(press any number not zero)");
		adminStatus=sc.nextInt();
		if(adminStatus==0) {
			System.out.println("You have successsfully logged out");
			System.out.println("Returning to Main Menu");
		}
		
	}while(!(adminStatus==0));
}
	
	public static void main(String arg[])throws DBConnectionException
	{
		List clist=null;
		int ch=0;
		int status=0;
		
		Scanner sc=new Scanner(System.in);
		do{
			System.out.println("--MENU--");
			System.out.println("1.Insert");
			System.out.println("2.Admin Login");
			System.out.println("3.User Login");
			System.out.println("Enter ur ch");
			ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:
				//inserting
//				int result=0;
//				System.out.println("enter cid");
//				int id=sc.nextInt();
//				System.out.println("Enter cname");
//				String name=sc.next();
//				Admin c=new Admin(id,name);
//				result=AdminDAO.insertCountry(c);
//				if(result!=0)
//				{
//					System.out.println("Country inserted successfully");
//				}
//				else
//				{
//					System.out.println("Failed to insert");
//				}
				
				break;
			case 2:
				try {
					clist=AdminDAO.getAdmin();
//					System.out.println("Details of countries are");
//					System.out.println("-------------------------");
//					for(Iterator it=clist.iterator();it.hasNext();)
//					{
//						Country c1=(Country) it.next();
//						System.out.println(c1);
//					}
					
				//	Geting the country details by passing the countryid
					List list1=null;
					 sc=new Scanner(System.in);
					System.out.println("\nEnter the admin id\n");
					int aid=sc.nextInt();
					System.out.println("Enter the admin password");
					String password=sc.next();
					System.out.println("");
					list1=AdminDAO.getAdmin(aid,password);
					
					if(!(list1.isEmpty()))
					{
					System.out.println("Successfully Logged in ");
					       actions();
					}
					else
					{
						System.out.println("Invalid admin details");
					}
					
					
					
				} catch (DBFWException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
					e.printStackTrace();
				} catch (AdminDAOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
