package io.cricket.service;

import io.cricket.domain.Cricket;

import java.util.List;

public interface CricketService {

    Cricket findOne(Integer id);

    List<Cricket> findAll();

    Cricket create(Cricket cricket);

    Cricket update(Integer id, Cricket cricket);

    void delete(Integer id);
}
