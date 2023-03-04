package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class HelloController {

  private static Logger LOGGER = LoggerFactory.getLogger("HelloController");

  @Autowired
  private HelloService helloService;

  @GetMapping("/")
  public ResponseEntity hello() {
    LOGGER.info("hello method called!");
    return ResponseEntity.status(HttpStatus.OK).body("Hii");
  }

  @GetMapping("/yourtable")
  public ResponseEntity yourtables() throws SQLException {
    LOGGER.info("yourtables method called!");
    return ResponseEntity.status(HttpStatus.OK).body(helloService.getYourTables());
  }

}
