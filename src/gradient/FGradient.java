package gradient;

import java.awt.Color;



public class FGradient {
    
    
    public Color getColor(int i, int max) {
        
        if (i == -1) {
            return new Color(255, 255, 255);
        } //else color ? glColor3d((double)(n*itr - i) / (n*itr), 0.5, (double)i / (n*itr)) : glColor3d(1, 1, 1);
        else {
            return new Color((int) (255 * (double) i / max), (int) (255 * (double) i / max), (int) (255 * (double) 0.5 * i / max));
        }
    }
    
}
