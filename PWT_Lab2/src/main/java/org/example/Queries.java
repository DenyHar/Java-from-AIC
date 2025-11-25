package org.example;

public class Queries {
    // INSERT
    public static String InsertStaff(){
        return  """
            INSERT INTO staff (id, full_name, phone_number, contact_address, position)
            VALUES (?, ?, ?, ?, ?);
            """;
    }
    public static String InsertClients(){
        return  """
            INSERT INTO clients (id, name, phone_number, discount)
            VALUES (?, ?, ?, ?);
            """;
    }
    public static String InsertMenu(){
        return  """
            INSERT INTO menu (id, name_ua, name_eng, type, price)
            VALUES (?, ?, ?, ?, ?)
            """;
    }
    public static String InsertOrders(){
        return  """
            INSERT INTO orders (id, waiter_id, client_id, date)
            VALUES (?, ?, ?, ?);
            """;
    }
    public static String InsertOrderMenu(){
        return  """
            INSERT INTO orders (order_id, menu_id)
            VALUES (?, ?);
            """;
    }
    public static String InsertSchedules(){
        return  """
            INSERT INTO schedule (staff_id, day_of_week, begin_time, end_time, date)
            VALUES (?, ?, ?, ?, ?);
            """;
    }
    /// ///////////////////////////////////////////////////
    // SELECT
    public static String SelectAllStaff(){
        return  """
            SELECT * FROM staff;
            """;
    }
    public static String SelectAllClients(){
        return  """
            SELECT * FROM clients;
            """;
    }
    public static String SelectAllMenu(){
        return  """
            SELECT * FROM menu;
            """;
    }
    public static String SelectAllOrders(){
        return  """
            SELECT * FROM orders;
            """;
    }
    public static String SelectAllSchedules(){
        return  """
            SELECT * FROM schedule;
            """;
    }
    public static String SelectIdNameFromMenu(){
        return  """
            SELECT menu.id, menu.name_ua FROM menu;
            """;
    }
    /// ///////////////////////////////////////////////////
    // UPDATE
    public static String UpdateStaffId(){
        return  """
            UPDATE staff
            SET id = ?
            WHERE id = ?;
            """;
    }
    public static String UpdateStaffName(){
        return  """
            UPDATE staff
            SET full_name = ?
            WHERE id = ?;
            """;
    }
    public static String UpdateStaffPhone(){
        return  """
            UPDATE staff
            SET phone_number = ?
            WHERE id = ?;
            """;
    }
    public static String UpdateStaffAddress(){
        return  """
            UPDATE staff
            SET contact_address = ?
            WHERE id = ?;
            """;
    }
    public static String UpdateStaffPosition(){
        return  """
            UPDATE staff
            SET position = ?
            WHERE id = ?;
            """;
    }
    /// ///////////////////////////////////////////////////
    public static String UpdateClientsId(){
        return  """
            UPDATE clients
            SET id = ?
            WHERE id = ?;
            """;
    }
    public static String UpdateClientsName(){
        return  """
            UPDATE clients
            SET name = ?
            WHERE id = ?;
            """;
    }
    public static String UpdateClientsPhone(){
        return  """
            UPDATE clients
            SET phone_number = ?
            WHERE id = ?;
            """;
    }
    public static String UpdateClientsDiscount(){
        return  """
            UPDATE clients
            SET discount = ?
            WHERE id = ?;
            """;
    }
    /// ///////////////////////////////////////////////////
    public static String UpdateMenuId(){
        return  """
            UPDATE menu
            SET id = ?
            WHERE id = ?;
            """;
    }
    public static String UpdateMenuNameUa(){
        return  """
            UPDATE menu
            SET name_ua = ?
            WHERE id = ?;
            """;
    }
    public static String UpdateMenuNameEng(){
        return  """
            UPDATE menu
            SET name_eng = ?
            WHERE id = ?;
            """;
    }
    public static String UpdateMenuType(){
        return  """
            UPDATE menu
            SET type = ?
            WHERE id = ?;
            """;
    }
    public static String UpdateMenuPrice(){
        return  """
            UPDATE menu
            SET price = ?
            WHERE id = ?;
            """;
    }
    /// ///////////////////////////////////////////////////
    public static String UpdateOrdersId(){
        return  """
            UPDATE orders
            SET id = ?
            WHERE id = ?;
            """;
    }
    public static String UpdateOrdersMenuId(){
        return  """
            UPDATE orders
            SET menu_id = ?
            WHERE id = ?;
            """;
    }
    public static String UpdateOrdersWaiterId(){
        return  """
            UPDATE orders
            SET waiter_id = ?
            WHERE id = ?;
            """;
    }
    public static String UpdateOrdersClientId(){
        return  """
            UPDATE orders
            SET client_id = ?
            WHERE id = ?;
            """;
    }
    public static String UpdateOrdersDate(){
        return  """
            UPDATE orders
            SET date = ?
            WHERE id = ?;
            """;
    }
    /// ///////////////////////////////////////////////////
    public static String UpdateSchedulesStaffId(){
        return  """
            UPDATE schedule
            SET staff_id = ?
            WHERE staff_id = ? and date = ?;
            """;
    }
    public static String UpdateSchedulesDayOfWeek(){
        return  """
            UPDATE schedule
            SET day_of_week = ?
            WHERE staff_id = ? and date = ?;
            """;
    }
    public static String UpdateSchedulesBeginTime(){
        return  """
            UPDATE schedule
            SET begin_time = ?
            WHERE staff_id = ? and date = ?;
            """;
    }
    public static String UpdateSchedulesEndTime(){
        return  """
            UPDATE schedule
            SET end_time = ?
            WHERE staff_id = ? and date = ?;
            """;
    }
    public static String UpdateSchedulesDate(){
        return  """
            UPDATE schedule
            SET date = ?
            WHERE staff_id = ? and date = ?;
            """;
    }
    /// ///////////////////////////////////////////////////
    // DELETE
    public static String DeleteStaff(){
        return  """
            DELETE FROM staff
            WHERE id = ?;
            """;
    }
    public static String DeleteClients(){
        return  """
            DELETE FROM clients
            WHERE id = ?;
            """;
    }
    public static String DeleteMenu(){
        return  """
            DELETE FROM menu
            WHERE id = ?;
            """;
    }
    public static String DeleteOrders(){
        return  """
            DELETE FROM orders
            WHERE id = ?;
            """;
    }
    public static String DeleteSchedules(){
        return  """
            DELETE FROM schedule
            WHERE staff_id = ? and date = ?;
            """;
    }
}
