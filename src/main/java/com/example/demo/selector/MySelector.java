package com.example.demo.selector;

import com.example.demo.services.SystemService;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑返回要导入的类的全类名
//AnnotationMetadata：当前标注@Import注解的类的所有注解信息（PageHelper类标注了@import，就可以拿到它头上标注的所有注解）
public class MySelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        //可以返回空数组，但是不能返回null，否则会报空指针异常
        return new String[]{};
    }
}
