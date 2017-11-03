package com.macro.readinglist;

import static org.hamcrest.Matchers.*;

import com.macro.readinglist.domain.Reader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@Before
	public void setupMokMvc(){
		mockMvc = MockMvcBuilders
				.webAppContextSetup(webApplicationContext)
				.apply(SecurityMockMvcConfigurers.springSecurity())
				.build();
	}

	@Test
	public void homePage() throws Exception {
		mockMvc.perform(get("/readingList"))
				.andExpect(status().isOk())
				.andExpect(view().name("readingList"))
				.andExpect(model().attributeExists("books"))
				.andExpect(model().attribute("books", is(empty())));
	}

	@Test
	public void postBook() throws Exception {
		mockMvc.perform(post("/readingList")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("title", "BOOK TITLE")
				.param("author", "BOOK AUTHOR")
				.param("isbn", "1234567890")
				.param("description", "DESCRIPTION"))
				.andExpect(status().is3xxRedirection())
				.andExpect(header().string("Location","readingList"))
		;
	}

	@Test
	public void homePage_unauthenticatedUser() throws Exception{
		mockMvc.perform(get("/"))
				.andExpect(status().is3xxRedirection())
				.andExpect(header().string("Location","http://localhost/login"));
	}

	@Test
	@WithMockUser(username = "macro",password = "123",roles = "READER")
	public void homePage_authenticatedUser() throws Exception{
		mockMvc.perform(get("/"))
				.andExpect(status().isOk());
	}

	@Test
	@WithUserDetails("macro")
	@WithMockUser(username = "macro",password = "123",roles = "READER")
	public void homePage_authenticatedUser2() throws Exception{
		Reader reader = new Reader();
		reader.setUsername("macro");
		reader.setPassword("123");
		reader.setFullname("macro cheng");
		mockMvc.perform(get("/"))
				.andExpect(model().attribute("reader",samePropertyValuesAs(reader)))
				.andExpect(model().attribute("books",hasSize(2)));
	}

}
