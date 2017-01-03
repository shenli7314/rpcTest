package com.sli.code.rpcWebServer.service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.sli.code.rpc.Components.provider.RpcService;
import com.sli.code.rpcWebServer.service.Intef.HelloPersonService;
import com.sli.code.rpcWebServer.service.Intef.Person;


@RpcService(HelloPersonService.class)
public class HelloPersonServiceImpl implements HelloPersonService {

    @Override
    public List<Person> GetTestPerson(String name, int num) {
        List<Person> persons = new ArrayList<>(num);
        for (int i = 0; i < num; ++i) {
            persons.add(new Person(Integer.toString(i), name));
        }
        return persons;
    }
}
