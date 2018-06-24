package com.javabycode.controller;

import com.javabycode.model.FileModel;
import com.javabycode.model.MultiFileModel;
import com.javabycode.validator.MultipleFileValidator;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class MultiFileUploadController {

    @Autowired
    private MultipleFileValidator multipleFileValidator;

    @ModelAttribute
    public MultiFileModel multiFileModel(){
        return new MultiFileModel(1);
    }

    @InitBinder
    protected void initBinderFileModel(WebDataBinder binder) {
        binder.setValidator(multipleFileValidator);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){
    	
    	model.addAttribute("multiFileModel", new MultiFileModel(1));

    	return "index";
    }

    
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public String handleFormUpload(@Valid MultiFileModel models,
                                   BindingResult result,
                                   RedirectAttributes redirectMap) throws IOException {
    	

        if (result.hasErrors()){
            return "index";
        }

        String[] files = new String[models.getFiles().size()];
        int index = 0;
        for (FileModel model : models.getFiles()){
            MultipartFile file = model.getFile();
            InputStream in = file.getInputStream();
            File destination = new File("/Users/fhdone/Downloads/" + file.getOriginalFilename());
            FileUtils.copyInputStreamToFile(in, destination);

            files[index] = file.getOriginalFilename();
            index++;
        }

        redirectMap.addFlashAttribute("filenames", files);

        return "redirect:success";
    }

}
