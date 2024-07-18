package com.example.application.views.frontdesk;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import jakarta.annotation.security.RolesAllowed;

@PageTitle("FrontDesk")
@Route(value = "", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@RolesAllowed("FRONTDESK")
public class FrontDeskView extends Composite<VerticalLayout> {

    public FrontDeskView() {
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        getContent().add(new H1("FRONTDESK"));
    }
}
