package io.cricket.service;

import io.cricket.domain.Cricket;
import io.cricket.exception.CricketNotFoundException;
import io.cricket.repository.CricketRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CricketServiceImpl implements CricketService {

    private CricketRepository cricketRepository;

    @Autowired
    public CricketServiceImpl(CricketRepository cricketRepository) {
        this.cricketRepository = cricketRepository;
    }

    @Override
    public Cricket findOne(Integer id) {
        return cricketRepository.findById(id).orElseThrow(CricketNotFoundException::new);
    }

    @Override
    public List<Cricket> findAll() {
        return cricketRepository.findAll();
    }

    @Override
    public Cricket create(Cricket cricket) {
        return cricketRepository.saveAndFlush(cricket);
    }

    @Override
    public Cricket update(Integer id, Cricket cricket) {
        Cricket oldCricket = findOne(id);
        BeanUtils.copyProperties(cricket, oldCricket, "id");
        return cricketRepository.saveAndFlush(cricket);
    }

    @Override
    public void delete(Integer id) {
        cricketRepository.deleteById(id);
    }


}
