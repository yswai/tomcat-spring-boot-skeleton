package com.example.demo;

public class YourTable {

  private Integer id;
  private String Column1;

  public YourTable() {
  }

  public YourTable(Integer id, String column1) {
    this.id = id;
    Column1 = column1;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getColumn1() {
    return Column1;
  }

  public void setColumn1(String column1) {
    Column1 = column1;
  }
}
