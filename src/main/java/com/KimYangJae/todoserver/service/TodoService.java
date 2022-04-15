package com.KimYangJae.todoserver.service;

import com.KimYangJae.todoserver.model.TodoEntity;
import com.KimYangJae.todoserver.model.TodoRequest;
import com.KimYangJae.todoserver.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoEntity add(TodoRequest todoRequest){
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(todoRequest.getTitle());
        todoEntity.setOrder(todoRequest.getOrder());
        todoEntity.setCompleted(todoRequest.getCompleted());
        return this.todoRepository.save(todoEntity);
    }

    public TodoEntity searchById(Long id){
        return this.todoRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<TodoEntity> searchAll(){
        return this.todoRepository.findAll();
    }

    public TodoEntity updateById(Long id, TodoRequest request){
        TodoEntity todoEntity = this.searchById(id);
        if(request.getTitle() != null)
            todoEntity.setTitle(request.getTitle());
        if(request.getOrder() != null)
            todoEntity.setOrder(request.getOrder());
        if(request.getCompleted() != null)
            todoEntity.setCompleted(request.getCompleted());
        return this.todoRepository.save(todoEntity);
    }

    public void deleteById(Long id){
        this.todoRepository.deleteById(id);
    }

    public void deleteAll(){
        this.todoRepository.deleteAll();
    }
}
