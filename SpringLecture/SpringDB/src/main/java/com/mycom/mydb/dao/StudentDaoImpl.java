package com.mycom.mydb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.mycom.mydb.common.DBManager;
import com.mycom.mydb.dto.StudentDto;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	private final DataSource dataSource;
	public StudentDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

    
    @Override
    public StudentDto studentDetail(int studentId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        StudentDto dto = null;
        
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("select student_id, student_nm, email, phone ");
            sb.append(" from student where student_id = ? ");
            
            con = dataSource.getConnection();
            pstmt = con.prepareStatement(sb.toString());
            pstmt.setInt(1, studentId);
            
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                dto = new StudentDto();
                dto.setStudentId(rs.getInt("student_id"));
                dto.setStudentNm(rs.getString("student_nm"));
                dto.setEmail(rs.getString("email"));
                dto.setPhone(rs.getString("phone"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.releaseConnection(rs, pstmt, con);
        }
        
        return dto;
    }

    @Override
    public List<StudentDto> studentList() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        List<StudentDto> list = new ArrayList<StudentDto>();
        
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("select student_id, student_nm, email, phone ");
            sb.append(" from student ");
            
            con = dataSource.getConnection();
            pstmt = con.prepareStatement(sb.toString());
            
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                StudentDto dto = new StudentDto();
                dto.setStudentId(rs.getInt("student_id"));
                dto.setStudentNm(rs.getString("student_nm"));
                dto.setEmail(rs.getString("email"));
                dto.setPhone(rs.getString("phone"));
                list.add(dto);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.releaseConnection(rs, pstmt, con);
        }
        
        return list;
    }


	@Override
	public int studentInsert(StudentDto dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int ret = -1;
		
			
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("insert into student (student_nm, email, phone) ");
			sb.append(" values (?, ?, ?) ");
			
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getStudentNm());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getPhone());
			
			ret = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(pstmt, con);
		}
		
		return ret;
	}

	

	@Override
	public int studentDelete(int studentId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int ret = -1;
		
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("delete from student where student_id=? ");
			
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, studentId);
			
			ret = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(pstmt, con);
		}
		
		return ret;
	}

    @Override
    public int studentUpdate(StudentDto dto) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int ret = -1;
        
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("update student set student_nm=?, email=?, phone=?");
            sb.append(" where student_id = ? ");
            
            con = dataSource.getConnection();
            pstmt = con.prepareStatement(sb.toString());
            
            pstmt.setString(1, dto.getStudentNm());
            pstmt.setString(2, dto.getEmail());
            pstmt.setString(3, dto.getPhone());
            pstmt.setInt(4, dto.getStudentId());
            
            ret = pstmt.executeUpdate();    // 성공 시 1건 리턴
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.releaseConnection(pstmt, con);
        }
        
        return ret;
    }

}
