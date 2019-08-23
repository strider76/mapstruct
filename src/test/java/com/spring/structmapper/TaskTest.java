package com.spring.structmapper;

import com.spring.structmapper.dto.TaskDTO;
import com.spring.structmapper.mapper.TaskMapper;
import com.spring.structmapper.model.Task;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTest {

    @Autowired
    TaskMapper taskMapper;

    private Task task;
    private TaskDTO taskDTO;

    @Before
    public  void init() {
        task = new Task();
        task.setId(1L);
        task.setName("nombre");
        task.setDetails("detalles");
        task.setActive(true);

        taskDTO = new TaskDTO();
        taskDTO.setId(2L);
        taskDTO.setNameDTO("nombreMod");
        taskDTO.setDetailsDTO("detallesMod");
    }

    @Test
    public void testDaoToDto() {
        TaskDTO taskDTO = taskMapper.taskToTaskDTO(task);

        Assert.assertEquals(taskDTO.getId(),task.getId());
        Assert.assertEquals(taskDTO.getNameDTO(),task.getName());
        Assert.assertEquals(taskDTO.getDetailsDTO(),task.getDetails());
    }

    @Test
    public void testDtoToDao() {
        Task task1 = taskMapper.TaskDtoToTask(taskDTO);
        Assert.assertEquals(taskDTO.getId(),task1.getId());
        Assert.assertEquals(taskDTO.getNameDTO(),task1.getName());
        Assert.assertEquals(taskDTO.getDetailsDTO(),task1.getDetails());
    }

    @Test
    public void testUpdateDao() {
        taskMapper.updateTaskFromTaskDTO(taskDTO, task);
        Assert.assertEquals(taskDTO.getId(),task.getId());
        Assert.assertEquals(taskDTO.getNameDTO(),task.getName());
        Assert.assertEquals(taskDTO.getDetailsDTO(),task.getDetails());

    }

}
