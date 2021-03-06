package hu.unideb.fitbase.service.api.service;

import hu.unideb.fitbase.commons.pojo.exceptions.BaseException;
import hu.unideb.fitbase.commons.pojo.exceptions.ViolationException;
import hu.unideb.fitbase.commons.pojo.request.ManagerRegistrationRequest;
import hu.unideb.fitbase.commons.pojo.request.RegistrationRequest;
import hu.unideb.fitbase.service.api.domain.User;
import hu.unideb.fitbase.service.api.exception.ServiceException;

public interface RegistrationService {

    /**
     * Register new user by registration request.
     *
     * @param registrationRequest registration request object.
     * @return registered user object.
     */
    User register(RegistrationRequest registrationRequest) throws ViolationException, ServiceException, BaseException;

    User addManager(ManagerRegistrationRequest managerRegistrationRequest) throws ViolationException, ServiceException, BaseException;
}
