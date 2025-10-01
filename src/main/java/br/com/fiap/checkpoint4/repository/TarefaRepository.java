package br.com.fiap.checkpoint4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.checkpoint4.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
