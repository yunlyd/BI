package com.llllz.springbootinit.manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;


/**
 * @create 2023-09-30-16:48
 */



@SpringBootTest
class AiManagerTest {

    @Resource
    private AiManager aiManager;

    @Test
    void doChat() {
        String answer = aiManager.doChat(1708041898549448705L,"邓紫棋");
        System.out.println(answer);
    }
}