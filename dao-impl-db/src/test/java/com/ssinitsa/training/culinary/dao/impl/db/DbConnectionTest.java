package com.ssinitsa.training.culinary.dao.impl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnectionTest {
	public static void main(String[] args) {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/culinary", "postgres", "postgres");
            System.out.println("Соединение установлено.");

            Statement createStatement = con.createStatement();
            createStatement.execute("select * from ingredient  order by id");

            ResultSet resultSet = createStatement.getResultSet();
            resultSet.next();
            int id = resultSet.getInt("id");
            con.close();
            boolean next = resultSet.next();
            int id2 = resultSet.getInt("id");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
            }
        }
    }

}
