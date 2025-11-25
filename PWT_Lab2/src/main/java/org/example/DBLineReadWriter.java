package org.example;

import org.example.Entities.*;

import java.sql.ResultSet;

public class DBLineReadWriter {
    public Staff ReadWriteStaff(ResultSet rs){
        try {
            return new Staff(rs.getInt("id"),
                        rs.getString("full_name"),
                        rs.getInt("phone_number"),
                        rs.getString("contact_address"),
                        rs.getString("position"));
        }catch (Exception e){
            return null;
        }
    }
    public Client ReadWriteClient(ResultSet rs){
        try {
            return new Client(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("phone_number"),
                    rs.getInt("discount"));
        }catch (Exception e){
            return null;
        }
    }
    public Menu ReadWriteMenu(ResultSet rs){
        try {
            return new Menu(rs.getInt("id"),
                    rs.getString("name_ua"),
                    rs.getString("name_eng"),
                    rs.getString("type"),
                    rs.getDouble("price"));
        }catch (Exception e){
            return null;
        }
    }
    public Order ReadWriteOrder(ResultSet rs){
        try {
            return new Order(rs.getInt("id"),
                    rs.getInt("menu_id"),
                    rs.getInt("waiter_id"),
                    rs.getInt("client_id"),
                    rs.getDate("date").toLocalDate());
        }catch (Exception e){
            return null;
        }
    }
    public Schedule ReadWriteSchedule(ResultSet rs){
        try {
            return new Schedule(rs.getInt("staff_id"),
                    rs.getString("day_of_week"),
                    rs.getTime("begin_time").toLocalTime(),
                    rs.getTime("end_time").toLocalTime(),
                    rs.getDate("date").toLocalDate());
        }catch (Exception e){
            return null;
        }
    }
}
