public class Projectile {
    private int x,y,w,h;
    private int dx;
    public Projectile(){
        x=417;
        y=513;
        w=10;
        h=7;
        dx=1;
    }

    

    public void move(){
        x+=dx;
    }

    public void setDX(int speed){
        dx=speed;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getW(){
        return w;
    }

    public int getH(){
        return h;
    }
}
