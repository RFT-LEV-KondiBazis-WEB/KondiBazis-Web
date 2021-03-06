package hu.unideb.fitbase.persistence.entity;

import hu.unideb.fitbase.commons.pojo.enumeration.Gender;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static hu.unideb.fitbase.commons.pojo.table.ColumnName.CustomerColumName.*;
import static hu.unideb.fitbase.commons.pojo.table.TableName.TABLE_NAME_CUSTOMER;
import static javax.persistence.CascadeType.ALL;

/**
 * CustomerEntity which represents the customer.
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = TABLE_NAME_CUSTOMER)

public class CustomerEntity extends BaseEntity<Long> {

    private static final long serialVersionUID = 3061510290085889333L;

    /**
     * The email of the customer.
     */
    @Column(name = COLUMN_NAME_EMAIL)
    private String email;

    /**
     * First name of the customer.
     */
    @Column(name = COLUMN_NAME_FIRST_NAME)
    private String firstName;

    /**
     * Last name of the customer.
     */
    @Column(name = COLUMN_NAME_LAST_NAME)
    private String lastName;

    /**
     * Phone number of the customer.
     */
    @Column(name = COLUMN_NAME_PHONE_NUMBER)
    private String phoneNumber;

    /**
     * Birthday date of the customer.
     */
    @Column(name = COLUMN_NAME_BIRTHDAY_DATE)
    private Date birthdayDate;

    /**
     * Gender of the customer.
     */
    @Column(name = COLUMN_NAME_GENDER)
    private Gender gender;

    @OneToMany(cascade=ALL, mappedBy="customerEntity")
    private List<CustomerHistoryEntity> customerHistoryEntities;

    /**
     * Builder pattern for creating customer.
     */
    @Builder
    public CustomerEntity(Long id, String email, String firstName, String lastName, String phoneNumber,
                          Date birthdayDate, Gender gender) {
        super(id);
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthdayDate = birthdayDate;
        this.gender = gender;
    }
}
