package com.example.demo;

import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SampleController {
    @FXML
    private TextField trainField;
    @FXML
    private DatePicker dataODatePicker;
    @FXML
    private DatePicker datePDatePicker;
    @FXML
    private TextField vagonField;
    @FXML
    private TextField mestoField;
    @FXML
    private TextField cityGoField;
    @FXML
    private TextField cityToField;
    @FXML
    private Button insertButton;
    @FXML
    private TableView<TrainData> tableView;
    @FXML
    private TableColumn<TrainData, Integer> idColumn;
    @FXML
    private TableColumn<TrainData, String> trainColumn;
    @FXML
    private TableColumn<TrainData, Date> dataOColumn;
    @FXML
    private TableColumn<TrainData, Date> datePColumn;
    @FXML
    private TableColumn<TrainData, Integer> vagonColumn;
    @FXML
    private TableColumn<TrainData, Integer> mestoColumn;
    @FXML
    private TableColumn<TrainData, String> cityGoColumn;
    @FXML
    private TableColumn<TrainData, String> cityToColumn;

    private DatabaseAccess databaseAccess;
    private ObservableList<TrainData> trainDataList;

    public void initialize() {
        trainDataList = FXCollections.observableArrayList();

        // Настройка модели данных для таблицы
        tableView.setItems(trainDataList);

        insertButton.setOnAction(event -> {
            // Получение значений из текстовых полей
            String train = trainField.getText();
            java.sql.Date dataO = java.sql.Date.valueOf(dataODatePicker.getValue());
            java.sql.Date dateP = java.sql.Date.valueOf(datePDatePicker.getValue());
            int vagon = Integer.parseInt(vagonField.getText());
            int mesto = Integer.parseInt(mestoField.getText());
            String cityGo = cityGoField.getText();
            String cityTo = cityToField.getText();

            // Выполнение операции INSERT через класс доступа к базе данных
            databaseAccess.insertData(train, dataO, dateP, vagon, mesto, cityGo, cityTo);

            // Очистка текстовых полей
            trainField.clear();
            dataODatePicker.setValue(null);
            datePDatePicker.setValue(null);
            vagonField.clear();
            mestoField.clear();
            cityGoField.clear();
            cityToField.clear();

            // Обновление данных в таблице
            trainDataList.setAll(databaseAccess.getAllTrainData());
        });
    }

    public void setDatabaseAccess(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    public TableView<TrainData> getTableView() {
        return tableView;
    }
}
