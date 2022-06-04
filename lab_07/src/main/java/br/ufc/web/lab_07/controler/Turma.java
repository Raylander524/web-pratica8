package br.ufc.web.lab_07.controler;

import java.util.List;

public class Turma {
    private int codigo;
    private String disciplina;
    private int semestre;
    private List<Aluno> alunos;

    public Turma(int codigo, String disciplina, int semestre, List<Aluno> alunos){
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.semestre = semestre;
        this.alunos = alunos;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo(){
        return this.codigo;
    }

    public void setDisciplina(String disciplina){
        this.disciplina = disciplina;
    }

    public String getDisciplina(){
        return this.disciplina;
    }

    public void setSemestre(int semestre){
        this.semestre = semestre;
    }

    public int getSemestre(){
        return this.semestre;
    }

    public void setAlunos(List<Aluno> alunos){
        this.alunos = alunos;
    }

    public List<Aluno> getAlunos(){
        return this.alunos;
    }

}
