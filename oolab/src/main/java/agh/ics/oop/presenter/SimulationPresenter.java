package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.List;

public class SimulationPresenter implements MapChangeListener {
    private WorldMap map;
    @FXML
    private Label infoLabel;
    @FXML
    private TextField argumentsField;
    @FXML
    private GridPane mapGrid;

    private int cell_size=50;
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;
    private int mapWidth;
    private int mapHeight;
    private final int maxMapWidth=450;
    private final int maxMapHeight=450;

    public void setWorldMap(WorldMap map){
        this.map=map;
    }

    private void updateMapBounds(){
        minX = map.getCurrentBounds().lowerLeftCorner().getX();
        minY = map.getCurrentBounds().lowerLeftCorner().getY();
        maxX = map.getCurrentBounds().upperRightCorner().getX();
        maxY = map.getCurrentBounds().upperRightCorner().getY();
        mapWidth = maxX - minX + 1;
        mapHeight = maxY - minY + 1;
        int cell_width = Math.round((float) maxMapWidth /mapWidth);
        int cell_height = Math.round((float) maxMapHeight /mapHeight);
        cell_size = Math.min(cell_height, cell_width);
    }

    private void createXYLabels(){
        mapGrid.getColumnConstraints().add(new ColumnConstraints(cell_size));
        mapGrid.getRowConstraints().add(new RowConstraints(cell_size));
        Label label = new Label("y/x");
        mapGrid.add(label,0,0);
        GridPane.setHalignment(label, HPos.CENTER);

        for (int i=0;i<mapWidth;i++){
            Label columnLabel = new Label(Integer.toString(i+minX));
            mapGrid.getColumnConstraints().add(new ColumnConstraints(cell_size));
            mapGrid.add(columnLabel,i+1,0);
            GridPane.setHalignment(columnLabel, HPos.CENTER);
        }

        for (int i=0;i<mapHeight;i++){
            Label rowLabel = new Label(Integer.toString(i+minY));
            mapGrid.getRowConstraints().add(new RowConstraints(cell_size));
            mapGrid.add(rowLabel,0,i+1);
            GridPane.setHalignment(rowLabel, HPos.CENTER);
        }
    }

    private void insertElements(){
        for (int i = minX; i <= maxX; i++) {
            for (int j = maxY; j >= minY; j--) {
                Vector2d pos = new Vector2d(i, j);
                Label label;
                if (map.isOccupied(pos)) {
                    label = new Label(map.objectAt(pos).toString());
                    mapGrid.add(label, i - minX + 1, maxY - j + 1);
                }
                else {
                    label = new Label(" ");
                    mapGrid.add(label, i - minX + 1, maxY - j + 1);
                }
                GridPane.setHalignment(label, HPos.CENTER);
            }
        }
    }

    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0)); // hack to retain visible grid lines
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }

    public void drawMap(String message){
        clearGrid();
        updateMapBounds();
        createXYLabels();
        insertElements();
        infoLabel.setText(message);
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
            Platform.runLater(() -> {
                setWorldMap(worldMap);
                drawMap(message);
            });
    }

    public void onSimulationStartClicked() {
        List<String> parameters = List.of(argumentsField.getText().split(""));
        List<MoveDirection> directions = OptionsParser.convertDirections(parameters);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));

        GrassField gf = new GrassField(10);

        gf.addSubscriber(this);
        Simulation simulation = new Simulation(positions,directions,gf);
        SimulationEngine simulationEngine = new SimulationEngine(List.of(simulation));
        simulationEngine.runAsync();
    }
}
