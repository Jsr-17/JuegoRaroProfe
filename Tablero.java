import java.util.Scanner;

public  class Tablero extends TableroBase implements Movimiento {
    public Scanner input= new Scanner(System.in);
    boolean ganador=true;
    boolean perdedor=false;
    
    Tablero(){

        while (ganador || !perdedor) {
            muestraTablero();
            generaNumeroPorMovimiento();        
            hacerMovimiento();
            compruebaGanador();
        }
    }
    
    public boolean compruebaSuma(int x,int y){
        if (x==y && x!=0 && y!=0) {
            return true;
        }
        return false;
    }

        public void hacerMovimiento(){
            String movimiento=input.nextLine();
            
            switch (movimiento.toLowerCase()) {
                case "w":
                    mueveArriba();
                    break;
                case "a":
                    mueveIzquierda();
                    break;
                case "s":
                    mueveAbajo();
                    break;
                case "d":
                    mueveDerecha();
                    break;
                default:
                    break;
            }
        }

    @Override
    public void mueveAbajo() {
        for(int i =3;i>0;i--){
            for(int j=0;j<=3;j++){
                if(compruebaSuma(tablero[i][j], tablero[i-1][j])){
                    tablero[i][j]=tablero[i][j]+tablero[i-1][j];
                    tablero[i-1][j]=0;
                    return;
                }
                if(tablero[i][j]==0){
                    tablero[i][j]=tablero[i-1][j];
                    tablero[i-1][j]=0;
                }            }
        } 
    }        

    @Override
    public void mueveArriba() {
        for(int i =0;i<3;i++){
            for(int j=0;j<=3;j++){
                if(compruebaSuma(tablero[i][j], tablero[i+1][j])){
                    tablero[i][j]=tablero[i][j]+tablero[i+1][j];
                    tablero[i+1][j]=0;
                    return;
                }
                if(tablero[i][j]==0){
                    tablero[i][j]=tablero[i+1][j];
                    tablero[i+1][j]=0;
                }            }
        } 
    }

    @Override
    public void mueveDerecha() {
        for(int i =3;i>=0;i--){
            for(int j=3;j>0;j--){
                if(compruebaSuma(tablero[i][j], tablero[i][j-1])){
                    tablero[i][j]=tablero[i][j]+tablero[i][j-1];
                    tablero[i][j-1]=0;
                    return;
                }

                if(tablero[i][j]==0){
                    tablero[i][j]=tablero[i][j-1];
                    tablero[i][j-1]=0;
                }                
            }
        }         
    }

    @Override
    public void mueveIzquierda() {
        for(int i =0;i<=3;i++){
            for(int j=0;j<3;j++){
                if(compruebaSuma(tablero[i][j], tablero[i][j+1])){
                    tablero[i][j]=tablero[i][j]+tablero[i][j+1];
                    tablero[i][j+1]=0;                   
                    return;
                }
                    if(tablero[i][j]==0){
                        tablero[i][j]=tablero[i][j+1];
                        tablero[i][j+1]=0;
                    }
                
                
            }
        }        
    }
    public void compruebaGanador(){
        boolean noCero=false;
        for(int i=0;i<4;i++){
            noCero=false;
            for(int j=0;j<4;j++){
                if (tablero[i][j]==2048) {
                    ganador=false;
                    System.out.println("Has ganado");
                }
                if (tablero[i][j]==0) {
                    noCero=true;
                }

            }
        }
        if (noCero) {
            perdedor=true;
        }
    }

    
}