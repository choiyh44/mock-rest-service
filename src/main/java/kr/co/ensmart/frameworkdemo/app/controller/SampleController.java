package kr.co.ensmart.frameworkdemo.app.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ensmart.frameworkdemo.app.model.Response;
import kr.co.ensmart.frameworkdemo.app.model.Sample;
import kr.co.ensmart.frameworkdemo.app.model.SampleArrayRequest;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/samples")
@Slf4j
public class SampleController {

	@GetMapping("")
	public List<Sample> getAllSampleList() {
		return Arrays.asList(
				new Sample(1L, "name1", "desc1"), 
				new Sample(2L, "name2", "desc2"), 
				new Sample(3L, "name3", "desc3"));
	}

	@GetMapping("/{id}")
	public Sample getAllSampleList(@PathVariable Long id, 
			@RequestHeader(value="test-header-key1", required = false) String testHeader1) {
		log.info("id: {}, testHeader1: {}", id, testHeader1);
		return new Sample(1L, "name1", "desc1");
	}

	@GetMapping("/search")
	public List<Sample> getAllSampleList(Sample sampleParam) {
		log.info("sampleParam: {}", sampleParam);
		return Arrays.asList(
				new Sample(2L, "name2", "desc2"), 
				new Sample(4L, "name4", "desc4")); 
	}

    @PostMapping("/search")
    public List<Sample> getAllSampleListByPost(@RequestBody Sample sampleParam) {
        log.info("sampleParam: {}", sampleParam);
        return Arrays.asList(
                new Sample(2L, "name2", "desc2"), 
                new Sample(4L, "name4", "desc4")); 
    }

	@PostMapping("")
	public ResponseEntity<Map<String, String>> registerSample(@RequestBody Sample sampleParam) throws InterruptedException {
		log.info("sampleParam: {}", sampleParam);
				
		return new ResponseEntity<Map<String, String>>(new HashMap<String, String>() {{put("result","success");}}, HttpStatus.OK); 
	}

	@PutMapping("/{id}")
	public ResponseEntity<Map<String, String>> saveSample(@PathVariable Long id, @RequestBody Sample sampleParam) {
		log.info("id: {}, sampleParam: {}", id, sampleParam);
				
		return new ResponseEntity<Map<String, String>>(new HashMap<String, String>() {{put("result","success");}}, HttpStatus.OK); 
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Map<String, String>> modifySample(@PathVariable Long id, @RequestBody Sample sampleParam) {
		log.info("id: {}, sampleParam: {}", id, sampleParam);
				
		return new ResponseEntity<Map<String, String>>(new HashMap<String, String>() {{put("result","success");}}, HttpStatus.OK); 
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> removeSample(@PathVariable Long id) {
		log.info("id: {}", id);
				
		return new ResponseEntity<Map<String, String>>(new HashMap<String, String>() {{put("result","success");}}, HttpStatus.OK); 
	}

	@PostMapping("/void")
	public void registerVod(@RequestBody Sample sampleParam) throws InterruptedException {
		log.info("sampleParam: {}", sampleParam);
	}

	@GetMapping("/long-running")
	public void longRunning() throws InterruptedException {
		log.info("longRunning start: {}", LocalDateTime.now());
		Thread.sleep(200000);
		log.info("longRunning end: {}", LocalDateTime.now());
	}

	@GetMapping("/array-param")
    public Response<List<Sample>> getArrayParam(HttpServletRequest request, SampleArrayRequest sampleParam) {
        log.info("request.getRequestURI(): {}", request.getRequestURI());
        log.info("request.getRequestURL(): {}", request.getRequestURL());
        log.info("sampleParam: {}", sampleParam);
        return new Response<List<Sample>>().setPayload(Arrays.asList(
                new Sample(2L, "name2", "desc2"), 
                new Sample(4L, "name4", "desc4")));
    }

    @PostMapping("/array-param")
    public Response<List<Sample>> postArrayParam(HttpServletRequest request, @RequestBody @Valid SampleArrayRequest sampleParam) {
        log.info("request.getRequestURI(): {}", request.getRequestURI());
        log.info("request.getRequestURL(): {}", request.getRequestURL());
        log.info("sampleParam: {}", sampleParam);
        return new Response<List<Sample>>().setPayload(Arrays.asList(
                new Sample(2L, "name2", "desc2"), 
                new Sample(4L, "name4", "desc4")));
    }

    @PostMapping("/string")
    public Response<List<Sample>> getArrayParam(@RequestBody String sampleParam) {
        log.info("sampleParam: {}", sampleParam);
        return new Response<List<Sample>>().setPayload(Arrays.asList(
                new Sample(2L, "name2", "desc2"), 
                new Sample(4L, "name4", "desc4")));
    }

}
