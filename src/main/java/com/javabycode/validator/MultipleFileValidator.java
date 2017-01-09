package com.javabycode.validator;

import com.javabycode.model.FileModel;
import com.javabycode.model.MultiFileModel;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MultipleFileValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return MultiFileModel.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MultiFileModel multiModel = (MultiFileModel) target;

        int index = 0;
        for (FileModel model : multiModel.getFiles()){
            if (model.getFile() != null && model.getFile().isEmpty()){
                errors.rejectValue("files[" + index + "].file", "file.empty");
            }
            index++;
        }
    }
}
