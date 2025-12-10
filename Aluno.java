
import java.util.ArrayList;

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
    
    public void calculaCR(){
        int totalCargaHoraria = 0;
        double nota_ponderada = 0.0;
        for(Disciplina disciplina : disciplinas){
            nota_ponderada += disciplina.getNota(mat)*disciplina.getCargaHoraria();
            totalCargaHoraria += disciplina.getCargaHoraria();
        }
        if(totalCargaHoraria > 0){
            this.cr = nota_ponderada / totalCargaHoraria;
        }else{
            this.cr = 0.0;
        }
    }
}
