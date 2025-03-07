package com.logdbmanag;

import com.logdbmanag.dto.PageableDto;
import com.logdbmanag.exception.exceptions.FunctionalityNotAvailableException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//@SpringBootTest
class LoggingAndDatabaseManagerApplicationTests {

    @Test
    void contextLoads() {
        PageableDto pageableDto = new PageableDto(List.of(), 0, 0, 0);
        System.out.println(pageableDto.getCurrentPage());
///*        System.out.println("Hello World");
//        try {
//            throw new FunctionalityNotAvailableException("test");
//        } catch (FunctionalityNotAvailableException e) {
//            System.out.println("catched exception");
//        }*/
    }

}
