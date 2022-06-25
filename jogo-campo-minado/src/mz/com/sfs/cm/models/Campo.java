package mz.com.sfs.cm.models;

import java.util.ArrayList;
import java.util.List;

public class Campo {

    // o tabuleiro funciona como uma matriz de campos
    private final int LINHA;
    private final int COLUNA;

    // default de boolean é false
    private boolean aberto; // se esta aberto ou nao
    private boolean minado; // tem mina ou nao
    private boolean marcado; // se ja foi marcado ou nao

    private List<Campo> vizinhos = new ArrayList<>();

    public Campo(int linha, int coluna) {
        this.LINHA = linha;
        this.COLUNA = coluna;
    }
    
    boolean par(int n){
        if(n%2 == 0){
            return true;
        }
        
        return false;
    }
    boolean addVizinho(Campo campo) {
        // Verificar se o campo dado como parametro, esta na mesma linha ou cpluna
        boolean linhaDiferente = LINHA != campo.LINHA;
        boolean colunaDiferente = COLUNA != campo.COLUNA;
        // se n esta na mesma linha ou coluna, entao esta numa diagonal
        boolean diagonal = linhaDiferente && colunaDiferente;

        int deltaLinha = Math.abs(LINHA - campo.LINHA); // distancia entre linhas
        int deltaColuna = Math.abs(COLUNA - campo.COLUNA); // distacia entre colunas
        int deltaGeral = deltaLinha + deltaColuna; // deistancia entre os campos

        if (deltaColuna == 1 && !diagonal) {
            vizinhos.add(campo);
            return true;
        } else if (deltaGeral == 2 && diagonal) {
            vizinhos.add(campo);
            return true;
        } else {
            return false;
        }

    }
}
