package com.example.demo;
import  java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import com.example.ConstDate.Config;
import com.example.demo.SampleController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess extends Config {
    private static final String url = View_Bases + "://" + DB_Host + ":" + DB_Port + "/" + DB_Name;
    private static final String username = DB_User;
    private static final String password = DB_Pass;

    private SampleController controller;
    private Connection connection;

    public DatabaseAccess(SampleController controller) {
        this.controller = controller;
        try {
            // Инициализация драйвера базы данных
            Class.forName(DB_Driver);

            // Установка соединения с базой данных
            connection = DriverManager.getConnection(url, username, password);
            // Проверка подключения к базе данных
            if (connection != null) {
                DatabaseMetaData metaData = connection.getMetaData();
                System.out.println("Connected to database: " + metaData.getDatabaseProductName());
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertData(String train, java.sql.Date dataO, java.sql.Date dateP, int vagon, int mesto, String cityGo, String cityTo) {
        String query = "INSERT INTO trainsdate (Train, DataO, DateP, Vagon, Mesto, CityGo, CityTo) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, train);
            statement.setDate(2, dataO);
            statement.setDate(3, dateP);
            statement.setInt(4, vagon);
            statement.setInt(5, mesto);
            statement.setString(6, cityGo);
            statement.setString(7, cityTo);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllRows() {
        List<String> rows = new ArrayList<>();

        String query = "SELECT * FROM trainsdate";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                StringBuilder rowBuilder = new StringBuilder();

                for (int i = 1; i <= columnCount; i++) {
                    String value = resultSet.getString(i);
                    rowBuilder.append(value).append(" | ");
                }

                // Remove the trailing " | "
                String row = rowBuilder.substring(0, rowBuilder.length() - 3);
                rows.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows;
    }

    public List<TrainData> getAllTrainData() {
        List<TrainData> trainDataList = new ArrayList<>();

        String query = "SELECT * FROM trainsdate";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String train = resultSet.getString("Train");
                Date dataO = resultSet.getDate("DataO");
                Date dateP = resultSet.getDate("DateP");
                int vagon = resultSet.getInt("Vagon");
                int mesto = resultSet.getInt("Mesto");
                String cityGo = resultSet.getString("CityGo");
                String cityTo = resultSet.getString("CityTo");

                TrainData trainData = new TrainData(train, dataO, dateP, vagon, mesto, cityGo, cityTo);
                trainDataList.add(trainData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Отображение ошибки
        }

        return trainDataList;
    }
}
