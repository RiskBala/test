package com.fsd.projectmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fsd.projectmanager.bo.ParentTaskVO;
import com.fsd.projectmanager.bo.ProjectVO;
import com.fsd.projectmanager.bo.TaskVO;
import com.fsd.projectmanager.bo.UserVO;
import com.fsd.projectmanager.entity.Task;


@Service
public interface ProjectService {
	
	public List<TaskVO> getAllTasks();
	
	public void saveTask(TaskVO task);
	
	public TaskVO getTask(String taskId);
	
	public void updateTask(TaskVO taskVO);
	
	
	public List<ParentTaskVO> getAllParentTasks();
	
	
	public List<ProjectVO> getAllProjects();
	
	public void saveProject(ProjectVO projectVO);
	
	public ProjectVO getProject(String projectId);
	
	public void updateProject(ProjectVO projectVO);
	
	
	public List<UserVO> getAllUsers();
	
	public void saveUser(UserVO userVO);
	
	public UserVO getUser(String userId);
	
	public void updateUser(UserVO userVO);
	
	
}
