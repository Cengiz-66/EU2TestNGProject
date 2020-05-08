package com.cybertek.tests.day11_file_upload;

import org.testng.annotations.Test;

public class FilePathExample {
        @Test
        public void test(){

            //getting project location/path dynamicly
            String projectPath=System.getProperty("user.dir");
            String relativePath="src/test/resources/testfile.txt";

            System.out.println(projectPath.concat("/"+relativePath));

    }
}
