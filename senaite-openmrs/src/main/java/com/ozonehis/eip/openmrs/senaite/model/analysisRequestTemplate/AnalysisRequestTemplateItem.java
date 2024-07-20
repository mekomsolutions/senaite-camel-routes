/*
 * Copyright © 2021, Ozone HIS <info@ozone-his.com>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.ozonehis.eip.openmrs.senaite.model.analysisRequestTemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnalysisRequestTemplateItem {

    @JsonProperty("uid")
    private String uid;

    @JsonProperty("path")
    private String path;

    @JsonProperty("AnalysisProfile")
    private AnalysisProfile analysisProfile;

    @JsonProperty("Analyses")
    private Analyses[] analyses;

    @JsonProperty("SampleType")
    private SampleType sampleType;
}
