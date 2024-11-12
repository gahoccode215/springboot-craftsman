package com.gahoccode.identity_service.mapper;

import org.mapstruct.Mapper;

import com.gahoccode.identity_service.dto.request.PermissionRequest;
import com.gahoccode.identity_service.dto.response.PermissionResponse;
import com.gahoccode.identity_service.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest permissionRequest);

    PermissionResponse toPermissionResponse(Permission permission);
}
