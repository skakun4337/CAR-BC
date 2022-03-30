package core.connection;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SmartContractJDBCDAO {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    public void add(SmartContract smartContract) {

        try {
            String queryString = "INSERT INTO `SmartContract`(`signature`, `contractName`" +
                    ", `code`, `owner`, `message`, `block_number`, `block_timestamp`, " +
                    "`block_hash`) VALUES (?,?,?,?,?,?,?,?)";

            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, smartContract.getSignature());
            ptmt.setString(2, smartContract.getContractName());
            ptmt.setBinaryStream(3, smartContract.getContractInputStream());
            ptmt.setString(4, smartContract.getOwner());
            ptmt.setString(5, smartContract.getMessage());
            ptmt.setInt(6, smartContract.getBlock_number());
            ptmt.setTimestamp(7, smartContract.getBlock_timestamp());
            ptmt.setString(8, smartContract.getBlock_hash());
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

    public boolean findDuplicates(SmartContract smartContract) {
        boolean contractExists = false;
        try {
            String queryString = "SELECT COUNT(*) FROM `SmartContract` WHERE `signature` = ? AND " +
                    "`contractName` = ? AND `code` = ? AS `duplicates`";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, smartContract.getSignature());
            ptmt.setString(2, smartContract.getContractName());
            ptmt.setBinaryStream(3, smartContract.getContractInputStream());
            resultSet = ptmt.executeQuery();

            if (resultSet.next()){
                int count = resultSet.getInt("duplicates");
                if (count > 0){
                    contractExists = true;
                }
            }
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
            }
        }
        return contractExists;
    }

    public Map getSmartContract(String contractSignature) {
        Map contract = new HashMap();

        try {
            String queryString = "SELECT `contractName`,`code` FROM `SmartContract` WHERE `signature` = ?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, contractSignature);
            resultSet = ptmt.executeQuery();

            if (resultSet.next()){
                InputStream results = resultSet.getBinaryStream("code");
                byte[] result = resultSet.getBytes("code");

                contract.put("contractName", resultSet.getString("contractName"));
                contract.put("code", result);
            }
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
                return contract;
            }
        }
    }
}
