import java.util.ArrayList;
import java.util.List;

/**
 * Created by merli on 5/25/2018.
 */
public class MainPlayer extends Object {
    MainPlayer(ArrayList<ArrayList<Character>> style, int width, int height, int positionX, int positionY) {
        int rowLevel = 0;
        for(List<Character> arrayList : style) {
            ImageStyle.add(new ArrayList<Character>());
            for (Character number : arrayList) {
                this.ImageStyle.get(rowLevel).add(number);
            }
        }
        this.width = width;
        this.height = height;
        this.x = positionX;
        this.y = positionY;
    }
    boolean moveGridBased(char move) {
        if(move == 'L') {
            this.x -= 7;
            return true;
        }
        else if(move == 'R') {
            this.x += 7;
            return true;
        }
        else if(move == 'U') {
            this.y -= 7;
            return true;
        }
        else if(move == 'D') {
            this.y += 7;
            return true;
        }
        else {
            return false;
        }
    }
    ArrayList<ArrayList<Character>> getImage() {

        return this.ImageStyle;
    }
    boolean isVisible() {
        return this.visible;
    }
    boolean collision(Enemy monster){
        if(this.x == monster.getX() && this.y == monster.getY() && monster.isVisible()) {
            return true;
        }
        return false;
    }
    int getWidth() {
        return this.width;
    }
    int getHeight() {
        return this.height;
    }
    boolean setWidth(int width) {
        if(width >= this.width) {
            this.width = width;
            return true;
        }
        else {
            return false;
        }
    }
    boolean setHeight(int height) {
        if(this.height <= height) {
            this.height = height;
            return true;
        }
        else {
            return false;
        }
    }
    int getX() {
        return this.x;
    }
    int getY() {
        return this.y;
    }
}
