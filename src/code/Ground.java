package code;

public class Ground {
    
    private int color;
    private int x;
    private int y;
    private boolean wall;
    private boolean start;
    private boolean end;
    private boolean player;

    public Ground(int x, int y, int color, boolean wall, boolean start, boolean end, boolean player){
        this.x = x;
        this.y = y;
        this.color = color;
        this.wall = wall;
        this.start = start;
        this.end = end;
        this.player = player;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getColor(){
        return color;
    }

    public boolean getWall(){
        return wall;
    }

    public boolean getStart(){
        return start;
    }

    public boolean getEnd(){
        return end;
    }

    public boolean getPlayer(){
        return player;
    }

    public void setColor(int newColor){
        this.color = newColor;
    }

    public void setStart(boolean newStart){
        this.start = newStart;
    }

    public void setEnd(boolean newEnd){
        this.end = newEnd;
    }

    public void setPlayer(boolean newPlayer){
        this.player = newPlayer;
    }
}