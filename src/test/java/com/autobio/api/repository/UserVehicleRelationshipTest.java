package com.autobio.api.repository;

import com.autobio.api.model.User;
import com.autobio.api.model.Vehicle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class UserVehicleRelationshipTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @Test
    void vehicleCanBeLinkedToUser() {
        User testUser = new User();
        testUser.setUsername("testUser");
        testUser.setEmail("testuser@example.com");
        testUser.setPassword("somepassword");
        User savedUser = userRepository.save(testUser);


        Vehicle testVehicle = new Vehicle();
        testVehicle.setMake("Ford");
        testVehicle.setModel("Mustang");
        testVehicle.setYear(2018);
        testVehicle.setColor("Blue");
        testVehicle.setMileage(30000);
        testVehicle.setUser(savedUser);

        Vehicle savedVehicle = vehicleRepository.save(testVehicle);

        List<Vehicle> result = vehicleRepository.findByUserId(savedUser.getId());
        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getId()).isEqualTo(savedVehicle.getId());

    }


}
