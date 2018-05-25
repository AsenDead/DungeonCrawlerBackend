import java.util.ArrayList;
import java.util.List;

/**
 * Created by merli on 5/25/2018.
 */
public class Enemy extends Object {
      Enemy(ArrayList<ArrayList<Character>> style, int width, int height, int positionX, int positionY) {
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
    boolean setWidth(int width) {
        if(width >= this.width) {
            this.width = width;
            return true;
        }
        else {
            return false;
        }
    }
    ArrayList<ArrayList<Character>> getImage() {

        return this.ImageStyle;
    }
    int getWidth() {
        return this.width;
    }
    int getHeight() {
        return this.height;
    }

    int getX() {
        return this.x;
    }
    int getY() {
        return this.y;
    }
    boolean isVisible() {
        return this.visible;
    }
}
