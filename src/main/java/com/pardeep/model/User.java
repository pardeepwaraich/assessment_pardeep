package com.pardeep.model;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@AutoProperty
@Document(indexName = "resource", type = "users")
public class User implements Serializable {

  @Id
  private int id;

  private String userName;

  private String email;

  private String password;

  private LocalDateTime localDateTime;

  public User(String userName, String email, String password, LocalDateTime localDateTime) {
    this.userName = userName;
    this.email = email;
    this.password = password;
    this.localDateTime = localDateTime;
  }

  public User() {}

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public LocalDateTime getLocalDateTime() {
    return localDateTime;
  }

  public void setLocalDateTime(LocalDateTime localDateTime) {
    this.localDateTime = localDateTime;
  }

  @Override
  public int hashCode() {
    return Pojomatic.hashCode(this);
  }

  @Override
  public String toString() {
    return Pojomatic.toString(this);
  }

  @Override
  public boolean equals(Object o) {
    return Pojomatic.equals(this, o);
  }
}
