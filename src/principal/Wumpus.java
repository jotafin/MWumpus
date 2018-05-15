package principal;

import java.util.ArrayList;
import java.util.Random;
import tab.Tabuleiro;

public class Wumpus {

    public static Object tabs;

    String Heroi = "H";
    String Wumpus = "W";
    String Fedor = "F";
    String Poço = "P";
    String Brisa = "B";
    String Ouro = "O";

    int LinhaHeroi = 3;
    int ColunaHeroi = 0;
    boolean GameOver = false;

    String[][] Mapa;

    // {{Fedor, "" , Brisa , Poço},
    //  {Wumpus, Ouro, Poço, Brisa},
    // {Fedor, "" , Brisa , ""},
    // {"", Brisa , Poço , Brisa}};
    String[][] Visão
            = {{"", "", "", ""},
            {"", "", "", ""},
            {"", "", "", ""},
            {Heroi, "", "", ""}};
    private boolean venceu = false;

    public void setMapa() {
        Tabuleiro mundoWumpus = new Tabuleiro();
        this.Mapa = mundoWumpus.Tabuleiro();
    }

    public void printMapa() {

        for (int i = 0; i < Mapa.length; i++) {
            for (int j = 0; j < Mapa.length; j++) {
                System.out.print(this.Mapa[i][j] + " | ");

            }
            System.out.println();
        }

        System.out.println("==============");

    }

    public void visão() {
        for (int i = 0; i < Visão.length; i++) {
            for (int j = 0; j < Mapa.length; j++) {
                System.out.print(this.Visão[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("==============");

    }

    public void Movimentar() {
        Random ran = new Random();
        int opção = ran.nextInt(4);

        switch (opção) {
            case 0:
                if (LinhaHeroi == 0) {
                    Movimentar();
                } else {
                    AndarCima();
                }
                break;

            case 1:
                if (LinhaHeroi == 3) {
                    Movimentar();
                } else {
                    AndarBaixo();
                }
                break;

            case 2:
                if (ColunaHeroi == 3) {
                    Movimentar();
                } else {
                    AndarDireita();
                }
                break;

            case 3:
                if (ColunaHeroi == 0) {
                    Movimentar();
                } else {
                    AndarEsquerda();
                }
                break;
        }

        Verificar();
    }

    public void AndarCima() {
        Visão[LinhaHeroi][ColunaHeroi] = Mapa[LinhaHeroi][ColunaHeroi];
        LinhaHeroi = LinhaHeroi - 1;
        Visão[LinhaHeroi][ColunaHeroi] = Mapa[LinhaHeroi][ColunaHeroi] + Heroi;
    }

    public void AndarBaixo() {
        Visão[LinhaHeroi][ColunaHeroi] = Mapa[LinhaHeroi][ColunaHeroi];
        LinhaHeroi = LinhaHeroi + 1;
        Visão[LinhaHeroi][ColunaHeroi] = Mapa[LinhaHeroi][ColunaHeroi] + Heroi;
    }

    public void AndarDireita() {
        Visão[LinhaHeroi][ColunaHeroi] = Mapa[LinhaHeroi][ColunaHeroi];
        ColunaHeroi = ColunaHeroi + 1;
        Visão[LinhaHeroi][ColunaHeroi] = Mapa[LinhaHeroi][ColunaHeroi] + Heroi;
    }

    public void AndarEsquerda() {
        Visão[LinhaHeroi][ColunaHeroi] = Mapa[LinhaHeroi][ColunaHeroi];
        ColunaHeroi = ColunaHeroi - 1;
        Visão[LinhaHeroi][ColunaHeroi] = Mapa[LinhaHeroi][ColunaHeroi] + Heroi;
    }

    public void Verificar() {
        if (Mapa[LinhaHeroi][ColunaHeroi] == Poço || Mapa[LinhaHeroi][ColunaHeroi] == Wumpus) {
            GameOver = true;
            System.out.println("you lose!!!");

        }

        if (Mapa[LinhaHeroi][ColunaHeroi] == Ouro) {
            GameOver = true;
            venceu = true;
            System.out.println(" VOCÊ PEGOU O OURO!!!");
        }
    }

    public void mapa1(String[] args) {

        setMapa();

    }

    public static void main(String[] args) {
        Wumpus c = new Wumpus();
        Tabuleiro tab = new Tabuleiro();

        c.Mapa = tab.Tabuleiro();

        c.visão();
        ArrayList<Integer> i = new ArrayList<>();
        ArrayList<Integer> j = new ArrayList<>();
        i.add(c.LinhaHeroi);
        j.add(c.ColunaHeroi);
        while (c.GameOver == false) {
            c.Movimentar();
            c.visão();
            i.add(c.LinhaHeroi);
            j.add(c.ColunaHeroi);
            // Thread.sleep(3000);
        }
        if (c.venceu == true) {
            System.out.println("*****************");
            for (int k = i.size() - 1; k >= 0; k--) {
                c.Visão[c.LinhaHeroi][c.ColunaHeroi] = "";

                c.Visão[i.get(k)][j.get(k)] = c.Mapa[i.get(k)][i.get(k)] + c.Heroi;
                c.visão();
            }

        }
    }
}


