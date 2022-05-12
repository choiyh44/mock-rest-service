/**
 * 
 */
package kr.co.ensmart.frameworkdemo.app.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.ensmart.frameworkdemo.app.model.Response;
import kr.co.ensmart.frameworkdemo.app.model.Sample;
import lombok.extern.slf4j.Slf4j;

/**
 * @author choiyh44
 * @version 1.0
 * @since 2021. 11. 23.
 *
 */
@RestController
@RequestMapping("/theHandsome/erp-ifs")
@Slf4j
public class TheHandsomeErpMockController {
    @Autowired
    ObjectMapper objectMapper;
    @PostMapping("")
    public String getAllSampleList(@RequestParam String inData) throws Exception {
        log.debug("inData: " + inData);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("result", "SUCCESS");
        resultMap.put("data", Arrays.asList(
                        new Sample(1L, "name1", "desc1"), 
                        new Sample(2L, "name2", "desc2"), 
                        new Sample(3L, "name3", "desc3")));
//        if (true) {
//            throw new Exception(inData);
//        }
        Response<Map<String,Object>> response = 
                new Response<Map<String,Object>>()
                    .setPayload(resultMap);
        return objectMapper.writeValueAsString(response);
    }
}
