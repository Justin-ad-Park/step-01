package io.cosmos.assign.distribute;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Qualifier   // ★ 이게 포인트
public @interface DistributorStrategy {
    DistributorType value();
}