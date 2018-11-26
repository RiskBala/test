package com.fsd.projectmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.projectmanager.bo.ParentTaskVO;
import com.fsd.projectmanager.bo.ProjectVO;
import com.fsd.projectmanager.bo.TaskVO;
import com.fsd.projectmanager.bo.UserVO;
import com.fsd.projectmanager.entity.Task;
import com.fsd.projectmanager.service.impl.ProjectServiceImpl;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class ProjectController {
	@Autowired
	private ProjectServiceImpl projectManagerService;
	
	
	@GetMapping("/hometest")
	public String testHome() {
		return "Project Manager App - Test Task ";
	}
	
	@GetMapping("/tasks")
	public List<TaskVO> getTasks() {
		List<TaskVO> tasks =projectManagerService.getAllTasks();
		return tasks;
	}
	
	@GetMapping("/tasks/{taskId}")
	public TaskVO getTasksById(@PathVariable(name="taskId") String taskId) {
		TaskVO task = projectManagerService.getTask(taskId); 
		return task;
	}
	
	@PostMapping(path = "/tasks", consumes = "application/json", produces = "application/json")
	public boolean saveTask(@RequestBody TaskVO task) {
		try {
			
			projectManagerService.saveTask(task);
		}catch(Exception e)
		{
			System.out.println("Save Task Failed : " + e.getMessage());
			return false;
		}
		return true;
	}	
	
	@PutMapping("/tasks/{taskId}")
	public boolean updateTask(@RequestBody TaskVO task, @PathVariable(name="taskId") String taskId) {
		try {
			TaskVO taskExists = projectManagerService.getTask(taskId);
			if(taskExists != null) {
				projectManagerService.updateTask(task);
			}else {
				System.out.println("updateTask: No task available in the task id : " + taskId);
				return false;
			}
		}catch(Exception e)
		{
			System.out.println("Update Task Failed : " + e.getMessage());
			return false;
		}
		return true;
	}
	
	@DeleteMapping("/tasks/{taskId}")
	public boolean deleteTask(@PathVariable(name="taskId") String taskId) {
		try {
			TaskVO taskRetrived = projectManagerService.getTask(taskId);
			if(taskRetrived != null) {
				taskRetrived.setStatus("I");
				projectManagerService.updateTask(taskRetrived);
			}else {
				System.out.println("deleteTask: No task available in the task id : " + taskId);
				return false;
			}
		}catch(Exception e)
		{
			System.out.println("Delete Task Failed : " + e.getMessage());
			return false;
		}
		return true;
	}
	
	
	@GetMapping("/ParentTasks")
	public List<ParentTaskVO> getParentTasks() {
		List<ParentTaskVO> tasks =projectManagerService.getAllParentTasks();
		return tasks;
	}
	
	
	@GetMapping("/projects")
	public List<ProjectVO> getProjects() {
		List<ProjectVO> tasks =projectManagerService.getAllProjects();
		return tasks;
	}
	
	
	@GetMapping("/projects/{projectsId}")
	public ProjectVO getProjectById(@PathVariable(name="projectsId") String projectsId) {
		ProjectVO projectVO = projectManagerService.getProject(projectsId); 
		return projectVO;
	}
	
	
	@PostMapping(path = "/projects", consumes = "application/json", produces = "application/json")
	public boolean saveProject(@RequestBody ProjectVO projectVO) {
		try {
			
			projectManagerService.saveProject(projectVO);
		}catch(Exception e)
		{
			System.out.println("Save Project Failed : " + e.getMessage());
			return false;
		}
		return true;
	}	
	
	@PutMapping("/projects/{projectID}")
	public boolean updateProject(@RequestBody ProjectVO projectVO, @PathVariable(name="projectID") String projectId) {
		try {
			ProjectVO projectexist = projectManagerService.getProject(projectId);
			if(projectexist != null) {
				projectManagerService.updateProject(projectVO);
			}else {
				System.out.println("updateProject: No project available in the project id : " + projectId);
				return false;
			}
		}catch(Exception e)
		{
			System.out.println("Update Project Failed : " + e.getMessage());
			return false;
		}
		return true;
	}
	
	@DeleteMapping("/projects/{projectsId}")
	public boolean deleteprojects(@PathVariable(name="projectsId") String projectsId) {
		try {
			ProjectVO projectVO = projectManagerService.getProject(projectsId);
			if(projectVO != null) {
				projectVO.setStatus("completed");
				projectManagerService.updateProject(projectVO);
			}else {
				System.out.println("deleteproject: No project available in the project id : " + projectsId);
				return false;
			}
		}catch(Exception e)
		{
			System.out.println("Delete project Failed : " + e.getMessage());
			return false;
		}
		return true;
	}
	
	
	@GetMapping("/users")
	public List<UserVO> getusers() {
		List<UserVO> users =projectManagerService.getAllUsers();
		return users;
	}
	
	
	@GetMapping("/users/{userID}")
	public UserVO getUserById(@PathVariable(name="userID") String userId) {
		UserVO userVO = projectManagerService.getUser(userId); 
		return userVO;
	}
	
	@PostMapping(path = "/users", consumes = "application/json", produces = "application/json")
	public boolean saveUser(@RequestBody UserVO userVO) {
		try {
			
			projectManagerService.saveUser(userVO);
		}catch(Exception e)
		{
			System.out.println("Save Project Failed : " + e.getMessage());
			return false;
		}
		return true;
	}	
	
	@PutMapping("/users/{userID}")
	public boolean updateProject(@RequestBody UserVO userVO, @PathVariable(name="userID") String userID) {
		try {
			UserVO userexist = projectManagerService.getUser(userID);
			if(userexist != null) {
				projectManagerService.updateUser(userexist);
			}else {
				System.out.println("update user: No user available in the user id : " + userID);
				return false;
			}
		}catch(Exception e)
		{
			System.out.println("Update user Failed : " + e.getMessage());
			return false;
		}
		return true;
	}
	
	@DeleteMapping("/users/{userID}")
	public boolean deleteUser(@PathVariable(name="userID") String userID) {
		try {
			UserVO userexist = projectManagerService.getUser(userID);
			if(userexist != null) {
				userexist.setStatus("I");
				projectManagerService.updateUser(userexist);
			}else {
				System.out.println("delete user: No user available in the user id : " + userID);
				return false;
			}
		}catch(Exception e)
		{
			System.out.println("Delete user Failed : " + e.getMessage());
			return false;
		}
		return true;
	}
	
}
