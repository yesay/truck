package cn.suius.truck.service;

import cn.suius.truck.domain.Girl;
import cn.suius.truck.enums.ResultEnum;
import cn.suius.truck.exception.GirlException;
import cn.suius.truck.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void getTwo() {
        Girl girl = new Girl();
        girl.setCupSize("D");
        girl.setAge(13);
        girlRepository.save(girl);

        Girl girl1 = new Girl();
        girl.setCupSize("FFFF");
        girl.setAge(16);
        girlRepository.save(girl1);
    }

    public void getAge(Integer id) throws Exception {
        Optional<Girl> girlOptional = girlRepository.findById(id);
        Girl girl = girlOptional.get();
        Integer age = girl.getAge();
        if (age < 10)
            throw new GirlException(ResultEnum.JUNIOR_SCHOOL);
        else if (age > 10 && age < 16)
            throw new GirlException(ResultEnum.HIGH_SCHOOL);
    }

    public Optional<Girl> findOne(Integer id) {
        return girlRepository.findById(id);
    }
}
