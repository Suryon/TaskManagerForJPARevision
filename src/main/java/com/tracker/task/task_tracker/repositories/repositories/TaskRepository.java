package com.tracker.task.task_tracker.repositories.repositories;

import com.tracker.task.task_tracker.entities.Task;
import com.tracker.task.task_tracker.entities.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    //custom finder methods
    List<Task> findByTitle(String title);

    List<Task> findByStatus(TaskStatus taskStatus);

    List<Task> findByCreatedAt(LocalDateTime localDateTime);




    //query
    @Query("select t from Task t")
    List<Task> getAllTask();//


    @Query("select t from Task t where t.id=?1")
    Task getById(long id);


    @NativeQuery("select * from jpa_tasks")
    List<Task> getAllTask2();


    //save
    //findall,
    //delete find by id easy
}
