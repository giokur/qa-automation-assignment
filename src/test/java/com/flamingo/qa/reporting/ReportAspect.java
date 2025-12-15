package com.flamingo.qa.reporting;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Step;
import io.qameta.allure.model.Parameter;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.List;
import java.util.UUID;

import static io.qameta.allure.util.AspectUtils.getName;
import static io.qameta.allure.util.AspectUtils.getParameters;
import static io.qameta.allure.util.ResultsUtils.getStatus;
import static io.qameta.allure.util.ResultsUtils.getStatusDetails;

@Aspect
public class ReportAspect {
    private static final InheritableThreadLocal<AllureLifecycle> LIFECYCLE
            = new InheritableThreadLocal<AllureLifecycle>() {
        @Override
        protected AllureLifecycle initialValue() {
            return Allure.getLifecycle();
        }
    };

    @Pointcut("execution(* com.flamingo.qa.reporting.Reportable+.*(..))")
    public void anyMethod() {
        //pointcut body, should be empty
    }

    @Before("anyMethod()")
    public void stepStart(final JoinPoint joinPoint) {
        final MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        final Step step = methodSignature.getMethod().getAnnotation(Step.class);

        final String uuid = UUID.randomUUID().toString();
        final String stepTemplate = step == null ? methodSignature.getName() : step.value();
        final String name = getName(stepTemplate, joinPoint);
        final List<Parameter> parameters = getParameters(methodSignature, joinPoint.getArgs());

        final StepResult result = new StepResult()
                .setName(name)
                .setParameters(parameters);

        getLifecycle().startStep(uuid, result);
    }

    @AfterThrowing(pointcut = "anyMethod()", throwing = "e")
    public void stepFailed(final Throwable e) {
        getLifecycle().updateStep(s -> s
                .setStatus(getStatus(e).orElse(Status.BROKEN))
                .setStatusDetails(getStatusDetails(e).orElse(null)));
        getLifecycle().stopStep();
    }

    @AfterReturning(pointcut = "anyMethod()")
    public void stepStop() {
        getLifecycle().updateStep(s -> s.setStatus(Status.PASSED));
        getLifecycle().stopStep();
    }

    public static AllureLifecycle getLifecycle() {
        return LIFECYCLE.get();
    }
}