package com.aop.service;

import com.aop.aspect.TrackTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FakeService2 {
  private final Logger logger    = LoggerFactory.getLogger(FakeService2.class);

  public String callDaoSuccess(){
    logger.info("callDaoSuccess is called");
    return "dao1";
  }
  public String callDaoThrowException() {
    logger.info("DAO is called");
    throw new RuntimeException("nice");
  }

  @TrackTime
  public String callMethodTrackTime(){
    logger.info("callDaoSuccess is called");
    return "dao1";
  }
}
