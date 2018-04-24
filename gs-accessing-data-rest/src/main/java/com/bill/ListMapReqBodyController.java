package com.bill;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ListMapReqBodyController {
    //curl -H "Content-Type: application/json" -X POST -d '["xxx", "sss"]' http://localhost:8080/test/list/1212
    @RequestMapping(value = "/test/list/{siteId}", method = RequestMethod.POST)
    public List<String> ping(@PathVariable int siteId, @RequestBody List<String> tags) {
        System.out.println(String.format("%d, %s", siteId, tags));
        return tags;
    }
    //curl -H "Content-Type: application/json" -X POST -d '{"sss":"sdsd", "xxx":"1"}' http://localhost:8080/test/map
    @PostMapping("/test/map")
    public String pingMap(@RequestBody Map<String, String> tags){
        System.out.println(String.format("%s", tags));
        return tags.toString();
    }
}
