package code;

import java.util.Random;

public class Labyrinthe {
    
    protected Ground[][] laby;

    //TableauLabyrinthePré-construit: 0 = sol; 1 = wall; 2 = start; 3 = end;
    protected int[][] labyTab = {{1,1,1,1,1,1,1,1,1,1,1},
                                {1,0,0,0,0,0,0,0,0,0,1},
                                {1,0,1,0,1,1,0,1,3,0,1},
                                {1,0,1,0,0,1,0,1,1,0,1},
                                {1,0,1,1,0,0,0,0,1,0,1},
                                {1,0,0,0,0,0,0,0,0,0,1},
                                {1,0,0,0,1,1,0,1,1,1,1},
                                {1,0,0,0,0,1,0,0,0,0,1},
                                {1,0,2,0,0,1,0,1,1,0,1},
                                {1,0,0,0,0,0,0,0,0,0,1},
                                {1,1,1,1,1,1,1,1,1,1,1}};

    /*
    Pour les couleurs, j'utilise la table suivante:
    - Inconnu : Noir(-1);
    - joueur : Jaune(0);
    - Sol : Blanc(1),Gris(2);
    - Mur : Bleu(3);
    - Depart : Vert(4);
    - Fin : Rouge(5);
    */

    public Labyrinthe(){

        this.laby = new Ground[11][11];
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                if(labyTab[i][j] == 0){
                    laby[i][j] = new Ground(i,j,-1,false,false,false,false);
                }
                else if(labyTab[i][j] == 1){
                    laby[i][j] = new Ground(i,j,3,true,false,false,false);
                }
                else if(labyTab[i][j] == 2){
                    laby[i][j] = new Ground(i,j,4,false,true,false,true);
                }
                else if(labyTab[i][j] == 3){
                    laby[i][j] = new Ground(i,j,5,false,false,true,false);
                }

            }
        }
    }

    public void affichage(){
        for(int i = 0; i<10 ; i++){
            System.out.print(i+"  ");
            for(int j = 0; j<10 ; j++){
                if (laby[i][j].getColor()==-1){System.out.print(" BLACK ");}
                else if (laby[i][j].getColor()==0){System.out.print("YELLOW ");}
                else if (laby[i][j].getColor()==1){System.out.print(" WHITE ");}
                else if (laby[i][j].getColor()==2){System.out.print(" GREY  ");}
                else if (laby[i][j].getColor()==3){System.out.print(" BLUE  ");}
                else if (laby[i][j].getColor()==4){System.out.print(" GREEN ");}
                else if (laby[i][j].getColor()==5){System.out.print("  RED  ");}
            }
            System.out.println(" ");
        }
        System.out.println("      0      1      2      3      4      5      6      7      8      9");
        System.out.println(" ");
    }

    public Ground[][] getLabyrinthe(){
        return laby;
    }

    public int[][] getLabyTab(){
        return labyTab;
    }

    public Ground getGround(int x, int y){
        return laby[x][y];
    }

    public Ground getPlayerGround(){
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                if(laby[i][j].getPlayer()){
                    return laby[i][j];
                }
            }
        }
        return null;
    }

    public void up(int x, int y){
        Ground g1 = laby[x][y];
        if(x==1){
            System.out.println("You can't go upwards! (cause: Wall)");
        }
        else{
            Ground g2 = laby[x-1][y];
            if(g2.getWall()){
                System.out.println("You can't go upwards! (cause: Wall)");
            }
            else{
                g1.setPlayer(false);
                g1.setColor(-1);
                g2.setPlayer(true);
                g2.setColor(0);
            }
        }
    }

    public void down(int x, int y){
        Ground g1 = laby[x][y];
        if(x==9){
            System.out.println("You can't go downwards! (cause: Wall)");
        }
        else{
            Ground g2 = laby[x+1][y];
            if(g2.getWall()){
                System.out.println("You can't go downwards! (cause: Wall)");
            }
            else{
                g1.setPlayer(false);
                g1.setColor(-1);
                g2.setPlayer(true);
                g2.setColor(0);
            }
        }
    }

    public void right(int x, int y){
        Ground g1 = laby[x][y];
        if(y==9){
            System.out.println("You can't go rightwards! (cause: Wall)");
        }
        else{
            Ground g2 = laby[x][y+1];
            if(g2.getWall()){
                System.out.println("You can't go rightwards! (cause: Wall)");
            }
            else{
                g1.setPlayer(false);
                g1.setColor(-1);
                g2.setPlayer(true);
                g2.setColor(0);
            }
        }
    }

    public void left(int x, int y){
        Ground g1 = laby[x][y];
        if(y==1){
            System.out.println("You can't go leftwards! (cause: Wall)");
        }
        else{
            Ground g2 = laby[x][y-1];
            if(g2.getWall()){
                System.out.println("You can't go leftwards! (cause: Wall)");
            }
            else{
                g1.setPlayer(false);
                g1.setColor(-1);
                g2.setPlayer(true);
                g2.setColor(0);
            }
        }
    }

    public void setBlack(){
        for(int i = 1; i < 10; i++){
            for(int j = 1; j < 10; j++){
                laby[i][j].setColor(-1);
            }
        } 
    }

    public void setWhiteColor(Ground g){
        if(g.getWall()){
            g.setColor(3);
        }
        else if(g.getStart()){
            g.setColor(4);
        }
        else if(g.getEnd()){
            g.setColor(5);
        }
        else{
            g.setColor(1);
        }    
    }

    public void setGreyColor(Ground g){
        if(g.getWall()){
            g.setColor(3);
        }
        else if(g.getStart()){
            g.setColor(4);
        }
        else if(g.getEnd()){
            g.setColor(5);
        }
        else{
            g.setColor(2);
        } 
    }

    public void setLight(){
        //Applique "l'effet lumière" autour de la case principale;
        Ground g;
        int x=0;
        int y=0;
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                g = laby[i][j];
                if(g.getPlayer()){
                    x = g.getX();
                    y = g.getY();
                    g.setColor(0);
                }
            }
        }
        if(x!=1){
            Ground g1 = laby[x-1][y];
            this.setWhiteColor(g1);
            if(y!=1){
                Ground g2 = laby[x-1][y-1];
                this.setGreyColor(g2);
            }
            if(!g1.getWall()){
                if(x!=2){
                    Ground g3 = laby[x-2][y];
                    this.setGreyColor(g3);
                }
            }
        }
        if(x!=9){
            Ground g4 = laby[x+1][y];
            this.setWhiteColor(g4);
            if(y!=9){
                Ground g5 = laby[x+1][y+1];
                this.setGreyColor(g5);
            }
            if(!g4.getWall()){
                if(x!=8){
                    Ground g6 = laby[x+2][y];
                    this.setGreyColor(g6);
                }
            }
        }
        if(y!=9){
            Ground g7 = laby[x][y+1];
            this.setWhiteColor(g7);
            if(x!=1){
                Ground g8 = laby[x-1][y+1];
                this.setGreyColor(g8);
            }
            if(!g7.getWall()){
                if(y!=8){
                    Ground g9 = laby[x][y+2];
                    this.setGreyColor(g9);
                }
            }
        }
        if(y!=1){
            Ground g10 = laby[x][y-1];
            this.setWhiteColor(g10);
            if(x!=9){
                Ground g11 = laby[x+1][y-1];
                this.setGreyColor(g11);
            }
            if(!g10.getWall()){
                if(y!=2){
                    Ground g12 = laby[x][y-2];
                    this.setGreyColor(g12);
                }
            }
        }
    }

    public void resetLab(){
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                if(laby[i][j].getPlayer()){
                    laby[i][j].setPlayer(false);
                }
                if(laby[i][j].getStart()){
                    laby[i][j].setPlayer(true);
                }
            }
        }
        this.setBlack();
        this.setLight();
    }

    public boolean end(){
        int xEnd = 0;
        int yEnd = 0;
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                if(laby[i][j].getEnd()){
                    xEnd = i;
                    yEnd = j;
                }
            }
        }
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                if(laby[i][j].getPlayer()){
                    if(xEnd == i && yEnd == j){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}