package sample;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;

import java.util.Set;

public class Schedule {
    @FXML
    public ScatterChart chart;
    private XYChart.Series series;

    // очистка графика
    void clearChart() {
        chart.getData().clear();
    }

    // создание массива с точками
    void createSeries() {
        series = new XYChart.Series();
    }

    // добавление одной точки в массив с точками
    void drawPoint(Double x, Double y) {
        series.getData().add(new XYChart.Data(x, y));
    }

    // добавление всех точек на график
    void addAllSeries() {
        chart.getData().addAll(series);
    }

    // изменения стиля у точек на графике
    void nodesChart() {
        Set<Node> nodes = chart.lookupAll(".series" + 0);
        for (Node n : nodes)
        {
            n.setStyle("-fx-background-color: black;\n"
                    + "-fx-padding: 1px;");
        }
    }
}
