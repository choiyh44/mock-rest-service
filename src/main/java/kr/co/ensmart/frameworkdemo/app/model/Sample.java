package kr.co.ensmart.frameworkdemo.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Sample {
	Long id;
	String name;
	String description;
}
