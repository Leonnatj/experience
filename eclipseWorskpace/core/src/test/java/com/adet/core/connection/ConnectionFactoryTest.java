package com.adet.core.connection;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.adet.core.connection.ConnectionFactory;

public class ConnectionFactoryTest {

	@Test
	public void test() {
		Connection con = ConnectionFactory.getConnection(ConnectionFactory.TYPE_MYSQL);
		assertNotNull(con);
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
