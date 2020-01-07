package cn.menghan.reflection.aspect;

import cn.menghan.reflection.annotation.OauthOrg;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author by liu.hongda
 * @date 2020/1/7 11:04
 */
@Component
@Aspect
public class OauthOrgAspect {

    /**
     * execution后指定反射的位置
     * 这里规定了所有包及其子包底下的所有方法
     */
    @Pointcut("execution(public * cn.menghan.reflection..*(..))")
    public void oauthOrg() {

    }

    /**
     * oauthOrg()为范围，@annotation()为用了注解的方法
     * @param jp
     * @param oo
     * @return
     */
    @Before("oauthOrg() && @annotation(oo)")
    public Object demoBefore(JoinPoint jp, OauthOrg oo) {

        return "";
    }

    /**
     * oauthOrg()为范围，@annotation()为用了注解的方法
     * around方法在于可操作参数,可用return proceed返回自己想用的参数
     * @param pjp
     * @param oo
     * @return
     * @throws Throwable
     */
    @Around("oauthOrg() && @annotation(oo)")
    public Object demoAround(ProceedingJoinPoint pjp, OauthOrg oo) throws Throwable {
        Object[] args = pjp.getArgs();
        String orgName = (String) args[0];

        if (orgName.equals(oo.orgName())) {
            return pjp.proceed();
        }
        args[0] = oo.orgName();
        return pjp.proceed(args);
    }
}
