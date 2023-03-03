package com.test.backend.Dto.Job;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobDto {
    private String id;
    private String type;
    private String url;
    @JsonProperty("created_at")
    private String createdAt;
    private String company;
    @JsonProperty("company_url")
    private String companyUrl;
    private String location;
    private String title;
    private String description;
    @JsonProperty("how_to_apply")
    private String howToApply;
    @JsonProperty("company_logo")
    private String companyLogo;
}
