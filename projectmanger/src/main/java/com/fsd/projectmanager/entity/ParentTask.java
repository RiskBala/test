package com.fsd.projectmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parent_tasks")
public class ParentTask {

	@Id
	@Column(name = "parent_task_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long parentTaskId;

	@Column(name = "parent_task_name")
	private String parentTaskName;

	@Column(name = "project_id")
	private String projectId;

	public ParentTask() {
		super();
	}

	public Long getParentTaskId() {
		return parentTaskId;
	}

	public void setParentTaskId(Long parentTaskId) {
		this.parentTaskId = parentTaskId;
	}

	public String getParentTaskName() {
		return parentTaskName;
	}

	public void setParentTaskName(String parentTaskName) {
		this.parentTaskName = parentTaskName;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	

}
