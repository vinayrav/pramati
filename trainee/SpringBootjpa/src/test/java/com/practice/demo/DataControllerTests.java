package com.practice.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringBootjpaApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataControllerTests {

 @Autowired
 private WebApplicationContext wac;

 @InjectMocks
 private DataController dataController;

 @Mock
 private DataRepo dataRepo;
 //private final String input = "{\"bid\": 4,\"bname\": \"b4\" }";
 private MockMvc mockMvc;


 @Before
 public void setUp() throws Exception {
  this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

  System.out.println(mockMvc);
 }
 //test to get the single data details by id
 @Test
 public void testGetDataById() throws Exception {
  mockMvc.perform(get("/data/3"))
   .andExpect(status().isOk())
   .andExpect(jsonPath("$.bid").exists())
   .andExpect(jsonPath("$.bname").exists())
   .andExpect(jsonPath("$.bid").value(3))
   .andExpect(jsonPath("$.bname").value("b3"))
   .andDo(print());


  //	MvcResult result=mockMvc.perform(get("/data/1")).andReturn();		
  //	System.out.println(result.getResponse().getContentAsString());

  //Mockito.verify(dataRepo).findById(1);
 }

 //Test to check the complete data
 @Test
 public void testGetData() throws Exception {
  mockMvc.perform(get("/data"))
   .andExpect(jsonPath("$[0].bid", is(1)))
   .andExpect(jsonPath("$[0].bname", is("b1")));
 }

 //Test to check whether the data is added
 @Test
 public void testPostData() throws Exception {
  mockMvc.perform(post("/data")
    .content("{\"bid\": 5,\"bname\": \"b5\"}")
    .contentType(MediaType.APPLICATION_JSON_VALUE))
   //.andDo(print())
   .andExpect(status().isOk())

   .andExpect(jsonPath("$.bid").exists())
   .andExpect(jsonPath("$.bname").exists())
   .andExpect(jsonPath("$.bid").value(5))
   .andExpect(jsonPath("$.bname").value("b5"));

 }

 //Test for the Invalid case of adding data
 @Test
 public void testInvalidPostData() throws Exception {

  mockMvc.perform(post("/data")
    .content("{\"bid\": 4,\"bname\":}")
    .contentType(MediaType.APPLICATION_JSON_VALUE))
   .andDo(print())
   .andExpect(status().is4xxClientError());
 }


 //Test to check whether the data is getting updated
 @Test
 public void testUpdateData() throws Exception {

  mockMvc.perform(put("/data")
    .content("{\"bid\": 3,\"bname\": \"b4\"}")
    .contentType(MediaType.APPLICATION_JSON_VALUE))
   .andDo(print())
   .andExpect(status().isOk())
   .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
   .andExpect(jsonPath("$.bid", is(3)))
   .andExpect(jsonPath("$.bname", is("b4")));
 }

 //Test to check update data when bad input is given
 @Test
 public void testInvalidUpdateData() throws Exception {

  mockMvc.perform(put("/data")
    .content("{\"bid\": 4,\"bname\":}")
    .contentType(MediaType.APPLICATION_JSON_VALUE))
   .andDo(print())
   .andExpect(status().is4xxClientError());
 }

 //Test to check if the data is being deleted
 @Test
 public void testDeleteData() throws Exception {
  mockMvc.perform(MockMvcRequestBuilders.delete("/data/2"))
   .andDo(print())
   .andExpect(status().isOk());
 }
 //Test to check if invalid data is given to delete
 //	@Test
 //	public void testIvalidDeleteData() throws EntityNotFoundException{
 //		try {
 //			mockMvc.perform(MockMvcRequestBuilders.delete("/data/8"))
 //			       .andDo(print())
 //				   .andExpect(status().is5xxServerError());
 //		} catch (Exception e) {
 //			
 //			e.printStackTrace();
 //		}
 //}
}