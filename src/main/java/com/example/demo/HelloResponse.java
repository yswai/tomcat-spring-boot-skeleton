package com.example.demo;

public class HelloResponse<T> {

  private Integer total;
  private T data;

  public HelloResponse() {
  }

  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
