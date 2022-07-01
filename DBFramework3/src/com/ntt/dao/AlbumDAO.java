package com.ntt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.ntt.dbcon.ConnectionHolder;
import com.ntt.dbcon.DBConnectionException;
import com.ntt.dbfw.DBFWException;
import com.ntt.dbfw.DBHelper;
import com.ntt.dbfw.ParamMapper;
import com.ntt.domain.Admin;
import com.ntt.domain.Album;

public class AlbumDAO {
static Logger log=Logger.getLogger(AlbumDAO.class);
	
	public static List getAlbum() throws DBFWException, AdminDAOException, DBConnectionException
	{
		List admin=null;
		ConnectionHolder ch=null;
		Connection con=null;
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			log.debug("fetchig");
			admin=DBHelper.executeSelect(con,SQLMapper.FETCHALBUM,SQLMapper.ALBUMMAPPER);
					
		} catch (DBConnectionException e) {
			throw new DBConnectionException("Unable to connect to db"+e);
		
		}
		finally {

			try {

				if (con != null)
					con.close();

			} catch (SQLException e) {
			}
		}
		
		
		return admin;
		
	}//getcountry
	public static List getAvailAlbum() throws DBFWException, AdminDAOException, DBConnectionException
	{
		List admin=null;
		ConnectionHolder ch=null;
		Connection con=null;
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			log.debug("fetchig");
			admin=DBHelper.executeSelect(con,SQLMapper.FETCHAVAILALBUM,SQLMapper.ALBUMMAPPER);
					
		} catch (DBConnectionException e) {
			throw new DBConnectionException("Unable to connect to db"+e);
		
		}
		finally {

			try {

				if (con != null)
					con.close();

			} catch (SQLException e) {
			}
		}
		
		
		return admin;
		
	}
	
	public static List getAdmin(final int aid,final String password)
	{
		ConnectionHolder ch=null;
		Connection con=null;
		List admin=null;
		
		try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
			final ParamMapper ADMINPMAPPER=new ParamMapper()
			{

				public void mapParam(PreparedStatement preStmt) throws SQLException {
				preStmt.setInt(1,aid);
				preStmt.setString(2,password);						
				}
				
			};//ananymous class
			
		admin=DBHelper.executeSelect
		(con,SQLMapper.FETCHADMINID,SQLMapper.ADMINMAPPER, ADMINPMAPPER );		
	
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;
		
	}//getcountry
	
	//insert
	public static int insertAlbum(final Album a)
	{
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			final ParamMapper INSERTPALBUM=new ParamMapper()
			{

				
				public void mapParam(PreparedStatement preStmt)
						throws SQLException {
					preStmt.setInt(1, a.getAlbumId());
					preStmt.setInt(2, a.getCategoryId());
					preStmt.setString(3, a.getAlbumTitle());
					preStmt.setInt(4, a.getHirePrice());
					preStmt.setInt(5, a.getNoofCD());
					preStmt.setString(6, a.getStatus());
				}
				
			};
			
		result=DBHelper.executeUpdate(con,SQLMapper.INSERTALBUM,INSERTPALBUM);
			
			
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		
	}//insert
	
}

