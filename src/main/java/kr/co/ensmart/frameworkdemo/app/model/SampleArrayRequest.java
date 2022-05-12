/**
 * 
 */
package kr.co.ensmart.frameworkdemo.app.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author choiyh44
 * @version 1.0
 * @since 2021. 12. 24.
 *
 */
@Getter
@Setter
@ToString
public class SampleArrayRequest {
    private Long id;
    private String name;
    private String description;
    private String[] sampleIds;
    @NotNull(message ="{common.error.emptyParameter}")
    private List<String> sampleIdList;
}
