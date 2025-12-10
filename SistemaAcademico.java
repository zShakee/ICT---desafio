import java.io.*;
import java.util.*;
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

    private void processarLinha(String linha) {
        String[] dados = linha.split(" ");
         
        if(dados.length < 6){
            System.out.println("Linha inválida");
            return;
        }

        String mat = dados[0].trim();
        String codDisciplina = dados[1].trim();
        int codCurso = Integer.parseInt(dados[2].trim());
        double nota = Double.parseDouble(dados[3].trim());
        int cargaHoraria = Integer.parseInt(dados[4].trim());
        String anoSemestre = dados[5].trim();

        Aluno aluno = alunos.get(mat);
        if(aluno == null ){
            aluno = new Aluno(mat, codCurso);
            alunos.put(mat,aluno);
        }

        Disciplina disciplina = disciplinas.get(codDisciplina);
        if(disciplina == null){
            disciplina = new Disciplina(codDisciplina, cargaHoraria);
            disciplinas.put(codDisciplina,disciplina);
        }

        disciplina.adicionarNota(mat,nota);
        aluno.adicionarDisciplina(disciplina);

    }

    private void calcularTodosCR(){
        for(Aluno aluno : alunos.values())
            aluno.calculaCR();
    }
    private void calcularCRMedioDisciplina(){
        for(Disciplina disciplina : disciplinas.values()){
            disciplina.calcularMediaCR();
        }
    }

    public void imprimirRelatorioFinal(){
        List<Aluno> listaAlunos = new ArrayList<>(alunos.values());
        listaAlunos.sort(Comparator.comparing(Aluno::getMat));
        System.out.println("------- O CR dos alunos é: --------");

        for(Aluno aluno : alunos.values()){
             System.out.printf("Matrícula: %s | CR: %.2f%n",
                aluno.getMat(), aluno.getCR());
        }
        System.out.println("-----------------------------------");
        }

        List<Disciplina> listaDisciplinas = new ArrayList<>(disciplinas.values());
        listaDisciplinas.sort(Comparator.comparing(Disciplina::getCod));

    }
}
