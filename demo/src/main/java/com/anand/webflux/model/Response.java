package com.anand.webflux.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.xml.bind.annotation.XmlType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlType(propOrder = { "serviceName", "status", "message", "data" })
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class Response {
	
	private String serviceName;

	private String status;

	private String message;

	private Object data;

}
