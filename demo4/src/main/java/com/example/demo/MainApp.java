package com.example.demo;

import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.util.Date;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo4/SampleController.fxml"));
        Parent root = loader.load();

        SampleController controller = loader.getController();
        DatabaseAccess databaseAccess = new DatabaseAccess(controller);
        controller.setDatabaseAccess(databaseAccess);

        // Получение ссылки на TableView из контроллера
        TableView<TrainData> tableView = controller.getTableView();

        // Настройка колонок таблицы
        TableColumn<TrainData, String> trainColumn = new TableColumn<>("Train");
        trainColumn.setCellValueFactory(new PropertyValueFactory<>("train"));

        TableColumn<TrainData, Date> dataOColumn = new TableColumn<>("DataO");
        dataOColumn.setCellValueFactory(new PropertyValueFactory<>("dataO"));

        TableColumn<TrainData, Date> datePColumn = new TableColumn<>("DateP");
        datePColumn.setCellValueFactory(new PropertyValueFactory<>("dateP"));

        TableColumn<TrainData, Integer> vagonColumn = new TableColumn<>("Vagon");
        vagonColumn.setCellValueFactory(new PropertyValueFactory<>("vagon"));

        TableColumn<TrainData, Integer> mestoColumn = new TableColumn<>("Mesto");
        mestoColumn.setCellValueFactory(new PropertyValueFactory<>("mesto"));

        TableColumn<TrainData, String> cityGoColumn = new TableColumn<>("CityGo");
        cityGoColumn.setCellValueFactory(new PropertyValueFactory<>("cityGo"));

        TableColumn<TrainData, String> cityToColumn = new TableColumn<>("CityTo");
        cityToColumn.setCellValueFactory(new PropertyValueFactory<>("cityTo"));

        // Добавление колонок в таблицу
        tableView.getColumns().addAll(trainColumn, dataOColumn, datePColumn, vagonColumn, mestoColumn, cityGoColumn, cityToColumn);

        // Настройка модели данных для таблицы
        TrainDataModel trainDataModel = new TrainDataModel();
        tableView.setItems(trainDataModel.getTrainDataList());

        Scene scene = new Scene(root);
        stage.setTitle("MySQL Table Access");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
