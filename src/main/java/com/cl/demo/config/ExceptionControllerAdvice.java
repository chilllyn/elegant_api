package com.cl.demo.config;

import com.cl.demo.annotation.ExceptionCode;
import com.cl.demo.enums.ResultCode;
import com.cl.demo.exception.APIException;
import com.cl.demo.vo.ResultVO;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @author cl
 * @description 全局异常处理
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(APIException.class)
    public ResultVO<String> apiExceptionHandler(APIException e) {
        return new ResultVO<>(ResultCode.FAILED, e.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) throws NoSuchFieldException {
        // 从异常对象中拿到错误信息
        String defaultMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();

        // 参数的Class对象，等下好通过字段名称获取Field对象
        Class<?> parameterType = e.getParameter().getParameterType();
        // 拿到错误的字段名称
        String fieldName = Objects.requireNonNull(e.getBindingResult().getFieldError()).getField();
        Field field = parameterType.getDeclaredField(fieldName);
        // 获取Field对象上的自定义注解
        ExceptionCode annotation = field.getAnnotation(ExceptionCode.class);

        // 有注解的话就返回注解的响应信息
        if (annotation != null) {
            return new ResultVO<>(annotation.value(),annotation.message(),defaultMessage);
        }

        // 没有注解就提取错误提示信息进行返回统一错误码
        return new ResultVO<>(ResultCode.VALIDATE_FAILED, defaultMessage);
    }

}
