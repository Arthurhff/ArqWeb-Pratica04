package com.example.tarefas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document(collection = "tarefas")
public class Tarefa {
    @Id
    private String id;
    private String titulo;
    private String descricao;
    private Instant dataCriacao;
    private Instant dataConclusao;
    private StatusTarefa status;

    public Tarefa() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Instant getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(Instant dataCriacao) { this.dataCriacao = dataCriacao; }
    public Instant getDataConclusao() { return dataConclusao; }
    public void setDataConclusao(Instant dataConclusao) { this.dataConclusao = dataConclusao; }
    public StatusTarefa getStatus() { return status; }
    public void setStatus(StatusTarefa status) { this.status = status; }
}
