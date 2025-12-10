
import java.util.ArrayList;

public class Aluno {
    private String mat;
    private int cod_curso;
    private ArrayList<Disciplina> disciplina;
    private double cr;
    private int cargaHorariaTotal;

    public String getMat(){
        return mat;
    }
    
    public void calculaCR(){
        int i = 0;
        double nota1 = 0.0;
        while(i < disciplina.size()){
            nota1 += disciplina.get(i).getNota(mat) * disciplina.get(i).getCargaHoraria();
            i++;
        }
        cr = nota1 / cargaHorariaTotal;
    }
}
