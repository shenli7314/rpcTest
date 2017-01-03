package com.sli.code.rpcWebServer.service.Intef;

import java.util.List;

public interface HelloPersonService {
    List<Person> GetTestPerson(String name,int num);
}
