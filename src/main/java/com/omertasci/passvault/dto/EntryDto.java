package com.omertasci.passvault.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntryDto {
    public Long id;
    public String title;
    public String username;
    public String password;
    public String weblink;
    public String note;
    public Date createDate;
    public Date updateDate;

}
