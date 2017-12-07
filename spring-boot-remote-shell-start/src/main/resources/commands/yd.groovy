package crash.commands

import org.crsh.cli.Command
import org.crsh.cli.Option
import org.crsh.cli.Usage
import org.springframework.beans.factory.support.DefaultListableBeanFactory

class yd {
    @Usage("get bean from context")
    @Command
    Object get(@Option(names = ["n", "beanName"]) String beanName) {
        def attrs = (DefaultListableBeanFactory) context.attributes["spring.beanfactory"];
        if (beanName != null && !"".equals(beanName.trim())) {
            return attrs.getBean(beanName)
        }
        return null;
    }
}