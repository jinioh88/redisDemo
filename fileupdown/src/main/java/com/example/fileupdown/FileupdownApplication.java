package com.example.fileupdown;

import com.example.fileupdown.controller.filestorage.FileStoreage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class FileupdownApplication implements CommandLineRunner {

    @Resource
    FileStoreage fileStorage;

    public static void main(String[] args) throws Exception {

        SpringApplication.run(FileupdownApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        fileStorage.deleteAll();
        fileStorage.init();
    }
}
