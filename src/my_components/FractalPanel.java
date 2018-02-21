
package my_components;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class FractalPanel extends JPanel{
    
    double changeLocation = 100, changeScale = 2;
    int changeItr = 100;
    
    double X=0.75,Y=-0,scale=200;    
    int N=200;
    
    public FractalPanel(){}
    
    public int isIn(double X, double Y) {
        double a=X,b=Y,j;
        for(int i=0;i<N;i++)
        {
            j=a;
            
            a = a*a - b*b + X;
            b = 2 * j*b + Y;
            
            //if(a>2||b>2)return i;
            if(a*a +b*b >4)return i;
        }
        
        return -1;
    }
    
    @Override
    public void paint(Graphics g)
    {
        
        int w=getWidth(),h=getHeight();
        int i;
        for(int x=0;x<w;x++)
        {
            for(int y=0;y<h;y++)
            {
                i=isIn(x / scale - X -w/2/scale, y / scale - Y -h/2/scale);
                
                //if(i==-1)g.setColor(new Color(0,0,0));
                //else g.setColor(new Color(255,255,255));
                
                if (i == -1)g.setColor(new Color(255,255,255));
		//else color ? glColor3d((double)(n*itr - i) / (n*itr), 0.5, (double)i / (n*itr)) : glColor3d(1, 1, 1);
                else g.setColor(new Color((int)(255*(double)i / N), (int)(255*(double)i / N), (int)(255*(double)0.5*i / N)));
                
                g.drawRect(x, y, 1, 1);
            }
        }
        
        g.setColor(Color.WHITE);
        g.fillRect(w/2-1, h/2-1, 3, 3);
        g.setColor(Color.RED);
        g.fillRect(w/2, h/2, 1, 1);
        g.setColor(Color.BLACK);
        g.fillRect(w/2+1, h/2, 1, 1);
        g.fillRect(w/2-1, h/2, 1, 1);
        g.fillRect(w/2, h/2+1, 1, 1);
        g.fillRect(w/2, h/2-1, 1, 1);
    }
    
    public void moveRight(){
        setFX(getFX() - changeLocation / getScale());
    }
    
    public void moveLeft(){
        setFX(getFX() + changeLocation / getScale());
    }
    
    public void moveUp(){
        setFY(getFY() + changeLocation / getScale());
    }
    
    public void moveDown(){
        setFY(getFY() - changeLocation / getScale());
    }
    
    public void incItr(){
        setItr(getItr() + changeItr);
    }
    
    public void decItr(){
        if (getItr() > changeItr) {
                    setItr(getItr() - changeItr);
                }
    }
    
    public void zoomIn(){
        setScale(getScale()*changeScale);
    }
    
    public void zoomOut(){
        setScale(getScale()/changeScale);
    }
    
    public int getItr()
    {
        return N;
    }
    
    public void setItr(int n)
    {
        N=n;
    }
    
    public double getFX()
    {
        return X;
    }
    
    public void setFX(double x)
    {
        X=x;
    }
    
    public double getFY()
    {
        return Y;
    }
    
    public void setFY(double y)
    {
        Y=y;
    }
    
    public double getScale()
    {
        return scale;
    }
    
    public void setScale(double sc)
    {
        scale=sc;
    }
    
    
    
}