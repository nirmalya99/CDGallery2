package com.ntt.dao;
import java.sql.Connection;
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
import com.ntt.domain.Hire;

public class HireDAO {
static Logger log=Logger.getLogger(HireDAO.class);
	
	public static List getHireDetails() throws DBFWException, HireDAOException, DBConnectionException
	{
		List hire=null;
		ConnectionHolder ch=null;
		Connection con=null;
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			log.debug("fetchig");
			hire=DBHelper.executeSelect(con,SQLMapper.FETCHHIRE,SQLMapper.HIREMAPPER);
					
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
		
		
		return hire;
		
	}//getcountry
	public static List getHireDetails(final int cid)
	{
		ConnectionHolder ch=null;
		Connection con=null;
		List album=null;
		
		try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
			final ParamMapper HIREPMAPPER=new ParamMapper()
			{

				public void mapParam(PreparedStatement preStmt) throws SQLException {
				preStmt.setInt(1,cid);
					
				}
				
			};//ananymous class
			
		album=DBHelper.executeSelect
		(con,SQLMapper.FETCHHIREID,SQLMapper.HIREMAPPER, HIREPMAPPER );		
	
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return album;
		
	}//getcountry
	
	public static int insertHire(final Hire h)
	{
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			final ParamMapper INSERTPHIRE=new ParamMapper()
			{

				
				public void mapParam(PreparedStatement preStmt)
						throws SQLException {
					preStmt.setInt(1, h.getHireId());
					preStmt.setInt(2, h.getCustomerId());
					preStmt.setInt(3, h.getAlbumId());
					preStmt.setString(4,  h.getHireDate());
					preStmt.setString(5, h.getReturnDate());
					preStmt.setString(6, h.getStatus());
					preStmt.setInt(7, h.getTotalHirePrice());
				}
				
			};
			
		result=DBHelper.executeUpdate(con,SQLMapper.INSERTHIRE,INSERTPHIRE);
			
			
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
