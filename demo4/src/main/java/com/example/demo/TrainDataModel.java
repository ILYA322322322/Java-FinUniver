package com.example.demo;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TrainDataModel {
    private final ObservableList<TrainData> trainDataList;

    public TrainDataModel() {
        trainDataList = FXCollections.observableArrayList();
    }

    public ObservableList<TrainData> getTrainDataList() {
        return trainDataList;
    }

    public void loadTrainData() {
        // Пример заполнения списка данными
        trainDataList.add(new TrainData("Train 1", new Date(), new Date(), 1, 1, "City 1", "City 2"));
        trainDataList.add(new TrainData("Train 2", new Date(), new Date(), 2, 2, "City 3", "City 4"));
    }
}
