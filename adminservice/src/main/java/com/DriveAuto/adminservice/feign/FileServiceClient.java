package com.DriveAuto.adminservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "fileService")
public interface FileServiceClient {
}
