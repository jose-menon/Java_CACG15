package com.example.G15CAC;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect
{
    public static void main(String[] args)
    {
        connect();
    }
    public static void connect()
    {
        Connection conn = null;
        String driver = "com.mysql.jdbc.Driver";
        try
        {
            Class.forName(driver);
            System.out.println("Driver Cargado");
            try
            {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/base?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","1234");
                if(conn != null)
                {
                    System.out.println("conexion exitosa");
                }
            }
            catch (Exception e)
            {
                System.out.println("Ha ocurrido un error al intentar conectar a la DB" + e.getMessage());
            }
        }
        catch (Exception e)
        {
            System.out.println("Ha ocurrido un error al cargar el driver" + e.getMessage());
        }
    }
}
