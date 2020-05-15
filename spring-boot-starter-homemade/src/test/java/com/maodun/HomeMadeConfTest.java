package com.maodun;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author maodunWorld
 * @version 1.0
 * @date 2020/5/15 9:51
 */
class HomeMadeConfTest {
    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner();

    @Test
    public void initHomeMadePojo() {
        this.contextRunner.withUserConfiguration(HomeMadeConf.class).withPropertyValues("homemade.name=name", "homemade.code=code").run((context) -> {
            assertThat(context).hasSingleBean(HomeMadePojo.class);
            HomeMadePojo bean = context.getBean(HomeMadePojo.class);
            System.out.println(bean);
            // 输出结果 HomeMadePojo{name='name', code='code'}
        });
    }
}