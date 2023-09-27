package org.iclass.mvc.dao;

import lombok.extern.slf4j.Slf4j;
import org.iclass.mvc.dto.Community;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class CommunityMapperTest {

    @Autowired
    CommunityMapper dao;

    @DisplayName("asd")
    @Test
    void count() {
        int count = dao.count();
    }

    @DisplayName("asr23r52rr3d")
    @Test
    void selectByIdx() {
        Community dto = dao.selectByIdx(110);
        Assertions.assertNotNull(dto);
    }
}