package org.woodwhales.music.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * 枚举校验器注解
 * @author woodwhales
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = EnumConstraintValidator.class)
public @interface EnumValidator {

    /**
     * 目标枚举类类型
     * @return
     */
	Class<?>[] target() default {};

    /**
     * 校验失败的默认异常信息
     * @return
     */
    String message() default "入参值不在正确枚举中";

    /**
     * 参数值中的数值与target目标枚举的method方法返回值是否一致，如果一致则校验成功，否则校验失败。
     * @return
     */
    String method() default "getCode";
    
    // 以下两行为固定模板
    Class<?>[] groups() default {};
    
    Class<? extends Payload>[] payload() default {};
    
}