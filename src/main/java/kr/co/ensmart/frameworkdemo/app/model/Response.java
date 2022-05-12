/**
 * 
 */
package kr.co.ensmart.frameworkdemo.app.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author choiyh44
 * @version 1.0
 * @since 2021. 11. 23.
 *
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Response<T> {
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime timestamp = LocalDateTime.now();
    private String code = "0000";
    private String message = "";
    private T payload;
}
