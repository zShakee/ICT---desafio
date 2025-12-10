
import java.util.HashMap;

public class Disciplina {
    private String cod_disciplina;
    private int cargaHoraria;
    private Double mediaCR;
    private HashMap<String,Double> notas; // matricula -> nota

    public Disciplina(String cod_disciplina, int cargaHoraria){
        this.cod_disciplina = cod_disciplina;
        this.cargaHoraria = cargaHoraria;
        this.notas = new HashMap<>();
    }
    public int getCargaHoraria(){
        return cargaHoraria;
    }
    public Double getNota(String mat){
        return notas.get(mat);
    }
    public Double getMediaCR(){
        return mediaCR;
    }
    public String getCodDisciplina(){
        return cod_disciplina;
    }

    public void adicionarNota(String mat, Double nota){
        notas.put(mat,nota);
    }

    /* 
    public void calcularMediaCR(){
         if(notas.isEmpty()){
            return;
        }
        Double soma = 0.0;
        for(Double notaAluno : notas.values())
             soma += notaAluno;
        this.mediaCR = soma/notas.size();
    }
    */
}
