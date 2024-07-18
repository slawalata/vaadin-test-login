package com.example.application.views.admin;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;

@PageTitle("Admin")
@Route(value = "my-view", layout = MainLayout.class)
@RolesAllowed("ADMIN")
public class AdminView extends Composite<VerticalLayout> {

    public AdminView() {
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
    }
}
