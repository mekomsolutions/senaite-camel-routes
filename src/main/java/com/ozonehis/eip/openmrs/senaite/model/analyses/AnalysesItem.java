package com.ozonehis.eip.openmrs.senaite.model.analyses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnalysesItem {
    @JsonProperty("Result")
    private String result;

    @JsonProperty("ResultCaptureDate")
    private String resultCaptureDate;

    @JsonProperty("description")
    private String description;
}
