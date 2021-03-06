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
import com.ntt.domain.AlbumDetails;

public class AlbumDetailsDAO {
static Logger log=Logger.getLogger(AlbumDetailsDAO.class);
	
	public static List getAlbum() throws DBFWException, AlbumDetailsDAOException, DBConnectionException
	{
		List album=null;
		ConnectionHolder ch=null;
		Connection con=null;
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			log.debug("fetchig");
			album=DBHelper.executeSelect(con,SQLMapper.FETCHALBUM,SQLMapper.ALBUMMAPPER);
					
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
		
		
		return album;
		
	}//getcountry
	public static List getAvailAlbum() throws DBFWException, AlbumDetailsDAOException, DBConnectionException
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
	
	public static List getAlbum(final int aid)
	{
		ConnectionHolder ch=null;
		Connection con=null;
		List album=null;
		
		try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
			final ParamMapper ALBUMPMAPPER=new ParamMapper()
			{

				public void mapParam(PreparedStatement preStmt) throws SQLException {
				preStmt.setInt(1,aid);
					
				}
				
			};//ananymous class
			
		album=DBHelper.executeSelect
		(con,SQLMapper.FETCHALBUMID,SQLMapper.ALBUMMAPPER, ALBUMPMAPPER );		
	
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return album;
		
	}//getcountry
	
	//insert
	public static int insertAlbum(final AlbumDetails a)
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

