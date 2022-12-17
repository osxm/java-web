/*
* @Title: H2Tests.java
* @Package com.osxm.jw
* @Description: TODO
* @author XM
* @date 2022年12月11日 下午12:50:29
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.jw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;





/**
 * 
 * @ClassName H2Tests
 * @Description TODO
 * @author XM 
 * @date 2022年12月11日
 * 
 */
public class H2Tests {

	//@Test
	public void connect() throws Exception {
		Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
		conn.close();
	}

	@Test
	public void initDb() throws Exception {
		Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
		Statement stmt = conn.createStatement();
		//stmt.execute("DROP TABLE MY_USER"); //删除已经存在的表
		stmt.execute("CREATE TABLE MY_USER(ID VARCHAR(10) PRIMARY KEY,NAME VARCHAR(50))"); //创建表
		stmt.executeUpdate("INSERT INTO MY_USER VALUES('001','刘备')"); //插入数据
		stmt.executeUpdate("INSERT INTO MY_USER VALUES('002','关羽')");
		stmt.executeUpdate("INSERT INTO MY_USER VALUES('003','张飞')");
		
		ResultSet rs = stmt.executeQuery("SELECT NAME FROM MY_USER WHERE ID='001'"); //查询
        while(rs.next()){ 
            String name = rs.getString("NAME");
            Assertions.assertTrue(name.equals("刘备"));
        }
        rs.close();
        stmt.close();
		conn.close();
	}
}
