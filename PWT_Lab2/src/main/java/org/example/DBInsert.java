package org.example;

import java.awt.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DBInsert {
    public static String InsertStaff(Integer id, String name, Integer phone, String address, String position){
        try {
            PreparedStatement statement = DBConnection.GetConnection().prepareStatement(Queries.InsertStaff());
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setInt(3, phone);
            statement.setString(4, address);
            statement.setString(5, position);
            if (statement.executeUpdate() != 0){
                return "Операцію успішно виконано";
            }else{return "Такого запису немає в базі даних";}

        }catch (SQLException e){
            return e.getMessage();
        }
    }
    public static String InsertClient(Integer id, String name, Integer phone, Integer discount){
        try {
            PreparedStatement statement = DBConnection.GetConnection().prepareStatement(Queries.InsertClients());
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setInt(3, phone);
            statement.setInt(4, discount);
            if (statement.executeUpdate() != 0){
                return "Операцію успішно виконано";
            }else{return "Такого запису немає в базі даних";}

        }catch (SQLException e){
            return e.getMessage();
        }
    }
    public static String InsertMenu(Integer id, String nameUa, String nameEng, String type, Double price){
        try {
            PreparedStatement statement = DBConnection.GetConnection().prepareStatement(Queries.InsertMenu());
            statement.setInt(1, id);
            statement.setString(2, nameUa);
            statement.setString(3, nameEng);
            statement.setString(4, type);
            statement.setDouble(5, price);
            if (statement.executeUpdate() != 0){
                return "Операцію успішно виконано";
            }else{return "Такого запису немає в базі даних";}

        }catch (SQLException e){
            return e.getMessage();
        }
    }
    public static String InsertOrder(Integer id, ArrayList<Integer> menuID, Integer waiterID, Integer clientID, LocalDate date){
        try {
            String result = "";
            PreparedStatement statement = DBConnection.GetConnection().prepareStatement(Queries.InsertOrders());
            statement.setInt(1, id);
            statement.setInt(2, waiterID);
            statement.setInt(3, clientID);
            statement.setDate(4, Date.valueOf(date));
            if (statement.executeUpdate() != 0){
                for (Integer menu : menuID){
                    try {
                        statement = DBConnection.GetConnection().prepareStatement(Queries.InsertOrderMenu());
                        statement.setInt(1, id);
                        statement.setInt(2, menu);
                        if (statement.executeUpdate() != 0){
                            result = "Операцію успішно виконано";
                        }else{
                            result = "Виникла помилка створення зв'язку замовлення-меню";
                            try {
                                statement = DBConnection.GetConnection().prepareStatement(Queries.DeleteOrders());
                                statement.setInt(1, id);
                                statement.executeUpdate();
                            }catch (SQLException e){
                                return e.getMessage();
                            }
                            break;
                        }
                    }catch (SQLException e){
                        return e.getMessage();
                    }
                }
            }else{result = "Такого запису немає в базі даних";}
            return result;
        }catch (SQLException e){
            return e.getMessage();
        }
    }
    public static String InsertSchedule(Integer id, String dayOfWeek, LocalTime beginTime, LocalTime endTime, LocalDate date){
        try {
            PreparedStatement statement = DBConnection.GetConnection().prepareStatement(Queries.InsertSchedules());
            statement.setInt(1, id);
            statement.setString(2, dayOfWeek);
            statement.setTime(3, Time.valueOf(beginTime));
            statement.setTime(4, Time.valueOf(endTime));
            statement.setDate(5, Date.valueOf(date));
            if (statement.executeUpdate() != 0){
                return "Операцію успішно виконано";
            }else{return "Такого запису немає в базі даних";}

        }catch (SQLException e){
            return e.getMessage();
        }
    }
}
