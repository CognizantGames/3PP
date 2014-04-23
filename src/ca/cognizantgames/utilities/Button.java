package ca.cognizantgames.utilities;

import java.awt.*;

public class Button {
    int x, y, ax, ay;
    public Button(int x, int y, int ax, int ay){
        this.x = x;
        this.y = y;
        this.ax = ax;
        this.ay = ay;
    }
    public boolean isMouseOver(float mouseX, float rawMouseY, float screenHeight) {
        float mouseY = screenHeight - rawMouseY;
        if (mouseX >= x) {
            if (mouseX <= ax + x) {
                if (mouseY >= y) {
                    if (mouseY <= ay + y) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle drawButton() {
        return new Rectangle(x, y, ax, ay);
    }
}
