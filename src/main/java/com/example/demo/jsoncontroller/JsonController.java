package com.example.demo.jsoncontroller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

/**
 * @Author: JinWenPeng
 * @Date: 2019/12/2 17:19
 */
@RestController
public class JsonController {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static final Logger log = LoggerFactory.getLogger(JsonController.class);

    class Obj{

        private String dateStr;

        private Long id;

        private String UUID;

        public String getDateStr() {
            return dateStr;
        }

        public void setDateStr(String dateStr) {
            this.dateStr = dateStr;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUUID() {
            return UUID;
        }

        public void setUUID(String UUID) {
            this.UUID = UUID;
        }

        @Override
        public String toString() {
            return "Obj{" +
                    "dateStr='" + dateStr + '\'' +
                    ", id=" + id +
                    ", UUID='" + UUID + '\'' +
                    '}';
        }
    }

    @GetMapping("print")
    public String print(){
        Obj obj = new Obj();
        obj.setId(new Random().nextLong());
        obj.setDateStr(dtf.format(LocalDateTime.now().minusSeconds(new Random().nextInt(1000000))));
        obj.setUUID(RandomStringUtils.randomNumeric(13));
        log.info(JSON.toJSONString(obj));
        return JSON.toJSONString(obj);
    }

    public static void main(String[] args) {
        System.out.println(-1l^(-1L<<5));
        System.out.println(Long.toBinaryString(-1L<<5));
    }
}

