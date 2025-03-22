package com.shukldi.spring_secuirty.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN_READ')")
    public String get() {
        return "GET:: admin controller";
    }

    @PreAuthorize("hasAuthority('ADMIN_CREATE')")
    @PostMapping
    public String post() {
        return "POST:: admin controller";
    }

    @PreAuthorize("hasAuthority('ADMIN_UPDATE')")
    @PutMapping
    public String put() {
        return "PUT:: admin controller";
    }

    @PreAuthorize("hasAuthority('ADMIN_DELETE')")
    @DeleteMapping
    public String delete() {
        return "DELETE:: admin controller";
    }
}