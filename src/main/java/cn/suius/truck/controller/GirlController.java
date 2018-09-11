package cn.suius.truck.controller;

import cn.suius.truck.domain.Result;
import cn.suius.truck.repository.GirlRepository;
import cn.suius.truck.service.GirlService;
import cn.suius.truck.domain.Girl;
import cn.suius.truck.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> findAllGirls() {
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girls")
    //public Girl addGirl(@RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age){
    public Result<Girl> addGirl(@Valid Girl girl, BindingResult bindingResult) {
        logger.info("controller中的方法");
        //Girl girl = new Girl();
        if (bindingResult.hasErrors()) {
            //System.out.println(bindingResult.getFieldError().getDefaultMessage());
            //return null;
            //return bindingResult.getFieldError().getDefaultMessage();
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        //return girlRepository.save(girl);
        return ResultUtil.success(girlRepository.save(girl));
    }

    @GetMapping(value = "/girl/{id}")
    public Optional<Girl> getGirl(@PathVariable("id") Integer id) {
        return girlRepository.findById(id);
    }

    @PutMapping(value = "/girl/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    @DeleteMapping(value = "/girl/{id}")
    public void delGirl(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
    }

    @GetMapping(value = "/girl/age/{age}")
    public List<Girl> getAgeGirl(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @GetMapping(value = "/girl/two")
    public void getTwo() {
        girlService.getTwo();
    }

    @GetMapping(value = "/girl/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}
