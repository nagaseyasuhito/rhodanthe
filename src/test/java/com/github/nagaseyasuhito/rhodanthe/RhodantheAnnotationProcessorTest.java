package com.github.nagaseyasuhito.rhodanthe;

import java.io.IOException;
import java.nio.charset.Charset;

import org.seasar.aptina.unit.AptinaTestCase;

import com.github.nagaseyasuhito.spiraea.Spiraea;

public class RhodantheAnnotationProcessorTest extends AptinaTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.addSourcePath("src/test/java");
        this.setCharset(Charset.forName("utf-8"));
    }

    public void test() throws IOException {
        this.addProcessor(new RhodantheAnnotationProcessor());

        this.addCompilationUnit(Spiraea.class);

        this.compile();
    }
}
