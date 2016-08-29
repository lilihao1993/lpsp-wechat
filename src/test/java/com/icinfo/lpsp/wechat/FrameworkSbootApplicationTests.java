package com.icinfo.lpsp.wechat;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FrameworkSbootApplication.class)
@WebAppConfiguration
public class FrameworkSbootApplicationTests {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    private RestTemplate restTemplate = new TestRestTemplate();

    /**
     * 初始化mock
     */
    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    @Ignore
    public void contextLoads() {

    }

    /**
     * mock形式
     * home restful 接口测试
     * @throws Exception
     */
    @Test
    @Ignore
    public void testHomeApiWithMock() throws Exception {
        logger.info(mockMvc.perform(get("/")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString());
    }

    /**
     * restTemplate形式
     * home restful 接口测试
     * @throws Exception
     */
    @Test
    @Ignore
    public void testHomeApiWithRestTemplate() throws Exception{
        List forObject = restTemplate.getForObject("http://localhost:8080/", List.class);
        Map<Object,Object> u = (LinkedHashMap)forObject.get(0);
        logger.info(u.get("realName").toString());
    }

}
