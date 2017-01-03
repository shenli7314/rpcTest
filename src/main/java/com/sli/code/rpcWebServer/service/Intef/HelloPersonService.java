package com.sli.code.rpcWebServer.service.Intef;

import java.util.List;

/**
 * Created by luxiaoxun on 2016-03-10.
 */
public interface HelloPersonService {
    List<Person> GetTestPerson(String name,int num);
}
