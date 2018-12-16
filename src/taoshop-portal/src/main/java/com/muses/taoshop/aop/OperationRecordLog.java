//package com.muses.taoshop.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//
//
//@Component
//@Aspect
//public class OperationRecordLog {
//
//    @Autowired
//    //private SystemService systemService;
//
//    @Around(value = "execution(* org.springframework.orm.ibatis.SqlMapClientTemplate.delete(..)) or execution(* org.springframework.orm.ibatis.SqlMapClientTemplate.insert(..)) or execution(* org.springframework.orm.ibatis.SqlMapClientTemplate.queryForList(..)) or execution(* org.springframework.orm.ibatis.SqlMapClientTemplate.queryForMap(..)) or execution(* org.springframework.orm.ibatis.SqlMapClientTemplate.queryForObject(..)) or execution(* org.springframework.orm.ibatis.SqlMapClientTemplate.queryWithRowHandler(..)) or execution(* org.springframework.orm.ibatis.SqlMapClientTemplate.update(..))")
//    public Object exec(ProceedingJoinPoint invocation) throws Throwable {
//        Object result = invocation.proceed();
//        Object[] args = invocation.getArgs();
//        if (args.length > 0) {
//            if (!args[0].toString().equals("system.saveSqlOperationRecord")) {
//                try {
//                    if (args.length>1) {
//                        //systemService.saveSqlOperationRecord(args[0].toString(), args[1]);
//                    } else {
//                        //systemService.saveSqlOperationRecord(args[0].toString(), "");
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return result;
//    }
//
//}
