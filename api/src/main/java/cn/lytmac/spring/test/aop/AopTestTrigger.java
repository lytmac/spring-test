package cn.lytmac.spring.test.aop;

import cn.lytmac.spring.test.aop.target.BaseObject;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

public class AopTestTrigger {

    @Resource
    private BaseObject baseObject;

    @PostConstruct
    public void init() {
        /**
         * 正常返回时，五种advice的顺序：before -> around -> after returning -> after
         * 运行结果如下：
         * before
         * around begin
         * around target: cn.lytmac.spring.test.aop.target.BaseObject@71c9cbf4
         * around signature: void cn.lytmac.spring.test.aop.target.BaseObject.returnNormally()
         * running method returnNormally
         * after returning
         * around end
         * after
         */
        baseObject.returnNormally();

        System.out.println("------------------------------------------");

        /**
         * 抛出异常在目标代码中捕获，五种advice的顺序：before -> around -> after returning -> after
         * 运行结果如下：
         * before
         * around begin
         * around target: cn.lytmac.spring.test.aop.target.BaseObject@5318cd85
         * around signature: void cn.lytmac.spring.test.aop.target.BaseObject.returnNormallyByCatchException()
         * running method returnNormallyByCatchException
         * throwing exception
         * after returning
         * around end
         * after
         */
        baseObject.returnNormallyByCatchException();

        System.out.println("------------------------------------------");

        /**
         * 抛出异常时，五种advice的顺序：before -> around -> after throwing -> after
         * 需要注意的是：around没有执行完成。
         * 运行结果如下：
         * before
         * around begin
         * around target: cn.lytmac.spring.test.aop.target.BaseObject@5318cd85
         * around signature: void cn.lytmac.spring.test.aop.target.BaseObject.returnExceptionally()
         * running method returnExceptionally
         * after throwing
         * after
         */
        baseObject.returnExceptionally();
    }

}
