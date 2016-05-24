package com.free4lab.freemonitor.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: RunTest
 * @Description: TODO
 * @author wenchaoz361
 * @date 2013-3-26 上午9:36:42
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RunTest {

}
