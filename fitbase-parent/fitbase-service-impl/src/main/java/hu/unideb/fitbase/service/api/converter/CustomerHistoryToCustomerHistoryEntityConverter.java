package hu.unideb.fitbase.service.api.converter;

import hu.unideb.fitbase.persistence.entity.CustomerEntity;
import hu.unideb.fitbase.persistence.entity.CustomerHistoryEntity;
import hu.unideb.fitbase.persistence.entity.GymEntity;
import hu.unideb.fitbase.service.api.domain.Customer;
import hu.unideb.fitbase.service.api.domain.CustomerHistory;
import hu.unideb.fitbase.service.api.domain.Gym;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerHistoryToCustomerHistoryEntityConverter implements Converter<CustomerHistory, CustomerHistoryEntity> {

    @Autowired
    private CustomerToCustomerEntityConverter customerToCustomerEntityConverter;

    @Autowired
    private GymToGymEntityConverter gymToGymEntityConverter;

    @Override
    public CustomerHistoryEntity convert(CustomerHistory customerHistory) {
        return CustomerHistoryEntity.builder()
                .passStartDate(customerHistory.getPassStartDate())
                .passEndDate(customerHistory.getPassEndDate())
                .passBuyDate(customerHistory.getPassBuyDate())
                .status(customerHistory.isStatus())
                .passName(customerHistory.getPassName())
                .passType(customerHistory.getPassType())
                .passPrice(customerHistory.getPassPrice())
                .customerEntity(customerToCustomerEntity(customerHistory.getCustomer()))
                .gymEntity(gymToGymEntity(customerHistory.getGym()))
                .build();
    }

    private CustomerEntity customerToCustomerEntity(Customer source) {
        return customerToCustomerEntityConverter.convert(source);
    }

    private GymEntity gymToGymEntity(Gym source) {
        return gymToGymEntityConverter.convert(source);
    }
}