package application;

import db.DB;

import java.sql.*;

public class Program {
    public static void main(String[] args) {

        Connection cnn = null;
        PreparedStatement st = null;

        try{
            cnn = DB.getConection();

            st = cnn.prepareStatement(
                    "update seller "
                    + "set baseSalary = basesalary + ? "
                    + "where "
                    + "(departmentId = ?)");

            st.setDouble(1, 200.0);
            st.setInt(2, 2);

            int rowsAffected =  st.executeUpdate();
            System.out.println("Linhas Afetadas: " + rowsAffected);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
