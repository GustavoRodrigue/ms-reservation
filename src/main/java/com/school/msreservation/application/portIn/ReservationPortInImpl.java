package com.school.msreservation.application.portIn;

import com.school.msreservation.application.portOut.CoursePortOut;
import com.school.msreservation.application.portOut.ReservationPortOut;
import com.school.msreservation.application.portOut.UserPortOut;
import com.school.msreservation.domain.Course;
import com.school.msreservation.domain.Reservation;
import com.school.msreservation.domain.User;
import com.school.msreservation.domain.enuns.UserEnum;

import com.school.msreservation.infrastructure.adapter.adapterOut.RegisteredStudentAdapterOut;
import com.school.msreservation.infrastructure.adapter.adapterOut.QuantityCourseMatriculationAdapterOut;
import com.school.msreservation.infrastructure.dto.*;
import org.modelmapper.ModelMapper;


public class ReservationPortInImpl implements ReservationPortIn {
    final ReservationPortOut reservationPortOut;
    private ModelMapper modelMapper;
    final UserPortOut userPortOut;
    final CoursePortOut coursePortOut;
    final QuantityCourseMatriculationAdapterOut quantityCourseMatriculationAdapterOut;
    final RegisteredStudentAdapterOut registeredStudentAdapterOut;



    public ReservationPortInImpl(ReservationPortOut reservationPortOut, ModelMapper modelMapper, UserPortOut userPortOut, CoursePortOut coursePortOut, QuantityCourseMatriculationAdapterOut quantityCourseMatriculationAdapterOut, RegisteredStudentAdapterOut registeredStudentAdapterOut) {
        this.reservationPortOut = reservationPortOut;
        this.modelMapper = modelMapper;
        this.userPortOut = userPortOut;
        this.coursePortOut = coursePortOut;
        this.quantityCourseMatriculationAdapterOut = quantityCourseMatriculationAdapterOut;
        this.registeredStudentAdapterOut = registeredStudentAdapterOut;
    }

    @Override
    public void createReservation(ReservationRequestDto reservationRequestDto) {


        CourseResponseDto courseResponseDto = coursePortOut.listCourseId(reservationRequestDto.getCourseId());
        Course course = modelMapper.map(courseResponseDto, Course.class);

        UserResponseDto studentDto = userPortOut.listUserId(reservationRequestDto.getStudentId());
        User student = modelMapper.map(studentDto, User.class);

        UserResponseDto teacherDto = userPortOut.listUserId(reservationRequestDto.getTeacherId());
        User teacher = modelMapper.map(teacherDto, User.class);

        QuantityCourseMatriculationResponseDto quantityCourseDto = quantityCourseMatriculationAdapterOut.quantityCourse(course.getId());

        RegisteredStudentResponseDto registeredStudentResponseDto = registeredStudentAdapterOut.registeredStudent(student.getId(), course.getId());

        if (student.getType().equals(UserEnum.ALUNO) && teacher.getType().equals(UserEnum.PROFESSOR)){
            if (quantityCourseDto.getQuantityCourse() < course.getCapacity() && !registeredStudentResponseDto.isThereIsStudent()) {
                Reservation reservation = new Reservation();
                reservation.setStudentId(student.getId());
                reservation.setStudentName(student.getName());
                reservation.setCourseId(course.getId());
                reservation.setCourseName(course.getName());
                reservation.setTeacherId(teacher.getId());
                reservation.setTeacherNome(teacher.getName());

                reservationPortOut.createReservation(reservation);
            }

        }

    }

}
