package com.iiht.emark.controller;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.iiht.emark.entity.UserEntity;
import com.iiht.emark.service.UserBusiness;

import junit.framework.TestCase;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration
public class UserControllerTest extends TestCase {
    @Autowired
    private UserBusiness service;
    @Autowired
    private MockMvc mvc;
    public void setUp() throws Exception {
        super.setUp();
    }
    public void tearDown() throws Exception {
    }
    @Test
    public void findAllUsersShouldReturnDetails()
            throws Exception {
        this.mvc.perform(get("/api/user")).andExpect(status().isOk());
        List<UserEntity> categoryEntityList = this.service.findAllUsers();
        for(int nIndex=0;nIndex <categoryEntityList.size();nIndex++)
        {
            assertThat(categoryEntityList.get(nIndex).getId()).isEqualTo(nIndex+1);
        }
    }
}