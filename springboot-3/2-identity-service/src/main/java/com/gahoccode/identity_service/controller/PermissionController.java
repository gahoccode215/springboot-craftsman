package com.gahoccode.identity_service.controller;

import com.gahoccode.identity_service.dto.request.APIResponse;
import com.gahoccode.identity_service.dto.request.PermissionRequest;
import com.gahoccode.identity_service.dto.response.PermissionResponse;
import com.gahoccode.identity_service.service.PermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PermissionController {
    PermissionService permissionService;

    @PostMapping
    APIResponse<PermissionResponse> create(@RequestBody PermissionRequest request){
        return APIResponse.<PermissionResponse>builder()
                .result(permissionService.create(request))
                .build();
    }
    @GetMapping
    APIResponse<List<PermissionResponse>> getAll(){
        return APIResponse.<List<PermissionResponse>>builder()
                .result(permissionService.getAll())
                .build();
    }
    @DeleteMapping("/{permission}")
    APIResponse<Void> delete(@PathVariable("permission") String permission){
        permissionService.delete(permission);
        return APIResponse.<Void>builder().build();
    }
}
