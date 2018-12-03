package cn.lytmac.spring.test.ioc;


import javax.annotation.PostConstruct;
import javax.annotation.Resource;

public class FromBean {

    @Resource
    private LazyInitBean lazyInitBean;

    @PostConstruct
    void init() {

        /**
         * 当非lazy-init的singleton对象依赖lazy-init对象时，还是会lazy-init对象进行对初始化
         */
        System.out.println("the toBean is: " + lazyInitBean);
    }
}
