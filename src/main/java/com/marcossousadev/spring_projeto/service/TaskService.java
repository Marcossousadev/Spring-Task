package com.marcossousadev.spring_projeto.service;

import com.marcossousadev.spring_projeto.domain.Task;
import com.marcossousadev.spring_projeto.exceptions.TaskNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    List<Task> tarefas = new ArrayList<>();

    public Task getTask(int id) {
        for (Task task : tarefas) {
            if (task.getId() == id) {
                return task;
            }
        }
        throw new TaskNotFoundException();
    }
    public String postTask(Task task){
            tarefas.add(task);
            task.setId(tarefas.size() - 1);
            return "Tarefa criada com sucesso!";
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
            try{
                tarefas.remove(id);

                for(int i = 0; i < tarefas.size(); i++){
                    tarefas.get(i).setId(i);
                }
                return "Tarefa removida com sucesso";
            }
            catch (IndexOutOfBoundsException e) {
                throw new TaskNotFoundException();
            }
    }
    public String updateStatusTask(int id) {
        try {
            Task task = tarefas.get(id);
            task.setStatus(!task.isStatus());
            boolean statusTask = task.isStatus();
            return "Task marcada como " + (statusTask ? "finalizada!" : "não finalizada!");
        }
        catch (IndexOutOfBoundsException e) {
            throw new TaskNotFoundException();
        }
    }
    public String updateDataTask(int id, Task body){
        try{
            Task task = tarefas.get(id);
            task.setTitulo(body.getTitulo());
            task.setDescription(body.getDescription());
            return "Task atualizada com sucesso!";
        }
        catch (IndexOutOfBoundsException e) {
            throw new TaskNotFoundException();
        }
    }
}
