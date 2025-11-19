package com.example.tarefas.controller;

import com.example.tarefas.model.Tarefa;
import com.example.tarefas.model.StatusTarefa;
import com.example.tarefas.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tarefa> listar() {
        return service.listarTarefas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscar(@PathVariable String id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Tarefa> criar(@RequestBody Tarefa tarefa) {
        if (tarefa.getStatus() == null) {
            tarefa.setStatus(StatusTarefa.PENDENTE);
        }
        Tarefa criado = service.criarTarefa(tarefa);
        return ResponseEntity.created(URI.create("/tarefas/" + criado.getId())).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable String id, @RequestBody Tarefa tarefa) {
        return ResponseEntity.ok(service.atualizarTarefa(id, tarefa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        service.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }
}
