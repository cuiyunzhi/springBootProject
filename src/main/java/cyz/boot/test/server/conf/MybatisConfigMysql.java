package cyz.boot.test.server.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan(basePackages = "cyz.boot.test.dao", sqlSessionFactoryRef="sqlSessionFactory", sqlSessionTemplateRef="sqlSessionTemplate")
@Configuration
public class MybatisConfigMysql {
}
