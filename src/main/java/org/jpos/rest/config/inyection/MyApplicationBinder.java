package org.jpos.rest.config.inyection;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.jpos.rest.DB.UserRepository;
import org.jpos.rest.DB.UserRepositoryContract;
import org.jpos.rest.controllers.ThalesController;
import org.jpos.rest.controllers.ThalesControllerDelegate;
import org.jpos.rest.services.contracts.EchoService;
import org.jpos.rest.services.contracts.ThalesService;
import org.jpos.rest.services.impl.EchoServiceImpl;
import org.jpos.rest.services.impl.ThalesServiceImpl;

public class MyApplicationBinder extends AbstractBinder {

    @Override
    protected void configure() {

        bind(new EchoServiceImpl()).to(EchoService.class);
        bind(new ThalesServiceImpl()).to(ThalesService.class);
        bind(ThalesController.class).to(ThalesControllerDelegate.class);
        bind(UserRepository.class).to(UserRepositoryContract.class);

    }
}

