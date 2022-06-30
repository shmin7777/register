package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Register;
import com.example.demo.repository.RegisterRepository;

import kr.co.openlabs.mtf.client.aop.GlobalTransaction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegisterService {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
    private final RegisterRepository registerRepository;
    
    @Transactional
    @GlobalTransaction(tag = "member 등록")
    public void regist(String code) {
        
        log.info("등록전~~");
        Register register = Register.builder()
                .code(code)
                .date(sdf.format(System.currentTimeMillis()))
                .build();
        registerRepository.save(register);
        List<Register> registList = registerRepository.findAllByCode(code);
        registList.stream().forEach(r->{
//            log.info(r.getCode()+"번이 "+r.getDate()+" 에생성 되었습니다.");
        });
        
        List<Register> list = registerRepository.findAll();
        list.forEach(l->{
//            log.info("id:: "+l.getId()+ " code:: "+l.getCode()+" date:: "+l.getDate());
        });
        
        registerRepository.save(register);
        List<Register> r2 = registerRepository.findAllByCode(code);
        r2.stream().forEach(r->{
//            log.info(r.getCode()+"번이 "+r.getDate()+" 에생성 되었습니다.");
        });
        registerRepository.save(register);
        List<Register> r3 = registerRepository.findAllByCode(code);
        r3.stream().forEach(r->{
//            log.info(r.getCode()+"번이 "+r.getDate()+" 에생성 되었습니다.");
        });
        
        List<Register> list2 = registerRepository.findAll();
        list2.forEach(l->{
//            log.info("id:: "+l.getId()+ " code:: "+l.getCode()+" date:: "+l.getDate());
        });
        
        log.info("등록후~~");
    }
}
