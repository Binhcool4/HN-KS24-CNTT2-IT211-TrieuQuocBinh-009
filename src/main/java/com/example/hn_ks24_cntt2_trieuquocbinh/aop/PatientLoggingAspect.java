package com.example.hn_ks24_cntt2_trieuquocbinh.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PatientLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(PatientLoggingAspect.class);

    @Pointcut("execution(* com.example.hn_ks24_cntt2_trieuquocbinh.service.PatientService.create*(..))" +
            " || execution(* com.example.hn_ks24_cntt2_trieuquocbinh.service.PatientService.update*(..))" +
            " || execution(* com.example.hn_ks24_cntt2_trieuquocbinh.service.PatientService.patch*(..))")
    public void patientWriteOperations() {
    }

    @Before("patientWriteOperations()")
    public void logBeforeWriteOperation(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info(" AOP LOG: Có luồng dữ liệu chuẩn bị gọi vào hệ thống tại Method: {}()", methodName);
    }
}

