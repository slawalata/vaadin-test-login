package com.example.application.views.alllogin;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

@PageTitle("AllLogin")
@Route(value = "my-view3", layout = MainLayout.class)
@PermitAll
public class AllLoginView extends Composite<VerticalLayout> {

    public AllLoginView() {
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
    }
}
