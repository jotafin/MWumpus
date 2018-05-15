package tab;
import java.util.Random;


public class Tabuleiro {
 
    
    String [][] Mapa = 
       
        {{"", "" , "" , ""},
        {"", "", "", ""},
        {"", "" ,"" , ""},
        {"","" , "",""}};	
 
   String Heroi =  "H";
   String Wumpus = "W";
   String Fedor =  "F";
   String Poço =   "P";
   String Brisa =  "B";
   String Ouro =   "O";
	

	
	public String[][] Tabuleiro(){
		//RandomHeroi();
		RandomOuro();
		RandomWumpus();
		RandomPoços();
		
		return Mapa;
	}
	
	 public void printMapa(){
           
           for (int i = 0; i < Mapa.length; i++){
               for(int j = 0; j < Mapa.length; j++){
                   System.out.print(this.Mapa[i][j] + " | ");
                   
                 
               }
               System.out.println();
           }
           
               System.out.println("==============");         
    
       }
         
	public void RandomWumpus(){
		
		Random gerador = new Random();
		
		int Coluna = gerador.nextInt(4); 
		int Linha = gerador.nextInt(4);
		
		if(	   this.Mapa[Coluna][Linha] != "H" 
			&& this.Mapa[Coluna][Linha] != "O"
			&& this.Mapa[Coluna][Linha] != "B")
		{
			 Mapa[Coluna][Linha] = Wumpus;
			 
			 if(Linha <= 3 && Linha > 0){
				 if(Mapa[Coluna][Linha - 1] == Ouro){
					 //Mapa[Coluna][Linha - 1] = FedorOuro;
				 }else if(Mapa[Coluna][Linha - 1] == Brisa){
					 //matriz[Coluna][Linha - 1] = BrisaFedor;
				 } else if(Mapa[Coluna][Linha - 1] == Heroi){
					// matriz[Coluna][Linha - 1] = FedorHeroi;
				 }else if(Mapa[Coluna][Linha - 1] == Poço){
					 //matriz[Coluna][Linha - 1] = FedorBuraco;
				 }else Mapa[Coluna][Linha - 1] = Fedor;
			 }
			 if(Linha >= 0 && Linha < 3){
				 if(Mapa[Coluna][Linha + 1] == Ouro){
					 //matriz[Coluna][Linha + 1] = FedorOuro;
				 }else if(Mapa[Coluna][Linha + 1] == Brisa){
					 //matriz[Coluna][Linha + 1] = BrisaFedor;
				 } else if(Mapa[Coluna][Linha + 1] == Heroi){
					 //matriz[Coluna][Linha + 1] = FedorHeroi;
				 }else if(Mapa[Coluna][Linha + 1] == Poço){
					 //matriz[Coluna][Linha + 1] = FedorBuraco;
				 }else Mapa[Coluna][Linha + 1] = Fedor;
			 }
			 if(Coluna <= 3 && Coluna > 0){
				 if(Mapa[Coluna - 1][Linha] == Ouro){
					 //matriz[Coluna - 1][Linha] = FedorOuro;
				 }else if(Mapa[Coluna - 1][Linha] == Brisa){
					 //matriz[Coluna - 1][Linha] = BrisaFedor;
				 } else if(Mapa[Coluna - 1][Linha] == Heroi){
					 //matriz[Coluna - 1][Linha] = FedorHeroi;
				 }else if(Mapa[Coluna - 1][Linha] == Poço){
					 //matriz[Coluna - 1][Linha] = FedorBuraco;
				 }else Mapa[Coluna - 1][Linha] = Fedor;
			 }
			 if(Coluna >= 0 && Coluna < 3){
				 if(Mapa[Coluna + 1][Linha] == Ouro){
					 //Mapa[Coluna + 1][Linha] = FedorOuro;
				 }else if(Mapa[Coluna + 1][Linha] == Brisa){
					 //matriz[Coluna + 1][Linha] = BrisaFedor;
				 } else if(Mapa[Coluna + 1][Linha] == Heroi){
					// matriz[Coluna + 1][Linha] = FedorHeroi;
				 }else if(Mapa[Coluna + 1][Linha]== Poço){
					// matriz[Coluna + 1][Linha] = FedorBuraco;
				 }else Mapa[Coluna + 1][Linha] = Fedor;
			 }
			 
		} else
		{
			RandomWumpus();
		}		
	}
	
	public void RandomHeroi() {
		Mapa[3][0] = Heroi;
	}
	
	public void RandomOuro() {
		Random gerador = new Random();
		
		int Coluna = gerador.nextInt(4); 
		int Linha = gerador.nextInt(4);
		
		if(	   this.Mapa[Coluna][Linha] != "H" 
			&& this.Mapa[Coluna][Linha] != "W"
			&& this.Mapa[Coluna][Linha] != "B")
		{
			 Mapa[Coluna][Linha] = Ouro;
			 
		} else
		{
			RandomOuro();
		}		
	}
	
	public void RandomPoços() {
		Random gerador = new Random();	
		
		int Coluna = gerador.nextInt(4); 
		int Linha = gerador.nextInt(4);
		
		if(	   Coluna != 0 && Linha == 3
			&& this.Mapa[Coluna][Linha] != "O"
			&& this.Mapa[Coluna][Linha] != "W")
		{
			 Mapa[Coluna][Linha] = Poço;
			 
			 if(Linha <= 3 && Linha > 0){
				 if(Mapa[Coluna][Linha - 1] == Ouro){
					// Mapa[Coluna][Linha - 1] = BrisaOuro;
				 //}else if(Mapa[Coluna][Linha - 1] == BrisaFedor){
					 //Mapa[Coluna][Linha - 1] = BrisaOuroFedor;
				 }else if(Mapa[Coluna][Linha - 1] == Wumpus){
					 //matriz[Coluna][Linha - 1] = BrisaWumpus;
				 }else if(Mapa[Coluna][Linha - 1] == Heroi){
					 //matriz[Coluna][Linha - 1] = BrisaHeroi;
				 }else Mapa[Coluna][Linha - 1] = Brisa;
			 }
			 if(Linha >= 0 && Linha < 3){
				 if(Mapa[Coluna][Linha + 1] == Ouro){
					 //matriz[Coluna][Linha + 1] = BrisaOuro;
				// }else if(Mapa[Coluna][Linha + 1] == BrisaFedor){
					// matriz[Coluna][Linha + 1] = BrisaOuroFedor;
				 }else if(Mapa[Coluna][Linha + 1] == Wumpus){
					// matriz[Coluna][Linha + 1] = BrisaWumpus;
				 }else if(Mapa[Coluna][Linha + 1] == Heroi){
					 //matriz[Coluna][Linha + 1] = BrisaHeroi;
				 }else Mapa[Coluna][Linha + 1] = Brisa;
			 }
			 if(Coluna <= 3 && Coluna > 0){
				 if(Mapa[Coluna - 1][Linha] == Ouro){
					 //matriz[Coluna - 1][Linha] = BrisaOuro;
				 //}else if(matriz[Coluna - 1][Linha] == BrisaFedor){
					 //matriz[Coluna - 1][Linha] = BrisaOuroFedor;
				 }else if(Mapa[Coluna - 1][Linha] == Wumpus){
					 //matriz[Coluna - 1][Linha] = BrisaWumpus;
				 }else if(Mapa[Coluna - 1][Linha] == Heroi){
					 //matriz[Coluna - 1][Linha] = BrisaHeroi;
				 }else Mapa[Coluna - 1][Linha] = Brisa;
			 }
			 if(Coluna >= 0 && Coluna < 3){
				 if(Mapa[Coluna + 1][Linha] == Ouro){
					 //matriz[Coluna + 1][Linha] = BrisaOuro;
				 //}else if(Mapa[Coluna + 1][Linha] == BrisaFedor){
					 //matriz[Coluna + 1][Linha] = BrisaOuroFedor;
				 }else if(Mapa[Coluna + 1][Linha] == Wumpus){
					 //matriz[Coluna + 1][Linha] = BrisaWumpus;
				 }else if(Mapa[Coluna + 1][Linha] == Heroi){
					 //matriz[Coluna + 1][Linha] = BrisaHeroi;
				 }else Mapa[Coluna + 1][Linha] = Brisa;
			 }
			 
		} else
		{
			RandomPoços();
		}
		
		}
        
          
            
        }

    





