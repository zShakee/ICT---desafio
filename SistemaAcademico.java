import java.util.*;
import java.io.*;
public class SistemaAcademico {
    HashMap<String, Aluno> alunos;
    HashMap<String, Disciplina> disciplinas;
    public SistemaAcademico(){
        alunos = new HashMap<>();
        disciplinas = new HashMap<>();
    }
    public void processarArquivo(String nomeArq) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(nomeArq));
        String linha;
        while((linha = br.readLine()) != null ){
            processarLinha(linha);
        }
        br.close();
        calcularTodosCR();
        calcularCRMedioDisciplina();
    }
}
