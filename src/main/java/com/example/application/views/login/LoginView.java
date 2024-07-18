package com.example.application.views.login;

import com.example.application.security.AuthenticatedUser;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.internal.RouteUtil;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.springframework.security.provisioning.UserDetailsManager;

@AnonymousAllowed
@PageTitle("Login")
@Route(value = "login", layout = MainLayout.class)
public class LoginView extends Composite<VerticalLayout> implements BeforeEnterObserver {

    private final LoginForm loginForm;
    private final UserDetailsManager userDetailsManager;

    public LoginView(UserDetailsManager userDetailsManager) {
        this.userDetailsManager = userDetailsManager;
        loginForm = new LoginForm();

        addClassName("login-view");
        getContent().setSizeFull();
        getContent().setAlignItems((FlexComponent.Alignment.CENTER));
        getContent().setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        loginForm.setAction("login");

        getContent().add(new H1("Vaadin CRM"), loginForm);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        // inform the user about an authentication error
        if (beforeEnterEvent.getLocation().getQueryParameters().getParameters().containsKey("error")) {
            loginForm.setError(true);
        }
    }
}
