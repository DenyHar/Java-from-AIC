package org.example;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class DBDelete {
    public static String DeleteStaff(Integer id){
        try {
            PreparedStatement statement = DBConnection.GetConnection().prepareStatement(Queries.DeleteStaff());
            statement.setInt(1, id);
            if (statement.executeUpdate() != 0){
                return "Операцію успішно виконано";
            }else{return "Такого запису немає в базі даних";}

        }catch (SQLException e){
            return e.getMessage();
        }
    }
    public static String DeleteClient(Integer id){
        try {
            PreparedStatement statement = DBConnection.GetConnection().prepareStatement(Queries.DeleteClients());
            statement.setInt(1, id);
            if (statement.executeUpdate() != 0){
                return "Операцію успішно виконано";
            }else{return "Такого запису немає в базі даних";}

        }catch (SQLException e){
            return e.getMessage();
        }
    }
    public static String DeleteMenu(Integer id){
        try {
            PreparedStatement statement = DBConnection.GetConnection().prepareStatement(Queries.DeleteMenu());
            statement.setInt(1, id);
            if (statement.executeUpdate() != 0){
                return "Операцію успішно виконано";
            }else{return "Такого запису немає в базі даних";}

        }catch (SQLException e){
            return e.getMessage();
        }
    }
    public static String DeleteOrder(Integer id){
        try {
            PreparedStatement statement = DBConnection.GetConnection().prepareStatement(Queries.DeleteOrders());
            statement.setInt(1, id);
            if (statement.executeUpdate() != 0){
                return "Операцію успішно виконано";
            }else{return "Такого запису немає в базі даних";}

        }catch (SQLException e){
            return e.getMessage();
        }
    }
    public static String DeleteSchedule(Integer id, LocalDate date){
        try {
            PreparedStatement statement = DBConnection.GetConnection().prepareStatement(Queries.DeleteSchedules());
            statement.setInt(1, id);
            statement.setDate(2, Date.valueOf(date));
            if (statement.executeUpdate() != 0){
                return "Операцію успішно виконано";
            }else{return "Такого запису немає в базі даних";}

        }catch (SQLException e){
            return e.getMessage();
        }
    }
}
