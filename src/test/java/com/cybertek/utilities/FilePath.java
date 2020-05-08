package com.cybertek.utilities;


public class FilePath {

    //getting project location/path dynamical
    public static String uploadFileWithPath (String relativePath) {
        String projectPath=System.getProperty("user.dir");
        String filePath=projectPath+"/"+relativePath;
        return filePath;
    }
}