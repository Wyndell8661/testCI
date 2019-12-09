package com.example.demo.mock;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;

//@RunWith(PowerMockRunner.class)
//@PowerMockIgnore({"javax.management.*","javax.net.ssl.*"})
@RunWith(SpringRunner.class)
@SpringBootTest
public class MockServiceTest {


    @InjectMocks
    @Autowired
    public MockService mockService;

    @Mock
    public MockDao mockDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMock(){
        System.out.println("————————————————————");
        mockService.getName();
        System.out.println("————————————————————");
    }


    @Test
    public void testInject(){
        Mockito.when(mockDao.getName(ArgumentMatchers.anyString())).thenReturn(Arrays.asList("Mock","Dao"));
        mockService.getName();
    }


}
