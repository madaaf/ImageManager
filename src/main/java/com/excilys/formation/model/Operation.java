package com.excilys.formation.model;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Operation
 * represents the relational "operations" table
 */
@Entity
@Table(name = "operations")
public class Operation implements Serializable {

  public Operation() {}

  public Operation(Long id, LocalDateTime time, String message) {
    this.id = id;
    this.time = time;
    this.message = message;
  }

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "time")
  @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
  private LocalDateTime time;

  @Column(name = "message")
  private String message;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getTime() {
    return time;
  }

  public void setTime(LocalDateTime time) {
    this.time = time;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Operation operation = (Operation) o;

    if (id != null ? !id.equals(operation.id) : operation.id != null) return false;
    if (message != null ? !message.equals(operation.message) : operation.message != null) return false;
    if (time != null ? !time.equals(operation.time) : operation.time != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (time != null ? time.hashCode() : 0);
    result = 31 * result + (message != null ? message.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Operation{" +
        "id=" + id +
        ", time=" + time +
        ", message='" + message + '\'' +
        '}';
  }

  /**
   * Builder pattern static constructor
   * @return a new Operation.Builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder pattern class
   */
  public static class Builder {
    private Long id;
    private LocalDateTime time;
    private String message;

    private Builder() {
    }

    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Builder time(LocalDateTime time) {
      this.time = time;
      return this;
    }

    public Builder message(String message) {
      this.message = message;
      return this;
    }

    public Operation build() {
      return new Operation(id, time, message);
    }
  }
}
