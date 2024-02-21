public  abstract class TableroBase {

    int[][] tablero;
    final int FIL=4;   
    final int COL=4;
    
    public void muestraTablero(){
        for(int i=0; i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(this.tablero[i][j]);
            }
            System.out.println();
        }
    }
    public int generaNumeroAleatorio(){

        return (int)(Math.random()*4);
    }

    public void generaPosicionesAleatorias(){
        int numero1;
        int numero2;

        for(int i =0;i<2;i++){
            numero1=generaNumeroAleatorio();
            numero2=generaNumeroAleatorio();

            if(tablero[numero1][numero2]==2){
                tablero[numero1][numero2]=2;
                i--;
            }
            tablero[numero1][numero2]=2;
        }
        
    }

    public void generaNumeroPorMovimiento(){
        int numero1;
        int numero2;

            numero1=generaNumeroAleatorio();
            numero2=generaNumeroAleatorio();
         
            if(tablero[numero1][numero2]!=0){
            return;
            }
            tablero[numero1][numero2]=2;
        }

    public TableroBase(){
        tablero =new int [FIL][COL];
        generaPosicionesAleatorias();
    }
    
}