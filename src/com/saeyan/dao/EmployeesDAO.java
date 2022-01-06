package com.saeyan.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.*;

import com.saeyan.dto.EmployeesVO;

import util.DBManager;

import javax.naming.*;

public class EmployeesDAO {

	private EmployeesDAO() {
		
	}
	private static EmployeesDAO instance = new EmployeesDAO();
	
	public static EmployeesDAO getInstance() {
		return instance;
	}
	
	public List<EmployeesVO> selectAllEmployees(){
		List<EmployeesVO> list = new ArrayList<EmployeesVO>();
		String sql = "select * from employees";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmployeesVO eVo = new EmployeesVO();
				eVo.setId(rs.getString("id"));
				eVo.setPass(rs.getString("pass"));
				eVo.setEnter(rs.getString("enter"));
				eVo.setLev(rs.getString("lev"));
				eVo.setGender(rs.getString("gender"));
				eVo.setName(rs.getString("name"));
				eVo.setPhone(rs.getString("phone"));
				list.add(eVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		
		return list;
	}
	
	public EmployeesVO selectEmployeesById(String id) {
		String sql = "select * from employees where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeesVO eVo = new EmployeesVO();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				eVo.setId(rs.getString("id"));
				eVo.setPass(rs.getString("pass"));
				eVo.setEnter(rs.getString("enter"));
				eVo.setLev(rs.getString("lev"));
				eVo.setGender(rs.getString("gender"));
				eVo.setName(rs.getString("name"));
				eVo.setPhone(rs.getString("phone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return eVo;
	}

	public void insertEmployees(EmployeesVO eVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into employees(id,pass,name,lev,gender,phone) "
				+ "values(?,?,?,?,?,?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eVo.getId());
			pstmt.setString(2, eVo.getPass());
			pstmt.setString(3, eVo.getName());
			pstmt.setString(4, eVo.getLev());
			pstmt.setString(5, eVo.getGender());
			pstmt.setString(6, eVo.getPhone());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void updateEmployees(EmployeesVO eVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update employees set pass=?, name=?, lev=?, gender=?, phone=? where id=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eVo.getPass());
			pstmt.setString(2, eVo.getName());
			pstmt.setString(3, eVo.getLev());
			pstmt.setString(4, eVo.getGender());
			pstmt.setString(5, eVo.getPhone());
			pstmt.setString(6, eVo.getId());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public void deleteEmployees(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete employees where id=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
}
