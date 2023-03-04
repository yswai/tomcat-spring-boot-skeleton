package com.example.demo;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Service
public class HelloService {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private DataSource dataSource;

  public List<YourTable> getYourTables() throws SQLException {
    QueryRunner run = new QueryRunner(dataSource);
    ResultSetHandler<List<YourTable>> h = new BeanListHandler<>(YourTable.class);
    return run.query("SELECT id, Column1 FROM [dbo].[YourTable]", h);
  }

}
