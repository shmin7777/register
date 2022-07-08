package com.example.demo.service;

import java.text.SimpleDateFormat;

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
        registerRepository.save(register);
        registerRepository.save(register);
        
        log.info("등록후~~");
    }
}
