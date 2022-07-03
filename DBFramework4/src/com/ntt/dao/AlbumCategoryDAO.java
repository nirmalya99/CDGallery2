package com.ntt.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.ntt.dbcon.ConnectionHolder;
import com.ntt.dbcon.DBConnectionException;
import com.ntt.dbfw.DBFWException;
import com.ntt.dbfw.DBHelper;

public class AlbumCategoryDAO 
{
	static Logger log=Logger.getLogger(AlbumCategoryDAO.class);
	public static List getAlbumCategory() throws DBFWException, AlbumCategoryDAOException, DBConnectionException
	{
		List albumCategory=null;
		ConnectionHolder ch=null;
		Connection con=null;
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			log.debug("fetchig");
			albumCategory=DBHelper.executeSelect(con,SQLMapper.FETCHALBUMC,SQLMapper.ALBUMCMAPPER);
					
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
		
		
		return albumCategory;
		
	}//getcountry

}
