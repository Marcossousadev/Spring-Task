package com.marcossousadev.spring_projeto.service;

import com.marcossousadev.spring_projeto.domain.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    List<Task> tarefas = new ArrayList<>();

    public Task getTask(int id){
         for(Task task: tarefas) {
             if(task.getId() == id) {
                 return task;
             }
        }
         return null;
    }

    public String postTask(Task task){
        try {
            tarefas.add(task);
            task.setId(tarefas.size() - 1);
            return "Tarefa criada com sucesso!";
        }
        catch (Exception e){
            return "Erro ao criar tarefa!";
        }
    }
    public List<Task> getTasks(String filter){
        if(filter == null){
            return tarefas;
        }
        else {
            List<Task> lista_filtrada = tarefas.stream().filter(task -> task.getTitulo().equals(filter)).toList();
            return lista_filtrada;
        }
    }
    public String deleteTask(int id){
        try {
            tarefas.remove(id);

            for(int i = 0; i < tarefas.size(); i++){
                tarefas.get(i).setId(i);
            }
            return "Tarefa removida com sucesso";
        }
        catch (Exception IndexOutOfBoundsException) {
            return "Erro a deletar task, lista vazia!";
        }
    }
    public String updateStatusTask(int id) {
        try {
            Task task = tarefas.get(id);
            task.setStatus(!task.isStatus());
            boolean statusTask = task.isStatus();
            return "Task marcada como " + (statusTask ? "finalizada!" : "não finalizada!");
        }
        catch (Exception IndexOutOfBoundsException) {
            return "Erro ao atualizar status task, lista vazia!";
        }
    }
    public String updateDataTask(int id, Task body){
        try{
            Task task = tarefas.get(id);
            task.setTitulo(body.getTitulo());
            task.setDescription(body.getDescription());
            return "Task atualizada com sucesso!";
        }
        catch (Exception IndexOutOfBoundsException) {
            return "Erro ao atualizar dados da task, lista vazia!";
        }
    }
}
