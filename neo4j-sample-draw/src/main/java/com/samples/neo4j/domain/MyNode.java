package com.samples.neo4j.domain;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class MyNode {
  // Below id seem to be required as an identity field.
  private Long id;
  private String name;

  public MyNode(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
