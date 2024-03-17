package com.jbudgets.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

public class TestService {

    private static final Logger LOG = LoggerFactory.getLogger(TestService.class);

    public void doSomething() {
        LOG.info("Testing");
    }
}
