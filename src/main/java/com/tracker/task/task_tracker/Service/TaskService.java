package com.tracker.task.task_tracker.Service;


import com.tracker.task.task_tracker.entities.Task;
import com.tracker.task.task_tracker.entities.TaskStatus;
import com.tracker.task.task_tracker.repositories.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;


    public Task saveTask(Task task){

        Task savedTask=taskRepository.save(task);
        System.out.println("task saved with id"+ savedTask.getId());
        return savedTask;

    }

    public List<Task> getAllTask(){
        List<Task> all = taskRepository.findAll();
        return all;
    }

    public  Task getTaskById(Long id){
        Task task = taskRepository.findById(id).
                orElseThrow(()->new RuntimeException("Task not found iwht id"+ id));

        return task;
    }

    public void deleteById(long id){
        Task task = taskRepository.findById(id).
                orElseThrow(()->new RuntimeException("Task not found iwht id"+ id));
        taskRepository.delete(task);
    }

    public List<Task> getByStatus(TaskStatus taskStatus){
        List<Task> byStatus = taskRepository.findByStatus(taskStatus);

        return byStatus;
    }
}
