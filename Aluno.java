import java.util.*;

public class Aluno {
    private String mat;
    private int cod_curso;
    private ArrayList<Disciplina> disciplinas;
    private double cr;

    public Aluno(String mat, int cod_curso){
        this.mat = mat;
        this.cod_curso = cod_curso;
        this.cr = 0.0;
        this.disciplinas = new ArrayList<>();
    }

    public String getMat(){
        return mat;
    }

    public Double getCR(){
        return cr;
    }
    
    public void adicionarDisciplina(Disciplina disciplina){
        if(!disciplinas.contains(disciplina))
            disciplinas.add(disciplina);
    }

    public void exibeDisciplinas(){
        for(Disciplina disciplina : disciplinas){
            System.out.printf("%s\n", disciplina.getCodDisciplina());
        }
    }
    
    public void calculaCR(){
        if(disciplinas.isEmpty()){
            this.cr = 0.0;
            return;
        }


        int totalCargaHoraria = 0;
        double nota_ponderada = 0.0;


        for(Disciplina disciplina : disciplinas){
            Collection<Double> notas = disciplina.getNota(mat);
            if(notas != null){ 
                for(Double nota : notas){
                    if(nota == null) continue;
                    nota_ponderada += nota*disciplina.getCargaHoraria();
                    totalCargaHoraria += disciplina.getCargaHoraria();
                }
            }
        }
        if(totalCargaHoraria > 0){
            this.cr = nota_ponderada / totalCargaHoraria;
        }else{
            this.cr = 0.0;
        }
    }
}
