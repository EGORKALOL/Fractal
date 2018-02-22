package gradient;

import java.awt.Color;
import java.util.ArrayList;


public class FGradient {
    
    ArrayList<Nod> nods;
    Color inside;
    
    public FGradient(){
        /*inside = new Color((int) (Math.random()*255), 
                (int) (Math.random()*255), (int)(Math.random()*255));
        start = new Color((int)(Math.random()*255), 
                (int)(Math.random()*255), (int)(Math.random()*255));
        end = new Color((int)(Math.random()*255), 
                (int)(Math.random()*255), (int)(Math.random()*255));
        System.out.println("in: "+ inside.toString()+";\nst: "+start.toString()+
                ";\nend:"+end.toString());
        */
        inside = Color.WHITE;
        nods = new ArrayList<>();
        nods.add(new Nod(0, Color.BLACK));
        //nods.add(new Nod(f(0.25), Color.RED));
        nods.add(new Nod(f(0.5), Color.RED));
        //nods.add(new Nod(f(0.75), Color.BLUE));
        //nods.add(new Nod(0.5, Color.RED));
        nods.add(new Nod(1, Color.YELLOW));
    }
    
    public Color getColor(int i, int max) {
        
        if (i == -1)
            return inside;
        else {
            double x = (double)i/max;
            x = f(x);
            for(int n = 0; n < nods.size() - 1; n++){
                if(x <= nods.get(n+1).getPos())
                    return getNodsColor(n, x);
            }
        }
        return inside;
    }
    
    Color getNodsColor(int n, double x){
        //System.out.println(""+x);
        x = (x - nods.get(n).getPos())/
                (nods.get(n+1).getPos() - nods.get(n).getPos());
        //System.out.println(""+x);
        
        return new Color((int)((1-x)*nods.get(n).getColor().getRed() 
                + x*nods.get(n+1).getColor().getRed()),
                (int)((1-x)*nods.get(n).getColor().getGreen()
                + x*nods.get(n+1).getColor().getGreen()),
                (int)((1-x)*nods.get(n).getColor().getBlue()
                + x*nods.get(n+1).getColor().getBlue()));
        
    }
    
    double f(double x) {
        
        //return Math.log1p(x*100)/Math.log1p(100);
        
        return Math.sqrt(1.0 - Math.pow(x-1, 2));
        
        //return Math.pow(x, 1/2);
        
        //return (Math.pow(Math.E, x)-1)/(Math.E-1);
    }
    
    class Nod{
        double pos;
        Color c;
        
        public Nod(double pos, Color c) {
            if(pos > 1)
                this.pos = 1;
            else if(pos < 0)
                this.pos = 0;
            else
                this.pos = pos;
            this.c = c;
        }
        
        public void setPos(double pos) {
            this.pos = pos;
        }

        public double getPos() {
            return pos;
        }

        public void setColor(Color c) {
            this.c = c;
        }

        public Color getColor() {
            return c;
        }
        
    }
    
}
