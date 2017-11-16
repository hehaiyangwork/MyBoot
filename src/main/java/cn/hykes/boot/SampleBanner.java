package cn.hykes.boot;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

/**
 * Desc:
 * Mail: hehaiyang@terminus.io
 * Date: 2017/11/8
 */
public class SampleBanner implements Banner {

    /**
     * Print the banner to the specified print stream.
     *
     * @param environment the spring environment
     * @param sourceClass the source class for the application
     * @param out         the output print stream
     */
    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
        out.println("elasticsearch-samples running ...");
    }
}
