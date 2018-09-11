package cn.suius.truck.controller;

import cn.suius.truck.property.GirlProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/hello")
@RestController
public class HelloTruck {

    @Autowired
    private GirlProperty girlProperty;

    /*@RequestMapping(value = {"/{id}/say","/hi"}, method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id){
        return girlProperty.getCupSize()+" : "+girlProperty.getAge()+" : "+id;
    }*/

    //@RequestMapping(value = {"/say","/hi"}, method = RequestMethod.GET)
    @GetMapping(value = "/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "000") Integer id) {
        return girlProperty.getCupSize() + " : " + girlProperty.getAge() + " : " + id;
    }

}
