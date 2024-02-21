import java.util.Scanner;

public  class Tablero extends TableroBase implements Movimiento {
    public Scanner input= new Scanner(System.in);
    boolean ganador=true;
    
    Tablero(){

        while (ganador) {
            muestraTablero();
            hacerMovimiento();
        }
    }
    
    public boolean compruebaSuma(int x,int y){
        if (x==y) {
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
            for(int j=0;j<3;j++){
                if(i==0){
                return;
                }
                tablero[i][j]=tablero[i-1][j];
            }
        } 
    }        

    @Override
    public void mueveArriba() {
        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i==3){
                return;
                }
                tablero[i][j]=tablero[i+1][j];
            }
        } 
    }

    @Override
    public void mueveDerecha() {
        for(int i =3;i>0;i--){
            for(int j=3;j>0;j--){
                if(j==0){
                    return;
                }
                tablero[i][j]=tablero[i][j-1];
            }
        }         
    }

    @Override
    public void mueveIzquierda() {
        for(int i =0;i<3;i++){
            for(int j=0;j<3;j++){

                tablero[i][j]=tablero[i][j+1];
            }
        }        
    }

    
}