package br.ufc.web.lab_07.controler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TurmaServices {

    private List<Turma> turmas = new ArrayList<Turma>();
	private Aluno aluno = new Aluno(1, "pedro", "bwefb");
	
	public TurmaServices() {
		turmas.addAll(Arrays.asList(new Turma(1, "Livro", 200, Arrays.asList(aluno,aluno)),new Turma(2, "Livro", 200,Arrays.asList(aluno,aluno)),new Turma(3, "Livro", 200,Arrays.asList(aluno,aluno))));
	}

	public Turma getTurma(int codigo) {
		for (Turma turma : turmas) {
			if(turma.getCodigo() == codigo){
				return turma;
			}
		}
		return null;
	}
	
	public List<Turma> getTurmas() {
		return turmas;
	}

	public void addTurmas(Turma turma) {
		turmas.add(turma);
	}

	public void updateTurma(int codigo, Turma turma) {
		int i = 0;
		for (Turma turma2 : turmas) {
			if(turma2.getCodigo() == codigo){
				turmas.get(i).setDisciplina(turma.getDisciplina());
				turmas.get(i).setSemestre(turma.getSemestre());
			}
			i++;
		}
	}
	
	public Boolean deleteTurma(int codigo) {
		for (Turma turma2 : turmas) {
			if(turma2.getCodigo() == codigo){
				turmas.remove(turma2);
				return true;
			}
		}
		return false;
	}

	public Boolean deleteAluno(int codigo,int matricula) {
		for (Turma turma2 : turmas) {
			if(turma2.getCodigo() == codigo){
				List<Aluno> aluno = turma2.getAlunos();
				for (Aluno aluno2 : aluno) {
					if(aluno2.getMatricula() == matricula){
						turma2.getAlunos().remove(aluno2);
						return true;
					}
				}
			}
		}
		return false;
	}

	public List<Aluno> getAlunos(int codigo) {
		for (Turma turma : turmas) {
			if(turma.getCodigo() == codigo){
				return turma.getAlunos();
			}
		}
		return null;
	}

	public void addAluno(int codigo,Aluno aluno) {
		for (Turma turma2 : turmas) {
			if(turma2.getCodigo() == codigo){
				turma2.getAlunos().add(aluno);
			}
		}
	}
}
