package com.samples.neo4j.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.helpers.collection.IteratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.samples.neo4j.context.PersistenceContext;
import com.samples.neo4j.domain.MyNode;
import com.samples.neo4j.repository.MyNodeRepository;

@ContextConfiguration(classes = { PersistenceContext.class })
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)

public class ServiceTest {
  @Autowired
  MyNodeRepository nodeRepository;

  @Test
  public void test() {
    System.out.println("Starting test!");
    MyNode n = new MyNode("test");
    nodeRepository.save(n);

    MyNode node = IteratorUtil.firstOrNull(nodeRepository.findByName("test"));
    // MyNode node = IteratorUtil.firstOrNull(nodeRepository.findAll());
    assertNotNull(node);
    // assertEquals(ingredient.getName(), emmental.getName());
    // assertEquals(category, emmental.getCategory());
  }

}
