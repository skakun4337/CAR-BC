package core.connection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class VehicleHistoryJDBCDAO {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    public VehicleHistoryJDBCDAO(){

    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public void add(VehicleHistory vehicleHistory) {
        try {
            String queryString = "INSERT INTO VehicleHistory(vid, transaction_id, block_id, " +
                    "block_hash, event, sender, validation_array, `data`, `smartContractSignature`" +
                    ",`smartContractMethod`,`parameters`) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, vehicleHistory.getVid());
            ptmt.setString(2, vehicleHistory.getTransactionId());
            ptmt.setInt(3, vehicleHistory.getBlockId());
            ptmt.setString(4, vehicleHistory.getBlockHash());
            ptmt.setString(5, vehicleHistory.getEvent());
            ptmt.setString(6, vehicleHistory.getSender());
            ptmt.setString(7, vehicleHistory.getValidationArray());
            ptmt.setString(8, vehicleHistory.getData());
            ptmt.setString(9, vehicleHistory.getSmartContractSignature());
            ptmt.setString(10, vehicleHistory.getSmartContractMethod());
            ptmt.setString(11, vehicleHistory.getParameters().toString());
            ptmt.executeUpdate();
            System.out.println("Data Added Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }


        }

    }

    public ResultSet findVehicle(VehicleHistory vehicleHistory) {
        try {
            String queryString = "SELECT * FROM `VehicleHistory` WHERE `vid` = ? AND `event` = ? ORDER BY id DESC LIMIT 1";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, vehicleHistory.getVid());
            ptmt.setString(2, vehicleHistory.getEvent());
            resultSet = ptmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (ptmt != null)
                    ptmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                return resultSet;
            }
        }
    }

    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }

}