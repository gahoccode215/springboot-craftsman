package com.gahoccode.identity_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.gahoccode.identity_service.dto.request.APIResponse;
import com.gahoccode.identity_service.dto.request.RoleRequest;
import com.gahoccode.identity_service.dto.response.RoleResponse;
import com.gahoccode.identity_service.service.PermissionService;
import com.gahoccode.identity_service.service.RoleService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleController {
    RoleService roleService;
    private final PermissionService permissionService;

    @PostMapping
    APIResponse<RoleResponse> create(@RequestBody RoleRequest request) {
        return APIResponse.<RoleResponse>builder()
                .result(roleService.create(request))
                .build();
    }

    @GetMapping
    APIResponse<List<RoleResponse>> getAll() {
        return APIResponse.<List<RoleResponse>>builder()
                .result(roleService.getAll())
                .build();
    }

    @DeleteMapping("/{role}")
    APIResponse<Void> delete(@PathVariable("role") String role) {
        roleService.delete(role);
        return APIResponse.<Void>builder().build();
    }
}
