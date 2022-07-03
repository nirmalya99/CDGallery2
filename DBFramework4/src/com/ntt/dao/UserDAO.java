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
import com.ntt.domain.User;

public class UserDAO {
static Logger log=Logger.getLogger(UserDAO.class);
	
	public static List getCust() throws DBFWException, UserDAOException, DBConnectionException
	{
		List cust=null;
		ConnectionHolder ch=null;
		Connection con=null;
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			log.debug("fetchig");
			cust=DBHelper.executeSelect(con,SQLMapper.FETCHCUST,SQLMapper.CUSTMAPPER);
					
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
		
		
		return cust;
		
	}//getcountry
	
	public static List getCust(final int cid,final String password)
	{
		ConnectionHolder ch=null;
		Connection con=null;
		List cust=null;
		
		try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
			final ParamMapper CUSTPMAPPER=new ParamMapper()
			{

				public void mapParam(PreparedStatement preStmt) throws SQLException {
				preStmt.setInt(1,cid);
				preStmt.setString(2,password);	
				
				}
				
			};//ananymous class
			
		cust=DBHelper.executeSelect
		(con,SQLMapper.FETCHCUST,SQLMapper.CUSTMAPPER, CUSTPMAPPER );		
	
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			System.out.println("Hello");
			e.printStackTrace();
		}
		return cust;
		
	}//getcountry
	
	//insert
	public static int insertCustomer(final User u)
	{
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			final ParamMapper INSERTPCUST=new ParamMapper()
			{

				
				public void mapParam(PreparedStatement preStmt)
						throws SQLException {
					preStmt.setInt(1, u.getCustomerId());
					preStmt.setString(2, u.getPassword());
					preStmt.setString(3, u.getFirstName());
					preStmt.setString(4, u.getSecondName());
					preStmt.setInt(5, u.getDob());
					preStmt.setString(6, u.getAddress());
					preStmt.setLong(7, u.getContactNo());
					preStmt.setLong(8, u.getCreditCardNo());
					preStmt.setString(9, u.getCreditCardType());
					preStmt.setInt(10, u.getCreditCardExpDate());
				}
				
			};
			
		result=DBHelper.executeUpdate(con,SQLMapper.INSERTCUST,INSERTPCUST);
			
			
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
