package com.aop.controller;

import com.aop.service.FakeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class api {

  private final FakeService fakeService;

  public api(FakeService fakeService) {
    this.fakeService = fakeService;
  }

  @GetMapping
  public String get(){
    return fakeService.callDaoSuccess();
  }

  @GetMapping("/2")
  public String get2() throws Exception {
    return fakeService.callDaoFailed();
  }
  @GetMapping("/3")
  public String get3(){
    return fakeService.callDaoTrackTime();
  }


}
