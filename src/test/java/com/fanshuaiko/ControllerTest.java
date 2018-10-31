package com.fanshuaiko;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ControllerTest {
    @Autowired
    private Controller controller;

    @Test
    public void longToShort() {
        URLEntity urlEntity = new URLEntity();
        urlEntity.setLongURL("");
    }
}