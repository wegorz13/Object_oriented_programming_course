package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.lang.Math.*;

public class GrassField extends AbstractWorldMap{
    private final Map<Vector2d, Grass> grasses = new HashMap<>();

    public GrassField(int numberOfGrass){
        super(new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE),new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE));
        generateGrassPosition(numberOfGrass);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        Animal possibleAnimal = (Animal) super.objectAt(position);

        if (possibleAnimal!=null) {
            return possibleAnimal;
        }
        else{
            return this.grasses.get(position);
        }
    }

     List<Vector2d> findSufficientCorners(){
        Vector2d lowerLeftPosition = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
        Vector2d upperRightPosition = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);

        List<WorldElement> worldElements = this.getElements();

        for (WorldElement element: worldElements){
            lowerLeftPosition = lowerLeftPosition.lowerLeft(element.getPosition());
            upperRightPosition = upperRightPosition.upperRight(element.getPosition());
        }

        return List.of(lowerLeftPosition,upperRightPosition);
    }

    @Override
    public String toString() {
        List<Vector2d> sufficientCorners = findSufficientCorners();
        return this.visualizer.draw(sufficientCorners.get(0),sufficientCorners.get(1));
    }

    private void generateGrassPosition(int numberOfGrass){
        double border = sqrt(numberOfGrass*10);
        int count=0;
        while (count<numberOfGrass){
            int x = (int) floor(random()*border);
            int y = (int) floor(random()*border);
            Vector2d position = new Vector2d(x,y);

            if (grasses.get(position)==null){
                grasses.put(position,new Grass(position));
                count++;
            }
        }
    }

    @Override
    public List<WorldElement> getElements() {
        List<WorldElement> elements = super.getElements();
        elements.addAll(grasses.values());

        return elements;
    }
}
