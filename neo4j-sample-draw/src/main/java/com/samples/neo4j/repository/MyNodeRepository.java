package com.samples.neo4j.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import com.samples.neo4j.domain.MyNode;

@Repository
public interface MyNodeRepository extends GraphRepository<MyNode> {

  List<MyNode> findByName(String name);

  /*
   * List<Ingredient> findByName(String name);
   *
   * @Query(
   * "match p=(ingredient:Ingredient {name:{0}})-[pairsWith:PAIRS_WITH*0..3]-(otherIngredient)-[r:HAS_CATEGORY]->(cat) return nodes(p) as nodes, rels(p) as rels"
   * ) Iterable<Map<String, Object>> getFlavorPaths(String ingredientName);
   *
   * @Query(
   * "match (ing1:Ingredient {name: {0}})-[r1:PAIRS_WITH]-(ing2)-[r2:PAIRS_WITH]-(ing3)-[r3:PAIRS_WITH]-(ing1) return ing1.name as firstName, ing2.name as secondName,ing3.name as thirdName, ID(r2) as relId"
   * ) Iterable<Map<String, Object>> getTrios(String ingredient);
   */
}
