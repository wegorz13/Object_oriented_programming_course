package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RandomPositionGenerator implements Iterable<Vector2d>, Iterator<Vector2d> {
    private final List<Vector2d> positions;
    private final int grassCount;
    private int index;

    public RandomPositionGenerator(int maxWidth, int maxHeight, int grassCount) {
        this.grassCount = grassCount;
        this.positions = new ArrayList<>(maxHeight*maxWidth);

        for (int x = 0; x <= maxWidth; x++) {
            for (int y = 0; y <= maxHeight; y++) {
                positions.add(new Vector2d(x, y));
            }
        }

        fisherYatesShuffle();
    }

    private void fisherYatesShuffle() {
        Random random = new Random();
        for (int i = positions.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            Vector2d temporary = positions.get(i);
            positions.set(i, positions.get(j));
            positions.set(j, temporary);
        }
    }

    @Override
    public boolean hasNext() {
        return index < grassCount && index < positions.size();
    }

    @Override
    public Vector2d next() {
        return positions.get(index++);
    }

    @Override
    public Iterator<Vector2d> iterator() {
        return this;
    }
}

