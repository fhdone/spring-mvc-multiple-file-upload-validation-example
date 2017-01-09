package com.javabycode.model;

import java.util.ArrayList;
import java.util.List;

public class MultiFileModel {

    List<FileModel> files = new ArrayList<FileModel>();

    public MultiFileModel(int count){
        for (int i = 0; i < count; i++){
            files.add(new FileModel());
        }
    }

    public List<FileModel> getFiles() {
        return files;
    }

    public void setFiles(List<FileModel> files) {
        this.files = files;
    }
}