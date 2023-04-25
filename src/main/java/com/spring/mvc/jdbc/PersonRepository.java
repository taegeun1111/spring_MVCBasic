package com.spring.mvc.jdbc;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class PersonRepository {

    private String url = "jdbc:mariadb://localhost:3306/spring";
    private String username = "root";
    private String password = "1111";

    //1.드라이버 클래스를 로딩 (mariadb 커넥터 로딩)
    public PersonRepository() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //사람 저장 기능
    public void save(Person person) {
        Connection conn = null;
        //2.DB 연결
        //Connection : DB 연결 정보를 가지며, SQL을 작성할 수 있는 Statement 객체를 받을 수 있다.
        try {
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false); //오토커밋 비활성화

            //SQL을 실행할 수 있는 객체 얻기
            String sql = "INSERT INTO person (person_name,person_age) VALUES (?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            //?값 세팅하기
            pstmt.setString(1, person.getPersonName());
            pstmt.setInt(2, person.getPersonAge());

            //sql 실행하기
            //INSERT, UPDATE, DELETE : executeUpdate()
            //SELECT : executeQuery()

            //executeUpdate()는 성공한 코리의 수를 반환
            int result = pstmt.executeUpdate();

            if (result == 1) conn.commit();
            else conn.rollback();

        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void insert(Person person) {
        Connection conn = null;
        //2.DB 연결
        //Connection : DB 연결 정보를 가지며, SQL을 작성할 수 있는 Statement 객체를 받을 수 있다.
        try {
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false); //오토커밋 비활성화

            //SQL을 실행할 수 있는 객체 얻기
            String sql = "UPDATE person SET person_name=?, person_age=? WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            //?값 세팅하기
            pstmt.setString(1, person.getPersonName());
            pstmt.setInt(2, person.getPersonAge());
            pstmt.setLong(3, person.getId());

            //sql 실행하기
            //INSERT, UPDATE, DELETE : executeUpdate()
            //SELECT : executeQuery()

            //executeUpdate()는 성공한 코리의 수를 반환
            int result = pstmt.executeUpdate();

            if (result == 1) conn.commit();
            else conn.rollback();

        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void remove(Long id) {
        Connection conn = null;
        //2.DB 연결
        //Connection : DB 연결 정보를 가지며, SQL을 작성할 수 있는 Statement 객체를 받을 수 있다.
        try {
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false); //오토커밋 비활성화

            //SQL을 실행할 수 있는 객체 얻기
            String sql = "DELETE FORM person WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            //?값 세팅하기
            pstmt.setLong(1, id);

            //sql 실행하기
            //INSERT, UPDATE, DELETE : executeUpdate()
            //SELECT : executeQuery()

            //executeUpdate()는 성공한 코리의 수를 반환
            int result = pstmt.executeUpdate();

            if (result == 1) conn.commit();
            else conn.rollback();

        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                e.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
