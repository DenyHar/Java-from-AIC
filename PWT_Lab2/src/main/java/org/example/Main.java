package org.example;

import org.example.GUI.Application;

public class Main {
    public static void main(String[] args) {
        new Application();
    }
//    public static final String QUERY1 = """
//            SELECT * FROM staff
//            WHERE position = ?;
//            """;
//
//    public static void main(String[] args) throws SQLException {
//        Queries queries = new Queries();
//        DBLineReadWriter readWriter = new DBLineReadWriter();
//        System.out.println("Begin");
//
//        Statement statement = DBConnection.GetConnection().createStatement();
//        ResultSet rs = statement.executeQuery(queries.SelectAllStaff());
//        while (rs.next()){
//            Staff s = readWriter.ReadWriteStaff(rs);
//            System.out.println(s.toString());
//
//        }
//        System.out.println();
//    }
}
