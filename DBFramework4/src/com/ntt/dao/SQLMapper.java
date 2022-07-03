package com.ntt.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ntt.dbfw.ResultMapper;
import com.ntt.domain.AlbumCategory;
import com.ntt.domain.AlbumDetails;
import com.ntt.domain.Hire;
import com.ntt.domain.User;

public class SQLMapper {
	
	public static final String FETCHCUST=
			"select * from USER where CUSTOMERID=? and PASSWORD=?";
	public static final String INSERTCUST=
		"insert into USER values(?,?,?,?,?,?,?,?,?,?)";
	public static final String FETCHALBUM=
			"select * from ALBUMDETAILS";
	public static final String FETCHALBUMID=
			"select * from ALBUMDETAILS where ALBUMID=?";
	public static final String FETCHAVAILALBUM=
			"select * from ALBUMDETAILS where STATUS='Available'";
	public static final String INSERTALBUM=
			"insert into ALBUMDETAILS values(?,?,?,?,?,?)";
	public static final String FETCHALBUMC=
			"select * from ALBUMCATEGORY";
	public static final String FETCHHIRE=
			"select * from HIRE";
	public static final String INSERTHIRE=
			"insert into HIRE values(?,?,?,?,?,?)";
	public static final ResultMapper CUSTMAPPER=
			new ResultMapper()
		{
			public Object mapRow(ResultSet rs) throws SQLException {
			 int  customerId=rs.getInt(1);
			 String password=rs.getString(2);
			 String firstName=rs.getString(3);
			 String secondName=rs.getString(4);
			 int dob=rs.getInt(5);
			 String address=rs.getString(6);
			 long contacttNo=rs.getLong(7);
			 long creditCardNo=rs.getLong(8);
			String creditCardType=rs.getString(9);
			int creditCardExpDate=rs.getInt(10);
			User u=new User(customerId,password,firstName,secondName,dob,address,contacttNo,creditCardNo,creditCardType,creditCardExpDate);
				return u;
			}//mapRow
			
		};
	public static final ResultMapper ALBUMMAPPER=
			new ResultMapper()
		{
			public Object mapRow(ResultSet rs) throws SQLException {
			int albumId=	rs.getInt(1);
			int categoryId=rs.getInt(2);
			String albumTitle=rs.getString(3);
			int hirePrice=rs.getInt(4);
		    int noofCD=rs.getInt(5);
		    String status=rs.getString(6);
			AlbumDetails al=new AlbumDetails(albumId,categoryId,albumTitle,hirePrice,noofCD,status);
				return al;
			}//mapRow
			
		};//Anonymous class
		public static final ResultMapper ALBUMCMAPPER=
				new ResultMapper()
			{
				public Object mapRow(ResultSet rs) throws SQLException {
		
				int categoryId=rs.getInt(1);
				String categoryName=rs.getString(2);
				String categoryDesc=rs.getString(3);
				AlbumCategory ac=new AlbumCategory(categoryId,categoryName,categoryDesc);
					return ac;
				}//mapRow
				
			};//Anonymous class
			public static final ResultMapper HIREMAPPER=
					new ResultMapper()
				{
					public Object mapRow(ResultSet rs) throws SQLException {
					int hireId=	rs.getInt(1);
					int customerId=rs.getInt(2);
					String albumId=rs.getString(3);
					Date hireDate=rs.getDate(4);
					Date returnDate=rs.getDate(5);
				    String status=rs.getString(6);
				    int totalHirePrice=rs.getInt(7);
					Hire h=new Hire(hireId,customerId,albumId,hireDate,returnDate,status,totalHirePrice);
						return h;
					}//mapRow
					
				};//Anonymous class
}









