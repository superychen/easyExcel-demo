package com.cqyc.yiitong;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @Description:
 * @Author:
 * @Date:
 */
@SpringBootApplication
@Import(FdfsClientConfig.class)
public class YiTongApplication {
    public static void main(String[] args) {
        SpringApplication.run(YiTongApplication.class);
    }
}
