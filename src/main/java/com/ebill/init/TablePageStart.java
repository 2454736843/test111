package com.ebill.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class TablePageStart implements ApplicationRunner {

    @Autowired
    private TablePage tablePage;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        tablePage.updatePage();
    }
}
