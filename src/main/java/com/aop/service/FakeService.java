package com.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FakeService {
  private Logger logger = LoggerFactory.getLogger(FakeService.class);

  private final FakeService2 fakeService2;

  public FakeService(FakeService2 fakeService2) {
    this.fakeService2 = fakeService2;
  }

  public String callDaoSuccess(){
    return fakeService2.callDaoSuccess();
  }

  public String callDaoFailed() {
    logger.info("Test Service callDaoFailed");
    return fakeService2.callDaoThrowException();
  }

  public String callDaoTrackTime(){
    logger.info("Test Service callDaoTrackTime");
    return fakeService2.callMethodTrackTime();
  }

}
