package com.endie.avizandum.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DistrictControllerTest {
    @Autowired
     DistrictController controller;

    //Test getDistrictById endpoint
    @Test
    public void testGetDistrictById() throws Exception {
        assertThat(controller.getDistrictById(1L)).isNotNull();
    }
}
