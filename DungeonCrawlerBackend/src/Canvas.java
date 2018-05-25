import javafx.util.Pair;

import java.io.*;
import java.util.*;

public class Canvas {
    private int canvas_x;
    private int canvas_y;

    private int frame_x;
    private int frame_y;

    private int camera_x;
    private int camera_y;

    Hashtable<Pair<Integer, Integer>, Object> foregroundObjects;
    Hashtable<Pair<Integer, Integer>, Object> midgroundObjects;
    Hashtable<Pair<Integer, Integer>,Object> backgroundObjects;

    public Canvas(int canvas_x_,
                  int canvas_y_,
                  int frame_x_,
                  int frame_y_,
                  int camera_x_,
                  int camera_y_) {

        canvas_x = canvas_x_;
        canvas_y = canvas_y_;

        frame_x = frame_x_;
        frame_y = frame_y_;

        camera_x = camera_x_;
        camera_y = camera_y_;

        foregroundObjects = new Hashtable<Pair<Integer, Integer>, Object>();
        midgroundObjects = new Hashtable<Pair<Integer, Integer>, Object>();
        backgroundObjects = new Hashtable<Pair<Integer, Integer>, Object>();
    }

    public char[][] GetFrame() {
        // Create a frame of given size
        char[][] array = new char[frame_x][frame_y];

        Pair<Integer, Integer> key;

        // Get position of player

        // edge cases include: being in the corners
        // to be implemented later, otherwise...

        int arrayIndex_x;
        int arrayIndex_y = 0;

        // The top-left corner
        int camera_top = camera_y - frame_y / 2;
        int camera_left = camera_x - frame_x / 2;

        for(int y = camera_top; y < camera_top + frame_y; ++y) {
            arrayIndex_x = 0;
            for (int x = camera_left; x < camera_left + frame_x; ++x) {
                key = new Pair<Integer, Integer>(x, y);

                if(foregroundObjects.get(key) != null) {
                    array[arrayIndex_x][arrayIndex_y] = foregroundObjects.get(key)
                                                                        .getImage()
                                                                        .get[0];
                }
                else if(midgroundObjects.get(key) != null) {
                    array[arrayIndex_x][arrayIndex_y] = midgroundObjects.get(key)
                            .getImage()
                            .get[0];
                }
                else if(backgroundObjects.get(key) != null) {
                    array[arrayIndex_x][arrayIndex_y] = backgroundObjects.get(key)
                            .getImage()
                            .get[0];
                }
                else {
                    array[arrayIndex_x][arrayIndex_y] = ' ';
                }
                ++arrayIndex_x;
            }
            ++arrayIndex_y;
        }
        return array;
    }

    public void setCameraPosition(int x, int y) {
        if(x + frame_x / 2 > canvas_x || x - frame_x / 2 < 0 ||
                y + frame_y / 2 > canvas_y || y - frame_y / 2 < 0) {
            return;
        }
        camera_x = x;
        camera_y = y;
    }

    public char[][] Render() {
        // Create a frame of given size
        char[][] array = new char[frame_x][frame_y];

        Pair<Integer, Integer> key;

        // Get position of player

        // edge cases include: being in the corners
        // to be implemented later, otherwise...

        int arrayIndex_x;
        int arrayIndex_y = 0;

        // The top-left corner
        int camera_top = camera_y - frame_y / 2;
        int camera_left = camera_x - frame_x / 2;

        for(int y = camera_top; y < camera_top + frame_y; ++y) {
            arrayIndex_x = 0;
            for (int x = camera_left; x < camera_left + frame_x; ++x) {
                key = new Pair<Integer, Integer>(x, y);

                if(foregroundObjects.get(key) != null) {
                    array[arrayIndex_x][arrayIndex_y] = foregroundObjects.get(key)
                            .getImage()
                            .get[0];
                }
                else if(midgroundObjects.get(key) != null) {
                    array[arrayIndex_x][arrayIndex_y] = midgroundObjects.get(key)
                            .getImage()
                            .get[0];
                }
                else if(backgroundObjects.get(key) != null) {
                    array[arrayIndex_x][arrayIndex_y] = backgroundObjects.get(key)
                            .getImage()
                            .get[0];
                }
                else {
                    array[arrayIndex_x][arrayIndex_y] = ' ';
                }
                ++arrayIndex_x;
            }
            ++arrayIndex_y;
        }
        return array;
    }

    public void addFG(Object to_add){
        Pair<Integer, Integer> key =
                new Pair<Integer, Integer>(to_add.getX(), to_add.getY);

        foregroundObjects.put(key, to_add);
    }

    public void addBG(Object to_add){
        Pair<Integer, Integer> key =
                new Pair<Integer, Integer>(to_add.getX(), to_add.getY);

        backgroundObjects.put(key, to_add);
    }
    public void addMG(Object to_add){
        Pair<Integer, Integer> key =
                new Pair<Integer, Integer>(to_add.getX(), to_add.getY);

        midgroundObjects.put(key, to_add);
    }

    @Override
    public String toString() {
        String result = "";
        char[][] view = Render();
        for(int y = 0; y < frame_y; ++y) {
            for(int x =0; x < frame_x; ++x) {
                result += view[x][y];
            }
            result += '\n';
        }
        return result;
    }

}