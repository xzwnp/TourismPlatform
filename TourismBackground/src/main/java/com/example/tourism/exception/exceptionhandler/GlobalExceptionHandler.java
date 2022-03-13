package com.example.tourism.exception.exceptionhandler;

import com.example.tourism.utils.ExceptionUtil;
import com.example.tourism.utils.R;
import com.example.tourism.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * com.example.commonutils.exceptionhandler
 *
 * @author xzwnp
 * 2022/1/27
 * 14:14
 * Steps：
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    //加上这个注解表示用于处理exception异常类
    @ExceptionHandler(Exception.class)
    @ResponseBody //指定返回json数据
    public R error(Exception e) {
        log.error(ExceptionUtil.getMessage(e));
        return R.error().message("服务器异常!");
    }

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public R error(MyException e) {
        log.error(ExceptionUtil.getMessage(e));
        return R.error().code(e.getCode()).message(e.getMsg());
    }
}
