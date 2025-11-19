package com.example.tarefas.service;

import com.example.tarefas.exception.ResourceNotFoundException;
import com.example.tarefas.model.Tarefa;
import com.example.tarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
public class TarefaService {
    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public Tarefa criarTarefa(Tarefa tarefa) {
        tarefa.setDataCriacao(Instant.now());
        return repository.save(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return repository.findAll();
    }

    public Tarefa buscarPorId(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada com id: " + id));
    }

    public Tarefa atualizarTarefa(String id, Tarefa dados) {
        Tarefa existente = buscarPorId(id);
        if (dados.getTitulo() != null) existente.setTitulo(dados.getTitulo());
        if (dados.getDescricao() != null) existente.setDescricao(dados.getDescricao());
        if (dados.getDataConclusao() != null) existente.setDataConclusao(dados.getDataConclusao());
        if (dados.getStatus() != null) existente.setStatus(dados.getStatus());
        return repository.save(existente);
    }

    public void deletarTarefa(String id) {
        Tarefa existente = buscarPorId(id);
        repository.delete(existente);
    }
}
