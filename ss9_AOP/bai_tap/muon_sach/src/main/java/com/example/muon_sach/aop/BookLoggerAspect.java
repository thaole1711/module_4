package com.example.muon_sach.aop;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Aspect
@Component
public class BookLoggerAspect {
    private static final Logger logger = LoggerFactory.getLogger(BookLoggerAspect.class);

    private final AtomicInteger visitCounter = new AtomicInteger(0);
    @Autowired
    private HttpServletRequest request;

    @Before("execution(* com.example.muon_sach.controller.BookController.*(..))")
    public void logVisit(JoinPoint joinPoint) {
        int count = visitCounter.incrementAndGet();
        logger.info(" Ghé thăm: {} | Tổng lượt: {}", joinPoint.getSignature().getName(), count);
    }

    @AfterReturning("execution(* com.example.muon_sach.controller.BookController.borrow(..))")
    public void logBorrow(JoinPoint joinPoint) {
        logger.info(" Mượn sách: phương thức {} đã thay đổi trạng thái sách.", joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.example.muon_sach.controller.BookController.returnBook(..))")
    public void logReturn(JoinPoint joinPoint) {
        logger.info(" Trả sách: phương thức {} đã thay đổi trạng thái sách.", joinPoint.getSignature().getName());
    }
}
