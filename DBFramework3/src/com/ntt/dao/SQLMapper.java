package com.ntt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ntt.dbfw.ResultMapper;
import com.ntt.domain.Admin;
import com.ntt.domain.Album;

public class SQLMapper {
	public static final String FETCHADMIN=
		"select * from Admin";
	public static final String FETCHADMINID=
		"select AdminId,Password from Admin where AdminId=? and Password=?";
	public static final String INSERTCOUNTRY=
		"insert into country_081 values(?,?)";
	public static final String FETCHALBUM=
			"select * from Album";
	public static final String FETCHAVAILALBUM=
			"select * from Album where NumberOfCDs>0";
	public static final String INSERTALBUM=
			"insert into Album values(?,?,?,?,?,?)";
	
	public static final ResultMapper ADMINMAPPER=
		new ResultMapper()
	{
		public Object mapRow(ResultSet rs) throws SQLException {
		int id=	rs.getInt(1);
		String name=rs.getString(2);
		Admin c=new Admin(id,name);
			return c;
		}//mapRow
		
	};//Anonymous class
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
			Album al=new Album(albumId,categoryId,albumTitle,hirePrice,noofCD,status);
				return al;
			}//mapRow
			
		};//Anonymous class
}









