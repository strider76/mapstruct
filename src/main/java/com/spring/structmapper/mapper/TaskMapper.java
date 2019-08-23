package com.spring.structmapper.mapper;

import com.spring.structmapper.dto.TaskDTO;
import com.spring.structmapper.model.Task;
import org.mapstruct.*;

@Mapper
public interface TaskMapper {

    @Mappings({
            @Mapping(source = "name", target = "nameDTO"),
            @Mapping(source = "details", target = "detailsDTO")
    })
    TaskDTO taskToTaskDTO(Task task);

    @InheritInverseConfiguration
    Task TaskDtoToTask(TaskDTO taskDTO);

    //actualizamos Task, metodo no devuelve y anotamos @mappingtarget sobre el parametro que se va a
    // actualizar, si los campos son diferentes, utilizamos @mapping
    @Mappings({
            @Mapping(source = "nameDTO", target = "name"),
            @Mapping(source = "detailsDTO", target = "details")
    })
    void updateTaskFromTaskDTO(TaskDTO taskDTO, @MappingTarget Task task);

}
