
import java.util.*;

public class Disciplina {
    private String cod_disciplina;
    private int cargaHoraria;
    private Double mediaCR;
    private HashMap<String,HashMap<String, Double>> notas; // matricula -> (semestre -> nota)

    //observação importante para mat 102 e 115, alunos cursando a mesma disciplina duas vezes

    public Disciplina(String cod_disciplina, int cargaHoraria){
        this.cod_disciplina = cod_disciplina;
        this.cargaHoraria = cargaHoraria;
        this.notas = new HashMap<>();
    }
    public int getCargaHoraria(){
        return cargaHoraria;
    }
    public Collection<Double> getNota(String mat){ //preciso agora devolver o vetor, precisa ser collection por ser mais genérico
        if(notas.containsKey(mat))
            return notas.get(mat).values();
        return null;
    }
    public Double getMediaCR(){
        return mediaCR;
    }
    public String getCodDisciplina(){
        return cod_disciplina;
    }

    public void adicionarNota(String mat, String semestre, Double nota){
        this.notas.putIfAbsent(mat, new HashMap<>()); //cria o espaço de memoria do hashmap
        this.notas.get(mat).put(semestre,nota);
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
