package com.example.demo.apitest;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.demo.entity.Project;
import com.example.demo.entity.Status;
import com.example.demo.entity.Task;
import com.example.demo.entity.Users;
import com.example.demo.service.ProjectServiceImplementation;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest
public class ProjectControllerIntegrationTest {
  
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	private ProjectServiceImplementation pService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	List<Project> proj=new ArrayList<>();
	Users user=new Users(1L,"John Doe", "john@example.com", "12345",proj);
	Set<Task> tasks = new HashSet<>();
	
	 @Test
	 public void saveTest() throws Exception{
		 Project project= Project.builder()
				 .project_id(1L)
				 .title("Java")
				 .startDate(LocalDate.now())
				 .endDate(LocalDate.now().plusDays(8))
				 .status(Status.ACTIVE)
                 .users(user)
                 .tasks(tasks)
                 .build();
		 given(pService.CreateProject(any(Project.class)))
		         .willAnswer((invocation) -> invocation.getArgument(0));
		 
		 ResultActions response=mockMvc.perform(post("/project/create"));
				 //.contentType(MediaType.APPLICATION_JSON)
		        // .content(objectMapper.writeValueAsString(project));
		         
                 
		
		 response.andDo(print())
		    .andExpect(status().isCreated())
		    .andExpect(jsonPath("$.title",
		    		is(project.getTitle())))
		    .andExpect(jsonPath("$.startDate",
		    		is(project.getStartDate())))
		    .andExpect(jsonPath("$.endDate",
		    		is(project.getEndDate())))
		    .andExpect(jsonPath("$.status",
		    		is(project.getUsers())))
		    .andExpect(jsonPath("$.tasks",
		    		is(project.getTasks())));
	 }

    
	 @Test
	 public void getProjectTasks() throws Exception{
	        // given - precondition or setup
	        List<Project> listOfProject = new ArrayList<>();
	        listOfProject.add(Project.builder().title("Project1")
	        		.startDate(LocalDate.now())
	        		.endDate(LocalDate.now().plusDays(8))
	        		.status(Status.ACTIVE)
	        		.users(user)
	        		.tasks(tasks)
	        		.build());

	        // when -  action or the behaviour that we are going test
	        ResultActions response = mockMvc.perform(get("/project/allProjects"));

	        // then - verify the output
	        response.andExpect(status().isOk())
	                .andDo(print())
	                .andExpect(jsonPath("$.size()",
	                        is(listOfProject.size())));

	    }
	 
	 @Test
	 public void givenProjectId() throws Exception{
	        // given - precondition or setup
	        Long projectId = 1L;
	        Project project = Project.builder()
	        		 .project_id(1L)
					 .title("Java")
					 .startDate(LocalDate.now())
					 .endDate(LocalDate.now().plusDays(8))
					 .status(Status.ACTIVE)
	                 .users(user)
	                 .tasks(tasks)
	                 .build();
	        given(pService.ViewProjectWithId(projectId)).willReturn(Optional.of(project));

	        // when -  action or the behaviour that we are going test
	        ResultActions response = mockMvc.perform(get("/project/view/{id}", projectId));

	        // then - verify the output
	        response.andExpect(status().isOk())
	                .andDo(print())
	                .andExpect(status().isCreated())
	    		    .andExpect(jsonPath("$.title",
	    		    		is(project.getTitle())))
	    		    .andExpect(jsonPath("$.startDate",
	    		    		is(project.getStartDate())))
	    		    .andExpect(jsonPath("$.endDate",
	    		    		is(project.getEndDate())))
	    		    .andExpect(jsonPath("$.status",
	    		    		is(project.getUsers())))
	    		    .andExpect(jsonPath("$.tasks",
	    		    		is(project.getTasks())));

	    }
	 //Handle Negative Scenario
	 @Test
	 public void givenNeg() throws Exception{
	        // given - precondition or setup
		    Long projectId = 1L;
	        Project project = Project.builder()
	        		 .project_id(1L)
					 .title("Project1")
					 .startDate(LocalDate.now())
					 .endDate(LocalDate.now().plusDays(8))
					 .status(Status.ACTIVE)
	                 .users(user)
	                 .tasks(tasks)
	                 .build();
	        given(pService.ViewProjectWithId(projectId)).willReturn(Optional.empty());


	        // when -  action or the behaviour that we are going test
	        ResultActions response = mockMvc.perform(get("/project/view/{id}", projectId));

	        // then - verify the output
	        response.andExpect(status().isNotFound())
	                .andDo(print());

	    }
	 
	  @Test
      public void updateProject() throws Exception{
          // given - precondition or setup
          Long projectId = 1L;
          Project Savedproject = Project.builder()
	        		 .project_id(1L)
					 .title("Java Development")
					 .startDate(LocalDate.now())
					 .endDate(LocalDate.now().plusDays(8))
					 .status(Status.ACTIVE)
	                 .users(user)
	                 .tasks(tasks)
	                 .build();

          Project Updatedproject = Project.builder()
	        		 .project_id(1L)
					 .title("Android")
					 .startDate(LocalDate.now())
					 .endDate(LocalDate.now().plusDays(8))
					 .status(Status.ACTIVE)
	                 .users(user)
	                 .tasks(tasks)
	                 .build();
          
          given(pService.ViewProjectWithId(projectId)).willReturn(Optional.of(Savedproject));
          given(pService.UpdateProjectExist(any(projectId,Project.class)))
                  .willAnswer((invocation)-> invocation.getArgument(0));

          // when -  action or the behaviour that we are going test
          ResultActions response = mockMvc.perform(put("/project/update", projectId)
                                      .contentType(MediaType.APPLICATION_JSON)
                                      .content(objectMapper.writeValueAsString(Updatedproject)));


          // then - verify the output
          response.andExpect(status().isOk())
                  .andDo(print())
                  .andExpect(jsonPath("$.title", is(Updatedproject.getTitle())))
                  .andExpect(jsonPath("$.endDate", is(Updatedproject.getEndDate())))
                  .andExpect(jsonPath("$.status", is(Updatedproject.getStatus())));
      }
	 
	 @Test
	 public void deleteProjectByID() throws Exception{
	        // given - precondition or setup
	        Long project_id = 1L;
	        willDoNothing().given(pService).deleteEmployee(project_id);

	        // when -  action or the behaviour that we are going test
	        ResultActions response = mockMvc.perform(delete("/projects/remove/{id}",  project_id));

	        // then - verify the output
	        response.andExpect(status().isOk())
	                .andDo(print());
	    }
}

















