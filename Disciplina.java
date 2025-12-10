
import java.util.HashMap;

public class Disciplina {
    private String cod_disciplina;
    private int cargaHoraria;
    private HashMap<String,Integer> notas;
    public Disciplina(){

    }
    public int getCargaHoraria(){
        return cargaHoraria;
    }
    public Integer getNota(String mat){
        return notas.get(mat);
    }
    public int calcularMediaCR(){
        int mediaCR,soma = 0;
        for(int notaAluno : notas.values())
             soma += notaAluno;
        return soma/notas.size();
    }
}
