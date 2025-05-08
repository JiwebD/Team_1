package com.example.demo.domain.mapper;

import com.example.demo.domain.dto.ProjectDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectMapper {

    @Insert("INSERT INTO project (project_title, project_info, image_path) " +
            "VALUES (#{projectTitle}, #{projectInfo}, #{imagePath})")
    @Options(useGeneratedKeys = true, keyProperty = "projectId", keyColumn = "project_id")
    void insertProject(ProjectDto dto);

    @Select("select * from project")
    @Results({
            @Result(property = "projectId", column = "project_id"),
            @Result(property = "projectTitle", column = "project_title"),
            @Result(property = "projectInfo", column = "project_info"),
            @Result(property = "imagePath", column = "image_path")
    })
    List<ProjectDto> selectAll();


    @Delete("DELETE FROM project WHERE project_id = #{projectId}")
    void deleteProject(Integer projectId);



    @Update("UPDATE project SET project_title=#{projectTitle}, project_info=#{projectInfo}, image_path=#{imagePath} WHERE project_id=#{projectId}")
    void updateProject(ProjectDto dto);

    @Select("SELECT * FROM project WHERE project_id = #{projectId}")
    @Results({
            @Result(property = "projectId", column = "project_id"),
            @Result(property = "projectTitle", column = "project_title"),
            @Result(property = "projectInfo", column = "project_info"),
            @Result(property = "imagePath", column = "image_path")
    })
    ProjectDto selectOne(int projectId);

}
