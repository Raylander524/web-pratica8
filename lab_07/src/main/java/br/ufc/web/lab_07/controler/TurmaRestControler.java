package br.ufc.web.lab_07.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class TurmaRestControler{

	@Autowired
	TurmaServices turmaServices;

	@GetMapping("/api/turma")
	public List<Turma> getTurmas(){
		return turmaServices.getTurmas();
	}

	@GetMapping("/api/turma/{codigo}")
	public Turma getTurmasCodigo(@PathVariable int codigo){
		return turmaServices.getTurma(codigo);
	}

	@PostMapping("/api/turma")
	public void addTurma(@RequestBody Turma turma) {
		turmaServices.addTurmas(turma);
	}

	@PutMapping("/api/turma/{codigo}")
    public void updateTurma(@PathVariable int codigo, @RequestBody Turma turma){
        turmaServices.updateTurma(codigo, turma);
    }

	@DeleteMapping("/api/turma/{codigo}")
    public void deleteTurma(@PathVariable int codigo){
        if (!turmaServices.deleteTurma(codigo)) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/turma/{codigo}/alunos")
	public List<Aluno> getAlunos(@PathVariable int codigo){
		return turmaServices.getAlunos(codigo);
	}

	@PostMapping("/api/turma/{codigo}/alunos")
	public void addAluno(@PathVariable int codigo,@RequestBody Aluno aluno) {
		turmaServices.addAluno(codigo, aluno);
	}

	@DeleteMapping("/api/turma/{codigo}/alunos/{matricula}")
    public void deleteAluno(@PathVariable int codigo,@PathVariable int matricula){
        if (!turmaServices.deleteAluno(codigo,matricula)) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
