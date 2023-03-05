package com.example.demo;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
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

  public List<YourTable> getYourTables(int page, int size) throws SQLException {
    QueryRunner run = new QueryRunner(dataSource);
    ResultSetHandler<List<YourTable>> h = new BeanListHandler<>(YourTable.class);
    int sizeValid = size > 0 ? size : 2;
    int pageValid = page > 0 ? page : 1;
    int offset = (pageValid - 1) * sizeValid;
    return run.query(
        "SELECT id, Column1 FROM [dbo].[YourTable] " +
        "ORDER BY id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;",
        h, offset, sizeValid);
  }

}
