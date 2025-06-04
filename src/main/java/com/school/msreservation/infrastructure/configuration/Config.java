package com.school.msreservation.infrastructure.configuration;

import com.school.msreservation.application.portIn.ReservationPortInImpl;
import com.escola.msreserva.application.portOut.*;
import com.escola.msreserva.infrastructure.adapter.adapterOut.*;
import com.school.msreservation.application.portOut.*;
import com.school.msreservation.infrastructure.adapter.adapterOut.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class Config {

    @Bean
    public ReservationPortInImpl reservationPortIn(ReservationPortOut reservationPortOut, ModelMapper modelMapper , UserPortOut userPortOut, CoursePortOut coursePortOut, QuantityCourseMatriculationAdapterOut quantityCourseMatriculationAdapterOut, RegisteredStudentAdapterOut registeredStudentAdapterOut){
        return new ReservationPortInImpl(reservationPortOut, modelMapper, userPortOut, coursePortOut, quantityCourseMatriculationAdapterOut, registeredStudentAdapterOut);
    }

    @Bean
    public ReservationPortOutImpl reservationPortOut(CourseAdapterOut courseAdapterOut, UserAdapterOut userAdapterOut, ModelMapper modelMapper, ReservationAdapterOut reservationAdapterOut){
        return new ReservationPortOutImpl(courseAdapterOut, userAdapterOut, modelMapper, reservationAdapterOut);
    }

    @Bean
    public ReservationAdapterOutImpl reservationAdapterOut(KafkaTemplate kafkaTemplate){
        return new ReservationAdapterOutImpl( kafkaTemplate);
    }

    @Bean
    public UserPortOutImpl userPortOut(UserAdapterOut userAdapterOut) {
        return new UserPortOutImpl(userAdapterOut);

    }

    @Bean
    public CoursePortOutImpl coursePortOut(CourseAdapterOut courseAdapterOut) {
        return new CoursePortOutImpl(courseAdapterOut);
    }

    @Bean
    public  ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
