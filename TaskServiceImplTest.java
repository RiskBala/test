package com.task.manager.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.task.manager.controller.Controller;
import com.task.manager.model.ParentTask;
import com.task.manager.model.Task;
import com.task.manager.model.TaskDAO;
import com.task.manager.repository.TaskRepository;

 
public class TaskServiceImplTest {

	@InjectMocks
 	Controller target;
	
	@Mock
	private TaskRepository repository;
	
	@Mock
	private TaskService taskService;
	
	private MockMvc mockMvc;
	
	@Before
	public void init() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(target).build();
		taskService = Mockito.mock(TaskService.class);
		 
	}
	
	@Test
	public void testViewTask_service() {
		List<TaskDAO> taskList = new ArrayList<TaskDAO>();
		TaskDAO newTaskDao = new TaskDAO();
		newTaskDao.setTask("Coding");
		newTaskDao.setParentTask("parentTask");
		newTaskDao.setParentTaskId(1);
		newTaskDao.setPriority(1);
		newTaskDao.setStartDate(new Date());
		newTaskDao.setEndDate(new Date());
		newTaskDao.setTaskId(1);
		newTaskDao.setStatus("Active");
		taskList.add(newTaskDao);
		when(taskService.getAllTasks()).thenReturn(taskList);
		target.viewtask();
		taskService.getAllTasks();
		verify(taskService).getAllTasks();
		assertEquals("Coding", taskList.get(0).getTask());
	}
	
	@Test
	public void testGetAllTask_service() {
		
		List<Task> tasks = new ArrayList<Task>();
		
		ParentTask parentTask = new ParentTask();
		parentTask.setParentTask("parentTask");
		parentTask.setParentId(1);
		
		Task task = new Task();
		task.setTask("Coding");
		task.setParentTask(parentTask);
		task.setPriority(1);
		task.setStartDate(new Date());
		task.setEndDate(new Date());
		task.setTaskId(1);
		task.setStatus("Active");
		tasks.add(task);
		when(repository.findAll()).thenReturn(tasks);
		ResponseEntity<List<TaskDAO>> taskDAO = target.viewtask();
		repository.findAll();
		verify(repository).findAll();
		List<TaskDAO>  taskVOList = taskService.getAllTasks();
		assertEquals("Coding", tasks.get(0).getTask());
		
	}
}
