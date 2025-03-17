package dataBase.queries;

import ObjectData.TableVinothQAObjectData;

import java.sql.SQLException;
import java.sql.Statement;

public class TableVinothQA extends CommonTable{
    public TableVinothQA() throws SQLException {
    }
    public synchronized void insertTableObject(TableVinothQAObjectData data) throws SQLException {
        Statement stm = dbConnection.getConnection().createStatement();
        String query = "insert into Users (userName, userRole, email, location, department) " +
                "values ('" + data.getName() + "'" + "," +
                "'" + data.getRole() + "'" + "," +
                "'" + data.getEmail() + "'" + "," +
                "'" + data.getLocation() + "'" + "," +
                "'" + data.getDepartment() + "'" + ");";
        stm.execute(query);
    }

    //INCOMPLETA / daca e nevoie sesiunea 27 min 2:15:34
//    public synchronized void updateEntryById(TableVinothQAObjectData data, Integer idTableVinothQA) throws SQLException {
//        Statement stm = dbConnection.getConnection().createStatement();
//        String query = "update users set permanent_address='" + data.
//    }
}
