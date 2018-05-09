package com.kodilla.jdbc;

import com.mysql.cj.xdevapi.SqlDataResult;
import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StoredProcTestSuite {

    @Test
    public void testUpdateVipLevel() throws SQLException {

        //given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        //when

        String sqlProcedureCall = "CALL updateVipLevels()";
        statement.execute(sqlProcedureCall);
        //then

        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");

            Assert.assertEquals(0, howMany);
        }
    }

    @Test
    public void testUpdateBestsellers() throws SQLException {

        //given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE BOOKS SET BESTSELLER = NULL";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        //when
        String sqlProcedureCall = "CALL updateBestseller()";
        statement.execute(sqlProcedureCall);
        //then
        try {
            String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER IS NULL";
            ResultSet rs = statement.executeQuery(sqlCheckTable);
            int howMany = -1;
            if (rs.next()) {
                howMany = rs.getInt("HOW_MANY");
                Assert.assertEquals(0, howMany);
            }
        } catch (SQLException ex) {
            Assert.fail();
        } finally {
            statement.close();
        }
    }
}

