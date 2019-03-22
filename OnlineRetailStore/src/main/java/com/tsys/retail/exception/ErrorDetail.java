package com.tsys.retail.exception;

public class ErrorDetail {

  private String detail;

  private String msg;
  private int status;
  private String title;

  public ErrorDetail() {
    super();

  }

  public String getDetail() {
    return detail;
  }

  public String getDeveloperMessage() {
    return msg;
  }


  public int getStatus() {
    return status;
  }


  public String getTitle() {
    return title;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public void setDeveloperMessage(String developerMessage) {
    this.msg = developerMessage;
  }


  public void setStatus(int status) {
    this.status = status;
  }


  public void setTitle(String title) {
    this.title = title;
  }

}
