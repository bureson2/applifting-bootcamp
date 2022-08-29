package bootcamp.soloproject.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"/applicationContext-test.xml"})
@Transactional
class MonitoredEndpointServiceTest {

    @Resource(name="stu")
    private MonitoredEndpointService stu;
    @BeforeEach
    void setUp() {

    }

    @Test
    public void test(){
        Assertions.assertTrue(true);
    }

}